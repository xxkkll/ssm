package com.lbyier.collectionInfo.netty.thread;

import com.lbyier.collectionInfo.netty.server.EchoServer;

/**
 * @author LByier
 * @date 2020/10/27 10:57
 */

public class NettyServerThread extends Thread {
    private int port;
    private boolean _run = true;

    public NettyServerThread(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        EchoServer server = new EchoServer();
        server.doStart();

    }

    public void stopThread(boolean run){
        this._run = !run;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean is_run() {
        return _run;
    }

    public void set_run(boolean _run) {
        this._run = _run;
    }
}
