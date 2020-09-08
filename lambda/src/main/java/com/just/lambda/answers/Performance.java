package com.just.lambda.answers;

import com.just.lambda.bean.Artist;

import java.util.stream.Stream;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-10-09 15:57
 **/
public interface Performance {
    public String getName();

    public Stream<Artist> getMusicians();
}
