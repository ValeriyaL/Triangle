package test.by.liudchyk.triangle.action;

import by.liudchyk.triangle.action.PointAction;
import by.liudchyk.triangle.entity.Point;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Admin on 21.09.2016.
 */
public class PointActionTest {
    @Test
    public void checkIsTriangle(){
        PointAction pa = new PointAction();
        boolean actual = pa.isTriangle(new Point(1,1), new Point(1,3), new Point(1,2));
        Assert.assertFalse(actual);
        actual = pa.isTriangle(new Point(1,1), new Point(3,1), new Point(1,2));
        Assert.assertTrue(actual);
        actual = pa.isTriangle(new Point(1,2), new Point(2,3), new Point(3,5));
        Assert.assertTrue(actual);
        actual = pa.isTriangle(new Point(1,1), new Point(1,1), new Point(1,1));
        Assert.assertFalse(actual);
    }
}
