import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.Filters.Median;
import at.itb13.beans.AbstractPictureBean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Mathias on 23/11/2015.
 */
public class MedianBean extends AbstractPictureBean implements PropertyChangeListener {
    private int _radius = 1;

    public MedianBean() {
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
            Median closing = new Median(getRadius());
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
