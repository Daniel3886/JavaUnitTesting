package org.springboot.javaunittesting.expectingExceptionsEverywhere;

public class MaliciousMyList<T> {

    // this constructor is malicious because it throws an exception when called,
    // which makes testing impossible since because the constructor always throws IndexOutOfBoundsException
    public MaliciousMyList() {
        throw new IndexOutOfBoundsException();
    }

    public void add(T i) {
    }

    public T get(T i) {
        return null;
    }
}
