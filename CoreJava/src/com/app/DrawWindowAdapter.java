
package com.app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
public class DrawWindowAdapter extends WindowAdapter {

    /*
     * (non-Javadoc)
     *
     * @see
     * java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
     */

    public void windowClosing(final WindowEvent e) {
        // TODO Auto-generated method stub
        // super.windowClosing(e);
        System.exit(0);
    }


}
