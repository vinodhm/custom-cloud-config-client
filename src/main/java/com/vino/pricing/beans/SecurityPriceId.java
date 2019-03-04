package com.vino.pricing.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class SecurityPriceId implements Serializable {

    @Column(name = "SECURITY_ID")
    String securityId;

    @Column(name = "TRADE_DATE")
    Date tradeDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SecurityPriceId)) return false;
        SecurityPriceId that = (SecurityPriceId) o;
        return Objects.equals(securityId, that.securityId) &&
                Objects.equals(tradeDate, that.tradeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(securityId, tradeDate);
    }
}
