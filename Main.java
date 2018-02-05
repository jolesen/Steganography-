import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Main{
	
	/* 得到图片的第一个像素的RGB
	public static void main(String... args) throws IOException{
		BufferedImage image = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop\\Rem_secret.png"));
		System.out.println(new Color(image.getRGB(0, 0)).toString());
	}
	*/
	
	/*
	 * 将图片的红色提取出来，然后每30个像素亮度降低一个，会发现肉眼看不出多少变化
	private static void  putPixel(BufferedImage image, int widthStart, int height, int rgb) {
		for (int h = 0; h < height; h++){
			for (int i = 0;i <30; i++)
				image.setRGB(widthStart + i, h, rgb);
		}
	}
	
	
	public static void main(String... args)throws IOException {
		int width = 30, height = 30;
		BufferedImage img = new BufferedImage(width * 10, height, BufferedImage.TYPE_INT_RGB);
		int r = 255, g =0, b = 0;
		for (int i = 0; i < 10; i++){
			putPixel(img, i * 30, height, new Color(r - i,g,b).getRGB());
		}
		ImageIO.write(img, "png", new File("C:\\Users\\Lenovo\\Desktop\\Rem_secret.png"));
	}
	
	*/
	
	//从图片中将每个像素的最低为都出来，得到一个二维码，二维码是隐藏起来的
	public static void main(String... args) throws IOException{
		BufferedImage secretImg = ImageIO.read(new File("C:\\Users\\Lenovo\\Desktop\\Rem_secret.png"));
		
		for(int w = 0; w < secretImg.getWidth(); w++)
			for(int h = 0;h < secretImg.getHeight();h++){
				int lsb = new Color(secretImg.getRGB(w,h)).getRed() % 2; //取最低为，或者& 1
				secretImg.setRGB(w, h, (lsb == 0 ? new Color(0,0,0) : new Color(255,255,255)).getRGB());
			}
		ImageIO.write(secretImg,"png",new File("C:\\Users\\Lenovo\\Desktop\\Rem_secret1.png"));
	}
	
	
	
}


