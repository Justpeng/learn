package com.just.lambda.chapter5;

import com.just.lambda.bean.Album;
import com.just.lambda.bean.Artist;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-10-09 16:42
 **/
public class CollectorExamples {

    public void toCollectionTreeSet() {
        Stream<Integer> stream = Stream.of(1, 3, 4);
        stream.collect(Collectors.toCollection(TreeSet::new));
    }


    public Optional<Artist> biggestGroup(Stream<Artist> artistStream) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artistStream.collect(Collectors.maxBy(Comparator.comparing(getCount)));
    }

    //计算平均曲目数
    public double averageNumberOfTracks(java.util.List<Album> artistList) {
        return artistList.stream().collect(averagingInt(album -> album.getTrackList().size()));
    }

    public Map<Boolean, java.util.List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(Collectors.partitioningBy(Artist::isSolo));
    }

    public Map<Boolean, java.util.List<Artist>> bandsAndSoloRef(Stream<Artist> artists) {
        return artists.collect(Collectors.partitioningBy(artist -> artist.isSolo()));
    }

    public Map<Artist, java.util.List<Album>> albumsByArtist(Stream<Album> albumStream) {
        return albumStream.collect(Collectors.groupingBy(album -> album.getMainMusician()));
    }

    public String getArtistNames(java.util.List<Artist> artists) {
        return artists.stream().map(Artist::getName)
                .collect(Collectors.joining(",","[","]"));
    }

    //每个艺术家的专辑数
    public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician,counting()));
    }

    //使用收集器 求每个艺术家的专辑名
    public Map<Artist, java.util.List<String>> nameOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician, mapping(Album::getName, toList())));
    }



}
