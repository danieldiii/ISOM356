package typingGame;

import javax.swing.Timer;

import acm.graphics.GCompound;
import acm.graphics.GImage;

public class Burglar extends GCompound{
    private GImage image;
    GImage arrested;
    GImage escaped;
    Map map;
    Timer timer;
    public Burglar(Map map) {
    	    this.map = map;
        image = new GImage("/Users/Daniel/desktop/burglar.png");
        image.setSize(60, 60);
        this.add(image);
        if(Map.mapOption == 0){
        		this.setLocation(100,250);
        }
        else if(Map.mapOption == 1){
        		this.setLocation(50,250);
        }
        else{
        		this.setLocation(350,50);
        }       
    }
    
    public void move() {
        map.hasPassedThief((int)this.getY()/50,(int)this.getX()/50);
        switch(map.NextStepDirThief((int)this.getY()/50,(int)this.getX()/50)) {
        case 0:this.setLocation(this.getX(), this.getY()-50);break;
        case 1:this.setLocation(this.getX()+50, this.getY());break;   
        case 2:this.setLocation(this.getX(), this.getY()+50);break;
        case 3:this.setLocation(this.getX()-50, this.getY());break;
        case 4:this.setLocation(0,0);
        		   arrested = new GImage("/Users/Daniel/desktop/arrested.png");        		   
        		   arrested.setLocation(0,0);
        		   arrested.setSize(1050,700);
        		   this.add(arrested);          		   
        		   break;
        case 5:this.setLocation(0,0);
        		   escaped = new GImage("/Users/Daniel/desktop/escaped.png");
        		   escaped.setLocation(0,0);
        		   escaped.setSize(1050,700);
        		   this.add(escaped);   
        		   
        }
        
    }
    
}
