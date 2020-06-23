package com.bridgelabz;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {

    @Override
    @MethodInfo(author = "Saiprasad", comments = "Main method", date = "June 23 2020" , revision = 1)
    public String toString(){
        return "Overridden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "Deprecated method", date = "June 24 2020")
    public static void oldMethod(){
        System.out.println("Old method, don't use it");
    }
    public static void main(String[] args) {
        try{
            for (Method method :  MethodInfo.class.getMethods()){
                if (method.isAnnotationPresent(MethodInfo.class)){
                    try{
                        for (Annotation anno : method.getDeclaredAnnotations()){
                            System.out.println("Annotation in method "+ method + " : "+ anno);
                        }
                        MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1){
                            System.out.println("Method with revision no 1 = "+ method);
                        }
                    } catch (Throwable ex){
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException e){
            e.printStackTrace();
        }
    }
}


