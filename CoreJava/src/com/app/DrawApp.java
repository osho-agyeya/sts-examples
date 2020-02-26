
package com.app;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DrawApp extends Frame {

    private Canvas drawCanvas;
    private Shape shape = new Line();
    private List<Shape> allShapes = new ArrayList<>();

    private DrawApp() {
        setSize(500, 500);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(final WindowEvent e) {
                System.exit(0);
            }
        });
        addComponents();
        setVisible(true);
    }

    private void addComponents() {
        Panel northPanel = new Panel();
        northPanel.setBackground(Color.BLUE);
        this.add(northPanel, BorderLayout.NORTH);

        Button lineButton = new Button("Line(Default)");
        northPanel.add(lineButton);
        lineButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.out.println("Line Clicked");
                DrawApp.this.shape = new Line();
            }
        });

        Button rectButton = new Button("Rectangle");
        northPanel.add(rectButton);
        rectButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.out.println("Rectangle clicked");
                DrawApp.this.shape = new Rectangle();
            }
        });

        Button ellipseButton = new Button("Ellipse");
        northPanel.add(ellipseButton);
        ellipseButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                System.out.println("Ellipse clicked");
                DrawApp.this.shape = new Ellipse();
            }
        });

        Panel southPanel = new Panel();
        southPanel.setBackground(Color.BLACK);
        this.add(southPanel, BorderLayout.SOUTH);

        Button saveButton = new Button("Save");
        Button loadButton = new Button("Load");
        Button clearButton = new Button("Clear");
        southPanel.add(saveButton);
        southPanel.add(loadButton);
        southPanel.add(clearButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try (FileOutputStream fos = new FileOutputStream("shapes.dat");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);) {
                    oos.writeObject(DrawApp.this.allShapes);
                    System.out.println("Shapes saved to shapes.dat");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try (FileInputStream fis = new FileInputStream("shapes.dat"); ObjectInputStream ois = new ObjectInputStream(fis);) {
                    DrawApp.this.allShapes = (List<Shape>) ois.readObject();
                    System.out.println("Shape array read from shapes.dat");
                    // DrawApp.this.drawCanvas.paint(DrawApp.this.drawCanvas.getGraphics());
                    // // if you use this it will keep the shapes drawn
                    // currently as it is
                    DrawApp.this.drawCanvas.repaint();
                    System.out.println("All loaded shapes drawn");
                } catch (FileNotFoundException ex) {
                    System.out.println("shapes.dat was not found.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                try {
                    DrawApp.this.allShapes.clear();
                    // DrawApp.this.drawCanvas.paint(DrawApp.this.drawCanvas.getGraphics());
                    DrawApp.this.drawCanvas.repaint();
                    System.out.println("Canvas cleared");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        class ClockThread extends Thread {

            public void run() {
                addTimeLabel(southPanel);
            }

        }
        this.drawCanvas = new DrawCanvas();
        this.add(this.drawCanvas, BorderLayout.CENTER);
        this.drawCanvas.addMouseListener(new CanvasMouseListener());

        ClockThread clockThread = new ClockThread();
        clockThread.start();
    }

    class CanvasMouseListener extends MouseAdapter {

        public void mousePressed(final MouseEvent e) {
            System.out.println("Mouse Pressed=" + e.getPoint());
            DrawApp.this.shape.start = e.getPoint();
        }

        public void mouseReleased(final MouseEvent e) {
            System.out.println("Mouse Released=" + e.getPoint());
            DrawApp.this.shape.end = e.getPoint();
            Graphics graphics = DrawApp.this.drawCanvas.getGraphics();
            DrawApp.this.shape.draw(graphics);
            DrawApp.this.allShapes.add(DrawApp.this.shape);
            try {
                DrawApp.this.shape = DrawApp.this.shape.getClass().newInstance();
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            }
        }

    }

    public class DrawCanvas extends Canvas {

        public void paint(final Graphics g) {
            for (Shape shape : DrawApp.this.allShapes) {
                shape.draw(g);
            }
        }

    }

    public void addTimeLabel(final Panel southPanel) {
        Label label = new Label();
        label.setForeground(Color.WHITE);
        southPanel.add(label);
        label.setText("Hello               ");
        while (true) { // this needs to go in a thread; we have to do it
            LocalTime time = LocalTime.now();
            label.setText(time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());
        }
    }

    public static void main(final String[] args) {
        new DrawApp();
    }

}
