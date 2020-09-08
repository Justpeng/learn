package com.just.netty.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.Date;

/**
 * @description:
 * @author: Peng.Li
 * @create: 2018-06-06 17:58
 **/
public class TimeServerHandler extends ChannelHandlerAdapter {

    private int counter;

    public void channelRead(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception{
        //防止半包读写
        String body = (String) msg;
//        ByteBuf byteBuf = (ByteBuf) msg;
//        byte[] req = new byte[byteBuf.readableBytes()];
//        byteBuf.readBytes(req);
//        String body = new String(req, "UTF-8").substring(0,req.length-System.getProperty("line.separator").length());
//
        System.out.println("The time server receiver order:" + body + "; the counter is" + ++counter);

        String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
        currentTime = currentTime + System.getProperty("line.separator");

        ByteBuf resp = Unpooled.copiedBuffer(currentTime.getBytes());
        channelHandlerContext.write(resp);
    }

    public void channelReadComplete(ChannelHandlerContext context) throws Exception{
        context.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context,Throwable throwable) throws Exception{
        context.close();
    }
}
