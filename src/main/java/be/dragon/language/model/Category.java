package be.dragon.language.model;

public enum Category {

    sentende(1),
    verb(2);

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
