import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FizzBuzz{

    private final int maxValue = 100;
    private final int minValue = 1;
    private final int operationBy3 = 3;
    private final int operationBy5 = 5;
    private final String Fizz = "Fizz";
    private final String Buzz = "Buzz";

    public int getMaxValue() {return maxValue;}
    public int getMinValue() {return minValue;}
    public String getFizzValue() {return Fizz;}
    public String getBuzzValue() {return Buzz;}
    public int getOperationBy3Value() {return operationBy3;}
    public int getOperationBy5Value() {return operationBy5;}

    public String FizzBuzz(){

        List<String> result = new ArrayList();
        
        for (int i = minValue; i <= maxValue; i++){
            result.add(checkNumber(i));
        }

        return result.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(", "));
    }

    public String checkNumber(int num) {

        String result = "";

        if (num % operationBy3 == 0){
            result += Fizz;
        }

        if (num % operationBy5 == 0){
            result += Buzz;
        }

        return result == "" ? Integer.toString(num) : result;
    }
}