package io.wms.ib.domain.ability;

import io.github.dddplus.annotation.DomainAbility;
import io.github.dddplus.ext.IDecideStepsExt;
import io.github.dddplus.runtime.BaseDomainAbility;
import io.wms.ib.domain.CoreDomain;
import io.wms.ib.spec.DomainAbilities;
import io.wms.ib.spec.model.IShelvingTask;

import javax.validation.constraints.NotNull;
import java.util.List;

@DomainAbility(domain = CoreDomain.CODE, name = "动态决定领域步骤的能力", tags = DomainAbilities.decideSteps)
public class DecideStepsAbility extends BaseDomainAbility<IShelvingTask, IDecideStepsExt> {

    public List<String> decideSteps(@NotNull IShelvingTask model, String activityCode) {
        return firstExtension(model).decideSteps(model, activityCode);
    }

    @Override
    public IDecideStepsExt defaultExtension(IShelvingTask model) {
        return null;
    }
}
