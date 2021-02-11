import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

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
                Matcher matcher = Pattern.compile("//(.*)\n(.*)").matcher(string);
                if(matcher.matches()){
                    String delimiter = matcher.group(1);
                    String toSplit = matcher.group(2);
                    String[] numbers = toSplit.split(delimiter);

                    res = addMultiple(numbers);
                }
            }
            else{
                String[] numbers = string.split(",|\n");
                res = addMultiple(numbers);
            }
            return res;
        }
    }
    public int addMultiple(String[] arr){
        int res = 0;
        for(int i=0 ; i< arr.length ; i++){
            int num = Integer.parseInt(arr[i]);
            try{
                if(num < 0){
                    throw new Exception();
                }
                if(num > 1000){
                    continue;
                }
                res += num;
            }
            catch(Exception a){
                System.out.println("negative not allowed " + num);
            }
        }
        return res;
    }

    public int GetCalledCount(String string){
        int count=0;
        if(string.isEmpty() || string.length() == 1){
            return 0;
        }
        else{
            if(string.startsWith("//")){
                Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(string);
                if(matcher.matches()){
                    String delimiter = matcher.group(1);
                    String toSplit = matcher.group(2);
                    String[] numbers = toSplit.split(delimiter);
                    count = numbers.length - 1;
                }
            }else{
                String[] numbers = string.split(",");
                count = numbers.length - 1;
            }
        }
        return count;
    }

}
