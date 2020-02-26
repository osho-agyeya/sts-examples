package com.app;

import java.awt.Graphics;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
public class Line extends Shape {

    /*
     * (non-Javadoc)
     *
     * @see com.app.Shape#draw(java.awt.Graphics)
     */
    public void draw(final Graphics graphics) {
        // TODO Auto-generated method stub

        graphics.drawLine(this.start.x, this.start.y, this.end.x, this.end.y);
        System.out.println("Line drawn");
    }

    public Shape createObject() {
        return new Line();
    }


}
