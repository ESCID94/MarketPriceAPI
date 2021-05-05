package com.ust.pricemarket.services;

import java.io.File;

import org.testng.annotations.Test;

public class NewTest {
    @Test
    public void importCSV() {
        SubscriberImp subscriber = new SubscriberImp();

        File csv = new File("TestMarketPriceFeed.csv");
        subscriber.importCSV(csv).toString();

    }
}
