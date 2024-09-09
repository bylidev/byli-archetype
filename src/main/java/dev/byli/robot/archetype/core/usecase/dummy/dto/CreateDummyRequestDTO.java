package dev.byli.robot.archetype.core.usecase.dummy.dto;

import dev.byli.robot.archetype.core.Dto;
import dev.byli.robot.archetype.core.domain.model.Dummy;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateDummyRequestDTO extends Dto<Dummy> {
    private String name;
    private String description;
}
