package projectAOPframework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**
 * 
 * 
 * @author Simon Thelin & Oskar Svensson
 * @version 1.3
 * @date 2016-05-12
 * @update 2016-05-15 implementation of pause, play reading from keyboard for use of other parts of the framework 
 * 
 */
public abstract class KeyActions implements KeyListener, MouseListener, ActionListener{

	private int left, right, up, down, r, key1, key2, key3, spacebar, buttonUp, buttonDown, buttonLeft, buttonRight;
	private char p, P;
	public abstract void moveLeftPlayer();
	public abstract void moveRightPlayer();
	public abstract void moveUpPlayer();
	public abstract void moveDownPlayer();
	public abstract void restarFromMenuBar();
	public abstract void start();
	public abstract void selectLevel(int selectedLevel);
	public abstract void pauseTheMusic();
	public abstract void continueTheMusic();
	public abstract JButton[] getButton();
	public abstract String getSymb();
	public abstract void setButtonValue(int val);
	private String txt;

	public KeyActions() {
		txt="";
		setKeyValues();
	}

	public void setKeyValues() {
		left=65;right=68;
		up=87;down=83;
		r=82;
		key1=49; key2=50; key3=51;
		spacebar=32;
		buttonLeft=37;buttonRight=39;
		buttonUp=38;buttonDown=40;
		p='p'; P='P';
	}
	public int getUp() {return up;}
	public int getDown() {return down;}
	public int getLeft() {return left;}
	public int getRight() {return right;}
	public int getR() {return r;}
	public int getP() {return p;}
	public int getSpacebar() {return spacebar;}
	public int getButtonUp() {return buttonUp;}
	public int getButtonDown() {return buttonDown;}
	public int getButtonLeft() {return buttonLeft;}
	public int getButtonRight() {return buttonRight;}
	public char getPauseP() {return p;}
	public char getContinueP() {return P;}
	public int getKey1() {return key1;}
	public int getKey2() {return key2;}
	public int getKey3() {return key3;}

	public void keyPressed(KeyEvent e) {
		try{
			if(e.getKeyCode()==getLeft() || e.getKeyCode()==getButtonLeft()) {
				moveLeftPlayer();
			}
			else if(e.getKeyCode()==getRight() || e.getKeyCode()==getButtonRight()) {
				moveRightPlayer();
			}
			else if(e.getKeyCode()==getUp() || e.getKeyCode()==getButtonUp()) {
				moveUpPlayer();
			}
			else if(e.getKeyCode()==getDown() || e.getKeyCode()==getButtonDown()){
				moveDownPlayer();
			}
			else if (e.getKeyCode()==getR()){
				restarFromMenuBar();
			}
			else if (e.getKeyCode()==getSpacebar()){
				start();
			}
			else if(e.getKeyChar()==getPauseP()){
				pauseTheMusic();
			}
			else if(e.getKeyChar()==getContinueP()){
				continueTheMusic();
			}
			else if(e.getKeyCode()==getKey1()){
				selectLevel(1);
			}
			else if(e.getKeyCode()==getKey2()){
				selectLevel(2);
			}
			else if(e.getKeyCode()==getKey3()){
				selectLevel(3);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public void setListenerButtons(JButton[] arr) {
		for(int i=0; i<arr.length; i++) {
			arr[i].addActionListener(this);
		}
	}
	public void actionPerformed(ActionEvent e) {
			for(int i=0; i<getButton().length; i++) {
				if(e.getSource()==getButton()[i]) {
					setButtonValue(i);
					txt = getButton()[i].getText();
					if(txt=="") {getButton()[i].setText(getSymb());}
					if(txt!=getButton()[i].getText()) {
						getButton()[i].setText(getSymb());
				}
			}
		}
	}
}
