public class Item extends Thing {

    private Place useAt;

    /**
     * Constructor for item
     * @param name String name of item
     * @param desc String description of item, hints at use case
     * @param foundAt Place where item can be found
     * @param unlocked Whether the item can be obtained
     * @param useAt Place where the item can be used
     */
    public Item(String name, String desc, Place foundAt, boolean unlocked, Place useAt) {
        super(name, desc, foundAt, unlocked);
        this.useAt = useAt;
    }

    /**
     * Accessor for useAt attribute
     * @return Place where item can be used
     */
    public Place getUseAt() {
        return this.useAt;
    }

    /**
     * Manipulator for unlocked attribute (only locks the item, cannot unlock)
     */
    public void lock() {
        this.unlocked = false;
    }

}
