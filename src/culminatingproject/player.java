/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package culminatingproject;
import processing.core.PApplet;

/**
 *
 * @author 343012951
 */
public class player {
    private int x;
    private int y;
    private int speed = 5;
    private int lives = 3;
    private int p=0;
    private int b =1;
    private PApplet app;
    private int width;
    private int height;
    
    
    public player(PApplet p, int width,int height, int x, int y){
        this.app=p;
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
    }
    
    public void drawPlayer() {
        app.fill(159, 129, 112);
        
        app.rect(x, y, width, height);
    }
    public void speedShift(boolean slow){
        if (slow){
            speed=3;
    }
        else {
            speed=6;
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
}


