import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

/**
 * Created by Jasmin on 23.11.2015.
 */
public class LoadPictureBeanInfo extends SimpleBeanInfo {
    private final static Class beanClass = LoadPicture.class;

    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor sourceFile = new PropertyDescriptor("sourceFile", beanClass);
            sourceFile.setBound(true); //was ist das? ;)

            PropertyDescriptor[] propertyDescriptors = {sourceFile};
            return propertyDescriptors;

        } catch (IntrospectionException e) {
           throw new Error(e.toString());
        }
    }

    public int getDefaultPropertyIndex() {
        return 0;
    }
}
