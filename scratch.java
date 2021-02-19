/**
* Print the Shortest Distance between the given character and its occurrence in the string provided.
 * string = SHARMA
 * character = a
 * output = 2 1 0 1 1 0
* */


import java.util.ArrayList;

class Main{
    public static void main(String[] args) {
        Scanner scan =  new Scanner(System.in);
        String string = scan.next();
        String character = scan.next();
        ArrayList<Integer> array = arrayOfCharacterIndex(string, character);
        minimumDistance(array, string, character);
    }

    public static ArrayList<Integer> arrayOfCharacterIndex(String string, String c) {
        ArrayList<Integer> array= new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == c.charAt(0)){
                array.add(i);
            }
        }
        return array;
    }
    public static void minimumDistance(ArrayList<Integer> array, String string, String c){
        int count = 0;
        int first, second;
        for (int i = 0; i < string.length(); i++) {
            if (count == 0){
                first = array.get(0);
                second = array.get(0);
            }
            else if(count == 1){
                first = array.get(0);
                second = array.get(count);
            }
            else if(count == array.size()){
                first = array.get(array.size() - 1);
                second = array.get(array.size() - 1);
            }
            else{
                first = array.get(count);
                second = array.get(count + 1);
            }
            System.out.print((Integer.min(Math.abs(first - i), Math.abs(second - i))) + " ");
            if (c.charAt(0) == string.charAt(i)){
                count++;
            }
        }
    }
}
