package io.wms.ib.infra.repository;

import io.wms.ib.domain.facade.repository.IShelvingTaskRepository;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.domain.model.vo.ShelvingTaskItem;
import io.wms.ib.infra.manager.ShelvingTaskManager;
import io.wms.ib.infra.po.ShelvingTaskItemPo;
import io.wms.ib.infra.po.ShelvingTaskPo;
import io.wms.ib.infra.translator.ShelvingTaskItemPoTranslator;
import io.wms.ib.infra.translator.ShelvingTaskPoTranslator;
import io.wms.ib.spec.model.vo.IShelvingTaskItem;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShelvingTaskRepository implements IShelvingTaskRepository {

    @Resource
    private ShelvingTaskManager shelvingTaskManager;

    @Override
    public void saveTask(ShelvingTask task) {
        // domain model转换为可以MyBatis使用的PO对象：persistent object
        ShelvingTaskPo taskPo = ShelvingTaskPoTranslator.instance.translate(task);
        List<ShelvingTaskItemPo> itemPos = new ArrayList<>(task.itemDelegate().size());
        for (IShelvingTaskItem item : task.itemDelegate().items()) {
            itemPos.add(ShelvingTaskItemPoTranslator.instance.translate(item));
        }

        // 事务由manager层处理
        shelvingTaskManager.insertTask(taskPo, itemPos);

        // 此时，task才得到id值：唯一标识
        task.assignId(this, taskPo.getId());
    }
}
