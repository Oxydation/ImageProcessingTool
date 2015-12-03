import Catalano.Imaging.FastBitmap;
import at.itb13.beans.AbstractPicture;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Mathias on 23/11/2015.
 */
public class Opening extends AbstractPicture implements PropertyChangeListener {
    private int _radius = 1;

    public Opening() {
        setName(getClass().getName());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("result")) {
            setOriginal((FastBitmap) evt.getNewValue());
            process();
        }
    }

    public void process() {
        if (getOriginal() != null) {
            FastBitmap original = new FastBitmap(getOriginal());
            Catalano.Imaging.Filters.Opening closing = new Catalano.Imaging.Filters.Opening(getRadius());
            closing.applyInPlace(getOriginal());
            setResult(getOriginal());
            setOriginal(original);
        }
    }

    public int getRadius() {
        return _radius;
    }

    public void setRadius(int radius) {
        int oldValue = _radius;
        _radius = radius;
        _changes.firePropertyChange("radius", oldValue, _radius);

        process();
    }
}
