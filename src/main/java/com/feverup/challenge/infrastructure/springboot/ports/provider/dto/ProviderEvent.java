package com.feverup.challenge.infrastructure.springboot.ports.provider.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProviderEvent {
    @JacksonXmlProperty(localName = "event_start_date")
    private String eventStartDate;

    @JacksonXmlProperty(localName = "event_end_date")
    private String eventEndDate;

    @JacksonXmlProperty(localName = "event_id")
    private Long eventId;

    @JacksonXmlProperty(localName = "sell_from")
    private String sellFrom;

    @JacksonXmlProperty(localName = "sell_to")
    private String sellTo;

    @JacksonXmlProperty(localName = "sold_out")
    private Boolean soldOut;
    @JsonProperty("zone")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Zone> zones;
}
