import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by Jasmin on 24.11.2015.
 */
public class OverlayBeanInfo extends SimpleBeanInfo {
    private final static Class beanClass = OverlayBean.class;

    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor overlayImage = new PropertyDescriptor("overlayImage", beanClass);
            overlayImage.setBound(true);
            PropertyDescriptor underlayImage = new PropertyDescriptor("underlayImage", beanClass);
            underlayImage.setBound(true);

            PropertyDescriptor[] propertyDescriptors = {overlayImage, underlayImage};
            return propertyDescriptors;

        } catch (IntrospectionException e) {
            throw new Error(e.toString());
        }
    }

    public int getDefaultPropertyIndex() {
        return 0;
    }
}
