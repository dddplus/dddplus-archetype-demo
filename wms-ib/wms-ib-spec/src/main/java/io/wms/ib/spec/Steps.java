package io.wms.ib.spec;

/**
 * 统一定义所有的活动和步骤.
 */
public interface Steps {

    /**
     * 领域活动：添加上架任务.
     */
    interface AddShelvingTask {
        String Activity = "addShelvingTask";
    }

    /**
     * 统一定义所有的步骤标签.
     */
    interface Tags {

    }
}
