package dev.byli.robot.archetype.entrypoints.controllers;

import dev.byli.robot.archetype.core.usecase.dummy.FindAllDummyUseCase;
import dev.byli.robot.archetype.core.usecase.dummy.FindDummyByIdUseCase;
import dev.byli.robot.archetype.core.usecase.dummy.SaveDummyUseCase;
import dev.byli.robot.archetype.core.usecase.dummy.dto.CreateDummyRequestDTO;
import dev.byli.robot.archetype.core.usecase.dummy.dto.DummyResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/dummy")
public class DomainController {
    private final SaveDummyUseCase saveDummyUseCase;
    private final FindDummyByIdUseCase findDummyByIdUseCase;
    private final FindAllDummyUseCase findAllDummyUseCase;

    @PostMapping
    public DummyResponseDTO execute(@RequestBody CreateDummyRequestDTO request) {
        return saveDummyUseCase.execute(request);
    }

    @GetMapping("/{id}")
    public DummyResponseDTO findDummyById(@PathVariable Long id) {
        return findDummyByIdUseCase.execute(id);
    }

    @GetMapping
    public List<DummyResponseDTO> findAllDummy() {
        return findAllDummyUseCase.execute();
    }
}

