package com.hand;
//此处的ChatSocket 相当于服务器，

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread{
	Socket socket;
	public ChatSocket(Socket s){
		this.socket = s;
	}
	public void run() {
		try {
			//将客户端的内容读取到服务器中，然后再通过publish方法（out方法在其中）发送给每个客户端，实现聊天的功能
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream("target.pdf"));
			BufferedOutputStream bos = new BufferedOutputStream(
										socket.getOutputStream(),100000);
					byte input2[] = new byte[10000];
					 int l2 = 0;
					 while((l2=bis.read(input2))!=-1){
						 bos.write(input2,0,l2);
					 }
					bos.close();
					bis.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	}
