package by.liudchyk.triangle.action;

import by.liudchyk.triangle.entity.Point;
import by.liudchyk.triangle.entity.Triangle;

/**
 * Created by Admin on 21.09.2016.
 */
public class TriangleAction {
    public double perimeter(Triangle triangle){
        PointAction pa = new PointAction();
        Point p1 = triangle.getFirstPoint();
        Point p2 = triangle.getSecondPoint();
        Point p3 = triangle.getThirdPoint();
        return pa.pointDistance(p1,p2)+pa.pointDistance(p2,p3)+pa.pointDistance(p3,p1);
    }
    public double square(Triangle triangle){
        PointAction pa = new PointAction();
        double semiPerim = perimeter(triangle)/2.0;
        double a = pa.pointDistance(triangle.getFirstPoint(),triangle.getSecondPoint());
        double b = pa.pointDistance(triangle.getFirstPoint(),triangle.getThirdPoint());
        double c = pa.pointDistance(triangle.getSecondPoint(),triangle.getThirdPoint());
        if(pa.isTriangle(triangle.getFirstPoint(),triangle.getSecondPoint(),triangle.getThirdPoint())) {
            return Math.sqrt(semiPerim * (semiPerim - a) * (semiPerim - b) * (semiPerim - c));
        }else{
            return 0;
        }
    }
    public boolean isRightTriangle(Triangle triangle){
        PointAction pa = new PointAction();
        Point a = pa.vectorCoordinates(triangle.getFirstPoint(),triangle.getSecondPoint());
        Point b = pa.vectorCoordinates(triangle.getFirstPoint(),triangle.getThirdPoint());
        Point c = pa.vectorCoordinates(triangle.getThirdPoint(),triangle.getSecondPoint());
        if(pa.scalarMultiplication(a,b)==0 || pa.scalarMultiplication(a,c)==0 || pa.scalarMultiplication(b,c)==0){
            return true;
        }else{
            return false;
        }
    }
}
