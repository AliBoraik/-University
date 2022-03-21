package ru.itis;

import ru.itis.annotations.Inject;
import ru.itis.models.ComparisonDB;

public class Main {

    @Inject
    private static ComparisonDB comparisonDb;

    public static void main(String[] args) {
        new Context(Main.class);

        comparisonDb.startComparing();

    }
}
