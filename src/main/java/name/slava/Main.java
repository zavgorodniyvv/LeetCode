package name.slava;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputBuilder = new StringBuilder();
        String line;
        while (scanner.hasNextLine() && !(line = scanner.nextLine()).isEmpty()) {
            inputBuilder.append(line).append("::");
        }
        String input = inputBuilder.toString();
        for(var expression: input.split("::")){
            handleExpression(expression);
        }
    }

    private static void handleExpression(String expression) {
        var splittedInput = expression.split(";");
        String operation = splittedInput[0];
        String type = splittedInput[1];
        String data = splittedInput[2];
        if(operation.equals("S")){
            System.out.println(split(type, data));
        }
        if(operation.equals("C")){
            System.out.println(combine(type, data));
        }
    }

    private static String combine(String type, String data) {
        StringBuilder result = new StringBuilder();
        var words = data.split(" ");
        switch (type){
            case "M" -> {
                result.append(words[0]);
                for(int i = 1; i< words.length; i++){
                    result.append(Character.toUpperCase(words[i].charAt(0)));
                    result.append(words[i].substring(1));
                }
                result.append("()");
            }
            case "C" -> {
                for(int i = 0; i< words.length; i++){
                    result.append(Character.toUpperCase(words[i].charAt(0)));
                    result.append(words[i].substring(1));
                }
            }
            case "V" -> {
                result.append(words[0]);
                for(int i = 1; i< words.length; i++){
                    result.append(Character.toUpperCase(words[i].charAt(0)));
                    result.append(words[i].substring(1));
                }
            }
        }

        return result.toString();
    }

    private static String split(String type, String data) {
        StringBuilder result = new StringBuilder();
        switch (type){
            case "M" -> {

                    for (int j = 0; j < data.length(); j++) {
                        if(Character.isUpperCase(data.charAt(j))){
                            result.append(" ");
                            result.append(Character.toLowerCase(data.charAt(j)));
                        } else {
                            if(data.charAt(j) == '(' || data.charAt(j) == ')'){
                                continue;
                            }
                            result.append(data.charAt(j));
                        }

                    }

            }
            case "C" -> {
                result.append(Character.toLowerCase(data.charAt(0)));
                for (int i = 1; i < data.length(); i++) {
                    if(Character.isUpperCase(data.charAt(i))){
                        result.append(" ");
                        result.append(Character.toLowerCase(data.charAt(i)));
                    } else {
                        result.append(data.charAt(i));
                    }
                }
            }
            case "V" -> {
                result.append(data.charAt(0));
                for (int i = 1; i < data.length(); i++) {
                    if(Character.isUpperCase(data.charAt(i))){
                        result.append(" ");
                        result.append(Character.toLowerCase(data.charAt(i)));
                    } else {
                        result.append(data.charAt(i));
                    }
                }
            }
        }
        return result.toString();
    }
}