import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberSystemConverterAndCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        String userNum;
        String userNum2;
        int firstNumLenth;
        int secondNumLenth;
        int hasremains;
        int user_Num;
        int result;
        int power;
        StringBuilder resultBuilder;

        Map<Character, Integer> hexadecimalMap = new HashMap<>();
        hexadecimalMap.put('A', 10);
        hexadecimalMap.put('B', 11);
        hexadecimalMap.put('C', 12);
        hexadecimalMap.put('D', 13);
        hexadecimalMap.put('E', 14);
        hexadecimalMap.put('F', 15);

        Map<Integer, Character> reversedHexadecimalMap = new HashMap<>();
        reversedHexadecimalMap.put(10, 'A');
        reversedHexadecimalMap.put(11, 'B');
        reversedHexadecimalMap.put(12, 'C');
        reversedHexadecimalMap.put(13, 'D');
        reversedHexadecimalMap.put(14, 'E');
        reversedHexadecimalMap.put(15, 'F');

        while (choice != 0) {
            System.out.println("Welcome ");
            System.out.println("1. Binary to decimal");
            System.out.println("2. Decimal to binary");
            System.out.println("3. Octal to decimal");
            System.out.println("4. Decimal to Octal");
            System.out.println("5. Hexadecimal to Decimal");
            System.out.println("6. Decimal to Hexadecimal");
            System.out.println("7. Addition with Binary");
            System.out.println("8. Subtraction with Binary");
            System.out.println("9. Addition with Octal");
            System.out.println("10. Subtraction with Octal");
            System.out.println("11. Addition with Hexadecimal");
            System.out.println("12. Subtraction with Hexadecimal");
            System.out.println("0. Exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    result = 0;
                    System.out.println("your binary number to convert Dec:");
                    scanner.nextLine();
                    userNum = scanner.nextLine();
                    power = userNum.length()-1;

                    for(int i = 0; i < userNum.length(); i++){
                        char binaryChar = userNum.charAt(i);
                        if (binaryChar == '1'){
                            result+= Math.pow(2, power);
                        }
                        power--;
                    }

                    System.out.println("result: " +result);
                    break;

                case 2:
                    System.out.println("your Decimal number to convert Binary:");
                    scanner.nextLine();
                    user_Num = scanner.nextInt();

                    resultBuilder = new StringBuilder();
                    while (user_Num>0){
                        resultBuilder.append(user_Num % 2);
                        user_Num /=2;
                    }

                    System.out.println("result: " +resultBuilder.reverse());
                    break;

                case 3:
                    result = 0;
                    System.out.println("your Octal number to convert Dec:");
                    scanner.nextLine();
                    userNum = scanner.nextLine();
                    power = userNum.length()-1;

                    for(int i = 0; i < userNum.length(); i++){
                        char numChar = userNum.charAt(i);
                        result += Character.getNumericValue(numChar)*Math.pow(8, power);
                        power--;
                    }

                    System.out.println("result: " +result);
                    break;

                case 4:
                    System.out.println("your Decimal number to convert Oct:");
                    scanner.nextLine();
                    user_Num = scanner.nextInt();

                    resultBuilder = new StringBuilder();
                    while (user_Num>0){
                        resultBuilder.append(user_Num % 8);
                        user_Num /=8;
                    }

                    System.out.println("result: " +resultBuilder.reverse());
                    break;

                case 5:
                    result = 0;
                    System.out.println("your Hex number to convert Dec:");
                    scanner.nextLine();
                    userNum = scanner.nextLine();
                    power = userNum.length()-1;

                    for(int i = 0; i < userNum.length(); i++){
                        char numChar = userNum.charAt(i);
                        int numInt;
                        if (hexadecimalMap.containsKey(numChar)){
                            numInt = hexadecimalMap.get(numChar);
                        }else {

                            numInt = Character.getNumericValue(numChar);
                        }
                        result += numInt*Math.pow(16, power);
                        power--;
                    }

                    System.out.println("result: " +result);
                    break;

                case 6:
                    System.out.println("your Decimal number to convert into Hex:");
                    scanner.nextLine();
                    user_Num = scanner.nextInt();

                    resultBuilder = new StringBuilder();
                    while (user_Num>0){
                        if(reversedHexadecimalMap.containsKey(user_Num % 16)){
                            resultBuilder.append(reversedHexadecimalMap.get(user_Num % 16));
                        }else {
                            resultBuilder.append(user_Num % 16);
                        }
                        user_Num /=16;
                    }

                    System.out.println("result: " +resultBuilder.reverse());
                    break;

                case 7:
                    System.out.println("your first Binary number to add:");
                    scanner.nextLine();
                    userNum = scanner.nextLine();
                    System.out.println("your second Binary number to add:");
                    userNum2 = scanner.nextLine();

                    resultBuilder = new StringBuilder();
                    hasremains = 0;
                    firstNumLenth = userNum.length()-1;
                    secondNumLenth = userNum2.length()-1;

                    while (firstNumLenth>=0 && secondNumLenth>=0){
                        if(userNum.charAt(firstNumLenth)=='1'){
                            if (userNum2.charAt(secondNumLenth) =='1'){
                                if(hasremains==1){
                                    resultBuilder.append(1);
                                }else {
                                    resultBuilder.append(0);
                                    hasremains = 1;
                                }
                            }
                            if (userNum2.charAt(secondNumLenth) =='0'){
                                System.out.println(hasremains);
                                if (hasremains == 1) {
                                    resultBuilder.append(0);
                                } else {
                                    resultBuilder.append(1);
                                }
                            }
                        }
                        if(userNum.charAt(firstNumLenth)=='0'){
                            if (userNum2.charAt(secondNumLenth) =='1'){
                                if (hasremains == 1) {
                                    resultBuilder.append(0);
                                } else {
                                    resultBuilder.append(1);
                                }
                            }
                            if (userNum2.charAt(secondNumLenth) =='0') {
                                if(hasremains == 1) {
                                    resultBuilder.append(1);
                                    hasremains = 0;
                                } else {
                                    resultBuilder.append(0);
                                }
                            }

                        }

                        if (firstNumLenth>=0){
                            firstNumLenth--;
                        }
                        if (secondNumLenth>=0){
                            secondNumLenth--;
                        }

                    }
                    if (firstNumLenth==0 || secondNumLenth ==0){
                        if (hasremains==1){
                            System.out.println(resultBuilder);
                            resultBuilder.append(0);
                            resultBuilder.append(1);
                            hasremains = 0;
                        }else {
                            resultBuilder.append(1);
                            hasremains = 0;
                        }
                    }
                    if(hasremains == 1){
                        resultBuilder.append(1);
                    }

                    System.out.println("result: " +resultBuilder.reverse());
                    break;

                case 8:
                    System.out.println("your first Binary number to subtract:");
                    scanner.nextLine();
                    userNum = scanner.nextLine();
                    System.out.println("your second Binary number to subtract:");
                    userNum2 = scanner.nextLine();

                    resultBuilder = new StringBuilder();
                    hasremains = 0;
                    firstNumLenth = userNum.length()-1;
                    secondNumLenth = userNum2.length()-1;

                    while (firstNumLenth>=0 && secondNumLenth>=0){
                        if(userNum.charAt(firstNumLenth)=='0' && userNum2.charAt(secondNumLenth)=='1'){
                            if(hasremains==0){
                                resultBuilder.append(1);
                                hasremains = 1;
                            }else {
                                resultBuilder.append(0);

                            }
                        }else {
                            if(hasremains==0) {
                                resultBuilder.append(Character.getNumericValue(userNum.charAt(firstNumLenth)) -
                                                     Character.getNumericValue(userNum2.charAt(secondNumLenth)));
                            }else {
                                resultBuilder.append(0);
                            }
                        }

                        if (firstNumLenth>=0){
                            firstNumLenth--;
                        }
                        if (secondNumLenth>=0){
                            secondNumLenth--;
                        }
                    }
                    if (firstNumLenth==0 && hasremains == 0){
                        resultBuilder.append(1);
                    }

                    System.out.println("result: " +resultBuilder.reverse());
                    break;

                case 9:
                    System.out.println("your first Octal number to add:");
                    scanner.nextLine();
                    userNum = scanner.nextLine();
                    System.out.println("your second Octal number:");
                    userNum2 = scanner.nextLine();

                    resultBuilder = new StringBuilder();
                    hasremains = 0;
                    firstNumLenth = userNum.length()-1;
                    secondNumLenth = userNum2.length()-1;

                    while (firstNumLenth>=0 && secondNumLenth>=0){
                        result = Character.getNumericValue(userNum.charAt(firstNumLenth))+
                                 Character.getNumericValue(userNum2.charAt(secondNumLenth));
                        if (hasremains==1){
                            result++;
                        }
                        if (result>=8){
                            resultBuilder.append(result-8);
                            hasremains = 1;
                        }else {
                            resultBuilder.append(result);
                            hasremains = 0;
                        }
                        result =0;
                        if (firstNumLenth>=0){
                            firstNumLenth--;
                        }
                        if (secondNumLenth>=0){
                            secondNumLenth--;
                        }
                    }
                    if (firstNumLenth==0){
                        if (hasremains == 0) {
                            resultBuilder.append(userNum.charAt(0));
                        }else {
                            if(userNum.charAt(0)!='7') {
                                resultBuilder.append(Character.getNumericValue(userNum.charAt(0)) + 1);
                            }else {
                                resultBuilder.append(0);
                                resultBuilder.append(1);
                            }
                        }
                    }
                    if (secondNumLenth==0){
                        if (hasremains == 0) {
                            resultBuilder.append(userNum2.charAt(0));
                        }else {
                            if(userNum2.charAt(0)!='7') {
                                resultBuilder.append(Character.getNumericValue(userNum2.charAt(0)) + 1);
                            }else {
                                resultBuilder.append(0);
                                resultBuilder.append(1);
                            }
                        }
                    }
                    System.out.println("result: " +resultBuilder.reverse());
                    break;

                case 10:
                    System.out.println("your first Octal number to subtract:");
                    scanner.nextLine();
                    userNum = scanner.nextLine();
                    System.out.println("your second Octal number:");
                    userNum2 = scanner.nextLine();

                    resultBuilder = new StringBuilder();
                    hasremains = 0;
                    firstNumLenth = userNum.length()-1;
                    secondNumLenth = userNum2.length()-1;

                    while (firstNumLenth>=0 && secondNumLenth>=0){
                        int Oct1 = Character.getNumericValue(userNum.charAt(firstNumLenth));
                        int Oct2 = Character.getNumericValue(userNum2.charAt(secondNumLenth));

                        if (hasremains == 1){
                            Oct1--;
                            hasremains =0;
                        }

                        if (Oct1 < Oct2) {
                            resultBuilder.append(Oct1+8-Oct2);
                            hasremains = 1;
                        }else {
                            resultBuilder.append(Oct1-Oct2);
                        }

                        if (firstNumLenth>=0){
                            firstNumLenth--;
                        }
                        if (secondNumLenth>=0){
                            secondNumLenth--;
                        }
                    }
                    if (firstNumLenth==0){
                        if (hasremains == 0) {
                            resultBuilder.append(userNum.charAt(0));
                        }else {
                            resultBuilder.append(Character.getNumericValue(userNum.charAt(0)-1));
                        }
                    }

                    System.out.println("result: " +resultBuilder.reverse());
                    break;

                case 11:
                    System.out.println("your first Hex number to add:");
                    scanner.nextLine();
                    userNum = scanner.nextLine();
                    System.out.println("your second Hex number:");
                    userNum2 = scanner.nextLine();

                    resultBuilder = new StringBuilder();
                    hasremains = 0;
                    firstNumLenth = userNum.length()-1;
                    secondNumLenth = userNum2.length()-1;

                    while (firstNumLenth>=0 && secondNumLenth>=0){
                        char hexChar1 =userNum.charAt(firstNumLenth);
                        char hexChar2 = userNum2.charAt(secondNumLenth);
                        int hex1, hex2;
                        int resultHexValue;

                        if (hexadecimalMap.containsKey(hexChar1)){
                            hex1 = hexadecimalMap.get(hexChar1);
                        }else {
                            hex1 = Character.getNumericValue(hexChar1);
                        }

                        if (hexadecimalMap.containsKey(hexChar2)){
                            hex2 = hexadecimalMap.get(hexChar2);
                        }else {
                            hex2 = Character.getNumericValue(hexChar2);
                        }

                        result = hex1 + hex2;
                        if (hasremains==1){
                            result++;
                        }
                        if (result>=16){
                            resultHexValue = result - 16;
                            if(reversedHexadecimalMap.containsKey(resultHexValue)){
                                resultBuilder.append(reversedHexadecimalMap.get(resultHexValue));
                            }else {
                                resultBuilder.append(result - 16);
                            }
                            hasremains = 1;
                        }else {
                            if(reversedHexadecimalMap.containsKey(result)){
                                resultBuilder.append(reversedHexadecimalMap.get(result));
                            }else {
                                resultBuilder.append(result);
                            }
                            hasremains = 0;
                        }
                        result =0;
                        if (firstNumLenth>=0){
                            firstNumLenth--;
                        }
                        if (secondNumLenth>=0){
                            secondNumLenth--;
                        }
                    }
                    if (firstNumLenth==0){
                        if (hasremains == 0) {
                            resultBuilder.append(userNum.charAt(0));
                        }else {
                            if(hexadecimalMap.containsKey(userNum.charAt(0))){
                                if(userNum.charAt(0)!='F'){
                                    resultBuilder.append(reversedHexadecimalMap.get(hexadecimalMap.get(userNum.charAt(0))+1));
                                }else{
                                    resultBuilder.append(0);
                                    resultBuilder.append(1);
                                }
                            }
                            hasremains = 0;
                        }
                    }
                    if (secondNumLenth==0){
                        if (hasremains == 0) {
                            resultBuilder.append(userNum2.charAt(0));
                        }else {
                            if(hexadecimalMap.containsKey(userNum2.charAt(0))){
                                if(userNum2.charAt(0)!='F'){
                                    resultBuilder.append(reversedHexadecimalMap.get(hexadecimalMap.get(userNum2.charAt(0))+1));
                                }else{
                                    resultBuilder.append(0);
                                    resultBuilder.append(1);
                                }
                            }
                            hasremains = 0;
                        }
                    }
                    System.out.println("result: " +resultBuilder.reverse());
                    break;

                case 12:
                    System.out.println("your first Hex number to subtract:");
                    scanner.nextLine();
                    userNum = scanner.nextLine();
                    System.out.println("your second Hex number:");
                    userNum2 = scanner.nextLine();

                    resultBuilder = new StringBuilder();
                    hasremains = 0;
                    firstNumLenth = userNum.length()-1;
                    secondNumLenth = userNum2.length()-1;

                    while (firstNumLenth>=0 && secondNumLenth>=0) {
                        char hexChar1 = userNum.charAt(firstNumLenth);
                        char hexChar2 = userNum2.charAt(secondNumLenth);
                        int hex1, hex2;
                        int resultHexValue;

                        if (hexadecimalMap.containsKey(hexChar1)) {
                            hex1 = hexadecimalMap.get(hexChar1);
                        } else {
                            hex1 = Character.getNumericValue(hexChar1);
                        }

                        if (hexadecimalMap.containsKey(hexChar2)) {
                            hex2 = hexadecimalMap.get(hexChar2);
                        } else {
                            hex2 = Character.getNumericValue(hexChar2);
                        }

                        if (hasremains == 1){
                            hex1--;
                            hasremains =0;
                        }

                        if (hex1 < hex2) {
                            resultHexValue = hex1+16-hex2;
                            if(reversedHexadecimalMap.containsKey(resultHexValue)){
                                resultBuilder.append(reversedHexadecimalMap.get(resultHexValue));
                            }else {
                                resultBuilder.append(resultHexValue);
                            }
                            hasremains = 1;
                        }else {
                            resultHexValue = hex1-hex2;
                            if(reversedHexadecimalMap.containsKey(resultHexValue)){
                                resultBuilder.append(reversedHexadecimalMap.get(resultHexValue));
                            }else {
                                resultBuilder.append(resultHexValue);
                            }
                        }

                        if (firstNumLenth>=0){
                            firstNumLenth--;
                        }
                        if (secondNumLenth>=0){
                            secondNumLenth--;
                        }
                    }

                    if (firstNumLenth==0){
                        if (hasremains == 0) {
                            resultBuilder.append(userNum.charAt(0));
                        }else {
                            if(hexadecimalMap.containsKey(userNum.charAt(0))){
                                if(hexadecimalMap.get(userNum.charAt(0))==10){
                                    resultBuilder.append(9);
                                }else {
                                    resultBuilder.append(reversedHexadecimalMap.get(hexadecimalMap.get(userNum.charAt(0))-1));
                                }
                            }else {
                                resultBuilder.append(Character.getNumericValue(userNum.charAt(0) - 1));
                            }
                        }
                    }
                    System.out.println("result: " +resultBuilder.reverse());
                    break;
            }
        }
    }
}


