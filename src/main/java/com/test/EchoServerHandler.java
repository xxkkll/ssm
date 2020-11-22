//package com.test;
//
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.ChannelFutureListener;
//import io.netty.channel.ChannelHandlerContext;
//import io.netty.channel.ChannelInboundHandlerAdapter;
//import io.netty.util.CharsetUtil;
//
///**
// * @author LByier
// * @date 2020/11/10 15:16
// */
//
//public class EchoServerHandler extends ChannelInboundHandlerAdapter {
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf in = (ByteBuf) msg;
//        System.out.println("收到客户端发来的消息: " + in.toString(CharsetUtil.UTF_8));        //2
//        ctx.writeAndFlush(Unpooled.copiedBuffer("服务端发送给客户端的消息",CharsetUtil.UTF_8)) ;                      //3
//    }
//
//
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx,
//                                Throwable cause) {
//        cause.printStackTrace();                //5
//        ctx.close();                            //6
//    }
//}
