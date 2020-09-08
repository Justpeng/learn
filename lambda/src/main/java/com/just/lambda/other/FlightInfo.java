package com.just.lambda.other;

import lombok.*;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2019-05-24 17:30
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightInfo {


    /**
     * 是否共享
     */
    private Boolean share;

    /**
     * 飞行时间
     */
    private Integer flyTime;

    /**
     * 航班号
     */
    private String flightNo;

    /**
     * 航司
     */
    private String airline;

    /**
     * 出发城市
     */
    private String depCity;

    /**
     * 到达城市
     */
    private String arrCity;
}
