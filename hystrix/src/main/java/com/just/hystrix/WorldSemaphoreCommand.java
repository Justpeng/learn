package com.just.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Getter
@Setter
public class WorldSemaphoreCommand extends HystrixCommand<String> {

    public static Map<String,String> cityMap=new HashMap<>();

    private String name;

    static {
        cityMap.put("BJS", "北京");
        cityMap.put("SHA", "上海");
    }

    public static String getCityName(String key) {
        return cityMap.get(key);
    }

    public WorldSemaphoreCommand(String name) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("semaphore"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE))
        );
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return getCityName(name);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException{
        HystrixCommand<String> hystrixCommand = new WorldSemaphoreCommand("BJS");
        String name = hystrixCommand.execute();
        System.out.println(name);

    }
}
