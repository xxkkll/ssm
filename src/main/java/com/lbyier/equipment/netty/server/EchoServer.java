package com.lbyier.equipment.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;
/*
*
 * @author LByier
 * @date 2020/10/23 16:42
 */

@Component
public class EchoServer {


    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private Channel serverChannel;

    public EchoServer() {
        this.bossGroup = new NioEventLoopGroup();
        this.workerGroup = new NioEventLoopGroup();
    }

    private void start(int port){
        try {
            //start server
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChildChannelHandler());
            b.option(ChannelOption.SO_BACKLOG,128);
            b.childOption(ChannelOption.SO_KEEPALIVE, true);
            b.childOption(ChannelOption.TCP_NODELAY, true);
            b.childOption(ChannelOption.SO_REUSEADDR, true);
            ChannelFuture f = b.bind(port).sync();
            serverChannel = f.channel();

            //start listener
            startListener();

            System.out.println("Server start OK!");
        }catch (Exception ex){
            System.out.println("Server start error: " + ex.getMessage());
            stop();
        }
    }

    /**
     * 启动Netty监听，发送信息
     */
    private void startListener(){
        NettyListener listener = new NettyListener();
        listener.start();
    }


    private void stop(){
        if (serverChannel != null) {
            serverChannel.close();
        }
        if (workerGroup != null) {
            workerGroup.shutdownGracefully();
        }
        if (bossGroup != null) {
            bossGroup.shutdownGracefully();
        }

        System.out.println("Server is shut down");
    }

    public void doStart(){
        int port = 18080;
        try {
            start(port);
        } catch (Exception e) {
            System.out.println("Server start error: " + e.getMessage());
        }
    }


    public void doStop() {
        stop();
    }
}
