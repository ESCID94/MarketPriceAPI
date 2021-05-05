package com.ust.pricemarket.api;

import java.io.File;

import org.junit.Test;

import com.ust.pricemarket.services.SubscriberImp;

/*
 * Creation : 26 Apr 2021
 */

public class SubscriberTest {

    @Test
    public void importCSV() {
        SubscriberImp subscriber = new SubscriberImp();

        File csv = new File("src/main/java/TestMarketPriceFeed.csv");
        subscriber.importCSV(csv).toString();

    }

}
