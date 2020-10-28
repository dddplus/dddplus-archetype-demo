package io.wms.ib.domain.service;

import io.github.dddplus.annotation.DomainService;
import io.github.dddplus.model.IDomainService;
import io.wms.ib.domain.CoreDomain;
import io.wms.ib.domain.facade.repository.IShelvingTaskRepository;
import io.wms.ib.domain.model.ShelvingTask;

import javax.annotation.Resource;

@DomainService(domain = CoreDomain.CODE)
public class ShelvingTaskService implements IDomainService {

    @Resource
    private IShelvingTaskRepository shelvingTaskRepository;

    public void addTask(ShelvingTask task) {

    }
}
