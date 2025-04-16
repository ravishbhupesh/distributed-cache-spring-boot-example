package br.example.hazelcast.sunsign.app.controller;

import br.example.hazelcast.sunsign.app.service.ZodiacService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sunsign")
public class SunsignController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SunsignController.class);

    @Autowired
    private ZodiacService zodiacService;

    @GetMapping("/sunsign/{month}/{day}")
    public ResponseEntity<String> getZodiac(@PathVariable int month, @PathVariable int day) {
        LOGGER.info("Request received!!! Month : {}, Day : {}", month, day);
        String result = zodiacService.getCachedZodiac(month, day);
        LOGGER.info("Response!!! Sun Sign : {}", result);
        return ResponseEntity.ok(result);
    }
}
