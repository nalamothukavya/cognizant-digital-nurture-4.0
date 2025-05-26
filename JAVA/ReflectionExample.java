import java.lang.reflect.Method;

public class ReflectionExample {
    public void hello(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ReflectionExample");
        Object obj = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getMethod("hello", String.class);
        method.invoke(obj, "World");

        System.out.println("Methods in class:");
        for (Method m : clazz.getDeclaredMethods()) {
            System.out.println(m.getName());
        }
    }
}
