package io.wms.ib.infra.translator;

import io.github.dddplus.IBaseTranslator;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.infra.po.ShelvingTaskPo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShelvingTaskPoTranslator extends IBaseTranslator<ShelvingTask, ShelvingTaskPo>  {
    ShelvingTaskPoTranslator instance = Mappers.getMapper(ShelvingTaskPoTranslator.class);

    @Override
    ShelvingTaskPo translate(ShelvingTask task);
}
