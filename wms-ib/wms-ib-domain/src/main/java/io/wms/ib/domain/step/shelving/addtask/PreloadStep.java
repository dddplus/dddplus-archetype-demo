package io.wms.ib.domain.step.shelving.addtask;

import io.github.dddplus.annotation.Step;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.domain.step.shelving.AddShelvingTaskStep;
import io.wms.ib.spec.Steps;
import io.wms.ib.spec.ext.IbException;

@Step(name = "预加载商品数据到上架任务明细，以便真正上架时不必再调商品接口：提升现场个人效率", tags = Steps.Tags.Performance)
public class PreloadStep extends AddShelvingTaskStep {

    @Override
    public void execute(ShelvingTask model) throws IbException {
        // 通过thread pool来异步执行预加载
        // 例如：商品的保质周期，商品的品牌等，这些在上架员现场操作时需要肉眼查看这些信息，而这些信息在商品中心里保存
    }

    @Override
    public String stepCode() {
        return Steps.AddShelvingTask.StepCode.Preload;
    }
}
