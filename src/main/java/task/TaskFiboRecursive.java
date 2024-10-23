package task;

public class TaskFiboRecursive extends TaskImpl {

    @Override
    public void execute() {
        try {
            int n = Integer.valueOf(input);
            result = String.valueOf(fibonacci(n));
        } catch (Exception e) {
            result = "Exception: " + e.getMessage();
        }
    }

    /**
     * Recursive Fibonacci function
     * @param n
     * @return int
     */
    private int fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
