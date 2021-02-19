/**
 * Print the largest number formed from the given integer array
 * array = 1, 34, 3, 98, 9, 76, 45, 4, 12, 121
 * number = 9 98 76 45 4 34 3 12 121 1
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class LargestNumberFromArray{

    public static void largestNumber(List<Integer> array){
        int size = Collections.max(array).toString().length();
        var newArray = new ArrayList<Values>();
        for (int i = 0; i < array.size(); i++) {
            newArray.add(new Values(array.get(i), size));
        }
        Collections.sort(newArray,(a, b)-> (b.changed - a.changed));
        for (Values values : newArray) {
            System.out.print(values.original+" ");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var array = new ArrayList<Integer>();
        String[] arr = scanner.nextLine().split(" ");
        for (String value: arr) {
            array.add(Integer.parseInt(value));
        }
       largestNumber(array);
    }
}

class Values{
    int original;
    int changed;

    public Values(int original, int size) {
        this.original = original;
        this.changed = Integer.parseInt(
                String.valueOf(original).repeat(size).substring(0, size)
                );
    }
}