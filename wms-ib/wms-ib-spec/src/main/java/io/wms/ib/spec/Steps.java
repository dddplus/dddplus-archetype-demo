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

        interface StepCode {
            /**
             * 防重校验.
             */
            String AntiDup = "antiDup";

            /**
             * 推荐储位.
             */
            String Recommend = "recommend";

            /**
             * 库存.
             */
            String Stock = "stock";

            /**
             * 从主数据中心提前预加载数据.
             */
            String Preload = "preload";

            /**
             * 落库.
             */
            String Persist = "persist";
        }
    }

    /**
     * 统一定义所有的步骤标签.
     */
    interface Tags {
        /**
         * 处于性能考虑.
         */
        String Performance = "perf";
    }
}
