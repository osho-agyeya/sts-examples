package com.app;

import java.awt.Graphics;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
public class Rectangle extends Shape {

    /*
     * (non-Javadoc)
     *
     * @see com.app.Shape#draw(java.awt.Graphics)
     */
    public void draw(final Graphics graphics) {
        // TODO Auto-generated method stub

        graphics.drawRect(this.start.x, this.start.y, Math.abs(this.end.x - this.start.x), Math.abs(this.end.y - this.start.y));
        System.out.println("Rectangle drawn");
    }

    public Shape createObject() {
        return new Rectangle();
    }

}
