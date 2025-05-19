package lab5;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssemblyInterpreter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 0 to run code");
        System.out.println("Enter 'quit' to stop program");
        Pattern pattern = Pattern.compile("^(?!\\d)([A-Za-z@$_]|\\.[A-Za-z@$_?])[A-Za-z0-9@$_?]*$?");
        String userIn = scanner.nextLine();

        String[] operations = {"ADD", "SUB", "MUL", "DIV", "INC", "DEC", "MOV", "XCHG"};
        String[] pseudoOpsArray = {"DB", "DW", "DD"};
        List<String> pseudoOpsArrayList = Arrays.asList(pseudoOpsArray);
        HashMap<String, String> variablesMap = new HashMap<>();
        String output = null;
        String newValue = null;
        int result = 0;
        Integer[] varFirst;
        Integer[] varSecond;



        while (!userIn.equalsIgnoreCase("quit")) {
            if(userIn.equalsIgnoreCase("0")){
                System.out.println("Result:"+output);
            }
            String[] words = userIn.split("\\s+");
            /*creating variable*/
            if (words.length>1 && pseudoOpsArrayList.contains(words[1])) {
                Matcher matcher = pattern.matcher(words[0]);
                if (!matcher.matches()) {
                    System.out.println(words[0] + " is a invalid variable name.");
                }else {
                    variablesMap.put(words[0],words[2]);
                    output = words[2];
                }
            }else {
                switch (words[0]){
                    case "ADD":
                        varFirst = numberType(words[1],variablesMap);
                        varSecond = numberType(words[2],variablesMap);

                        result =varFirst[0]+varSecond[0];
                        result = Math.abs(result);

                        newValue = addLetter(varFirst[1], result);

                        variablesMap.put(words[1], newValue);
                        output = variablesMap.get(words[1]);
                        break;
                    case "SUB":
                        varFirst = numberType(words[1],variablesMap);
                        varSecond = numberType(words[2],variablesMap);

                        result =varFirst[0]-varSecond[0];
                        /*result = Math.abs(result);*/

                        newValue = addLetter(varFirst[1], result);

                        variablesMap.put(words[1], newValue);
                        output = variablesMap.get(words[1]);
                        break;
                    case "MUL":
                        varFirst = numberType(words[1],variablesMap);
                        varSecond = numberType(words[2],variablesMap);

                        result =varFirst[0]*varSecond[0];
                        result = Math.abs(result);

                        newValue = addLetter(varFirst[1], result);

                        variablesMap.put(words[1], newValue);
                        output = variablesMap.get(words[1]);
                        break;
                    case "DIV":
                        varFirst = numberType(words[1],variablesMap);
                        varSecond = numberType(words[2],variablesMap);

                        result =varFirst[0]/varSecond[0];
                        result = Math.abs(result);

                        newValue = addLetter(varFirst[1], result);

                        variablesMap.put(words[1], newValue);
                        output = variablesMap.get(words[1]);
                        break;
                    case "INC":
                        varFirst = numberType(words[1],variablesMap);
                        result= varFirst[0]+1;

                        newValue = addLetter(varFirst[1], result);
                        variablesMap.put(words[1], newValue);
                        output = variablesMap.get(words[1]);
                        break;
                    case "DEC":
                        varFirst = numberType(words[1],variablesMap);
                        result= varFirst[0]-1;

                        newValue = addLetter(varFirst[1], result);
                        variablesMap.put(words[1], newValue);
                        output = variablesMap.get(words[1]);
                        break;
                    case "MOV":
                        variablesMap.put(words[1], variablesMap.get(words[2]));
                        output = variablesMap.get(words[1]);
                        break;
                    case "XCHG":
                        String var1 = variablesMap.get(words[2]);
                        String var2 = variablesMap.get(words[1]);

                        variablesMap.put(words[1], var1);
                        variablesMap.put(words[2], var2);

                        output = words[1]+"="+variablesMap.get(words[1])+","+ words[2]+"="+variablesMap.get(words[2]) ;
                        break;
                    case "0":
                        break;
                    default:
                        System.out.println("Incorrect input");
                        break;

                }
            }

            userIn = scanner.nextLine();
        }

    }

    public static Integer[] numberType(String var, HashMap variablesMap){
        int numType1 = 10;
        String var1 = (String) variablesMap.get(var);
        switch (var1.charAt(var1.length()-1)){
            case 'h':
                var1 = var1.substring(0, var1.length() - 1);
                numType1 = 16;
                break;
            case 'q':
                var1 = var1.substring(0, var1.length() - 1);
                numType1 = 8;
                break;
            case 'b':
                var1 = var1.substring(0, var1.length() - 1);
                numType1 = 2;
                break;
            case 'd':
                var1 = var1.substring(0, var1.length() - 1);
                break;
            default:
                break;
        }
        return new Integer[]{Integer.parseInt(var1, numType1), numType1};
    }

    public static String addLetter(int numType, int result){
        String newValue;
        if (numType == 16){
            newValue = Integer.toHexString(result).toUpperCase()+"h";
        } else if (numType==8) {
            newValue = Integer.toOctalString(result)+"q";
        } else if (numType == 2) {
            newValue = Integer.toBinaryString(result)+"b";
        }else {
            newValue = String.valueOf(result);
        }
        return newValue;
    }

}

/*
VAR_A DB 6
VAR_B DB 1
ADD VAR_A VAR_B
INC VAR_A
        */

/*
HEX_VAR DB 8ABh
HEX_VAR_2 DB B78h
SUB HEX_VAR HEX_VAR_2
*/

/*
CHAR_VAR DB 41h
CHAR_VAR_2 DB 42h
MOV CHAR_VAR CHAR_VAR_2
*/

/*
TEST_VAR DB 1
INC TEST_VAR*/

/*    VARIABLE_NAME DB ‘Hello,assembly!’
* */
/*
Var1 DB 8AB
        Var2 DB 78B
        SUB Var1 Var2*/
