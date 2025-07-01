package hackerRank;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class CamelCase {
    @Test
    void runTest(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        var splittedInput = input.split(";");
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

    private String combine(String type, String data) {
        StringBuilder result = new StringBuilder();
        var words = data.split(" ");
        switch (type){
            case "M" -> {
                result.append(words[0]);
                for(int i = 1; i< words.length; i++){
                    result.append(Character.toUpperCase(words[i].charAt(0)));
                    result.append(words[i].substring(1));
                }
            }
            case "C" -> {}
            case "V" -> {}
        }

        return result.toString();
    }

    private String split(String type, String data) {
        switch (type){
            case "M" -> {}
            case "C" -> {}
            case "V" -> {}
        }
        return "";
    }



}
