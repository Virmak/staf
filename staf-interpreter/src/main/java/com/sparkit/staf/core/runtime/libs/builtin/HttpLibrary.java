package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.ast.types.StafDictionary;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@StafLibrary(name = "HTTP Library", builtin = true)
public class HttpLibrary extends AbstractStafLibrary {

    @Keyword(name = "http get", doc = "Send a HTTP GET method with $url")
    public StafDictionary getMethod(@KeywordArgument(name = "url") StafString url,
                                    @KeywordArgument(name = "headers", optional = true) StafDictionary headers) throws IOException {
        StafDictionary responseDictionary = new StafDictionary();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url.getValue());
            if (headers != null) {
                setRequestHeaders(request, headers);
            }
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();
                responseDictionary.getObjectMap().put("body", new StafString(EntityUtils.toString(entity, StandardCharsets.UTF_8)));
                responseDictionary.getObjectMap().put("headers", extractResponseHeaders(response));
                return responseDictionary;
            }
        }
    }

    private void setRequestHeaders(HttpRequestBase request, StafDictionary headers) {
        for (Map.Entry<String, Object> headerEntry : headers.getEvaluatedObjectMap().entrySet()) {
            request.setHeader(headerEntry.getKey(), headerEntry.getValue().toString());
        }
    }

    private StafDictionary extractResponseHeaders(HttpResponse response) {
        StafDictionary headersDictionary = new StafDictionary();
        for (Header header : response.getAllHeaders()) {
            headersDictionary.getObjectMap().put(header.getName(), new StafString(header.getValue()));
        }
        return headersDictionary;
    }
}
