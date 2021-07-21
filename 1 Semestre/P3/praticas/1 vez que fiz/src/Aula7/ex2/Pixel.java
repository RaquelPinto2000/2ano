//Raquel Resende Milheiro Pinto nºMEC = 92948
package Aula7.ex2;

public class Pixel {
	final byte R; //red
	final byte G; //green
	final byte B;//blue
	
	public Pixel(byte r, byte g, byte b) {
		R = r;
		G = g;
		B = b;
	}

	@Override
	public String toString() {
		return "Pixel [R=" + R + ", G=" + G + ", B=" + B + "]";
	}
	
	
}
