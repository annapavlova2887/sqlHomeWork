package data;

public enum ListOfAnimals {
    CAT,
    DOG,
    DUCK;

    public static ListOfAnimals fromString (String animal) {
        try {
            return ListOfAnimals.valueOf(animal.trim().toUpperCase());
        }
        catch (IllegalArgumentException e) {
            return null;
        }
    }
}