package com.duonghv.shoppingcart.util;

/**
 * Class: ConvertName
 * Author: DuongHV
 * Created: 31/03/2019 17:01
 */

public class ConvertName {
    public static void main(String[] sgr) {
        String str = "    Nguyễn     van     quan   7826    ";
        ConvertName chx = new ConvertName();
        str = chx.chuanHoaDanhTuRieng(str).replaceAll("[^\\p{ASCII}]", "");
        System.out.println(str);
    }

    public String chuanHoa(String str) {
        str = str.trim();
        str = str.replaceAll("\\s+", " ");
        return str;
    }

    public String chuanHoaDanhTuRieng(String str) {
        str = chuanHoa(str);
        String temp[] = str.split(" ");
        str = ""; // ? ^-^
        for (int i = 0; i < temp.length; i++) {
            str += String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
            if (i < temp.length - 1) // ? ^-^
                str += " ";
        }
        return str;
    }
}
