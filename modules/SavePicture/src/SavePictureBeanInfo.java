import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by Jasmin on 23.11.2015.
 */
public class SavePictureBeanInfo extends SimpleBeanInfo {
    private final static Class beanClass = SavePicture.class;

    public PropertyDescriptor[] getPropertyDescriptors() {
        try {

            PropertyDescriptor targetFile = new PropertyDescriptor("targetFile", beanClass);
            targetFile.setBound(true);

            PropertyDescriptor original = new PropertyDescriptor("original", beanClass);
            PropertyDescriptor result = new PropertyDescriptor("result", beanClass);

            original.setBound(true);
            result.setBound(true);

            PropertyDescriptor[] propertyDescriptors = {targetFile, original, result};
            return propertyDescriptors;

        } catch (IntrospectionException e) {
            throw new Error(e.toString());
        }
    }

    public int getDefaultPropertyIndex() {
        return 0;
    }
}
