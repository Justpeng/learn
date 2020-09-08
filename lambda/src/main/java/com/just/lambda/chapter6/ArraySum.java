package com.just.lambda.chapter6;

import com.just.lambda.bean.Album;
import com.just.lambda.bean.Track;
import com.just.lambda.chapter1.SampleData;
import org.junit.Test;
import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.RunnerException;

import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-10-15 18:48
 **/
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class ArraySum {

    public java.util.List<Album> albums;

    public static void main(String[] ignore) throws IOException, RunnerException {
        final String[] args = {
                ".*ArraySum.*",
                "-wi",
                "5",
                "-i",
                "5"
        };
        Main.main(args);
    }

    @Setup
    public void initAlbums() {
        int n = Integer.getInteger("arraysum.size", 1000);
        albums = IntStream.range(0,n)
                .mapToObj(i->SampleData.aLoveSupreme.copy())
                .collect(Collectors.toList());
    }


    //串行化计算专辑曲目长度
    public int serialArraySum() {
        return albums.stream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }


    //并行化计算曲目长度
    public int parallelArraySum() {
        return albums.parallelStream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }
}
