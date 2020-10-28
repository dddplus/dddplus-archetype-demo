package io.wms.ib.domain.step.shelving;

import io.github.dddplus.runtime.StepsExecTemplate;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.domain.step.shelving.AddShelvingTaskStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ShelvingTaskStepsExecutor extends StepsExecTemplate<AddShelvingTaskStep, ShelvingTask> {

    @Override
    protected void beforeStep(AddShelvingTaskStep step, ShelvingTask model) {
        log.info("step:{}.{} before:{}", step.activityCode(), step.stepCode(), model.label());
    }

}
