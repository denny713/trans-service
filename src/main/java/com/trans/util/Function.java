package com.trans.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Function {

    public static String generateTransId(String transId) {
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        date = date.replace("-", "");
        String code = "";
        if (transId.equals("-")) {
            code = "TRS" + date + "0001";
        } else {
            int num = Integer.parseInt(transId.replace(transId.substring(0, 11), ""));
            num++;
            String no = "0000" + num;
            code = "TRS" + date + no.substring(no.length() - 4);
        }
        return code;
    }
}
