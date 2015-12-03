import at.itb13.beans.AbstractPicture;
import at.itb13.imaging.entities.PicturePack;
import at.itb13.pipesandfilter.filter.ImageSource;

import java.io.StreamCorruptedException;

/**
 * Created by Mathias on 30.10.2015.
 */
public class LoadPicture extends AbstractPicture {
    private String _sourceFile = "";
    private ImageSource _imageSource;

    public LoadPicture() {
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
