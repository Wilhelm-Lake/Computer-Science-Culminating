package culminatingproject;

import processing.core.PApplet;
import processing.core.PImage;

public class buddha {

    /*
    x, y, and health are obvious
    as is PApplet and image
    damage is if it was recentally hit
    bullets is an array of bullets used by enemy
     */
    private int x;
    private int y;
    private int health = 2000;
    private PApplet app;
    private projectile[] bullets = new projectile[300];
    private PImage image;
    private boolean damage = false;

    /*
    @param PApplet
    @param x positiob
    @param y posiitiob
    @param image filename
    also loads entire array of bullets
     */
    public buddha(PApplet p, int x, int y, String imagePath) {
        this.x = x;
        this.y = y;
        this.app = p;
        this.image = app.loadImage(imagePath);
        for (int i = 0; i < bullets.length; i++) {
            bullets[i] = new bullet(0, 0, 1, 5, app);
        }
        this.image.resize(100, 100);
    }

    /*
    @param p the thing we're checking collision with
    draws the graphic, in a different picture if damaged
    uses loop to go through array checking collision and drawing active bullets
    uses downcasting to do the aforementioned because those are bullet not projectile methods
    resets damaged stat
     */
    public void drawBuddha(player p) {
        app.fill(255, 215, 0);
        if (this.damage == true) {
            app.fill(204, 153, 102);
        }
        app.ellipse(this.x, this.y, 100, 100);
        app.image(image, x - 50, y - 50);
        for (int i = 0; i < bullets.length; i++) {

            bullet b = (bullet) bullets[i];

            if (b.collide(p)) {
                p.damage();
                bullets[i].unActive();
                bullets[i].changeX(-100);
                bullets[i].changeY(-100);
            }
            if (bullets[i].active() == true) {
                b.drawBullet();
            }
        }
        this.damage = false;
    }

    /*
    @param angle for bullet to travel
    loops through array to find inactive bullet
    than activates the bullet with current x and y of buddha
    applies new direction
     */
    public void shootBuddha(double angle) {
        for (int i = 0; i < bullets.length; i++) {
            if (bullets[i].active() == false) {
                double radian = Math.toRadians(angle);
                bullets[i].changeX(this.x);
                bullets[i].changeY(this.y);
                bullets[i].changeDirect(radian);
                bullets[i].toggle();
                return;
            }
        }
    }

    /*
    @param rotation offset of bullet ring
    @param number of bullets in ring
    shoots evenly spaced bullets in every direction
    does so by dividing 360 by number of bullets and than
    shooting bullet at that interval
     */
    public void ringShoot(double rotation, int numBullets) {
        rotation = rotation % 360;
        double angleStep = 360.0 / numBullets;
        for (int i = 0; i < numBullets; i++) {
            double angle = (i * angleStep) + rotation;
            shootBuddha(angle);

        }

    }

    /*
    @param dx change in x
    @param dy change in y
    moves
     */
    public void moveBuddha(int dx, int dy) {
        this.x += dx;
        this.y -= dy;
    }

    /*
    @return x x position
     */
    public int buddhaX() {
        return this.x;
    }

    /*
    @return y y position
     */
    public int buddhaY() {
        return this.y;
    }

    /*
    @param damage , not really needed technically constant
    lowers health and toggles damaged state
     */
    public void damage(int damage) {
        this.health -= damage;
        this.damage = true;
    }

    /*
    @return health returns health
     */
    public int buddhaHealth() {
        return this.health;
    }

    /*
    @param x new x
    @param y new y
    telaports instead of moving
     */
    public void buddhaTeleport(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
