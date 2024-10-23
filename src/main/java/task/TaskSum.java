package task;

import java.util.Arrays;

public class TaskSum extends TaskImpl{

    @Override
    public void execute() {
        String[] stringArray = input.split(",");
        int sum = Arrays.stream(stringArray).mapToInt(Integer::valueOf).sum();
        result = "Sum: " + sum;
    }
}
