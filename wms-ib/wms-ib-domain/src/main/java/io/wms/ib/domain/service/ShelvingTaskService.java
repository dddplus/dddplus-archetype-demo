package io.wms.ib.domain.service;

import io.github.dddplus.annotation.DomainService;
import io.github.dddplus.model.IDomainService;
import io.github.dddplus.runtime.DDD;
import io.wms.ib.domain.CoreDomain;
import io.wms.ib.domain.ability.DecideStepsAbility;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.domain.step.shelving.ShelvingTaskStepsExecutor;
import io.wms.ib.spec.Steps;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.List;

@DomainService(domain = CoreDomain.CODE)
@Slf4j
public class ShelvingTaskService implements IDomainService {

    @Resource
    private ShelvingTaskStepsExecutor stepsExecutor;

    public void addTask(ShelvingTask task) {
        // 不同场景下，接单的执行步骤不同：通过扩展点实现业务流程的多态
        List<String> steps = DDD.findAbility(DecideStepsAbility.class).decideSteps(task, Steps.AddShelvingTask.Activity);
        log.info("steps: {}", steps);

        if (steps != null && !steps.isEmpty()) {
            // 通过步骤编排的模板方法执行每一个步骤，其中涉及到：步骤回滚，步骤重新编排
            stepsExecutor.execute(Steps.AddShelvingTask.Activity, steps, task);
        }

        log.info("上架任务添加完成！");
    }
}
