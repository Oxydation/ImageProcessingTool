import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.Filters.And;
import at.itb13.beans.AbstractPictureBean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Mathias on 23/11/2015.
 */
public class OverlayBean extends AbstractPictureBean implements PropertyChangeListener {
    private FastBitmap _overlayImage;

    public OverlayBean() {
        setName(getClass().getName());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("result")) {
            setOriginal((FastBitmap) evt.getNewValue());
            //setOverlayImage((FastBitmap) evt.getNewValue());
            process();
        }

        if (evt.getPropertyName().equals("original")) {
            setOverlayImage((FastBitmap) evt.getNewValue());
        }
        //TODO: set overlay image from second source
    }

    public void process() {
        if (getOriginal() != null && getOverlayImage() != null) {
            FastBitmap original = new FastBitmap(getOriginal());
            And and = new And(getOverlayImage());
            and.applyInPlace(getOriginal());
            setResult(getOriginal());
            setOriginal(original);
        }
    }

    public FastBitmap getOverlayImage() {
        return _overlayImage;
    }

    public void setOverlayImage(FastBitmap overlayImage) {
        FastBitmap oldValue = _overlayImage;
        _overlayImage = overlayImage;
        _changes.firePropertyChange("overlayImage", oldValue, overlayImage);

        process();
    }
}
