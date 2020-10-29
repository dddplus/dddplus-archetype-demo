package io.wms.ib.app.service;

import io.github.dddplus.api.RequestProfile;
import io.wms.ib.api.dto.AddShelvingTaskRequest;
import io.wms.ib.api.dto.AddShelvingTaskResponse;
import io.wms.ib.app.translator.ShelvingTaskCreatorTranslator;
import io.wms.ib.domain.model.ShelvingTask;
import io.wms.ib.domain.model.ShelvingTaskCreator;
import io.wms.ib.domain.service.ShelvingTaskService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * 上架任务的application service: use case层.
 *
 * <p>负责对领域服务进行编排</p>
 */
@Component
public class ShelvingTaskUseCase {

    @Resource
    private ShelvingTaskService shelvingTaskService;

    public AddShelvingTaskResponse addTask(@NotNull RequestProfile profile, @NotNull AddShelvingTaskRequest request) {
        // Application层负责把外部请求，转换为领域对象

        // 通过MapStruct进行转换：DTO -> Domain Model Creator
        ShelvingTaskCreator creator = ShelvingTaskCreatorTranslator.instance.translate(request);

        // 通过Creator创建domain model
        ShelvingTask task = ShelvingTask.createWith(creator);

        // 这里只编排了一个领域服务，但如果编排多个领域服务就更能看到它的价值了
        shelvingTaskService.addTask(task);

        // 这里省略了根据domain service的返回值来构建response的过程
        AddShelvingTaskResponse response = new AddShelvingTaskResponse();
        return response;
    }
}
