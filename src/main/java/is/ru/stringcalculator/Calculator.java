package is.ru.stringcalculator;

public class Calculator {
    public static int add(String numbers)
    {
        if(numbers.isEmpty())
            return 0;

        if(numbers.contains(","))
        {
            String[] n = numbers.split(",");
            return Integer.parseInt(n[0]) + Integer.parseInt(n[1]);
        }

        return Integer.parseInt(numbers);
    }
}
