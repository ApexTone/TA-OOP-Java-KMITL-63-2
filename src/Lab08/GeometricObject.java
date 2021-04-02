package Lab08;

import java.util.Date;

public abstract class GeometricObject implements Comparable<GeometricObject>{
    private boolean isFilled;
    private String color;
    private Date dateCreated;
    private String name;

    public GeometricObject() {
        this(false, "Black");
    }

    public GeometricObject(boolean isFilled, String color) {
        this.setFilled(isFilled);
        this.setColor(color);
        this.dateCreated = new Date();
        this.setName(name);
    }

    public boolean isFilled() {
        return isFilled;
    }
    public void setFilled(boolean filled) {
        isFilled = filled;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public int compareTo(GeometricObject o) {
        return Double.compare(this.getArea(), o.getArea());
    }

    @Override
    public String toString() {
        return "GeometricObject{" +
                "isFilled=" + isFilled +
                ", color='" + color + '\'' +
                ", dateCreated=" + dateCreated +
                ", name='" + name + '\'' +
                '}';
    }
}
