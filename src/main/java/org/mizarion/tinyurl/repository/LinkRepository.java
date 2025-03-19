package org.mizarion.tinyurl.repository;

import org.mizarion.tinyurl.entity.LinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LinkRepository extends JpaRepository<LinkEntity, Long> {

    Optional<LinkEntity> findByShortUrl(String shortUrl);

}
