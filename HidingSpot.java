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

    public double getValue() {
        return this.value;
    }

    public Place getPlace() {
        return this.place;
    }
}
