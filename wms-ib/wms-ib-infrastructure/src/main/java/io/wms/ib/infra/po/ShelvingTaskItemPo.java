package io.wms.ib.infra.po;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class ShelvingTaskItemPo {
    private Long taskId;
    private String orderNo;
    private String ownerNo;
    private String sku;
    private BigDecimal expectedQty;
    private BigDecimal listPrice;
}
