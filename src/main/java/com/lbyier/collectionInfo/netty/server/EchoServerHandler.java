package com.lbyier.collectionInfo.netty.server;

import com.lbyier.collectionInfo.dao.CollectionInfoDao;
import com.lbyier.equipment.dao.EquipmentDao;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

//通道数组 保存连接通道
    public static ChannelGroup channels=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

//超时
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state()== IdleState.READER_IDLE){
                System.out.println("===服务端===(READER_IDLE 超时)");
                //检测到超时 发送心跳消息
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss SSS");
                String date = sdf.format(new Date());
                ctx.writeAndFlush(Unpooled.copiedBuffer("心跳消息："+date+"\r\n",CharsetUtil.UTF_8));



            }
        }
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx,
                            Object msg) throws Exception {

        ByteBuf in = (ByteBuf) msg;
            //转字符串
        String data = in.toString(CharsetUtil.UTF_8);
        //处理从设备获取到的数据
        String equipment_id=data.substring(0,2);
        String tem=data.substring(2,4);
        String hum=data.substring(4,6);
        System.out.println("服务器端接收到信息: " + data);
        ctx.write(data);
        this.sqlMapper(equipment_id,tem,hum);
        //关闭链路
        //ctx.close();

    }
//这一段代码导致了通道在只进行了一次读写操作就被关闭
//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
//                .addListener(ChannelFutureListener.CLOSE);
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
      ctx.close();
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        //建立连接时调用
        Channel incoming = ctx.channel();
        System.out.println("设备"+incoming.remoteAddress()+"已连接");
        channels.add(incoming);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        //连接断开时触发
        Channel incoming = ctx.channel();
        System.out.println("设备"+incoming.remoteAddress()+"已断开连接");
        channels.remove(incoming);
    }
@Override
public void channelActive(ChannelHandlerContext ctx) throws Exception {
    //建立连接时触发一次
    Channel incoming = ctx.channel();
    System.out.println("设备"+incoming.remoteAddress()+"在线");
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss SSS");
    String date = sdf.format(new Date());
    ctx.writeAndFlush(Unpooled.copiedBuffer("服务端建立时反馈的消息："+date+"\r\n",CharsetUtil.UTF_8));
}

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        //断开时调用
        Channel incoming = ctx.channel();
        System.out.println("客户端"+incoming.remoteAddress()+"掉线");

    }

    public void sqlMapper(String equipment_id,String tem, String hum) throws IOException {
        /* *methodName: sqlMapper
         * @Description: 数据写入数据库
           * @param
         * @return void
         * @author: bier
         * @date 2020/10/26 20:22
         **/

        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfigNetty.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();
        // 获取到代理对象
        CollectionInfoDao dao = session.getMapper(CollectionInfoDao.class);



        dao.addData(equipment_id,tem,hum);


        session.commit();
        // 关闭资源
        session.close();
        in.close();
    }

}
