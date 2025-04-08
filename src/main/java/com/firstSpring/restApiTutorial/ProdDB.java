package com.firstSpring.restApiTutorial;

public class ProdDB implements DB {

    @Override
    public String getData() {
        return "Prod DB";
    }
    
}
