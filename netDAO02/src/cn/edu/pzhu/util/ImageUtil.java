package cn.edu.pzhu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class ImageUtil {
	private String key;
	private BufferedImage image;
	
	
	
	public ImageUtil(int width,int height,int n) {
		createImage(width, height, n);
		//createCNImage(width, height, n);
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


	public void createImage(int width,int height,int n){
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Times new Roman", Font.BOLD, 20));
		char[] eles="23456789qwertyupkjhgfdsazxcvbnm".toCharArray();
		Random random = new Random();
		String code="";
		for (int i = 0; i < n; i++) {
			int index = random.nextInt(eles.length);
			code = code+eles[index];
		}
		g.drawString(code,width/8, height*3/4);
		g.setColor(Color.RED);
		for (int i = 0; i < 10; i++) {
			int x1 = random.nextInt(width/2);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(width/2)+width/2;
			int y2 = random.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		setKey(code);
		setImage(image);
	}
	public void createCNImage(int width,int height,int n){
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.BLACK);
		g.setFont(new Font("ËÎÌו", Font.BOLD, 16));		
		Random random = new Random();
		String code="";
		byte[] bytes = new byte[2];
		for (int i = 0; i < n; i++) {
			int index = random.nextInt(3755);
			int h = index/94 + Integer.valueOf("B0", 16);
			int l = index%94 + Integer.valueOf("A1", 16);
			bytes[0] = Integer.valueOf(h).byteValue();
			bytes[1] = Integer.valueOf(l).byteValue();
			String x = "";
			try {
				x = new String(bytes, "GB2312");
			} catch (UnsupportedEncodingException e) {				
				e.printStackTrace();
			}
			code+=x;
			
		}
		System.out.println(code);
		g.drawString(code,width/8, height*3/4);
		g.setColor(Color.WHITE);
		for (int i = 0; i < 10; i++) {
			int x1 = random.nextInt(width/2);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(width/2)+width/2;
			int y2 = random.nextInt(height);
			g.drawLine(x1, y1, x2, y2);
		}
		
		
		
		setKey(code);
		setImage(image);
		
	}

}
