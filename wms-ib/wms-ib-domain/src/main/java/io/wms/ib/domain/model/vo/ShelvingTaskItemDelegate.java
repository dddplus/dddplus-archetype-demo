package io.wms.ib.domain.model.vo;

import io.wms.ib.domain.model.ShelvingTaskCreator;
import io.wms.ib.spec.model.vo.IShelvingTaskItem;
import io.wms.ib.spec.model.vo.IShelvingTaskItemDelegate;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 上架任务明细的管理器.
 */
public class ShelvingTaskItemDelegate implements IShelvingTaskItemDelegate {

    private List<ShelvingTaskItem> items;

    public static ShelvingTaskItemDelegate createWith(ShelvingTaskCreator creator) {
        return new ShelvingTaskItemDelegate(creator);
    }

    private ShelvingTaskItemDelegate(ShelvingTaskCreator creator) {
        this.items = new ArrayList<>(creator.getItems().size());
        for (ShelvingTaskCreator.Item item : creator.getItems()) {
            ShelvingTaskItem taskItem = new ShelvingTaskItem();
            taskItem.setSku(item.getSku());
            taskItem.setExpectedQty(item.getExpectedQty());
            taskItem.setListPrice(item.getListPrice());
            taskItem.setOrderNo(item.getOrderNo());
            taskItem.setOwnerNo(item.getOwnerNo());

            this.items.add(taskItem);
        }
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public List<? extends IShelvingTaskItem> items() {
        return items;
    }
}
