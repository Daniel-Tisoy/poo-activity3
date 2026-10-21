
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
public class PrismWindow extends JFrame implements ActionListener {
    
    private Container container;
    private JLabel lblHeight, lblSide, lblApothem, lblVolume, lblSurface;
    private JTextField txtSide, txtHeight, txtApothem;
    private JButton btnCalculate;

    public PrismWindow() {
        this.start();
        this.setTitle("Prism");
        this.setSize(280, 240);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

    }

    private void start() {
        Rectangle lblBounds = new Rectangle(20, 20, 135, 23);
        this.container = getContentPane();
        this.container.setLayout(null);

        this.lblSide = new JLabel();
        this.lblSide.setText("Side (cms): ");
        this.lblSide.setBounds(lblBounds);

        this.txtSide = new JTextField();
        lblBounds.setLocation(120, 20);
        this.txtSide.setBounds(lblBounds);

        this.lblHeight = new JLabel();
        this.lblHeight.setText("Height (cms): ");
        lblBounds.setLocation(20, 50);
        this.lblHeight.setBounds(lblBounds);

        this.txtHeight = new JTextField();
        lblBounds.setLocation(120, 50);
        this.txtHeight.setBounds(lblBounds);

        this.lblApothem = new JLabel();
        this.lblApothem.setText("Apothem (cms): ");
        lblBounds.setLocation(20, 80);
        this.lblApothem.setBounds(lblBounds);

        this.txtApothem = new JTextField();
        lblBounds.setLocation(120, 80);
        this.txtApothem.setBounds(lblBounds);

        this.btnCalculate = new JButton();
        this.btnCalculate.setText("Calculate");
        lblBounds.setLocation(120, 110);
        this.btnCalculate.setBounds(lblBounds);

        this.btnCalculate.addActionListener(this);

        this.lblVolume = new JLabel();
        this.lblVolume.setText("Volume (cm3): ");
        lblBounds.setLocation(20, 140);
        this.lblVolume.setBounds(lblBounds);

        this.lblSurface = new JLabel();
        this.lblSurface.setText("Surface (cm2): ");
        lblBounds.setLocation(20, 170);
        this.lblSurface.setBounds(lblBounds);
        
        //add image
        URL pngPrism = getClass().getResource("/images/hexagonal.png");
        
        if (pngPrism != null) {
            ImageIcon imageIcon = new ImageIcon(pngPrism);
            ImageIcon prismIcon = ImgResize.resize(imageIcon);
            JLabel imageLabel = new JLabel(prismIcon);
            imageLabel.setBounds(155, 140, 50, 50);

            this.container.add(imageLabel);
        } else {
            System.err.println("Image not found!");
        }

        this.container.add(this.btnCalculate);
        this.container.add(this.txtSide);
        this.container.add(this.lblSide);
        this.container.add(this.txtHeight);
        this.container.add(this.lblHeight);
        this.container.add(this.txtApothem);
        this.container.add(this.lblApothem);
        this.container.add(this.lblVolume);
        this.container.add(this.lblSurface);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Prism prism;
        boolean error;
        double inBase, inHeight, inApothem;

        if (e.getSource() == this.btnCalculate) {
            error = false;
            try {
                inBase = Double.parseDouble(this.txtSide.getText());
                inHeight = Double.parseDouble(this.txtHeight.getText());
                inApothem = Double.parseDouble(this.txtApothem.getText());

                prism = new Prism(inBase, inHeight, inApothem);

                this.lblVolume.setText("Volume (cm3): " + String.format("%.2f", prism.getVolume()));
                this.lblSurface.setText("Surface (cm2): " + String.format("%.2f", prism.getSurface()));
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
