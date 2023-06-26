package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;

public class Checklist {

    private static HashMap<String, String> resultMap = new HashMap<>();
    private static String PASS = "Pass";
    private static String FAIL = "Fail";

    private static Logger log = LogManager.getLogger(Checklist.class.getName());

    private static void setStatus(String testName, String status) {
        resultMap.put(testName, status);
        if (status.equals(FAIL)){
            log.error(testName + "=>" + status);
        }else {
            log.info(testName + "=>" + status);
        }
    }


    public static void mark(String testName, boolean result) {
        try {
            if (result) {
                setStatus(testName, PASS);
            } else {
                setStatus(testName, FAIL);
            }
        } catch (Exception e) {
            log.error("Exception occured: Mark");
        }

    }

    public static void markFinal(String testName, boolean result) {
        mark(testName, result);
        ArrayList<String> resultList = new ArrayList<>();
        for (String key : resultMap.keySet()) {
            if (resultMap.get(key).equals(FAIL)) {
                log.error("Test Method Failed");
                Assert.assertTrue(false);
            } else {
                log.info("Test Method Successful");
                Assert.assertTrue(true);
            }
        }
    }

}
