package com.izeye.helloworld.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Utilities for URL.
 *
 * @author Johnny Lim
 */
public final class UrlUtils {

    public static Map<String, String> extractQueryParameters(String url) {
        Map<String, String> queryParameters = new LinkedHashMap<>();
        String[] pairs = url.substring(url.indexOf('?') + 1).split("&");
        for (String pair : pairs) {
            String[] nameAndValue = pair.split("=");
            queryParameters.put(nameAndValue[0], URLDecoder.decode(nameAndValue[1], StandardCharsets.UTF_8));
        }
        return queryParameters;
    }

    private UrlUtils() {
    }

}
