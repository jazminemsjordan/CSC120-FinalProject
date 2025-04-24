abstract class Thing {

    protected String name;
    protected String desc;
    protected Place foundAt;
    protected boolean unlocked;

    public Thing(String name, String desc, Place foundAt, boolean unlocked) {
        this.name = name;
        this.desc = desc;
        this.foundAt = foundAt;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public Place getFoundAt() {
        return this.foundAt;
    }

    public boolean isUnlocked() {
        return this.unlocked;
    }

    public void unlock() {
        this.unlocked = true;
    }
}
