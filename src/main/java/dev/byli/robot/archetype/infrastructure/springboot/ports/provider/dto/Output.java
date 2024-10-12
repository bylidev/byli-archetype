package dev.byli.robot.archetype.infrastructure.springboot.ports.provider.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Output {
    @JsonProperty("base_event")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<BaseEvent> baseEvents;
}
