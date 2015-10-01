package utilities.cmd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cmd {

    private HashMap<Integer, Process> processes;
    private HashMap<Integer, ArrayList<String>> outputs;

    public Cmd() {
        processes = new HashMap<>();
        outputs = new HashMap<>();
    }

    public int execute(Integer id, String cmd) {
        String[] command = cmd.split(" ");
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        try {
            processes.put(id, processBuilder.start());
            Process process = processes.get(id);
            ArrayList<String> output = new ArrayList<>();
            outputs.put(id, output);
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line;
            while ((line = br.readLine()) != null) {
                outputs.get(id).add(line);
            }
            int exitValue = process.waitFor();
            return exitValue;
        } catch (IOException | InterruptedException ignored) {
        }
        return 0;
    }

    public void stop(Integer id) {
        if (processes.get(id) != null) {
            processes.get(id).destroy();
        }
    }

    public List<String> getOutput(int id) {
        return outputs.get(id);
    }

}

