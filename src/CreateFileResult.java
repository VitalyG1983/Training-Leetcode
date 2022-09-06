import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CreateFileResult {


    public static void givenLargeFileWhenUsingFilesAPI() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("/Users/vitalygavrilov/Documents/Java/training/storage/input.txt"))) {
            //String extractedLine = lines.skip(4).findFirst().get();
            // List<String> collect = lines.collect(Collectors.toCollection(ArrayList::new));
            int firstListSize = Integer.parseInt(lines.findFirst().orElseThrow());
            List<String> firstList = lines.limit(firstListSize).toList();
            lines.limit(firstListSize).toList();
            // List<String> secondList = lines.skip(firstListSize + 1).toList();


            Supplier<Stream<String>> streamSupplier
                    = () -> Stream.of("A", "B", "C", "D");
        }
    }

    public static void BufferedReader() {
        final int batchSize = 2;
        Path file = Paths.get("/Users/vitalygavrilov/Documents/Java/training/storage/input.txt");

        try (BufferedReader bfr = Files.newBufferedReader(file)) {
            List<String> batch = new ArrayList<>(batchSize);
            Integer firstBatchSize = null;
            for (String line; (line = bfr.readLine().trim().isBlank()==) ; ) {
                if (firstBatchSize == null) {
                    Integer.parseInt(line)
                }
                batch.add(line);
                if (batch.size() == batchSize) {
                    processBatch(batch);
                    batch = new ArrayList<>(batchSize); // or: batch.clear()
                }
            }
            if (!batch.isEmpty()) {
                //  process(batch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) throws IOException {
        givenLargeFileWhenUsingFilesAPI();
    }
}
