package tckdevtraining.poc;


import lombok.extern.java.Log;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Log
@Command(name = "tckpoc-form", description = "Display the form of a tck configuration.")
public class TCKPOCForm implements Callable<Integer> {

    @Parameters(description = "Type of configuration: 'dso', 'dse' or 'conn'.", paramLabel = "type")
    private Type type;

    @Parameters(description = "Id of the desired configuration.", paramLabel = "id")
    private String id;

    @Override
    public Integer call(){
        log.info(String.format("Generate tck form for type: %s, ID: %s", type, id));

        return 0;
    }

    enum Type {
        dso, dse, conn
    }

    public static void main(String[] args){
        int exitCode = new CommandLine(new TCKPOCForm()).execute(args);
        System.exit(exitCode);
    }

}
