package typingGame;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GRect;

public class Map extends GCompound{
	public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3; 
    public static final int ARRESTED = 4;
    public static final int ESCAPED = 5;
    private GImage car;
    GRect brick;
    
	int[][] road = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            		    {0,2,0,0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,0,0},
            		    {0,2,0,1,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0},
            		    {0,2,0,1,0,0,1,1,0,1,0,1,1,1,0,1,0,1,0,0,0},
            		    {0,2,0,1,0,1,1,0,0,1,0,0,0,0,0,1,0,1,0,0,0},
            		    {0,1,0,1,0,1,0,0,0,1,0,1,1,1,1,1,0,1,1,1,0},
            		    {0,1,1,1,0,1,1,1,0,1,0,1,0,0,0,0,0,0,0,1,0},
            		    {0,0,0,0,0,0,0,1,0,1,0,1,1,0,0,1,1,1,0,1,0},
            		    {0,1,1,1,1,1,1,1,0,1,0,0,1,0,0,1,0,1,0,1,0},
            		    {0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,1,0,1,0},
            		    {0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,0,1,1,1,0},
            		    {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
	
	 
	    public Map() {   
	    	car = new GImage("/Users/Daniel/desktop/car.png");
	    	car.setLocation(950,30);
	    	car.setSize(100, 80);
	    	this.add(car);
	    	 for (int i = 0; i<12; i++) {
	             for (int j = 0; j<21; j++) {
	                 if (road[i][j] != 0) {
	                     brick = new GRect(50,50);
	                     brick.setLocation(j*50,i*50);
	                     brick.setFilled(true);
	                     brick.setFillColor(Color.ORANGE);
	                     brick.setColor(Color.BLACK);	                     
	                     this.add(brick);
	                }
	            }
	        }
	       
	    }
	    public void hasPassedThief(int a, int b) {
	        this.road[a][b] = 2;
	    }
	    public void hasPassedPolice(int a, int b) {
	        this.road[a][b] = 3;
	    }
	    
	    public int NextStepDirThief (int a, int b) {
	        if (this.road[a][b+1]==3 || this.road[a-1][b]==3 ||this.road[a+1][b]==3||this.road[a][b-1]==3) {
	            return ARRESTED;
	        }
	        else if(this.road[a][b+1]==1) {
	            return RIGHT;
	        }
	        else if (this.road[a-1][b]==1) {
	            return UP;
	        }
	        else if(this.road[a+1][b]==1) {
	            return DOWN;
	        }
	        else if(this.road[a][b-1]==1) {
	            return LEFT;
	        }
	        else if (this.road[a][b+1] != 1 && this.road[a-1][b]!= 1 && this.road[a+1][b]!= 1 && this.road[a][b-1]!= 1) {
	            return ESCAPED;
	        }
	        else {
	            return -1;
	        }
	        
	    }
	    public int NextStepDirPolice (int a, int b) {
	        if(this.road[a][b+1]==2) {
	            return RIGHT;
	        }
	        else if (this.road[a-1][b]==2 ) {
	            return UP;
	        }
	        else if(this.road[a+1][b]==2) {
	            return DOWN;
	        }
	        else if(this.road[a][b-1]==2) {
	            return LEFT;
	        }
	        else {
	            return -1;
	        }
	        
	    }


}
