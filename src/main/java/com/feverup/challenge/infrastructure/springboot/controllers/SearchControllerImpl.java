package com.feverup.challenge.infrastructure.springboot.controllers;

import com.feverup.challenge.core.application.dto.SearchRequest;
import com.feverup.challenge.core.application.dto.SearchResponse;
import com.feverup.challenge.core.application.usecases.SearchUseCase;
import com.feverup.challenge.entrypoints.controllers.SearchController;
import com.feverup.challenge.infrastructure.springboot.configs.CacheConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequiredArgsConstructor
public class SearchControllerImpl implements SearchController {
    private final SearchUseCase searchUseCase;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    @Cacheable(CacheConfig.EVENTS_CACHE)
    public SearchResponse search(@RequestParam("starts_at") ZonedDateTime start, @RequestParam("ends_at") ZonedDateTime end) {
        return searchUseCase.execute(SearchRequest.builder().startsAt(start).endsAt(end).build());
    }
}
