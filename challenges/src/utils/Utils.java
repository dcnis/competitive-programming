package utils;

public class Utils {

    public int[] readArray(String arrayAsString){
        String removeBrackets = arrayAsString.substring(1, arrayAsString.length()-1);
        String[] splitted = removeBrackets.split(",");

        int[] array = new int[splitted.length];
        for(int i = 0; i < splitted.length; i++){
            array[i] = Integer.parseInt(splitted[i].strip());
        }
        return array;
    }

    public static void main(String[] args) {
        Utils utils = new Utils();
        utils.readArray("[8, 5, 2, 9, 5, 6, 3]");
    }
}
