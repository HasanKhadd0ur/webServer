package task;

import java.util.Arrays;
import java.util.StringJoiner;

public class TaskBubbleSort extends TaskImpl {

    @Override
    public void execute() {
        String[] stringArray = input.split(",");
        int[] intArray = Arrays.stream(stringArray).mapToInt(s -> Integer.valueOf(s)).toArray();
        sort(intArray);
        result = printArray(intArray);
    }

    private void sort(int array[]) {

        int n = array.length;
        int temp = 0;

        for(int i=0; i < n; i++){
            for(int j=1; j < (n-i); j++){
                if(array[j-1] > array[j]){
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private String printArray(int[] array) {
        StringJoiner stringJoiner = new StringJoiner(",", "[","]");
        Arrays.stream(array).forEach(item -> stringJoiner.add(String.valueOf(item)));
        return stringJoiner.toString();
    }
}
