package by.liudchyk.triangle.runner;

import by.liudchyk.triangle.action.TriangleAction;
import by.liudchyk.triangle.creator.TriangleCreator;
import by.liudchyk.triangle.entity.Triangle;
import by.liudchyk.triangle.exception.TriangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by Admin on 28.09.2016.
 */
public class Main {
    static final Logger LOG = LogManager.getLogger();
    public static void main(String[] args) {
        TriangleCreator tc = new TriangleCreator();
        TriangleAction ta = new TriangleAction();
        List<Triangle> list = tc.createFromFile("data/triangle.txt");
        for (Triangle temp : list) {
            ta.isTriangle(temp.getPointA(),temp.getPointB(),temp.getPointC());
            try {
                ta.isRightTriangle(temp);
            } catch (TriangleException e) {
                LOG.info("Degenerate triangle");
            }
            ta.perimeter(temp);
            ta.square(temp);
        }
    }
}
