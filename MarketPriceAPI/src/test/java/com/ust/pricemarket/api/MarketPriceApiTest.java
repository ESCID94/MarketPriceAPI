/*
 * Swagger MarketPricestore
 * This is a sample server MarketPricestore server.  You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.5
 * Contact: apiteam@swagger.io
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.ust.pricemarket.api;

import java.io.File;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.ust.pricemarket.model.MarketPrice;
import com.ust.pricemarket.model.ModelApiResponse;

/**
 * API tests for MarketPriceApi
 */
@Ignore
public class MarketPriceApiTest {

    private final MarketPriceApi api = new MarketPriceApi();

    /**
     * Add a new MarketPrice to the store
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void addMarketPriceTest() {
        MarketPrice body = null;
        api.addMarketPrice(body);

        // TODO: test validations
    }

    /**
     * Deletes a MarketPrice
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void deleteMarketPriceTest() {
        Long MarketPriceId = null;
        String apiKey = null;
        api.deleteMarketPrice(MarketPriceId, apiKey);

        // TODO: test validations
    }

    /**
     * Finds MarketPrices by status Multiple status values can be provided with comma separated strings
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void findMarketPricesByStatusTest() {
        List<String> status = null;
        List<MarketPrice> response = api.findMarketPricesByStatus(status);

        // TODO: test validations
    }

    /**
     * Finds MarketPrices by tags Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void findMarketPricesByTagsTest() {
        List<String> tags = null;
        List<MarketPrice> response = api.findMarketPricesByTags(tags);

        // TODO: test validations
    }

    /**
     * Find MarketPrice by ID Returns a single MarketPrice
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void getMarketPriceByIdTest() {
        Long MarketPriceId = null;
        MarketPrice response = api.getMarketPriceById(MarketPriceId);

        // TODO: test validations
    }

    /**
     * Update an existing MarketPrice
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateMarketPriceTest() {
        MarketPrice body = null;
        api.updateMarketPrice(body);

        // TODO: test validations
    }

    /**
     * Updates a MarketPrice in the store with form data
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void updateMarketPriceWithFormTest() {
        Long MarketPriceId = null;
        String name = null;
        String status = null;
        api.updateMarketPriceWithForm(MarketPriceId, name, status);

        // TODO: test validations
    }

    /**
     * uploads an image
     *
     * @throws ApiException if the Api call fails
     */
    @Test
    public void uploadFileTest() {
        Long MarketPriceId = null;
        String additionalMetadata = null;
        File file = null;
        ModelApiResponse response = api.uploadFile(MarketPriceId, additionalMetadata, file);

        // TODO: test validations
    }

}
