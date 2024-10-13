package com.feverup.challenge.core.application.dto;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Builder
public class SearchRequest {
    private ZonedDateTime startsAt;
    private ZonedDateTime endsAt;
}
