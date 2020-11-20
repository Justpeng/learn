package com.just.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixThreadPoolKey;
import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Getter
@Setter
public class WorldCommand extends HystrixCommand<String> {
    private String name;

    public WorldCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("World"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("hello"))
        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("helloWorldPool")));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "hello"+name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        WorldCommand worldCommand = new WorldCommand("just");
        //同步
        System.out.println(worldCommand.execute());

        WorldCommand worldCommand2 = new WorldCommand("just");
        //异步
        Future<String> future = worldCommand2.queue();
        System.out.println(future.get());
    }
}
