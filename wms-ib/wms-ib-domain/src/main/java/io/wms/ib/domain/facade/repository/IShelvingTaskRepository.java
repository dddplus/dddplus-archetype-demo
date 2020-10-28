package io.wms.ib.domain.facade.repository;

import io.wms.ib.domain.model.ShelvingTask;

public interface IShelvingTaskRepository {

    void saveTask(ShelvingTask task);
}
