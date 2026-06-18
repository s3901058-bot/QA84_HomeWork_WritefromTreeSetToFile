import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;

public class MainFolderFile {
    public static void main(String[] args) {
        TreeSet<String> fruits = new TreeSet<>();
        fillFruitstToFile(fruits);

        String home=System.getProperty("user.home");
        String FolderPath=home+ File.separator+"Fruits";
        String FilePath = FolderPath +File.separator+"Fruits.txt";
        addFruitstToFile(fruits,FolderPath,FilePath);
        System.out.println("Fruits: "+fruits);


    }


    private static void addFruitstToFile(TreeSet<String> fruits, String folderPath, String filePath) {
         File folder = new File(folderPath);
         if (!folder.exists()) {
             folder.mkdir();
         }
         File fl=new File(filePath);
         if (!fl.exists()) {
             try {
                 fl.createNewFile();
                 FileWriter fw=new FileWriter(fl);
                 BufferedWriter bw=new BufferedWriter(fw);
                 for(String fruit:fruits){
                     bw.write("\nYour Favourite fruits:  "+fruit);
                     bw.newLine();
                 }
                bw.close();

             } catch (IOException e)
             {
                 System.out.println(e.getMessage());
             }
         }

    }

    private static void fillFruitstToFile(TreeSet<String> fruits) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while (true) {

        System.out.print("Enter your favourite fruits: ");
        try {
            fruits.add(br.readLine());

        System.out.print("Do you want add anything else? y/n: ");
        if(br.readLine().equalsIgnoreCase("n")){
            br.close();
            break;
        }
        } catch (IOException e) {
            System.out.println(e.getMessage());    } }
    }


}
