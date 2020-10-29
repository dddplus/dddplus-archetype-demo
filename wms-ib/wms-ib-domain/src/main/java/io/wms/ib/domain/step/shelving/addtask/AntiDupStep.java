package io.wms.ib.domain.step.shelving.addtask;

import io.github.dddplus.annotation.Step;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.domain.step.shelving.AddShelvingTaskStep;
import io.wms.ib.spec.Steps;
import io.wms.ib.spec.ext.IbException;
import lombok.extern.slf4j.Slf4j;

@Step
@Slf4j
public class AntiDupStep extends AddShelvingTaskStep {

    @Override
    public void execute(ShelvingTask model) throws IbException {
        log.info("taskNo: {}，根据任务号防重", model.getTaskNo());

        // 此处省略了防重的实现
    }

    @Override
    public String stepCode() {
        return Steps.AddShelvingTask.StepCode.AntiDup;
    }
}
