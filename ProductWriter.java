import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> productRecords = new ArrayList<>();
        boolean addMore = true;

        System.out.println("Welcome to the Product Writer!");
        System.out.println("Enter product details (ID, Name, Description, Cost).");

        while (addMore) {
            // Collect and validate input using SafeInput
            String id = SafeInput.getNonZeroLenString(in, "Enter Product ID");
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name");
            String description = SafeInput.getNonZeroLenString(in, "Enter Product Description");
            double cost = SafeInput.getDouble(in, "Enter Product Cost");

            // Combine the details into a single record
            String record = String.format("%s, %s, %s, %.2f", id, name, description, cost);
            productRecords.add(record);

            // Ask if the user wants to add another product
            addMore = SafeInput.getYNConfirm(in, "Do you want to add another product?");
        }

        // Get the file name from the user
        String fileName = SafeInput.getNonZeroLenString(in, "Enter the name of the file to save the data (e.g., ProductTestData.txt)");

        // Write records to the file
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String record : productRecords) {
                writer.write(record + "\n");
            }
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Thank you for using the Product Writer!");
    }
}
