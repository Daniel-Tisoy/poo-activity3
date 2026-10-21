
package dtisoy.shapes;

import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author dtisoy
 */
class CubeWindow extends JFrame implements ActionListener{
    private Container container;
    private JLabel lblSide, lblVolume, lblSurface;
    private JTextField txtSide;
    private JButton btnCalculate;

    public CubeWindow() {
        this.start();
        this.setTitle("Cube");
        this.setSize(280, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    private void start() {
        Rectangle lblBounds = new Rectangle(20, 20, 135, 23);
        this.container = getContentPane();
        this.container.setLayout(null);

        this.lblSide = new JLabel();
        this.lblSide.setText("Side (cms); ");
        this.lblSide.setBounds(lblBounds);

        this.txtSide = new JTextField();
        lblBounds.setLocation(100, 20);
        this.txtSide.setBounds(lblBounds);

        this.btnCalculate = new JButton();
        this.btnCalculate.setText("Calculate");
        lblBounds.setLocation(100, 50);
        this.btnCalculate.setBounds(lblBounds);

        this.btnCalculate.addActionListener(this);

        this.lblVolume = new JLabel();
        this.lblVolume.setText("Volume (cm3): ");
        lblBounds.setLocation(20, 90);
        this.lblVolume.setBounds(lblBounds);

        this.lblSurface = new JLabel();
        this.lblSurface.setText("Surface (cm2): ");
        lblBounds.setLocation(20, 120);
        this.lblSurface.setBounds(lblBounds);

         URL pngCube = getClass().getResource("/images/cubo.png");
        if (pngCube != null) {
            ImageIcon imageIcon = new ImageIcon(pngCube);
            ImageIcon cubeIcon = ImgResize.resize(imageIcon);
            JLabel imageLabel = new JLabel(cubeIcon);
            imageLabel.setBounds(155, 90, 50, 50);

            this.container.add(imageLabel);
        } else {
            System.err.println("Image not found!");
        }
        
        this.container.add(this.btnCalculate);
        this.container.add(this.lblSide);
        this.container.add(this.lblSurface);
        this.container.add(this.lblVolume);
        this.container.add(this.txtSide);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.btnCalculate) {
            boolean error = false;
            try {
                double side = Double.parseDouble(this.txtSide.getText());

                Cube cube = new Cube(side);

                this.lblVolume.setText("Volume (cm3): " + String.format("%.2f", cube.getVolume()));
                this.lblSurface.setText("Surface (cm2): " + String.format("%.2f", cube.getSurface()));
            } catch (NumberFormatException err) {
                error = true;
            } finally {
                if (error) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Null field or error in the number format",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);

                }
            }
        }
    }
}
