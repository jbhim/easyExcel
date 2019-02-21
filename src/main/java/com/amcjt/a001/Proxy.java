package com.amcjt.a001;

public class Proxy {

    public static void main(String[] args) {
        Origin o = (Origin) java.lang.reflect.Proxy.newProxyInstance(Proxy.class.getClassLoader(), new Class[]{Origin.class}, (proxy, method, args1) -> {
            System.out.println("代理前");
            for (int i = 0; i < args1.length; i++) {
                if (args1[i] instanceof String[]) {
                    String[] a = (String[]) args1[i];
                    for (String s : a) {
                        System.out.println(s);
                    }
                }
            }
            Object invoke = method.invoke(new StringUtils(), args1);
            System.out.println("代理前");
            return invoke;
        });
        String[] arr = {"ss", "bb", "cc"};
        o.target(arr);
    }
}
