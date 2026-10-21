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
public class CilinderWindow extends JFrame implements ActionListener {

    private Container container;
    private JLabel lblRadio, lblVolume, lblSurface, lblHeight;
    private JTextField txtRadio, txtHeight;
    private JButton btnCalculate;

    public CilinderWindow() {
        this.start();
        this.setTitle("Cilinder");
        this.setSize(280, 210);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    private void start() {

        Rectangle rtlBounds = new Rectangle(20, 20, 135, 23);
        this.container = getContentPane();
        this.container.setLayout(null);
        this.lblRadio = new JLabel();
        this.lblRadio.setText(
                "Radio(cms): ");
        this.lblRadio.setBounds(rtlBounds);
        this.txtRadio = new JTextField();
        rtlBounds.setLocation(100, 20);
        this.txtRadio.setBounds(rtlBounds);
        this.lblHeight = new JLabel();
        this.lblHeight.setText("Height (cms):");
        rtlBounds.setLocation(20, 50);
        this.lblHeight.setBounds(rtlBounds);

        this.txtHeight = new JTextField();
        rtlBounds.setLocation(100, 50);
        this.txtHeight.setBounds(rtlBounds);
        this.btnCalculate = new JButton();
        this.btnCalculate.setText("Calculate");
        rtlBounds.setLocation(100, 80);
        this.btnCalculate.setBounds(rtlBounds);
        this.btnCalculate.addActionListener(this);
        this.lblVolume = new JLabel();
        this.lblVolume.setText("Volumen(cm3): ");
        rtlBounds.setLocation(20, 110);
        this.lblVolume.setBounds(rtlBounds);

        this.lblSurface = new JLabel();
        this.lblSurface.setText("Superficie(cm2): ");
        rtlBounds.setLocation(20, 140);

        //add image
        URL pngCilinder = getClass().getResource("/images/cilindro.png");
        
        if (pngCilinder != null) {
            ImageIcon imageIcon = new ImageIcon(pngCilinder);
            ImageIcon cilinderIcon = ImgResize.resize(imageIcon);
            JLabel imageLabel = new JLabel(cilinderIcon);
            imageLabel.setBounds(155, 110, 50, 50);

            this.container.add(imageLabel);
        } else {
            System.err.println("Image not found!");
        }

        this.lblSurface.setBounds(rtlBounds);
        this.container.add(this.lblRadio);
        this.container.add(this.txtRadio);
        this.container.add(this.lblHeight);
        this.container.add(this.txtHeight);
        this.container.add(this.btnCalculate);
        this.container.add(this.lblVolume);
        this.container.add(this.lblSurface);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean error = false;
        double inRadio;
        double inHeight;
        try {
            inRadio = Double.parseDouble(this.txtRadio.getText());
            inHeight = Double.parseDouble(this.txtHeight.getText());
            Cilinder cilinder = new Cilinder(inRadio, inHeight);

            this.lblVolume.setText("Volume (cm3): " + String.format("%.2f", cilinder.getVolume()));
            this.lblSurface.setText("Surface (cm2): " + String.format("%.2f", cilinder.getSurface()));

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
