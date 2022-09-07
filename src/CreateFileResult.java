import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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
        List<String> firstList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();
        try (BufferedReader bfr = Files.newBufferedReader(file)) {
            // List<String> batch = new ArrayList<>(batchSize);
            int firstListSize = Integer.parseInt(bfr.readLine());
            firstList = bfr.lines().limit(firstListSize).toList();
            secondList = bfr.lines().skip(firstListSize + 2).toList();
         /*   for (String line; (line = bfr.readLine().trim().isBlank() ==); ) {
                bfr.;
                if (firstBatchSize == null) {
                    Integer.parseInt(line)
                }
                batch.add(line);
                if (batch.size() == batchSize) {
                    processBatch(batch);
                    batch = new ArrayList<>(batchSize); // or: batch.clear()
                }
            }*/

        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : firstList) {
         /*   List<String> strings = Arrays.stream(s.split(" ")).toList();
            for (String str : strings){
                str.contentEquals(secondList.)
            }*/

            for (String str : secondList){
                s..contentEquals(str)
            }
        }
    }

    public static void main(String... args) throws IOException {
        givenLargeFileWhenUsingFilesAPI();
    }
}
