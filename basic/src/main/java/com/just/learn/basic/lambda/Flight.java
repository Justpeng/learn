package com.just.learn.basic.lambda;

import lombok.*;

/**
 * @description:机场信息
 * @author: Peng.Li
 * @create: 2019-06-04 10:50
 **/
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    /**
     * 航班号 MU1234
     */
    private String flightNo;

    /**
     * 航司
     */
    private String airline;

    /**
     * 出发机场 PEK
     */
    private String depAirportCode;

    /**
     * 到达机场 HKG
     */
    private String arrAirportCode;

    /**
     * 飞行时间 22/min
     */
    private Integer duration;

    /**
     * 是否共享 true/false
     */
    private Boolean codeShare;
}
