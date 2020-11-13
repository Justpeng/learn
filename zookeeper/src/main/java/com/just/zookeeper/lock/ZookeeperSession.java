package com.just.zookeeper.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ZookeeperSession {

    private static CountDownLatch connectSemaphore = new CountDownLatch(1);
    private CountDownLatch latch;

    private ZooKeeper zooKeeper;

    public ZookeeperSession() {
        try {
            //链接zookeeper，创建会话异步进行
            //添加监听器，告诉我们什么时候完成链接
            this.zooKeeper = new ZooKeeper("127.0.0.1:2181", 50000, new ZookeeperWatcher());
            //输出状态
            System.out.println(zooKeeper.getState());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean acquireDistributionLock(Long productId) {
        String path = "/product.lock-" + productId;
        try {
            zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("success lock productId" + productId);
            return true;
        } catch (Exception e) {
            //报错，说明已经有了
            while (true) {
                try {
                    Stat state = zooKeeper.exists(path, true);
                    //存在
                    if (state != null) {
                        this.latch = new CountDownLatch(1);
                        //等待
                        this.latch.await(1000, TimeUnit.MILLISECONDS);
                        this.latch = null;
                    }
                    zooKeeper.create(path, "".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                } catch (Exception e1) {
                    continue;
                }
            }
        }
    }

    public class ZookeeperWatcher implements Watcher {

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println("receive watcher event:" + watchedEvent.getState());
            if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                connectSemaphore.countDown();
            }
            //释放
            if (latch != null) {
                latch.countDown();
            }
        }
    }
}
