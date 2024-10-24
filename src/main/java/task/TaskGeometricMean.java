package task;

import java.util.Arrays;

public class TaskGeometricMean extends TaskImpl {

    @Override
    public void execute() {
        String[] stringArray = input.split(",");
        double[] doubleArray = Arrays.stream(stringArray)
                .mapToDouble(Double::parseDouble)
                .toArray();

        // Calculate the geometric mean
        double product = Arrays.stream(doubleArray).reduce(1.0, (a, b) -> a * b);
        double geometricMean = Math.pow(product, 1.0 / doubleArray.length);
        result = String.valueOf(geometricMean);
    }
}
