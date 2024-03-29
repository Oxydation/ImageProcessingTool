import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by Jasmin on 24.11.2015.
 */
public class OverlayBeanInfo extends SimpleBeanInfo {
    private final static Class beanClass = Overlay.class;

    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor overlayImage = new PropertyDescriptor("overlayImage", beanClass);
            overlayImage.setBound(true);
            PropertyDescriptor underlayImage = new PropertyDescriptor("underlayImage", beanClass);
            underlayImage.setBound(true);

            PropertyDescriptor original = new PropertyDescriptor("original", beanClass);
            PropertyDescriptor result = new PropertyDescriptor("result", beanClass);

            original.setBound(true);
            result.setBound(true);

            PropertyDescriptor[] propertyDescriptors = {overlayImage, underlayImage, original, result};
            return propertyDescriptors;

        } catch (IntrospectionException e) {
            throw new Error(e.toString());
        }
    }

    public int getDefaultPropertyIndex() {
        return 0;
    }
}
