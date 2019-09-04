package vehicles;

import java.util.List;

public class Wheel {
    private String brand;
    private double diameter;

    public Wheel(String brand, double diameter) {
        this.brand = brand;
        this.diameter = diameter;
    }

    public String getBrand()
    {
        return this.brand;
    }

    public Double getDiameter()
    {
        return this.diameter;
    }

}
