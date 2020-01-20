public class Class2 implements IMyClass {

    private String str = null;

    @Override
    public void Out(String name) {

    }

    @Override
    public String get() {
        return str+" Class2";
    }

    @Override
    public void set(String val) {
        this.str = val;
    }

}

