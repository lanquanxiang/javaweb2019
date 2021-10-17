package cn.edu.pzhu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

public class ImageUtil {
	private String key;
	private BufferedImage image;
	
	
	
	public ImageUtil(int width,int height,int n) {
		createImage(width, height, n);
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
		setKey(code);
		setImage(image);
	}

}
