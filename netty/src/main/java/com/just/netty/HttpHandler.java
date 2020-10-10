package com.just.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.AsciiString;

public class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private AsciiString contentType = HttpHeaderValues.TEXT_PLAIN;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
        System.out.println("class:" + fullHttpRequest.getClass().getName());
        DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                HttpResponseStatus.OK, Unpooled.wrappedBuffer("test".getBytes()));
        HttpHeaders httpHeaders = response.headers();
        httpHeaders.add(HttpHeaderNames.CONTENT_TYPE, contentType + ";charset=UTF-8");
        httpHeaders.add(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        httpHeaders.add(HttpHeaderNames.CONNECTION,HttpHeaderValues.KEEP_ALIVE);
        channelHandlerContext.write(response);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        System.out.println("channelComplete");
        super.channelReadComplete(channelHandlerContext);
        channelHandlerContext.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("exceptionCaught");
        if (null != cause) {
            cause.printStackTrace();
        }
        if (null != ctx) {
            ctx.close();
        }
    }
}
