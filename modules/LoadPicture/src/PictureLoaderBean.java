import at.itb13.beans.AbstractPictureBean;
import at.itb13.imaging.entities.PicturePack;
import at.itb13.pipesandfilter.filter.ImageSource;

import java.awt.*;
import java.io.StreamCorruptedException;

/**
 * Created by Mathias on 30.10.2015.
 */
public class PictureLoaderBean extends AbstractPictureBean {
    private String _sourceFile = "";
    private ImageSource _imageSource;

    public PictureLoaderBean() {
        setName(this.getClass().getName());
        _imageSource = new ImageSource("", 1);
    }

    public String getSourceFile() {
        return _sourceFile;
    }

    public void setSourceFile(String file) {
        String oldFile = _sourceFile;
        _sourceFile = file;
        _imageSource.setFile(file);
        _changes.firePropertyChange("sourceFile", oldFile, file);

        readImage();
    }

    private void readImage() {
        try {
            PicturePack pp = _imageSource.read();
            if (pp != null) {
                setOriginal(pp.getOriginal());
                setResult(getOriginal());
            }
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        }
    }
}
