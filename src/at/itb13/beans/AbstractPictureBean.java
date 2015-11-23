package at.itb13.beans;

import Catalano.Imaging.FastBitmap;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

/**
 * Created by Mathias on 23/11/2015.
 */
public abstract class AbstractPictureBean extends Component implements Serializable {
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
        _changes.firePropertyChange("result", _result, result);
        _result = result;
    }


}
