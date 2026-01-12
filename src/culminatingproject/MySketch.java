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
    private buddha buddha;
int stage=2;
//change back to 0 for main menue

public void keyPressed(){
    if (stage<2){
        stage+=1;
    }
}

    public void settings() {
        size(1600, 1000);
    }

    public void setup() {
        background(97, 64, 81);
        buddha=new buddha(this, 800, 500, 40, 100);
        
    }

    public void draw() {
        //reminder that our effective screen is 1000 tall and wide
        background(97, 64, 81);
        fill(0, 0, 0);
        rect(0, 0, 300, 1000);
        rect(1300, 0, 300, 1000);
        if (stage == 0) {
            fill(0, 0, 0);
            rect(0, 0, 1600, 1000);
            fill(255, 0, 0);
            textSize(50);
            this.text("Journey To The West", 550, 300);
            textSize(30);
            this.text("Fight Against Buddha", 650, 400);
            this.text("Press Anything to Begin", 650, 600);


        } else if (stage == 1) {
            fill(0, 0, 0);
            rect(0, 0, 1600, 1000);
            fill(255, 0, 0);
            textSize(50);
            this.text("You are the Monkey King", 550, 300);
            textSize(30);
            this.text("The Buddha disrespects you, so you must beat his bald ass up", 500, 400);
            this.text("Use arrowkeys to move, z to shoot", 600, 600);

        } else if (stage == 2) {
            buddha.drawBuddha();

        }
    }

}

    

