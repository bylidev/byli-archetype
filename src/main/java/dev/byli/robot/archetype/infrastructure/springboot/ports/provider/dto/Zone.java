package dev.byli.robot.archetype.infrastructure.springboot.ports.provider.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Zone {
    @JacksonXmlProperty(localName = "zone_id")
    private Long zoneId;
    @JacksonXmlProperty(localName = "capacity")
    private Integer capacity;
    @JacksonXmlProperty(localName = "price")
    private String price;
    @JacksonXmlProperty(localName = "localName")
    private String localName;
    @JacksonXmlProperty(localName = "numbered")
    private Boolean numbered;
}
