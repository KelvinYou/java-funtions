package com.mycompany.java.functions;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class ConverterSHV {
    public static String generateSHV(String sht, String data) {
        return null;
    }

    public static void separateResult(String result) {
        // Perform the required logic for separating the result
        System.out.println("Separated result: " + result);

        // Split the result string by '&' to separate key-value pairs
        String[] pairs = result.split("&");

        // Create a map to store the separated values
        Map<String, String> resultMap = new HashMap<>();

        // Iterate over the key-value pairs and add them to the map
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1];
                try {
                    // URL decode the value
                    value = URLDecoder.decode(value, "UTF-8");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                resultMap.put(key, value);
            }
        }

        // Print the separated result
        System.out.println("Separated result: " + resultMap.toString());
    }

    public static void mergeResult(Map<String, String> input) {
        System.out.println("Input: " + input.toString());
        StringBuilder dataSig = new StringBuilder();
        for (Map.Entry<String, String> entry : input.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            try {
                // URL encode the value
                value = URLEncoder.encode(value, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
            dataSig.append(key).append('=').append(value).append('&');
        }
        String shv = dataSig.toString();
        System.out.println("SHV: " + shv);
        separateResult(shv);
    }

    public static void main(String[] args) {
        Map<String, String> items = new HashMap<>();
        items.put("name", "Alice&123");
        items.put("age", "18");
        mergeResult(items);
    }
}

