package com.just.dubbo.provider;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2019-04-26 09:51
 **/
@Path("just")
public interface DemoService {
    @POST
    @Path("queryFlightSchedule")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Consumes(MediaType.APPLICATION_JSON+ ";charset=utf-8")
    String sayHello(String name);


    }
