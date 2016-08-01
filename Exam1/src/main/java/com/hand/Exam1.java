package com.hand;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class Exam1 {

	public static void main(String[] args) {
		new ReadByGet().start();
	}


static class ReadByGet extends Thread{
	public void run() {
	try {
		URL url = new URL("http://files.saas.hand-china.com/java/target.pdf");
		URLConnection  connection = url.openConnection();
		InputStream is2 = connection.getInputStream();
		BufferedInputStream bis2 = new BufferedInputStream(is2);
		FileOutputStream  fos2 = new FileOutputStream("target.pdf");
		BufferedOutputStream bos2 = new BufferedOutputStream(fos2,100000);
		 //大型文件对应的数组可以大一些，10KB
		 byte input2[] = new byte[10000]; 
		 int l2 = 0;
		 while((l2=bis2.read(input2))!=-1){
			 bos2.write(input2,0,l2);		 
		 }
		 bos2.close();
		 fos2.close();
		 bis2.close();
		 is2.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	}
}
}