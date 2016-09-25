package test.by.liudchyk.triangle.action;

import by.liudchyk.triangle.action.TriangleAction;
import by.liudchyk.triangle.entity.Point;
import by.liudchyk.triangle.entity.Triangle;
import by.liudchyk.triangle.exception.TriangleException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Admin on 21.09.2016.
 */
public class TriangleActionTest {
    private static TriangleAction triangleAction;

    @BeforeClass
    public static void initTriangleAction(){
        triangleAction = new TriangleAction();
    }

    @AfterClass
    public static void clearTriangleAction(){
        triangleAction = null;
    }

    @Test
    public void checkPerimeter1() {
        Triangle triangle = new Triangle(new Point(1, 1), new Point(1, 3), new Point(3, 1));
        double actual = triangleAction.perimeter(triangle);
        Assert.assertEquals(6.828427, actual, 0.00001);
    }

    @Test
    public void checkPerimetr2() {
        Triangle triangle = new Triangle(new Point(-5, 0), new Point(7, 9), new Point(5, -5));
        double actual = triangleAction.perimeter(triangle);
        Assert.assertEquals(40.32247, actual, 0.00001);
    }

    @Test
    public void checkPerimetr3(){
        Triangle triangle = new Triangle(new Point(1,1), new Point(1,2), new Point(1,3));
        double actual = triangleAction.perimeter(triangle);
        Assert.assertEquals(0,actual,0.00001);
    }

    @Test
    public void checkSquare1() {
        Triangle triangle = new Triangle(new Point(1, 1), new Point(1, 3), new Point(3, 1));
        double actual = triangleAction.square(triangle);
        Assert.assertEquals(2.0, actual, 0.00001);
    }

    @Test
    public void checkSquare2() {
        Triangle triangle = new Triangle(new Point(-5, 0), new Point(7, 9), new Point(5, -5));
        double actual = triangleAction.square(triangle);
        Assert.assertEquals(74.99999, actual, 0.00001);
    }

    @Test
    public void checkSquare3(){
        Triangle triangle = new Triangle(new Point(1,1), new Point(1,2), new Point(1,3));
        double actual = triangleAction.square(triangle);
        Assert.assertEquals(0,actual,0.00001);
    }

    @Test
    public void checkIsTriangle1() {
        boolean actual = triangleAction.isTriangle(new Point(1, 1), new Point(1, 3), new Point(1, 2));
        Assert.assertFalse(actual);
    }

    @Test
    public void checkIsTriangle2() {
        boolean actual = triangleAction.isTriangle(new Point(1, 1), new Point(3, 1), new Point(1, 3));
        Assert.assertTrue(actual);
    }

    @Test
    public void checkIsTriangle3() {
        boolean actual = triangleAction.isTriangle(new Point(1, 2), new Point(2, 3), new Point(3, 5));
        Assert.assertTrue(actual);
    }

    @Test
    public void checkIsTriangle4(){
        boolean actual = triangleAction.isTriangle(new Point(1,1), new Point(1,1), new Point(1,1));
        Assert.assertFalse(actual);
    }

    @Test
    public void checkIsRightTriangle1() throws TriangleException {
        Triangle triangle = new Triangle(new Point(1, 1), new Point(1, 3), new Point(3, 1));
        boolean actual = triangleAction.isRightTriangle(triangle);
        Assert.assertTrue(actual);
    }

    @Test
    public void checkIsRightTriangle2() throws TriangleException {
        Triangle triangle = new Triangle(new Point(-5,0), new Point(7,9), new Point(5,-5));
        boolean actual = triangleAction.isRightTriangle(triangle);
        Assert.assertFalse(actual);
    }

    @Test(expected = TriangleException.class)
    public void checkIsRightTriangle3() throws TriangleException {
        Triangle triangle = new Triangle(new Point(1,1), new Point(1,3), new Point(1,2));
        boolean actual = triangleAction.isRightTriangle(triangle);
        Assert.assertEquals(false,actual);
    }
}
