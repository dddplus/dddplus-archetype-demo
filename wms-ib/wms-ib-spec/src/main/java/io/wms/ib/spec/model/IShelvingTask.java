package io.wms.ib.spec.model;

import io.github.dddplus.model.IDomainModel;
import io.wms.ib.spec.model.vo.IShelvingTaskItemDelegate;

/**
 * 上架任务.
 *
 * <p>改进DDD shared kernel模式：共享的不是领域模型类，而是接口.</p>
 * <p>这样，可以让前台与中台解耦：中台选择性输出领域模型的部分能力给前台.</p>
 * <p>早期，这样看起来繁琐了，但越往后收益越大.</p>
 */
public interface IShelvingTask extends IDomainModel {

    IShelvingTaskItemDelegate itemDelegate();

    String label();
}
