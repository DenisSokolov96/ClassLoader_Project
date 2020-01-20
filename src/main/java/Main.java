import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static StringBuilder str = new StringBuilder();

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        MyClassLoader loader1 = new MyClassLoader();
        Class class1 = loader1.findClass("Class1");

        MyClassLoader loader2 = new MyClassLoader();
        Class class2 = loader2.findClass("Class2");

       /* str.append("reflection");
        Class cl1 = loader1.findClass("Class1");
        Object instanceOfClass1 = cl1.newInstance();
        Object[] param =  new Object[]{"call "};
        Class[] paramTypes = new Class[] { String.class};
        Method m_get = cl1.getMethod("Out", paramTypes);*/
        /* это объект, класс которого объявляет или наследует данный метод,
         * а второй - массив значений параметров, которые передаются вызываемому методу */
        /*m_get.invoke(instanceOfClass1, param);

        str.append("interface");
        Class cl2 = loader2.findClass("Class2");
        IMyClass instCl = (IMyClass) cl2.newInstance();
        instCl.Out("call ");


        InfoClass info = new InfoClass();
        System.out.println("------------------------");
        System.out.println("Class 1 info:");
        info.getMyClassInfo(cl1.getName());

        System.out.println("Class 2 info:");
        info.getMyClassInfo(cl2.getName());*/


        Constructor constructor = class1.getDeclaredConstructor(Object.class);
        //проверка доступа может быть отменена, что ускорит процесс
        constructor.setAccessible(true);

        Object cl2 = class2.newInstance();
        Object cl1 = constructor.newInstance(cl2);

        IMyClass intCl1 = (IMyClass) cl1;
        IMyClass intCl2 = (IMyClass) cl2;

        str.append("Interface"+"\n");
        intCl1.set("Hello");
        str.append(intCl1.get()+" - intCl1"+"\n");
        str.append(intCl2.get()+" - intCl2"+"\n");
        str.append("\n");


        str.append("Reflection"+"\n");
        Method method1 = class1.getMethod("set", new Class[] {String.class});
        method1.invoke(cl1, new Object[]{"Hello"});
        Method method2 = class1.getMethod("get");
        str.append(method2.invoke(intCl1)+"\n");
        str.append("\n");
        System.out.println(str);


        InfoClass info = new InfoClass();
        System.out.println("Class 1 info:");
        info.getMyClassInfo(class1.getName());

        System.out.println("Class 2 info:");
        info.getMyClassInfo(class2.getName());

    }
}
