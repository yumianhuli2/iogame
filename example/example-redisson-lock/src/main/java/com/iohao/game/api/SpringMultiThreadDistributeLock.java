package com.iohao.game.api;

import com.iohao.game.domain.entity.UserWallet;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 使用自建线程池模拟多线程环境竞争锁
 *
 * @author shen
 * @Date 2022/3/31
 * @Slogan  慢慢变好，是给自己最好的礼物
 */
@Component
public class SpringMultiThreadDistributeLock {

    @Resource
    private Consumer consumer;

    /**
     * 模拟正常的，能够执行完所有任务的lock
     */
    public void testRlock() {
        UserWallet wallet = new UserWallet();
        wallet.setUserId("10086");
        wallet.setName("中国移动");
        wallet.setBalance(BigDecimal.valueOf(100000L));
        for (int i = 0; i < 100; i++) {
            consumer.consume(wallet);
        }
    }

    /**
     * 模拟等到超时的lock
     * 以下时间默认单位：秒
     */
    public void testLockButWaitTimeOut() {
        UserWallet wallet = new UserWallet();
        wallet.setUserId("10086");
        wallet.setName("中国移动");
        wallet.setBalance(BigDecimal.valueOf(100000L));

        //等到锁时间
        long waitTime = 1L;

        //执行时间
        long leaseTime = 10L;

        for (int i = 0; i < 100; i++) {
            consumer.consumeWaitTimeout(wallet, waitTime, leaseTime);
        }
    }
}
