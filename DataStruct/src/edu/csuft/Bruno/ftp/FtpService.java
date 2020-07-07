package edu.csuft.Bruno.ftp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.jar.Attributes.Name;

public class FtpService implements Runnable {

	// 定义三个命令
	public static final String COMMAND_DIR = "dir";
	public static final String COMMAND_FIND = "find";
	public static final String COMMAND_BYE = "bye";

	private Socket clientSocket;

	private String path;

	public FtpService(Socket clientSocket, String path) {
		this.clientSocket = clientSocket;
		this.path = path;
	}
	
	@Override
	public void run() {
		try (InputStream in = clientSocket.getInputStream(); 
				OutputStream out = clientSocket.getOutputStream()) {

			String command = null;
			
			// 接收 并操作逻辑方法
			loop : while (true) {
				//接收方法返回值
				command = readCommand(in);
				//将返回值转换成小写
				command = command.toLowerCase();
				
				//dir ,byte, find xxx
				//用空格取切分
				String[] str = command.split(" ");
				command= str[0];
				//匹配
				switch (command) {
				case COMMAND_DIR:
					responseDir(out);
					break;
				case COMMAND_FIND:
					responseFind(out, str[1]);
					break;
				case COMMAND_BYE:
					//跳出死循环
					break loop;
				default:
					break;
				}
			}
			
			// 不再接收命令

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	
	/**原则：do not repeat yourself == DRY
	 * 响应find命令
	 * @param out
	 * @throws IOException 
	 */
	private void responseFind(OutputStream out, String key) throws IOException {
		
		
		File filepath = new File(path);
		File[] files = filepath.listFiles();
		
		StringBuilder sb = new StringBuilder();
		for (File f : files) {
			String fileName = f.getName();			
			//判断文件名是否包含key的字串
			if (fileName.contains(key)) {
				
				long size = f.length();
				
				Date timeDemo = new Date(f.lastModified());
				SimpleDateFormat fm = new SimpleDateFormat("yyyy/MM/dd HH:mm");
				String time = fm.format(timeDemo);
				
				String fileinfo = String.format("%s,%d,%s", fileName, size, time);
				sb.append(fileinfo);
				sb.append("|");
			}			
			
		}
		//转换为字符串
		String data = sb.toString();
		System.out.println(data);

			out.write(data.getBytes());
			
			//最后一次刷新一下缓冲
			out.flush();
	}

	/**
	 * 响应dir命令
	 * @param out
	 * @throws IOException 
	 */
	private void responseDir(OutputStream out) throws IOException {
		File filepath = new File(path);
		File[] files = filepath.listFiles();
		
		StringBuilder sb = new StringBuilder();
		for (File f : files) {
			String fileName = f.getName();
			long size = f.length();
			
			Date timeDemo = new Date(f.lastModified());
			SimpleDateFormat fm = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			String time = fm.format(timeDemo);
			
			String fileinfo = String.format("%s,%d,%s", fileName, size, time);
			sb.append(fileinfo);
			sb.append("|");
		}
		//转换为字符串
		String data = sb.toString();
		System.out.println(data);

			out.write(data.getBytes());
			
			//最后一次刷新一下缓冲
			out.flush();
		
		
	}

	/**
	 * 读命令
	 * @param in
	 * @return 
	 * @throws IOException 
	 */
	private String readCommand(InputStream in) throws IOException {
		
		//接收客户端发送的命令
		byte[] bf = new byte[64];
		int size = in.read(bf);
		
		return new String(bf, 0, size);
	}

}
