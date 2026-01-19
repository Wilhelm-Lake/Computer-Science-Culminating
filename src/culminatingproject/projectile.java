
package culminatingproject;


public class projectile {
    public int x, y, speed;
    public double direct;
    private boolean active = false;
    
    
    public projectile(int x, int y, double direct){
        this.x=x;
        this.y=y;
        this.direct=direct;
        this.speed=15;
    }
    
    public projectile(int x, int y, double direct, int speed){
        this.x=x;
        this.y=y;
        this.direct=direct;
        this.speed=speed;
    }
    
    public void drawBullet(){
        this.x+=Math.cos(this.direct)*this.speed;
        this.y-=Math.sin(this.direct)*this.speed;
        if(this.y < 0 || this.y > 1000 || this.x < 300 || this.x > 1300) {
            this.x=-100;
            this.y=-100;
            this.unActive();
        }
    }
    
    
    public void toggle(){
        this.active = !this.active;

    }
    public void unActive(){
        this.active = false;
    }
    
    public boolean active(){
        return active;
    }
    
    public void changeX(int x){
        this.x=x;
    }
    public void changeY(int y){
        this.y=y;
    }
    
    public void changeDirect(double direct){
        this.direct= direct;
    }
}
