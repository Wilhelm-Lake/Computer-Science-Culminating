

package culminatingproject;

import processing.core.PApplet;

public class playerBullet extends projectile {

    private PApplet app;

    public playerBullet(int x, int y, double direct, PApplet p) {
        super(x, y, direct);
        this.app = p;
    }

    public void drawPlayerBullet() {
        this.y -= this.speed;
        if (this.collide()) {
            this.unActive();
        }
        this.app.fill(255, 255, 255);
        this.app.ellipse(this.x, this.y, 30, 30);
    }
    
    public boolean collide(){
        if(this.y<0){
            return true;
        }
        return false;
    }

    public boolean collide(buddha b) {
       boolean box = false;
       boolean xCross=false;
       boolean yCross=false;
       int x=b.buddhaX()+50;
       int y =b.buddhaY()+50;
       int ourX=this.x+15;
       int ourY=this.y+15;
       if(Math.abs(ourX - x) <= 65){
           xCross=true;
       }
       if(Math.abs(ourY - y) <= 65){
           yCross=true;
       }
       if(yCross&&xCross){
           box=true;
           this.toggle();
       }
       
       return box;
    }
    
    
        @Override
    public void changeDirect(double direct){
        this.direct= this.direct+=180;
    }

}
