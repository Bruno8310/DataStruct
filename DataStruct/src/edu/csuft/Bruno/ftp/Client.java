package edu.csuft.Bruno.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 * 
 * @author Bruno
 *
 */
public class Client {

	public static void main(String[] args) {

		String command;

		String ip;

		int port;

		// 连接成功
		System.out.println("请输入:connect [ip] [port]连接服务器");
		System.out.println("如：connect 127.0.0.1 1000");

		// 输入一行命令，读取命令中对应字段，最后输入时存在一个换行符(会人为敲一个换行)
		Scanner sc = new Scanner(System.in);
		command = sc.next();
		ip = sc.next();
		port = sc.nextInt();
		// 读取多余的换行符
		sc.nextLine();

		System.out.printf("%s %s:%d\n", command, ip, port);

		Socket socket = null;

		if (command.equalsIgnoreCase("connect")) {
			try {
				// 连接命令正确,建立连接
				socket = new Socket(ip, port);

				// 从套接字中获得输入和输出
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();

				System.out.println("连接成功！！");
				System.out.println("dir\t获得 FTP服务文件列表");
				System.out.println("find\t根据文件名查询文件");
				System.out.println("bye\t断开与服务器的连接");
				System.out.print("请输入以上任意一个命令:");
				while (true) {
					// 接收用户命令
					command = sc.nextLine();
					if (command.equalsIgnoreCase("bye")) {
						break;
					}

					// 发送命令
					System.out.println("执行:" + command);
					command = command.toLowerCase();
					switch (command) {
					case "dir":
						sendDir(inputStream, outputStream);
						break;

					case "find":
						String key = sc.next();
						findDir(inputStream, outputStream, key);
						break;

					default:
						// 无效命令
						System.out.println("无效命令，请重新输入！！");
						break;
					}
					sc.nextLine();

					// 接收服务器响应

				}
				System.out.println("断开连接！！");

			} catch (IOException e) {
				System.out.println("连接失败！！");
			}
		} else {
			System.out.print("请输入connect命令\n");
		}

	}

	private static void findDir(InputStream inputStream, OutputStream outputStream, String key) throws IOException {
		// 发送
		String command = "find" + key;
		outputStream.write(command.getBytes());

		// 接收
		byte[] bf = new byte[1024 * 8];
		int size = inputStream.read(bf);
		String data = new String(bf, 0, size);
		System.out.println("包含关键字" + key + "的文件有：");
		System.out.println(data);

		// 切分，利用|分割符进行切分
		String[] file = data.split("\\|");
		System.out.println("文件列表：");
		for (String f : file) {
			System.out.println(f);
		}
	}

	private static void sendDir(InputStream inputStream, OutputStream outputStream) throws IOException {
		// 发送dir
		outputStream.write("dir".getBytes());
		outputStream.flush();

		// 接收文件信息列表
		byte[] bf = new byte[1024 * 8];
		int size = inputStream.read(bf);
		String data = new String(bf, 0, size);

		// 切分，利用|分割符进行切分
		String[] file = data.split("\\|");
		System.out.println("文件列表：");
		for (String f : file) {
			System.out.println(f);
		}

	}
}
