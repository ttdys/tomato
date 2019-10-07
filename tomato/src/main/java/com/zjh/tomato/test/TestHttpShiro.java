package com.zjh.tomato.test;


import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class TestHttpShiro {

    public static void main(String[] args) throws NoSuchMethodException {
        TT tt = new TT();
        tt.norm("abc");
        Class<TT> aClass = (Class<TT>) tt.getClass();
        //DeclaredMethods()获取本类的所有方法包括私有
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method.getName() = " + method.getName());
        }
        Method method = methods[1];

        System.out.println("method.getParameterCount() = " + method.getParameterCount());
        Class<?>[] classes = method.getParameterTypes();
        System.out.println("method = " + method.getName());
        Method method1 = aClass.getMethod(method.getName(), classes);
        System.out.println("method1 = " + method1);
    }


}
