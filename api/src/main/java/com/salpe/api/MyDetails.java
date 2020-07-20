package com.salpe.api;

import javax.xml.bind.annotation.XmlRootElement;

public class MyDetails {
    String name;
    public MyDetails(){};

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
