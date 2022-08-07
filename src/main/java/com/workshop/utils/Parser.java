package com.workshop.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static int parseInteger(String inputWithnumbers){
        String regex = "^\\d*";

        //pattern rabotaet s regex
        Pattern pattern = Pattern.compile(regex);
        //matcher provereaet sootvetstvie zadannim cislam:
        Matcher matcher = pattern.matcher(inputWithnumbers);

        if (matcher.find()){
            return Integer.parseInt(matcher.group(0));
        }

        return 0;
    }

}
