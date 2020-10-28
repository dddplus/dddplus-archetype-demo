package io.wms.ib.infra.manager;

import io.wms.ib.infra.po.ShelvingTaskItemPo;
import io.wms.ib.infra.po.ShelvingTaskPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Slf4j
public class ShelvingTaskManager {

    @Transactional(rollbackFor = Exception.class)
    public void insertTask(ShelvingTaskPo taskPo, List<ShelvingTaskItemPo> itemPos) {
        // 这里省略了DAO的调用
        // 主档表，明细表，要在一个事务内完成插入
        log.debug("insert: {}", taskPo);
    }
}
