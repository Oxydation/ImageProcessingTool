import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.Filters.Invert;
import at.itb13.beans.AbstractPicture;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Mathias on 23/11/2015.
 */
public class Threshold extends AbstractPicture implements PropertyChangeListener {
    private int _threshold = 50;

    public Threshold() {
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

            Catalano.Imaging.Filters.Threshold threshold = new Catalano.Imaging.Filters.Threshold(getThreshold());
            getOriginal().toGrayscale();
            threshold.applyInPlace(getOriginal());

            Invert invert = new Invert();
            invert.applyInPlace(getOriginal());
            setResult(getOriginal());
            setOriginal(original);
        }
    }

    public int getThreshold() {
        return _threshold;
    }

    public void setThreshold(int threshold) {
        int oldValue = _threshold;
        _threshold = threshold;

        _changes.firePropertyChange("threshold", oldValue, _threshold);
    }
}
