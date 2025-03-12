package org.mizarion.tinyurl.service;

import org.junit.jupiter.api.Test;
import org.mizarion.tinyurl.model.CreateShortUrlRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class RedirectServiceImplTest {

    @Autowired
    private RedirectService redirectService;

    @Test
    void getOriginalUrl() {
        CreateShortUrlRequestDto request = new CreateShortUrlRequestDto("https://www.google.com");
        String shortUrl = redirectService.createShortUrl(request).getShortUrl();

        assertEquals(request.getOriginalUrl(), redirectService.getOriginalUrl(shortUrl));
    }
}