package HW18_Save_to_JSON;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainDemoJson {

    private static final Gson GSON = new Gson();

    public static void main(String[] args) throws IOException {
        int numberWorkers = 1000;
        FileWriter fileWriter = new FileWriter("src/JSON/output_workers.json");
        ArrayList<Worker> workersToOut = new ArrayList<>();
        for (int i = 0; i < numberWorkers; i++) {
            Worker worker = new Worker("name", (int) (Math.random() * 100));
            workersToOut.add(worker);
        }
        fileWriter.write(GSON.toJson(workersToOut));
        fileWriter.flush();
        fileWriter.close();
    }
}
