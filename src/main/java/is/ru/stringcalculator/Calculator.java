package is.ru.stringcalculator;

import java.util.List;
import java.lang.String;
import java.util.ArrayList;

public class Calculator {
    public static int add(String numbers)
    {
        if(numbers.isEmpty())
            return 0;

        numbers = numbers.replace("\n", ",");

        if(numbers.contains("//"))
        {
            numbers = numbers.replace(numbers.substring(2,3), ",");
            numbers = numbers.substring(4);
        }

        int[] n = parseNumbers(numbers);

        negativeCheck(n);

        return sum(n);
    }

    private static int[] parseNumbers(String numbers)
    {
        String[] s = numbers.split(",");
        int[] ret = new int[s.length];
        for(int i = 0; i < s.length; i++)
            ret[i] = Integer.parseInt(s[i]);

        return ret;
    }

    private static int sum(int[] n)
    {
        int ret = 0;
        for(int num : n)
        {
            if(num <= 1000)
                ret += num;
        }
        return ret;
    }

    private static void negativeCheck(int[] n)
    {
        List<String> neg = new ArrayList<String>();
        for(int num : n)
        {
            if(num < 0)
                neg.add(Integer.toString(num));
        }

        if(!neg.isEmpty())
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(",", neg));
    }
}
