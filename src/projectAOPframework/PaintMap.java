package projectAOPframework;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

/**
 * 
 * @author Simon Thelin & Oskar Svensson
 * @version 1.2
 * @date 2016-05-13
 * 
 */

public abstract class PaintMap extends JPanel  {

	public abstract void levelOne(Graphics g);
	public abstract void levelTwo(Graphics g);
	public abstract void levelThree(Graphics g);

	public abstract BufferedImage getObjectImage(int val);
	public abstract BufferedImage getObjectAnimation(int val);
	public abstract int getAnimationSize();

	public abstract int[][] getGridObject(int val);
	public abstract int getObjectXvalue(int val);
	public abstract int getObjectYvalue(int val);
	public abstract int getEndXYvalue(int val);
	public abstract Container getTheContainer();
	public abstract int getActualLevel();
	public abstract int getMoves();
	public abstract int getPushes();
	public abstract int[] getPixelsOfFrame(int val);
	public abstract int getXYcord(int val);
	public abstract boolean ifRestart();
	public abstract void restartTheLevel();
	public abstract int doneObject();
	public abstract boolean allObjectsDone();

	public abstract Font getFont(int val);
	public abstract int[] getFontLocationOnScreen(int val);
	public abstract String getFontTxt(int val);
	public abstract int levelCompleted();

	private int ani=0;

	@Override
	public void paintComponent(Graphics g) {
		try{
			super.paintComponent(g);

			int tileWidth = getObjectImage(0).getWidth();
			int tileHeight = getObjectImage(0).getHeight();

			if(getActualLevel()==-1){
				for (int i = 0; i < getHeight(); i += tileHeight) {
					for (int j = 0; j < getWidth(); j += tileWidth) {
						g.drawImage(getObjectImage(0), j, i, getTheContainer());
					}
				}
			}
			g.setFont(getFont(1));
			g.drawString(getFontTxt(1),getFontLocationOnScreen(1)[0],getFontLocationOnScreen(1)[1]);
			g.drawString(getFontTxt(2),getFontLocationOnScreen(2)[0],getFontLocationOnScreen(2)[1]);

			if(getActualLevel()==1) {
				paintMovements(g, tileHeight, tileWidth);
				levelOne(g);

				g.setFont(getFont(1));
				g.drawString(getFontTxt(3)+getMoves(),getFontLocationOnScreen(3)[0],getFontLocationOnScreen(3)[1]);
				g.drawString(getFontTxt(4)+getPushes(),getFontLocationOnScreen(4)[0],getFontLocationOnScreen(4)[1]);

			} else if(getActualLevel()==2){
				paintMovements(g,tileHeight,tileWidth);
				levelTwo(g);

				g.setFont(getFont(1));
				g.drawString(getFontTxt(3)+getMoves(),getFontLocationOnScreen(3)[0],getFontLocationOnScreen(3)[1]);
				g.drawString(getFontTxt(4)+getPushes(),getFontLocationOnScreen(4)[0],getFontLocationOnScreen(4)[1]);

			} else if(getActualLevel()==3){
				paintMovements(g,tileHeight,tileWidth);
				levelThree(g);

				g.setFont(getFont(1));
				g.drawString(getFontTxt(3)+getMoves(),getFontLocationOnScreen(3)[0],getFontLocationOnScreen(3)[1]);
				g.drawString(getFontTxt(4)+getPushes(),getFontLocationOnScreen(4)[0],getFontLocationOnScreen(4)[1]);

			}
			g.dispose();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void paintMovements(Graphics g, int height, int width) {
		try{
			for (int i = 0; i < getHeight(); i += height) {
				for (int j = 0; j < getWidth(); j += width) {
					if(ifRestart()){
						restartTheLevel();
					}
					g.drawImage(getObjectImage(0), j, i, getTheContainer());
					g.drawImage(getObjectImage(1),getPixelsOfFrame(1)[getEndXYvalue(1)],getPixelsOfFrame(2)[getEndXYvalue(2)],getTheContainer());
					g.drawImage(getObjectImage(1),getPixelsOfFrame(1)[getEndXYvalue(3)],getPixelsOfFrame(2)[getEndXYvalue(4)],getTheContainer());

					if(getGridObject(5)[getEndXYvalue(1)][getEndXYvalue(2)]!=1){
						g.drawImage(getObjectImage(3),getPixelsOfFrame(1)[getObjectXvalue(1)],getPixelsOfFrame(2)[getObjectYvalue(1)],getTheContainer());
						if(doneObject()==1) {
							g.drawImage(getObjectImage(4),getPixelsOfFrame(1)[getObjectXvalue(1)],getPixelsOfFrame(2)[getObjectYvalue(1)],getTheContainer());
						}
					}

					if(getGridObject(5)[getEndXYvalue(3)][getEndXYvalue(4)]!=1){
						g.drawImage(getObjectImage(3),getPixelsOfFrame(1)[getObjectXvalue(2)],getPixelsOfFrame(2)[getObjectYvalue(2)],getTheContainer());
						if(doneObject()==2) {
							g.drawImage(getObjectImage(4),getPixelsOfFrame(1)[getObjectXvalue(2)],getPixelsOfFrame(2)[getObjectYvalue(2)],getTheContainer());
						}
					}

					if(allObjectsDone()) {
						g.drawImage(getObjectImage(4),getPixelsOfFrame(1)[getObjectXvalue(2)],getPixelsOfFrame(2)[getObjectYvalue(2)],getTheContainer());
						g.drawImage(getObjectImage(4),getPixelsOfFrame(1)[getObjectXvalue(1)],getPixelsOfFrame(2)[getObjectYvalue(1)],getTheContainer());

						g.setFont(getFont(2)); 
						g.drawString(getFontTxt(5),getFontLocationOnScreen(5)[0],getFontLocationOnScreen(5)[1]);
						g.setFont(getFont(1));
						g.drawString(getFontTxt(9),getFontLocationOnScreen(7)[0],getFontLocationOnScreen(7)[1]);

					}
				}

				if(ani>getAnimationSize()-1) {
					ani=0;
				}
				paintAnimation(g, ani);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	public void paintAnimation(Graphics g, int val){
		g.drawImage(getObjectAnimation(val),getPixelsOfFrame(1)[getXYcord(1)],getPixelsOfFrame(2)[getXYcord(2)],getTheContainer());
		ani++;
	}

	public void paintLevelOne(Graphics g) {
		if(levelCompleted()==0){
			g.setFont(getFont(2));
			g.drawString(getFontTxt(6),getFontLocationOnScreen(6)[0],getFontLocationOnScreen(6)[1]);
		}
		for(int x=5 ; x<14; x++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[x],getPixelsOfFrame(2)[13],getTheContainer());}
		for (int y=7; y<13; y++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[13],getPixelsOfFrame(2)[y],getTheContainer());}
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[12],getPixelsOfFrame(2)[10],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[12],getPixelsOfFrame(2)[7],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[12],getPixelsOfFrame(2)[6],getTheContainer());
		for (int x=12; x>8; x--){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[x],getPixelsOfFrame(2)[6],getTheContainer());}
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[9],getPixelsOfFrame(2)[7],getTheContainer());
		for(int x=8; x>5; x--){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[x],getPixelsOfFrame(2)[7],getTheContainer());}
		for (int y=7; y<11; y++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[6],getPixelsOfFrame(2)[y],getTheContainer());}
		for (int y=10; y<14; y++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[5],getPixelsOfFrame(2)[y],getTheContainer());}
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[9],getPixelsOfFrame(2)[12],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[12],getPixelsOfFrame(2)[10],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[8],getPixelsOfFrame(2)[10],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[10],getPixelsOfFrame(2)[10],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[10],getPixelsOfFrame(2)[9],getTheContainer());
	}

	public void paintLevelTwo(Graphics g) {
		if(levelCompleted()==0){
			g.setFont(getFont(2));
			g.drawString(getFontTxt(7),getFontLocationOnScreen(6)[0],getFontLocationOnScreen(6)[1]);
		}
		for(int x=5; x<10; x++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[x],getPixelsOfFrame(2)[13],getTheContainer());}
		for(int x=9; x<13; x++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[x],getPixelsOfFrame(2)[12],getTheContainer());}
		for(int y=12; y>7; y--){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[12],getPixelsOfFrame(2)[y],getTheContainer());}
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[10],getPixelsOfFrame(2)[10],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[10],getPixelsOfFrame(2)[9],getTheContainer());
		for(int y=12; y>6; y--){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[5],getPixelsOfFrame(2)[y],getTheContainer());}
		for(int x=5; x<11; x++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[x],getPixelsOfFrame(2)[6],getTheContainer());}
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[10],getPixelsOfFrame(2)[7],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[11],getPixelsOfFrame(2)[7],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[12],getPixelsOfFrame(2)[7],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[7],getPixelsOfFrame(2)[11],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[7],getPixelsOfFrame(2)[9],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[7],getPixelsOfFrame(2)[8],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[8],getPixelsOfFrame(2)[8],getTheContainer());
	}

	public void paintLevelThree(Graphics g){
		if(levelCompleted()==0){
			g.setFont(getFont(2));
			g.drawString(getFontTxt(8),getFontLocationOnScreen(6)[0],getFontLocationOnScreen(6)[1]);
		}
		for(int x=4; x<9; x++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[x],getPixelsOfFrame(2)[13],getTheContainer());}
		for(int x=8; x<12; x++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[x],getPixelsOfFrame(2)[12],getTheContainer());}
		for(int x=11; x<16; x++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[x],getPixelsOfFrame(2)[13],getTheContainer());}
		for(int y=12; y>5; y--){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[15],getPixelsOfFrame(2)[y],getTheContainer());}
		for(int y=12; y>6; y--){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[4],getPixelsOfFrame(2)[y],getTheContainer());}
		for(int x=5; x<10; x++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[x],getPixelsOfFrame(2)[7],getTheContainer());}
		for(int x=9; x<16; x++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[x],getPixelsOfFrame(2)[5],getTheContainer());}
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[12],getPixelsOfFrame(2)[6],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[9],getPixelsOfFrame(2)[6],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[9],getPixelsOfFrame(2)[8],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[12],getPixelsOfFrame(2)[9],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[12],getPixelsOfFrame(2)[8],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[14],getPixelsOfFrame(2)[10],getTheContainer());
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[14],getPixelsOfFrame(2)[9],getTheContainer());
		for(int x=7; x<13; x++){g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[x],getPixelsOfFrame(2)[10],getTheContainer());}
		g.drawImage(getObjectImage(5),getPixelsOfFrame(1)[5],getPixelsOfFrame(2)[10],getTheContainer());
	}
}