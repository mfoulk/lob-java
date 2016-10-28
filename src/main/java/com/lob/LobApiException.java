package com.lob;

import com.lob.protocol.response.ErrorResponse;
import com.ning.http.client.FluentCaseInsensitiveStringsMap;

import com.ning.http.client.uri.Uri;

public class LobApiException extends RuntimeException {
    private final Uri uri;
    private final ErrorResponse errorResponse;
    private final int statusCode;
    private final FluentCaseInsensitiveStringsMap headers;

    public LobApiException(final Uri uri, final ErrorResponse errorResponse, final int statusCode, final FluentCaseInsensitiveStringsMap headers) {
        super(uri + " " + errorResponse.getError().toString());
        this.uri = uri;
        this.errorResponse = errorResponse;
        this.statusCode = statusCode;
        this.headers = headers;
    }

    public Uri getUri() {
        return uri;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public FluentCaseInsensitiveStringsMap getHeaders() {
        return headers;
    }

    @Override
    public String toString() {
        return "LobApiException: " + uri + " " + errorResponse.getError().toString();
    }
}
