package io.wms.ib.domain.model;

import io.github.dddplus.model.IDomainModelCreator;
import lombok.Data;
import lombok.ToString;

/**
 * 领域模型的契约对象，持有业务行为所需要的数据.
 * <p>
 * <p>为了保护领域模型</p>
 */
@Data
@ToString
public class ShelvingTaskCreator implements IDomainModelCreator {
}
