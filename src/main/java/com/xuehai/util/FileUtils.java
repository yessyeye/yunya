package com.xuehai.util;

import java.io.*;

public class FileUtils {
	public static String getContent(String filePath,String charset) {
		FileInputStream fis= null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuilder temp = new StringBuilder();
		try {
			try {
				fis = new FileInputStream(new File(filePath));
				isr = new InputStreamReader(fis, charset);
				br = new BufferedReader(isr);
				String nextline;
				while((nextline = br.readLine()) != null)
				{
					temp.append(nextline);
				}
			
			}finally{
				if(br != null)
					br.close();
				if(isr != null)
					isr.close();
				if(fis != null)
					fis.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp.toString();
	}
}

