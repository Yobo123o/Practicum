import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {
        Scanner fileScanner = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Select a Product Data File");
        int fileSelection = chooser.showOpenDialog(null);

        if (fileSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();

            try {
                fileScanner = new Scanner(selectedFile);

                System.out.printf("%-10s %-20s %-30s %-10s%n", "ID#", "Name", "Description", "Cost");
                System.out.println("============================================================");

                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] data = line.split(",\\s*"); // Split by commas and handle spaces

                    if (data.length == 4) {
                        System.out.printf("%-10s %-20s %-30s %-10s%n",
                                data[0], data[1], data[2], data[3]);
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
