import java.lang.reflect.InvocationTargetException;

public interface IMyClass {

    public void Out(String name);
    public String get() throws InvocationTargetException, IllegalAccessException;

    public void set(String val);
}
