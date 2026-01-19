package culminatingproject;

import processing.core.PApplet;

public class playerBullet extends projectile {

    private PApplet app;

    /*
    @param x
    @param y
    @param direct
    @param PApplet
    note this uses the version of the constructor without speed
     */
    public playerBullet(int x, int y, double direct, PApplet p) {
        super(x, y, direct);
        this.app = p;
    }

    /*
    moves bullet and deactives if it goes off screen then draws
     */
    public void drawPlayerBullet() {
        this.y -= this.speed;
        if (this.collide()) {

            this.unActive();
        }
        this.app.fill(255, 255, 255);
        this.app.ellipse(this.x, this.y, 30, 30);
    }

    /*
    checks if bullet is off screen
    @return off screen or not
     */
    public boolean collide() {
        if (this.y < 0) {
            return true;
        }
        return false;
    }

    /*
    @param b what we check for collission with
    checks if bullet is colliding with b
    overloaded constructor
    @return box if colliding
    checks using math by checking if x and y differences are equal to radius+radius
     */
    public boolean collide(buddha b) {
        boolean box = false;
        boolean xCross = false;
        boolean yCross = false;
        int x = b.buddhaX() + 50;
        int y = b.buddhaY() + 50;
        int ourX = this.x + 15;
        int ourY = this.y + 15;
        if (Math.abs(ourX - x) <= 65) {
            xCross = true;
        }
        if (Math.abs(ourY - y) <= 65) {
            yCross = true;
        }
        if (yCross && xCross) {
            box = true;
            this.unActive();
        }

        return box;
    }

}
