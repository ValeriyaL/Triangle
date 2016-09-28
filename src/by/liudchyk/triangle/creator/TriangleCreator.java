package by.liudchyk.triangle.creator;

import by.liudchyk.triangle.entity.Point;
import by.liudchyk.triangle.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Admin on 28.09.2016.
 */
public class TriangleCreator {
    static final Logger LOG = LogManager.getLogger();
    public List<Triangle> createFromFile(String path) {
        List<Triangle> res = new ArrayList<>();
        List<String> list;
        try {
            Stream<String> stream = Files.lines(Paths.get(path));
            list = stream.collect(Collectors.toList());
            for (String temp : list) {
                Pattern p = Pattern.compile("-?\\d+");
                Matcher m = p.matcher(temp);
                Point[] trPoints = new Point[3];
                for (int i = 0; i < 3; i++) {
                    boolean bool = m.find();
                    int x = Integer.valueOf(m.group());
                    m.find();
                    int y = Integer.valueOf(m.group());
                    trPoints[i] = new Point(x, y);
                }
                res.add(new Triangle(trPoints[0], trPoints[1], trPoints[2]));
            }
        }catch (IllegalStateException e){
            LOG.error("Wrong data in yor file");
        }catch (IOException e) {
            LOG.error("Can't read from file!");
        }
        return res;
    }
}
