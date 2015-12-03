import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by Mathias on 23/11/2015.
 */
public class ThresholdBeanInfo extends SimpleBeanInfo {
    private final static Class beanClass = Threshold.class;

    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor threshold = new PropertyDescriptor("threshold", beanClass);
            threshold.setBound(true);

            PropertyDescriptor[] propertyDescriptors = {threshold};
            return propertyDescriptors;

        } catch (IntrospectionException e) {
            throw new Error(e.toString());
        }
    }

    public int getDefaultPropertyIndex() {
        return 0;
    }
}
