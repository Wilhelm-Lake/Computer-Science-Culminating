
package culminatingproject;


public class projectile {
    public int x, y, speed;
    public double direct;
    private boolean active = false;
    
    public projectile(int x, int y, double direct, int speed){
        this.x=x;
        this.y=y;
        this.direct=direct;
        this.speed=speed;
    }
    
    public void move(){
        this.x+=this.speed;
        this.y-=this.speed*this.direct;
    }
    
    public void toggle(){
        this.active = !this.active;
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
        this.direct= Math.tan(direct);
    }
}
