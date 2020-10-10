package com.just.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpServer2 {
    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup parentGroup = new NioEventLoopGroup();
        NioEventLoopGroup childGroup = new NioEventLoopGroup();
        try {
            serverBootstrap.group(parentGroup, childGroup)
                    //指定创建的socket类型
                    .channel(NioServerSocketChannel.class)
//                    //处理链接
//                    .option()
//                    //处理IO
//                    .childOption()
                    //添加属性 在 NioEventLoopGroup 的处理其中可用
                    .attr(AttributeKey.valueOf("depart"),"市场部")
                    .childAttr(AttributeKey.valueOf("number"),50)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) {
                            //获取pipeline不是创建
                            ChannelPipeline pipeline = ch.pipeline();
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new StringEncoder());
                            pipeline.addLast(new HttpHandler());
                            Attribute attribute = ch.attr(AttributeKey.valueOf("depart"));
                            attribute.get();
                        }
                    });

            ChannelFuture channelFuture = serverBootstrap.bind(8223).sync();
            System.out.println("服务已启动");
            //关闭服务
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            log.error("出现异常", e);
        } finally {
            parentGroup.shutdownGracefully();
            childGroup.shutdownGracefully();
        }

        Thread thread = new Thread();
        thread.start();

    }
}
