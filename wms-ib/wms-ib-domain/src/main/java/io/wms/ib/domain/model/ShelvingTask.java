package io.wms.ib.domain.model;

import io.wms.ib.domain.model.vo.ShelvingTaskItemDelegate;
import io.wms.ib.spec.ext.IbException;
import io.wms.ib.spec.model.IShelvingTask;
import io.wms.ib.spec.model.vo.IShelvingTaskItemDelegate;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 上架任务聚合根.
 */
@Slf4j
public class ShelvingTask implements IShelvingTask {

    @Getter
    private Long id;

    @Getter
    private String taskNo;

    @Getter
    private String containerNo; // 容器号

    @Getter
    private String areaNo; // 储区号

    @Getter
    private String warehouseNo; // 仓库号

    @Getter
    private Date createTime;

    // 上架任务明细，不使用java List直接放到ShelvingTask，而是单独拿一个delegate VO管理起来：这样更方便建立充血模型
    private ShelvingTaskItemDelegate itemDelegate;

    public static ShelvingTask createWith(ShelvingTaskCreator creator) throws IbException {
        log.debug("create with {}", creator);
        return new ShelvingTask(creator).validate();
    }

    // 为了保护领域模型，domain model不允许直接new
    private ShelvingTask(ShelvingTaskCreator creator) {
        this.containerNo = creator.getContainerNo();
        this.areaNo = creator.getAreaNo();
        this.warehouseNo = creator.getWarehouseNo();
        this.taskNo = creator.getTaskNo();
        this.createTime = new Date();

        this.itemDelegate = ShelvingTaskItemDelegate.createWith(creator);
    }

    private ShelvingTask validate() throws IbException {
        // TODO
        return this;
    }

    public void assignId(Object who, Long id) {
        if (!who.getClass().getSimpleName().toLowerCase().contains("repository")) {
            throw IbException.ofCode("PermissionDenied");
        }

        this.id = id;
    }

    @Override
    public IShelvingTaskItemDelegate itemDelegate() {
        return itemDelegate;
    }

    @Override
    public String label() {
        return "warehouse:" + warehouseNo;
    }
}
