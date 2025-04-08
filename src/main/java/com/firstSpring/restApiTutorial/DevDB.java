package com.firstSpring.restApiTutorial;

public class DevDB implements DB {

    @Override
    public String getData() {
        return "Dev DB";
    }

}
