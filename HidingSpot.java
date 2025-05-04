public class HidingSpot {
    
    private String name;
    private String desc;
    private Place place;
    private double value;

    public HidingSpot(String name, String desc, Place place, double value) {
        this.name = name;
        this.desc = desc;
        this.place = place;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public Place getPlace() {
        return this.place;
    }

    public double getValue() {
        return this.value;
    }

}
