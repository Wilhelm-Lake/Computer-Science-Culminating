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

    
    
public class MySketch extends PApplet {
int stage= 0;
    public void settings() {
        size(1600, 1000);
    }

    public void setup() {
        background(97, 64, 81);
    }

    public void draw() {
        fill(0, 0, 0);
        rect(0,0,300,1000);
        rect(1300,0,300,1000);
        if (stage==0){
            fill(0,0,0);
            rect(0,0,1600,1000);
            fill(255,0 ,0);
            textSize(50);
            this.text("Journey To The West", 550, 300);
            textSize(30);
            this.text("Fight Against Buddha",650, 400);
            this.text("Press Anything to Begin",650, 600);
        }
    }
}
    

