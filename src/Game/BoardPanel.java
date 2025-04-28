package Game;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import GameHandler.ChipMove;

public class BoardPanel extends JPanel{
	
	private final int MAX_HEIGHT = 8;
	private final int MAX_WIDTH = 8;
	private final int MAX_CHIPS = 12;
	
	public ImageIcon[] white;
	public ImageIcon[] black;
	public ImageIcon[] whiteDama;
	public ImageIcon[] blackDama;
	
	public BoardBoxes[][] boardBoxes;
	public ChipMove chipMove;
	
	public BoardPanel() {
		setBounds(440, 40, 640, 640);
		setLayout(new GridLayout(MAX_HEIGHT, MAX_WIDTH));
		
		boardBoxes = new BoardBoxes[MAX_HEIGHT][MAX_WIDTH];
		
		setBoardBoxes(boardBoxes);
		setImages();
		setPieces();
		
		chipMove = new ChipMove(boardBoxes, white, black, whiteDama, blackDama);
	}

	public void setPieces() {
		
		int counterForBlack = 11;
		int counterForWhite = 0;
		
		/*
		boardBoxes[2][0].setText("");
		boardBoxes[2][0].setIcon(white[counterForWhite]);
		boardBoxes[2][0].setHasChip(true);
		boardBoxes[2][0].setHasWhite(true);
		boardBoxes[2][0].setBoxIcon(white[counterForWhite]);
		
		boardBoxes[1][1].setText("");
		boardBoxes[1][1].setIcon(black[counterForWhite]);
		boardBoxes[1][1].setHasChip(true);
		boardBoxes[1][1].setHasBlack(true);
		boardBoxes[1][1].setBoxIcon(black[counterForWhite]);
		/*
		boardBoxes[6][4].setText("");
		boardBoxes[6][4].setIcon(black[counterForWhite]);
		boardBoxes[6][4].setHasChip(true);
		boardBoxes[6][4].setHasBlack(true);
		boardBoxes[6][4].setBoxIcon(black[counterForWhite]);
		
		boardBoxes[1][3].setText("");
		boardBoxes[1][3].setIcon(black[counterForWhite]);
		boardBoxes[1][3].setHasChip(true);
		boardBoxes[1][3].setHasBlack(true);
		boardBoxes[1][3].setBoxIcon(black[counterForWhite]);
		*/
		
		for(int yCoordinate = 0; yCoordinate < 3; yCoordinate++) {
			for(int xCoordinate = 0; xCoordinate < MAX_WIDTH; xCoordinate += 2) {
				if(yCoordinate == 1) xCoordinate++;
				boardBoxes[yCoordinate][xCoordinate].setText("");
				boardBoxes[yCoordinate][xCoordinate].setIcon(black[counterForBlack]);
				boardBoxes[yCoordinate][xCoordinate].setHasChip(true);
				boardBoxes[yCoordinate][xCoordinate].setHasBlack(true);
				boardBoxes[yCoordinate][xCoordinate].setBoxIcon(black[counterForBlack]);
				if(yCoordinate == 1) xCoordinate--;
				counterForBlack--;
			}
		}
		
		for(int yCoordinate = 5; yCoordinate < 8; yCoordinate++) {
			for(int xCoordinate = 1; xCoordinate < MAX_WIDTH; xCoordinate += 2) {
				if(yCoordinate == 6) xCoordinate--;
				boardBoxes[yCoordinate][xCoordinate].setText("");
				boardBoxes[yCoordinate][xCoordinate].setIcon(white[counterForWhite]);
				boardBoxes[yCoordinate][xCoordinate].setHasChip(true);
				boardBoxes[yCoordinate][xCoordinate].setHasWhite(true);
				boardBoxes[yCoordinate][xCoordinate].setBoxIcon(white[counterForWhite]);
				if(yCoordinate == 6) xCoordinate++;
				counterForWhite++;
			}
		}
	}

	private void setImages() {
		white = new ImageIcon[12];
		for(int counter = 0; counter < MAX_CHIPS; counter++) {
			white[counter] = new ImageIcon(BoardPanel.class.getResource("/Pieces/white" + counter + ".png"));
		}
		
		black = new ImageIcon[12];
		for(int counter = 0; counter < MAX_CHIPS; counter++) {
			black[counter] = new ImageIcon(BoardPanel.class.getResource("/Pieces/black" + counter + ".png"));
		}
		
		whiteDama = new ImageIcon[12];
		for(int counter = 0; counter < MAX_CHIPS; counter++) {
			whiteDama[counter] = new ImageIcon(BoardPanel.class.getResource("/DamaPieces/WhiteDama" + counter + ".png"));
		}
		
		blackDama = new ImageIcon[12];
		for(int counter = 0; counter < MAX_CHIPS; counter++) {
			blackDama[counter] = new ImageIcon(BoardPanel.class.getResource("/DamaPieces/BlackDama" + counter + ".png"));
		}
	}

	public void setBoardBoxes(BoardBoxes[][] boardBoxes) {
		for(int height = 0; height < MAX_HEIGHT; height++) {
			for(int width = 0; width < MAX_WIDTH; width++) {
				boardBoxes[height][width] = new BoardBoxes(height, width);
				boardBoxes[height][width].setCoordinateX(width);
				boardBoxes[height][width].setCoordinateY(height);
				boardBoxes[height][width].addActionListener(e -> {
					for(int x = 0; x < 8; x++) {
						for(int y = 0; y < 8; y++) {
							if(e.getSource() == boardBoxes[x][y]) {
								if(chipMove.startGame) {
									chipMove.boxChecker(boardBoxes[x][y]);
								}
							}
						}
					}
				}	
				);
				add(boardBoxes[height][width]);
			}
		}
	}
}
