package com.tt52.demolib2_export.bean;

/**
 * Created by liaohailiang on 2019-08-30.
 */
public class HelloWorldEvent {
    public String name;
    public TestEventBean eventBean;

    public HelloWorldEvent(String name, TestEventBean eventBean) {
        this.name = name;
        this.eventBean = eventBean;
    }
}
