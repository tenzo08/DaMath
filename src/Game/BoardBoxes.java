package Game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BoardBoxes extends JButton{
	private ImageIcon boxIcon;
	private int coordinateX, coordinateY;
	private char operation;
	private boolean thisIsActivated, readyForMove, chipHasToEat, chipIsDama, chipCanBeDama;
	private boolean hasChip, hasWhite, hasBlack, hasWhiteDama, hasBlackDama;
	
	public BoardBoxes(int yCoordinate, int xCoordinate) {
		setFocusable(false);
		setFont(new Font("Sansarif Sans", Font.BOLD, 50));
		setOperation(yCoordinate, xCoordinate);
	}
	
	public ImageIcon getBoxIcon() {
		return boxIcon;
	}

	public void setBoxIcon(ImageIcon boxIcon) {
		this.boxIcon = boxIcon;
	}

	public int getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(int coordinateX) {
		this.coordinateX = coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(int coordinateY) {
		this.coordinateY = coordinateY;
	}

	public char getOperationCharacter() {
		return operation;
	}

	public void setOperationCharacter(char operation) {
		this.operation = operation;
	}

	public boolean isThisActivated() {
		return thisIsActivated;
	}

	public void setThisIsActivated(boolean thisIsActivated) {
		this.thisIsActivated = thisIsActivated;
	}

	public boolean isReadyForMove() {
		return readyForMove;
	}

	public void setReadyForMove(boolean readyForMove) {
		this.readyForMove = readyForMove;
	}

	public boolean isChipHasToEat() {
		return chipHasToEat;
	}

	public void setChipHasToEat(boolean chipHasToEat) {
		this.chipHasToEat = chipHasToEat;
	}

	public boolean isChipIsDama() {
		return chipIsDama;
	}

	public void setChipIsDama(boolean chipIsDama) {
		this.chipIsDama = chipIsDama;
	}

	public boolean isChipCanBeDama() {
		return chipCanBeDama;
	}

	public void setChipCanBeDama(boolean chipCanBeDama) {
		this.chipCanBeDama = chipCanBeDama;
	}

	public boolean isHasChip() {
		return hasChip;
	}

	public void setHasChip(boolean hasChip) {
		this.hasChip = hasChip;
	}

	public boolean isHasWhite() {
		return hasWhite;
	}

	public void setHasWhite(boolean hasWhite) {
		this.hasWhite = hasWhite;
	}

	public boolean isHasBlack() {
		return hasBlack;
	}

	public void setHasBlack(boolean hasBlack) {
		this.hasBlack = hasBlack;
	}

	public boolean isHasWhiteDama() {
		return hasWhiteDama;
	}

	public void setHasWhiteDama(boolean hasWhiteDama) {
		this.hasWhiteDama = hasWhiteDama;
	}

	public boolean isHasBlackDama() {
		return hasBlackDama;
	}

	public void setHasBlackDama(boolean hasBlackDama) {
		this.hasBlackDama = hasBlackDama;
	}
	
	public void setOperation(int yCoordinate, int xCoordinate) {
		switch(yCoordinate){
		case 0, 4:
			switch(xCoordinate) {
				case 0: 
					setBackground(Color.white);
					setOperationCharacter('x');
					setText("x");
					break;
				case 2: 
					setBackground(Color.white);
					setOperationCharacter('÷');
					setText("÷");
					break;
				case 4: 
					setBackground(Color.white);
					setOperationCharacter('-');
					setText("-");
					break;
				case 6: 
					setBackground(Color.white);
					setOperationCharacter('+');
					setText("+");
					break;
				default:
					setBackground(Color.black);
					break;
				}
			break;
		case 1, 5:
			switch(xCoordinate) {
			case 1: 
				setBackground(Color.white);
				setOperationCharacter('÷');
				setText("÷");
				break;
			case 3: 
				setBackground(Color.white);
				setOperationCharacter('x');
				setText("x");
				break;
			case 5: 
				setBackground(Color.white);
				setOperationCharacter('+');
				setText("+");
				break;
			case 7: 
				setBackground(Color.white);
				setOperationCharacter('-');
				setText("-");
				break;
			default:
				setBackground(Color.black);
				break;
			}
			break;
		case 2, 6:
			switch(xCoordinate) {
			case 0: 
				setBackground(Color.white);
				setOperationCharacter('-');
				setText("-");
				break;
			case 2: 
				setBackground(Color.white);
				setOperationCharacter('+');
				setText("+");
				break;
			case 4: 
				setBackground(Color.white);
				setOperationCharacter('x');
				setText("x");
				break;
			case 6: 
				setBackground(Color.white);
				setOperationCharacter('÷');
				setText("÷");
				break;
			default:
				setBackground(Color.black);
				break;
			}
			break;
		case 3, 7:
			switch(xCoordinate) {
			case 1: 
				setBackground(Color.white);
				setOperationCharacter('+');
				setText("+");
				break;
			case 3: 
				setBackground(Color.white);
				setOperationCharacter('-');
				setText("-");
				break;
			case 5: 
				setBackground(Color.white);
				setOperationCharacter('÷');
				setText("÷");
				break;
			case 7: 
				setBackground(Color.white);
				setOperationCharacter('x');
				setText("x");
				break;
			default:
				setBackground(Color.black);
				break;
			}
			break;
		}
	}
}
