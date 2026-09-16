package org.springboot.javaunittesting.noAsssertion;

import java.util.Iterator;

public interface IResult {
    Iterator iterator();

    String getMessage();

    int size();
}