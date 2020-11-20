package com.just.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class GetWorldsCommand extends HystrixObservableCommand<String> {

    private List<String> names;

    public GetWorldsCommand(List<String> names) {
        super(HystrixCommandGroupKey.Factory.asKey("GetWorldsCommand"));
        this.names = names;
    }

    @Override
    protected Observable<String> construct() {
        return Observable.create(subscriber -> {
            try {
                for (String name : names) {
                    subscriber.onNext("aa" + name);
                }
                subscriber.onCompleted();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        HystrixObservableCommand command = new GetWorldsCommand(list);
        Observable<String> stringObservable = command.observe();
        stringObservable.subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("done");
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onNext(String s) {
                System.out.println(s);
            }
        });
    }
}
