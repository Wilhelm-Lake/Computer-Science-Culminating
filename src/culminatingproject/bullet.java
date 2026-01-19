
package culminatingproject;

import processing.core.PApplet;

public class bullet extends projectile {

    private PApplet p;

    /*
    @param x
    @param y
    @param direct
    @param p
    normal stuff
     */
    public bullet(int x, int y, double direct, int speed, PApplet p) {
        super(x, y, direct, speed);
        this.p = p;
    }

    /*
    draws bullet
    calls super.drawbullet
    checks if bullet is offscreen, moves it using sin and cos based off angle
    then draws
     */
    @Override
    public void drawBullet() {
        super.drawBullet();
        this.p.fill(253, 216, 8);
        this.p.ellipse(this.x, this.y, 25, 25);
    }

    /*
    checks if colliding with player using x and y difference greather than or lesser than
    radius sum method
     */
    public boolean collide(player p) {
        boolean box = false;
        boolean xCross = false;
        boolean yCross = false;
        int x = p.playerX() + 10;
        int y = p.playerY() + 25;
        int ourX = this.x + 15;
        int ourY = this.y + 15;
        if (Math.abs(ourX - x) <= 16) {
            xCross = true;
        }
        if (Math.abs(ourY - y) <= 50) {
            yCross = true;
        }
        if (yCross && xCross) {
            box = true;
            this.unActive();
        }

        return box;
    }

}
