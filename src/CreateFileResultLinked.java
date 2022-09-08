import info.debatty.java.stringsimilarity.SorensenDice;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.awt.SystemColor.info;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Nodes.collect;

public class CreateFileResultLinked {


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
        String[] firstArray;
        List<String> secondArray = new ArrayList<>();


        try (BufferedReader bfr = Files.newBufferedReader(file)) {
            int firstListSize = Integer.parseInt(bfr.readLine());
            firstArray = (String[]) bfr.lines().skip(1).limit(firstListSize + 1).toArray();
            secondArray = bfr.lines().skip(firstListSize + 2).toList();

            SorensenDice sorensenDice = new SorensenDice();
            Map<String, String> outputStrings = new HashMap<>();
            Map<Integer, Map<Integer, Double>> calcFinalMap = new HashMap<>();

            for (int i = 0; i < firstArray.length; i++) {
                //int subtraction = firstArray.length - secondArray.size();
                //boolean pos = subtraction >= 0;
                Double similarity = 0.0;
                int index = -1;
                Map<Integer, Double> calcMap = new HashMap<>();
                for (int j = 0; j < secondArray.size(); j++) {
                    // StringUtils.getJaroWinklerDistance() ;
                    double calcSimilarity = sorensenDice.similarity(firstArray[i], secondArray.get(j));
                    if (calcSimilarity > similarity) {
                        similarity = calcSimilarity;
                        index = j;
                    }
                }
                if (index >= 0) {
                    calcMap.put(index, similarity);
                    calcFinalMap.put(i, calcMap);
                }
            }
            calcFinalMap.entrySet().stream().collect(Collectors(groupingBy(Map.Entry::getKey,
                   // Collectors(groupingBy(Map.Entry::getKey, Collectors.maxBy(Map.Entry::getValue))))));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String... args) throws IOException {
        givenLargeFileWhenUsingFilesAPI();
    }
}
