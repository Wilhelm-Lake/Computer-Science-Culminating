package culminatingproject;

import processing.core.PApplet;

public class player {

    /*
    most are self explanatory
    width and height can technically be fixed
    it also has the array of projectiles
    shootDelay is used to delay shooting to not have laser of bullets
     */
    private int x;
    private int y;
    private int speed = 5;
    private PApplet app;
    private int width;
    private int height;
    private int lives = 4;
    private projectile[] bullets = new projectile[100];
    private int shootDelay = 0;

    /*
    @param papplet
    @param width
    @param height
    @param x
    @param y
     */
    public player(PApplet p, int width, int height, int x, int y) {
        this.app = p;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new playerBullet(0, 0, 1, app);

        }
    }

    /*
    @param t buddha we check for collision with
    we draw all active cards and check for collision with enemy
     */
    public void drawPlayer(buddha t) {
        app.fill(159, 129, 112);

        app.rect(x, y, width, height);
        for (int i = 0; i < bullets.length; i++) {
            playerBullet b = (playerBullet) bullets[i];
            if (b.collide(t)) {
                t.damage(1);
            }

            if (bullets[i].active() == true) {
                b.drawPlayerBullet();
            }
        }
    }

    /*
    @param slow if player is slowed or not
     */
    public void speedShift(boolean slow) {
        if (slow) {
            speed = 3;
        } else {
            speed = 6;
        }
    }

    /*
    @param x direction
    @param y direction
    moves in direction by speed
     */
    public void movePlayer(int x, int y) {
        this.x += x * speed;
        this.y -= y * speed;
    }

    //@param x
    public int playerX() {
        return this.x;
    }

    //@param y
    public int playerY() {
        return this.y;
    }

    /*
    increases shoot delay
    when high enough shoots a bullet by activating
    applying current x and y
     */
    public void shootPlayer() {
        if (shootDelay == 10) {
            shootDelay = 0;
            for (int i = 0; i < bullets.length; i++) {
                if (bullets[i].active() == false) {
                    bullets[i].changeX(this.x + 10);
                    bullets[i].changeY(this.y);
                    bullets[i].toggle();
                    return;
                }
            }
        } else {
            shootDelay += 1;
        }
    }

    /*
    decreases lives
     */
    public void damage() {

        lives -= 1;
    }

    //@param lives
    public int lives() {
        return this.lives;
    }

}
