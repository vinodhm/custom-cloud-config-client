package com.vino.pricing.controller;

import com.vino.pricing.beans.SecurityPrice;
import com.vino.pricing.beans.SecurityPriceId;
import com.vino.pricing.dao.PricingRepository;
import com.vino.pricing.service.StockPricing;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class StockPricingController {

    StockPricing stockPricing;

    @Autowired
    StockPricingController(StockPricing stockPricing) {
        this.stockPricing = stockPricing;
    }

    @GetMapping("/securities")
    public List<SecurityPrice> allSecurities(){
        return stockPricing.getSecuritiesPrices();
    }

    @GetMapping("/price/{securityId}/{tradeDate}")
    public SecurityPrice getSecurityPrice(@PathVariable String securityId, @PathVariable Date tradeDate ) {
        return stockPricing.getSecurityPrice(securityId,tradeDate);
    }

}
