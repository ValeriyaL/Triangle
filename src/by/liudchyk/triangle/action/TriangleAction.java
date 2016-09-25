package by.liudchyk.triangle.action;

import by.liudchyk.triangle.entity.Point;
import by.liudchyk.triangle.entity.Triangle;
import by.liudchyk.triangle.exception.TriangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Admin on 21.09.2016.
 */
public class TriangleAction {
    static final Logger LOG = LogManager.getLogger();
    public double perimeter(Triangle triangle){
        Point pointA = triangle.getPointA();
        Point pointB = triangle.getPointB();
        Point pointC = triangle.getPointC();
        double sideAB = Math.hypot(pointB.getX()-pointA.getX(),pointB.getY()-pointA.getY());
        double sideBC = Math.hypot(pointB.getX()-pointC.getX(),pointB.getY()-pointC.getY());
        double sideAC = Math.hypot(pointC.getX()-pointA.getX(),pointC.getY()-pointA.getY());
        if(isTriangle(triangle.getPointA(),triangle.getPointB(),triangle.getPointC())) {
            return sideAB+sideBC+sideAC;
        }else{
            LOG.info("Degenerate triangle");
            return 0;
        }
    }

    public double square(Triangle triangle){
        double semiPerimeter = perimeter(triangle)/2.0;
        double sideAB = Math.hypot(triangle.getPointB().getX()-triangle.getPointA().getX(),
                              triangle.getPointB().getY()-triangle.getPointA().getY());
        double sideBC = Math.hypot(triangle.getPointB().getX()-triangle.getPointC().getX(),
                              triangle.getPointB().getY()-triangle.getPointC().getY());
        double sideAC = Math.hypot(triangle.getPointC().getX()-triangle.getPointA().getX(),
                              triangle.getPointC().getY()-triangle.getPointA().getY());
        if(isTriangle(triangle.getPointA(),triangle.getPointB(),triangle.getPointC())) {
            return Math.sqrt(semiPerimeter * (semiPerimeter - sideAB) * (semiPerimeter - sideBC) * (semiPerimeter - sideAC));
        }else{
            LOG.info("Degenerate triangle");
            return 0;
        }
    }

    public boolean isTriangle(Point p1, Point p2, Point p3){
        double a = Math.hypot(p2.getX()-p1.getX(),p2.getY()-p1.getY());
        double b = Math.hypot(p2.getX()-p3.getX(),p2.getY()-p3.getY());
        double c = Math.hypot(p3.getX()-p1.getX(),p3.getY()-p1.getY());
        if((a < b + c) && (b < a + c) && (c < a + b)){
            return true;
        }else{
            return false;
        }
    }

    public boolean isRightTriangle(Triangle triangle) throws TriangleException{
        if(!isTriangle(triangle.getPointA(),triangle.getPointB(),triangle.getPointC())){
            throw new TriangleException();
        }
        Point a = vectorCoordinates(triangle.getPointA(),triangle.getPointB());
        Point b = vectorCoordinates(triangle.getPointA(),triangle.getPointC());
        Point c = vectorCoordinates(triangle.getPointC(),triangle.getPointB());
        if(scalarMultiplication(a,b)==0 || scalarMultiplication(a,c)==0 || scalarMultiplication(b,c)==0){
            return true;
        }else{
            return false;
        }
    }

    private Point vectorCoordinates(Point p1, Point p2){
        return new Point(p2.getX() - p1.getX(),p2.getY() - p1.getY());
    }

    private double scalarMultiplication(Point p1, Point p2){
        return p1.getX()*p2.getX()+p1.getY()*p2.getY();
    }
}
