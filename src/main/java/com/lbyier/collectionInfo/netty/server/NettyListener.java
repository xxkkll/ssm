package com.lbyier.collectionInfo.netty.server;

import java.util.concurrent.TimeUnit;

/**
 * @author LByier
 * @date 2020/10/27 11:04
 */

public class NettyListener {
    private Thread listenThread;

    public void start(){
        listenThread = new Thread(){
            @Override
            public void run() {
                try {

                    while (true){

                        TimeUnit.SECONDS.sleep(5);

                    }
                }catch (Exception ex){
                    System.out.println(String.format(
                            "Create Netty listener error %s",
                            ex.getMessage()));
                }
            }
        };
        listenThread.setDaemon(true);
        listenThread.start();
    }
}
