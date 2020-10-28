package io.wms.ib.domain.model;

import io.wms.ib.spec.ext.IbException;
import io.wms.ib.spec.model.IShelvingTask;
import lombok.extern.slf4j.Slf4j;

/**
 * 上架任务聚合根.
 */
@Slf4j
public class ShelvingTask implements IShelvingTask {

    public static ShelvingTask createWith(ShelvingTaskCreator creator) throws IbException {
        log.debug("create with {}", creator);
        return new ShelvingTask(creator).validate();
    }

    // 为了保护领域模型，domain model不允许直接new
    private ShelvingTask(ShelvingTaskCreator creator) {

    }

    private ShelvingTask validate() throws IbException {
        return this;
    }
}
