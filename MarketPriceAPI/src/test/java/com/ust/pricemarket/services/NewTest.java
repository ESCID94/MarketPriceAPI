package com.ust.pricemarket.services;

import java.io.File;

public class NewTest {
    @org.junit.Test
    public void importCSV() {
        SubscriberImp subscriber = new SubscriberImp();

        File csv = new File("TestMarketPriceFeed.csv");
        subscriber.importCSV(csv).toString();

    }
}
