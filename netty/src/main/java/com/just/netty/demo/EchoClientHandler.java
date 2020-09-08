package com.just.netty.demo;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-09 11:49
 **/
public class EchoClientHandler extends ChannelHandlerAdapter {

    private int counter;

    private static final String ECHO_ERQ = "Hi, LiPeng, Welcome to Netty.$_";

    public EchoClientHandler() {

    }

    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 10; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_ERQ.getBytes()));
        }
    }

    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("This is " + ++counter + " times receiver server[" + msg + "]");
    }

    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
