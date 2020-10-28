package io.wms.ib.domain.step.shelving;

import io.github.dddplus.step.IRevokableDomainStep;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.spec.Steps;
import io.wms.ib.spec.ext.IbException;

import javax.validation.constraints.NotNull;

/**
 * 添加上架任务活动.
 */
public abstract class AddShelvingTaskStep implements IRevokableDomainStep<ShelvingTask, IbException> {

    @Override
    public String activityCode() {
        return Steps.AddShelvingTask.Activity;
    }

    @Override
    public void rollback(@NotNull ShelvingTask model, @NotNull IbException cause) {
        // 默认不回滚，子类可以通过覆盖实现对应步骤的回滚逻辑
    }

}
