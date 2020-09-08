package com.just.netty.demo;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-09 11:40
 **/
public class EchoServerHandler extends ChannelHandlerAdapter {

    private int counter = 0;

    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        /**
         * 基于分隔符
         */
//        String body = (String) msg;
//        System.out.println("This is " + ++counter + " times receive client:[" + body + "]");
//        body += "$_";
//        ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
//        ctx.writeAndFlush(echo);

        /**
         * 基于定长
         */
        System.out.println("Receive client:[" + msg + "]");

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
