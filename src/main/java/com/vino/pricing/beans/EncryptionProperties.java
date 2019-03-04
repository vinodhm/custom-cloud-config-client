package com.vino.pricing.beans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.vin.config.encryption")
public class EncryptionProperties {
    @Getter @Setter
    private String key;
    @Getter @Setter
    private String keyPrefix;
    @Getter @Setter
    private String algorithm ;
}
