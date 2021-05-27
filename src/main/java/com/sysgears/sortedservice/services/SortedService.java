package com.sysgears.sortedservice.services;

import com.sysgears.sortedservice.dto.Condition;


import java.util.*;

public class SortedService {


    public Object sorted(List<Map<String, String>> data, Condition condition) {


        List<Map<String, String>> result = data;

        if (condition.getInclude() != null){
            result = include(result, condition.getInclude());
        }
        if (condition.getExclude() != null){
            result = exclude(result, condition.getExclude());
        }
        if (condition.getSortBy() != null){
            result = sortBy(result, condition.getSortBy());
        }

        return result;
    }
    private List<Map<String, String>> exclude(List<Map<String, String>> data, List<Map<String, String>> conditionExclude) {

        List<Map<String, String>> resultExclude = new ArrayList<>();

        List<String> keyExclude = new ArrayList<>();
        List<String> valueExclude = new ArrayList<>();


        Map<String, String> conditionExcludeAllMaps;
        for (int i = 0; i < conditionExclude.size(); i++){
            conditionExcludeAllMaps = conditionExclude.get(i);
            valueExclude.addAll(conditionExcludeAllMaps.values());
            keyExclude.addAll(conditionExcludeAllMaps.keySet());

        }

        for (Map<String, String> data1 : data) {
            for (int i = 0; i < keyExclude.size(); i++){
                if (data1.get(keyExclude.get(i)) != null && !data1.get(keyExclude.get(i)).equals(valueExclude.get(i))){
                    resultExclude.add(data1);
                }
            }

        }


        return resultExclude;
    }
    private List<Map<String, String>> include(List<Map<String, String>> data, List<Map<String, String>> conditionInclude) {

        List<Map<String, String>> resultInclude = new ArrayList<>();
        List<String> keyInclude = new ArrayList<>();
        List<String> valueInclude = new ArrayList<>();

        Map<String, String> conditionIncludeAllMaps;
        for (int i = 0; i < conditionInclude.size(); i++){
            conditionIncludeAllMaps = conditionInclude.get(i);
            valueInclude.addAll(conditionIncludeAllMaps.values());
            keyInclude.addAll(conditionIncludeAllMaps.keySet());

        }

        for (Map<String, String> data1 : data) {
            for (int i = 0; i < keyInclude.size(); i++){
                if (data1.get(keyInclude.get(i)) != null && data1.get(keyInclude.get(i)).equals(valueInclude.get(i))){
                    resultInclude.add(data1);
                }
            }

        }


        return resultInclude;
    }

    public List<Map<String, String>> sortBy(List<Map<String, String>> data, ArrayList<String> sortBy){

        List<Map<String, String>> resultSortBy = data;

        Comparator<Map<String, String>> mapComparator = new Comparator<Map<String, String>>() {
            public int compare(Map<String, String> m1, Map<String, String> m2) {
                return m1.get(sortBy.get(0)).compareTo(m2.get(sortBy.get(0)));
            }
        };
        resultSortBy.sort(mapComparator);

        return resultSortBy;
    }

}
