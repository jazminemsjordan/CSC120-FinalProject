abstract class Thing {

    protected String name;
    protected String desc;
    protected Place foundAt;
    protected boolean unlocked;

    /**
     * Constructor for thing
     * @param name String name of thing
     * @param desc String description of thing, should provide hints to use/value
     * @param foundAt Place where thing can be found
     * @param unlocked whether the thing can be taken or not
     */
    public Thing(String name, String desc, Place foundAt, boolean unlocked) {
        this.name = name;
        this.desc = desc;
        this.foundAt = foundAt;
        this.unlocked = unlocked;
    }

    /**
     * Accessor for name variable
     * @return String name of thing
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for desc variable
     * @return String description of thing
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Accessor for foundAt variable
     * @return the place the thing is originally found at
     */
    public Place getFoundAt() {
        return this.foundAt;
    }

    /**
     * Accessor for unlocked variable
     * @return boolean, whether the thing is unlocked and can be taken
     */
    public boolean getUnlocked() {
        return this.unlocked;
    }


    /** 
     * Method to unlock thing and allow it to be accessed
     */
    public void unlock() {
        this.unlocked = true;
    }
}
