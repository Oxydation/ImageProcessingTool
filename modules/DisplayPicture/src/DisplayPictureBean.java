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

    public Dimension getPreferredSize() {
        Graphics g = getGraphics();
        FontMetrics fm = g.getFontMetrics();
        int w = fm.stringWidth("Display") + 2 * 10;
        int h = fm.getHeight() + 2 * 10;
        return new Dimension(w, h);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if (_fastBitmap != null) {
            drawImage(g, _fastBitmap.toImage());
        } else {
            drawName(g, "Display");
        }
    }

    private void drawImage(Graphics g, Image image) {
        g.drawImage(image, 0, 0, 200, 100, null);
    }

    private void drawName(Graphics g, String name) {
        super.paint(g);
        Dimension d = getSize();
        int w = d.width;
        int h = d.height;
        FontMetrics fm = g.getFontMetrics();
        int x = (d.width - fm.stringWidth(name)) / 2;
        int y = (d.height + fm.getMaxAscent() -
                fm.getMaxDescent()) / 2;
        g.drawString(name, x, y);
        g.drawRect(0, 0, w - 1, h - 1);
    }
}
