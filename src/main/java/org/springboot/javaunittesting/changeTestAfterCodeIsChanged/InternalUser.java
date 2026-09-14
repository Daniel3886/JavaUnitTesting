package org.springboot.javaunittesting.changeTestAfterCodeIsChanged;

public class InternalUser extends User {

    @Override
    public boolean isExternal() {
        return false;
    }
}

