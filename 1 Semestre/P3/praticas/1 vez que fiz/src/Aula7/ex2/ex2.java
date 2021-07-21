//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula7.ex2;

public class ex2 {
	public static void main(String[]args) {

		//will load the image and print info about it
		Bitmap image = new Bitmap("Figura.bmp");
		System.out.println(image);
		
		//copies the image
		image.guardarcopiar ("Figura_copy");
		
		//saves the image as raw
		image.salvarinicio("Figura"); 
		
		// resizes the image to 1/4 of the original image's size and saves as a bmp file
		image.saveResize("Figura_resized");
		
		// flips the image horizontally
		image.saveFlipHorizontal("Figura_Hflip");
		
		// flips the image vertically
		image.saveFlipVertical("Figura_Vflip");
	}
}
