package dev.byli.robot.archetype.core.domain.model;

import dev.byli.robot.archetype.core.domain.Domain;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Dummy implements Domain {
    private String id;
    private String name;
    private String description;
}
