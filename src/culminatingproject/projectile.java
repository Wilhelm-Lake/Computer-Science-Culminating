package culminatingproject;

public class projectile {

    //simple stuff
    public int x, y, speed;
    public double direct;
    private boolean active = false;

    /*
    @param x
    @param y
    @param direct
     */
    public projectile(int x, int y, double direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = 15;
    }

    /*
    @param x
    @param y
    @param direct
    @param speed
     */
    public projectile(int x, int y, double direct, int speed) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.speed = speed;
    }

    /*
    draws bullet
    not realy used since there are no actual projectile objects
     */
    public void drawBullet() {
        this.x += Math.cos(this.direct) * this.speed;
        this.y -= Math.sin(this.direct) * this.speed;
        if (this.y < 0 || this.y > 1000 || this.x < 300 || this.x > 1300) {
            this.x = -100;
            this.y = -100;
            this.unActive();
        }
    }

    //toggles active
    public void toggle() {
        this.active = !this.active;

        //decatives active, originally meant to be used to count missed bullets
    }

    public void unActive() {
        this.active = false;
    }

    //@param active
    public boolean active() {
        return active;
    }

    //@param x changes x
    public void changeX(int x) {
        this.x = x;
    }

    //@param y changes y
    public void changeY(int y) {
        this.y = y;
    }

    //@param direct changes direct
    public void changeDirect(double direct) {
        this.direct = direct;
    }
}
