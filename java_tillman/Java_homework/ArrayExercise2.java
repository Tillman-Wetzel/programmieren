package Java_homework;

import java.util.Arrays;

import Java_conferenz.system_out_println;

public class ArrayExercise2 {
    public static void main(String[] args) {
//         int[] intArray = {5, 2, 8, 3, 7};

//         //{2, 3, 5, 7, 8}
//         //{8, 7, 5 , 3 , 2}
//         int[] resultArray = new int [intArray.length];
//         int arrayinput = 0;
        
//         resultArray[0] = intArray[0];

//         for (int i = 0; i < intArray.length; i++) {

//             int currentValue = intArray[i];
//             for (int j = 0; j < resultArray.length; j++ ){
//                  if ( currentValue > resultArray[j] ) {
//                     int switchNumberToRight = resultArray[j];
//                     resultArray[j] = currentValue;
//                     currentValue = switchNumberToRight;
//                 }
//             }





//         }
    

//         System.out.println(intArray);
//         System.out.println(Arrays.toString(resultArray));

//     }
// }   


// Sort an array of integers
        int[] intArray = {5, 2, 8, 3, 7};
        Arrays.sort(intArray);
        System.out.println("Sorted integers: " + Arrays.toString(intArray)); 
        
        int[] intArrayResult = new int[intArray.length];

       // Reverse to get descending order
        for (int i = 0; i < intArray.length; i++) {
            if (i == 0) {
                intArrayResult[i] = intArray[i];
                continue;
            }
            int current_number = intArray[i];
            for (int j = 0; j < intArrayResult.length; j++ ){
                if ( current_number > intArrayResult[j] ) {
                    int switchNumberToRight = intArrayResult[j];
                    intArrayResult[j] = current_number;
                    current_number = switchNumberToRight;
                }
            }
        }
    }
}