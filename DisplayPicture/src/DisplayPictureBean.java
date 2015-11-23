import Catalano.Imaging.FastBitmap;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Jasmin on 23.11.2015.
 */
public class DisplayPictureBean extends Canvas implements PropertyChangeListener {

    private FastBitmap _fastBitmap;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("result")) {
            _fastBitmap = (FastBitmap) evt.getNewValue();
            repaint();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(_fastBitmap != null){

            g.drawImage(_fastBitmap.toImage(), 0, 0, null);
        }else{
            g.drawChars("No image!".toCharArray(),0,9,0,0);
        }
    }
}
