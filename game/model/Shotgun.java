package game.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Shotgun extends Bullet {

    private final double FIRE_POWER = 100.0;
    private int bulletLeft = 3;

    public Shotgun(Falcon fal) {
        super(fal);
        setExpiry(10);
        setRadius(15);
        //everything is relative to the falcon ship that fired the bullet
        setDeltaX(fal.getDeltaX() +
                Math.cos(Math.toRadians(fal.getOrientation())) * FIRE_POWER);
        setDeltaY(fal.getDeltaY() +
                Math.sin(Math.toRadians(fal.getOrientation())) * FIRE_POWER);
        setCenter(fal.getCenter());

        //set the bullet orientation to the falcon (ship) orientation
        setOrientation(fal.getOrientation());

        //make sure to setCartesianPoints last
        //defined the points on a cartesean grid
        List<Point> pntCs = new ArrayList<>();

        pntCs.add(new Point(0, 5)); //top point

        pntCs.add(new Point(1, -5));
        pntCs.add(new Point(0, -8));
        pntCs.add(new Point(-1, -2));
        setCarteseans(pntCs);

    }
    @Override
    public void move() {
        super.move();
        expire();

    }

    public int getBulletLeft(){
        return bulletLeft;
    }

    public void useBullet(){
        bulletLeft -= 1;
    }

    public void resetBullet(){
        bulletLeft = 3;
    }
}
