import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TopReaders {
    public static void main(String[] args) {
        String filePath = "/Users/kamal/IdeaProjects/LeetCodeJavaSolutions/Karat/test.txt"; // Update this path to your file
        Map<String, Integer> readerPoints = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0];
                int points = Integer.parseInt(parts[parts.length - 1]);
                readerPoints.put(id, readerPoints.getOrDefault(id, 0) + points + 50);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> sortedReaders = new ArrayList<>(readerPoints.entrySet());
        sortedReaders.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Top 5 Readers:");
        for (int i = 0; i < Math.min(5, sortedReaders.size()); i++) {
            Map.Entry<String, Integer> entry = sortedReaders.get(i);
            System.out.println("ID: " + entry.getKey() + ", Points: " + entry.getValue());
        }
    }
}