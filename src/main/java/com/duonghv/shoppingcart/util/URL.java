package com.duonghv.shoppingcart.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 * Class: URL
 * Author: DuongHV
 * Created: 31/03/2019 17:01
 */

public class URL {
    public static String covertStringToURL(String str) {
        try {
            String temp = Normalizer.normalize(str, Normalizer.Form.NFD)
                    .replaceAll("[^\\p{L}\\s]", "")
                    .trim().replaceAll(" +", " ");

            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("").toLowerCase().replaceAll(" ", "-").replaceAll("đ", "d");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
