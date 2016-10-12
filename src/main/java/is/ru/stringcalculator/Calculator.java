package is.ru.stringcalculator;

public class Calculator {
    public static int add(String numbers)
    {
        if(numbers.isEmpty())
            return 0;

        if(numbers.contains(","))
        {
            int ret = 0;
            String[] n = numbers.split(",");

            for(String numb : n)
                ret += Integer.parseInt(numb);

            return ret;
        }

        return Integer.parseInt(numbers);
    }
}
