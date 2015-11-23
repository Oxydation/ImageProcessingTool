import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.Filters.Erosion;
import at.itb13.beans.AbstractPictureBean;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Mathias on 23/11/2015.
 */
public class ErodeBean extends AbstractPictureBean implements PropertyChangeListener{
    private int _radius = 1;

    public ErodeBean(){
        setName(this.getClass().getName());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("result")) {
            setOriginal((FastBitmap) evt.getNewValue());
            process();
        }
    }

    public void process(){
        if(getOriginal() != null){
            FastBitmap original = new FastBitmap(getOriginal());
            Erosion erosion = new Erosion();
            erosion.applyInPlace(getOriginal());
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
        _changes.firePropertyChange("radius", oldValue,_radius);

        process();
    }
}
