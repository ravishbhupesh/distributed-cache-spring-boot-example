package br.example.hazelcast.sunsign.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ZodiacService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ZodiacService.class);

    @Autowired
    private ZodiacClient zodiacClient;

    @Cacheable(value = "zodiacCache", key = "#month + '-' + #day")
    public String getCachedZodiac(int month, int day) {

        LOGGER.info("Call Zodiac Service with month : {}, Day : {}", month, day);
        String result = zodiacClient.getZodiac(month, day);
        LOGGER.info("Zodiac Service Response!!! Sun Sign : {}", result);
        return result;
    }
}