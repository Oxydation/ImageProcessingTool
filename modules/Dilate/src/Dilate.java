import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.Filters.Dilatation;
import at.itb13.beans.AbstractPicture;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Jasmin on 23.11.2015.
 */
public class Dilate extends AbstractPicture implements PropertyChangeListener {
    private int _radius = 1;

    public Dilate(){
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
            Dilatation dilatation = new Dilatation();
            dilatation.applyInPlace(getOriginal());
            setResult(getOriginal());
            setOriginal(fastBitmap);
        }
    }

    public int getRadius() {
        return _radius;
    }

    public void setRadius(int radius) {
        int old = _radius;
        this._radius = radius;
        _changes.firePropertyChange("radius", old, _radius);
        process();
    }
}
