package com.sxu.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.apache.log4j.Logger;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client {
    private static final Logger LOGGER = Logger.getLogger(Client.class);
    private NioEventLoopGroup worker = new NioEventLoopGroup();
    private Channel channel;
    private Bootstrap bootstrap;

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
        client.sendData();
    }

    private void start() {
        bootstrap = new Bootstrap();
        bootstrap.group(worker)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new IdleStateHandler(0, 0, 10));
                        pipeline.addLast(new ClientHandler(Client.this));
                    }
                });
        doConnect();
    }

    protected void doConnect() {

        if (channel != null && channel.isActive()) {
            return;
        }
        ChannelFuture connect = bootstrap.connect("127.0.0.1", 8081);
        //实现监听通道连接的方法
        connect.addListener(new ChannelFutureListener() {

            public void operationComplete(ChannelFuture channelFuture) throws Exception {

                if (channelFuture.isSuccess()) {
                    channel = channelFuture.channel();
                    LOGGER.debug("连接成功");
                } else {
                    LOGGER.debug("每隔10s重连....");
                    channelFuture.channel().eventLoop().schedule(new Runnable() {
                        public void run() {
                            doConnect();
                        }
                    }, 10, TimeUnit.SECONDS);
                }
            }
        });
    }

    /**
     * 向服务端发送消息
     */
    private void sendData() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 1000; i++) {
            if (channel != null && channel.isActive()) {
                //获取一个键盘扫描器
                String nextLine = sc.nextLine();
                channel.writeAndFlush(nextLine);
            }
        }
    }
}
