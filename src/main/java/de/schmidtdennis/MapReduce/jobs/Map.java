package de.schmidtdennis.MapReduce.jobs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Map {

    MapReduce mapReduce = new MapReduce();

    public void map(String host) throws IOException {

        Path file = Paths.get("src/main/java/de/schmidtdennis/MapReduce/" + host + "/latencies.txt");

        for(String latency : Files.readAllLines(file)){
            if(Integer.parseInt(latency) < 1000){
                mapReduce.emitMapResult(host, "under_1_second", "1");
            } else {
                mapReduce.emitMapResult(host, "over_1_second", "1");
            }
        }
    }

}
