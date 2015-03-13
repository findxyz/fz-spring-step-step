package com.bar;

/**
 * Created by Administrator on 2015-3-13.
 */
public class Apple {
    private String size;

    private String weight;

    private Shape shape;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void a(){
        Apple.this.getShape();
    }
}
