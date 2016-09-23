package by.liudchyk.triangle.entity;

import by.liudchyk.triangle.action.PointAction;

/**
 * Created by Admin on 21.09.2016.
 */
public class Triangle {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }
}
