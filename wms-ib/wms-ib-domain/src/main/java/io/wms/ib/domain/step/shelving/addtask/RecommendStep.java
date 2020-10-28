package io.wms.ib.domain.step.shelving.addtask;

import io.github.dddplus.annotation.Step;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.domain.step.shelving.AddShelvingTaskStep;
import io.wms.ib.spec.Steps;
import io.wms.ib.spec.ext.IbException;

@Step
public class RecommendStep extends AddShelvingTaskStep {

    @Override
    public void execute(ShelvingTask model) throws IbException {
    }

    @Override
    public String stepCode() {
        return Steps.AddShelvingTask.StepCode.Recommend;
    }
}
