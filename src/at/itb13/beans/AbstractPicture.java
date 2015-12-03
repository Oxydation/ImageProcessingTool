package at.itb13.beans;

import Catalano.Imaging.FastBitmap;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * Created by Mathias on 23/11/2015.
 */
public abstract class AbstractPicture extends Component implements Serializable {
    private String _name =  "";
    private FastBitmap _original;
    private FastBitmap _result;

    protected PropertyChangeSupport _changes = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _changes.removePropertyChangeListener(l);
    }

    public FastBitmap getOriginal() {
        return _original;
    }

    public void setOriginal(FastBitmap original) {
        _changes.firePropertyChange("original", _original, original);
        _original = original;
    }

    public FastBitmap getResult() {
        return _result;
    }

    public void setResult(FastBitmap result) {
        FastBitmap old = _result;
        _result = result;
        _changes.firePropertyChange("result", old, result);
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawName(g, getName());
    }

    public Dimension getPreferredSize() {
        Graphics g = getGraphics();
        FontMetrics fm = g.getFontMetrics();
        int w = fm.stringWidth(getName()) + 2 * 10;
        int h = fm.getHeight() + 2 * 10;
        return new Dimension(w, h);
    }

    protected void drawName(Graphics g, String name) {
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
