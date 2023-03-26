package net.bungie.api.trending;

import net.bungie.api.SearchResult;

public class TrendingCategory 
{
	public String categoryName;
	public SearchResult<TrendingEntry> entries;
	public String categoryId;
}