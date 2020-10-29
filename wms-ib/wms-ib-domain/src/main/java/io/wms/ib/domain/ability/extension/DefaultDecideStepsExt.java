package io.wms.ib.domain.ability.extension;

import io.github.dddplus.annotation.Extension;
import io.github.dddplus.ext.IDecideStepsExt;
import io.github.dddplus.model.IDomainModel;
import io.wms.ib.spec.Steps;

import java.util.*;

@Extension(code = IDecideStepsExt.DefaultCode)
public class DefaultDecideStepsExt implements IDecideStepsExt {
    private static final List<String> emptySteps = Collections.emptyList();

    @Override
    public List<String> decideSteps(IDomainModel model, String activityCode) {
        List<String> steps = stepsRegistry.get(activityCode);
        if (steps == null) {
            return emptySteps;
        }

        return steps;
    }

    private static Map<String, List<String>> stepsRegistry = new HashMap<>();
    static {
        List<String> addShelvingTaskSteps = new ArrayList<>();
        addShelvingTaskSteps.add(Steps.AddShelvingTask.StepCode.AntiDup);
        addShelvingTaskSteps.add(Steps.AddShelvingTask.StepCode.Recommend);
        addShelvingTaskSteps.add(Steps.AddShelvingTask.StepCode.Stock);
        addShelvingTaskSteps.add(Steps.AddShelvingTask.StepCode.Persist);
        addShelvingTaskSteps.add(Steps.AddShelvingTask.StepCode.Preload);
        stepsRegistry.put(Steps.AddShelvingTask.Activity, addShelvingTaskSteps);
    }
}
