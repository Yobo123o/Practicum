import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> personRecords = new ArrayList<>();
        boolean addMore = true;

        System.out.println("Welcome to the Person Generator!");
        System.out.println("Enter person details (ID, FirstName, LastName, Title, YearOfBirth).");

        while (addMore) {
            // Collect and validate each field using SafeInput
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title (e.g., Mr., Mrs., Dr., etc.)");
            int yearOfBirth = SafeInput.getInt(in, "Enter Year of Birth");

            // Combine the details into a single record
            String record = String.format("%s, %s, %s, %s, %d", id, firstName, lastName, title, yearOfBirth);
            personRecords.add(record);

            // Ask user if they want to add another record
            addMore = SafeInput.getYNConfirm(in, "Do you want to add another person?");
        }

        // Get the file name from the user
        String fileName = SafeInput.getNonZeroLenString(in, "Enter the name of the file to save the data (e.g., PersonTestData.txt)");

        // Save records to the file
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String record : personRecords) {
                writer.write(record + "\n");
            }
            System.out.println("Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("Thank you for using the Person Generator!");
    }
}
