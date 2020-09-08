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
public class FlightShortInfo {
    /**
     * 飞行时间
     */
    private Integer flyTime;

    /**
     * 航班号
     */
    private String flightNo;

}
