package org.mizarion.tinyurl.service;

import lombok.RequiredArgsConstructor;
import org.mizarion.tinyurl.entity.LinkEntity;
import org.mizarion.tinyurl.model.CreateShortUrlRequestDto;
import org.mizarion.tinyurl.model.ShortUrlDto;
import org.mizarion.tinyurl.repository.LinkRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RedirectServiceImpl implements RedirectService {

    private final LinkRepository linkRepository;

    @Override
    public String getOriginalUrl(String shortUrl) {
        Optional<LinkEntity> linkByShortUrl = linkRepository.findByShortUrl(shortUrl);
        if (linkByShortUrl.isPresent()) {
            return linkByShortUrl.get().getLongUrl();
        } else {
            throw new RuntimeException("Link not found");
        }
    }

    @Override
    public ShortUrlDto createShortUrl(CreateShortUrlRequestDto request) {
        String shortUrl = UUID.randomUUID().toString().substring(0, 8);
        LinkEntity link = LinkEntity.builder()
                .shortUrl(shortUrl)
                .longUrl(request.getOriginalUrl())
                .build();
        linkRepository.save(link);
        return ShortUrlDto.builder()
                .shortUrl(shortUrl)
                .build();
    }
}
