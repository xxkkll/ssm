
package com.lbyier.equipment.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;


/**
 * @author LByier
 * @date 2020/10/26 16:38
 */


@Component
public class ChildChannelHandler extends ChannelInitializer<SocketChannel>{


/* *methodName: initChannel
 * @Description: 初始化通道 将handler放入handl
   * @param socketChannel
 * @return void
 * @author: bier
 * @date 2020/10/26 16:43
 *
 */


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new EchoServerHandler());
    }
}

