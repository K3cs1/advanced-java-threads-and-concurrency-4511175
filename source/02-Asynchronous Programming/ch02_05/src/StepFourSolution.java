import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class StepFourSolution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Write code for the Task 04 solution here
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                    System.out.println("Calculating the sum of squares ...");
                    int sum = 0;
                    for(int i = 0; i < 10; i++) {
                        int square = i * i;
                        sum += square;
                    }
                    System.out.println("Finished calculating the sum of squares");
                    return sum;
            }).thenCombine(CompletableFuture.supplyAsync(() -> {
				System.out.println("Calculating the sum of even numbers ...");
				int sum = 0;
				for(int i = 0; i < 10; i++) {
                    int quare = i * i;
                    sum += quare;
				}
				System.out.println("Finished calculating the sum of even numbers");
				return sum;
			}), (res1, res2) -> res1 + res2);

        System.out.println("Sum of even numbers + Sum of squares = " + future.get());
    }
}
