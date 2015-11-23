import Catalano.Imaging.FastBitmap;
import at.itb13.beans.AbstractPictureBean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Mathias on 23/11/2015.
 */
public class ROIBean extends AbstractPictureBean implements PropertyChangeListener {
    private int _xOffset = 0;
    private int _yOffset = 60;
    private int _width = 448;
    private int _heigth = 79 ;

    public ROIBean() {
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
            FastBitmap roi = new FastBitmap(getOriginal().toBufferedImage().getSubimage(getxOffset(), getyOffset(), getWidth(), getHeigth()));
            setResult(roi);
            setOriginal(fastBitmap);
        }
    }

    public int getxOffset() {
        return _xOffset;
    }

    public void setxOffset(int xOffset) {
        int oldValue = _xOffset;
        _xOffset = xOffset;
        _changes.firePropertyChange("xOffset", oldValue, _xOffset);
        process();
    }

    public int getyOffset() {
        return _yOffset;
    }

    public void setyOffset(int yOffset) {
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
