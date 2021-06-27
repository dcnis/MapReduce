package de.schmidtdennis.MapReduce.jobs;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Map {

    MapReduce mapReduce = new MapReduce();

    public void map(String host) throws IOException {

        File file = new File("src/main/java/de/schmidtdennis/MapReduce/" + host + "/latencies.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String latency = scanner.nextLine();
            if(Integer.parseInt(latency) < 1000){
                mapReduce.emitMapResult(host, "under_1_second", "1");
            } else {
                mapReduce.emitMapResult(host, "over_1_second", "1");
            }
        }
    }

}
