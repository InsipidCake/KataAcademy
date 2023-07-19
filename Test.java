import java.util.InputMismatchException;
import java.util.Scanner;

public class Test{
    static int a,b;
    static char operation;
    static int result;
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String input = scanner.nextLine();
        scanner.close();
        char[] inputToArr = new char[9];
        int oper = 0;
        for(int i = 0;i<input.length();i++){
            inputToArr[i] = input.charAt(i);
            if(inputToArr[i] == '+'){
                operation = '+';oper++;
            }if(inputToArr[i] == '-'){
                operation = '-';oper++;
            }if(inputToArr[i] == '*'){
                operation = '*';oper++;
            }if(inputToArr[i] == '/'){
                operation = '/';oper++;
            }
        }
        if(oper<1){
            throw new Exception("нехватает знака");
        }if(oper>1){
            throw new Exception("слишком много знаков");
        }
        String[] variables = input.split("[+-/*]");
        String aStr = variables[0];
        String bStr = variables[1];
        if(aStr.contains("X")||aStr.contains("I")||aStr.contains("V")){
            if(bStr.contains("X")||bStr.contains("I")||bStr.contains("V")){
                a = RomanToInt(aStr);
                b = RomanToInt(bStr);
                switch (operation){
                    case '+': result = a+b; break;
                    case '-': result = a-b; break;
                    case '*': result = a*b; break;
                    case '/': result = a/b; break;
                }
                if(result>=0){
                    System.out.println(intToRoman(result));
                }else{
                    throw new Exception("в римской системе нет отрицательных чисел");
                }                
            }else{
                try{
                basicCalculate(Integer.parseInt(aStr), Integer.parseInt(bStr));
                System.out.println(result);
                }catch(Exception l){
                    throw new Exception("разные системы счисления");
                }
        }
        }else{
            try{
            basicCalculate(Integer.parseInt(aStr), Integer.parseInt(bStr));
            System.out.println(result);
            }catch(Exception l){
                throw new Exception("разные системы счисления");
            }
        }
    }
    static int RomanToInt(String m) throws InputMismatchException{
        try {
            switch(m){
                case "I": return 1;
                case "II": return 2;
                case "III": return 3;
                case "IV": return 4;
                case "V": return 5;
                case "VI": return 6;
                case "VII": return 7;
                case "VIII":return 8;
                case "IX": return 9;
                case "X": return 10;
            }
        } catch (InputMismatchException e) {
            System.out.println("m");
        }
        return -1;
    }
    static String intToRoman(int o){
        String[] RomanNum = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
        "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
        "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
        "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
        "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
        "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
        "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        return RomanNum[o--];
    }
    static void basicCalculate(int a, int b){
        switch(operation){
            case '+': result = a+b; break;
            case '-': result = a-b; break;
            case '*': result = a*b; break;
            case '/': result = a/b; break;
        }
    }
}
