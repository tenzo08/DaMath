package GameHandler;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import Game.BoardBoxes;

public class ConditionsToBeMet {
	
	public boolean whiteTurn = true;
	
	private Color boxActivationColor;
	private Color movePossibleBoxColor;
	
	private BoardBoxes[][] boardBoxes;
	
	public List<Integer> shouldEatChipHeight, shouldEatChipWidth;
	
	public ConditionsToBeMet(BoardBoxes[][] boardBoxes) {
		this.boardBoxes = boardBoxes;
		
		boxActivationColor = new Color(128, 250, 129);
		movePossibleBoxColor = new Color(255, 250, 129);
		
		shouldEatChipHeight = new ArrayList<Integer>();
		shouldEatChipWidth = new ArrayList<Integer>();
	}
	
	public void showTheMovesPossible(boolean whiteTurn) {
		for(int height = 0; height < 8; height++) {
			
			for(int width = 0; width < 8; width++) {
				
				if(!checkChipsThatShouldEat(whiteTurn)) {
					shouldEatChipHeight.clear();
					shouldEatChipWidth.clear();
					if(whiteTurn && boardBoxes[height][width].isHasWhite()) {
						try {
							if(!boardBoxes[height - 1][width - 1].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if(!boardBoxes[height - 1][width + 1].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
					} else if(!whiteTurn && (boardBoxes[height][width].isHasBlack() || boardBoxes[height][width].isHasBlackDama())) {
						try {
							if(!boardBoxes[height - 1][width - 1].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if(!boardBoxes[height - 1][width + 1].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
					} else if(whiteTurn && boardBoxes[height][width].isHasWhiteDama()) {
						try {
							if(!boardBoxes[height - 1][width - 1].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if(!boardBoxes[height - 1][width + 1].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if(!boardBoxes[height + 1][width - 1].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if(!boardBoxes[height + 1][width + 1].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
					} else if(!whiteTurn && boardBoxes[height][width].isHasBlackDama()) {
						try {
							if(!boardBoxes[height - 1][width - 1].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if(!boardBoxes[height - 1][width + 1].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if(!boardBoxes[height + 1][width - 1].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if(!boardBoxes[height + 1][width + 1].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
					}
				} else {
					shouldEatChipHeight.clear();
					shouldEatChipWidth.clear();
					if(whiteTurn && boardBoxes[height][width].isHasWhite()) {
						
						try {
							if((boardBoxes[height - 1][width - 1].isHasBlack() || boardBoxes[height - 1][width - 1].isHasBlackDama()) 
									&&  !boardBoxes[height - 2][width - 2].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if((boardBoxes[height - 1][width + 1].isHasBlack() || boardBoxes[height - 1][width + 1].isHasBlackDama()) 
									&&  !boardBoxes[height - 2][width + 2].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if((boardBoxes[height + 1][width - 1].isHasBlack() || boardBoxes[height + 1][width - 1].isHasBlackDama()) 
									&&  !boardBoxes[height + 2][width - 2].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if((boardBoxes[height + 1][width + 1].isHasBlack() || boardBoxes[height + 1][width + 1].isHasBlackDama()) 
									&&  !boardBoxes[height + 2][width + 2].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
					} else if(!whiteTurn && boardBoxes[height][width].isHasBlack()) {
						
						try {
							if((boardBoxes[height - 1][width - 1].isHasWhite() || boardBoxes[height - 1][width - 1].isHasWhiteDama()) 
									&&  !boardBoxes[height - 2][width - 2].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if((boardBoxes[height - 1][width + 1].isHasWhite() || boardBoxes[height - 1][width + 1].isHasWhiteDama()) 
									&&  !boardBoxes[height - 2][width + 2].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if((boardBoxes[height + 1][width - 1].isHasWhite() || boardBoxes[height + 1][width - 1].isHasWhiteDama()) 
									&&  !boardBoxes[height + 2][width - 2].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
						try {
							if((boardBoxes[height + 1][width + 1].isHasWhite() || boardBoxes[height + 1][width + 1].isHasWhiteDama()) 
									&&  !boardBoxes[height + 2][width + 2].isHasChip()) {
								boardBoxes[height][width].setBackground(movePossibleBoxColor);
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
					} else if(whiteTurn && boardBoxes[height][width].isHasWhiteDama()) {
						try {
							int tempHeight = height;
							int tempWidth = width;
							while(true) {
								tempHeight--;
								tempWidth++;
								if((boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) &&
										!boardBoxes[tempHeight - 1][tempWidth + 1].isHasChip()) {
									boardBoxes[height][width].setBackground(movePossibleBoxColor);
								}
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
									boardBoxes[height][width].setBackground(movePossibleBoxColor);
								}
							}
						} catch (IndexOutOfBoundsException e) {}
						try {
							int tempHeight = height;
							int tempWidth = width;
							while(true) {
								tempHeight++;
								tempWidth++;
								if((boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) &&
										!boardBoxes[tempHeight + 1][tempWidth + 1].isHasChip()) {
									boardBoxes[height][width].setBackground(movePossibleBoxColor);
								}
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
									boardBoxes[height][width].setBackground(movePossibleBoxColor);
								}
							}
						} catch (IndexOutOfBoundsException e) {}
					} else if(!whiteTurn && boardBoxes[height][width].isHasBlackDama()) {
						try {
							int tempHeight = height;
							int tempWidth = width;
							while(true) {
								tempHeight--;
								tempWidth++;
								if((boardBoxes[tempHeight][tempWidth].isHasWhite() || boardBoxes[tempHeight][tempWidth].isHasWhiteDama()) &&
										!boardBoxes[tempHeight - 1][tempWidth + 1].isHasChip()) {
									boardBoxes[height][width].setBackground(movePossibleBoxColor);
								}
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
									boardBoxes[height][width].setBackground(movePossibleBoxColor);
								}
							}
						} catch (IndexOutOfBoundsException e) {}
						try {
							int tempHeight = height;
							int tempWidth = width;
							while(true) {
								tempHeight++;
								tempWidth++;
								if((boardBoxes[tempHeight][tempWidth].isHasWhite() || boardBoxes[tempHeight][tempWidth].isHasWhiteDama()) &&
										!boardBoxes[tempHeight + 1][tempWidth + 1].isHasChip()) {
									boardBoxes[height][width].setBackground(movePossibleBoxColor);
								}
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
									boardBoxes[height][width].setBackground(movePossibleBoxColor);
								}
							}
						} catch (IndexOutOfBoundsException e) {}
					}
				}
			}
		}
	}
	
	public boolean checkChipsThatShouldEat(boolean whiteTurn) {
		boolean aChipShouldEat = false;
		
		for(int height = 0; height < 8; height++) {
			for(int width = 0; width < 8; width++) {
				if(whiteTurn && boardBoxes[height][width].isHasWhite()) {
					try {
						if((boardBoxes[height - 1][width - 1].isHasBlack() || boardBoxes[height - 1][width - 1].isHasBlackDama())
								&& !boardBoxes[height - 2][width - 2].isHasChip()) {
							shouldEatChipHeight.add(height);
							shouldEatChipWidth.add(width);
							aChipShouldEat = true;
						}
					} catch (ArrayIndexOutOfBoundsException e) {}
					try {
						if((boardBoxes[height - 1][width + 1].isHasBlack() || boardBoxes[height - 1][width + 1].isHasBlackDama())
								&& !boardBoxes[height - 2][width + 2].isHasChip()) {
							shouldEatChipHeight.add(height);
							shouldEatChipWidth.add(width);
							aChipShouldEat = true;
						}
					} catch (ArrayIndexOutOfBoundsException e) {}
					try {
						if((boardBoxes[height + 1][width - 1].isHasBlack() || boardBoxes[height + 1][width - 1].isHasBlackDama())
								&& !boardBoxes[height + 2][width - 2].isHasChip()) {
							shouldEatChipHeight.add(height);
							shouldEatChipWidth.add(width);
							aChipShouldEat = true;
						}
					} catch (ArrayIndexOutOfBoundsException e) {}
					try {
						if((boardBoxes[height + 1][width + 1].isHasBlack() || boardBoxes[height + 1][width + 1].isHasBlackDama())
								&& !boardBoxes[height + 2][width + 2].isHasChip()) {
							shouldEatChipHeight.add(height);
							shouldEatChipWidth.add(width);
							aChipShouldEat = true;
						}
					} catch (ArrayIndexOutOfBoundsException e) {}
				} else if(!whiteTurn && boardBoxes[height][width].isHasBlack()) {
					try {
						if((boardBoxes[height - 1][width - 1].isHasWhite() || boardBoxes[height - 1][width - 1].isHasWhiteDama())
								&& !boardBoxes[height - 2][width - 2].isHasChip()) {
							shouldEatChipHeight.add(height);
							shouldEatChipWidth.add(width);
							aChipShouldEat = true;
						}
					} catch (ArrayIndexOutOfBoundsException e) {}
					try {
						if((boardBoxes[height - 1][width + 1].isHasWhite() || boardBoxes[height - 1][width + 1].isHasWhiteDama())
								&& !boardBoxes[height - 2][width + 2].isHasChip()) {
							shouldEatChipHeight.add(height);
							shouldEatChipWidth.add(width);
							aChipShouldEat = true;
						}
					} catch (ArrayIndexOutOfBoundsException e) {}
					try {
						if((boardBoxes[height + 1][width - 1].isHasWhite() || boardBoxes[height + 1][width - 1].isHasWhiteDama())
								&& !boardBoxes[height + 2][width - 2].isHasChip()) {
							shouldEatChipHeight.add(height);
							shouldEatChipWidth.add(width);
							aChipShouldEat = true;
						}
					} catch (ArrayIndexOutOfBoundsException e) {}
					try {
						if((boardBoxes[height + 1][width + 1].isHasWhite() || boardBoxes[height + 1][width + 1].isHasWhiteDama())
								&& !boardBoxes[height + 2][width + 2].isHasChip()) {
							shouldEatChipHeight.add(height);
							shouldEatChipWidth.add(width);
							aChipShouldEat = true;
						}
					} catch (ArrayIndexOutOfBoundsException e) {}
				} else if(whiteTurn && boardBoxes[height][width].isHasWhiteDama()) {
					try {
						int tempHeight = height;
						int tempWidth = width;
						while(true) {
							tempHeight--;
							tempWidth++;
							if((boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) &&
									!boardBoxes[tempHeight - 1][tempWidth + 1].isHasChip()) {
								shouldEatChipHeight.add(height);
								shouldEatChipWidth.add(width);
								aChipShouldEat = true;
							}
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
								shouldEatChipHeight.add(height);
								shouldEatChipWidth.add(width);
								aChipShouldEat = true;
							}
						}
					} catch (IndexOutOfBoundsException e) {}
					try {
						int tempHeight = height;
						int tempWidth = width;
						while(true) {
							tempHeight++;
							tempWidth++;
							if((boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) &&
									!boardBoxes[tempHeight + 1][tempWidth + 1].isHasChip()) {
								shouldEatChipHeight.add(height);
								shouldEatChipWidth.add(width);
								aChipShouldEat = true;
							}
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
								shouldEatChipHeight.add(height);
								shouldEatChipWidth.add(width);
								aChipShouldEat = true;
							}
						}
					} catch (IndexOutOfBoundsException e) {}
				} else if(!whiteTurn && boardBoxes[height][width].isHasBlackDama()) {
					try {
						int tempHeight = height;
						int tempWidth = width;
						while(true) {
							tempHeight--;
							tempWidth++;
							if((boardBoxes[tempHeight][tempWidth].isHasWhite() || boardBoxes[tempHeight][tempWidth].isHasWhiteDama()) &&
									!boardBoxes[tempHeight - 1][tempWidth + 1].isHasChip()) {
								shouldEatChipHeight.add(height);
								shouldEatChipWidth.add(width);
								aChipShouldEat = true;
							}
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
								shouldEatChipHeight.add(height);
								shouldEatChipWidth.add(width);
								aChipShouldEat = true;
							}
						}
					} catch (IndexOutOfBoundsException e) {}
					try {
						int tempHeight = height;
						int tempWidth = width;
						while(true) {
							tempHeight++;
							tempWidth++;
							if((boardBoxes[tempHeight][tempWidth].isHasWhite() || boardBoxes[tempHeight][tempWidth].isHasWhiteDama()) &&
									!boardBoxes[tempHeight + 1][tempWidth + 1].isHasChip()) {
								shouldEatChipHeight.add(height);
								shouldEatChipWidth.add(width);
								aChipShouldEat = true;
							}
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
								shouldEatChipHeight.add(height);
								shouldEatChipWidth.add(width);
								aChipShouldEat = true;
							}
						}
					} catch (IndexOutOfBoundsException e) {}
				}
			}
		}
		return aChipShouldEat;
	}
	
	public boolean checkForOtherEat(int height, int width) {
		try {
			if(!boardBoxes[height - 2][width + 2].isHasChip() && 
				(whiteTurn && boardBoxes[height - 1][width + 1].isHasBlack() ||
				!whiteTurn && boardBoxes[height - 1][width + 1].isHasWhite())) {
				
				boardBoxes[height - 2][width + 2].setBackground(boxActivationColor);
				boardBoxes[height - 2][width + 2].setReadyForMove(true);
				boardBoxes[height][width].setThisIsActivated(true);
				boardBoxes[height][width].setChipHasToEat(true);
				
				return true;
			}
		} catch (IndexOutOfBoundsException e) {}
		try {
			if(!boardBoxes[height - 2][width - 2].isHasChip() && 
				(whiteTurn && boardBoxes[height - 1][width - 1].isHasBlack() ||
				!whiteTurn && boardBoxes[height - 1][width - 1].isHasWhite())) {
				
				boardBoxes[height - 2][width - 2].setBackground(boxActivationColor);
				boardBoxes[height - 2][width - 2].setReadyForMove(true);
				boardBoxes[height][width].setThisIsActivated(true);
				boardBoxes[height][width].setChipHasToEat(true);
				
				return true;
			}
		} catch (IndexOutOfBoundsException e) {}
		try {
			if(!boardBoxes[height + 2][width + 2].isHasChip() && 
				(whiteTurn && boardBoxes[height + 1][width + 1].isHasBlack() ||
				!whiteTurn && boardBoxes[height + 1][width + 1].isHasWhite())) {
				
				boardBoxes[height + 2][width + 2].setBackground(boxActivationColor);
				boardBoxes[height + 2][width + 2].setReadyForMove(true);
				boardBoxes[height][width].setThisIsActivated(true);
				boardBoxes[height][width].setChipHasToEat(true);
				
				return true;
			}
		} catch (IndexOutOfBoundsException e) {}
		try {
			if(!boardBoxes[height + 2][width - 2].isHasChip() && 
				(whiteTurn && boardBoxes[height + 1][width - 1].isHasBlack() ||
				!whiteTurn && boardBoxes[height + 1][width - 1].isHasWhite())) {
				
				boardBoxes[height + 2][width - 2].setBackground(boxActivationColor);
				boardBoxes[height + 2][width - 2].setReadyForMove(true);
				boardBoxes[height][width].setThisIsActivated(true);
				boardBoxes[height][width].setChipHasToEat(true);
				
				return true;
			}
		} catch (IndexOutOfBoundsException e) {}
		if(boardBoxes[height][width].isHasWhiteDama()) {
			try {
				int tempHeight = height;
				int tempWidth = width;
				while(true) {
					tempHeight++;
					tempWidth++;
					if((boardBoxes[tempHeight][tempWidth].isHasBlack() || boardBoxes[tempHeight][tempWidth].isHasBlackDama()) &&
							!boardBoxes[tempHeight + 1][tempWidth + 1].isHasChip()) {
						tempHeight++;
						tempWidth++;
						try {
							boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
							boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							while(!boardBoxes[tempHeight + 1][tempWidth + 1].isHasChip()) {
								tempHeight++;
								tempWidth++;
								boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
								boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							}
						} catch (IndexOutOfBoundsException e) { return true; }
					}
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
						tempHeight++;
						tempWidth--;
						try {
							boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
							boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							while(!boardBoxes[tempHeight + 1][tempWidth - 1].isHasChip()) {
								tempHeight++;
								tempWidth--;
								boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
								boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							}
						} catch (IndexOutOfBoundsException e) { return true; }
					}
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
						tempHeight--;
						tempWidth++;
						try {
							boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
							boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							while(!boardBoxes[tempHeight - 1][tempWidth + 1].isHasChip()) {
								tempHeight--;
								tempWidth++;
								boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
								boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							}
						} catch (IndexOutOfBoundsException e) { return true; }
					}
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
						tempHeight--;
						tempWidth--;
						try {
							boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
							boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							while(!boardBoxes[tempHeight - 1][tempWidth - 1].isHasChip()) {
								tempHeight--;
								tempWidth--;
								boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
								boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							}
						} catch (IndexOutOfBoundsException e) { return true; }
					}
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
						tempHeight++;
						tempWidth++;
						try {
							boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
							boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							while(!boardBoxes[tempHeight + 1][tempWidth + 1].isHasChip()) {
								tempHeight++;
								tempWidth++;
								boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
								boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							}
						} catch (IndexOutOfBoundsException e) { return true; }
					}
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
						tempHeight++;
						tempWidth--;
						try {
							boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
							boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							while(!boardBoxes[tempHeight + 1][tempWidth - 1].isHasChip()) {
								tempHeight++;
								tempWidth--;
								boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
								boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							}
						} catch (IndexOutOfBoundsException e) { return true; }
					}
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
						tempHeight--;
						tempWidth++;
						try {
							boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
							boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							while(!boardBoxes[tempHeight + 1][tempWidth - 1].isHasChip()) {
								tempHeight--;
								tempWidth++;
								boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
								boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							}
						} catch (IndexOutOfBoundsException e) { return true; }
					}
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
						tempHeight--;
						tempWidth--;
						try {
							boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
							boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							while(!boardBoxes[tempHeight - 1][tempWidth - 1].isHasChip()) {
								tempHeight--;
								tempWidth--;
								boardBoxes[tempHeight][tempWidth].setBackground(boxActivationColor);
								boardBoxes[tempHeight][tempWidth].setReadyForMove(true);
							}
						} catch (IndexOutOfBoundsException e) { return true; }
					}
				}
			} catch (IndexOutOfBoundsException e) {}
		}
		return false;
	}
}
