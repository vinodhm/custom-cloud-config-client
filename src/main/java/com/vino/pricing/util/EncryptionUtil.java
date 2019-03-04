package com.vino.pricing.util;

import com.vino.pricing.beans.EncryptionProperties;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "com.vin.config.encryption")
@Slf4j
@Component
public class EncryptionUtil {

    EncryptionProperties encryptionProperties;

    @Autowired
    EncryptionUtil(EncryptionProperties encryptionProperties){
        this.encryptionProperties = encryptionProperties;
    }

    public String decrypt(String encryptedData){
        System.out.println(" in Decrypt................");
        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();

        decryptor.setPassword(encryptionProperties.getKey());
        decryptor.setAlgorithm(encryptionProperties.getAlgorithm());
        System.out.println("encryptedData ::::"+encryptedData);
        String[] dataAfterSplitPrefix = encryptedData.split(encryptionProperties.getKeyPrefix());
        if(dataAfterSplitPrefix.length!=2 || dataAfterSplitPrefix[1].length()<=0){
            throw new IllegalStateException("Invalid encrypted Data, need to have some data after 'encrypted.' !!! ");
        }
        String decrypted = decryptor.decrypt(dataAfterSplitPrefix[1]);
        System.out.println("decrypted ::::"+decrypted);
        return decrypted;
    }
}
