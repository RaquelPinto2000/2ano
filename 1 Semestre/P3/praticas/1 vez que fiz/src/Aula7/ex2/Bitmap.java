//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula7.ex2;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;
import static java.lang.System.*;

public class Bitmap {
	private BitmapFileHeader bitmapFileHeader;
	private BitmapInfoHeader bitmapInfoHeader;
	byte[] rgbQuad; // color pallete – opcional (ver abaixo)
	byte[] data; // pixel data
	private String name;
	private Pixel[][] pixels;
	
	public Bitmap(File file) {
		this(file.getAbsolutePath());
	}
	
	public Bitmap(String path) {
		try {
			RandomAccessFile file=new RandomAccessFile(path,"r");
			this.name = path.split("\\.")[0];
			
			//ler informacao imagem
			bitmapFileHeader = new BitmapFileHeader(Short.reverseBytes(file.readShort()),
					Integer.reverseBytes(file.readInt()), Short.reverseBytes(file.readShort()),
					Short.reverseBytes(file.readShort()), Integer.reverseBytes(file.readInt()));
			
			bitmapInfoHeader = new BitmapInfoHeader(Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()), Integer.reverseBytes(file.readInt()),
					Short.reverseBytes(file.readShort()), Short.reverseBytes(file.readShort()),
					Integer.reverseBytes(file.readInt()), Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()), Integer.reverseBytes(file.readInt()),
					Integer.reverseBytes(file.readInt()), Integer.reverseBytes(file.readInt()));
			
			
			if(bitmapInfoHeader.bitCount<16) {
				out.print("Este programa não suporta uma contagem inferior a 16 bits");
				exit(0);
			}
			
			int byteData = (int)file.length()-bitmapFileHeader.offBits;
			data = new byte[byteData];
			file.read(data);
			file.close();
			
			pixels = byteToPixelArray(data,Math.abs(bitmapInfoHeader.height),Math.abs(bitmapInfoHeader.width));
			
			
		}catch(Exception e) {
			out.print("Ficheiro nao lido");
		}
	}
	
	public void guardarcopiar (String nome) {
		esq(pixelToByteArray(pixels),nome+".bmp",bitmapInfoHeader.height,bitmapInfoHeader.width,bitmapFileHeader.size);
	}
	
	public void salvarinicio(String nome) {
		esq(pixelToByteArray(pixels),nome+".raw",bitmapInfoHeader.height,bitmapInfoHeader.width,bitmapFileHeader.size-bitmapFileHeader.offBits);
	}
	
	public void saveResize(String nome) {
		int width = Math.abs(bitmapInfoHeader.width);
		int heigth =Math.abs(bitmapInfoHeader.height);
		
		int newWidth = (int) width/2;
		int newHeight = (int) heigth/2;
		esq(pixelToByteArray(diminuir(pixels)),nome+".bmp",newHeight,newWidth,bitmapFileHeader.size/4);
	}
	
	public static Bitmap resize(Bitmap bmp) {
		bmp.pixels = diminuir(bmp.pixels);
		bmp.bitmapInfoHeader.width = bmp.bitmapInfoHeader.width/2;
		bmp.bitmapInfoHeader.height = bmp.bitmapInfoHeader.height/2;
		bmp.data= Bitmap.pixelToByteArray(bmp.pixels);
		return bmp;
	}
	
	public static Pixel [][] diminuir(Pixel[][] pixel) {
		Pixel[][] novapixel = new Pixel[pixel.length/2][pixel[0].length/2];
		int pixelXX=0;
		int pixelYY=0;
		for(int y=0;y<pixel.length/2;y++) {
			for(int x=0;x<pixel[0].length/2;x++) {
				novapixel[y][x] = pixel[pixelYY][pixelXX];
				pixelXX+=2;
			}
			pixelXX=0;
			pixelYY+=2;
		}
		return novapixel;
	}
	public void saveFlipHorizontal(String nome) {
		esq(pixelToByteArray(flipHorizontal(pixels)),nome+".bmp",bitmapInfoHeader.height,bitmapInfoHeader.width,bitmapFileHeader.size);		
	}
	
	public static Bitmap flipHorizontal(File file) {
		return flipHorizontal(new Bitmap(file));
	}
	
	public static byte[] flipHorizontal(byte[] byteArray, int height, int width) {
		return pixelToByteArray(flipHorizontal(byteToPixelArray(byteArray,height,width)));
	}
	
	public static Bitmap flipHorizontal(Bitmap bmp) {
		bmp.pixels = flipHorizontal(bmp.pixels);
		bmp.data = Bitmap.pixelToByteArray(bmp.pixels);
		return bmp;
	}
	
	private static Pixel[][] flipHorizontal(Pixel[][] pixelData){
		Pixel[][] newPixelData = new Pixel[pixelData.length][pixelData[0].length];
		for(int y = 0; y < pixelData.length; y++) {
			for(int x = 0; x < pixelData[0].length; x++) {
				newPixelData[y][x] = pixelData[pixelData.length-y-1][x];
			}
		}
		return newPixelData;
	}
	
	public void saveFlipVertical(String newName) {
		esq(pixelToByteArray(flipVertical(pixels)),newName+".bmp",bitmapInfoHeader.height,bitmapInfoHeader.width,bitmapFileHeader.size);
	}
	

	public static Bitmap flipVertical(Bitmap bmp) {
		bmp.pixels = flipHorizontal(flipVertical(flipHorizontal(bmp.pixels)));
		bmp.data = Bitmap.pixelToByteArray(bmp.pixels);
		return bmp;
	}
	
	private static Pixel[][] flipVertical(Pixel[][] pixelData){
		Pixel[][] newPixelData = new Pixel[pixelData.length][pixelData[0].length];
		
		for(int y = 0; y < pixelData.length; y++) {
			for(int x = 0; x < pixelData[0].length; x++) {
				newPixelData[y][x] = pixelData[y][pixelData[0].length-x-1];
			}
		}
		
		return newPixelData;
	}
	
	private static byte[] pixelToByteArray(Pixel[][] pixelArray) {
		byte[] retVal = new byte[pixelArray.length * pixelArray[0].length * 3];
		//pixelArray.length => height
		//pixelArray[0].length => width
		
		int i = 0;
		for(int y = 0; y < pixelArray.length; y++) {
			for(int x = 0; x < pixelArray[0].length; x++) {
				retVal[i++] = pixelArray[y][x].B;
				retVal[i++] = pixelArray[y][x].G;
				retVal[i++] = pixelArray[y][x].R;
			}
		}
		return retVal;
	}
	
	
	
	public void esq(byte[] byteArray, String newFileName, int height, int width, int size) {
		esq(this,byteArray,newFileName,height,width,size);
	}
	
	public static void esq(Bitmap bmp, byte[] byteArray, String newFileName, int height, int width, int size) {
		try {
			RandomAccessFile newFile = new RandomAccessFile(newFileName, "rw");
	        newFile.writeShort(Short.reverseBytes(bmp.bitmapFileHeader.type));
	        newFile.writeInt(Integer.reverseBytes(size));
	        newFile.writeShort(Short.reverseBytes(bmp.bitmapFileHeader.reserved1));
	        newFile.writeShort(Short.reverseBytes(bmp.bitmapFileHeader.reserved2));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapFileHeader.offBits));
	        
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.size));
	        newFile.writeInt(Integer.reverseBytes(width));
	        newFile.writeInt(Integer.reverseBytes(-Math.abs(height))); //because the pixel data is stored upside down
	        newFile.writeShort(Short.reverseBytes(bmp.bitmapInfoHeader.planes));
	        newFile.writeShort(Short.reverseBytes(bmp.bitmapInfoHeader.bitCount));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.compression));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.sizeImage));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.xPelsPerMeter));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.yPelsPerMeter));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.clrUsed));
	        newFile.writeInt(Integer.reverseBytes(bmp.bitmapInfoHeader.clrImportant));
        
        	newFile.write(byteArray);
            newFile.close();
        }catch(Exception e) {
        	out.println("Nao e possivel guardar o arquivo");
        	exit(1);
        }
		
	}
	
	private static Pixel[][] byteToPixelArray(byte[] data, int height, int width) {
		Pixel[][] newPixels = new Pixel[height][width];
		int i = 0;
		for(int y = 0; y < newPixels.length; y++) {
			for(int x = 0; x < newPixels[0].length; x++) {
				newPixels[y][x] = new Pixel(data[i++],data[i++],data[i++]);
			}
		}
		return newPixels;
	}

	public int width() {
		return Math.abs(bitmapInfoHeader.width);
	}
	
	public int height() {
		return Math.abs(bitmapInfoHeader.height);
	}
	
	public byte[] data() {
		return data;
	}
	
	public int offBits() {
		return bitmapFileHeader.offBits;
	}
	
	public String name() {
		return name;
	}
	
	@Override
	public String toString() {
		return String.format("** Informacao sobre '%s' **\n\n"
							+"%s\n"
							+"%s\n"
							,name,bitmapFileHeader,bitmapInfoHeader);
	}
	
}
