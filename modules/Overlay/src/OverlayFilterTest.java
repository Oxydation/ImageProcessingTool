import Catalano.Imaging.FastBitmap;
import org.junit.Test;

/**
 * Created by Mathias on 30/11/2015.
 */
public class OverlayFilterTest {
    @Test
    public void testOverlayFilter() throws Exception {
        FastBitmap originalImage = new FastBitmap("loetstellen.jpg");
        FastBitmap overlayImage = new FastBitmap("test.jpg");

        OverlayFilter overlayFilter = new OverlayFilter(overlayImage);
        overlayFilter.applyInPlace(originalImage);

        originalImage.saveAsJPG("blasaaa.jpg");
        overlayImage.saveAsJPG(("blasaaa2.jpg"));
    }
}