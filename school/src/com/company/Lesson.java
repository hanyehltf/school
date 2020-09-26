package com.company;

import java.io.Serializable;

public class Lesson implements Serializable {
    String Name,Code;
    @Override
    public String toString() {
        return "Name= "+Name+" Code= "+Code;
    }
}
