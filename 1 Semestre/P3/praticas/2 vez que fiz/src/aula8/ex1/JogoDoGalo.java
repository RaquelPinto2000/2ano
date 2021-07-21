package aula8.ex1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JogoDoGalo implements ActionListener {

	JToggleButton botao[] = new JToggleButton[9];
	private String jogar[] = new String[2];
	private int count=0; // ver se efetuou uma jogada ou nao
	public JogoDoGalo() {
		JFrame f = new JFrame("Jogo do galo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400,400); //largura,altura
		jogar[0] = "X";
		jogar[1] = "O";
		JPanel p = (JPanel) f.getContentPane();
		p.setBackground(Color.WHITE);
		p.setLayout(new GridLayout(3,3));
		//criar os botoes
		for (int i = 0; i < botao.length; i++) {
			botao[i]=new JToggleButton();
			botao[i].setFont(new Font ("Arial", Font.BOLD,50));  // tamanho dos botoes com a letra em cima do botao
			botao[i].addActionListener(this); // para ver se tem movimento ou nao
			p.add(botao[i]);
		}
		f.setVisible(true);
	}
	
	
	
	public void actionPerformed(ActionEvent evento) { // botao[i].addActionListener(this); e chamado por isto
		JToggleButton button = (JToggleButton) evento.getSource(); // o getSource() diz nos qual o botao que foi carregado
		for (int i = 0; i < botao.length; i++) {
			if(!jogoacabou()) {
				if(button == botao[i] && botao[i].getText().equals("")) {
					botao[i].setText(jogar[count]);
					if(count ==1) {
						count=0;
					}else {
						count=1;
						break;
					}
				}
			}
		}
	}
	
	// 0 1 2
	// 3 4 5 
	// 6 7 8
	
	public boolean jogoacabou() { 
		boolean jogador1=false;
		boolean jogador2=false;
		boolean empate = false;
		//getText() danos o texto associado a cada botao
		for (int i = 0; i < botao.length/3; i++) { // i<3 sao as 3 linhas ou as 3 coolunas
			//na horizantal
			if(botao[i*3].getText().equals(botao[i*3+1].getText()) && botao[i*3+1].getText().equals(botao[i*3+2].getText()) ) {
				if(botao[i*3].getText().equals("O")) {
					jogador2=true;
				}else if(botao[i*3].getText().equals("X")){
					jogador1=true;
				}
			}
			
			//vertical
			if(botao[i].getText().equals(botao[i+3].getText()) && botao[i].getText().equals(botao[i+6].getText())) {
				if(botao[i].getText().equals("O")) {
					jogador2=true;
				}else if(botao[i].getText().equals("X")){
					jogador1=true;
				}
			}
		}

		// Na diagonal para a direita 
		if(botao[0].getText().equals(botao[4].getText()) && botao[0].getText().equals(botao[8].getText())) {
			if(botao[0].getText().equals("O")) {
				jogador2=true;
			}else if(botao[0].getText().equals("X")){
				jogador1=true;
			}
		}
		
		
		// Na diagonal para a esquerda
		if(botao[6].getText().equals(botao[4].getText()) && botao[6].getText().equals(botao[2].getText())) {
			if(botao[6].getText().equals("O")) {
				jogador2=true;
			}else if(botao[6].getText().equals("X")){
				jogador1=true;
			}
		}
		
		
		//empate
		for (int i = 0; i < botao.length; i++) {
			// se os botoes forem diferentes de vazios entao e porque todos os botoes foram preenchidos com alguma coisa e como ninguem ganhou e pq houve um empate
			if(botao[i].getText().equals("")) { 
				empate=false;
				break;
			}else {
				empate=true;
				
			}
		}
		printjogo(jogador1,jogador2,empate);
		
		return false;
	}
	
	public void printjogo(boolean j1,boolean j2,boolean e) {
		if(j1) {
			JOptionPane.showMessageDialog(null,"Resultado: jogador 1 ganhou");
			System.exit(0);
		}else if(j2) {
			JOptionPane.showMessageDialog(null,"Resultado: jogador 2 ganhou");
			System.exit(0);
		}else if(e) {
			JOptionPane.showMessageDialog(null,"Resultado: Empate");
			System.exit(0);
		}
	}
	
}
