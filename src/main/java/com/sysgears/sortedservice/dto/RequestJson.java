package com.sysgears.sortedservice.dto;

import java.util.List;

import com.sysgears.sortedservice.dto.Condition;
import lombok.Data;
import java.util.Map;
@Data
public class RequestJson {
    private List<Map<String, String>> data;
    private Condition condition;
}
