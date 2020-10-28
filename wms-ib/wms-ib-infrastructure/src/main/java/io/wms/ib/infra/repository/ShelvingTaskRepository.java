package io.wms.ib.infra.repository;

import io.wms.ib.domain.facade.repository.IShelvingTaskRepository;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.infra.manager.ShelvingTaskManager;
import io.wms.ib.infra.po.ShelvingTaskPo;
import io.wms.ib.infra.translator.ShelvingTaskPoTranslator;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ShelvingTaskRepository implements IShelvingTaskRepository {

    @Resource
    private ShelvingTaskManager shelvingTaskManager;

    @Override
    public void saveTask(ShelvingTask task) {
        // domain model转换为可以MyBatis使用的PO对象：persistent object
        ShelvingTaskPo taskPo = ShelvingTaskPoTranslator.instance.translate(task);

        // 事务由Manager处理
        shelvingTaskManager.insertTask(taskPo);
    }
}
