package org.algorithms.io.meta;

public class ExcelTitleToNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String columnTitle) {
        if (columnTitle.isBlank())
            return 0;

        int titleToNumber = 0;
        for (char column : columnTitle.toCharArray()) {
            int curr = (column - 'A') + 1;
            titleToNumber = titleToNumber * 26 + curr;
        }

        return titleToNumber;
    }
}
