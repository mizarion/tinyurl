package org.mizarion.tinyurl.service;

import org.mizarion.tinyurl.model.CreateShortUrlRequestDto;
import org.mizarion.tinyurl.model.ShortUrlDto;

public interface RedirectService {

    String getOriginalUrl(String shortUrl);

    ShortUrlDto createShortUrl(CreateShortUrlRequestDto request);
}
