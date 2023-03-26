package net.bungie.api.trending;

import java.util.Date;

public class TrendingEntry 
{
	public double weight;
	public boolean isFeatured;
	public String identifier;
	public int entityType;
	public String displayName;
	public String tagline;
	public String image;
	public Date startDate;
	public Date endDate;
	public String link;
	public String webmVideo;
	public String mp4Video;
	public String featureImage;
	public TrendingEntry[] items;
	public Date creationDate;
}