package dev.byli.robot.archetype.entrypoints.controllers;

import dev.byli.robot.archetype.core.application.dto.SearchResponse;

import java.time.ZonedDateTime;

public interface SearchController {
    SearchResponse search(ZonedDateTime start, ZonedDateTime end);
}

