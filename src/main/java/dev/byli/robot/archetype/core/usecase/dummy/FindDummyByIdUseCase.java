package dev.byli.robot.archetype.core.usecase.dummy;

import dev.byli.robot.archetype.core.UseCase;
import dev.byli.robot.archetype.core.mappers.DummyMapper;
import dev.byli.robot.archetype.core.usecase.dummy.dto.DummyResponseDTO;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FindDummyByIdUseCase implements UseCase {
    private final DummyRepository repository;
    private final DummyMapper mapper= Mappers.getMapper(DummyMapper.class);

    @Override
    public DummyResponseDTO execute(Long id) {
        return mapper.toDto(repository.findById(id));
    }
}
