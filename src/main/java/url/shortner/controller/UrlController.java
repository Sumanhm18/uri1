package url.shortner.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import url.shortner.entity.ShortUrlDetails;
import url.shortner.entity.Url;
import url.shortner.entity.Urlentity;
import url.shortner.repository.UrlRepository;
import url.shortner.service.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
@Tag(name="controlers")
@RestController
public class UrlController {
    @Autowired
    UrlRepository urlRepository;
    @Autowired
    ShortUrlDetails shortUrlDetails;
    @Autowired
    private Urlentity urlentity1;
    @Autowired
    private Service service;



    @PostMapping("/shorten")
    public ResponseEntity<String> shotenUrls(@RequestBody Url url) {
        String url1 = url.getUrl();
        Urlentity entity = urlRepository.findByLongUrl(url1);
        String shortenUrl = entity.getShortUrl();
        return new ResponseEntity<>(shortenUrl, HttpStatus.OK);

    }


    @PostMapping("/custom")
    public ResponseEntity<?> saveUrlInfo(@RequestBody Urlentity urlentity) {
        service.save(urlentity);
        return new ResponseEntity<>(HttpStatus.OK);

    }


    @GetMapping("/stats/{shortcode}")
    public ResponseEntity<?> stats(@PathVariable String shortcode) {
        try {
            Urlentity urlEntity = urlRepository.findByShortUrl(shortcode);

            if (urlEntity == null) {
                return ResponseEntity.notFound().build();
            }

            Map<String, String> map = new HashMap<>();
            map.put("longUrl", urlEntity.getLongUrl());
            map.put("createdDate", String.valueOf(urlEntity.getDate()));
            map.put("expireDate", String.valueOf(urlEntity.getExpireDate()));
            map.put("accessCount", String.valueOf(urlEntity.getAccescount()));

            return ResponseEntity.ok(map);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
