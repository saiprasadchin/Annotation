package com.bridgelabz.services;

import com.bridgelabz.models.CSVUSER;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class OpenCSVAndGsonTester {
    private static final String SAMPLE_CSV_FILE_PATH = "./user.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "./juser.json";
    public static void main(String[] args) {
        try{
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBeanBuilder<CSVUSER> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVUSER.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVUSER> csvToBean = csvToBeanBuilder.build();
            List<CSVUSER> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            CSVUSER[] usrObj = gson.fromJson(br, CSVUSER[].class);
            List<CSVUSER> csvUser = Arrays.asList(usrObj);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
