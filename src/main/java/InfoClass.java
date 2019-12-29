import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class InfoClass {

    StringBuilder str = new StringBuilder();

    public void getMyClassInfo(String name) throws ClassNotFoundException {

        Class ClassInfo = Class.forName(name);
        int t = 0;
        getClassInfo(ClassInfo, t);
        System.out.println(str);
        str.setLength(0);
    }

    public void tab(String s, int t){
        if (s!="") {
            for (int j = 0; j < t; j++)
                str.append("   ");
            str.append(s + " ");
        }
    }
    public void getClassInfo(Class cl, int t)throws ClassNotFoundException {

        int temp = t;
        t++;
        tab("\n", t);
        tab(cl+"\n", t);
        tab("Родительский класс: " + cl.getSuperclass()+"\n",t);
        //str.append("\n");
        //str.append(cl+"\n");
        //str.append("Родительский класс: " + cl.getSuperclass()+"\n");

        if ( cl.getInterfaces().length > 0) {
            //str.append("Интерфейсы класса:"+"\n");
            tab("Интерфейсы класса:\n",t);
            print(cl.getInterfaces(), t);
        }
        if ( cl.getConstructors().length > 0){
            //str.append("Конструкторы класса:"+"\n");
            tab("Конструкторы класса:\n", t);
            for (Constructor c: cl.getConstructors())
                //str.append(c.getName()+"\n");
                tab(c.getName()+"\n", t);
        }
        if ( cl.getDeclaredFields().length > 0) {
            //str.append("Поля класса:"+"\n");
            tab("Поля класса:"+"\n", t);
            for (Field f: cl.getDeclaredFields())
                //str.append(f.getName()+"\n");
                tab(f.getName()+"\n", t);
        }
        if ( cl.getDeclaredMethods().length > 0){
            //str.append("Методы класса:"+"\n");
            tab("Методы класса:"+"\n", t);
            for (Method m: cl.getDeclaredMethods())
                //str.append(m.getName()+"\n");
                tab(m.getName()+"\n", t);
        }
        tab("**********************************************\n",t);
        //str.append("**************************************************\n");

        if (cl.getSuperclass()!=null) getClassInfo(cl.getSuperclass(), t);
        if (cl.getInterfaces()!=null) getInterfaceInfo(cl.getInterfaces(), t);
    }

    public void getInterfaceInfo(Class[] clazz, int t)throws ClassNotFoundException{
        int i=0;
        try{
            while (true){
                getClassInfo(clazz[i], t);
                i++;
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException e){
        }
    }

    public void print(Object[] masObj, int t){
        for (int i = 0; i < masObj.length; i++) {
            //str.append(masObj[i].toString()+"\n");
            tab(masObj[i].toString()+"\n", t);
        }
    }

}

