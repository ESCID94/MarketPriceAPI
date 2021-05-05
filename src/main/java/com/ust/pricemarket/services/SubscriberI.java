/*
 * Creation : 26 Apr 2021
 */
package com.ust.pricemarket.services;

import java.io.File;
import java.util.List;

public interface SubscriberI<MarketPrice> {

    public void onMessage(String message);

    public List<MarketPrice> importCSV(File csv);

}
