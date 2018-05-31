package ru.system.OLSystem.UtilsUnit;

import org.junit.Assert;
import org.junit.Test;
import ru.system.OLSystem.data.entity.TestData;
import ru.system.OLSystem.olympiad.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class JsonUtilTest {

    @Test
    public void generationJsonForSendOnChecking()  {
        List<TestData> testData = new ArrayList<>();
        testData.add(new TestData("input", "output", null));
        String resGeneration = JsonUtil.generateJsonStructure("name", "text", testData);
        String correctGeneration = "{\"testData\":[{\"outputData\":\"output\",\"inputData\":\"input\"}],\"nameProgram\":\"name\",\"textProgram\":\"text\"}";
        Assert.assertEquals(correctGeneration, resGeneration);
    }

    @Test
    public void parsingAnswerFromProgramChecker() {
        String jsonTextAnswer = "{\"resultChecking\" : \"100\"}";
        Assert.assertEquals(100, JsonUtil.getResultCheckingFromJson(jsonTextAnswer));
    }

}
