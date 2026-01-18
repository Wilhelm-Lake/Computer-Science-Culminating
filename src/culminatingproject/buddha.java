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
public class buddha {

    private int x;
    private int y;
    private int movement = 0;
    private int health = 1500;
    private PApplet app;
    private int width;
    private int height;
    private projectile[]bullets=new projectile[100];

    //0 for normal, negative for glowingm positive for hurt

    public buddha(PApplet p, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.app = p;
        for(int i=0; i<bullets.length;i++){
            bullets[i]=new bullet(0,0,1,3);
        }

    }

    public void drawBuddha() {
        app.fill(255, 215, 0);
        
        app.rect(x, y, width, height);
    }

    public void shootBuddha(int x,int y,double angle) {
        for(int i=0; i<bullets.length;i++){
            if(bullets[i].active()==true){
                bullets[i].changeX(x);
                bullets[i].changeY(y);
                bullets[i].changeDirect(angle);
                return;
            }
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
