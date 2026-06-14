import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class StepThreeSolution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Write code for the Task 03 solution here
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculating the sum of even numbers ...");
            int sum = 0;
            for(int i = 0; i < 10; i++) {
                if(i%2 == 0) {
                    sum += i;
                }
            }
            System.out.println("Finished calculating the sum of even numbers");
            return sum;
        }).thenCompose(result -> CompletableFuture.supplyAsync(() -> {
            return result * result;
        }));

        System.out.println("Sum of even numbers squared: " + future.get());
    }
}
