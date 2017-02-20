package projectAOP;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javafx.scene.media.MediaPlayer;
import projectAOPframework.Engine;

/**
 * 
 * @author Simon Thelin & Oskar Svensson
 * @version 1.2
 * @date 2016-05-13
 * 
 */
public class Model extends Engine  {

	protected int dx, dy, frame_dx, frame_dy;
	protected int[][] walls, cratePos1, cratePos2, cratePos3, cratePos4, blankMarks, playerPos;
	protected int endPosY1,endPosY2,endPosY3,endPosY4,endPosX1,endPosX2,endPosX3,endPosX4;
	protected int[] xPos, yPos;
	protected int[] finalEndPosX;
	protected ArrayList<BufferedImage> usedPictureList;
	protected ArrayList<BufferedImage> animationList;
	protected ArrayList<MediaPlayer> usedAudioList;
	protected int x,y;
	protected int crateForAllY=13;
	protected int crateOneX=8, crateOneY=9, crateTwoX=8, crateTwoY=8,crateThreeX=9, crateThreeY=13,crateFourX=10, crateFourY=13;
	protected int doneBoxX,doneBoxY,level;
	protected int goal=0,count=0, nbrOfCrates;
	protected int[] gameOverPosX,gameOverPosY;
	protected boolean restart=false, start=false;
	protected int moves = 0, pushes = 0;
	protected String levelCompleted, background;

	public Model() {
		readAudioFiles(2);
		readImages(6);
		readAnimation(14);
		setGuiHeight();
		setGuiWidth();
		setDataStructures();		
	}

	@Override
	public void moveUp() {
		try{
			if(walls[x][y-1]==0){
				if(playerPos[x][y-2]!=-1 || cratePos1[x][y-1]!=1) {
					if(playerPos[x][y-2]!=-1 || cratePos2[x][y-1]!=1) {
						if(playerPos[x][y-2]!=-1 || cratePos3[x][y-1]!=1) {
							if(playerPos[x][y-2]!=-1 || cratePos4[x][y-1]!=1) {
								dy=dy-32;
								y=y-1;
								incMoves();
							}
						}
					}
				} 
			}
			if(cratePos1[x][y]==1){
				if(playerPos[x][y-2]==0 || playerPos[x][y-1]==0) {
					crateOneY--;
					incPushes();
					cratePos1[crateOneX][crateOneY+1]=0;
					playerPos[crateOneX][crateOneY+1]=0;
					walls[crateOneX][crateOneY-1]=0;
					count=0;
					setBoxValue(blankMarks[x][y-1], count, crateOneY);
					if(blankMarks[x][y-1]==-2){
						count=0;
						setBoxValue(blankMarks[x][y-1], count, crateOneY);
					}
				}
			} else if(cratePos2[x][y]==1){
				if(playerPos[x][y-2]==0 || playerPos[x][y-1]==0) {
					crateTwoY--;
					incPushes();
					cratePos2[crateTwoX][crateTwoY+1]=0;
					playerPos[crateTwoX][crateTwoY+1]=0;
					walls[crateTwoX][crateTwoY-1]=0;
					count=1;
					setBoxValue(blankMarks[x][y-1], count, crateTwoY);
					if(blankMarks[x][y-1]==-2){
						count=1;
						setBoxValue(blankMarks[x][y-1], count, crateTwoY);
					}
				}
			} else if(cratePos3[x][y]==1){
				if(playerPos[x][y-2]==0 || playerPos[x][y-1]==0) {
					crateThreeY--;
					incPushes();
					cratePos3[crateThreeX][crateThreeY+1]=0;
					playerPos[crateThreeX][crateThreeY+1]=0;
					walls[crateThreeX][crateThreeY-1]=0;
					count=2;
					setBoxValue(blankMarks[x][y-1], count, crateThreeY);
					if(blankMarks[x][y-1]==-2){
						count=2;
						setBoxValue(blankMarks[x][y-1], count, crateThreeY);
					}
				}
			}
			else if(cratePos4[x][y]==1){
				if(playerPos[x][y-2]==0 || playerPos[x][y-1]==0) {
					crateFourY--;
					incPushes();
					cratePos4[crateFourX][crateFourY+1]=0;
					playerPos[crateFourX][crateFourY+1]=0;
					walls[crateFourX][crateFourY-1]=0;
					count=3;
					setBoxValue(blankMarks[x][y-1], count, crateFourY);
					if(blankMarks[x][y-1]==-2){
						count=3;
						setBoxValue(blankMarks[x][y-1], count, crateFourY);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void moveDown() { 
		try{
			if(walls[x][y+1]==0){
				if(playerPos[x][y+2]!=-1 || cratePos1[x][y+1]!=1) {
					if(playerPos[x][y+2]!=-1 || cratePos2[x][y+1]!=1) {
						if(playerPos[x][y+2]!=-1 || cratePos3[x][y+1]!=1) {
							if(playerPos[x][y+2]!=-1 || cratePos4[x][y+1]!=1) {
								dy=dy+32;
								y=y+1;
								incMoves();
							}
						}
					}
				} 
			}
			if(cratePos1[x][y]==1){
				if(playerPos[x][y+2]==0 || playerPos[x][y+1]==0) {
					crateOneY++;
					incPushes();
					cratePos1[crateOneX][crateOneY-1]=0;
					playerPos[crateOneX][crateOneY-1]=0;
					walls[crateOneX][crateOneY+1]=0;
					count=0;
					setBoxValue(blankMarks[x][y+1], count, crateOneY);
					if(blankMarks[x][y+1]==-2){
						count=0;
						setBoxValue(blankMarks[x][y+1], count, crateOneY);
					}
				}
			} else if(cratePos2[x][y]==1){
				if(playerPos[x][y+2]==0 || playerPos[x][y+1]==0) {
					crateTwoY++;
					incPushes();
					cratePos2[crateTwoX][crateTwoY-1]=0;
					playerPos[crateTwoX][crateTwoY-1]=0;
					walls[crateTwoX][crateTwoY+1]=0;
					count=1;
					setBoxValue(blankMarks[x][y+1], count, crateTwoY);
					if(blankMarks[x][y+1]==-2){
						count=1;
						setBoxValue(blankMarks[x][y+1], count, crateTwoY);
					}
				}
			} else if(cratePos3[x][y]==1){
				if(playerPos[x][y+2]==0 || playerPos[x][y+1]==0) {
					crateThreeY++;
					incPushes();
					cratePos3[crateThreeX][crateThreeY-1]=0;
					playerPos[crateThreeX][crateThreeY-1]=0;
					walls[crateThreeX][crateThreeY+1]=0;
					count=2;
					setBoxValue(blankMarks[x][y+1], count, crateThreeY);
					if(blankMarks[x][y+1]==-2){
						count=2;
						setBoxValue(blankMarks[x][y+1], count, crateThreeY);
					}
				}
			}
			else if(cratePos4[x][y]==1){
				if(playerPos[x][y+2]==0 || playerPos[x][y+1]==0) {
					crateFourY++;
					incPushes();
					cratePos4[crateFourX][crateFourY-1]=0;
					playerPos[crateFourX][crateFourY-1]=0;
					walls[crateFourX][crateFourY+1]=0;
					count=3;
					setBoxValue(blankMarks[x][y+1], count, crateFourY);
					if(blankMarks[x][y+1]==-2){
						count=3;
						setBoxValue(blankMarks[x][y+1], count, crateFourY);
					}
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Override
	public void moveLeft() {
		try{

			if(walls[x-1][y]!=1){
				if(playerPos[x-2][y]!=-1 || cratePos1[x-1][y]!=1) {
					if(playerPos[x-2][y]!=-1 || cratePos2[x-1][y]!=1){
						if(playerPos[x-2][y]!=-1 || cratePos3[x-1][y]!=1) {
							if(playerPos[x-2][y]!=-1 || cratePos4[x-1][y]!=1) {
								dx=dx-32;
								x=x-1;
								incMoves();
							}
						}
					}
				}
			}

			if(cratePos1[x][y]==1){
				if(playerPos[x-2][y]==0 || playerPos[x-1][y]==0) {
					crateOneX--;
					incPushes();
					cratePos1[crateOneX+1][crateOneY]=0;
					playerPos[crateOneX+1][crateOneY]=0;
					walls[crateOneX+1][crateOneY]=0;
					count=0;
					setBoxValue(blankMarks[x-1][y], count, crateOneY);
					if(blankMarks[x-1][y]==-2){
						count=0;
						setBoxValue(blankMarks[x-1][y], count, crateOneY);
					}
				}
			} else if(cratePos2[x][y]==1) {
				if(playerPos[x-2][y]==0 || playerPos[x-1][y]==0) { 
					crateTwoX--;
					incPushes();
					cratePos2[crateTwoX+1][crateTwoY]=0;
					playerPos[crateTwoX+1][crateTwoY]=0;
					walls[crateTwoX+1][crateTwoY]=0;
					count=1;
					setBoxValue(blankMarks[x-1][y], count, crateTwoY);
					if(blankMarks[x-1][y]==-2){
						count=1;
						setBoxValue(blankMarks[x-1][y], count, crateTwoY);
					}
				}
			} else if(cratePos3[x][y]==1) {
				if(playerPos[x-2][y]==0 || playerPos[x-1][y]==0)  {
					crateThreeX--;
					incPushes();
					cratePos3[crateThreeX+1][crateThreeY]=0;
					playerPos[crateThreeX+1][crateThreeY]=0;
					walls[crateThreeX+1][crateThreeY]=0;
					count=2;
					setBoxValue(blankMarks[x-1][y], count, crateThreeY);
					if(blankMarks[x-1][y]==-2){
						count=2;
						setBoxValue(blankMarks[x-1][y], count, crateThreeY);
					}
				}
			} else if(cratePos4[x][y]==1) {
				if(playerPos[x-2][y]==0 || playerPos[x-1][y]==0) {
					crateFourX--;
					incPushes();
					cratePos4[crateFourX+1][crateFourY]=0;
					playerPos[crateFourX+1][crateFourY]=0;
					walls[crateFourX+1][crateFourY]=0;
					count=3;
					setBoxValue(blankMarks[x-1][y], count, crateFourY);
					if(blankMarks[x-1][y]==-2){
						count=3;
						setBoxValue(blankMarks[x-1][y], count, crateFourY);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	@Override
	public void moveRight() {
		try{
			if(walls[x+1][y]!=1){
				if(playerPos[x+1][y]!=-2)
					if(playerPos[x+2][y]!=-1 || cratePos1[x+1][y]!=1) {
						if(playerPos[x+2][y]!=-1 || cratePos2[x+1][y]!=1){
							if(playerPos[x+2][y]!=-1 || cratePos3[x+1][y]!=1) {
								if(playerPos[x+2][y]!=-1 || cratePos4[x+1][y]!=1) {
									dx=dx+32;
									x=x+1;
									incMoves();
								}
							}
						}
					}

				if(cratePos1[x][y]==1){
					if(playerPos[x+2][y]==0 || playerPos[x+1][y]==0) {
						crateOneX++;
						incPushes();
						cratePos1[crateOneX-1][crateOneY]=0;
						playerPos[crateOneX-1][crateOneY]=0;
						walls[crateOneX-1][crateOneY]=0;
						count=0;
						setBoxValue(blankMarks[x+1][y], count, crateOneY);
						if(blankMarks[x+1][y]==-2){
							count=0;
							setBoxValue(blankMarks[x+1][y], count, crateOneY);
						}
					}

				} else if(cratePos2[x][y]==1){
					if(playerPos[x+2][y]==0 || playerPos[x+1][y]==0) {
						crateTwoX++;
						incPushes();
						cratePos2[crateTwoX-1][crateTwoY]=0;
						playerPos[crateTwoX-1][crateTwoY]=0;
						walls[crateTwoX-1][crateTwoY]=0;
						count=1;
						setBoxValue(blankMarks[x+1][y],  count, crateTwoY);
						if(blankMarks[x+1][y]==-2){
							count=1;
							setBoxValue(blankMarks[x+1][y], count, crateTwoY);
						}

					}
				} else if(cratePos3[x][y]==1){
					if(playerPos[x+2][y]==0 || playerPos[x+1][y]==0) {
						crateThreeX++;
						incPushes();
						cratePos3[crateThreeX-1][crateThreeY]=0;
						playerPos[crateThreeX-1][crateThreeY]=0;
						walls[crateThreeX-1][crateThreeY]=0;
						count=2;
						setBoxValue(blankMarks[x+1][y], count, crateThreeY);
						if(blankMarks[x+1][y]==-2){
							count=2;
							setBoxValue(blankMarks[x+1][y], count, crateThreeY);
						}
					}
				} else if(cratePos4[x][y]==1){
					if(playerPos[x+2][y]==0 || playerPos[x+1][y]==0) {
						crateFourX++;
						incPushes();
						cratePos4[crateFourX-1][crateFourY]=0;
						playerPos[crateFourX-1][crateFourY]=0;
						walls[crateFourX-1][crateFourY]=0;
						count=3;
						setBoxValue(blankMarks[x+1][y],count, crateFourY);
						if(blankMarks[x+1][y]==-2){
							count=3;
							setBoxValue(blankMarks[x+1][y],count, crateFourY);
						}
					}
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */
	public int boxDone() {
		for(int i=0; i<gameOverPosX.length; i++){
			if(gameOverPosX[i]==-2) {
				if(i==0 || i==1 || i==2 || i==3){
					return i+1;
				}
			}
		}
		return -1;
	}

	public boolean allBoxesDone() {
		int count=0;
		for(int j=0; j<gameOverPosX.length; j++) {
			if(gameOverPosX[j]==-2) {
				count++;	
			}
		} 
		if(count==nbrOfCrates) {
			goal=1;
			stopMusic(usedAudioList,1);
			playMusic(usedAudioList,0);
			return true;
		} else
			return false;
	}

	/**
	 * 
	 * @param xVal
	 */
	public void setBoxValue(int xVal, int pos, int yVal) {
		gameOverPosX[pos]=xVal;
		gameOverPosY[pos]=yVal;
	}

	public void setCollideValues() {
		cratePos1[crateOneX][crateOneY]=1;
		cratePos2[crateTwoX][crateTwoY]=1;
		playerPos[crateOneX][crateOneY]=-1;
		playerPos[crateTwoX][crateTwoY]=-1;		
		blankMarks[endPosX1][endPosY1]=-2;
		blankMarks[endPosX2][endPosY2]=-2;
	}

	/**
	 * 
	 */
	@Override
	public void setGuiHeight() {frame_dx=640;}

	/**
	 * 
	 */
	@Override
	public void setGuiWidth() {frame_dy=640;}

	/**
	 * @return
	 */
	public int getHeight() {return frame_dy;}

	/**
	 * @return
	 */
	public int getWidth() {return frame_dx;}

	/**
	 * 
	 */
	@Override
	public String getImageName(int val) {
		try {
			Thread.sleep(10);
			if(val==0) {return "blank.png";}
			else if(val==1){return "blankmarked.png";}
			else if(val==2){return "player.png";}
			else if(val==3){return  "crate.png";}
			else if(val==4){return "cratemarked.png";}
			else if(val==5){return "wall.png";
			} 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String getAnimationName(int val) {
		try {
			Thread.sleep(10);
			if(val==0) {return "playerdef.png";}
			else if(val==1){return "player3.1.png";}
			else if(val==2){return "player3.2.png";}
			else if(val==3){return "player3.3.png";}
			else if(val==4){return "player3.4.png";}
			else if(val==5){return "player3.5.png";}
			else if(val==6){return "player3.6.png";}
			else if(val==7){return "player3.7.png";}
			else if(val==8){return "player3.8.png";}
			else if(val==9){return "player4.png";}
			else if(val==10){return "player4.1.png";}
			else if(val==11){return "player4.2.png";}
			else if(val==12){return "player5.png";}
			else if(val==13){return "player5.1.png";}
			else if(val==14){return "player5.2.png";
			} 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAudioFileName(int val) {
		try{
			Thread.sleep(10);
			if(val==0){return new File("levelCompleted.mp3").toURI().toString();
			}
			else if(val==1){return new File("zizibum.mp3").toURI().toString();
			}
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setDataStructures() {		
		finalEndPosX = new int[4];
		walls = new int [20][20];
		cratePos1 = new int [20][20];
		cratePos2 = new int [20][20];
		cratePos3 = new int [20][20];
		cratePos4 = new int [20][20];
		blankMarks = new int[20][20];
		playerPos = new int [20][20];
		xPos = new int[20];yPos = new int[20];
		gameOverPosX = new int[4];gameOverPosY = new int[4];
		usedPictureList = new ArrayList<BufferedImage>();
		usedPictureList = getPictureList();
		animationList = new ArrayList<BufferedImage>();
		animationList = getAnimationList();
		usedAudioList = new ArrayList<MediaPlayer>();
		usedAudioList = getAudioList();
		for(int x=0; x<xPos.length; x++) {
			xPos[x]=x*32;
			yPos[x]=x*32;
		}
	}

	@Override
	public int actualLevel() {
		if(level==1) {
			nbrOfCrates=2;
			return 1;
			}
		else if(level==2){
			nbrOfCrates=2;
			return 2;
			}
		else if(level==3){
			nbrOfCrates=2;
			return 3;
			}
		else
			return -1;
	}

	public void restartActionPerformed(java.awt.event.ActionEvent evt) {
		restart=true;
	}
	public void level1ActionPerformed(java.awt.event.ActionEvent evt) {
		level=1;
		for (int x=0; x<20; x++) {
			for (int y=0; y<20; y++) {
				walls[x][y]=0;
				playerPos[x][y]=0;
			}
		}
		blankMarks[endPosX1][endPosY1]=0;blankMarks[endPosX2][endPosY2]=0;
		endPosX1=11;endPosY1=9;
		endPosX2=11;endPosY2=10;
		cratePos1[crateOneX][crateOneY]=0;cratePos2[crateTwoX][crateTwoY]=0;
		playerPos[crateOneX][crateOneY]=0;playerPos[crateTwoX][crateTwoY]=0;
		x=12;y=12;

		for(int res=0; res<4; res++) {
			gameOverPosX[res]=0;
			gameOverPosY[res]=0;
		}
		crateOneX=8; crateOneY=8; 
		crateTwoX=8; crateTwoY=9;
		goal=0;moves=0;pushes=0;
	}
	public void level2ActionPerformed(java.awt.event.ActionEvent evt) {
		level=2;
		for (int x=0; x<20; x++) {
			for (int y=0; y<20; y++) {
				walls[x][y]=0;
				playerPos[x][y]=0;
			}
		}
		blankMarks[endPosX1][endPosY1]=0;blankMarks[endPosX2][endPosY2]=0;
		endPosX1=6;endPosY1=12;
		endPosX2=6;endPosY2=11;
		cratePos1[crateOneX][crateOneY]=0;cratePos2[crateTwoX][crateTwoY]=0;
		playerPos[crateOneX][crateOneY]=0;playerPos[crateTwoX][crateTwoY]=0;
		x=8;y=12;
		for(int res=0; res<4; res++) {
			gameOverPosX[res]=0;
			gameOverPosY[res]=0;
		}
		crateOneX=9; crateOneY=8; 
		crateTwoX=10; crateTwoY=8;
		goal=0;moves=0;pushes=0;
	}
	public void level3ActionPerformed(java.awt.event.ActionEvent evt) {
		level=3;
		for (int x=0; x<20; x++) {
			for (int y=0; y<20; y++) {
				walls[x][y]=0;
				playerPos[x][y]=0;
			}
		}
		blankMarks[endPosX1][endPosY1]=0;blankMarks[endPosX2][endPosY2]=0;
		endPosX1=13;endPosY1=10;
		endPosX2=13;endPosY2=9;
		cratePos1[crateOneX][crateOneY]=0;cratePos2[crateTwoX][crateTwoY]=0;
		playerPos[crateOneX][crateOneY]=0;playerPos[crateTwoX][crateTwoY]=0;
		x=11;
		y=11;

		for(int res=0; res<4; res++) {
			gameOverPosX[res]=0;
			gameOverPosY[res]=0;
		}
		crateOneX=6; crateOneY=10; 
		crateTwoX=8; crateTwoY=11;
		goal=0;moves=0;pushes=0;
	}
	public void restartLevel(){
		if(actualLevel()==1){
			for (int x=0; x<20; x++) {
				for (int y=0; y<20; y++) {
					walls[x][y]=0;
					playerPos[x][y]=0;
				}
			}
			blankMarks[endPosX1][endPosY1]=0;blankMarks[endPosX2][endPosY2]=0;
			endPosX1=11;endPosY1=9;endPosX2=11;endPosY2=10;
			cratePos1[crateOneX][crateOneY]=0;cratePos2[crateTwoX][crateTwoY]=0;
			playerPos[crateOneX][crateOneY]=0;playerPos[crateTwoX][crateTwoY]=0;
			x=12;y=12;
			for(int res=0; res<4; res++) {
				gameOverPosX[res]=0;
				gameOverPosY[res]=0;
			}
			crateOneX=8;crateOneY=8;crateTwoX=8; crateTwoY=9;
			goal=0;moves=0;pushes=0;restart=false;
		} else if(actualLevel()==2){
			for (int x=0; x<20; x++) {
				for (int y=0; y<20; y++) {
					walls[x][y]=0;
					playerPos[x][y]=0;
				}
			}
			blankMarks[endPosX1][endPosY1]=0;blankMarks[endPosX2][endPosY2]=0;
			endPosX1=6;endPosY1=12;
			endPosX2=6;endPosY2=11;
			cratePos1[crateOneX][crateOneY]=0;cratePos2[crateTwoX][crateTwoY]=0;
			playerPos[crateOneX][crateOneY]=0;playerPos[crateTwoX][crateTwoY]=0;
			x=8;y=12;
			for(int res=0; res<4; res++) {
				gameOverPosX[res]=0;
				gameOverPosY[res]=0;
			}
			crateOneX=9; crateOneY=8; 
			crateTwoX=10; crateTwoY=8;
			goal=0;moves=0;pushes=0;restart=false;
		}
		if(actualLevel()==3){
			for (int x=0; x<20; x++) {
				for (int y=0; y<20; y++) {
					walls[x][y]=0;
					playerPos[x][y]=0;
				}
			}
			blankMarks[endPosX1][endPosY1]=0;blankMarks[endPosX2][endPosY2]=0;
			endPosX1=13;endPosY1=10;endPosX2=13;endPosY2=9;cratePos1[crateOneX][crateOneY]=0;
			cratePos2[crateTwoX][crateTwoY]=0;playerPos[crateOneX][crateOneY]=0;playerPos[crateTwoX][crateTwoY]=0;
			x=11;y=11;
			for(int res=0; res<4; res++) {gameOverPosX[res]=0;gameOverPosY[res]=0;}
			crateOneX=6; crateOneY=10; crateTwoX=8; crateTwoY=11;goal=0;moves=0;pushes=0;restart=false;
		}
	}

	@Override
	public String getGameName() {return "Sokoban";}

	@Override
	public String getMenuBarName() {return "Play";}

	@Override
	public String[] menuBarItems() {String[] arr = {"Restart", "Level 1", "Level 2", "Level 3", "Level 4"};
	return arr;
	}

	@Override
	public int[] gameLocationOnScreen() {
		int[] arr = {300,0};
		return arr;
	}

	public int incMoves(){
		if(goal==0){moves++;}
		return moves;
	} 
	public int incPushes(){
		if(goal==0){pushes++;}
		return pushes;
	} 

	public void levelOneGridValues() {
		for(int x=5 ; x<14; x++){
			if(x==8) {walls[x][10]=1;playerPos[x][10]=-1;}
			if(x==9){walls[x][7]=1;playerPos[x][7]=-1;walls[x][12]=1;playerPos[x][12]=-1;}
			else if(x==10){walls[x][10]=1;playerPos[x][10]=-1;walls[x][9]=1;playerPos[x][9]=-1;}
			else if(x==12){walls[x][10]=1;playerPos[x][10]=-1;walls[x][7]=1;playerPos[x][7]=-1;walls[x][10]=1;
			playerPos[x][10]=-1;walls[x][6]=1;playerPos[x][6]=-1;}
			walls[x][13]=1;playerPos[x][13]=-1;
			for (int y=7; y<13; y++){walls[13][y]=1;playerPos[13][y]=-1;}
			for(int xx=8; xx>5; xx--){walls[xx][7]=1;playerPos[xx][7]=-1;
			for (int y=7; y<11; y++){walls[6][y]=1;playerPos[6][y]=-1;}
			for (int y=10; y<14; y++){walls[5][y]=1;playerPos[5][y]=-1;}
			}
			for (int xxx=12; xxx>8; xxx--){walls[xxx][6]=1;playerPos[xxx][6]=-1;}
		}
	}

	public void levelTwoGridValues() {
		for(int x=5; x<10; x++){
			if(x==7){walls[x][11]=1;playerPos[x][11]=-1;walls[x][9]=1;playerPos[x][9]=-1;walls[x][8]=1;playerPos[x][8]=-1;}
			walls[x][13]=1;playerPos[x][13]=-1;
			for(int xx=9; xx<13; xx++){
				if(xx==12) {walls[xx][7]=1;playerPos[xx][7]=-1;}
				else if(xx==11){walls[xx][7]=1;playerPos[xx][7]=-1;}
				else if(xx==10){walls[xx][10]=1;playerPos[xx][10]=-1;walls[xx][9]=1;playerPos[xx][9]=-1;walls[xx][7]=1;
				playerPos[xx][7]=-1;walls[10][xx]=1;playerPos[xx][10]=-1;walls[xx][9]=1;
				playerPos[xx][9]=-1;walls[xx][7]=1;playerPos[xx][7]=-1;}walls[xx][12]=1;playerPos[xx][12]=-1;
				for(int y=12; y>7; y--){walls[12][y]=1;playerPos[12][y]=-1;}
				for(int y=12; y>6; y--){walls[5][y]=1;playerPos[5][y]=-1;}
				for(int xxx=5; xxx<11; xxx++){
					if(xxx==8){walls[xxx][8]=1;playerPos[xxx][8]=-1;}
					walls[xxx][6]=1;playerPos[xxx][6]=-1;
				}
			}
		}
	}

	public void levelThreeGridValues(){
		for(int x=4; x<9; x++){
			if(x==5){walls[x][10]=1;playerPos[x][10]=-1;}
			walls[x][13]=1;playerPos[x][13]=-1;
			for(int xx=8; xx<12; xx++){walls[xx][12]=1;playerPos[xx][12]=-1;}
			for(int xxx=11; xxx<16; xxx++){walls[xxx][13]=1;playerPos[xxx][13]=-1;}
			for(int y=12; y>5; y--){walls[15][y]=1;playerPos[15][y]=-1;}
			for(int y=12; y>6; y--){walls[4][y]=1;playerPos[4][y]=-1;}
			for(int xz=5; xz<10; xz++){walls[xz][7]=1;playerPos[xz][7]=-1;}
			for(int xzz=9; xzz<16; xzz++){
				if(xzz==12){walls[xzz][6]=1;playerPos[xzz][6]=-1;walls[xzz][9]=1;
				playerPos[xzz][9]=-1;walls[xzz][8]=1;playerPos[xzz][8]=-1;}
				else if(xzz==14){walls[xzz][10]=1;playerPos[xzz][10]=-1;walls[xzz][9]=1;playerPos[xzz][9]=-1;}
				walls[xzz][5]=1;playerPos[xzz][5]=-1;}
			for(int xc=7; xc<13; xc++){
				if(xc==9){walls[xc][6]=1;playerPos[xc][6]=-1;walls[xc][8]=1;playerPos[xc][8]=-1;}
				walls[xc][10]=1;playerPos[xc][10]=-1;
			}
		}
	}

	@Override
	public String getSymbol() {
		// TODO Auto-generated method stub
		return null;
	}


}
