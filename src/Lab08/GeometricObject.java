package Lab08;

import java.util.Date;

public abstract class GeometricObject{
    private boolean isFilled;
    private String color;
    private Date dateCreated;

    public GeometricObject() {
        this(false, "Black");
    }

    public GeometricObject(boolean isFilled, String color) {
        this.setFilled(isFilled);
        this.setColor(color);
        this.dateCreated = new Date();
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

    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return "GeometricObject{" +
                "isFilled=" + isFilled +
                ", color='" + color + '\'' +
                '}';
    }
}
