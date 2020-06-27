package com.bridgelabz.models;

import com.opencsv.bean.CsvBindByName;

public class CSVUSER {
        @CsvBindByName
        private String name;

        @CsvBindByName(column = "email", required = false )
        private String email;

        @CsvBindByName(column = "phone")
        private String phoneNo;
        @CsvBindByName
        private String country;
        @Override
        public String toString(){
            return "CSVUser{" +
                    "name='" + name + '\'' +
                    ", email='" + email + '\'' +
                    ", phoneNo='" + phoneNo + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
}

