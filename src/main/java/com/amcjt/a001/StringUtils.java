package com.amcjt.a001;

public class StringUtils implements Origin {
    public String str = "my name is geely";

    public void target(String[] arr) {
        String join = String.join(",", arr);
        System.out.println(join);
    }
}
