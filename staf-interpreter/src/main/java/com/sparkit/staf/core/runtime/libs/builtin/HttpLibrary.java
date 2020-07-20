package com.sparkit.staf.core.runtime.libs.builtin;

import com.sparkit.staf.core.ast.types.AbstractStafObject;
import com.sparkit.staf.core.ast.types.StafDictionary;
import com.sparkit.staf.core.ast.types.StafList;
import com.sparkit.staf.core.ast.types.StafString;
import com.sparkit.staf.core.runtime.libs.AbstractStafLibrary;
import com.sparkit.staf.core.runtime.libs.annotations.Keyword;
import com.sparkit.staf.core.runtime.libs.annotations.KeywordArgument;
import com.sparkit.staf.core.runtime.libs.annotations.StafLibrary;
import com.sparkit.staf.core.utils.SharedConstants;
import org.apache.http.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@StafLibrary(name = "HTTP Library", builtin = true)
public class HttpLibrary extends AbstractStafLibrary {

    @Keyword(name = "http get", doc = "Send a HTTP GET request with $url and optional $headers dictionary, and returns a Dictionary with [body: string, headers: dictionary]")
    public StafDictionary httpGetRequest(@KeywordArgument(name = "url") StafString url,
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

    @Keyword(name = "http post", doc = "Send a HTTP POST request with $url, $postData dictionary and optional $headers dictionary, and returns a Dictionary with [body: string, headers: dictionary]")
    public StafDictionary httpPostRequest(@KeywordArgument(name = "url") StafString url,
                                          @KeywordArgument(name = "postData") StafDictionary postData,
                                          @KeywordArgument(name = "headers", optional = true) StafDictionary headers) throws IOException {
        StafDictionary responseDictionary = new StafDictionary();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost postRequest = new HttpPost(url.getValue());
            if (headers != null) {
                setRequestHeaders(postRequest, headers);
            }
            if (!postData.getObjectMap().isEmpty()) {
                setRequestParams(postRequest, postData);
            }
            try (CloseableHttpResponse response = httpClient.execute(postRequest)) {
                HttpEntity entity = response.getEntity();
                responseDictionary.getObjectMap().put("body", new StafString(EntityUtils.toString(entity, StandardCharsets.UTF_8)));
                responseDictionary.getObjectMap().put("headers", extractResponseHeaders(response));
                return responseDictionary;
            }
        }
    }

    @Keyword(name = "http post json", doc = "Send a HTTP POST request with $url, $jsonData string and optional $headers dictionary, and returns a Dictionary with [body: string, headers: dictionary]")
    public StafDictionary httpPostJsonRequest(@KeywordArgument(name = "url") StafString url,
                                              @KeywordArgument(name = "jsonData") StafString jsonData,
                                              @KeywordArgument(name = "headers", optional = true) StafDictionary headers) throws IOException {
        StafDictionary responseDictionary = new StafDictionary();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost postRequest = new HttpPost(url.getValue());
            if (headers != null) {
                setRequestHeaders(postRequest, headers);
            }

            StringEntity entity = new StringEntity(jsonData.getValue());
            postRequest.setEntity(entity);
            postRequest.setHeader(HttpHeaders.ACCEPT, SharedConstants.APPLICATION_JSON);
            postRequest.setHeader(HttpHeaders.CONTENT_TYPE, SharedConstants.APPLICATION_JSON);
            try (CloseableHttpResponse response = httpClient.execute(postRequest)) {
                HttpEntity responseEntity = response.getEntity();
                responseDictionary.getObjectMap().put("body", new StafString(EntityUtils.toString(responseEntity, StandardCharsets.UTF_8)));
                responseDictionary.getObjectMap().put("headers", extractResponseHeaders(response));
                return responseDictionary;
            }
        }
    }

    @Keyword(name = "http put json", doc = "Send a HTTP PUT request with $url, $jsonData string and optional $headers dictionary, and returns a Dictionary with [body: string, headers: dictionary]")
    public StafDictionary httpPutRequest(@KeywordArgument(name = "url") StafString url,
                                         @KeywordArgument(name = "jsonData") StafString jsonData,
                                         @KeywordArgument(name = "headers", optional = true) StafDictionary headers) throws IOException {
        StafDictionary responseDictionary = new StafDictionary();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPut postRequest = new HttpPut(url.getValue());
            if (headers != null) {
                setRequestHeaders(postRequest, headers);
            }

            StringEntity entity = new StringEntity(jsonData.getValue());
            postRequest.setEntity(entity);
            postRequest.setHeader(HttpHeaders.ACCEPT, SharedConstants.APPLICATION_JSON);
            postRequest.setHeader(HttpHeaders.CONTENT_TYPE, SharedConstants.APPLICATION_JSON);
            try (CloseableHttpResponse response = httpClient.execute(postRequest)) {
                HttpEntity responseEntity = response.getEntity();
                responseDictionary.getObjectMap().put("body", new StafString(EntityUtils.toString(responseEntity, StandardCharsets.UTF_8)));
                responseDictionary.getObjectMap().put("headers", extractResponseHeaders(response));
                return responseDictionary;
            }
        }
    }

    @Keyword(name = "http patch json", doc = "Send a HTTP PATCH request with $url, $jsonData string and optional $headers dictionary, and returns a Dictionary with [body: string, headers: dictionary]")
    public StafDictionary httpPatchRequest(@KeywordArgument(name = "url") StafString url,
                                           @KeywordArgument(name = "jsonData") StafString jsonData,
                                           @KeywordArgument(name = "headers", optional = true) StafDictionary headers) throws IOException {
        StafDictionary responseDictionary = new StafDictionary();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPatch postRequest = new HttpPatch(url.getValue());
            if (headers != null) {
                setRequestHeaders(postRequest, headers);
            }

            StringEntity entity = new StringEntity(jsonData.getValue());
            postRequest.setEntity(entity);
            postRequest.setHeader(HttpHeaders.ACCEPT, SharedConstants.APPLICATION_JSON);
            postRequest.setHeader(HttpHeaders.CONTENT_TYPE, SharedConstants.APPLICATION_JSON);
            try (CloseableHttpResponse response = httpClient.execute(postRequest)) {
                HttpEntity responseEntity = response.getEntity();
                responseDictionary.getObjectMap().put("body", new StafString(EntityUtils.toString(responseEntity, StandardCharsets.UTF_8)));
                responseDictionary.getObjectMap().put("headers", extractResponseHeaders(response));
                return responseDictionary;
            }
        }
    }

    @Keyword(name = "http delete", doc = "Send a HTTP DELETE request with $url and optional $headers dictionary, and returns a Dictionary with [body: string, headers: dictionary]")
    public StafDictionary httpDeleteRequest(@KeywordArgument(name = "url") StafString url,
                                            @KeywordArgument(name = "headers", optional = true) StafDictionary headers) throws IOException {
        StafDictionary responseDictionary = new StafDictionary();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpDelete request = new HttpDelete(url.getValue());
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

    private void setRequestParams(HttpPost request, StafDictionary params) throws UnsupportedEncodingException {
        List<NameValuePair> urlParameters = new ArrayList<>();
        for (Map.Entry<String, AbstractStafObject> requestParameterEntry : params.getObjectMap().entrySet()) {
            urlParameters.add(new BasicNameValuePair(requestParameterEntry.getKey(), requestParameterEntry.getValue().toString()));
        }
        request.setEntity(new UrlEncodedFormEntity(urlParameters));
    }

    private void setRequestHeaders(HttpRequestBase request, StafDictionary headers) {
        for (Map.Entry<String, AbstractStafObject> headerEntry : headers.getObjectMap().entrySet()) {
            if (headerEntry.getValue() instanceof StafList) {
                ((StafList) headerEntry.getValue()).getStafList().forEach(stafObject -> request.addHeader(headerEntry.getKey(),
                        (String) stafObject.getValue()));
            } else {
                request.addHeader(headerEntry.getKey(), headerEntry.getValue().toString());
            }
        }
    }

    private StafDictionary extractResponseHeaders(HttpResponse response) {
        StafDictionary headersDictionary = new StafDictionary();
        for (Header header : response.getAllHeaders()) {
            if (headersDictionary.getObjectMap().containsKey(header.getName())) {
                ((StafList) headersDictionary.getObjectMap().get(header.getName())).getStafList().add(new StafString(header.getValue()));
            } else {
                headersDictionary.getObjectMap().put(header.getName(),
                        new StafList(new ArrayList<>(Collections.singletonList(new StafString(header.getValue())))));
            }
        }
        return headersDictionary;
    }
}
