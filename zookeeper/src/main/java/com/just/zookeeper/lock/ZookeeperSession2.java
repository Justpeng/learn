package com.just.zookeeper.lock;

import com.alibaba.fastjson.JSONObject;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.omg.CORBA.TIMEOUT;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ZookeeperSession2 {

    private static CountDownLatch connectSemaphore = new CountDownLatch(1);
    private CountDownLatch latch;

    private ZooKeeper zooKeeper;

    private String productId;

    private String waitNode;

    private String lockNode;

    private int sessionTimeout = 30000;

    private static final String lock_root = "/lockroot";

    public ZookeeperSession2(String productId) {
        this.productId = productId;
        try {
            //链接zookeeper，创建会话异步进行
            //添加监听器，告诉我们什么时候完成链接
            this.zooKeeper = new ZooKeeper("127.0.0.1:2181", 50000, new ZookeeperWatcher());
            //输出状态
            System.out.println(zooKeeper.getState());
            acquireDistributeLock();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void acquireDistributeLock() {
        try {
            if (tryLock()) {
                return;
            }else {
                waitLock(waitNode, sessionTimeout);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unLock() {
        try {
            //删除当前节点
            zooKeeper.delete(lockNode, -1);
            lockNode = null;
            zooKeeper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean tryLock() {
        try {
            String node =zooKeeper.create(lock_root + "/" + productId.getBytes(),new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL);
            List<String> locks = zooKeeper.getChildren(lock_root, false);
            Collections.sort(locks);
            //获取第一个
            if (node.equals(locks.get(0))) {
                //如果是最小的，则表示获取锁
                return true;
            }
            int preLockIndex =-1;
            //不是最小的找比自己小1的
            for (int i = 0; i < locks.size(); i++) {
                if (node.equals(lock_root + "/" + locks.get(i))) {
                    preLockIndex = i - 1;
                    break;
                }
            }
            this.waitNode = locks.get(preLockIndex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean waitLock(String waitNode,int waitTime) throws KeeperException, InterruptedException {
        Stat stat = zooKeeper.exists(lock_root + "/" + waitNode, true);
        if (stat != null) {
            this.latch = new CountDownLatch(1);
            this.latch.await(waitTime, TimeUnit.MILLISECONDS);
            this.latch = null;
        }
        return true;

    }


    public class ZookeeperWatcher implements Watcher {

        @Override
        public void process(WatchedEvent watchedEvent) {
            System.out.println("receive watcher event:" + watchedEvent.getState());
            if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                connectSemaphore.countDown();
                return;
            }
            //释放
            if (latch != null) {
                latch.countDown();
            }
        }
    }

    public static void main(String[] args) {
        String str = "\"{\\\"payType\\\":\\\"2\\\",\\\"totalFee\\\":\\\"25.0\\\",\\\"outTradeNo\\\":\\\"1324604784656830464\\\",\\\"tradeStatus\\\":\\\"success\\\",\\\"sign\\\":\\\"e6593badffd208e954a6cb74586c5807\\\",\\\"onlineFee\\\":\\\"25.0\\\",\\\"payId\\\":\\\"214076032232159873\\\",\\\"userId\\\":\\\"56585896175636\\\",\\\"channelId\\\":\\\"82\\\",\\\"rechargeId\\\":\\\"214076032232364674\\\"}\"";
        Object obj = JSONObject.parse(str);
        System.out.println(obj.toString());
    }
}
