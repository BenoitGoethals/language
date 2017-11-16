package be.dragon.language.model;

public enum Category {

    functionWord(1),
    verb(2),
    none(3),
    adjectief(4),
    subsantief(5),
    expression(6);

    private int nr;

    Category(int nr) {

        this.nr=nr;
    }


    @Override
    public String toString() {
        return "Category{" +
                "nr=" + nr +
                '}';
    }
}
