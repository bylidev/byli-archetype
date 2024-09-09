package dev.byli.robot.archetype.infrastructure.repository;

import dev.byli.robot.archetype.core.mappers.DummyMapper;
import dev.byli.robot.archetype.core.domain.model.Dummy;
import dev.byli.robot.archetype.infrastructure.repository.jooq.Tables;
import dev.byli.robot.archetype.infrastructure.repository.jooq.tables.records.DummyRecord;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;


@AllArgsConstructor
@Component
public class DummyRepository implements dev.byli.robot.archetype.core.usecase.dummy.DummyRepository {
    private final DSLContext dslContext;
    private final DummyMapper mapper = Mappers.getMapper(DummyMapper.class);

    @Override
    public Dummy save(Dummy domain) {
        dslContext.transaction(c -> {
            DummyRecord dummyRecord = dslContext.newRecord(Tables.DUMMY);
            dummyRecord.setName(domain.getName());
            dummyRecord.setDescription(domain.getDescription());
            dummyRecord.store();
        });
        return domain;
    }

    @Override
    public List<Dummy> findAll() {
        return dslContext.selectFrom(Tables.DUMMY).fetch().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Dummy findById(Long id) {
        DummyRecord result = dslContext.selectFrom(Tables.DUMMY).where(Tables.DUMMY.ID.eq(id)).fetchOne();
        return mapper.toDomain(result);
    }
}
