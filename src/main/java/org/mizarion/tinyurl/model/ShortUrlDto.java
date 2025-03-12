package org.mizarion.tinyurl.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShortUrlDto {

    @JsonAlias({"short_url"})
    private String shortUrl;
}
