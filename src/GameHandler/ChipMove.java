package GameHandler;

import java.awt.Color;

import javax.swing.ImageIcon;

import Game.BoardBoxes;

public class ChipMove{
	public boolean startGame = false;
	
	private Color boxActivationColor;
	
	private BoardBoxes[][] boardBoxes;
	private BoardBoxes[][] tempBoxes;
	
	ImageIcon white[];
	ImageIcon black[];
	ImageIcon whiteDama[];
	ImageIcon blackDama[];
	
	public ConditionsToBeMet condition;
	private ChipMoveForDama chipMoveForDama;
	public PointSystemHandler pointSystemHandler;

	public ChipMove(BoardBoxes[][] boardBoxes, ImageIcon white[], ImageIcon black[], ImageIcon whiteDama[], ImageIcon blackDama[]) {
		this.boardBoxes = boardBoxes;
		this.white = white;
		this.black = black;
		this.whiteDama = whiteDama;
		this.blackDama = blackDama;
		
		boxActivationColor = new Color(128, 250, 129);
		
		tempBoxes = new BoardBoxes[8][8];
		
		chipMoveForDama = new ChipMoveForDama(boardBoxes);
		
		condition = new ConditionsToBeMet(boardBoxes);
		
		pointSystemHandler = new PointSystemHandler(white, black, whiteDama, blackDama);
	}

	public void boxChecker(BoardBoxes chosenBoardBox) {
		int width = chosenBoardBox.getCoordinateX();
		int height = chosenBoardBox.getCoordinateY();
		
		if(condition.checkChipsThatShouldEat(condition.whiteTurn) && !checkActivatedChip()) {
			
			for(int counter = 0; counter < condition.shouldEatChipHeight.size(); counter++) {
				
				if(height == condition.shouldEatChipHeight.get(counter) &&
				   width == condition.shouldEatChipWidth.get(counter)) {
					
					if(condition.whiteTurn && boardBoxes[height][width].isHasWhite()) {
						
						boxActivationForEating(width, height);
						
					} else if(!condition.whiteTurn && boardBoxes[height][width].isHasBlack()) {
						
						boxActivationForEating(width, height);
					} else if(condition.whiteTurn && boardBoxes[height][width].isHasWhiteDama()) {
						
						chipMoveForDama.boxActivationForEatingDama(width, height);
					} else if(!condition.whiteTurn && boardBoxes[height][width].isHasBlackDama()) {
						
						chipMoveForDama.boxActivationForEatingDama(width, height);
					}
				}
			}
			
			condition.shouldEatChipHeight.clear();
			condition.shouldEatChipWidth.clear();
			
		} else if(!checkActivatedChip() && boardBoxes[height][width].isHasChip()) {
			if(condition.whiteTurn && boardBoxes[height][width].isHasWhite()) {
				
				boxActivation(width, height);
				
			} else if(!condition.whiteTurn && boardBoxes[height][width].isHasBlack()) {
				
				boxActivation(width, height);
				
			} else if(condition.whiteTurn && boardBoxes[height][width].isHasWhiteDama()) {
				
				chipMoveForDama.boxActivationForDama(width, height);
				
			} else if(!condition.whiteTurn && boardBoxes[height][width].isHasBlackDama()) {
				
				chipMoveForDama.boxActivationForDama(width, height);
				
			} 
		} else if(boardBoxes[height][width].isThisActivated()) {
			
			boxReset(width, height);
			condition.showTheMovesPossible(condition.whiteTurn);
			
		} else if(!boardBoxes[height][width].isHasChip() && boardBoxes[height][width].isReadyForMove()) {
			
			if(condition.checkChipsThatShouldEat(condition.whiteTurn)) {
				
				chipShouldEat(width, height);
				
				if(!condition.checkForOtherEat(height, width)) {
					
					if(height == 0) { makeADama(height, width);}
					switchTurn();
					checkForWinner();
					
				} else {
					
					condition.showTheMovesPossible(condition.whiteTurn);
					boxActivationForEating(width, height);
					
				}
				
				condition.shouldEatChipHeight.clear();
				condition.shouldEatChipWidth.clear();
				
			} else {
				
				chipShouldMove(width, height);
				if(height == 0) { makeADama(height, width);}
				switchTurn();
				checkForWinner();
			}
		}
	}

	private void boxActivationForEating(int width, int height) {
		
		boardBoxes[height][width].setThisIsActivated(true);
		boardBoxes[height][width].setChipHasToEat(true);
		
		if(boardBoxes[height][width].isHasWhite()) {
			try {
				if(!boardBoxes[height - 2][width + 2].isHasChip() && 
					(boardBoxes[height - 1][width + 1].isHasBlack() || boardBoxes[height - 1][width + 1].isHasBlackDama())) {
					
					boardBoxes[height - 2][width + 2].setBackground(boxActivationColor);
					boardBoxes[height - 2][width + 2].setReadyForMove(true);
					
				}
			} catch (IndexOutOfBoundsException e) {}
			try {
				if(!boardBoxes[height - 2][width - 2].isHasChip() && 
						(boardBoxes[height - 1][width - 1].isHasBlack() || boardBoxes[height - 1][width - 1].isHasBlackDama())) {
					
					boardBoxes[height - 2][width - 2].setBackground(boxActivationColor);
					boardBoxes[height - 2][width - 2].setReadyForMove(true);
					
				}
			} catch (IndexOutOfBoundsException e) {}
			try {
				if(!boardBoxes[height + 2][width + 2].isHasChip() && 
						(boardBoxes[height + 1][width + 1].isHasBlack() || boardBoxes[height + 1][width + 1].isHasBlackDama())) {
					
					boardBoxes[height + 2][width + 2].setBackground(boxActivationColor);
					boardBoxes[height + 2][width + 2].setReadyForMove(true);
					
				}
			} catch (IndexOutOfBoundsException e) {}
			try {
				if(!boardBoxes[height + 2][width - 2].isHasChip() && 
						(boardBoxes[height + 1][width - 1].isHasBlack() || boardBoxes[height + 1][width - 1].isHasBlackDama())) {
					
					boardBoxes[height + 2][width - 2].setBackground(boxActivationColor);
					boardBoxes[height + 2][width - 2].setReadyForMove(true);
					
				}
			} catch (IndexOutOfBoundsException e) {}
		} else if(boardBoxes[height][width].isHasBlack()) {
			try {
				if(!boardBoxes[height - 2][width + 2].isHasChip() && 
					(boardBoxes[height - 1][width + 1].isHasWhite() || boardBoxes[height - 1][width + 1].isHasWhiteDama())) {
					
					boardBoxes[height - 2][width + 2].setBackground(boxActivationColor);
					boardBoxes[height - 2][width + 2].setReadyForMove(true);
					
				}
			} catch (IndexOutOfBoundsException e) {}
			try {
				if(!boardBoxes[height - 2][width - 2].isHasChip() && 
						(boardBoxes[height - 1][width - 1].isHasWhite() || boardBoxes[height - 1][width - 1].isHasWhiteDama())) {
					
					boardBoxes[height - 2][width - 2].setBackground(boxActivationColor);
					boardBoxes[height - 2][width - 2].setReadyForMove(true);
					
				}
			} catch (IndexOutOfBoundsException e) {}
			try {
				if(!boardBoxes[height + 2][width + 2].isHasChip() && 
						(boardBoxes[height + 1][width + 1].isHasWhite() || boardBoxes[height + 1][width + 1].isHasWhiteDama())) {
					
					boardBoxes[height + 2][width + 2].setBackground(boxActivationColor);
					boardBoxes[height + 2][width + 2].setReadyForMove(true);
					
				}
			} catch (IndexOutOfBoundsException e) {}
			try {
				if(!boardBoxes[height + 2][width - 2].isHasChip() && 
						(boardBoxes[height + 1][width - 1].isHasWhite() || boardBoxes[height + 1][width - 1].isHasWhiteDama())) {
					
					boardBoxes[height + 2][width - 2].setBackground(boxActivationColor);
					boardBoxes[height + 2][width - 2].setReadyForMove(true);
					
				}
			} catch (IndexOutOfBoundsException e) {}
		}
	}

	private void boxActivation(int width, int height) {
		boardBoxes[height][width].setThisIsActivated(true);
		try {
			if(!boardBoxes[height - 1][width + 1].isHasChip()) {
	
				boardBoxes[height - 1][width + 1].setBackground(boxActivationColor);
				boardBoxes[height - 1][width + 1].setReadyForMove(true);
				
			}
		} catch (IndexOutOfBoundsException e) {}
		try {
			if(!boardBoxes[height - 1][width - 1].isHasChip()) {
				
				boardBoxes[height - 1][width - 1].setBackground(boxActivationColor);
				boardBoxes[height - 1][width - 1].setReadyForMove(true);
				
			}
		} catch (IndexOutOfBoundsException e) {}
	}
	
	public void boxReset(int width, int height) {
		boardBoxes[height][width].setThisIsActivated(false);
		try {
			int tempHeight = height - 1;
			int tempWidth = width + 1;
			while(true) {
				boardBoxes[tempHeight][tempWidth].setBackground(Color.white);
				boardBoxes[tempHeight][tempWidth].setReadyForMove(false);
				tempHeight--;
				tempWidth++;
			}
		} catch (IndexOutOfBoundsException e) {}
		try {
			int tempHeight = height - 1;
			int tempWidth = width - 1;
			while(true) {
				boardBoxes[tempHeight][tempWidth].setBackground(Color.white);
				boardBoxes[tempHeight][tempWidth].setReadyForMove(false);
				tempHeight--;
				tempWidth--;
			}
		} catch (IndexOutOfBoundsException e) {}
		try {
			int tempHeight = height + 1;
			int tempWidth = width + 1;
			while(true) {
				boardBoxes[tempHeight][tempWidth].setBackground(Color.white);
				boardBoxes[tempHeight][tempWidth].setReadyForMove(false);
				tempHeight++;
				tempWidth++;
			}
		} catch (IndexOutOfBoundsException e) {}
		try {
			int tempHeight = height + 1;
			int tempWidth = width - 1;
			while(true) {
				boardBoxes[tempHeight][tempWidth].setBackground(Color.white);
				boardBoxes[tempHeight][tempWidth].setReadyForMove(false);
				tempHeight++;
				tempWidth--;
			}
		} catch (IndexOutOfBoundsException e) {}
	}

	private boolean checkActivatedChip() {
		
		for(int height = 0; height < 8; height++) {
			
			for(int width = 0; width < 8; width++) {
				
				if(boardBoxes[height][width].isThisActivated()) {
					
					return true;
					
				}
			}
		}
		return false;
	}
	
	private void chipShouldMove(int newWidth, int newHeight) {
		
		for(int origHeight = 0; origHeight < 8; origHeight++) {
			
			for(int origWidth = 0; origWidth < 8; origWidth++) {
				
				if(boardBoxes[origHeight][origWidth].isThisActivated()) {
					
					boardBoxes[newHeight][newWidth].setText("");
					boardBoxes[newHeight][newWidth].setBoxIcon(boardBoxes[origHeight][origWidth].getBoxIcon());
					boardBoxes[newHeight][newWidth].setIcon(boardBoxes[origHeight][origWidth].getBoxIcon());
					
					changeHasWhatChip(newWidth, newHeight, origWidth, origHeight);
					boxReset(origWidth, origHeight);
					
					boardBoxes[origHeight][origWidth].setIcon(null);
					boardBoxes[origHeight][origWidth].setBoxIcon(null);
					boardBoxes[origHeight][origWidth].setOperation(origHeight, origWidth);
				}
			}
		}
	}

	private void chipShouldEat(int newWidth, int newHeight) {
		pointSystemHandler.setOperation(String.valueOf(boardBoxes[newHeight][newWidth].getText()));
		for(int origHeight = 0; origHeight < 8; origHeight++) {
			
			for(int origWidth = 0; origWidth < 8; origWidth++) {
				if((boardBoxes[origHeight][origWidth].isHasWhiteDama() || boardBoxes[origHeight][origWidth].isHasBlackDama()) &&
						boardBoxes[origHeight][origWidth].isChipHasToEat()) {
					
					chipMoveForDama.damaShouldEat(origWidth, origHeight, newWidth, newHeight);
					pointSystemHandler.setValueForEater(boardBoxes[origHeight][origWidth].getBoxIcon());
					pointSystemHandler.setValueForEaten(boardBoxes[chipMoveForDama.damaEatenY][chipMoveForDama.damaEatenX].getBoxIcon());
					removeChip(boardBoxes[chipMoveForDama.damaEatenY][chipMoveForDama.damaEatenX], 
							chipMoveForDama.damaEatenY, chipMoveForDama.damaEatenX);
					changeHasWhatChip(newWidth, newHeight, origWidth, origHeight);
					removeChip(boardBoxes[origHeight][origWidth], origHeight, origWidth);
					boxReset(origWidth, origHeight);
					
				} else if((boardBoxes[origHeight][origWidth].isHasWhite() || boardBoxes[origHeight][origWidth].isHasBlack()) &&
						boardBoxes[origHeight][origWidth].isChipHasToEat()) {
					
					boardBoxes[newHeight][newWidth].setText("");
					boardBoxes[newHeight][newWidth].setBoxIcon(boardBoxes[origHeight][origWidth].getBoxIcon());
					boardBoxes[newHeight][newWidth].setIcon(boardBoxes[origHeight][origWidth].getBoxIcon());
					pointSystemHandler.setValueForEater(boardBoxes[origHeight][origWidth].getBoxIcon());
					
					try {
						if(newHeight - origHeight == -2 && newWidth - origWidth == -2) {
							pointSystemHandler.setValueForEaten(boardBoxes[origHeight - 1][origWidth - 1].getBoxIcon());
							removeChip(boardBoxes[origHeight - 1][origWidth - 1], origHeight - 1, origWidth - 1);
						}
					} catch (IndexOutOfBoundsException e) {}
					try {
						if(newHeight - origHeight == -2 && newWidth - origWidth == 2) {
							pointSystemHandler.setValueForEaten(boardBoxes[origHeight - 1][origWidth + 1].getBoxIcon());
							removeChip(boardBoxes[origHeight - 1][origWidth + 1], origHeight - 1, origWidth + 1);
						}
					} catch (IndexOutOfBoundsException e) {}
					try {
						if(newHeight - origHeight == 2 && newWidth - origWidth == -2) {
							pointSystemHandler.setValueForEaten(boardBoxes[origHeight + 1][origWidth - 1].getBoxIcon());
							removeChip(boardBoxes[origHeight + 1][origWidth - 1], origHeight + 1, origWidth - 1);
						}
					} catch (IndexOutOfBoundsException e) {}
					try {
						if(newHeight - origHeight == 2 && newWidth - origWidth == 2) {
							pointSystemHandler.setValueForEaten(boardBoxes[origHeight + 1][origWidth + 1].getBoxIcon());
							removeChip(boardBoxes[origHeight + 1][origWidth + 1], origHeight + 1, origWidth + 1);
						}
					} catch (IndexOutOfBoundsException e) {}
					
					changeHasWhatChip(newWidth, newHeight, origWidth, origHeight);
					removeChip(boardBoxes[origHeight][origWidth], origHeight, origWidth);
					boxReset(origWidth, origHeight);
				}
			}
		}
	}
	
	public void removeChip(BoardBoxes boardBoxes, int height, int width) {
		
		boardBoxes.setIcon(null);
		boardBoxes.setBoxIcon(null);
		boardBoxes.setOperation(height, width);
		boardBoxes.setThisIsActivated(false);
		boardBoxes.setReadyForMove(false);
		boardBoxes.setChipHasToEat(false);
		boardBoxes.setChipIsDama(false);
		boardBoxes.setChipCanBeDama(false);
		boardBoxes.setHasChip(false);
		boardBoxes.setHasWhite(false);
		boardBoxes.setHasBlack(false);
		boardBoxes.setHasWhiteDama(false);
		boardBoxes.setHasBlackDama(false);
		
	}

	private void changeHasWhatChip(int newWidth, int newHeight, int origWidth, int origHeight) {
		
		boardBoxes[origHeight][origWidth].setHasChip(false);
		boardBoxes[newHeight][newWidth].setHasChip(true);
		
		if(boardBoxes[origHeight][origWidth].isHasWhite()) {
			
			boardBoxes[origHeight][origWidth].setHasWhite(false);
			boardBoxes[newHeight][newWidth].setHasWhite(true);
			
		} else if(boardBoxes[origHeight][origWidth].isHasWhiteDama()) {
			
			boardBoxes[origHeight][origWidth].setHasWhiteDama(false);
			boardBoxes[newHeight][newWidth].setHasWhiteDama(true);
			
		} else if(boardBoxes[origHeight][origWidth].isHasBlack()) {
			
			boardBoxes[origHeight][origWidth].setHasBlack(false);
			boardBoxes[newHeight][newWidth].setHasBlack(true);
			
		} else if(boardBoxes[origHeight][origWidth].isHasBlackDama()) {
			
			boardBoxes[origHeight][origWidth].setHasBlackDama(false);
			boardBoxes[newHeight][newWidth].setHasBlackDama(true);
			
		}
	}
	
	private void switchTurn() {
		int tempHeight = 0, tempWidth = 0;
		
		if(condition.whiteTurn) condition.whiteTurn = false;
		else if(!condition.whiteTurn) condition.whiteTurn = true;
		
		for(int height = 0; height < 8; height++) {
			for(int width = 0; width < 8; width++) {
				tempBoxes[height][width] = new BoardBoxes(height, width);
				tempBoxes[height][width].setIcon(boardBoxes[height][width].getIcon());
				tempBoxes[height][width].setBoxIcon(boardBoxes[height][width].getBoxIcon());
				tempBoxes[height][width].setHasChip(boardBoxes[height][width].isHasChip());
				tempBoxes[height][width].setHasWhite(boardBoxes[height][width].isHasWhite());
				tempBoxes[height][width].setHasBlack(boardBoxes[height][width].isHasBlack());
				tempBoxes[height][width].setHasWhiteDama(boardBoxes[height][width].isHasWhiteDama());
				tempBoxes[height][width].setHasBlackDama(boardBoxes[height][width].isHasBlackDama());
				
				removeChip(boardBoxes[height][width], height, width);
			}
		}
		for(int height = 7; height >= 0; height--) {
			for(int width = 7; width >= 0; width--) {
				boardBoxes[tempHeight][tempWidth].setText("");
				boardBoxes[tempHeight][tempWidth].setIcon(tempBoxes[height][width].getIcon());
				boardBoxes[tempHeight][tempWidth].setBoxIcon(tempBoxes[height][width].getBoxIcon());
				boardBoxes[tempHeight][tempWidth].setHasChip(tempBoxes[height][width].isHasChip());
				boardBoxes[tempHeight][tempWidth].setHasWhite(tempBoxes[height][width].isHasWhite());
				boardBoxes[tempHeight][tempWidth].setHasBlack(tempBoxes[height][width].isHasBlack());
				boardBoxes[tempHeight][tempWidth].setHasWhiteDama(tempBoxes[height][width].isHasWhiteDama());
				boardBoxes[tempHeight][tempWidth].setHasBlackDama(tempBoxes[height][width].isHasBlackDama());
				
				if(boardBoxes[tempHeight][tempWidth].getBoxIcon() == null) {
					boardBoxes[tempHeight][tempWidth].setOperation(tempHeight, tempWidth);
				}
				
				removeChip(tempBoxes[height][width], height, width);
				tempBoxes[height][width].setText("");
				
				tempWidth++;
			}
			tempWidth = 0;
			tempHeight++;
		}
		
		condition.showTheMovesPossible(condition.whiteTurn);
	}
	
	private void makeADama(int height, int width) {
		if(boardBoxes[height][width].getBoxIcon() == white[0]) { whatDama(whiteDama[0], height, width, true);}
		if(boardBoxes[height][width].getBoxIcon() == white[1]) { whatDama(whiteDama[1], height, width, true);}
		if(boardBoxes[height][width].getBoxIcon() == white[2]) { whatDama(whiteDama[2], height, width, true);}
		if(boardBoxes[height][width].getBoxIcon() == white[3]) { whatDama(whiteDama[3], height, width, true);}
		if(boardBoxes[height][width].getBoxIcon() == white[4]) { whatDama(whiteDama[4], height, width, true);}
		if(boardBoxes[height][width].getBoxIcon() == white[5]) { whatDama(whiteDama[5], height, width, true);}
		if(boardBoxes[height][width].getBoxIcon() == white[6]) { whatDama(whiteDama[6], height, width, true);}
		if(boardBoxes[height][width].getBoxIcon() == white[7]) { whatDama(whiteDama[7], height, width, true);}
		if(boardBoxes[height][width].getBoxIcon() == white[8]) { whatDama(whiteDama[8], height, width, true);}
		if(boardBoxes[height][width].getBoxIcon() == white[9]) { whatDama(whiteDama[9], height, width, true);}
		if(boardBoxes[height][width].getBoxIcon() == white[10]) { whatDama(whiteDama[10], height, width, true);}
		if(boardBoxes[height][width].getBoxIcon() == white[11]) { whatDama(whiteDama[11], height, width, true);}
		if(boardBoxes[height][width].getBoxIcon() == black[0]) { whatDama(blackDama[0], height, width, false);}
		if(boardBoxes[height][width].getBoxIcon() == black[1]) { whatDama(blackDama[1], height, width, false);}
		if(boardBoxes[height][width].getBoxIcon() == black[2]) { whatDama(blackDama[2], height, width, false);}
		if(boardBoxes[height][width].getBoxIcon() == black[3]) { whatDama(blackDama[3], height, width, false);}
		if(boardBoxes[height][width].getBoxIcon() == black[4]) { whatDama(blackDama[4], height, width, false);}
		if(boardBoxes[height][width].getBoxIcon() == black[5]) { whatDama(blackDama[5], height, width, false);}
		if(boardBoxes[height][width].getBoxIcon() == black[6]) { whatDama(blackDama[6], height, width, false);}
		if(boardBoxes[height][width].getBoxIcon() == black[7]) { whatDama(blackDama[7], height, width, false);}
		if(boardBoxes[height][width].getBoxIcon() == black[8]) { whatDama(blackDama[8], height, width, false);}
		if(boardBoxes[height][width].getBoxIcon() == black[9]) { whatDama(blackDama[9], height, width, false);}
		if(boardBoxes[height][width].getBoxIcon() == black[10]) { whatDama(blackDama[10], height, width, false);}
		if(boardBoxes[height][width].getBoxIcon() == black[11]) { whatDama(blackDama[11], height, width, false);}
	}
	
	private void whatDama(ImageIcon damaIcon, int height, int width, boolean isWhite) {
		boardBoxes[height][width].setIcon(damaIcon);
		boardBoxes[height][width].setBoxIcon(damaIcon);
		if(isWhite) {
			boardBoxes[height][width].setHasWhite(false);
			boardBoxes[height][width].setHasWhiteDama(true);
		} else {
			boardBoxes[height][width].setHasBlack(false);
			boardBoxes[height][width].setHasBlackDama(true);
		}
	}
	
	public void checkForWinner() {
		boolean stillHasWhite = false;
		boolean stillHasBlack = false;
		for(int height = 0; height < 8; height++) {
			for(int width = 0; width < 8; width++) {
				if(boardBoxes[height][width].isHasWhite() || boardBoxes[height][width].isHasWhiteDama()) {
					stillHasWhite = true;
				} else if(boardBoxes[height][width].isHasBlack() || boardBoxes[height][width].isHasBlackDama()) {
					stillHasBlack = true;
				}
			}
		}
		if(!stillHasBlack) {
			if(pointSystemHandler.whiteTotalScore == pointSystemHandler.blackTotalScore) {
				System.out.println("Game is tied!!");
			} else if(pointSystemHandler.whiteTotalScore > pointSystemHandler.blackTotalScore){
				System.out.println("White is the Winner!!");
			} else {
				System.out.println("Black is the Winner!!");
			}
			for(int height = 0; height < 8; height++) {
				for(int width = 0; width < 8; width++) {
					if((height + width) % 2 == 0) {
						removeChip(boardBoxes[height][width], height, width);
						boxReset(height, width);
					}
					condition.whiteTurn = true;
					setPieces();
					startGame = false;
				}
			}
		} else if(!stillHasWhite) {
			for(int counter = 0; counter < pointSystemHandler.whiteScore.size(); counter++) {
				pointSystemHandler.whiteScoreList[counter + 1].setText(String.valueOf(pointSystemHandler.whiteScore.get(counter)));
				pointSystemHandler.whiteTotalScore += pointSystemHandler.whiteScore.get(counter);
			}
			for(int counter = 0; counter < pointSystemHandler.blackScore.size(); counter++) {
				pointSystemHandler.blackScoreList[counter + 1].setText(String.valueOf(pointSystemHandler.blackScore.get(counter)));
				pointSystemHandler.blackTotalScore += pointSystemHandler.blackScore.get(counter);
			}
			if(pointSystemHandler.whiteTotalScore == pointSystemHandler.blackTotalScore) {
				System.out.println("Game is tied!!");
			} else if(pointSystemHandler.whiteTotalScore > pointSystemHandler.blackTotalScore){
				System.out.println("White is the Winner!!");
			} else {
				System.out.println("Black is the Winner!!");
			}
			
			pointSystemHandler.clearScore();
			
			for(int height = 0; height < 8; height++) {
				for(int width = 0; width < 8; width++) {
					if((height + width) % 2 == 0) {
						removeChip(boardBoxes[height][width], height, width);
						boxReset(height, width);
					}
					condition.whiteTurn = true;
					setPieces();
					startGame = false;
				}
			}
		}
	}

	private void setPieces() {
		int counterForBlack = 11;
		int counterForWhite = 0;
		
		for(int yCoordinate = 0; yCoordinate < 3; yCoordinate++) {
			for(int xCoordinate = 0; xCoordinate < 8; xCoordinate += 2) {
				if(yCoordinate == 1) xCoordinate++;
				boardBoxes[yCoordinate][xCoordinate].setText("");
				boardBoxes[yCoordinate][xCoordinate].setIcon(black[counterForBlack]);
				boardBoxes[yCoordinate][xCoordinate].setHasChip(true);
				boardBoxes[yCoordinate][xCoordinate].setHasBlack(true);
				boardBoxes[yCoordinate][xCoordinate].setBoxIcon(black[counterForWhite]);
				if(yCoordinate == 1) xCoordinate--;
				counterForBlack--;
			}
		}
		
		for(int yCoordinate = 5; yCoordinate < 8; yCoordinate++) {
			for(int xCoordinate = 1; xCoordinate < 8; xCoordinate += 2) {
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
}
