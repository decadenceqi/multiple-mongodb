package com.ykun.multiple.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

/**
 * @author Ykun 于 2017-06-16 16:34
 */
public class HelloWorld {

    @Id
    private String id;

    private Date date;

    private String name;

    private long counter;

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public HelloWorld() {
        this.name = UUID.randomUUID().toString();
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
