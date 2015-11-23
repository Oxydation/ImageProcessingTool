import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by Mathias on 23/11/2015.
 */
public class ROIBeanInfo extends SimpleBeanInfo{
    private final static Class beanClass = ROIBeanInfo.class;

    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor xOffset = new PropertyDescriptor("xOffset", beanClass);
            PropertyDescriptor yOffset = new PropertyDescriptor("yOffset", beanClass);
            PropertyDescriptor width = new PropertyDescriptor("width", beanClass);
            PropertyDescriptor heigth = new PropertyDescriptor("heigth", beanClass);

            xOffset.setBound(true);
            yOffset.setBound(true);
            width.setBound(true);
            heigth.setBound(true);

            PropertyDescriptor[] propertyDescriptors = {xOffset, yOffset, width, heigth};
            return propertyDescriptors;

        } catch (IntrospectionException e) {
            throw new Error(e.toString());
        }
    }

    public int getDefaultPropertyIndex() {
        return 0;
    }
}
