package io.wms.ib;

import java.util.concurrent.CountDownLatch;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 系统启动类.
public class Bootstrap {

    public static void main(String[] args) throws Exception {
        new ClassPathXmlApplicationContext("applicationContext.xml");
        CountDownLatch latch = new CountDownLatch(1);
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
