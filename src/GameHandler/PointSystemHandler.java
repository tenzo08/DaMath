package GameHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PointSystemHandler extends JPanel{
	private Font font = new Font("Sansarif Sans", Font.BOLD, 20);
	
	private boolean whiteHasEaten;
	private char operation;
	
	private int eaten;
	private int whiteEater, blackEater;
	public int whiteTotalScore;
	public int blackTotalScore;
	
	public List<Integer> whiteScore;
	public List<Integer> blackScore;
	
	private ImageIcon white[];
	private ImageIcon black[];
	private ImageIcon whiteDama[];
	private ImageIcon blackDama[];
	
	public JLabel[] blackScoreList;
	public JLabel[] whiteScoreList;
	
	public PointSystemHandler(ImageIcon white[], ImageIcon black[], ImageIcon whiteDama[], ImageIcon blackDama[]) {
		this.white = white;
		this.black = black;
		this.whiteDama = whiteDama;
		this.blackDama = blackDama;
		
		setBounds(40, 100, 390, 520);
		setLayout(new GridLayout(15, 2));
		
		whiteScore = new ArrayList<Integer>();
		blackScore = new ArrayList<Integer>();
		
		blackScoreList = new JLabel[15];
		whiteScoreList = new JLabel[15];
		
		addTextFields();
	}
	
	private void addTextFields() {
		for(int counter = 0; counter < 15; counter++) {
			if(counter == 0) {
				whiteScoreList[counter] = new JLabel("White Score");
				add(whiteScoreList[counter]);
				blackScoreList[counter] = new JLabel("Black Score");
				add(blackScoreList[counter]);
			} else if(counter == 13) {
				whiteScoreList[counter] = new JLabel("Total Score");
				add(whiteScoreList[counter]);
				blackScoreList[counter] = new JLabel("Total Score");
				add(blackScoreList[counter]);
			} else {
				whiteScoreList[counter] = new JLabel();
				add(whiteScoreList[counter]);
				blackScoreList[counter] = new JLabel();
				add(blackScoreList[counter]);
			}
			whiteScoreList[counter].setBorder(BorderFactory.createLineBorder(Color.black, 2));
			whiteScoreList[counter].setFont(font);
			whiteScoreList[counter].setVerticalAlignment(JLabel.CENTER);
			whiteScoreList[counter].setHorizontalAlignment(JLabel.CENTER);
			blackScoreList[counter].setBorder(BorderFactory.createLineBorder(Color.black, 2));
			blackScoreList[counter].setFont(font);
			blackScoreList[counter].setVerticalAlignment(JTextField.CENTER);
			blackScoreList[counter].setHorizontalAlignment(JLabel.CENTER);
		}
	}

	public void setOperation(String operation) {
		switch(operation) {
			case "+": this.operation = '+'; break;
			case "-": this.operation = '-'; break;
			case "x": this.operation = 'x'; break;
			case "÷": this.operation = '÷'; break;
		}
	}
	
	public void setValueForEater(ImageIcon eater) {
		for(int counter = 0; counter < 12; counter++) {
			if(eater == white[counter] || eater == whiteDama[counter]) {
				whiteEater = counter;
				whiteHasEaten = true;
				break;
			}
			if(eater == black[counter] || eater == blackDama[counter]) {
				blackEater = counter;
				whiteHasEaten = false;
				break;
			}
		}
	}
	
	public void setValueForEaten(ImageIcon eater) {
		for(int counter = 0; counter < 12; counter++) {
			if(eater == white[counter] || eater == whiteDama[counter] || 
				eater == black[counter] || eater == blackDama[counter]) {
				eaten = counter;
				printScore();
				break;
			}
		}
	}

	private void printScore() {
		int score = 0;
		if(whiteHasEaten) {
			switch(operation) {
				case '+': score = whiteEater + eaten; break;
				case '-': score = whiteEater - eaten; break;
				case 'x': score = whiteEater * eaten; break;
				case '÷': if(eaten == 0) score = 0; else score = whiteEater / eaten; break;
			}
			whiteScore.add(score);
			for(int counter = 0; counter < whiteScore.size(); counter++) {
				whiteScoreList[counter + 1].setText(String.valueOf(whiteScore.get(counter)));
				whiteTotalScore += whiteScore.get(counter);
			}
			whiteScoreList[14].setText(String.valueOf(whiteTotalScore));
			whiteTotalScore = 0;
		} else {
			switch(operation) {
				case '+': score = blackEater + eaten; break;
				case '-': score = blackEater - eaten; break;
				case 'x': score = blackEater * eaten; break;
				case '÷': if(eaten == 0) score = 0; else score = blackEater / eaten; break;
			}
			blackScore.add(score);
			for(int counter = 0; counter < blackScore.size(); counter++) {
				blackScoreList[counter + 1].setText(String.valueOf(blackScore.get(counter)));
				blackTotalScore += blackScore.get(counter);
			}
			blackScoreList[14].setText(String.valueOf(blackTotalScore));
			blackTotalScore = 0;
		}
	}
	
	public void clearScore() {
		whiteScore.clear();
		blackScore.clear();
		whiteTotalScore = 0;
		blackTotalScore = 0;
		for(int counter = 0; counter < 12; counter++) {
			blackScoreList[counter + 1].setText("");
			whiteScoreList[counter + 1].setText("");
		}
		blackScoreList[14].setText("");
		whiteScoreList[14].setText("");
	}
}














