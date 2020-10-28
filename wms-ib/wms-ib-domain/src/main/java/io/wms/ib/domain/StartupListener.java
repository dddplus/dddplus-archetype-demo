package io.wms.ib.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import io.github.dddplus.runtime.IStartupListener;

/**
 * DDDplus框架启动成功后的回调机制.
 */
@Component
@Slf4j
public class StartupListener implements IStartupListener {

    @Override
    public void onStartComplete() {
        log.info("DDDplus framework started!");
    }
}
