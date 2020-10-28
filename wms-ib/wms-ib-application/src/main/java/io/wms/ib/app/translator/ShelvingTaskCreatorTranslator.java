package io.wms.ib.app.translator;

import io.github.dddplus.IBaseTranslator;
import io.wms.ib.api.dto.AddShelvingTaskRequest;
import io.wms.ib.domain.model.ShelvingTaskCreator;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShelvingTaskCreatorTranslator extends IBaseTranslator<AddShelvingTaskRequest, ShelvingTaskCreator> {
    ShelvingTaskCreatorTranslator instance = Mappers.getMapper(ShelvingTaskCreatorTranslator.class);

    @Override
    ShelvingTaskCreator translate(AddShelvingTaskRequest request);
}
