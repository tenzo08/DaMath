package Main;

import javax.swing.JFrame;

import Game.GamePanel;
import Menu.GameMenu;

public class GameFrame extends JFrame{
	private GamePanel gamePanel;
	private GameMenu menu;

	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

		menu = new GameMenu();
		gamePanel = new GamePanel();
		
		add(menu);
		
		gamePanel.exitButton.addActionListener(e -> {
			gamePanel.whoseTurnLabel.setText("Player Turn");
			gamePanel.timerLabel.setText("20 : 00");
			
			gamePanel.boardPanel.chipMove.pointSystemHandler.clearScore();
			
			for(int height = 0; height < 8; height++) {
				for(int width = 0; width < 8; width++) {
					if((height + width) % 2 == 0) {
						gamePanel.boardPanel.chipMove.removeChip(gamePanel.boardPanel.boardBoxes[height][width], height, width);
						gamePanel.boardPanel.chipMove.boxReset(height, width);
					}
					gamePanel.boardPanel.chipMove.condition.whiteTurn = true;
					gamePanel.boardPanel.setPieces();
					gamePanel.boardPanel.chipMove.startGame = false;
					gamePanel.running = false;
				}
			}

			System.out.println("exit");
			
			getContentPane().removeAll();  // <-- SAFER to clean everything
			getContentPane().add(menu);
			revalidate();
			pack();
			repaint();  // <-- optional, for extra guarantee
		});
		
		menu.startButton.addActionListener(e -> {
			getContentPane().removeAll();  // <-- SAFER to clean everything
			getContentPane().add(gamePanel);
			revalidate();
			pack();
			repaint();  // <-- optional, for extra guarantee
		});
		
		menu.exitButton.addActionListener(e -> {
			dispose();
		});
		
		pack();
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
