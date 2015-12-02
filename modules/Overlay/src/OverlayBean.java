import Catalano.Imaging.FastBitmap;
import at.itb13.beans.AbstractPictureBean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Mathias on 23/11/2015.
 */
public class OverlayBean extends AbstractPictureBean implements PropertyChangeListener {
    private FastBitmap _overlayImage = new FastBitmap(50, 50);
    private FastBitmap _underlayImage = new FastBitmap(50, 50);

    public OverlayBean() {
        setName(getClass().getName());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Propertychange");
        process();
    }

    public void process() {

        if (_overlayImage != null && _underlayImage != null) {
            System.out.println("process");
            OverlayFilter overlayFilter = new OverlayFilter(_overlayImage);
            overlayFilter.applyInPlace(_underlayImage);

            setOriginal(_overlayImage);
            setResult(_underlayImage);
            _underlayImage.saveAsJPG("test.jpg");
        }
    }

    public FastBitmap getOverlayImage() {
        return _overlayImage;
    }

    public void setOverlayImage(FastBitmap overlayImage) {
        FastBitmap old = _overlayImage;
        this._overlayImage = overlayImage;
        _changes.firePropertyChange("overlayImage", old, overlayImage);
        process();
    }

    public FastBitmap getUnderlayImage() {
        return _underlayImage;
    }

    public void setUnderlayImage(FastBitmap underlayImage) {
        FastBitmap old = _underlayImage;
        this._underlayImage = underlayImage;
        _changes.firePropertyChange("underlay", old, underlayImage);
        process();
    }
}
