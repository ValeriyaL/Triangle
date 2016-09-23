package test.by.liudchyk.triangle.action;

import by.liudchyk.triangle.action.TriangleAction;
import by.liudchyk.triangle.entity.Point;
import by.liudchyk.triangle.entity.Triangle;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Admin on 21.09.2016.
 */
public class TriangleActionTest {
    private final double DELTA = 0.00001;
    @Test
    public void checkPerimeter(){
        TriangleAction ta = new TriangleAction();
        Triangle triangle = new Triangle(new Point(1,1), new Point(1,3), new Point(3,1));
        double actual = ta.perimeter(triangle);
        Assert.assertEquals(6.828427,actual,DELTA);
        triangle = new Triangle(new Point(-5,0), new Point(7,9), new Point(5,-5));
        actual = ta.perimeter(triangle);
        Assert.assertEquals(40.32247,actual,DELTA);
        triangle = new Triangle(new Point(1,1), new Point(1,2), new Point(1,3));
        actual = ta.perimeter(triangle);
        Assert.assertEquals(4.0,actual,DELTA);

    }
    @Test
    public void checkSquare(){
        TriangleAction ta = new TriangleAction();
        Triangle triangle = new Triangle(new Point(1,1), new Point(1,3), new Point(3,1));
        double actual = ta.square(triangle);
        Assert.assertEquals(2.0,actual,DELTA);
        triangle = new Triangle(new Point(-5,0), new Point(7,9), new Point(5,-5));
        actual = ta.square(triangle);
        Assert.assertEquals(74.99999,actual,DELTA);
        triangle = new Triangle(new Point(1,1), new Point(1,2), new Point(1,3));
        actual = ta.square(triangle);
        Assert.assertEquals(0,actual,DELTA);
    }
    @Test
    public void checkIsRightTriangle(){
        TriangleAction ta = new TriangleAction();
        Triangle triangle = new Triangle(new Point(1,1), new Point(1,3), new Point(3,1));
        boolean actual = ta.isRightTriangle(triangle);
        Assert.assertTrue(actual);
        triangle = new Triangle(new Point(-5,0), new Point(7,9), new Point(5,-5));
        actual = ta.isRightTriangle(triangle);
        Assert.assertFalse(actual);
        triangle = new Triangle(new Point(1,1), new Point(1,3), new Point(1,2));
        actual = ta.isRightTriangle(triangle);
        Assert.assertFalse(actual);
    }
}
