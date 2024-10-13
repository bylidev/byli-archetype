package com.feverup.challenge.entrypoints.controllers;

import com.feverup.challenge.core.application.dto.SearchResponse;

import java.time.ZonedDateTime;

public interface SearchController {
    SearchResponse search(ZonedDateTime start, ZonedDateTime end);
}

