import Catalano.Imaging.FastBitmap;
import at.itb13.beans.AbstractPicture;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Mathias on 23/11/2015.
 */
public class ROI extends AbstractPicture implements PropertyChangeListener {
    private int _xOffset = 0;
    private int _yOffset = 60;
    private int _width = 445;
    private int _heigth = 75 ;

    public ROI() {
        setName(this.getClass().getName());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("result")) {
            setOriginal((FastBitmap) evt.getNewValue());
            process();
        }
    }

    private void process() {
        if (getOriginal() != null) {
            FastBitmap fastBitmap = new FastBitmap(getOriginal());
            FastBitmap roi = new FastBitmap(getOriginal().toBufferedImage().getSubimage(getXOffset(), getYOffset(), getWidth(), getHeigth()));
            setResult(roi);
            setOriginal(fastBitmap);
        }
    }

    public int getXOffset() {
        return _xOffset;
    }

    public void setXOffset(int xOffset) {
        int oldValue = _xOffset;
        _xOffset = xOffset;
        _changes.firePropertyChange("xOffset", oldValue, _xOffset);
        process();
    }

    public int getYOffset() {
        return _yOffset;
    }

    public void setYOffset(int yOffset) {
        int oldValue = _yOffset;
        _yOffset = yOffset;
        _changes.firePropertyChange("yOffset", oldValue, _yOffset);
        process();
    }

    @Override
    public int getWidth() {
        return _width;
    }

    public void setWidth(int width) {
        int oldValue = _width;
        _width = width;
        _changes.firePropertyChange("width", oldValue, _yOffset);
        process();
    }

    public int getHeigth() {
        return _heigth;
    }

    public void setHeigth(int heigth) {
        int oldValue = _heigth;
        _heigth = heigth;
        _changes.firePropertyChange("heigth", oldValue, _yOffset);
        process();
    }
}
