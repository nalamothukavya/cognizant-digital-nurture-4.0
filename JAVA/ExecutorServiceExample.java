import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> task1 = () -> "Task 1 result";
        Callable<String> task2 = () -> "Task 2 result";
        Callable<String> task3 = () -> "Task 3 result";

        Future<String> result1 = executor.submit(task1);
        Future<String> result2 = executor.submit(task2);
        Future<String> result3 = executor.submit(task3);

        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());

        executor.shutdown();
    }
}
