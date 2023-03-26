package net.bungie.api.destiny;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.plexus.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.MalformedJsonException;

import net.bungie.api.BungieMembershipType;
import net.bungie.api.CoreSettingsConfiguration;
import net.bungie.api.destiny.config.DestinyManifest;
import net.bungie.api.destiny.historicalstats.DestinyActivityHistoryResults;
import net.bungie.api.destiny.historicalstats.DestinyPostGameCarnageReportData;
import net.bungie.api.destiny.historicalstats.definitions.DestinyActivityModeType;
import net.bungie.api.destiny.milestones.DestinyPublicMilestone;
import net.bungie.api.destiny.responses.DestinyCharacterResponse;
import net.bungie.api.destiny.responses.DestinyProfileResponse;
import net.bungie.api.trending.TrendingCategories;
import net.bungie.api.trending.TrendingDetail;
import net.bungie.api.trending.TrendingEntryType;
import net.bungie.api.user.ExactSearchRequest;
import net.bungie.api.user.GeneralUser;
import net.bungie.api.user.UserInfoCard;
import net.bungie.api.user.UserMembershipData;

public final class DestinyAPI
{
	public static String API_URL = "https://www.bungie.net/Platform";
	public static String STATS_API_URL = "https://stats.bungie.net/Platform";
	
	private HttpClient client = HttpClients.createDefault();
	private HttpClientContext context = HttpClientContext.create();
	private Gson gson = new Gson();
	
	private String api_key;
	private String client_id;
	private String client_secret;
	
	private DestinyAPICallback callback;
	
	public DestinyAPI(String apiKey)
	{
		this.api_key = apiKey;
	}
	
	public DestinyAPI(String apiKey, String client_id, String client_secret)
	{
		this.api_key = apiKey;
		this.client_id = client_id;
		this.client_secret = client_secret;
	}
	
	public Map<Long, DestinyPublicMilestone> GetPublicMilestones() throws APIErrorException
	{
		return get("/Destiny2/Milestones/", new TypeToken<Map<Long, DestinyPublicMilestone>>(){}.getType());
	}
	
	public TrendingCategories GetTrendingCategories() throws APIErrorException
	{
		return get("/Trending/Categories/", TrendingCategories.class);
	}
	
	public TrendingDetail GetTrendingEntryDetail(TrendingEntryType trendingEntryType, int identifier) throws APIErrorException
	{
		return get("/Trending/Details/" + trendingEntryType.ordinal() + "/" + identifier + "/", TrendingDetail.class);
	}
	
	public CoreSettingsConfiguration GetCommonSettings() throws APIErrorException
	{
		return get("/Settings/", CoreSettingsConfiguration.class);
	}
	
	public GeneralUser GetCurrentBungieNetUser(APIUser user) throws APIErrorException
	{
		return get_authorized("/User/GetCurrentBungieNetUser/", GeneralUser.class, user);
	}
	
	public DestinyManifest getDestinyManifest() throws APIErrorException
	{
		return get("/Destiny2/Manifest/", DestinyManifest.class);
	}
	
	public DestinyActivityHistoryResults GetActivityHistory(BungieMembershipType membershipType, long destinyMembershipId, long characterId, int count, DestinyActivityModeType mode, int page) throws APIErrorException
	{
		return get(STATS_API_URL, "/Destiny2/" + membershipType + "/Account/" + destinyMembershipId + "/Character/" + characterId + "/Stats/Activities/", DestinyActivityHistoryResults.class, 
				new BasicNameValuePair("count", String.valueOf(count)), new BasicNameValuePair("mode", String.valueOf(mode.ordinal())), new BasicNameValuePair("page", String.valueOf(page)));
	}
	
	public DestinyPostGameCarnageReportData GetPostGameCarnageReport(long activityId) throws APIErrorException
	{
		return get(STATS_API_URL, "/Destiny2/Stats/PostGameCarnageReport/" + activityId + "/", DestinyPostGameCarnageReportData.class);
	}
	
	public DestinyCharacterResponse GetCharacter(BungieMembershipType membershipType, long destinyMembershipId, long characterId, DestinyComponentType... components) throws APIErrorException
	{
		String componentsString = "" + components[0].getId();
		
		for(int i = 1; i < components.length; i++)
		{
			componentsString += "," + components[i].getId();
		}
		
		return get("/Destiny2/" + membershipType + "/Profile/" + destinyMembershipId + "/Character/" + characterId + "/", DestinyCharacterResponse.class, 
				new BasicNameValuePair("components", componentsString));
	}
	
	public DestinyProfileResponse GetProfile(BungieMembershipType membershipType, long destinyMembershipId, DestinyComponentType... components) throws APIErrorException
	{
		String componentsString = "" + components[0].getId();
		
		for(int i = 1; i < components.length; i++)
		{
			componentsString += "," + components[i].getId();
		}
		
		return get("/Destiny2/" + membershipType + "/Profile/" + destinyMembershipId + "/", DestinyProfileResponse.class, 
				new BasicNameValuePair("components", componentsString));
	}
	
	public DestinyProfileResponse GetProfile(APIUser user, DestinyComponentType... components) throws APIErrorException
	{
		UserMembershipData data = GetMembershipDataForCurrentUser(user);
		
		return GetProfile(BungieMembershipType.fromId(data.destinyMemberships[0].membershipType), data.destinyMemberships[0].membershipId, components);
	}
	
	public UserMembershipData GetMembershipDataForCurrentUser(APIUser user) throws APIErrorException
	{
		return get_authorized("/User/GetMembershipsForCurrentUser/", UserMembershipData.class, user);
	}
	
	public UserInfoCard[] SearchDestinyPlayerByBungieName(BungieMembershipType membershipType, String displayName, short displayNameCode) throws APIErrorException
	{
		return SearchDestinyPlayerByBungieName(membershipType, new ExactSearchRequest(displayName, displayNameCode));
	}
	
	public UserInfoCard[] SearchDestinyPlayerByBungieName(BungieMembershipType membershipType, ExactSearchRequest request) throws APIErrorException
	{
		return post("/Destiny2/SearchDestinyPlayerByBungieName/" + membershipType + "/", UserInfoCard[].class, new RestHeader[] 
				{
					new RestHeader("X-API-Key", this.api_key)
				}, gson.toJson(request));
	}
	
	public UserInfoCard[] SearchDestinyPlayerByBungieName(BungieMembershipType membershipType, String displayNameWithCode) throws APIErrorException
	{
		int index = displayNameWithCode.lastIndexOf('#');
		String displayName = displayNameWithCode.substring(0, index);
		short displayNameCode = Short.parseShort(displayNameWithCode.substring(index + 1));
		
		return SearchDestinyPlayerByBungieName(membershipType, displayName, displayNameCode);
	}
	
	public void registerCallback(DestinyAPICallback callback)
	{
		this.callback = callback;
	}
	
	private boolean tryRenewAccessToken(APIUser user) throws APIErrorException
	{
		if(this.client_id == null || this.client_id.isBlank() || this.client_secret == null || this.client_secret.isBlank())
			return false;

		if(!this.callback.hasAccessTokenExpired(user))
			return true;
			
		if(!this.callback.canRenewAccessToken(user))
			return false;
		
		String authToken = this.client_id + ":" + this.client_secret;
		String base64EncodedAuthToken = Base64.getEncoder().encodeToString(authToken.getBytes());
		
		AccessTokenResponse response = post("/App/OAuth/Token/", AccessTokenResponse.class, new RestHeader[]
				{
					new RestHeader("Authorization", "Basic " + base64EncodedAuthToken),
					new RestHeader("Content-Type", "application/x-www-form-urlencoded")
				}, new BasicNameValuePair("grant_type", "refresh_token"), new BasicNameValuePair("refresh_token", user.refresh_token));
		
		if(response == null)
		{
			return false;
		}
		else if(response.error != null && response.error_description != null)
		{
			this.callback.onAccessTokenRenewalError(user, response.error, response.error_description);
			return false;
		}
		
		String accessToken = response.access_token;
		user.access_token = accessToken;
		
		String refreshToken = response.refresh_token;
		user.refresh_token = refreshToken;
		
		long accessTokenExpiryTimeSeconds = response.expires_in;
		long refreshTokenExpiryTimeSeconds = response.refresh_expires_in;
		
		user.accessTokenExpiryTimeSeconds = accessTokenExpiryTimeSeconds;
		user.refreshTokenExpiryTimeSeconds = refreshTokenExpiryTimeSeconds;
		
		this.callback.onAccessTokenRenewed(user, accessToken, refreshToken, accessTokenExpiryTimeSeconds, refreshTokenExpiryTimeSeconds);
		
		return true;
	}
	
	private class AccessTokenResponse
	{
		public String access_token;
		public String refresh_token;
		public long expires_in;
		public long refresh_expires_in;
		
		public String error;
		public String error_description;
	}
	
	private <T> T get_authorized(String endpoint, Class<T> clazz, APIUser user, BasicNameValuePair...params) throws APIErrorException
	{
		if(!tryRenewAccessToken(user))
		{
			System.out.println("Failed to renew access token.");
			return null;
		}
		
		return get(endpoint, clazz, new RestHeader[]
				{
					new RestHeader("Authorization", "Bearer " + user.access_token)
				}, params);
	}
	
	private <T> T get(String endpoint, Class<T> clazz, BasicNameValuePair...params) throws APIErrorException
	{
		return get(API_URL, endpoint, clazz, new RestHeader[0], params);
	}
	
	private <T> T get(String endpoint, Class<T> clazz, RestHeader[] headers, BasicNameValuePair...params) throws APIErrorException
	{
		return get(API_URL, endpoint, clazz, headers, params);
	}
	
	private <T> T get(String apiUrl, String endpoint, Class<T> clazz, BasicNameValuePair...params) throws APIErrorException
	{
		return get(apiUrl, endpoint, clazz, new RestHeader[0], params);
	}
	
	private <T> T get(String apiUrl, String endpoint, Class<T> clazz, RestHeader[] headers, BasicNameValuePair...params) throws APIErrorException
	{
		try
		{
			URIBuilder builder = new URIBuilder(apiUrl + endpoint).setParameters(params);
			
			HttpGet get = new HttpGet(builder.build());
			
			get.setHeader("X-API-Key", this.api_key);
			
			for(RestHeader header : headers)
			{
				get.setHeader(header.key, header.value);
			}
			
			HttpResponse response = client.execute(get, context);
			String jsonString = EntityUtils.toString(response.getEntity());
			
			System.out.println(String.format("GET %s %s %s", apiUrl, endpoint, StringUtils.abbreviate(jsonString, 1000)));

			JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
			
			int errorCode = json.get("ErrorCode").getAsInt();
			int throttleSeconds = json.get("ThrottleSeconds").getAsInt();
			String errorStatus = json.get("ErrorStatus").getAsString();
			String message = json.get("Message").getAsString();
			Map<String, String> messageData = gson.fromJson(json.get("MessageData"), Map.class);
			
			if(errorCode != 1) // TODO: Error codes
				throw new APIErrorException(errorCode, throttleSeconds, errorStatus, message, messageData);
				
			return gson.fromJson(json.get("Response").getAsJsonObject(), clazz);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	private <T> T get(String endpoint, Type type, BasicNameValuePair...params) throws APIErrorException
	{
		return get(API_URL, endpoint, type, new RestHeader[0], params);
	}
	
	private <T> T get(String apiUrl, String endpoint, Type type, RestHeader[] headers, BasicNameValuePair...params) throws APIErrorException
	{
		try
		{
			URIBuilder builder = new URIBuilder(apiUrl + endpoint).setParameters(params);
			
			HttpGet get = new HttpGet(builder.build());
			
			get.setHeader("X-API-Key", this.api_key);
			
			for(RestHeader header : headers)
			{
				get.setHeader(header.key, header.value);
			}
			
			HttpResponse response = client.execute(get, context);
			String jsonString = EntityUtils.toString(response.getEntity());
			
			System.out.println(String.format("GET %s %s %s", apiUrl, endpoint, StringUtils.abbreviate(jsonString, 1000)));

			JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
			
			int errorCode = json.get("ErrorCode").getAsInt();
			int throttleSeconds = json.get("ThrottleSeconds").getAsInt();
			String errorStatus = json.get("ErrorStatus").getAsString();
			String message = json.get("Message").getAsString();
			Map<String, String> messageData = gson.fromJson(json.get("MessageData"), Map.class);
			
			if(errorCode != 1) // TODO: Error codes
				throw new APIErrorException(errorCode, throttleSeconds, errorStatus, message, messageData);
				
			return gson.fromJson(json.get("Response").getAsJsonObject(), type);
		}
		catch(MalformedJsonException e)
		{
			throw new APIErrorException(5, -1, "", "Bungie.Net is down for maintenance.", new HashMap<>());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	private <T> T post_authorized(String endpoint, Class<T> clazz, APIUser user, BasicNameValuePair...params) throws APIErrorException
	{
		if(!tryRenewAccessToken(user))
		{
			System.out.println("Failed to renew access token.");
			return null;
		}
		
		return post(endpoint, clazz, new RestHeader[]
				{
					new RestHeader("X-API-Key", this.api_key),
					new RestHeader("Authorization", "Bearer " + user.access_token)
				}, params);
	}
	
	private <T> T post(String endpoint, Class<T> clazz, RestHeader[] headers, String json) throws APIErrorException
	{
		try 
		{
			return post(endpoint, clazz, headers, new StringEntity(json));
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	private <T> T post(String endpoint, Class<T> clazz, RestHeader[] headers, BasicNameValuePair...params) throws APIErrorException
	{
		try 
		{
			return post(endpoint, clazz, headers, new UrlEncodedFormEntity(Arrays.asList(params)));
		} 
		catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	private <T> T post(String endpoint, Class<T> clazz, RestHeader[] headers, HttpEntity entity) throws APIErrorException
	{
		try
		{
			HttpPost post = new HttpPost(API_URL + endpoint);
			
			for(RestHeader header : headers)
			{
				post.setHeader(header.key, header.value);
			}
			
			post.setEntity(entity);
			
			HttpResponse response = client.execute(post, context);
			String jsonString = EntityUtils.toString(response.getEntity());
			System.out.println(String.format("POST %s %s", endpoint, StringUtils.abbreviate(jsonString, 1000)));
			
			JsonObject json = JsonParser.parseString(jsonString).getAsJsonObject();
			
			if(json.has("Response"))
			{
				int errorCode = json.get("ErrorCode").getAsInt();
				int throttleSeconds = json.get("ThrottleSeconds").getAsInt();
				String errorStatus = json.get("ErrorStatus").getAsString();
				String message = json.get("Message").getAsString();
				Map<String, String> messageData = gson.fromJson(json.get("MessageData"), Map.class);
				
				if(errorCode != 1) // TODO: Error codes
					throw new APIErrorException(errorCode, throttleSeconds, errorStatus, message, messageData);
					
				return gson.fromJson(json.get("Response"), clazz);
			}
			else
			{
				return gson.fromJson(json, clazz);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public class RestHeader
	{
		private String key;
		private String value;
		
		public RestHeader(String key, String value)
		{
			this.key = key;
			this.value = value;
		}
	}
	
	public interface DestinyAPICallback
	{
		default boolean canRenewAccessToken(APIUser user)
		{
			return true;
		}
		
		boolean hasAccessTokenExpired(APIUser user);
		void onAccessTokenRenewed(APIUser user, String renewedAccessToken, String renewedRefreshToken, long accessTokenExpiryTimeSeconds, long refreshTokenExpiryTimeSeconds);
		void onAccessTokenRenewalError(APIUser user, String error, String errorDescription);
	}
	
	public static class APIUser
	{
		private String access_token;
		private String refresh_token;
		public long accessTokenExpiryTimeSeconds;
		public long refreshTokenExpiryTimeSeconds;
		
		public APIUser(String accessToken, String refreshToken, long accessTokenExpiryTimeSeconds, long refreshTokenExpiryTimeSeconds)
		{
			this.access_token = accessToken;
			this.refresh_token = refreshToken;
			this.accessTokenExpiryTimeSeconds = accessTokenExpiryTimeSeconds;
			this.refreshTokenExpiryTimeSeconds = refreshTokenExpiryTimeSeconds;
		}
	}
	
	public boolean Authorize(APIUser user) throws APIErrorException
	{
		return tryRenewAccessToken(user);
	}
	
	public class APIErrorException extends Exception
	{
		private static final long serialVersionUID = 2371360571084929840L;
	
		public final int errorCode;
		public final int throttleSeconds;
		public final String errorStatus;
		public final String message;
		public final Map<String, String> messageData;
		
		public APIErrorException(int errorCode, int throttleSeconds, String errorStatus, String message, Map<String, String> messageData)
		{
			this.errorCode = errorCode;
			this.throttleSeconds = throttleSeconds;
			this.errorStatus = errorStatus;
			this.message = message;
			this.messageData = messageData;
		}
	}
}