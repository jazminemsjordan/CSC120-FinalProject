abstract class Thing {

    protected String name;
    protected String desc;
    protected Place foundAt;

    public Thing(String name, String desc, Place foundAt) {
        this.name = name;
        this.desc = desc;
        this.foundAt = foundAt;
    }

    public static void initializeThings() {

    }
}
