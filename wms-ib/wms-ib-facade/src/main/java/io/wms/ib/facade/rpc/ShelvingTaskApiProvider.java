package io.wms.ib.facade.rpc;

import io.github.dddplus.api.ApiResult;
import io.github.dddplus.api.RequestProfile;
import io.wms.ib.api.ShelvingTaskApi;
import io.wms.ib.api.dto.AddShelvingTaskRequest;
import io.wms.ib.api.dto.AddShelvingTaskResponse;
import io.wms.ib.app.service.ShelvingTaskUseCase;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

@Component
public class ShelvingTaskApiProvider implements ShelvingTaskApi {

    @Resource
    private ShelvingTaskUseCase shelvingTaskUseCase;

    @Override
    public ApiResult<AddShelvingTaskResponse> addTask(@NotNull RequestProfile profile, @NotNull AddShelvingTaskRequest request) {
        // Facade层是非常薄的一层，直接调用Application Service
        // Facade层的主要内容：
        // 1. JSR303 validation
        // 2. 统一处理异常，包括业务异常和系统异常：把底层的异常转换为对外公开的错误码和错误消息，底层只抛出异常，不处理异常

        // 把该会话通过log4j的MDC机制统一起来，对业务开发无侵入，又能在日志上把一个会话的所有日志串起来
        MDC.put("_tid", profile.getTraceId());

        // 出于演示，这里省略了JSR303的数据校验实现
        ApiResult<AddShelvingTaskResponse> apiResult = new ApiResult<>();
        try {
            AddShelvingTaskResponse response = shelvingTaskUseCase.addTask(profile, request);
            apiResult.setCode("0");
            apiResult.setData(response);
            return apiResult;
        } catch (Exception ex) {
            // TODO 根据不同的异常，统一成对外公开的错误码
            apiResult.setCode("1");
            apiResult.setMessage(ex.getMessage());
        }

        return apiResult;
    }
}
