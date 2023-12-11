package org.example.mvc.controller;

import org.example.controller.RequestMethods;

import java.util.Objects;


public class HandlerKey {
    private final RequestMethods requestMethod;
    private final String url;

    public HandlerKey(RequestMethods requestMethod, String url) {
        this.requestMethod = requestMethod;
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlerKey that = (HandlerKey) o;
        return requestMethod == that.requestMethod && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestMethod, url);
    }
}
