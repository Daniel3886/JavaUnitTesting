package org.springboot.javaunittesting.noasssertion;

import java.util.Iterator;

public interface IResult {
    Iterator iterator();

    String getMessage();

    int size();
}