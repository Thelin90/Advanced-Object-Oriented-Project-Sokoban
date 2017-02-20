package projectAOP;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import projectAOPframework.PaintMap;

/**
 * 
 * 
 * @author Simon Thelin & Oskar Svensson
 * @version 1.2
 * @date 2016-05-13
 * 
 */
public class View extends Model {
	protected JFrame frame;
	protected Container c;
	protected JPanel backgroundPanel = new JPanel();
	protected JPanel frontPanel = new JPanel();
	protected JMenuBar menuBar = new JMenuBar();
	protected JMenu menu;
	protected JMenuItem restartLevel;
	protected JMenuItem level1;
	protected JMenuItem level2;
	protected JMenuItem level3;

	public View() {
		super();
		frame = new JFrame(getGameName());
		menu = new JMenu(getMenuBarName());

		restartLevel = new JMenuItem(menuBarItems()[0]);
		level1 = new JMenuItem(menuBarItems()[1]);
		level2 = new JMenuItem(menuBarItems()[2]);
		level3 =  new JMenuItem(menuBarItems()[3]);

		c = frame.getContentPane();
		c.setLayout(new BorderLayout());
		frontPanel.setLayout(new BorderLayout());

		backgroundPanel.setLayout(new BorderLayout());
		frontPanel.setBounds(0, 0, 320, 320);

		menuBar.add(menu);
		menu.add(restartLevel);
		menu.add(level1);
		menu.add(level2);
		menu.add(level3);
		frame.setJMenuBar(menuBar);

		c.add(backgroundPanel,BorderLayout.CENTER);
		backgroundPanel.add(new Map());

		frame.setVisible(true);
		frame.setSize(getHeight(),getWidth());
		frame.setResizable(false);
		frame.setLocation(gameLocationOnScreen()[0],gameLocationOnScreen()[1]);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.requestFocusInWindow();


	}

	public void movePlayer() {
		if(goal==0){
			setCollideValues();
			c.repaint();
		}
	}

	/**
	 * 
	 * @author simon
	 *
	 */
	@SuppressWarnings("serial")
	public class Map extends PaintMap{
		
		public Map() {
			setCollideValues();
		}

		@Override
		public void levelOne(Graphics g) {
			levelOneGridValues();
			paintLevelOne(g);
		}

		@Override
		public void levelTwo(Graphics g) {
			levelTwoGridValues();
			paintLevelTwo(g);

		}
		@Override
		public void levelThree(Graphics g) {
			levelThreeGridValues();
			paintLevelThree(g);
		}

		@Override
		public BufferedImage getObjectImage(int val) {
			if(usedPictureList!=null){
				return usedPictureList.get(val);
			}
			return null;
		}
		

		@Override
		public BufferedImage getObjectAnimation(int val) {
			if(animationList!=null){
				return animationList.get(val);
			}
			return null;
		}
		
		@Override
		public int getAnimationSize() {
			return animationList.size();
		}

		/**
		 * @precondition The container object must not be equal to null
		 * Returns the given Container, which adapts the frame of the GUI
		 * @return Container object
		 */
		@Override
		public Container getTheContainer() {
			if(c!=null) {return c;}
			else 
				return null;
		}

		@Override
		public int getActualLevel() {return actualLevel();}

		@Override
		public int getMoves() {return moves;}

		@Override
		public int getPushes() {return pushes;}

		@Override
		public boolean ifRestart() {
			if(restart==true){return true;}
			return false;
		}
		@Override
		public void restartTheLevel() {
			restartLevel();
		}
		@Override
		public int[][] getGridObject(int val) {
			if(val==0){return playerPos;}
			else if(val==1) {return cratePos1;}
			else if(val==2){return cratePos2;}
			else if(val==3) {return cratePos3;}
			else if(val==4) {return cratePos4;}
			else if(val==5){return blankMarks;
			} else
				return null;
		}

		@Override
		public int getObjectXvalue(int val) {
			if(val==1){return crateOneX;}
			else if(val==2){return crateTwoX;}
			else if(val==3){return crateThreeX;} 
			else if(val==4){return crateFourX;} else
				return 0;
		}
		@Override
		public int getObjectYvalue(int val) {
			if(val==1){return crateOneY;}
			else if(val==2){return crateTwoY;}
			else if(val==3){return crateThreeY;} 
			else if(val==4){return crateFourY;}
			else
				return 0;
		}

		@Override
		public int[] getPixelsOfFrame(int val) {
			if(val==1){return xPos;}
			else if(val==2){return yPos;}
			else
				return null;
		}

		@Override
		public int getEndXYvalue(int val) {
			if(val==1){return endPosX1;}
			else if(val==2){return endPosY1;}
			else if(val==3){return endPosX2;}
			else if(val==4){return endPosY2;}
			else if(val==5) {return endPosX3;}
			else if(val==6){return endPosY3;}
			else if(val==7){return endPosX4;}
			else if(val==8){return endPosY4;}
			else
				return 0;
		}
		@Override
		public int getXYcord(int val) {
			if(val==1){return x;}
			else if(val==2){return y;}
			else
				return 0;
		}

		@Override
		public int doneObject() {
			if(boxDone()==1) {return 1;} 
			else if(boxDone()==2){return 2;}
			else
				return 0;
		}

		@Override
		public boolean allObjectsDone() {
			if(allBoxesDone()){return true;}
			else
				return false;
		}
		@Override
		public Font getFont(int val) {
			if(val==1){return new Font("Lucida Grande", Font.BOLD, 17); } 
			else if(val==2) {return new Font("Lucida Grande", Font.BOLD, 138);}
			else
				return null;
		}

		@Override
		public int[] getFontLocationOnScreen(int val) {
			int[] returnArr = new int[2];
			if(val==1){returnArr[0]=50;returnArr[1]=300;}
			else if(val==2){returnArr[0]=50;returnArr[1]=320;}
			else if(val==3){returnArr[0]=1;returnArr[1]=15;}
			else if(val==4){returnArr[0]=1;returnArr[1]=33;}
			else if(val==5){returnArr[0]=0;returnArr[1]=150;} 
			else if(val==6){returnArr[0]=40;returnArr[1]=150;}
			else if(val==7){returnArr[0]=80;returnArr[1]=512;}
			return returnArr;
		}

		@Override
		public String getFontTxt(int val) {
			String retTxt=null;
			if(val==1){retTxt="To start playing, press Play in the menu bar and choose level";}
			else if(val==2){retTxt="Or select level by pressing 1, 2 or 3";}
			else if(val==3){retTxt="Moves: ";}
			else if(val==4){retTxt="Pushes: ";}
			else if(val==5){retTxt="VICTORY";}
			else if(val==6){retTxt="LEVEL 1";}
			else if(val==7){retTxt="LEVEL 2";}
			else if(val==8){retTxt="LEVEL 3";}
			else if(val==9){retTxt="You completed the level in " + pushes + " pushes and " + moves + " moves!";}
			return retTxt;
		}

		@Override
		public int levelCompleted() {return goal;}
	}
}


