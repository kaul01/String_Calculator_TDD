public class Calculator {

    public int add(String string){
        if(string.isEmpty()){
            return 0;
        }
        else if(string.length() == 1){
            return Integer.parseInt(string);
        }
        else{
            String [] numbers = string.split(",");
            int num1 = Integer.parseInt(numbers[0]);
            int num2 = Integer.parseInt(numbers[1]);
//            given that there are only 2 numbers for this case
            return (num1 + num2);
        }
    }
    public int addMultiple(String string){
        String[] numbers = string.split(",");
        int res = 0;
        for(int i=0 ; i< numbers.length ; i++){
            res += Integer.parseInt(numbers[i]);
        }
        return res;
    }
}
