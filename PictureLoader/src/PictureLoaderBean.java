import Catalano.Imaging.FastBitmap;
import at.itb13.pipesandfilter.interfaces.Writeable;
import at.itb13.pipesandfilter.interfaces.Readable;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.io.StreamCorruptedException;

/**
 * Created by Mathias on 30.10.2015.
 */
public class PictureLoaderBean extends Component implements Readable<FastBitmap>, Runnable, Serializable {
    private String _sourceFile;
    private Writeable<FastBitmap> _writeable;
    private PropertyChangeSupport _changes = new PropertyChangeSupport(this);

    public PictureLoaderBean(String file) {
        _sourceFile = file;
    }

    public PictureLoaderBean(String file, Writeable<FastBitmap> output) {
        _writeable = output;
        _sourceFile = file;
    }

    @Override
    public FastBitmap read() throws StreamCorruptedException {
        return new FastBitmap(_sourceFile);
    }

    @Override
    public void run() {
        if (_writeable != null) {
            FastBitmap input = null;
            try {
                int counter = 0;
                while ((input = read()) != null) {
                    //System.out.println("Source: read input and write output");
                    _writeable.write(input);
                }
                _writeable.write(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void addPropertyChangeListener(PropertyChangeListener l) {
        _changes.addPropertyChangeListener(l);
    }

    /**
     * Remove this PropertyChangeListener from the buttons internal list.
     * If the PropertyChangeListener isn't on the list, silently do nothing.
     *
     * @see #addPropertyChangeListener
     * @param l the PropertyChangeListener
     */
    public void removePropertyChangeListener(PropertyChangeListener l) {
        _changes.removePropertyChangeListener(l);
    }

    public String getSourceFile() {
        return _sourceFile;
    }

    public void setSourceFile(String file) {
        _changes.firePropertyChange("sourceFile", _sourceFile, file);
        _sourceFile = file;

    }

    public Writeable<FastBitmap> getWriteable() {
        return _writeable;
    }

    public void setWriteable(Writeable<FastBitmap> writeable) {
        _writeable = writeable;
    }

}
