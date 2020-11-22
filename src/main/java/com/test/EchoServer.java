//package com.test;
//
//import io.netty.bootstrap.ServerBootstrap;
//import io.netty.channel.ChannelFuture;
//import io.netty.channel.ChannelInitializer;
//import io.netty.channel.ChannelOption;
//import io.netty.channel.nio.NioEventLoopGroup;
//import io.netty.channel.socket.SocketChannel;
//import io.netty.channel.socket.nio.NioServerSocketChannel;
//
//import java.net.InetSocketAddress;
//
///**
// * @author LByier
// * @date 2020/11/10 15:17
// */
//
//public class EchoServer {
//    private final int port;
//
//    public EchoServer(int port) {
//        this.port = port;
//    }
//    public static void main(String[] args) throws Exception {
//
//        int port = 18080;        //1
//        new EchoServer(port).start();                //2
//    }
//
//    public void start() throws Exception {
//        NioEventLoopGroup group = new NioEventLoopGroup(); //3
//        try {
//            ServerBootstrap b = new ServerBootstrap();
//            b.group(group)                                //4
//                    .channel(NioServerSocketChannel.class)
//                    .childOption(ChannelOption.SO_KEEPALIVE, true)//5
//                    .localAddress(new InetSocketAddress(port))    //6
//                    .childHandler(new ChannelInitializer<SocketChannel>() { //7
//                        @Override
//                        public void initChannel(SocketChannel ch)
//                                throws Exception {
//                            ch.pipeline().addLast(
//                                    new EchoServerHandler());
//                        }
//                    });
//
//            ChannelFuture f = b.bind().sync();            //8
//            System.out.println(EchoServer.class.getName() + " started and listen on " + f.channel().localAddress());
//            f.channel().closeFuture().sync();            //9
//        } finally {
//            group.shutdownGracefully().sync();            //10
//        }
//    }
//}
