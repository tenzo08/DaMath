package Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Game.BoardPanel;

public class GameMenu extends JPanel{
	private Dimension dimension = new Dimension(1120, 720);
	
	private JLabel menuBackground, menuLabel;
	public JButton startButton, exitButton;
	
	private ImageIcon menuIcon = new ImageIcon(BoardPanel.class.getResource("/Menu/menu.png"));
	
	public GameMenu() {
		setLayout(null);
		setPanelSize();
		
		menuLabel = new JLabel("Damath");
		menuLabel.setBounds(160, 150, 800, 150);
		menuLabel.setFont(new Font("Algerian", Font.PLAIN, 180));
		menuLabel.setForeground(Color.white);
		menuLabel.setHorizontalAlignment(JLabel.CENTER);
		menuLabel.setVerticalAlignment(JLabel.CENTER);
		add(menuLabel);
		
		startButton = new JButton("Start");
		startButton.setBounds(410, 400, 300, 80);
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setHorizontalAlignment(JLabel.CENTER);
		startButton.setVerticalAlignment(JLabel.CENTER);
		startButton.setFocusable(false);
		startButton.setFont(new Font("Algerian", Font.PLAIN, 50));
		startButton.setBorder(BorderFactory.createLineBorder(Color.white, 4));
		add(startButton);
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(410, 500, 300, 80);
		exitButton.setBackground(Color.black);
		exitButton.setForeground(Color.white);
		exitButton.setHorizontalAlignment(JLabel.CENTER);
		exitButton.setVerticalAlignment(JLabel.CENTER);
		exitButton.setFocusable(false);
		exitButton.setFont(new Font("Algerian", Font.PLAIN, 50));
		exitButton.setBorder(BorderFactory.createLineBorder(Color.white, 4));
		add(exitButton);
		
		menuBackground = new JLabel(menuIcon);
		menuBackground.setBounds(0, 0, 1120, 720);
		add(menuBackground);
	}

	private void setPanelSize() {
		setMinimumSize(dimension);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
	}
}
