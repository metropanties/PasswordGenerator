package me.metropanties.password;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class PasswordGenerator implements PasswordOperations {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String SYMBOLS = "~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/";
    private static final String NUMBERS = "0123456789";

    private static final String COMBINATION = UPPERCASE + LOWERCASE + NUMBERS;
    private static final String COMBINATION_SYMBOLS = UPPERCASE + LOWERCASE + NUMBERS + SYMBOLS;

    private final int size;
    private final boolean useSymbols;

    public PasswordGenerator(int size, boolean useSymbols) {
        this.size = size;
        this.useSymbols = useSymbols;
    }

    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder(size);
        Random random = new Random();

        while (sb.length() < size) {
            if (useSymbols) {
                sb.append(COMBINATION_SYMBOLS.charAt(random.nextInt(COMBINATION_SYMBOLS.length())));
            }
            sb.append(COMBINATION.charAt(random.nextInt(COMBINATION.length())));
        }

        return sb.toString().trim();
    }

    @Override
    public void save(String password) throws IOException {
        Objects.requireNonNull(password, "Password cannot be null!");
        File file = new File("./password.txt");
        if (!file.exists())
            file.createNewFile();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(password);
            writer.flush();
        }
    }

}
