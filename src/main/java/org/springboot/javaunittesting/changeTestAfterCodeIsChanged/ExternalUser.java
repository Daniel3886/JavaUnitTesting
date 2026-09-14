package org.springboot.javaunittesting.changeTestAfterCodeIsChanged;


public class ExternalUser extends User {

    @Override
    public boolean isExternal() {
        return true;
    }
}

