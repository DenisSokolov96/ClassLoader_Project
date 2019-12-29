import java.io.*;

public class MyClassLoader extends ClassLoader{

    /**
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File filePath = new File( "target/classes/"+name+".class");

        try {

            InputStream inputStream = new BufferedInputStream( new FileInputStream(filePath));
            byte[] b = new byte[(int)filePath.length()];
            inputStream.read(b);

            return defineClass(name, b, 0, b.length);

        } catch (Exception e) {
            e.printStackTrace();
            return super.findClass(name);
        }

    }
}
