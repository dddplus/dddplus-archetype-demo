package io.wms.ib.api;

import io.github.dddplus.api.ApiResult;
import io.github.dddplus.api.RequestProfile;
import io.wms.ib.api.dto.AddShelvingTaskRequest;
import io.wms.ib.api.dto.AddShelvingTaskResponse;

import javax.validation.constraints.NotNull;

/**
 * 上架任务的公共服务.
 */
public interface ShelvingTaskApi {

    /**
     * 添加上架任务.
     *
     * @param profile 系统入参
     * @param request 业务入参
     */
    ApiResult<AddShelvingTaskResponse> addTask(@NotNull RequestProfile profile, @NotNull AddShelvingTaskRequest request);

}
