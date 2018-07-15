package com.example.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @author Administrator
 * @Title: BioServer
 * @ProjectName helloworld
 * @Description: TODO
 * @date 2018/7/9 000920:20
 */
public class BioServer {

    private static Charset charset = Charset.forName("UTF-8");


    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(80808);) {
            while (true) {
                Socket s = ss.accept();
                //开一个线程去处理這个连接
                new Thread(new SocketProcess(s)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static  class  SocketProcess implements  Runnable{
        Socket s;
        SocketProcess(Socket s) {
            super();
            this.s = s;
        }

        @Override
        public void run() {

        }
    }
}
