package asciiArt;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ASCIIArt {
	public static void main(String[] args){
		String fileName = args[0];
		
		double pixelVal = 0;
		
		BufferedWriter writer = null;
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(fileName));
		    File logFile = new File("output.txt");
		    writer = new BufferedWriter(new FileWriter(logFile));
		} catch (IOException e) {
			System.out.println("Couldn't find the image");
		}
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		System.out.println("width: " + width + ", height: " + height);
		
		for(int i=0; i<height; i++){
			String line = "";
			int num = 0;
			for(int j=0; j<width; j++){
				Color pixel = new Color(img.getRGB(j, i));
				pixelVal = ((pixel.getRed()*0.3) + (pixel.getBlue()*0.59) + pixel.getGreen()*0.11);
				line += addChar(pixelVal);
				num++;
			}
			try {
				writer.write(line);
				writer.newLine();
			} catch (IOException e) {
				System.out.println("ERROR occured");
			}
		}
		
	}
	
	public static String addChar(double pixelVal){
		String str = " ";
        if (pixelVal >= 240) {
            str = " ";
        } else if (pixelVal >= 210) {
            str = ".";
        } else if (pixelVal >= 180) {
            str = "*";
        } else if (pixelVal >= 140) {
            str = "0";
        } else if (pixelVal >= 100) {
            str = "%";
        } else if (pixelVal >= 50) {
            str = "#";
        } else{
        	str = "@";
        }
        return str;
	}
}
