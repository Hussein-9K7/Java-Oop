import java.io.*;
import java.net.*;
import java.util.*;
import java.time.*;
import java.time.format.*;

public class Main {
    public static void main(String[] args) {
        String fileUrl = "https://users.metropolia.fi/~jarkkov/temploki.csv";

        try {
            // Download data from the URL
            URL url = new URL(fileUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;

            // Read the header line
            String headerLine = reader.readLine();
            String[] headers = headerLine.split(";"); // Use semicolon as delimiter
            int ulkoTaloIndex = Arrays.asList(headers).indexOf("UlkoTalo");

            if (ulkoTaloIndex == -1) {
                System.out.println("'UlkoTalo' column not found in the data.");
                return;
            }

            // Date format to parse the timestamps in the data
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

            double totalTemperature = 0;
            int count = 0;

            // Read the data lines
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length <= ulkoTaloIndex) continue;

                String timestamp = data[0];
                String temperatureStr = data[ulkoTaloIndex];
                if (temperatureStr.trim().isEmpty()) continue;

                try {
                    // Replace comma with dot if needed for correct decimal parsing
                    double temperature = Double.parseDouble(temperatureStr.replace(",", "."));
                    LocalDateTime dateTime = LocalDateTime.parse(timestamp, formatter);

                    // Check if the date is exactly 1st January 2023
                    if (dateTime.toLocalDate().equals(LocalDate.of(2023, 1, 1))) {
                        totalTemperature += temperature;
                        count++;
                    }
                } catch (NumberFormatException | DateTimeParseException e) {
                    // Skip any invalid data
                    continue;
                }
            }

            reader.close();

            // Calculate and display the average temperature if data exists
            if (count > 0) {
                double averageTemperature = totalTemperature / count;
                System.out.println("The average temperature on 1st January 2023 is: " + averageTemperature + "°C");
            } else {
                System.out.println("No data found for 1st January 2023.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}