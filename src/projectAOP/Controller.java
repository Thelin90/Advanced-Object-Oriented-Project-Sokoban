package projectAOP;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import projectAOPframework.KeyActions;

/**
 * 
 * @author Simon Thelin & Oskar Svensson
 * @version 1.2
 * @date 2016-05-13
 * 
 */
public class Controller extends View {
	public Controller() {
		super();
		c.addKeyListener(new MyKeyListener());
		c.requestFocusInWindow();

		restartLevel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopMusic(usedAudioList,0);
				playMusic(usedAudioList,1);
				restartActionPerformed(evt);
				c.repaint();
			}
		});
		level1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopMusic(usedAudioList,0);
				playMusic(usedAudioList,1);
				level1ActionPerformed(evt);
				c.repaint();
			}
		});
		level2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopMusic(usedAudioList,0);
				playMusic(usedAudioList,1);
				level2ActionPerformed(evt);
				c.repaint();
			}
		});
		level3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				stopMusic(usedAudioList,0);
				playMusic(usedAudioList,1);
				level3ActionPerformed(evt);
				c.repaint();
			}
		});
	}

	public class MyKeyListener extends KeyActions {
		@Override
		public void keyReleased(KeyEvent e) {}
		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void moveLeftPlayer() {
			if(actualLevel()!=-1) {
				moveLeft();
				movePlayer();
			}
		}

		@Override
		public void moveRightPlayer() {
			if(actualLevel()!=-1){
				moveRight();
				movePlayer();
			}
		}
		@Override
		public void moveUpPlayer() {
			if(actualLevel()!=-1){
				moveUp();
				movePlayer();
			}
		}

		@Override
		public void moveDownPlayer() {
			if(actualLevel()!=-1){
				moveDown();
				movePlayer();
			}
		}
		@Override
		public void pauseTheMusic() {
			if(actualLevel()!=-1){
				pauseMusic(usedAudioList,1);
			}
		}
		
		@Override
		public void continueTheMusic() {
			if(actualLevel()!=-1){
				playMusic(usedAudioList,1);
			}
		}

		@Override
		public void start() {
			if(actualLevel()==-1){
				stopMusic(usedAudioList,0);
				playMusic(usedAudioList,1);
				level=1;
				restart=true;
				restartLevel();
				c.repaint();
			}
		}
		@Override
		public void restarFromMenuBar() {
			stopMusic(usedAudioList,0);
			playMusic(usedAudioList,1);
			restart=true;
			restartLevel();
			c.repaint();
		}
		@Override
		public void selectLevel(int selectedLevel){
			level = selectedLevel;
			stopMusic(usedAudioList,0);
			playMusic(usedAudioList,1);
			restart=true;
			restartLevel();
			c.repaint();
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
		public JButton[] getButton() {
			return null;
		}

		@Override
		public String getSymb() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public void setButtonValue(int val) {
			// TODO Auto-generated method stub
			
		}
	}
}
