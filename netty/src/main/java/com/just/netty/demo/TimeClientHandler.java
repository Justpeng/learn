package com.just.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-06 18:59
 **/
@Slf4j
public class TimeClientHandler extends ChannelHandlerAdapter {
    private final ByteBuf firstMessage;

    private byte[] req;

    private int counter;

    public TimeClientHandler() {
        req = ("QUERY TIME ORDER"+System.getProperty("line.separator")).getBytes();
        firstMessage = Unpooled.buffer(req.length);
        firstMessage.writeBytes(req);
    }

    public void channelActive(ChannelHandlerContext context) throws Exception{
        ByteBuf message;
        for (int i = 0; i < 100; i++) {
            message = Unpooled.buffer(req.length);
            message.writeBytes(req);
            context.writeAndFlush(message);
        }
    }

    public void channelRead(ChannelHandlerContext context, Object msg) throws Exception{
//        ByteBuf byteBuf = (ByteBuf) msg;
//        byte[] req = new byte[byteBuf.readableBytes()];
//        byteBuf.readBytes(req);
//        String body = new String(req, "UTF-8");
        String body = (String) msg;
        System.out.println("now is :" + body+"；the counter is："+ ++counter);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) {
        log.error("Unexcepted exception from downstream:" + cause.getMessage());
        context.close();
    }
}
