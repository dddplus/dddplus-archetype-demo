package io.wms.ib.infra.translator;

import io.github.dddplus.IBaseTranslator;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.domain.model.vo.ShelvingTaskItem;
import io.wms.ib.infra.po.ShelvingTaskItemPo;
import io.wms.ib.infra.po.ShelvingTaskPo;
import io.wms.ib.spec.model.vo.IShelvingTaskItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShelvingTaskItemPoTranslator extends IBaseTranslator<IShelvingTaskItem, ShelvingTaskItemPo>  {
    ShelvingTaskItemPoTranslator instance = Mappers.getMapper(ShelvingTaskItemPoTranslator.class);

    @Override
    ShelvingTaskItemPo translate(IShelvingTaskItem taskItem);
}
