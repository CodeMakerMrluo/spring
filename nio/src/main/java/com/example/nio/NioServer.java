package com.example.nio;

import sun.nio.cs.ext.HKSCS;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.*;

/**
 * @author Administrator
 * @Title: NioServer
 * @ProjectName helloworld
 * @Description: TODO
 * @date 2018/7/9 000921:14
 */
public class NioServer {
    private static Charset charset = Charset.forName("UTF-8");
    private  static CharsetDecoder decoder = charset.newDecoder();
    public static void main(String[] args) throws Exception {

        int port = 9092;
        int threads = 3;
        ExecutorService executorService =Executors.newFixedThreadPool(3);


        // 得到一个Selector
        Selector selector = Selector.open();
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(port));

            //非阻塞
            ssc.configureBlocking(false);

            //注册
            ssc.register(selector,SelectionKey.OP_ACCEPT);

            //阻塞等待事件 就绪
            int connectionCout = 0;

            // 循环阻塞时间
            while (true) {
                int readyChannels = selector.select();
                //因为select 阻塞可以被中断
                if(readyChannels == 0) {
                    continue;
                }
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();

                    if(key.isAcceptable()){
                        ServerSocketChannel ssssc = (ServerSocketChannel)key.channel();
                        // 接受连接
                        SocketChannel cc = ssssc.accept();
                        //请selector 帮忙检测数据到了
                        //设置自己是非阻塞
                        cc.configureBlocking(false);
                        //向selector注册
                        cc.register(selector,SelectionKey.OP_READ,++connectionCout);
                    }else if(key.isConnectable()) {

                    }else if(key.isReadable()) {
                        // 读数据进行处理
                        // 交给线程池处理
                        executorService.execute(new SocketReadProcess(key));
                        // 取消一下注册 防止线程池处理来不及时 没有注销
                        key.cancel();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class  SocketReadProcess implements Runnable{
        SelectionKey key ;

        public SocketReadProcess(SelectionKey key) {
            super();
            this.key = key;
        }

        @Override
        public void run() {
            //如果连接不需要了 就关闭
            try {
                System.out.println("连接" + key.attachment() + " 发来" + readFromChannel());

                key.channel().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String readFromChannel() throws IOException {
            SocketChannel sc = (SocketChannel) key.channel();

            int bfsize = 1024;
            ByteBuffer rbf = ByteBuffer.allocateDirect(bfsize);
            // 定义一个更大的buffer
            ByteBuffer bigBuffer = null;
            // 读的次数计数
            int count = 0;
            while (sc.read (rbf) != -1) {

                count ++ ;
                ByteBuffer temp = ByteBuffer.allocateDirect(bfsize * (count + 1));
                if(bigBuffer != null) {
                    // flip 将buffer 由写转为读模式
                    bigBuffer.flip();
                    temp.put(bigBuffer);
                }
                bigBuffer = temp;

                //将这次读取到的数据放入bugbuffer
                rbf.flip();
                bigBuffer.put(rbf);
                // 为下次读 清理
                rbf.clear();
                //读出来的是字节 ，要转为字符
            }
            if (bigBuffer != null) {
                bigBuffer.flip();
                return decoder.decode(bigBuffer).toString();


            }
            return  null;
        }
    }
}
