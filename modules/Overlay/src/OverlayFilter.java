

/**
 * Created by Mathias on 30/11/2015.
 */

import Catalano.Imaging.FastBitmap;
import Catalano.Imaging.IBaseInPlace;

/**
 * Or filter - Performs logical operator "or" between two images.
 * <br />Logical operators are generally derived from <i>Boolean algebra</i>.
 * <br /><br />Truth-tables for AND: <br /><br />
 * A    B  |    Q <br />
 * --------- <br />
 * 0    0  |    0 <br />
 * 0    1  |    1 <br />
 * 1    0  |    1 <br />
 * 1    1  |    1 <br />
 *
 * @author Diego Catalano
 */
public class OverlayFilter implements IBaseInPlace {
    FastBitmap overlayImage;
    private int _xOffset = 0;
    private int _yOffset = 60;
    private int _width = 448;
    private int _heigth = 79;

    private int _replaceColor = 0; // 0 .. White, 255 .. Black

    /**
     * Initialize a new instance of the Or class.
     */
    public OverlayFilter() {

    }

    /**
     * Initialize a new instance of the Or class with defined an overlay image.
     *
     * @param overlayImage Overlay image.
     */
    public OverlayFilter(FastBitmap overlayImage) {
        this.overlayImage = overlayImage;
    }

    /**
     * Set Overlay image.
     *
     * @param overlayImage Overlay image.
     */
    public void setOverlayImage(FastBitmap overlayImage) {
        this.overlayImage = overlayImage;
    }

    @Override
    public void applyInPlace(FastBitmap sourceImage) {
        int width = overlayImage.getWidth();
        int height = overlayImage.getHeight();
        if ((sourceImage.isGrayscale()) && (overlayImage.isGrayscale())) {
            int grayO;
            for (int x = 0; x < height; x++) {
                for (int y = 0; y < width; y++) {
                    grayO = overlayImage.getGray(x, y);
                    if (grayO == _replaceColor) {
                        sourceImage.setGray(x + getxOffset(), y + getyOffset(), grayO);
                    }
                }
            }
        }
    }

    public int getxOffset() {
        return _xOffset;
    }

    public void setxOffset(int xOffset) {
        _xOffset = xOffset;
    }

    public int getyOffset() {
        return _yOffset;
    }

    public void setyOffset(int yOffset) {
        _yOffset = yOffset;
    }

    public int getWidth() {
        return _width;
    }

    public void setWidth(int width) {
        _width = width;
    }

    public int getHeigth() {
        return _heigth;
    }

    public void setHeigth(int heigth) {
        _heigth = heigth;
    }

    public int getReplaceColor() {
        return _replaceColor;
    }

    public void setReplaceColor(int replaceColor) {
        _replaceColor = replaceColor;
    }
}