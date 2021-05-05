/*
 * Creation : 26 Apr 2021
 */
package com.ust.pricemarket.services;

import java.util.List;

public interface ModifierI<MarketPrice> {

    public List<MarketPrice> addCommission(List<MarketPrice> priceList);
}
