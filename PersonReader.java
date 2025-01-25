import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PersonReader {
    public static void main(String[] args) {
        Scanner fileScanner = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select a Person Data File");
        int fileSelection = chooser.showOpenDialog(null);

        if (fileSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            try {
                fileScanner = new Scanner(selectedFile);

                System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", "ID#", "FirstName", "LastName", "Title", "YOB");
                System.out.println("============================================================");

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] data = line.split(",\\s*"); // Split by commas and ignore surrounding spaces

                    if (data.length == 5) {
                        System.out.printf("%-10s %-15s %-15s %-10s %-5s%n",
                                data[0], data[1], data[2], data[3], data[4]);
                    } else {
                        System.out.println("Invalid data format in line: " + line);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("The selected file was not found: " + e.getMessage());
            } finally {
                if (fileScanner != null) {
                    fileScanner.close();
                }
            }
        } else {
            System.out.println("No file was selected. Exiting program.");
        }
    }
}
