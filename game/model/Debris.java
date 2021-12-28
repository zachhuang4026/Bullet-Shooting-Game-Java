package edu.uchicago.gerber._08final.mvc.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import edu.uchicago.gerber._08final.mvc.controller.Game;
import javafx.util.Pair;

public class Debris extends Sprite {

    public Debris() {
        super();

        setTeam(Team.DEBRIS);
        setColor(Color.YELLOW);

        //set random DeltaX
        setDeltaX(somePosNegValue(10));

        //set random DeltaY
        setDeltaY(somePosNegValue(10));

        //set random spin
        setSpin(somePosNegValue(10));

        //random point on the screen
        setCenter(new Point(Game.R.nextInt(Game.DIM.width),
                Game.R.nextInt(Game.DIM.height)));

        //random orientation
        setOrientation(Game.R.nextInt(360));
        setRadius(20);
        // debris with random shape
        assignRandomShape();
    }

    @Override
    public void move() {
        super.move();
        //a debris spins
        setOrientation(getOrientation() + getSpin());
    }

    public void assignRandomShape (){

        //6.283 is the max radians
        final int MAX_RADIANS_X1000 =6283;

        int sides = Game.R.nextInt( 7 ) + 17;
        List<Pair<Double, Double>> polarPairs = new ArrayList<>();
        for ( int nC = 0; nC < sides; nC++ ){
            double theta = Game.R.nextInt(MAX_RADIANS_X1000) / 1000.0;
            double r = (800 + Game.R.nextInt(200)) / 1000.0;
            polarPairs.add(new Pair<>(theta,r));
        }

        setCarteseans(polarToCartesian(

                polarPairs.stream()
                        .sorted(new Comparator<Pair<Double, Double>>() {
                            @Override
                            public int compare(Pair<Double, Double> p1, Pair<Double, Double> p2) {
                                return  p1.getKey().compareTo(p2.getKey());
                            }
                        })
                        .collect(Collectors.toList()))
        );

    }
}
