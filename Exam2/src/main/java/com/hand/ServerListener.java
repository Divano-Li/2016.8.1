package com.hand;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
public class ServerListener extends Thread {
	@Override
	public void run() {
		//指定一个端口进行通信，一般选择12345 ，（1-6553）
		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(12345);
			//建立监听，这是一个阻塞的方法，会阻塞main线程，The method blocks until a connection is made. 
			//对于accept（） 方法，每当有一个客户端连接上，都会新建一个Socket对象。
			while(true){
				Socket socket = serverSocket.accept();
				//建立连接
				JOptionPane.showMessageDialog(null,"连接上了");
				ChatSocket cs = new ChatSocket(socket);
				cs.start();
			}
		} catch (IOException e) { 
		}

	}

}

