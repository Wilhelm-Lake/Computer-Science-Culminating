
package culminatingproject;

import processing.core.PApplet;

public class buddha {

    private int x;
    private int y;
    private int movement = 0;
    private int health = 1500;
    private PApplet app;
    private int width=40;
    private int height=100;
    private projectile[]bullets=new projectile[300];

    //0 for normal, negative for glowingm positive for hurt

    public buddha(PApplet p, int x, int y) {
        this.x = x;
        this.y = y;
        this.app = p;
        for(int i=0; i<bullets.length;i++){
            bullets[i]=new bullet(0,0,1,5,app);
        }

    }

    public void drawBuddha() {
        app.fill(255, 215, 0);
        app.rect(x, y, width, height);
        for(int i=0; i<bullets.length;i++){
            if (bullets[i].active() == true) {
                bullet b = (bullet) bullets[i];
                   b.drawBullet();
                }
        }
    }

    public void shootBuddha(double angle) {
        for(int i=0; i<bullets.length;i++){
            if(bullets[i].active()==false){
                double radian = Math.toRadians(angle);
                bullets[i].changeX(this.x+this.width/2);
                bullets[i].changeY(this.y+this.height/2);
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

}
