

package culminatingproject;

import processing.core.PApplet;


public class playerBullet extends projectile{
    private PApplet app;
    public playerBullet(int x, int y, double direct, int speed, PApplet p){
        super(x,y,direct,speed);
        this.app=p;
    }
    
    public void drawPlayerBullet(){
        this.y-=this.speed;
        if(this.y<0){
            this.toggle();
        }
        this.app.fill(255,255,255);
        this.app.ellipse(this.x, this.y, 5, 5);
    }
    
}
