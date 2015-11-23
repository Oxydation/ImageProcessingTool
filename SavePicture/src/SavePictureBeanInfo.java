import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by Jasmin on 23.11.2015.
 */
public class SavePictureBeanInfo extends SimpleBeanInfo {
    private final static Class beanClass = SavePictureBean.class;

    public PropertyDescriptor[] getPropertyDescriptors() {
        try {

            PropertyDescriptor targetFile = new PropertyDescriptor("targetFile", beanClass);
            targetFile.setBound(true);

            PropertyDescriptor[] propertyDescriptors = {};
            return propertyDescriptors;

        } catch (IntrospectionException e) {
            throw new Error(e.toString());
        }
    }

    public int getDefaultPropertyIndex() {
        return 0;
    }
}
