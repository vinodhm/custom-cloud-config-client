package com.vino.pricing.dao;

import com.vino.pricing.beans.SecurityPrice;
import com.vino.pricing.beans.SecurityPriceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingRepository extends JpaRepository<SecurityPrice,SecurityPriceId> {

}
