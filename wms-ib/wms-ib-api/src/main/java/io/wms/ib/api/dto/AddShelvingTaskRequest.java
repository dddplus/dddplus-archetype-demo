package io.wms.ib.api.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 添加上架任务请求.
 */
@Data
@ToString
public class AddShelvingTaskRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String taskNo; // 任务编号，上游负责同一个任务的唯一性
    @NotNull
    private String containerNo; // 容器号
    @NotNull
    private String areaNo; // 储区号
    @NotNull
    private String warehouseNo; // 仓库号
    @Valid
    private List<Item> items; // 上架的商品明细

    public static class Item implements Serializable {
        private static final long serialVersionUID = 1L;

        @NotNull
        private String orderNo; // 对应的订单号
        @NotNull
        private String ownerNo; // 货主编号
        @NotNull
        private String sku; // 商品编号
        @NotNull
        private BigDecimal expectedQty; // 应上架数量
        private BigDecimal listPrice; // 标价
    }
}
