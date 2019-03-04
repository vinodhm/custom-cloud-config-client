package com.vino.pricing.beans;

import com.vino.pricing.util.EncryptionUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@ConfigurationProperties(prefix = "pricing-service")
public class PricingProperties {

    @Setter @Getter
    private String sqluser;
    @Setter @Getter
    private String jdbcurl;
    @Setter @Getter
    private String password;

    private EncryptionUtil encryptionUtil;

    @Autowired
    public void setEncryptionUtil(EncryptionUtil encryptionUtil){
        this.encryptionUtil = encryptionUtil;
    }

    @Bean
    public DataSource getDatasource() throws Exception {
        HikariConfig config = new HikariConfig();
        config.setUsername(ifEncryptedDecrypt(sqluser));
        config.setPassword(ifEncryptedDecrypt(password));
        config.setJdbcUrl(jdbcurl);
//        config.setConnectionTestQuery("select getdate()");
        return new HikariDataSource(config);
    }
    private String ifEncryptedDecrypt(String val){
        return val.contains("encrypted.")?encryptionUtil.decrypt(val):val;
    }
}

