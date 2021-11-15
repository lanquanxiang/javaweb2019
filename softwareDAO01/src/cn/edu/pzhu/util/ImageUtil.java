package cn.edu.pzhu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;


public class ImageUtil {
	private BufferedImage image;
	private String answer;
	public ImageUtil() {
		//InitImage();
		InitCNImage();
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	private void InitImage(){
		BufferedImage image = new BufferedImage(80 ,30 , BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, 80, 30);
		
		graphics.setColor(Color.black);
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < 10; i++) {
			int x1 = random.nextInt(40);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(40)+40;
			int y2 = random.nextInt(30);
			graphics.drawLine(x1, y1, x2, y2);
		}	
		graphics.setFont(new Font("Times New Roman", Font.BOLD, 22));
		char[] eles="23456789qwertyupkjhgfdsazxcvbnm".toCharArray();
		
		String ans = "";
		
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(eles.length);
			ans+=eles[index];
		}
		graphics.drawString(ans, 10,20);
		
		setImage(image);
		setAnswer(ans);
	}
	
	private void InitCNImage(){
		BufferedImage image = new BufferedImage(80 ,30 , BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, 80, 30);
		
		graphics.setColor(Color.blue);
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < 10; i++) {
			int x1 = random.nextInt(40);
			int y1 = random.nextInt(30);
			int x2 = random.nextInt(40)+40;
			int y2 = random.nextInt(30);
			graphics.drawLine(x1, y1, x2, y2);
		}	
		graphics.setColor(Color.black);
		graphics.setFont(new Font("ËÎÌו", Font.BOLD, 16));
		String ans = "";
		byte[] eles = new byte[2]; 
		for (int i = 0; i < 4; i++) {
			int index = random.nextInt(3756);
			int h = Integer.valueOf("B0", 16)+index/94;
			int l = Integer.valueOf("A1", 16)+index%94;
			eles[0] = Integer.valueOf(h).byteValue();
			eles[1] = Integer.valueOf(l).byteValue();
			try {
				ans+= new String(eles, "GB2312");
			} catch (UnsupportedEncodingException e) {
				ans+="";
			}			
		}
		System.out.println(ans);
		graphics.drawString(ans, 10,20);
		
		setImage(image);
		setAnswer(ans);
	}
	
}
