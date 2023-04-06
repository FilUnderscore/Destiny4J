package com.filunderscore.destiny4j.api.rest;

import java.util.function.Consumer;

import com.filunderscore.destiny4j.api.exceptions.IBungieNetError;

public interface IRestRequest<Response>
{
	/**
	 * Queues the REST request for execution asynchronously.
	 */
	void queue();
	
	/**
	 * Queues the REST request for execution asynchronously.
	 * 
	 * @param response Callback with response data if successful, otherwise null.
	 */
	void queue(Consumer<Response> response);
	
	/**
	 * Queues the REST request for execution synchronously.
	 * 
	 * @return Response.
	 */
	Response execute();
	
	/**
	 * Sets the fail callback if an error occurs while calling queue().
	 * 
	 * @param response Callback with error code if not successful.
	 * 
	 * @return IRestRequest.
	 */
	IRestRequest<Response> fail(Consumer<IBungieNetError> response);
	
	/**
	 * Sets the success callback if no error occurs while calling queue().
	 * 
	 * @param response
	 * @return
	 */
	IRestRequest<Response> success(Consumer<Response> response);
	
	/**
	 * Chains another REST request to this one, executing in order of chain, 
	 * regardless of fail/success.
	 * 
	 * @param request Request to chain.
	 * 
	 * @return IRestRequest.
	 */
	IRestRequest<Response> chain(@SuppressWarnings("rawtypes") IRestRequest request);
	
	/**
	 * Chains another REST request to this one, executing in order of chain, 
	 * only if the previous request was successful.
	 * 
	 * @param request Request to chain.
	 * 
	 * @return IRestRequest.
	 */
	IRestRequest<Response> chainOnSuccess(@SuppressWarnings("rawtypes") IRestRequest request);
}