package dev.byli.robot.archetype.core.mappers;

import dev.byli.robot.archetype.core.usecase.dummy.dto.CreateDummyRequestDTO;
import dev.byli.robot.archetype.core.usecase.dummy.dto.DummyResponseDTO;
import dev.byli.robot.archetype.core.domain.model.Dummy;
import dev.byli.robot.archetype.infrastructure.repository.jooq.tables.records.DummyRecord;
import org.mapstruct.Mapper;

@Mapper
public interface DummyMapper {
    DummyResponseDTO toDto(Dummy domain);

    Dummy toDomain(CreateDummyRequestDTO dto);

    Dummy toDomain(DummyResponseDTO dto);

    Dummy toDomain(DummyRecord record);

}
