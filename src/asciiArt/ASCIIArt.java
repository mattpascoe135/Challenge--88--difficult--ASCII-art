package asciiArt;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

public class ASCIIArt {
	/**
	 * Takes a string giving the location of an image (GIF, PNG, or JPEG image 
	 * file), and converts it into ASCII text. The result is outputted into 
	 * a text file.
	 * 
	 * @param args
	 * 		filename, the filename of the image to convert into ASCII
	 * 		scale, the new scale of the image in perentage. 
	 * 			Note: 100=current size, 50=halfsize, 200=double size
	 */
	public static void main(String[] args){
		String fileName = args[0];
		
		int scale = 0;
		double pixelVal = 0;
		
		PrintWriter writer = null;
		BufferedImage img = null;
		try {
			scale = Integer.parseInt(args[1]);
		    img = ImageIO.read(new File(fileName));
		    writer = new PrintWriter("output.txt");
		} catch (IOException e) {
			System.out.println("Couldn't find the image");
		}

		//Resize the image
		int newHeight = img.getHeight()*scale/100;
		int newWidth = img.getWidth()*scale/100;
		
		BufferedImage newImg = new BufferedImage(newWidth, newHeight, 
				img.getType());
		newImg.getGraphics().drawImage(img, 0, 0, newWidth, newHeight, null);
		
		for(int i=0; i<newImg.getHeight(); i++){
			String line = "";
			for(int j=0; j<newImg.getWidth(); j++){
				Color pixel = new Color(newImg.getRGB(j, i));
				//Convert color into single rgb value
				pixelVal = ((pixel.getRed()*0.3) + (pixel.getBlue()*0.59) 
						+ pixel.getGreen()*0.11);
				line += addChar(pixelVal);
			}
			writer.println(line);		
		}
		writer.close();
		
	}
	
	/**
	 * Takes an RBG value for a pixel and returns an appropriate 
	 * ASCII character
	 * 
	 * @param pixelVal
	 * 		A single RGB value for a given pixel
	 * @return
	 * 		A corresponding ASCII symbol for the pixel
	 */
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
