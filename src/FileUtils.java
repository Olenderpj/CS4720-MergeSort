import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtils {

    public static int[] createIntArrayFromFile(String fileName){
        ArrayList<Integer> intArray = new ArrayList<>();

        try{
             File inputFile = new File(fileName);
            Scanner fileReader = new Scanner(inputFile);
            while (fileReader.hasNextLine()){
                int data = fileReader.nextInt();
                intArray.add(data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return convertArraylistToArray(intArray);

    }

    private static int[] convertArraylistToArray(ArrayList<Integer> arrayList){
        int[] array = new int[arrayList.size()];

        for (int i = 0; i < array.length; i++){
            array[i] = arrayList.get(i);
        }
        return array;
    }
}
