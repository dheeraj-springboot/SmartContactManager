package com.Smartmanager26.SCM2.o.services.impl;

public class ResosourceNotFound extends RuntimeException  {
    public ResosourceNotFound(String message){
        super(message);
    }
    public ResosourceNotFound(){
        super("Resources are not here");
    }

}
