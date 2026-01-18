
package culminatingproject;
import processing.core.PApplet;

public class bullet extends projectile{
    private PApplet p;
    public bullet(int x, int y, double direct, int speed, PApplet p){
        super(x,y,direct,speed);
        this.p=p;
    }
    
    public void drawBullet(){
        this.x+=Math.cos(this.direct)*this.speed;
        this.y-=Math.sin(this.direct)*this.speed;
        if(this.y<0){
            this.toggle();
        }
        if(this.y>1000){
            this.toggle();
        }
        if(this.x>1300){
            this.toggle();
        }
        if(this.x<300){
            this.toggle();
        }
        this.p.fill(253,216,8);
        this.p.ellipse(this.x, this.y, 25, 25);
    }
    
}
