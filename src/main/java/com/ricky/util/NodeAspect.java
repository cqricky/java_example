package com.ricky.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by caiqing on 16/10/20.
 */
@Aspect
@Component
@Slf4j
public class NodeAspect {

    @Before("execution(* com.ricky.services.*.get*(*))")
    public void getNodeAdvice() {
        System.out.println("");
        System.out.println("before get node advice!");
        System.out.println("");
    }


    @Before("execution(public com.ricky.model.Node getNode(*))")
    public void getAllAdvice(JoinPoint jp) {
        System.out.println("");
        System.out.println("before run " + jp.toString());
        System.out.println("before get all advice!");
        System.out.println("before run args " + jp.getArgs());
        System.out.println("");
    }

    @Pointcut("execution(* com.ricky.services.*.add*())")
    public void addPointCut(){
    }

    @After("addPointCut()")
    public void addNodeAdvice() {
        System.out.println("");
        System.out.println("add node!!");
        System.out.println("");
    }

//    @Before("@annotation(ua)")
//    public void updateAdvice(JoinPoint jp, UpdateAnnotation ua) {
//        System.out.println("before annotation!! " + jp.getArgs());
//        System.out.println("before annotation ua key: " + ua.key() + " name: " + ua.getName());
//    }

    @Around("@annotation(ua)")
    public void updateAroundAdvice(ProceedingJoinPoint jp, UpdateAnnotation ua) throws Throwable{
        System.out.println("around before annotation!! " + jp.getArgs());
        System.out.println("around annotation ua key: " + ua.key() + " name: " + ua.getName());

        jp.proceed();

        System.out.println("around after annotation!!");
    }

    @Before("execution(* com.ricky.services.*.get*(*)) && args(id)")
    public void logIntegerArguments(Integer id) {
        System.out.println("processing Integer id:  " + id);
    }

}
