import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int add(String string){
        if(string.isEmpty()){
            return 0;
        }
        else if(string.length() == 1){
            return Integer.parseInt(string);
        }
        else{
            int res = 0;
            if(string.startsWith("//")){
                Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(string);
                if(matcher.matches()){
                    String delimiter = matcher.group(1);
                    String toSplit = matcher.group(2);
                    String[] numbers = toSplit.split(delimiter);

                    res = addMultiple(numbers);
                }
            }
            else{
                String[] numbers = string.split(",|\n");
                if (numbers.length == 2) {
                    int num1 = Integer.parseInt(numbers[0]);
                    int num2 = Integer.parseInt(numbers[1]);
                    res = num1 + num2;
                } else {
                    res = addMultiple(numbers);
                }
            }
            return res;
        }
    }
    public int addMultiple(String[] arr){
        int res = 0;
        for(int i=0 ; i< arr.length ; i++){
            res += Integer.parseInt(arr[i]);
        }
        return res;
    }

}
