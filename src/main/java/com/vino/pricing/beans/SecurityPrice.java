package com.vino.pricing.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SECURITY_PRICING")
public class SecurityPrice {
    @EmbeddedId
    SecurityPriceId securityPriceId;

    @Column
    Double price;
}
