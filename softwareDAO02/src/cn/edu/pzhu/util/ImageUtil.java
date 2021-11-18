package cn.edu.pzhu.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;


public class ImageUtil {
	private BufferedImage image;
	private String answer;
	public ImageUtil() {
		Init();
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
	
	private void Init(){
		BufferedImage image = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g  = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, 80, 30);
		g.setColor(Color.red);
		
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < 10; i++) {
			int x1= random.nextInt(40);
			int y1=random.nextInt(30);
			int x2 = random.nextInt(40)+40;
			int y2 = random.nextInt(30);
			g.drawLine(x1, y1, x2, y2);
		}
		g.setColor(Color.BLACK);
		g.setFont(new Font("Times new Roman", Font.BOLD, 20));
		String answer = "";
		
		char[] eles="23456789puytrewqasdfghjkmnbvcxz".toCharArray();
		for (int i = 0; i < 4; i++) {
			answer += eles[random.nextInt(eles.length)];
		}
		g.drawString(answer, 10, 20);
		setImage(image);
		setAnswer(answer);
		
	}
	

}
