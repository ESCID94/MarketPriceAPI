package com.ust.pricemarket.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.util.UriComponentsBuilder;

import com.ust.pricemarket.invoker.ApiClient;
import com.ust.pricemarket.model.MarketPrice;
import com.ust.pricemarket.model.ModelApiResponse;

@Component("com.ust.pricemarket.api.MarketPriceApi")
public class MarketPriceApi {
    private ApiClient apiClient;

    public MarketPriceApi() {
        this(new ApiClient());
    }

    @Autowired
    public MarketPriceApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Add a new MarketPrice to the store
     * <p>
     * <b>405</b> - Invalid input
     * 
     * @param body MarketPrice object that needs to be added to the store
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void addMarketPrice(MarketPrice body) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling addMarketPrice");
        }

        String path = UriComponentsBuilder.fromPath("/MarketPrice").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { "application/json", "application/xml" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json", "application/xml" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "MarketPricestore_auth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
        };
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Deletes a MarketPrice
     * <p>
     * <b>400</b> - Invalid ID supplied
     * <p>
     * <b>404</b> - MarketPrice not found
     * 
     * @param MarketPriceId MarketPrice id to delete
     * @param apiKey        The apiKey parameter
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteMarketPrice(Long MarketPriceId, String apiKey) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'MarketPriceId' is set
        if (MarketPriceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'MarketPriceId' when calling deleteMarketPrice");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("MarketPriceId", MarketPriceId);
        String path = UriComponentsBuilder.fromPath("/MarketPrice/{MarketPriceId}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (apiKey != null)
            headerParams.add("api_key", apiClient.parameterToString(apiKey));

        final String[] accepts = { "application/json", "application/xml" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "MarketPricestore_auth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
        };
        apiClient.invokeAPI(path, HttpMethod.DELETE, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Finds MarketPrices by status Multiple status values can be provided with comma separated strings
     * <p>
     * <b>200</b> - successful operation
     * <p>
     * <b>400</b> - Invalid status value
     * 
     * @param status Status values that need to be considered for filter
     * @return List&lt;MarketPrice&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<MarketPrice> findMarketPricesByStatus(List<String> status) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'status' is set
        if (status == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'status' when calling findMarketPricesByStatus");
        }

        String path = UriComponentsBuilder.fromPath("/MarketPrice/findByStatus").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "status", status));

        final String[] accepts = { "application/json", "application/xml" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "MarketPricestore_auth" };

        ParameterizedTypeReference<List<MarketPrice>> returnType = new ParameterizedTypeReference<List<MarketPrice>>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Finds MarketPrices by tags Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     * <p>
     * <b>200</b> - successful operation
     * <p>
     * <b>400</b> - Invalid tag value
     * 
     * @param tags Tags to filter by
     * @return List&lt;MarketPrice&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<MarketPrice> findMarketPricesByTags(List<String> tags) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'tags' is set
        if (tags == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'tags' when calling findMarketPricesByTags");
        }

        String path = UriComponentsBuilder.fromPath("/MarketPrice/findByTags").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        queryParams.putAll(apiClient.parameterToMultiValueMap(ApiClient.CollectionFormat.valueOf("multi".toUpperCase()), "tags", tags));

        final String[] accepts = { "application/json", "application/xml" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "MarketPricestore_auth" };

        ParameterizedTypeReference<List<MarketPrice>> returnType = new ParameterizedTypeReference<List<MarketPrice>>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Find MarketPrice by ID Returns a single MarketPrice
     * <p>
     * <b>200</b> - successful operation
     * <p>
     * <b>400</b> - Invalid ID supplied
     * <p>
     * <b>404</b> - MarketPrice not found
     * 
     * @param MarketPriceId ID of MarketPrice to return
     * @return MarketPrice
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public MarketPrice getMarketPriceById(Long MarketPriceId) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'MarketPriceId' is set
        if (MarketPriceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'MarketPriceId' when calling getMarketPriceById");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("MarketPriceId", MarketPriceId);
        String path = UriComponentsBuilder.fromPath("/MarketPrice/{MarketPriceId}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { "application/json", "application/xml" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = {};
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "api_key" };

        ParameterizedTypeReference<MarketPrice> returnType = new ParameterizedTypeReference<MarketPrice>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Update an existing MarketPrice
     * <p>
     * <b>400</b> - Invalid ID supplied
     * <p>
     * <b>404</b> - MarketPrice not found
     * <p>
     * <b>405</b> - Validation exception
     * 
     * @param body MarketPrice object that needs to be added to the store
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateMarketPrice(MarketPrice body) throws RestClientException {
        Object postBody = body;

        // verify the required parameter 'body' is set
        if (body == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'body' when calling updateMarketPrice");
        }

        String path = UriComponentsBuilder.fromPath("/MarketPrice").build().toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { "application/json", "application/xml" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/json", "application/xml" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "MarketPricestore_auth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
        };
        apiClient.invokeAPI(path, HttpMethod.PUT, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * Updates a MarketPrice in the store with form data
     * <p>
     * <b>405</b> - Invalid input
     * 
     * @param MarketPriceId ID of MarketPrice that needs to be updated
     * @param name          Updated name of the MarketPrice
     * @param status        Updated status of the MarketPrice
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void updateMarketPriceWithForm(Long MarketPriceId, String name, String status) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'MarketPriceId' is set
        if (MarketPriceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST,
                    "Missing the required parameter 'MarketPriceId' when calling updateMarketPriceWithForm");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("MarketPriceId", MarketPriceId);
        String path = UriComponentsBuilder.fromPath("/MarketPrice/{MarketPriceId}").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (name != null)
            formParams.add("name", name);
        if (status != null)
            formParams.add("status", status);

        final String[] accepts = { "application/json", "application/xml" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "application/x-www-form-urlencoded" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "MarketPricestore_auth" };

        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
        };
        apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }

    /**
     * uploads an image
     * <p>
     * <b>200</b> - successful operation
     * 
     * @param MarketPriceId      ID of MarketPrice to update
     * @param additionalMetadata Additional data to pass to server
     * @param file               file to upload
     * @return ModelApiResponse
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ModelApiResponse uploadFile(Long MarketPriceId, String additionalMetadata, File file) throws RestClientException {
        Object postBody = null;

        // verify the required parameter 'MarketPriceId' is set
        if (MarketPriceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'MarketPriceId' when calling uploadFile");
        }

        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("MarketPriceId", MarketPriceId);
        String path = UriComponentsBuilder.fromPath("/MarketPrice/{MarketPriceId}/uploadImage").buildAndExpand(uriVariables).toUriString();

        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        if (additionalMetadata != null)
            formParams.add("additionalMetadata", additionalMetadata);
        if (file != null)
            formParams.add("file", new FileSystemResource(file));

        final String[] accepts = { "application/json" };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { "multipart/form-data" };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] { "MarketPricestore_auth" };

        ParameterizedTypeReference<ModelApiResponse> returnType = new ParameterizedTypeReference<ModelApiResponse>() {
        };
        return apiClient.invokeAPI(path, HttpMethod.POST, queryParams, postBody, headerParams, formParams, accept, contentType, authNames,
                returnType);
    }
}
