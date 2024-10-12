package dev.byli.robot.archetype.infrastructure.springboot.ports.provider.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEvent {

    @JacksonXmlProperty(localName = "base_event_id")
    private Long baseEventId;

    @JacksonXmlProperty(localName = "sell_mode")
    private String sellMode;

    @JacksonXmlProperty(localName = "organizer_company_id")
    private Long organizerCompanyId;

    @JacksonXmlProperty(localName = "title")
    private String title;

    @JacksonXmlElementWrapper(localName = "event")
    private ProviderEvent event;

}
