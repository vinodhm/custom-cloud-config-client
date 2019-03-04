package com.vino.pricing.service;

import com.vino.pricing.beans.SecurityPrice;
import com.vino.pricing.beans.SecurityPriceId;
import com.vino.pricing.dao.PricingRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StockPricingImpl implements StockPricing {


    @Setter @Autowired
    private PricingRepository pricingRepository;

    public List<SecurityPrice> getSecuritiesPrices(){
        System.out.println("In getSqlUser.......");
        return pricingRepository.findAll();
    }

    public SecurityPrice getSecurityPrice(String securityId,Date tradeDate) {
        return pricingRepository.findById(new SecurityPriceId(securityId,tradeDate)).get();
    }
}
