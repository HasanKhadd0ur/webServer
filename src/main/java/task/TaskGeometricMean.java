package task;

import java.util.Arrays;

// This Task Calculate The Geometric Mean
// The Geo-Mean is defined by :
//         Geo-Mean = N-Root of (a1 * a2 * ... * an) , ai >=0
//
public class TaskGeometricMean extends TaskImpl {

    @Override
    public void execute() {
        //Split the input values
        String[] stringArray = input.split(",");

        // Parse the values
        double[] doubleArray = Arrays.stream(stringArray)
                .mapToDouble(Double::parseDouble)
                .toArray();

        // Check if all the values is poistive
        boolean allPositive =Arrays.stream(doubleArray).allMatch((e)->e>=0);

        if(allPositive){
            // Calculate the geometric mean

            // Calculate P = (a1 * a2 * ... * an)
            double product = Arrays.stream(doubleArray).reduce(1.0, (a, b) -> a * b);

            // Calculate the Geo-Mean = N-Root of( P )
            double geometricMean = Math.pow(product, 1.0 / doubleArray.length);

            // Set tThe result
            result = String.valueOf(geometricMean);
        }else {
            result="All The Array Values Should Be Positive";
        }

    }
}
