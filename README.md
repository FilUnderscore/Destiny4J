# Destiny4J
Java binding for Bungie's Destiny API.

# Usage
Get your Bungie Application API login through https://www.bungie.net/en/Application

# API
Using your credentials for the Bungie API, create a new DestinyAPI object.
```java
DestinyAPI destinyApi = new DestinyAPI("API-KEY", "CLIENT-ID", "CLIENT-SECRET");
```

API calls can then be made through the `DestinyAPI` instanced object. See https://bungie-net.github.io/ for the full list of API calls and callbacks.

## Authorized User Requests
To make authorized user requests, you must create a `DestinyAPI.APIUser` object.
```java
DestinyAPI.APIUser user = new DestinyAPI.APIUser("user-access-token", "user-refresh-token", accessTokenExpiryTimeInSeconds, refreshTokenExpiryTimeInSeconds);
```

You can pass the `DestinyAPI.APIUser` object into API calls that require an authorized user. Access tokens are checked and refreshed periodically on every request.

# Manifest
Using your Bungie API Key, initialize the DestinyManifest.
```java
DestinyManifest.init("API-KEY", DestinyManifestFormat);
```

DestinyManifestFormat is an enum with two options:
* JSON
* SQLite

Subsequent calls to the manifest can be made through `DestinyManifest.getInstance()`.
