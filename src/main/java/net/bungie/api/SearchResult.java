package net.bungie.api;

import net.bungie.api.queries.PagedQuery;

public class SearchResult<T>
{
	public T[] results;
	public int totalResults;
	public boolean hasMore;
	public PagedQuery query;
	public String replacementContinuationToken;
	public boolean useTotalResults;
}