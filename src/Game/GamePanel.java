package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	private Dimension dimension = new Dimension(1120, 720);
	private Font font = new Font("Sansarif Sans", Font.BOLD, 30);
	
	public BoardPanel boardPanel;
	
	private JButton resetButton, startButton;
	public JButton exitButton;
	public JLabel whoseTurnLabel;
	public JLabel timerLabel;
	
	private Thread timer, whoseTurn;
	
	public boolean running = true;
	
	private int minutes = 20, seconds = 0;
	
	public GamePanel() {
		setLayout(null);
		setPanelSize();
		
		boardPanel = new BoardPanel();
		add(boardPanel);
	
		add(boardPanel.chipMove.pointSystemHandler);
		
		timerLabel = new JLabel(minutes + " : 0" + seconds);
		timerLabel.setBounds(240, 40, 190, 50);
		timerLabel.setFont(font);
		timerLabel.setVerticalAlignment(JLabel.CENTER);
		timerLabel.setHorizontalAlignment(JLabel.CENTER);
		timerLabel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		add(timerLabel);
		
		whoseTurnLabel = new JLabel("Player Turn");
		whoseTurnLabel.setBounds(40, 40, 190, 50);
		whoseTurnLabel.setFont(font);
		whoseTurnLabel.setVerticalAlignment(JLabel.CENTER);
		whoseTurnLabel.setHorizontalAlignment(JLabel.CENTER);
		whoseTurnLabel.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		add(whoseTurnLabel);
		
		exitButton = new JButton("Exit");
		exitButton.setFont(font);
		exitButton.setBounds(310, 630, 120, 50);
		add(exitButton);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(font);
		resetButton.setBounds(175, 630, 120, 50);
		resetButton.addActionListener(e -> {
			running = false;
			whoseTurnLabel.setText("Player Turn");
			timerLabel.setText("20 : 00");
			
			boardPanel.chipMove.pointSystemHandler.clearScore();
			
			for(int height = 0; height < 8; height++) {
				for(int width = 0; width < 8; width++) {
					if((height + width) % 2 == 0) {
						boardPanel.chipMove.removeChip(boardPanel.boardBoxes[height][width], height, width);
						boardPanel.chipMove.boxReset(height, width);
					}
					boardPanel.chipMove.condition.whiteTurn = true;
					boardPanel.setPieces();
					boardPanel.chipMove.startGame = false;
				}
			}
		});
		add(resetButton);
		
		startButton = new JButton("Start");
		startButton.setBounds(40, 630, 120, 50);
		startButton.setFont(font);
		startButton.addActionListener(e -> {
			if(!running) {
				minutes = 20;
				seconds = 0;
				running = true;
				boardPanel.chipMove.startGame = true;
				boardPanel.chipMove.condition.showTheMovesPossible(boardPanel.chipMove.condition.whiteTurn);
			}
		});
		add(startButton);
		
		setTimer();
		setWhoseTurn();
	}

	private void setPanelSize() {
		setMinimumSize(dimension);
		setPreferredSize(dimension);
		setMaximumSize(dimension);
	}
	
	private void setTimer() {
		timer = new  Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						if(running) {
							if(seconds == 0 && minutes < 10) {
								timerLabel.setText("0" + minutes + " : 0" + seconds);
								minutes--;
								seconds = 59;
							} else if(seconds == 0 && minutes >= 10) {
								timerLabel.setText(minutes + " : 0" + seconds);
								minutes--;
								seconds = 59;
							}else if(seconds < 10 && minutes < 10) {
								timerLabel.setText("0" + minutes + " : 0" + seconds);
								seconds--;
							} else if(seconds < 10 && minutes > 10) {
								timerLabel.setText(minutes + " : 0" + seconds);
								seconds--;
							} else {
								timerLabel.setText(minutes + " : " + seconds);
								seconds--;
							} if(minutes == 0 && seconds == 0) {
								for(int counter = 0; counter < boardPanel.chipMove.pointSystemHandler.whiteScore.size(); counter++) {
									boardPanel.chipMove.pointSystemHandler.whiteScoreList[counter + 1].setText(String.valueOf(boardPanel.chipMove.pointSystemHandler.whiteScore.get(counter)));
									boardPanel.chipMove.pointSystemHandler.whiteTotalScore += boardPanel.chipMove.pointSystemHandler.whiteScore.get(counter);
								}
								for(int counter = 0; counter < boardPanel.chipMove.pointSystemHandler.blackScore.size(); counter++) {
									boardPanel.chipMove.pointSystemHandler.blackScoreList[counter + 1].setText(String.valueOf(boardPanel.chipMove.pointSystemHandler.blackScore.get(counter)));
									boardPanel.chipMove.pointSystemHandler.blackTotalScore += boardPanel.chipMove.pointSystemHandler.blackScore.get(counter);
								}
								
								if(boardPanel.chipMove.pointSystemHandler.whiteTotalScore == boardPanel.chipMove.pointSystemHandler.blackTotalScore) {
									System.out.println("Game is tied!!");
								} else if(boardPanel.chipMove.pointSystemHandler.whiteTotalScore > boardPanel.chipMove.pointSystemHandler.blackTotalScore){
									System.out.println("White is the Winner!!");
								} else {
									System.out.println("Black is the Winner!!");
								}
								
								running = false;
								whoseTurnLabel.setText("Player Turn");
								timerLabel.setText("20 : 00");
								
								boardPanel.chipMove.pointSystemHandler.clearScore();
								
								for(int height = 0; height < 8; height++) {
									for(int width = 0; width < 8; width++) {
										if((height + width) % 2 == 0) {
											boardPanel.chipMove.removeChip(boardPanel.boardBoxes[height][width], height, width);
											boardPanel.chipMove.boxReset(height, width);
										}
										boardPanel.chipMove.condition.whiteTurn = true;
										boardPanel.setPieces();
										boardPanel.chipMove.startGame = false;
									}
								}
							}
						}
						Thread.sleep(1000);
					} catch (InterruptedException e) {}
				}
			}
		});
		timer.setDaemon(true);
		timer.start();
		running = false;
	}
	private void setWhoseTurn() {
		whoseTurn = new  Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1);
						if(running) {
							if(boardPanel.chipMove.condition.whiteTurn) {
								whoseTurnLabel.setText("White Turn");
							} else {whoseTurnLabel.setText("Black Turn");}
						}
					} catch (InterruptedException e) {}
				}
			}
		});
		whoseTurn.setDaemon(true);
		whoseTurn.start();
		running = false;
		
	}
}
