package data;

public enum Comands {
    ADD,
    UPDATE,
    LIST,
    EXIT;

    public static Comands fromString(String command) {

        try {
            return Comands.valueOf(command.trim().toUpperCase());
        }
        catch (IllegalArgumentException e) {
            return null;
        }

    }
}