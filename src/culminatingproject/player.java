
package culminatingproject;
import processing.core.PApplet;


public class player {
    private int x;
    private int y;
    private int speed = 5;
    private int p=0;
    private int b =1;
    private PApplet app;
    private int width;
    private int height;
    private int lives =4;
    private projectile[]bullets=new projectile[100];
    private int shootDelay=0;
    
    
    public player(PApplet p, int width,int height, int x, int y){
        this.app=p;
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
        for(int i=0; i<bullets.length;i++){
            bullets[i]=new playerBullet(0,0,1,app);
            
        }
    }
    
    public void drawPlayer(buddha t) {
        app.fill(159, 129, 112);
        
        app.rect(x, y, width, height);
        for (int i = 0; i < bullets.length; i++) {
            playerBullet b = (playerBullet) bullets[i];
            if (b.collide(t)) {
                t.damage(1);
            }
            
            if (bullets[i].active() == true) {
                b.drawPlayerBullet();
            }
        }
    }

    public void speedShift(boolean slow) {
        if (slow) {
            speed = 3;
        } else {
            speed = 6;
        }
    }
    
    public void movePlayer(int x, int y){
        this.x+=x*speed;
        this.y-=y*speed;
    }
    public int playerX(){
        return this.x;
    }
    public int playerY(){
        return this.y;
    }

    public void shootPlayer() {
        if (shootDelay == 10) {
            shootDelay=0;
            for (int i = 0; i < bullets.length; i++) {
                if (bullets[i].active() == false) {
                    bullets[i].changeX(this.x+10);
                    bullets[i].changeY(this.y);
                    bullets[i].toggle();
                    return;
                }
            }
        } else {
            shootDelay += 1;
        }
    }
    
    public void damage(){
 
        lives-=1;
    }
    
    public int lives(){
        return this.lives;
    }
    
    

}

