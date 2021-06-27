package de.schmidtdennis.MapReduce.jobs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MapReduce {

    public void emitMapResult(String host, String key, String value) throws IOException {
        Path under1SecondPath = Paths.get("src/main/java/de/schmidtdennis/MapReduce/" + host + "/" + key + ".txt");
        Files.write(under1SecondPath, (value+"\n").getBytes(), StandardOpenOption.APPEND);
    }


}
