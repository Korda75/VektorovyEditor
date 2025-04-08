package cz.uhk.veditor.gui;

import cz.uhk.veditor.grobjekty.*;
import cz.uhk.veditor.grobjekty.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Hlavní okno
 */
public class MainWindow extends JFrame {

    private List<AbstractGeomObject> objekty = new ArrayList<>();

    private JToolBar toolBar;
    private JToggleButton btSquare;
    private JToggleButton btCircle;
    private JToggleButton btRectangle;
    private JToggleButton btTriangle;

    public MainWindow() {
        super("Vektorový editor");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initTestData();

        createToolBar();

        GraphPanel panel = new GraphPanel(objekty);
        add(panel, BorderLayout.CENTER);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    //kliknuto na leve tlacitko mysi
                    if(btCircle.isSelected()){
                        objekty.add(
                                new Circle(
                                        new Point(e.getX(), e.getY()),
                                        50,
                                        Color.BLUE
                                )
                        );
                    }
                    else if (btSquare.isSelected()) {
                        //kliknuto na leve tlacitko mysi
                            objekty.add(
                                    new Square(
                                            new Point(e.getX(), e.getY()),
                                            50,
                                            Color.RED
                                    )
                            );
                    } else if (btRectangle.isSelected()) {
                        objekty.add(
                                new Rectangle(
                                        new Point(e.getX(), e.getY()),
                                        50, 60,
                                        Color.GREEN
                                )
                        );
                    } else if (btTriangle.isSelected()) {
                        objekty.add(
                                new Triangle(
                                        new Point(e.getX(), e.getY()),
                                        50, 100, -50, 100, 0, 0,
                                        Color.MAGENTA
                                )
                        );
                    }
                    repaint();
                }
            }
        });

        setSize(800,600);
        setLocationRelativeTo(null);

    }

    private void createToolBar() {
        toolBar = new JToolBar(JToolBar.HORIZONTAL);
        add(toolBar, BorderLayout.NORTH);
        btSquare = new JToggleButton("Ctverec", new ImageIcon(getClass().getResource("/square.png")));
        btCircle = new JToggleButton("Kruznice", new ImageIcon(getClass().getResource("/circle.png")));
        btRectangle = new JToggleButton("Obdelnik", new ImageIcon(getClass().getResource("/rectangle.png")));
        btTriangle = new JToggleButton("Trojuhlenik", new ImageIcon(getClass().getResource("/triangle.png")));
        toolBar.add(btSquare);
        toolBar.add(btCircle);
        toolBar.add(btRectangle);
        toolBar.add(btTriangle);
        ButtonGroup gr = new ButtonGroup();
        gr.add(btSquare);
        gr.add(btCircle);
        gr.add(btRectangle);
        gr.add(btTriangle);
    }

    private void initTestData() {
        objekty.add(new Circle(new Point(100,100), 50, Color.BLUE));
        objekty.add(new Square(new Point(200,100), 50, Color.RED));
        objekty.add(new Circle(new Point(100,300), 50, Color.GREEN));
        objekty.add(new Circle(new Point(500,100), 50, Color.YELLOW));
        objekty.add(new Square(new Point(200,600), 50, Color.MAGENTA));
        objekty.add(new Circle(new Point(300,300), 50, Color.ORANGE));
        objekty.add(new Square(new Point(600,400), 50, Color.BLACK));
        objekty.add(new Triangle(new Point(100, 400), 100, 200, 150, 200, 200, 100, Color.GREEN));
    }


}
