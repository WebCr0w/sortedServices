package com.sysgears.sortedservice.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class Condition {
    private ArrayList<String> sortBy;
    private List<Map<String, String>> exclude;
    private List<Map<String, String>> include;
}
