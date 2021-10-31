package cn.edu.pzhu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;




public class ImageUtil {
	private String key;
	private BufferedImage image;
	public ImageUtil(int width,int height,int n) {
		//InitImage(width, height, n);
		InitCNImage(width, height, n);
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	public void InitImage(int width,int height,int n){
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.black);
		g.setFont(new Font("Times new Roman", Font.BOLD, 22));
		
		SecureRandom random = new SecureRandom();
		char[] eles = "23456789qwertyupkjhgfdsazxcvbnmMNBVCXZASDFGHJKPUYTREWQ".toCharArray();
		String key="";
		for (int i = 0; i < n; i++) {
			key+= eles[random.nextInt(eles.length)];
		}		
		g.drawString(key, width/8, height*3/4);
		for (int i = 0; i < 10; i++) {
			int x1 = random.nextInt(width/2);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(width/2)+width/2;
			int y2 = random.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}		
		setKey(key);
		setImage(image);
	}
	
	public void InitCNImage(int width,int height,int n){
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.black);
		g.setFont(new Font("ËÎÌו", Font.BOLD, 16));
		
		SecureRandom random = new SecureRandom();
		
		String key="";
		byte[] bytes = new byte[2];
		for (int i = 0; i < n; i++) {
			int index  =random.nextInt(3755);
			int h = index/94 + Integer.valueOf("B0", 16);
			int l = index%94 + Integer.valueOf("A1",16);
			bytes[0] = Integer.valueOf(h).byteValue();
			bytes[1] = Integer.valueOf(l).byteValue();
			
			try {
				key += new String(bytes, "GB2312");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				key += "";
			}
		}		
		g.drawString(key, width/8, height*3/4);
		for (int i = 0; i < 10; i++) {
			int x1 = random.nextInt(width/2);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(width/2)+width/2;
			int y2 = random.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}	
		System.out.println(key);
		setKey(key);
		setImage(image);
	}
	
}
