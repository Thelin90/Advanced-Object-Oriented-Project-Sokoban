package projectAOP.projectAOPTicTacToe;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import projectAOPframework.KeyActions;

public class Controller extends View{

	public Controller(){
		c.addKeyListener(new MyListener());
	}

	public class MyListener extends KeyActions{
		String symb;
		public MyListener() {
			setListenerButtons(buttons);
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void moveLeftPlayer() {
			// TODO Auto-generated method stub

		}

		@Override
		public void moveRightPlayer() {
			// TODO Auto-generated method stub

		}

		@Override
		public void moveUpPlayer() {
			// TODO Auto-generated method stub

		}

		@Override
		public void moveDownPlayer() {
			// TODO Auto-generated method stub

		}

		@Override
		public void restarFromMenuBar() {
			// TODO Auto-generated method stub

		}

		@Override
		public void start() {
			// TODO Auto-generated method stub

		}

		@Override
		public void selectLevel(int selectedLevel) {
			// TODO Auto-generated method stub

		}

		@Override
		public void pauseTheMusic() {
			// TODO Auto-generated method stub

		}

		@Override
		public void continueTheMusic() {
			// TODO Auto-generated method stub

		}

		@Override
		public JButton[] getButton() {
			return buttons;
		}

		@Override
		public void setButtonValue(int val) {
			setPlayerSymbol(val);
		}
		@Override
		public String getSymb() {
			return getSymbol();
		}
	}
}
