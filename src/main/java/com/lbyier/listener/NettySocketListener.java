package com.lbyier.listener;

import com.lbyier.collectionInfo.netty.thread.NettyServerThread;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author LByier
 *Netty——TCP/IP通信监听类（port：18080）
 * @date 2020/10/27 10:53
 */

public class NettySocketListener implements ServletContextListener {

    private NettyServerThread nettyServerThread;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String port = servletContextEvent.getServletContext().getInitParameter("socketPort");
        nettyServerThread = new NettyServerThread(Integer.parseInt(port));
        nettyServerThread.start();
        System.out.println("Project NettyServerThread Start in Port:" + port);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
