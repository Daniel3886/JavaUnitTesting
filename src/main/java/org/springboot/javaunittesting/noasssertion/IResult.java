package org.springboot.javaunittesting;

import java.util.Iterator;

public interface IResult {
    Iterator iterator();

    String getMessage();

    int size();
}