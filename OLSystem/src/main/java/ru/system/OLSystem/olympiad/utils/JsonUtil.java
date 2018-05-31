package ru.system.OLSystem.olympiad.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.system.OLSystem.data.entity.TestData;

import java.util.List;

/**
 *
 */
public class JsonUtil {

    /**
     *
     * @param nameProgram
     * @param textProgram
     * @param testData
     * @return
     */
    public static String generateJsonStructure(String nameProgram, String textProgram, List<TestData> testData) {
        JSONArray jsonTestData = new JSONArray();
        for (TestData data : testData) {
            jsonTestData.put(new JSONObject()
                    .put("inputData", data.getInput())
                    .put("outputData", data.getOutput()));
        }
        JSONObject jsonResult= new JSONObject()
                .put("testData", jsonTestData)
                .put("textProgram", textProgram)
                .put("nameProgram", nameProgram);
        return jsonResult.toString();
    }

    /**
     *
     * @param jsonText
     * @return
     */
    public static int getResultCheckingFromJson(String jsonText) {
        JSONObject jsonStructure = new JSONObject(jsonText);
        return Integer.valueOf(jsonStructure.getString("resultChecking"));
    }

}
