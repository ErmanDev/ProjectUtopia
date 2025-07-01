package com.example.projectutopia.data;

import com.example.projectutopia.model.CategoryItem;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfoRepository {

    public static List<CategoryItem> getInfoByCategory(String category) {
        Map<String, List<CategoryItem>> dataMap = new HashMap<>();

        dataMap.put("HOSPITAL", Arrays.asList(
                new CategoryItem("Adventist Medical Center - Valencia City (AMCV)",
                        "SAYRE HIGHWAY VALENCIA CITY, BUKIDNON",
                        "09672234645", "Open Daily"),
                new CategoryItem("Abella Midway Hospital",
                        "SAYRE HIGHWAY VALENCIA CITY, BUKIDNON",
                        "0912345678", "Mon–Fri 8:00 AM - 5:00 PM")
        ));

        // Add other categories similarly...

        return dataMap.getOrDefault(category, Collections.emptyList());
    }
}
