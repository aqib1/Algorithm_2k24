package org.algorithms.io.amazon2k24;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.*;

enum LogType {
    LETTER, DIGIT
}

class Log {
    String identifier;
    String entry;
    public Log(String identifier, String entry) {
        this.identifier = identifier;
        this.entry = entry;
    }
}

public class ReorderingLogFiles {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        reorderLogFiles(new String[] {
                                "zoey i love you","lucas i love you","rong i love you"
                        })
                )
        );
    }

    public static String[] reorderLogFiles(String[] logs) {
        String[] result = new String[logs.length];
        var lexicographicalOrderHeap = new PriorityQueue<>(
                Map.Entry.<String, String>comparingByValue().thenComparing(Map.Entry::getKey)
        );
        var map = new HashMap<LogType, List<Log>>();

        for(String log: logs) {
            var logData = log.split(" ");
            if(isNumeric(logData[1])) {
                var logList = map.getOrDefault(LogType.DIGIT, new ArrayList<>());
                logList.add(new Log(logData[0], log));
                map.put(LogType.DIGIT, logList);
            } else {
                lexicographicalOrderHeap.offer(new AbstractMap.SimpleEntry<>(
                        logData[0], log.substring(logData[0].length() + 1)
                ));
            }
        }

        while(!lexicographicalOrderHeap.isEmpty()) {
            var order = lexicographicalOrderHeap.poll();
            var logList = map.getOrDefault(LogType.LETTER, new ArrayList<>());
            logList.add(new Log(order.getKey(), order.getKey() + " "+ order.getValue()));
            map.put(LogType.LETTER, logList);
        }

        var letters = map.getOrDefault(LogType.LETTER, List.of());
        var digits = map.getOrDefault(LogType.DIGIT, List.of());
        int index = 0;
        if(!letters.isEmpty()) {
            for (var letter : letters) {
                result[index] = letter.entry;
                index++;
            }
        }

        if(!digits.isEmpty()) {
            for (var digit : digits) {
                result[index] = digit.entry;
                index++;
            }
        }

        return result;
    }

    private static boolean isNumeric(String data) {
        ParsePosition position = new ParsePosition(0);
        NumberFormat.getInstance().parse(data, position);
        return data.length() == position.getIndex();
    }
}
