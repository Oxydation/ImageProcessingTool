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


    public Dimension getPreferredSize() {
        Graphics g = getGraphics();
        FontMetrics fm = g.getFontMetrics();
        int w = fm.stringWidth("PictureLoader") + 2 * 10;
        int h = fm.getHeight() + 2 * 10;
        return new Dimension(w, h);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Dimension d = getSize();
        int w = d.width;
        int h = d.height;
        FontMetrics fm = g.getFontMetrics();
        int x = (d.width - fm.stringWidth("PictureLoader")) / 2;
        int y = (d.height + fm.getMaxAscent() -
                fm.getMaxDescent()) / 2;
        g.drawString("PictureLoader", x, y);
        g.drawRect(0, 0, w - 1, h - 1);
    }

}
