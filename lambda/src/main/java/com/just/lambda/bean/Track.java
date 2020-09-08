package com.just.lambda.bean;

import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-07-19 17:14
 **/
@Data
@Builder
public class Track {
    private String name;

    private Integer length;

    public Track(String name, Integer length) {
        this.name = name;
        this.length = length;
    }

    public Track copy() {
        return Track.builder().length(length).name(name).build();
    }

}
