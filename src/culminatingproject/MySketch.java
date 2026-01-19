
package culminatingproject;

import processing.core.PApplet;
import processing.core.PImage;

public class MySketch extends PApplet {

    private buddha buddha;
    private int health;
    private int attack;
    private player player;
    int stage = 2;
    boolean up, down, left, right, slow, shoot;
    private int counter1 = 0;
    private int counter2 = 0;
    PImage p;
    private int lives=3;
    
            
//change back to 0 for main menue

    public void keyPressed() {
        if (stage < 2) {
            stage += 1;
        }
        if (stage >= 2) {
            if (keyCode == UP) {
                up = true;
            }
            if (keyCode == DOWN) {
                down = true;
            }
            if (keyCode == LEFT) {
                left = true;
            }
            if (keyCode == RIGHT) {
                right = true;
            }

            if (key == 'x' || key == 'X') {
                slow = true;
            }
            if (key == 'z' || key == 'Z') {
                shoot = true;
            }
        }
    }

    public void keyReleased() {
        if (key == 'x' || key == 'X') {
            slow = false;
        }
        if (keyCode == UP) {
            up = false;
        }
        if (keyCode == DOWN) {
            down = false;
        }
        if (keyCode == LEFT) {
            left = false;
        }
        if (keyCode == RIGHT) {
            right = false;
        }
        if (key == 'z' || key == 'Z') {
            shoot = false;
        }
    }

    public void settings() {
        size(1600, 1000);
    }

    public void setup() {
        background(97, 64, 81);
        buddha = new buddha(this, 800, 300, "images/buddha.png");
        player = new player(this, 20, 50, 800, 700);
        p=loadImage("images/buddha.png");

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

        }
        if (stage >= 2) {
            if(buddha.buddhaHealth()==200){
                stage+=1;
            }
            if(buddha.buddhaHealth()==100){
                stage+=1;
            }
            if(buddha.buddhaHealth()==0){
                stage+=1;
            }
            
            p.resize(100, 100);
            if(stage<5){
                image(p,1400,100);
            }
            if(stage<4){
                image(p,1450,100);
            }
            if(stage<3){
                image(p,1500,100);
            }
            
            
            
            
            int dx = 0;
            int dy = 0;
            if (up && player.playerY() > -1) {
                dy += 1;
            }
            if (down && player.playerY() < 949) {
                dy -= 1;
            }
            if (left && player.playerX() > 300) {
                dx -= 1;
            }
            if (right && player.playerX() < 1280) {
                dx += 1;
            }
            if (shoot) {
                player.shootPlayer();
            }
            player.speedShift(slow);
            player.movePlayer(dx, dy);
            player.drawPlayer(buddha);

            buddha.drawBuddha();

        }

        if (stage == 2) {
            textSize(15);
            this.text("Buddha Health", 1300, 100);
            counter1 += 1;
            if (counter1 == 100) {
                buddha.ringShoot(0, 50);

            }
            if (counter1 == 200) {
                buddha.ringShoot(0, 75);
                counter1 = 0;
            }
        }
    }

}
    

