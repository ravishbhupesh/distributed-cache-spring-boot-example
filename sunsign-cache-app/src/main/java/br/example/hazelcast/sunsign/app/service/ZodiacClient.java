package br.example.hazelcast.sunsign.app.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${app.zodiac.client.name}", url = "${app.zodiac.client.url}")
public interface ZodiacClient {

    @GetMapping("/zodiac/{month}/{day}")
    String getZodiac(@PathVariable("month") int month, @PathVariable("day") int day);
}
