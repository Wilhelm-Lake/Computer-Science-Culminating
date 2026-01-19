
package culminatingproject;

import processing.core.PApplet;
import processing.core.PImage;

public class buddha {

    private int x;
    private int y;
    private int health = 2000;
    private PApplet app;
    private projectile[]bullets=new projectile[300];
    private PImage image;
    private boolean damage=false;

    //0 for normal, negative for glowingm positive for hurt

    public buddha(PApplet p, int x, int y,String imagePath) {
        this.x = x;
        this.y = y;
        this.app = p;
        this.image=app.loadImage(imagePath);
        for(int i=0; i<bullets.length;i++){
            bullets[i]=new bullet(0,0,1,5,app);
        }
        this.image.resize(100, 100);
    }

    
    public void drawBuddha(player p) {
        app.fill(255, 215, 0);
        if (this.damage==true){
            app.fill(204,153,102);
        }
        app.ellipse(this.x, this.y, 100, 100);
        app.image(image,x-50,y-50);
        for(int i=0; i<bullets.length;i++){
            
            bullet b = (bullet) bullets[i];
            
            if (b.collide(p)) {
                p.damage();
                
            }
            if (bullets[i].active() == true) {
                   b.drawBullet();
                }
        }
        this.damage=false;
    }

    public void shootBuddha(double angle) {
        for(int i=0; i<bullets.length;i++){
            if(bullets[i].active()==false){
                double radian = Math.toRadians(angle);
                bullets[i].changeX(this.x);
                bullets[i].changeY(this.y);
                bullets[i].changeDirect(radian);
                bullets[i].toggle();
                return;
            }
        }
    }
    
    public void ringShoot(double rotation, int numBullets){
        rotation = rotation % 360;
        double angleStep = 360.0/numBullets;
        for (int i=0;i<numBullets;i++){
            double angle =(i*angleStep)+rotation;
            shootBuddha(angle);

        }
        
    }

    public void moveBuddha(int dx, int dy) {
        this.x += dx;
        this.y -= dy;
    }

    public int buddhaX() {
        return this.x;
    }

    public int buddhaY() {
        return this.y;
    }

    
    public void damage(int damage){
        this.health-=damage;
        this.damage=true;
    }
    
    public int buddhaHealth(){
        return this.health;
    }
    
    public void buddhaTeleport(int x, int y){
        this.x=x;
        this.y=y;
    }
    

}
