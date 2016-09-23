package by.liudchyk.triangle.action;

import by.liudchyk.triangle.entity.Point;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by Admin on 21.09.2016.
 */
public class PointAction {
    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager. getLoggerRepository());
    }
    static final Logger LOG = Logger. getLogger(PointAction. class);
    private final double DELTA = 0.00001;
    public double pointDistance(Point p1, Point p2){
        return Math.sqrt(Math.pow((p2.getX()-p1.getX()),2)+Math.pow((p2.getY()-p1.getY()),2));
    }
    public Point vectorCoordinates(Point p1, Point p2){
        return new Point(p2.getX() - p1.getX(),p2.getY()-p1.getY());
    }
    public double scalarMultiplication(Point p1, Point p2){
        return p1.getX()*p2.getX()+p1.getY()*p2.getY();
    }
    public boolean isTriangle(Point p1, Point p2, Point p3){
        double a = pointDistance(p1,p2);
        double b = pointDistance(p2,p3);
        double c = pointDistance(p1,p3);
        if(a<b+c && b<a+c && c<a+b){
            return true;
        }else{
            LOG.info("Degenerate triangle");
            return false;
        }
    }
}
