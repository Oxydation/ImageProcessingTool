import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by Mathias on 23/11/2015.
 */
public class ClosingBeanInfo extends SimpleBeanInfo {
    private final static Class beanClass = Closing.class;

    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor radius = new PropertyDescriptor("radius", beanClass);
            radius.setBound(true);

            PropertyDescriptor original = new PropertyDescriptor("original", beanClass);
            PropertyDescriptor result = new PropertyDescriptor("result", beanClass);

            original.setBound(true);
            result.setBound(true);

            PropertyDescriptor[] propertyDescriptors = {radius, original, result};
            return propertyDescriptors;

        } catch (IntrospectionException e) {
            throw new Error(e.toString());
        }
    }

    public int getDefaultPropertyIndex() {
        return 0;
    }
}
