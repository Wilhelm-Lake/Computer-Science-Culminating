
package culminatingproject;
import processing.core.PApplet;

/**
 *
 * @author 343012951
 */

    
    
public class MySketch extends PApplet {

    private buddha buddha;
    private player player;
    int stage = 2;
    boolean up, down, left, right, slow;
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
                slow=true;
            }
        }
}

    public void keyReleased() {
        if (key == 'x' || key == 'X') {
            slow=false;
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
    }

    public void settings() {
        size(1600, 1000);
    }

    public void setup() {
        background(97, 64, 81);
        buddha = new buddha(this, 800, 300, 40, 100);
        player = new player(this, 20, 50, 800, 700);

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

        } else if (stage>=2) {
            buddha.drawBuddha();
            player.drawPlayer();
            int dx = 0;
            int dy = 0;
            if (up && player.playerY() > -1) {
                dy += 1;
            }
            if (down && player.playerY() <949) {
                dy -= 1;
            }
            if (left && player.playerX() >300) {
                dx -= 1;
            }
            if (right && player.playerX() < 1280) {
                dx += 1;
            }
            player.speedShift(slow);
            player.movePlayer(dx, dy);
        }
    }

}

    

