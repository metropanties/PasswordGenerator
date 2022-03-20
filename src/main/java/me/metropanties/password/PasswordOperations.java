package me.metropanties.password;

import java.io.IOException;

public interface PasswordOperations {

    String generate();

    void save(String password) throws IOException;

}
