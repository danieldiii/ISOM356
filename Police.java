package typingGame;

import acm.graphics.GCompound;
import acm.graphics.GImage;

public class Police extends GCompound{
    private GImage image;
    Map map;
    public Police(Map map) {
        image = new GImage("/Users/Daniel/desktop/police.png");
        image.setSize(60,60);
        this.map = map;
        this.add(image);
        this.setLocation(50,50);
    }
    
    public void move() {
        map.hasPassedPolice((int)this.getY()/50,(int)this.getX()/50);
        switch(map.NextStepDirPolice((int)this.getY()/50,(int)this.getX()/50)) {
        case 0:this.setLocation(this.getX(), this.getY()-50);break;
        case 1:this.setLocation(this.getX()+50, this.getY());break;   
        case 2:this.setLocation(this.getX(), this.getY()+50);break;
        case 3:this.setLocation(this.getX()-50, this.getY());break;        
        }
    }

}
