/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminatingproject;

/**
 *
 * @author 343012951
 */
public class projectile {
    private int x, y, direct, speed;
    private boolean active = false;
    
    public projectile(int x, int y, int direct, int speed){
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
}
