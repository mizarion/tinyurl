package org.mizarion.tinyurl.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.mizarion.tinyurl.model.CreateShortUrlRequestDto;
import org.mizarion.tinyurl.model.ShortUrlDto;
import org.mizarion.tinyurl.service.RedirectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequiredArgsConstructor
public class LinkController {

    private final RedirectService redirectService;

    @GetMapping("/redirect/{link}")
    public RedirectView redirect(@PathVariable String link) {
        return new RedirectView(redirectService.getOriginalUrl(link));
    }

    @PostMapping("/redirect")
    public ShortUrlDto createRedirection(@Valid @RequestBody CreateShortUrlRequestDto request) {
        return redirectService.createShortUrl(request);
    }
}
