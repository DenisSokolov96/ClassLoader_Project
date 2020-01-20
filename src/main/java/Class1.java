import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import org.apache.log4j.Logger;

public class Class1 implements IMyClass{

    public static final Logger log = Logger.getLogger(Class1.class);
    Object obj;

    Class1(Object obj) {
        this.obj = obj;
    }

    @Override
    public void Out(String name) {

    }

    @Override
    public String get() {
        String str = null;
        try {
            Method m = obj.getClass().getMethod("get");
            str = (String) m.invoke(obj);
        } catch (InvocationTargetException e) {
            log.error(e.getMessage());
        } catch (NoSuchMethodException e) {
            log.error(e.getMessage());
        } catch (IllegalAccessException e) {
            log.error(e.getMessage());
        }
        return str + " Class1";
    }

    @Override
    public void set(String st) {
        ((IMyClass)obj).set(st);
    }
}

