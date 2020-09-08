package com.just.lambda.answers;

import com.just.lambda.bean.Artist;

import java.util.Optional;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-10-09 16:05
 **/
public class Artists {
    private java.util.List<Artist> artists;

    public Optional<Artist> getArtist(int index) {
        if (index < 0 || index >= artists.size()) {
            return Optional.empty();
        }
        return Optional.of(artists.get(index));
    }

    public String getArtistName(int index) {
        Optional<Artist> artist = getArtist(index);
        return artist.map(Artist::getName)
                .orElse("unKnow");
    }
}
