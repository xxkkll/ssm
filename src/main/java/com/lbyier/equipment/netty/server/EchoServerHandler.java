package com.lbyier.equipment.netty.server;

import com.lbyier.equipment.dao.EquipmentDao;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;


@ChannelHandler.Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx,
                            Object msg) throws Exception {

        ByteBuf in = (ByteBuf) msg;
        System.out.println("服务器端接收到信息: " + in.toString(CharsetUtil.UTF_8));
        ctx.write(in);
        this.sqlMapper();

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER)
                .addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    public void sqlMapper() throws IOException {
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
        EquipmentDao dao = session.getMapper(EquipmentDao.class);
        // 查询所有数据

//        dao.addDate("24","90");


        session.commit();
        // 关闭资源
        session.close();
        in.close();
    }

}
