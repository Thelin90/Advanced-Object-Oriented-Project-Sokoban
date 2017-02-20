package projectAOP.projectAOPTicTacToe;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import projectAOPframework.Engine;

public class Model extends Engine {
	protected int dx, dy, frame_dx, frame_dy;
	protected boolean restart=false;
	protected int [][] gameMap;
	protected int [] btnStatus;
	protected int nbrOfChoice;
	protected String levelCompleted, background;
	protected int player=1;
	protected String symb;
	protected String win;
	protected Container cx;
	protected JButton [] defaultButtons;

	public Model() {
		readImages(2);
		setGuiHeight();
		setGuiWidth();
		setDataStructures();		
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void restartActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void level1ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void level2ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void level3ActionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setGuiHeight() {frame_dy=288;}

	@Override
	public void setGuiWidth() {frame_dx=288;}

	@Override
	public int[] gameLocationOnScreen() {
		int [] arr = {500,300};
		return arr;
	}

	@Override
	public String getMenuBarName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] menuBarItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGameName() {return "Tic-Tac-Toe";}

	@Override
	public void setDataStructures() {
		win="Game won by player ";
		nbrOfChoice=9;
		gameMap= new int [3][3];
		btnStatus = new int [9];
		for(int x=0; x<gameMap.length;x++){
			for (int y=0; y<gameMap[0].length;y++){
				gameMap[x][y]=0;
			}
		}
	}

	@Override
	public int actualLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getImageName(int val) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAnimationName(int val) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAudioFileName(int val) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return
	 */
	public int getHeight() {return frame_dy;}

	/**
	 * @return
	 */
	public int getWidth() {return frame_dx;}

	public int getButton(){
		for (int i=0; i<nbrOfChoice; i++){
			return i;
		}
		return -1;
	}

	public void setGameMap(int val){
		if(val==0) {
			gameMap[0][0]=player;
			btnStatus[0]=player;
		}
		else if(val==1) {
			gameMap[1][0]=player;
			btnStatus[1]=player;
		}
		else if(val==2) {
			gameMap[2][0]=player;
			btnStatus[2]=player;
		}
		else if(val==3) {
			gameMap[0][1]=player;
			btnStatus[3]=player;
		}
		else if(val==4) {
			gameMap[1][1]=player;
			btnStatus[4]=player;
		}
		else if(val==5) {
			gameMap[2][1]=player;
			btnStatus[5]=player;
		}
		else if(val==6) {
			gameMap[0][2]=player;
			btnStatus[6]=player;
		}
		else if(val==7) {
			gameMap[1][2]=player;
			btnStatus[7]=player;
		}
		else if(val==8) {
			gameMap[2][2]=player;
			btnStatus[8]=player;
		}
	}
	public void setSymb(String val) {
		symb =  val;
	}

	public void setPlayerSymbol(int val){
		if(checkIfGameWon()==false){
			if(player==1 && btnStatus[val]==0){
				System.out.println(player);
				player=2;
				setGameMap(val);
				setSymb("X");

			}
			else if(player==2 && btnStatus[val]==0){
				System.out.println(player);
				player=1;
				setGameMap(val);
				setSymb("O");
			}
		} else if(checkIfGameWon()==true){
			gameWon();
		}
	}

	@Override
	public String getSymbol() {
		return symb;
	}

	public boolean checkIfGameWon(){
		if(btnStatus[0]==1 && btnStatus[1]==1 && btnStatus[2]==1 || btnStatus[0]==2 && btnStatus[1]==2 && btnStatus[2]==2){
			return true;
		}
		else if(btnStatus[3]==1 && btnStatus[4]==1 && btnStatus[5]==1 || btnStatus[3]==2 && btnStatus[4]==2 && btnStatus[5]==2){
			return true;
		}
		else if(btnStatus[6]==1 && btnStatus[7]==1 && btnStatus[8]==1 || btnStatus[6]==2 && btnStatus[7]==2 && btnStatus[8]==2){
			return true;
		}
		else if(btnStatus[3]==1 && btnStatus[4]==1 && btnStatus[5]==1 || btnStatus[3]==2 && btnStatus[4]==2 && btnStatus[5]==2){
			return true;
		}
		else if(btnStatus[0]==1 && btnStatus[3]==1 && btnStatus[6]==1 || btnStatus[0]==2 && btnStatus[3]==2 && btnStatus[6]==2){
			return true;
		}
		else if(btnStatus[1]==1 && btnStatus[4]==1 && btnStatus[7]==1 || btnStatus[1]==2 && btnStatus[4]==2 && btnStatus[7]==2){
			return true;
		}
		else if(btnStatus[2]==1 && btnStatus[5]==1 && btnStatus[8]==1 || btnStatus[2]==2 && btnStatus[5]==2 && btnStatus[8]==2){
			return true;
		}
		else if(btnStatus[0]==1 && btnStatus[4]==1 && btnStatus[8]==1 || btnStatus[0]==2 && btnStatus[4]==2 && btnStatus[8]==2){
			return true;
		}
		else if(btnStatus[2]==1 && btnStatus[4]==1 && btnStatus[6]==1 || btnStatus[2]==2 && btnStatus[4]==2 && btnStatus[6]==2){
			return true;
		}
		return false;
	}

	public void setContainer(Container c){
		cx = c;
	}

	public Container getContainer(){return cx;}

	public String getGameWonText(){return win;}

	public void gameWon(){
		if(player==1){
			player=2;
		} else {
			player=1;
		}
		System.out.println("dsadsf");
		JOptionPane.showMessageDialog(getContainer(),getGameWonText()+" " + player);
		for (int i=0; i<9; i++){
			btnStatus[i]=0;
			setSymb("");
			getButtonsDefault()[i].setText(getSymbol());
		}
		for (int x=0; x<3; x++){
			for (int y=0; y<3; y++){
				gameMap[x][y]=0;
			}
		}
	}
	public void setButtonsDefault(JButton [] arr){
		defaultButtons = arr;
	}
	
	public JButton[] getButtonsDefault(){
		return defaultButtons;
	}
}