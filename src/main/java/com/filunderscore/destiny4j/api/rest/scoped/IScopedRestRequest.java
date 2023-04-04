package com.filunderscore.destiny4j.api.rest.scoped;

import java.util.function.Consumer;

import com.filunderscore.destiny4j.api.rest.IRestRequest;

public interface IScopedRestRequest<Response> extends IRestRequest<Response>
{
	IScopedRestRequest<Response> authFailed(Consumer<Void> response);
}