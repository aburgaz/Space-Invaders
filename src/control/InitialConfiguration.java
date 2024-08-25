package tp1.control;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.io.*;
import java.util.Collections;
import java.util.List;


public class InitialConfiguration {

    public static final InitialConfiguration NONE = new InitialConfiguration();     //CONFIGURACION DEFAULT

    private List<String> descriptions;

    private InitialConfiguration() {
    }

    // CARGA DEL ARCHIVO
    public static InitialConfiguration readFromFile(String filename) throws InvalidPathException, IOException {

        String inBytes = Files.readString(Paths.get(filename), StandardCharsets.UTF_8);
        InitialConfiguration ic = new InitialConfiguration(Arrays.stream(inBytes.split("\n")).toList());

        return ic;
    }


    private InitialConfiguration(List<String> descriptions) {
        this.descriptions = descriptions;       //Devuelve la lista con las naves
    }

    public List<String> getShipDescription() {
        return Collections.unmodifiableList(descriptions);
    }
}