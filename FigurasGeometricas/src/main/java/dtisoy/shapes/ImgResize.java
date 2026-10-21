package dtisoy.shapes;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author dtisoy
 */
public class ImgResize {

    public static ImageIcon resize(ImageIcon icon) {
        Image scalated = icon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        ImageIcon finalIcon = new ImageIcon(scalated);
        return finalIcon;
    }
}
