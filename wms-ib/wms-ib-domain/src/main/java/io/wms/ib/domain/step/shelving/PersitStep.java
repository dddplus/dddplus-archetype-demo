package io.wms.ib.domain.step.shelving;

import io.github.dddplus.annotation.Step;
import io.wms.ib.domain.facade.repository.IShelvingTaskRepository;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.domain.step.AddShelvingTaskStep;
import io.wms.ib.spec.Steps;
import io.wms.ib.spec.ext.IbException;

import javax.annotation.Resource;

@Step
public class PersitStep extends AddShelvingTaskStep {

    @Resource
    private IShelvingTaskRepository shelvingTaskRepository;

    @Override
    public void execute(ShelvingTask model) throws IbException {
        shelvingTaskRepository.saveTask(model);
    }

    @Override
    public String stepCode() {
        return Steps.AddShelvingTask.Step.Persist;
    }
}
