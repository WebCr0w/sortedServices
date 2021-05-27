package com.sysgears.sortedservice;

import com.google.gson.Gson;
import com.sysgears.sortedservice.dto.RequestJson;
import com.sysgears.sortedservice.services.SortedService;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        Gson g = new Gson();
        RequestJson requestJson = g.fromJson(new FileReader("./src/main/resources/index.json"), RequestJson.class);

        SortedService sortedService = new SortedService();

        System.out.println(sortedService.sorted(requestJson.getData(), requestJson.getCondition()));



    }
}