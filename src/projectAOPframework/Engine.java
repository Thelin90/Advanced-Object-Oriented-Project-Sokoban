package projectAOPframework;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.imageio.ImageIO;


/**
 * The abstract class Engine is the heart of the framework for a given project.
 * It tells the developer which methods that should be implemented in a given application.
 * Such as ActionEvents for a menu and movements, to set datastructures and such.
 * It also handles the reading of images, and mp3 files.
 * 
 * @author Simon Thelin & Oskar Svensson
 * @version 1.2
 * @date 2016-05-13
 * 
 * @invariant picList will always be BufferedImage, and audioList will always be the 
 * type of MediaPlayer.
 *
 */
public abstract class Engine {

	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveLeft();
	public abstract void moveRight();
	
	public abstract String getSymbol();
	public abstract void restartActionPerformed(ActionEvent evt);
	public abstract void level1ActionPerformed(ActionEvent evt);
	public abstract void level2ActionPerformed(ActionEvent evt);
	public abstract void level3ActionPerformed(ActionEvent evt);
	public abstract void setGuiHeight();
	public abstract void setGuiWidth();
	public abstract int[] gameLocationOnScreen();
	public abstract String getMenuBarName();
	public abstract String[] menuBarItems();
	public abstract String getGameName();
	public abstract void setDataStructures();
	public abstract int actualLevel();
	public abstract String getImageName(int val);
	public abstract String getAnimationName(int val);
	public abstract String getAudioFileName(int val);
	private ArrayList<BufferedImage> picList= new ArrayList<BufferedImage>();
	private ArrayList<BufferedImage> animationPicList= new ArrayList<BufferedImage>();
	private ArrayList<MediaPlayer> audioList = new ArrayList<MediaPlayer>();
	private BufferedImage pic;
	private MediaPlayer audioFile;

	public Engine() {
		new javafx.embed.swing.JFXPanel();
	}

	/**
	 * The method reads a given number of pictures, where zero is the
	 * lowest value and indicates one file, and puts them inside
	 * an ArrayList called picList of the type BufferedImage.
	 * 
	 * @param integer nbrOfPics
	 * @precondition nbrOfPics must be greater or equal to zero
	 * @postcondition the method will return an picture, else it will throw an exception
	 */
	public void readImages(int nbrOfPics) {
		try {
			if(nbrOfPics>=0){
				for(int i=0; i<nbrOfPics; i++) {
					if(getImageName(i)!=null) {
						pic = ImageIO.read(new File(getImageName(i)));
						picList.add(pic);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void readAnimation(int nbrOfPics) {
		try {
			if(14>=0){
				for(int i=0; i<14; i++) {
					if(getAnimationName(i)!=null) {
						pic = ImageIO.read(new File(getAnimationName(i)));
						animationPicList.add(pic);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The method reads a given number of audio files, where zero is the
	 * lowest value and indicates one file, and puts them inside
	 * an ArrayList called audioList of the type MediaPlayer. 
	 * 
	 * @param integer nbrOfFiles
	 * @precondition integer nbrOfFiles must be greater or equal to zero
	 * @postcondition the method will return an audio file, else it will throw an exception
	 */
	public void readAudioFiles(int nbrOfFiles) {
		try{
			if(nbrOfFiles>=0){
				for(int i=0; i<nbrOfFiles; i++){
					audioFile = new MediaPlayer(new Media(getAudioFileName(i)));
					audioList.add(audioFile);
				}
			}

		} catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * The method will play a given audio file.
	 * 
	 * @param MediaPlayer list
	 * @param integer val
	 * @precondition list must be !=null, and val must be
	 * greater than or equal to zero, where zero is one file within the
	 * list.
	 * @postcondition the method will generate a song to play, otherwise it 
	 * will throw an exception.
	 */
	public void playMusic(ArrayList<MediaPlayer> list, int val){
		try{
			if(list!=null && val>=0){
				for(int i=0; i<list.size(); i++){
					if(val==i){
						list.get(i).play();
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * The method will stop a given audio file.
	 * 
	 * @param BufferedImage list
	 * @param integer val
	 * @precondition list must be !=null, and val must be
	 * greater than or equal to zero, where zero is one file within the
	 * list.
	 * @postcondition the method will generate a song to stop, otherwise it 
	 * will throw an exception.
	 */
	public void stopMusic(ArrayList<MediaPlayer> list, int val){
		try{
			if(list!=null && val>=0){
				for(int i=0; i<list.size(); i++){
					if(val==i){
						list.get(i).stop();
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * The method will pause a given audio file.
	 * 
	 * @param MediaPlayer list
	 * @param integer val
	 * @precondition list must be !=null, and val must be
	 * greater than or equal to zero, where zero is one file within the
	 * list.
	 * @postcondition the method will generate a song to pause, otherwise it 
	 * will throw an exception.
	 */
	public void pauseMusic(ArrayList<MediaPlayer> list, int val){
		try{
			if(list!=null && val>=0){
				for(int i=0; i<list.size(); i++){
					if(val==i){
						list.get(i).pause();
					}
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * The method will return an ArrayList of the type BufferedImage
	 * @return BufferedImage list
	 * @precondition picList!=null
	 * @postcondition the given list will be returned, otherwise it will throw
	 * an exception and return null
	 */
	public ArrayList<BufferedImage> getPictureList() {
		try{
			if(picList!=null){
				return picList;
			} 
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	
	public ArrayList<BufferedImage> getAnimationList() {
		try{
			if(picList!=null){
				return animationPicList;
			} 
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * The method will return an ArrayList of the type BufferedImage
	 * @return MediaPlayer list
	 * @precondition audioList!=null
	 * @postcondition the given list will be returned, otherwise it will throw
	 * an exception and return null
	 */
	public ArrayList<MediaPlayer> getAudioList() {
		try{
			if(audioList!=null){
				return audioList;
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}