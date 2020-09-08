package com.just.lambda.answers;

import com.just.lambda.bean.Artist;

import java.util.stream.Stream;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-10-09 16:00
 **/
public interface PerformanceFixed {

    public String getName();

    public Stream<Artist> getMusicians();

    public default Stream<Artist> getAllMusicians(){
        return getMusicians().flatMap(artist -> Stream.concat(Stream.of(artist), artist.getMembers()));
    };
}
