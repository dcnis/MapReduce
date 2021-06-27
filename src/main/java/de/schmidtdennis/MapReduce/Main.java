package de.schmidtdennis.MapReduce;

import de.schmidtdennis.MapReduce.jobs.Map;
import de.schmidtdennis.MapReduce.jobs.Reduce;
import de.schmidtdennis.MapReduce.jobs.Shuffle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    Map mapFunction = new Map();
    Shuffle shuffleFunction = new Shuffle();
    Reduce reduceFunction = new Reduce();

    public static void main(String[] args) throws IOException {
        List<String> hosts = List.of("host1", "host2");
        clearFiles(hosts);

        Main program = new Main();
        program.run(hosts);
    }

    private void run(List<String> hosts) throws IOException {
        // Map Step
        for(String host : hosts){
            mapFunction.map(host);
        }

        // Shuffle Step
        shuffleFunction.shuffle(hosts);

        // Reduce Step
        reduceFunction.reduce();

    }


    private static void clearFiles(List<String> hosts) throws IOException {
        for(String host : hosts){

            Path over1Second = Paths.get("src/main/java/de/schmidtdennis/MapReduce/" + host + "/over_1_second.txt");
            Path under1Second = Paths.get("src/main/java/de/schmidtdennis/MapReduce/" + host + "/under_1_second.txt");
            Files.deleteIfExists(over1Second);
            Files.deleteIfExists(under1Second);
            Files.createFile(over1Second);
            Files.createFile(under1Second);

            Path over1SecondResult = Paths.get("src/main/java/de/schmidtdennis/MapReduce/results/over_1_second.txt");
            Path under1SecondResult = Paths.get("src/main/java/de/schmidtdennis/MapReduce/results/under_1_second.txt");
            Files.deleteIfExists(over1SecondResult);
            Files.deleteIfExists(under1SecondResult);
            Files.createFile(over1SecondResult);
            Files.createFile(under1SecondResult);
        }

        Path result = Paths.get("src/main/java/de/schmidtdennis/MapReduce/results/result.txt");
        Files.deleteIfExists(result);
        Files.createFile(result);

    }
}
