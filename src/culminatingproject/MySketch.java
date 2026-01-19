
package culminatingproject;

import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
public class MySketch extends PApplet {

    private buddha buddha;
    private player player;
    int stage = 0;
    boolean up, down, left, right, slow, shoot;
    private int counter1 = 0;
    private int counter2 = 0;
    private int counter3=0;
    private int counter4=0;
    private int counter5=0;
    private int counter6=0;
    private int lives;
    PImage p,m;
    boolean moveRight = true;
    private int substage=0;
    private int subsubstage=0;
    Random rand = new Random();
    private int timer;
    private int bestTime=500;
    private int bestLives=0;
    File scoreFile = new File("score.txt");
    
      
//change back to 0 for main menue
    @Override
    public void keyPressed() {
        if (stage < 2||stage==6) {
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
    @Override
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
    @Override
    public void settings() {
        size(1600, 1000);
    }
    @Override
    public void setup() {
        

        background(97, 64, 81);
        buddha = new buddha(this, 800, 300, "images/buddha.png");
        player = new player(this, 20, 50, 800, 700);
        p = loadImage("images/buddha.png");
        m=loadImage("images/monkey.png");
        try{
    Scanner fileInput=new Scanner (scoreFile);

    while(fileInput.hasNext()){
        String output=fileInput.nextLine();
        String[]info=output.split(",");
        if(Integer.parseInt(info[0])<bestTime){
            bestTime=Integer.parseInt(info[0]);
        }
        if(Integer.parseInt(info[1])>bestLives){
            bestLives=Integer.parseInt(info[1]);
        }
    }
    fileInput.close();
}catch(IOException ioException){
    
}
    }
    @Override
    public void draw() {
        //reminder that our effective screen is 1000 tall and wide
        background(97, 64, 81);
        fill(0, 0, 0);
        rect(0, 0, 300, 1000);
        rect(1300, 0, 300, 1000);
        lives=player.lives();
        
        if (stage == 0) {
            fill(0, 0, 0);
            rect(0, 0, 1600, 1000);
            fill(255, 0, 0);
            textSize(50);
            this.text("Journey To The West", 550, 300);
            textSize(30);
            this.text("Fight Against Buddha", 650, 400);
            this.text("Press Anything to Begin", 650, 600);
            this.text("Best lives;"+bestLives+" Best time;"+bestTime, 650, 800);

        }
        if (stage == 1) {
            fill(0, 0, 0);
            rect(0, 0, 1600, 1000);
            fill(255, 0, 0);
            textSize(50);
            this.text("You are the Monkey King", 550, 300);
            textSize(30);
            this.text("The Buddha disrespects you, so you must beat his bald ass up", 500, 400);
            this.text("Use arrowkeys to move, z to shoot", 600, 600);
            this.text("Hold x to slow, press c to reverse fire", 600, 800);

        }

        if (stage == 2) {

            counter1 += 1;
            if (counter1 == 100) {
                buddha.ringShoot(0, 50);

            }
            if (counter1 == 200) {
                buddha.ringShoot(0, 75);
                counter1 = 0;
            }
        }
        if (stage == 3) {
            if (buddha.buddhaX() > 1250) {
                moveRight = false;
            }
            if (buddha.buddhaX() < 350) {
                moveRight = true;
            }
            counter2 += 1;
            if (buddha.buddhaY() > 80) {
                buddha.moveBuddha(0, 3);
            }
            if (counter2 == 30) {
                buddha.shootBuddha(270);
                counter2 = 0;
            }
            if (moveRight) {
                buddha.moveBuddha(3, 0);
            } else {
                buddha.moveBuddha(-3, 0);
            }

        }

        if (stage == 4) {
//            if (substage == 0) {
//                buddha.moveBuddha(0, 5);
//                if (buddha.buddhaY() < -150) {
//                    substage += 1;
//                }
//            }
//
//            if (substage >= 1) {
//                while (buddha.buddhaX() > 250 && buddha.buddhaX() < 1350 && buddha.buddhaY() > -50 && buddha.buddhaY() < 1050) {
//                    counter4 += 1;
//                }
//                if (counter4 == 30) {
//                    buddha.ringShoot(0, 50);
//                    counter4 = 0;
//                }
//
//                if (counter3 == 0) {
//                    subsubstage = 0;
//                    counter3 = rand.nextInt(4) + 1;
//                }
//
//                if (counter3 == 1) {
//                    if (subsubstage == 0) {
//                        buddha.buddhaTeleport(1250, 50);
//                        subsubstage += 1;
//                    }
//                    buddha.moveBuddha(-8, 0);
//                    if (buddha.buddhaX() < 250) {
//                        counter3 = 0;
//                    }
//                }
//
//                if (counter3 == 2) {
//                    if (subsubstage == 0) {
//                        buddha.buddhaTeleport(1250, 950);
//                        subsubstage += 1;
//                    }
//                    buddha.moveBuddha(-8, 0);
//                    if (buddha.buddhaX() < 250) {
//                        counter3 = 0;
//                    }
//                }
//
//                if (counter3 == 3) {
//                    if (subsubstage == 0) {
//                        buddha.buddhaTeleport(350, 50);
//                        subsubstage += 1;
//                    }
//                    buddha.moveBuddha(8, 0);
//                    if (buddha.buddhaX() > 1350) {
//                        counter3 = 0;
//                    }
//                }
//
//                if (counter3 == 0) {
//                    if (subsubstage == 0) {
//                        buddha.buddhaTeleport(350, 950);
//                        subsubstage += 1;
//                    }
//                    buddha.moveBuddha(8, 0);
//                    if (buddha.buddhaX() > 1350) {
//                        counter3 = 0;
//                    }
//                }
//
//            }
        }
        
        if(stage==5){
            if(buddha.buddhaX()>800){
                buddha.moveBuddha(-5,0);
            }
            if(buddha.buddhaX()<800){
                buddha.moveBuddha(5,0);
            }
            if(buddha.buddhaY()>500){
                buddha.moveBuddha(0,5);
            }
            if(buddha.buddhaY()<500){
                buddha.moveBuddha(0,-5);
            }
            if (Math.abs(buddha.buddhaX() - 800) <= 5 && Math.abs(buddha.buddhaY() - 500) <= 5) {
                buddha.moveBuddha(800 - buddha.buddhaX(), 500 - buddha.buddhaY());
            }

            if (buddha.buddhaX() == 500 || buddha.buddhaY() == 500) {
                counter5 += 1;
                counter6 += 1;
                if (counter5 == 15) {
                    buddha.shootBuddha(counter6);
                    buddha.shootBuddha(counter6 + 90);
                    buddha.shootBuddha(counter6 + 180);
                    buddha.shootBuddha(counter6 + 270);
                }
                if (counter5 == 30) {
                    buddha.shootBuddha(counter6);
                    buddha.shootBuddha(counter6 + 90);
                    buddha.shootBuddha(counter6+180);
                    buddha.shootBuddha(counter6+270);
                    buddha.ringShoot(counter6, 15);
                }
                if(counter5==45){
                    buddha.shootBuddha(counter6);
                    buddha.shootBuddha(counter6+90);
                    buddha.shootBuddha(counter6+180);
                    buddha.shootBuddha(counter6+270);
                    counter5=0;
                }
                if(counter6==360){
                    counter6=0;
                }
                

            }
        }
        
        if(stage==6){
           fill(0, 0, 0);
            rect(0, 0, 1600, 1000);
            fill(255, 0, 0);
            textSize(50);
            this.text("Victory", 550, 300);
            textSize(30);
            int time=timer%60;
            this.text("You took "+time+" secounds to defeat Buddha", 500, 400);
            this.text("You have "+lives+" lives left", 600, 600);

        }
        if(stage==7){
            try{
                FileWriter writer=new FileWriter("score.txt",true);
                PrintWriter output = new PrintWriter(writer);
                output.println(timer+","+lives);
                output.close();
            }catch(IOException ioException){
                
            }
            exit();
        }
        
        if (stage > 1 && stage < 6) {
            fill(255, 0, 0);
            textSize(15);
            this.text("Buddha Health", 1300, 100);
            this.text("Monkey Lives", 1300, 500);
            timer += 1;
            if (buddha.buddhaHealth() == 1500) {
                stage += 1;
            }
            if (buddha.buddhaHealth() == 1000) {
                stage += 1;
            }
            if (buddha.buddhaHealth() == 500) {
                stage += 1;
            }
            if (buddha.buddhaHealth() == 0) {
                stage += 1;
            }

            p.resize(100, 100);
            if (stage < 5) {
                image(p, 1400, 100);
            }
            if (stage < 4) {
                image(p, 1450, 100);
            }
            if (stage < 3) {
                image(p, 1500, 100);
            }
            
            m.resize(100, 100);
            if(lives==0){
                exit();
            }
            if (lives >1) {
                image(m, 1400, 500);
            }
            if (lives >2) {
                image(m, 1450, 500);
            }
            if (lives >3) {
                image(m, 1500, 500);
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

            buddha.drawBuddha(player);

        }

    }

}
