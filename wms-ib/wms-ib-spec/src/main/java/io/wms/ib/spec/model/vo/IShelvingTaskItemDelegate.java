package io.wms.ib.spec.model.vo;

import java.util.List;

public interface IShelvingTaskItemDelegate {

    List<? extends IShelvingTaskItem> items();

    int size();

}
