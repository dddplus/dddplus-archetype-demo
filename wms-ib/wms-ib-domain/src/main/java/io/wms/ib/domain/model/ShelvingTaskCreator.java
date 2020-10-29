package io.wms.ib.domain.model;

import io.github.dddplus.model.IDomainModelCreator;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * 领域模型的契约对象，持有业务行为所需要的数据.
 * <p>
 * <p>为了保护领域模型</p>
 */
@Data
@ToString
public class ShelvingTaskCreator implements IDomainModelCreator {

    private String taskNo;

    private String containerNo; // 容器号

    private String areaNo; // 储区号

    private String warehouseNo; // 仓库号

    private List<Item> items;

    @Data
    public static class Item {
        private String orderNo; // 对应的订单号
        private String ownerNo; // 货主编号
        private String sku; // 商品编号
        private BigDecimal expectedQty; // 应上架数量
        private BigDecimal listPrice; // 标价
    }
}
