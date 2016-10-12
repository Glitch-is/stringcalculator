package is.ru.stringcalculator;

public class Calculator {
    public static int add(String numbers)
    {
        if(numbers.isEmpty())
            return 0;

        numbers = numbers.replace("\n", ",");

        if(numbers.contains(","))
        {
            int ret = 0;
            String[] n = numbers.split(",");

            for(String snum : n)
            {
                int num = Integer.parseInt(snum);
                if(num < 0)
                    throw new IllegalArgumentException("Negatives not allowed: " + num);

                ret += num;
            }

            return ret;
        }

        return Integer.parseInt(numbers);
    }
}
