import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by Mathias on 23/11/2015.
 */
public class OpeningBeanInfo extends SimpleBeanInfo {
    private final static Class beanClass = Opening.class;

    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor radius = new PropertyDescriptor("radius", beanClass);
            radius.setBound(true);

            PropertyDescriptor[] propertyDescriptors = {radius};
            return propertyDescriptors;

        } catch (IntrospectionException e) {
            throw new Error(e.toString());
        }
    }

    public int getDefaultPropertyIndex() {
        return 0;
    }
}
