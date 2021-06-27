package de.schmidtdennis.MapReduce.jobs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Shuffle {

    public void shuffle(List<String> hosts) throws IOException {
        Path under1SecondResultPath = Paths.get("src/main/java/de/schmidtdennis/MapReduce/results/under_1_second.txt");
        Path over1SecondResultPath = Paths.get("src/main/java/de/schmidtdennis/MapReduce/results/over_1_second.txt");

        // shuffle under 1 second
        for (String host : hosts) {
            byte[] under1Second = Files.readAllBytes(Paths.get("src/main/java/de/schmidtdennis/MapReduce/" + host +
                    "/under_1_second.txt"));
            Files.write(under1SecondResultPath, under1Second, StandardOpenOption.APPEND);
        }

        // shuffle over 1 secoond
        for (String host : hosts) {
            List<String> over1Second = Files.readAllLines(Paths.get("src/main/java/de/schmidtdennis/MapReduce/" + host +
                    "/over_1_second.txt"));
            Files.write(over1SecondResultPath, over1Second, StandardOpenOption.APPEND);
        }

    }
}
