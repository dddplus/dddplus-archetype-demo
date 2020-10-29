package io.wms.ib.infra.po;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ShelvingTaskPo {
    private Long id; // auto_increment
    private String containerNo;
    private String areaNo;
    private String warehouseNo;
    private Date createTime;
    private Boolean deleted; // 逻辑删除标记
}
