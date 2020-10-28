package io.wms.ib.spec.model;

import io.github.dddplus.model.IDomainModel;
import io.wms.ib.spec.model.vo.IShelvingTaskItemDelegate;

/**
 * 上架任务.
 */
public interface IShelvingTask extends IDomainModel {

    IShelvingTaskItemDelegate itemDelegate();

    String label();
}
