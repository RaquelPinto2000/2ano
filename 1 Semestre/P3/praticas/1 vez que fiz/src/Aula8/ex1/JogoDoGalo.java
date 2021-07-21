package Aula8.ex1;
import static java.lang.System.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class JogoDoGalo implements ActionListener {	
	//0 1 2
	//3 4 5
	//6 7 8
	JToggleButton botao[] = new JToggleButton[9];
	private String[] jogar = new String[2];
    private int count = 0; //verifica se efetuou uma jogada ou nao
	
	public JogoDoGalo() {
		JFrame frame = new JFrame("Jogo do galo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		jogar[0]="X";
		jogar[1]="O";
		JPanel content = (JPanel)frame.getContentPane();
		content.setBackground(Color.WHITE);
		content.setLayout(new GridLayout(3,3)); //janela com 3 botoes de lado e de largura
		
		//criar botoes
		for(int i=0;i<botao.length;i++) {
			botao[i]= new JToggleButton();
			botao[i].setFont(new Font("Arial", Font.BOLD, 50));
			botao[i].addActionListener(this);
			content.add(botao[i]);
		}
		frame.setVisible(true);	
	}
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		JToggleButton button = (JToggleButton) evento.getSource();
		for(int i=0;i<botao.length;i++) {
			if(!acaboujogo()) {
				if(button==botao[i] && botao[i].getText().equals("")) { //se button==botao[i] e se o botao estiver vazio
					botao[i].setText(jogar[count]); 
					if(count==1) { //ver que jogador vai jogar
						count=0;
					}else {
						count=1;
						break;
					}
				}
			}
		}
	}
	
	//0 1 2
	//3 4 5
	//6 7 8
	
	//getText() retorna uma string neste caso e X e O
	public boolean acaboujogo() {
		boolean j1=false;
		boolean j2= false;
		boolean empatar=false;
		
		//para a horizontal e a vertical
		for(int i=0;i<botao.length/3;i++) {
			// se ganhar na horizontal
			if(botao[i*3].getText().equals(botao[i*3+1].getText()) && botao[i*3].getText().equals(botao[i*3+2].getText())) {
				if(botao[i*3].getText().equals("X")) {
					j1=true;
				}
				if(botao[i*3].getText().equals("O")) {
					j2=true;
				}
			}
			// se ganhar na vertical
			if(botao[i].getText().equals(botao[i+3].getText()) && botao[i].getText().equals(botao[i+6].getText())) {
				if(botao[i].getText().equals("X")) {
					j1=true;
				}
				if(botao[i].getText().equals("O")) {
					j2=true;
				}
			}
		}
		//se ganhar para a diagonal
		if(botao[0].getText().equals(botao[4].getText()) && botao[0].getText().equals(botao[8].getText())) {
			if(botao[0].getText().equals("X")) {
				j1=true;
			}
			if(botao[0].getText().equals("O")) {
				j2=true;
			
			}	
		}
		if(botao[2].getText().equals(botao[4].getText()) && botao[2].getText().equals(botao[6].getText())) {
			if(botao[2].getText().equals("X")) {
				j1=true;
			}if(botao[2].getText().equals("O")) {
				j2=true;
			}	
		}
		for(int i=0;i<botao.length;i++) {
			if(botao[i].getText().equals("")) {
				empatar = false;
				break;
			}else {
				empatar=true;
			}
		}
	
		print(j1,j2,empatar);
		return false;
	}
	
	public void print(boolean j1, boolean j2,boolean empatar) {
		//ganhar
		if(j1) {
			JOptionPane.showMessageDialog(null, "Resultado: Venceu o jogador X");
			 exit(0);
		}
		if(j2) {	
			JOptionPane.showMessageDialog(null, "Resultado: Venceu o jogador O");
			 exit(0);
		}
		//empate
		if(empatar) {
			JOptionPane.showMessageDialog(null, "Resultado: Empate");
			 exit(0);
		}
		
	}
}
		
