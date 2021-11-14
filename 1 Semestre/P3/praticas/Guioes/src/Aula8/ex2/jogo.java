package Aula8.ex2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
//import org.jdesktop.layout.GroupLayout;
public class jogo {
	
	private JLabel imageHolder = new JLabel();
	private JLabel levelHolder = new JLabel("0€");
	//Espaco da questao
	private JTextArea question = new JTextArea();
	private JScrollPane jScrollPanel = new JScrollPane();
	//botoes
	private JButton botaodesistir;
	private JButton botaoconfirmar;
	private JButton botao50;
	private JButton botaotelefonar;
	private JButton botaoajudapublico;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton opcaoA;
	private JRadioButton opcaoB;
	private JRadioButton opcaoC;
	private JRadioButton opcaoD;
	
	
	//perguntas
	private ListaPergunta Lpergunta = new ListaPergunta();
	private Pergunta nextQuestion;
	private int numQuestionsAnswered = 0;
	
	private int prizes[] = {0, 25,    50,    125,    250,   500,
			   750,   1500,  2500,  5000,   10000,
			   16000, 32000, 64000, 125000, 250000};

	public jogo() {
		
	}
	
}
