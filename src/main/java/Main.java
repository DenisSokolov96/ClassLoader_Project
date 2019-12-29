import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        MyClassLoader loader1 = new MyClassLoader();
        MyClassLoader loader2 = new MyClassLoader();


        /*
         * Метод invoke принимает два параметра,
         * первый - это объект, класс которого объявляет или наследует данный метод,
         * а второй - массив значений параметров, которые передаются вызываемому методу.
        */
        System.out.println("reflection");
        Class cl1 = loader1.findClass("Class1");
        Object instanceOfClass1 = cl1.newInstance();
        Object[] param =  new Object[]{"call "};
        Class[] paramTypes = new Class[] { String.class};
        Method m_get = cl1.getMethod("Out", paramTypes);
        m_get.invoke(instanceOfClass1, param);

        System.out.println("interface");
        Class cl2 = loader2.findClass("Class2");
        IMyClass instCl = (IMyClass) cl2.newInstance();
        instCl.Out("call ");


        InfoClass info = new InfoClass();
        System.out.println("------------------------");
        System.out.println("Class 1 info:");
        info.getMyClassInfo(cl1.getName());

        System.out.println("Class 2 info:");
        info.getMyClassInfo(cl2.getName());

    }
}
