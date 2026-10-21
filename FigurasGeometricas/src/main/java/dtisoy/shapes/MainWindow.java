package dtisoy.shapes;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author dtisoy
 */
public class MainWindow extends JFrame implements ActionListener {

    private Container container;
    private JButton btnCilinder, btnSphere, btnPiramid, btnCube, btnPrism;

    public MainWindow() {
        // añadir icono
        URL windowIconURL = getClass().getResource("/images/monitor.png");

        if (windowIconURL != null) {
            ImageIcon windowIcon = new ImageIcon(windowIconURL);

            this.setIconImage(windowIcon.getImage());
        } else {
            System.err.println("Couldn't load the app icon.");
        }
        this.start();
        this.setTitle("Shapes");
        this.setSize(550, 160);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void start() {

        this.container = this.getContentPane();
        this.container.setLayout(null);

        this.btnCilinder = new JButton();
        this.btnSphere = new JButton();
        this.btnPiramid = new JButton();
        this.btnCube = new JButton();
        this.btnPrism = new JButton();

        this.btnCilinder.setText("Cilinder");
        this.btnSphere.setText("Sphere");
        this.btnPiramid.setText("Piramid");
        this.btnCube.setText("Cube");
        this.btnPrism.setText("Prism");

        this.btnCilinder.setBounds(20, 50, 80, 23);
        this.btnSphere.setBounds(125, 50, 80, 23);
        this.btnPiramid.setBounds(225, 50, 80, 23);
        this.btnCube.setBounds(325, 50, 80, 23);
        this.btnPrism.setBounds(425, 50, 80, 23);

        this.btnCilinder.addActionListener(this);
        this.btnSphere.addActionListener(this);
        this.btnPiramid.addActionListener(this);
        this.btnCube.addActionListener(this);
        this.btnPrism.addActionListener(this);

        this.container.add(this.btnCilinder);
        this.container.add(this.btnSphere);
        this.container.add(this.btnPiramid);
        this.container.add(this.btnCube);
        this.container.add(this.btnPrism);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnSphere) {
            SphereWindow sphere = new SphereWindow();
            sphere.setVisible(true);
        }
        if (e.getSource() == this.btnCilinder) {
            CilinderWindow cilinder = new CilinderWindow();
            cilinder.setVisible(true);
        }

        if (e.getSource() == this.btnPiramid) {
            PiramidWindow piramid = new PiramidWindow();
            piramid.setVisible(true);
        }

        if (e.getSource() == this.btnCube) {
            CubeWindow cube = new CubeWindow();
            cube.setVisible(true);
        }
        if (e.getSource() == this.btnPrism) {
            PrismWindow prism = new PrismWindow();
            prism.setVisible(true);
        }
    }

}
