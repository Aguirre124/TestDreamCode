package us.zippopotam.api.models;

import java.util.HashMap;
import java.util.Map;

public class TestData {

    private static Map<String, Object> map = new HashMap<>();

    public static Map<String, Object> getData() {
        return map;
    }

    public static void setData(Map<String, Object> map) {
        TestData.map = map;
    }

    private TestData() {}
}

