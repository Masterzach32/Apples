package net.masterzach32.apples.server

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import java.nio.channels.SocketChannel

/*
 * apples - Created on 6/21/2019
 * Author: Zach Kozar
 * 
 * This code is licensed under the GNU GPL v3
 * You can find more info in the LICENSE file at the project root.
 */

/**
 * @author Zach Kozar
 * @version 6/21/2019
 */
object Server {

    fun start(port: Int) {
        val bossGroup = NioEventLoopGroup()
        val workerGroup = NioEventLoopGroup()

        val b = ServerBootstrap().apply {
            group(bossGroup, workerGroup)
            channel(NioServerSocketChannel::class.java)
            childHandler(object : ChannelInitializer<Channel>() {
                override fun initChannel(ch: Channel) {
                    ch.pipeline().addLast()
                }
            })
            option(ChannelOption.SO_BACKLOG, 128)
            childOption(ChannelOption.SO_KEEPALIVE, true)
        }
        val f = b.bind(port).sync()

        f.channel().closeFuture().sync()
        workerGroup.shutdownGracefully()
        bossGroup.shutdownGracefully()
    }
}