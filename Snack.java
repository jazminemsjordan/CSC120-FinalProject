public class Snack extends Thing {

    private int snackValue;
    private HidingSpot stashedAt;

    public Snack(String name, String desc, boolean unlocked, Place foundAt, int snackValue) {
        super(name, desc, foundAt, unlocked);
        if (Player.hiddenSnacks.contains(this)) {
            this.stashedAt = Player.hiddenSnacks.get(this);
        }
    }

    public int getSnackValue() {
        return this.snackValue;
    }

    public HidingSpot getStashedAt() {
        return this.stashedAt;
    }

}
