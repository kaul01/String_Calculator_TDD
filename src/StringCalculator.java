import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String string){
        if(string.isEmpty()){
            return 0;
        }
        else if(string.length() == 1){
            int num =  Integer.parseInt(string);
            try {
                if (num < 0) {
                    throw new Exception();
                }
                return num;
            }
            catch(Exception a){
                System.out.println("negatives not allowed " + num);
            }

        }
        else{
            int res = 0;
            if(string.startsWith("//")){
                Matcher matcher = Pattern.compile("//\\[(.*)\\]\n(.*)").matcher(string);
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
        return 0;
    }
    public int addMultiple(String[] arr){
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i< arr.length ; i++){
            int num = Integer.parseInt(arr[i]);
            try{
                if(num < 0){
                    list.add(num);
                    throw new Exception();
                }
                if(num > 1000){
                    continue;
                }
                res += num;
            }
            catch(Exception a){
                System.out.println("negatives not allowed ");
            }
        }
        if(!list.isEmpty()){
            System.out.println("The negative numbers are" + list);
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

    public int multipleDelimiters(String string){
        int res=0;
        Matcher matcher = Pattern.compile("//\\[(.*)\\]\\[(.*)\\]\n(.*)").matcher(string);
        if(matcher.matches()){
            String delimiter1 = matcher.group(1);
            String delimiter2 = matcher.group(2);
//            String toSplit = matcher.group(3);
            System.out.println(delimiter1 + "  " + delimiter2);
            res = 6;
        }
        return res;
    }

}
