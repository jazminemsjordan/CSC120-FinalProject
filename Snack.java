public class Snack extends Thing {

    private int snackValue;
    private HidingSpot stashedAt;

    /**
     * Constructor for snack
     * @param name string name of the snack
     * @param desc string descrption of the snack, provides hints to snack value
     * @param unlocked boolean, whether or not the snack can be accessed
     * @param foundAt Place, where the snack can be found
     * @param snackValue integer point value of snack 
     */
    public Snack(String name, String desc, boolean unlocked, Place foundAt, int snackValue) {
        super(name, desc, foundAt, unlocked);
        this.snackValue = snackValue;
    }

    /**
     * Accessor for snackValue attribute
     * @return base point value of snack
     */
    public int getSnackValue() {
        return this.snackValue;
    }

    /**
     * Accessor for stashedAt attribute
     * @return the hiding spot the snack is hidden at
     * @throws RuntimeException if the snack isn't hidden
     */
    public HidingSpot getStashedAt() {
        if (Player.hiddenSnacks.containsKey(this)) {
            this.stashedAt = Player.hiddenSnacks.get(this);
            return this.stashedAt;
        } else {
            throw new RuntimeException("This snack isn't hidden anywhere!");
        }
    }
}
