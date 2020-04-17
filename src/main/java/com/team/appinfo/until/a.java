package com.team.appinfo.until;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

public class a {
    public static void main(String[] args) {
        String str="哈哈哈哈";
        Cookie cookie=new Cookie("info",str);
        cookie.setMaxAge(20);


    }
}
