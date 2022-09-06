import info.debatty.java.stringsimilarity.SorensenDice;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.lang.Math.abs;

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
        String[] firstArray ;
        String[] secondArray;


        try (BufferedReader bfr = Files.newBufferedReader(file)) {
            // List<String> batch = new ArrayList<>(batchSize);
            int firstListSize = Integer.parseInt(bfr.readLine());
            firstArray = (String[]) bfr.lines().skip(1).limit(firstListSize + 1).toArray();
            secondArray = (String[]) bfr.lines().skip(firstListSize + 2).toArray();

            SorensenDice sorensenDice = new SorensenDice();
            Map<String, String> outputStrings = new HashMap<>();

            for (int i = 0; i < firstArray.length; i++) {
         /*   List<String> strings = Arrays.stream(s.split(" ")).toList();
            for (String str : strings){
                str.contentEquals(secondList.)
            }*/
                Map<Integer, Double> pairsComparity = new HashMap<>();
                int subtraction = firstArray.length - secondArray.length;
                boolean pos = subtraction >= 0;
                for (int j = 0; j < secondArray.length; j++) {
                //for (int j = secondList.length - 1; j >= 0; j--) {
                    // StringUtils.getJaroWinklerDistance() ;
                    //if (subtraction >= 0) {
                        pairsComparity.put(j, sorensenDice.similarity(firstArray[i], secondArray[j]));
                   /* } else {
                        if (j > abs(subtraction)) {

                        }
                    }*/
                }
                Map.Entry<Integer, Double> foundedPair = pairsComparity.entrySet().stream().max(Map.Entry.comparingByValue()).orElseThrow();
                outputStrings.put(firstArray[i], secondArray[foundedPair.getKey()]);
                secondArray.
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String... args) throws IOException {
        givenLargeFileWhenUsingFilesAPI();
    }
}
