import java.util.concurrent.*;

public class StepOneSolution {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Write code for the Task 01 solution here
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        long startTime = System.nanoTime();
        Future<Integer> future1 = executorService.submit(new SumOfEvenTask());
        Future<Integer> future2 = executorService.submit(new SumOfSquaresTask());

        // Place your solution code here
        while (!future1.isDone() && !future2.isDone()) {
            System.out.println("Tasks are in progress..");
        }

        System.out.println("Sum of Even Numbers: " + future1.get());
        System.out.println("Sum of Squares: " + future2.get());

        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Both tasks finished in " + (elapsedTime/1000000)/1000 + " seconds");

        // Don't forget to shut down the executor service once you are done
    }
}
