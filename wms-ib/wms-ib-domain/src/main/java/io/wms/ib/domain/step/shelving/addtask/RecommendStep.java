package io.wms.ib.domain.step.shelving.addtask;

import io.github.dddplus.annotation.Step;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.domain.step.shelving.AddShelvingTaskStep;
import io.wms.ib.spec.Steps;
import io.wms.ib.spec.ext.IbException;

@Step(name = "推荐储位")
public class RecommendStep extends AddShelvingTaskStep {

    @Override
    public void execute(ShelvingTask model) throws IbException {
        // 调用推荐中心，根据任务明细，推荐这些商品应该被上架到哪些储位上
    }

    @Override
    public String stepCode() {
        return Steps.AddShelvingTask.StepCode.Recommend;
    }
}
