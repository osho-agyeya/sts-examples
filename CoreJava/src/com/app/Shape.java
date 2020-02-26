package com.app;

import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
public abstract class Shape implements Serializable { //

    Point start;
    Point end;

    public abstract void draw(Graphics graphics);

    public abstract Shape createObject();


}
