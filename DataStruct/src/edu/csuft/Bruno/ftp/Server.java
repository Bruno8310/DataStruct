package edu.csuft.Bruno.ftp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * MyFTP--服务端
 * TODO:1.读取目录内容
 * 		2.响应特定的命令
 * 
 * @author Bruno
 *
 */
public class Server {
	
	/**
	 * 文件路径
	 */
	String path = "D:\\bf\\g";
	
	/**
	 * 服务端套接字
	 */
	ServerSocket socket;
	
	/**
	 * 端口号
	 */
	int port = 1000;
	
	/**
	 *用于侦听客户端请求和做出响应
	 *
	 * 
	 */
	public void start() {
		
		try {
			socket = new ServerSocket(port);
			System.out.println("服务器启动！！");
			//接收请求，创建连接
			ExecutorService pool = Executors.newCachedThreadPool();
			System.out.println("初始化线程池");
			while(true) {
				//创建客户端套接字，接收多个请求
				Socket clientSocket = socket.accept();
				//指定一个线程去响应客户端的请求
				pool.execute(new FtpService(clientSocket, path));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
}
