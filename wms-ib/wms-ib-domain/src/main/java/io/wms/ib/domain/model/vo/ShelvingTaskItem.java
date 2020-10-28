package io.wms.ib.domain.model.vo;

import io.wms.ib.spec.model.vo.IShelvingTaskItem;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShelvingTaskItem implements IShelvingTaskItem {

    private String orderNo; // 对应的订单号

    private String ownerNo; // 货主编号

    private String sku; // 商品编号

    private BigDecimal expectedQty; // 应上架数量

    private BigDecimal listPrice; // 标价
}
