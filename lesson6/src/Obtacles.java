public abstract class Obtacles {

    private int distance;
    protected String obtacleName;

    public Obtacles (int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getObtacleName() {
        return obtacleName;
    }
}
