import Catalano.Imaging.FastBitmap;
import at.itb13.beans.AbstractPicture;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by Jasmin on 23.11.2015.
 */
public class SavePicture extends AbstractPicture implements PropertyChangeListener {
    private String _targetFile = "";

    public SavePicture() {
        setName(this.getClass().getName());
    }

    public String getTargetFile() {
        return _targetFile;
    }

    public void setTargetFile(String target) {
        String oldTarget = _targetFile;
        _targetFile = target;
        _changes.firePropertyChange("targetFile", oldTarget, target);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("result")) {
            setOriginal((FastBitmap) evt.getNewValue());
            if (getOriginal() != null) {
                getOriginal().saveAsPNG(getTargetFile());
            }
        }
    }
}
