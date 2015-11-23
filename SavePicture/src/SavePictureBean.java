import java.awt.*;
import java.io.Serializable;

/**
 * Created by Jasmin on 23.11.2015.
 */
public class SavePictureBean extends Component implements Runnable, Serializable {
    private String _target;

    @Override
    public void run() {

    }

    public String get_target() {
        return _target;
    }

    public void set_target(String _target) {
        this._target = _target;
    }
}
