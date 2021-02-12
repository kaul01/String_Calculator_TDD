import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String string){
        int res = 0;
        if(string.isEmpty()){
            return res;
        }
        else if(string.length() == 1){
            int num =  toInt(string);
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
            if(string.startsWith("//")){
                Matcher matcher1 = Pattern.compile("//(.)\n(.*)").matcher(string);
                Matcher matcher2 = Pattern.compile("//\\[(.*)]\n(.*)").matcher(string);
                if(matcher1.matches()){
                    String delimiter = matcher1.group(1);
                    String toSplit = matcher1.group(2);
                    String[] numbers = toSplit.split(delimiter);
                    res = addMultiple(numbers);
                }
                if(matcher2.matches()){
                    String delimiter = matcher2.group(1);
                    String toSplit = matcher2.group(2);
                    String[] delimiter_ar = delimiter.split("]\\[");
                    if(delimiter_ar.length == 1){
                        String[] numbers = toSplit.split(delimiter);
                        res = addMultiple(numbers);
                    }
                    else{
                        String cus_delimiter = "";
                        for(int i=0 ; i<delimiter_ar.length ; i++){
                            if(i == delimiter_ar.length - 1){
                                cus_delimiter += delimiter_ar[i];
                            }else{
                                cus_delimiter += delimiter_ar[i] + "|";
                            }
                        }
                        String[] numbers = toSplit.split(cus_delimiter);
                        res = addMultiple(numbers);
                    }
                }
            }
            else{
                String[] numbers = string.split(",|\n");
                res = addMultiple(numbers);
            }
        }
        return res;
    }

    public int toInt(String s){
        return Integer.parseInt(s);
    }

    public int addMultiple(String[] arr){
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0 ; i< arr.length ; i++){
            int num = toInt(arr[i]);
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

}
