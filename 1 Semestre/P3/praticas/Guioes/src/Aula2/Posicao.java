package Aula2;

class Posicao{
		
		private int x;
		private int y;
		
		public Posicao(int y, int x){
			this.y = y;
			this.x = x;
		}
		
		public int x() {
			return x;
		}
		
		public int y() {
			return y;
		}
		
		
		public String toString() { 
			return (y+1) + "," + (x+1); 
		}
		
	}