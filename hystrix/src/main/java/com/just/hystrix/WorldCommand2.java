package com.just.hystrix;

import com.netflix.hystrix.*;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Getter
@Setter
public class WorldCommand2 extends HystrixCommand<String> {
    private String name;

    public WorldCommand2(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("World"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("hello2"))
        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("helloWorldPool2"))
        .andThreadPoolPropertiesDefaults(
                HystrixThreadPoolProperties.Setter()
                        .withCoreSize(20)
                        .withQueueSizeRejectionThreshold(10)));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "hello"+name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WorldCommand2 worldCommand = new WorldCommand2("just");
        //同步
        System.out.println(worldCommand.execute());

        WorldCommand2 worldCommand2 = new WorldCommand2("just");
        //异步
        Future<String> future = worldCommand2.queue();
        System.out.println(future.get());
    }
}
