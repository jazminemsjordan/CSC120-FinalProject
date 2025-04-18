public class Item extends Thing {

    private Place useAt;

    public Item(String name, String desc, Place foundAt, Place useAt) {
        super(name, desc, foundAt);
        this.useAt = useAt;
    }

    public Place getUseCase() {
        return this.useAt;
    }

    public void use() {
        if (this.name == "placeholder") {
            // use case
            System.out.println("Successful use message");
        } else if (this.name == "another placeholder") {

        }
    }

}
