package org.mizarion.tinyurl.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateShortUrlRequestDto {

    @JsonAlias({"url", "original_url"})
    @NotBlank
    private String originalUrl;
}
