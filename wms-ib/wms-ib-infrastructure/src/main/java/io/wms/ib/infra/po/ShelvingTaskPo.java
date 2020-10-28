package io.wms.ib.infra.po;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
public class ShelvingTaskPo {
    private Long id; // auto_increment
    private String containerNo;
    private String areaNo;
    private String warehouseNo;
}
