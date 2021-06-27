package de.schmidtdennis.MapReduce.jobs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Reduce {

    public void reduce() throws IOException {

        List<String> keys = List.of("under_1_second", "over_1_second");

        for(String key : keys){
            // Grab file
            Path path = Paths.get("src/main/java/de/schmidtdennis/MapReduce/results/" + key + ".txt");
            List<String> entries = Files.readAllLines(path);
            long amount = entries.stream().mapToInt(Integer::parseInt).count();

            Path result = Paths.get("src/main/java/de/schmidtdennis/MapReduce/results/result.txt");
            String line = key + ": " + amount + "\n";
            Files.writeString(result, line, StandardOpenOption.APPEND);
        }
    }
}
