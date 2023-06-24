package base;

import java.util.HashMap;

public class Checklist {

    private static HashMap<String, String> resultMap = new HashMap<>();
    private static String PASS = "Pass";
    private static String FAIL = "Fail";

    public static void mark(String testName, boolean result){
        if (result){
            resultMap.put(testName, PASS);
        } else {
            resultMap.put(testName, FAIL);
        }
    }
    public static void markFinal(String testName, boolean result){
        if (result){
            resultMap.put(testName, PASS);
        } else {
            resultMap.put(testName, FAIL);
        }

        if (resultMap.containsValue(FAIL)){
            System.out.println(resultMap);
        }
    }

}
