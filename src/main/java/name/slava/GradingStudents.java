package name.slava;

import java.util.ArrayList;
import java.util.List;

public class GradingStudents {
    public static void main(String[] args) {
        List<Integer> result = gradingStudents(List.of(4, 73, 67, 38, 33));
        System.out.println(result);
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> resultList = new ArrayList<>();
        var len = grades.get(0);
        resultList.add(len);
        for(int i = 1; i <= len; i++ ){
            if(grades.get(i) < 38){
                resultList.add(grades.get(i));
                continue;
            }
            var nextMultiple5 = getNextMultiple5(grades.get(i));
            if((nextMultiple5 - grades.get(i)) < 3){
                resultList.add(nextMultiple5);
            } else {
                resultList.add(grades.get(i));
            }

        }
        return resultList;
    }

    private static int getNextMultiple5(int grade){
        var rest = grade % 5;
        return grade + (5 - rest);
    }
}
