import Catalano.Imaging.FastBitmap;
import at.itb13.pipesandfilter.interfaces.Writeable;
import at.itb13.pipesandfilter.interfaces.Readable;

import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.ArrayList;

/**
 * Created by Mathias on 30.10.2015.
 */
public class PictureLoaderBean extends Component implements Serializable {
    private String _sourceFile;
    private FastBitmap _picture;
    private PropertyChangeSupport _changes = new PropertyChangeSupport(this);
    private ArrayList<ActionListener> _actionListeners = new ArrayList<>();

    public PictureLoaderBean(String file) {
        _sourceFile = file;
    }


    public FastBitmap load() {
        return new FastBitmap(_sourceFile);
    }

    public synchronized void addActionListener(ActionListener l) {
        _actionListeners.add(l);
    }

    public synchronized void removeActionListener(ActionListener l) {
        _actionListeners.remove(l);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        _changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        _changes.removePropertyChangeListener(l);
    }

    //Getters & Setters
    public String getSourceFile() {
        return _sourceFile;
    }

    public void setSourceFile(String file) {
        _changes.firePropertyChange("sourceFile", _sourceFile, file);
        _sourceFile = file;

    }

    public FastBitmap getPicture() {
        return _picture;
    }

    public void setPicture(FastBitmap pic) {
        _changes.firePropertyChange("picture", _picture, pic);
        _picture = pic ;
    }

}
