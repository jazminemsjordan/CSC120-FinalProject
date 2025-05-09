public class HidingSpot {
    
    private String name;
    private String desc;
    private Place place;
    private double value;

    /** 
     * Constructor for hiding spot
     * @param name string name of the hiding spot
     * @param desc description of the hiding spot
     * @param place the place the hiding spot is associated with
     * @param value the decimal value of the hiding spot: higher values mean higher ending scores
     */
    public HidingSpot(String name, String desc, Place place, double value) {
        this.name = name;
        this.desc = desc;
        this.place = place;
        this.value = value;
    }

    /**
     * Accessor for name attribute
     * @return the string name of the hiding spot
     */
    public String getName() {
        return this.name;
    }

    /**
     * Accessor for desc attribute
     * @return the string description of the hiding spot
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Accessor for place attribute
     * @return the Place the hiding spot is located at
     */
    public Place getPlace() {
        return this.place;
    }

    /**
     * Accessor for value attribute
     * @return the double value of the hiding spot
     */
    public double getValue() {
        return this.value;
    }

}
