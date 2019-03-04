package com.vino.pricing.service;

import com.vino.pricing.beans.SecurityPrice;

import java.util.Date;
import java.util.List;

public interface StockPricing {
    List<SecurityPrice> getSecuritiesPrices();
    SecurityPrice getSecurityPrice(String securityId,Date tradeDate);
}
