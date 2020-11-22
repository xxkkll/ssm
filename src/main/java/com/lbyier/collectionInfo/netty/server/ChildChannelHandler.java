
package com.lbyier.collectionInfo.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


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
    protected void initChannel(SocketChannel ch) throws Exception {


        //添加自定义的业务逻辑
        ch.pipeline().addLast(new EchoServerHandler());
        //超时检测handler
        ch.pipeline().addLast(new IdleStateHandler(3,0,0,TimeUnit.SECONDS));
        //添加日志
        ch.pipeline().addLast("logging", new LoggingHandler(LogLevel.INFO));
    }
}

