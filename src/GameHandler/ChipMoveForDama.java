package GameHandler;

import java.awt.Color;

import Game.BoardBoxes;

public class ChipMoveForDama {
	private Color boxActivationColor;
	
	private BoardBoxes[][] boardBoxes;
	
	public int damaEatenX, damaEatenY;
	
	public ChipMoveForDama(BoardBoxes[][] boardBoxes) {
		this.boardBoxes = boardBoxes;
		
		boxActivationColor = new Color(128, 250, 129);
	}
	
	public void boxActivationForDama(int width, int height) {
		boardBoxes[height][width].setThisIsActivated(true);
		
		try {
			int tempHeight = height - 1;
			int tempWidth = width + 1;
			while(!boardBoxes[tempHeight][tempWidth].isHasChip()) {
				boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
				boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
				tempHeight--;
				tempWidth++;
			}
		} catch (IndexOutOfBoundsException e) {}
		try {
			int tempHeight = height - 1;
			int tempWidth = width - 1;
			while(!boardBoxes[tempHeight][tempWidth].isHasChip()) {
				boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
				boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
				tempHeight--;
				tempWidth--;
			}
		} catch (IndexOutOfBoundsException e) {}
		try {
			int tempHeight = height + 1;
			int tempWidth = width + 1;
			while(!boardBoxes[tempHeight][tempWidth].isHasChip()) {
				boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
				boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
				tempHeight++;
				tempWidth++;
			}
		} catch (IndexOutOfBoundsException e) {}
		try {
			int tempHeight = height + 1;
			int tempWidth = width - 1;
			while(!boardBoxes[tempHeight][tempWidth].isHasChip()) {
				boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
				boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
				tempHeight++;
				tempWidth--;
			}
		} catch (IndexOutOfBoundsException e) {}
	}

	public void boxActivationForEatingDama(int width, int height) {
		boardBoxes[height][width].setThisIsActivated(true);
		boardBoxes[height][width].setChipHasToEat(true);
		
		if(boardBoxes[height][width].isHasWhiteDama()) {
			try {
				int tempHeight = height;
				int tempWidth = width;
				while(true) {
					tempHeight++;
					tempWidth++;
					if((boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) &&
							!boardBoxes[tempHeight + 1][tempWidth + 1].isHasChip()) {
						break;
					}
				}
				tempHeight++;
				tempWidth++;
				while(!boardBoxes[tempHeight][tempWidth].isHasChip()) {
					boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
					boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
					tempHeight++;
					tempWidth++;
				}
			} catch (IndexOutOfBoundsException e) {}
			try {
				int tempHeight = height;
				int tempWidth = width;
				while(true) {
					tempHeight++;
					tempWidth--;
					if((boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) &&
							!boardBoxes[tempHeight + 1][tempWidth - 1].isHasChip()) {
						break;
					}
				}
				tempHeight++;
				tempWidth--;
				while(!boardBoxes[tempHeight][tempWidth].isHasChip()) {
					boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
					boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
					tempHeight++;
					tempWidth--;
				}
			} catch (IndexOutOfBoundsException e) {}
			try {
				int tempHeight = height;
				int tempWidth = width;
				while(true) {
					tempHeight--;
					tempWidth++;
					if((boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) &&
							!boardBoxes[tempHeight - 1][tempWidth + 1].isHasChip()) {
						break;
					}
				}
				tempHeight--;
				tempWidth++;
				while(!boardBoxes[tempHeight][tempWidth].isHasChip()) {
					boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
					boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
					tempHeight--;
					tempWidth++;
				}
			} catch (IndexOutOfBoundsException e) {}
			try {
				int tempHeight = height;
				int tempWidth = width;
				while(true) {
					tempHeight--;
					tempWidth--;
					if((boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) &&
							!boardBoxes[tempHeight - 1][tempWidth - 1].isHasChip()) {
						break;
					}
				}
				tempHeight--;
				tempWidth--;
				while(!boardBoxes[tempHeight][tempWidth].isHasChip()) {
					boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
					boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
					tempHeight--;
					tempWidth--;
				}
			} catch (IndexOutOfBoundsException e) {}
		} else if(boardBoxes[height][width].isHasBlackDama()) {
			try {
				int tempHeight = height;
				int tempWidth = width;
				while(true) {
					tempHeight++;
					tempWidth++;
					if((boardBoxes[tempHeight][tempWidth].isHasWhite() || boardBoxes[tempHeight][tempWidth].isHasWhiteDama()) &&
							!boardBoxes[tempHeight + 1][tempWidth + 1].isHasChip()) {
						break;
					}
				}
				tempHeight++;
				tempWidth++;
				while(!boardBoxes[tempHeight][tempWidth].isHasChip()) {
					boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
					boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
					tempHeight++;
					tempWidth++;
				}
			} catch (IndexOutOfBoundsException e) {}
			try {
				int tempHeight = height;
				int tempWidth = width;
				while(true) {
					tempHeight++;
					tempWidth--;
					if((boardBoxes[tempHeight][tempWidth].isHasWhite() || boardBoxes[tempHeight][tempWidth].isHasWhiteDama()) &&
							!boardBoxes[tempHeight + 1][tempWidth - 1].isHasChip()) {
						break;
					}
				}
				tempHeight++;
				tempWidth--;
				while(!boardBoxes[tempHeight][tempWidth].isHasChip()) {
					boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
					boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
					tempHeight++;
					tempWidth--;
				}
			} catch (IndexOutOfBoundsException e) {}
			try {
				int tempHeight = height;
				int tempWidth = width;
				while(true) {
					tempHeight--;
					tempWidth++;
					if((boardBoxes[tempHeight][tempWidth].isHasWhite() || boardBoxes[tempHeight][tempWidth].isHasWhiteDama()) &&
							!boardBoxes[tempHeight - 1][tempWidth + 1].isHasChip()) {
						break;
					}
				}
				tempHeight--;
				tempWidth++;
				while(!boardBoxes[tempHeight][tempWidth].isHasChip()) {
					boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
					boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
					tempHeight--;
					tempWidth++;
				}
			} catch (IndexOutOfBoundsException e) {}
			try {
				int tempHeight = height;
				int tempWidth = width;
				while(true) {
					tempHeight--;
					tempWidth--;
					if((boardBoxes[tempHeight][tempWidth].isHasWhite() || boardBoxes[tempHeight][tempWidth].isHasWhiteDama()) &&
							!boardBoxes[tempHeight - 1][tempWidth - 1].isHasChip()) {
						break;
					}
				}
				tempHeight--;
				tempWidth--;
				while(!boardBoxes[tempHeight][tempWidth].isHasChip()) {
					boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
					boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
					tempHeight--;
					tempWidth--;
				}
			} catch (IndexOutOfBoundsException e) {}
		}
	}

	public void damaShouldEat(int origWidth, int origHeight, int newWidth, int newHeight) {
		boardBoxes[newHeight][newWidth].setText("");
		boardBoxes[newHeight][newWidth].setBoxIcon(boardBoxes[origHeight][origWidth].getBoxIcon());
		boardBoxes[newHeight][newWidth].setIcon(boardBoxes[origHeight][origWidth].getBoxIcon());
		
		if(boardBoxes[origHeight][origWidth].isHasWhiteDama()) {
			if(origHeight - newHeight > 0 && origWidth - newWidth > 0) {
				try {
					int tempHeight = origHeight;
					int tempWidth = origWidth;
					while(true) {
						tempHeight--;
						tempWidth--;
						if(boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) {
							damaEatenX = tempWidth;
							damaEatenY = tempHeight;
							break;
						}
					}
				} catch (IndexOutOfBoundsException e) {}
			} else if(origHeight - newHeight > 0 && origWidth - newWidth < 0) {
				try {
					int tempHeight = origHeight;
					int tempWidth = origWidth;
					while(true) {
						tempHeight--;
						tempWidth++;
						if(boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) {
							damaEatenX = tempWidth;
							damaEatenY = tempHeight;
							break;
						}
					}
				} catch (IndexOutOfBoundsException e) {}
			} else if(origHeight - newHeight < 0 && origWidth - newWidth > 0) {
				try {
					int tempHeight = origHeight;
					int tempWidth = origWidth;
					while(true) {
						tempHeight++;
						tempWidth--;
						if(boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) {
							damaEatenX = tempWidth;
							damaEatenY = tempHeight;
							break;
						}
					}
				} catch (IndexOutOfBoundsException e) {}
			} else if(origHeight - newHeight < 0 && origWidth - newWidth < 0) {
				try {
					int tempHeight = origHeight;
					int tempWidth = origWidth;
					while(true) {
						tempHeight++;
						tempWidth++;
						if(boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) {
							damaEatenX = tempWidth;
							damaEatenY = tempHeight;
							break;
						}
					}
				} catch (IndexOutOfBoundsException e) {}
			}
		} else if(boardBoxes[origHeight][origWidth].isHasBlackDama()) {
			if(origHeight - newHeight > 0 && origWidth - newWidth > 0) {
				try {
					int tempHeight = origHeight;
					int tempWidth = origWidth;
					while(true) {
						tempHeight--;
						tempWidth--;
						if(boardBoxes[tempHeight][tempWidth].isHasWhite() || boardBoxes[tempHeight][tempWidth].isHasWhiteDama()) {
							damaEatenX = tempWidth;
							damaEatenY = tempHeight;
							break;
						}
					}
				} catch (IndexOutOfBoundsException e) {}
			} else if(origHeight - newHeight > 0 && origWidth - newWidth < 0) {
				try {
					int tempHeight = origHeight;
					int tempWidth = origWidth;
					while(true) {
						tempHeight--;
						tempWidth++;
						if(boardBoxes[tempHeight][tempWidth].isHasWhite() || boardBoxes[tempHeight][tempWidth].isHasWhiteDama()) {
							damaEatenX = tempWidth;
							damaEatenY = tempHeight;
							break;
						}
					}
				} catch (IndexOutOfBoundsException e) {}
			} else if(origHeight - newHeight < 0 && origWidth - newWidth > 0) {
				try {
					int tempHeight = origHeight;
					int tempWidth = origWidth;
					while(true) {
						tempHeight++;
						tempWidth--;
						if(boardBoxes[tempHeight][tempWidth].isHasWhite() || boardBoxes[tempHeight][tempWidth].isHasWhiteDama()) {
							damaEatenX = tempWidth;
							damaEatenY = tempHeight;
							break;
						}
					}
				} catch (IndexOutOfBoundsException e) {}
			} else if(origHeight - newHeight < 0 && origWidth - newWidth < 0) {
				try {
					int tempHeight = origHeight;
					int tempWidth = origWidth;
					while(true) {
						tempHeight++;
						tempWidth++;
						if(boardBoxes[tempHeight][tempWidth].isHasWhite() || boardBoxes[tempHeight][tempWidth].isHasWhiteDama()) {
							damaEatenX = tempWidth;
							damaEatenY = tempHeight;
							break;
						}
					}
				} catch (IndexOutOfBoundsException e) {}
			}
		}
	}
}
