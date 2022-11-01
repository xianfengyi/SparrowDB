package com.pioneer.sparrowdb.server;

import com.pioneer.sparrowdb.server.net.handler.SparrowChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class SparrowServer extends Thread {

    private static final int BOSS_THREAD_COUNT = 1;

    private static final int SERVER_PORT = 9093;

    private static final int CONNECT_TIMEOUT_MILLIS = 5000;

    private static final int SO_TIMEOUT = 10 * 60;

    public static void main(String[] args) {
        SparrowServer server = new SparrowServer();
        try {
            server.start();
            while (true) {
                try {
                    Thread.sleep(1000 * 300);
                } catch (Exception e) {
                    // just ignore it
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        startServer();
    }

    public void startServer() {
        // acceptor , one port => one thread
        EventLoopGroup bossGroup = new NioEventLoopGroup(BOSS_THREAD_COUNT);
        // worker
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            // 这边的childHandler是用来管理accept的
            // 由于线程间传递的是byte[],所以内存池okay
            // 只需要保证分配ByteBuf和write在同一个线程(函数)就行了
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new SparrowChannelHandler())
                    .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, CONNECT_TIMEOUT_MILLIS)
                    .option(ChannelOption.SO_TIMEOUT, SO_TIMEOUT);
            ChannelFuture channelFuture = b.bind(SERVER_PORT).sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            System.out.println("监听失败");
        }
    }
}
