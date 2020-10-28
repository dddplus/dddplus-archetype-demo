package io.wms.ib.infra.manager;

import io.wms.ib.infra.po.ShelvingTaskPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class ShelvingTaskManager {

    @Transactional(rollbackFor = Exception.class)
    public void insertTask(ShelvingTaskPo taskPo) {
        // 这里省略了DAO的调用
        log.debug("insert: {}", taskPo);
    }
}
