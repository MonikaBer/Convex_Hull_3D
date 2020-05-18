package project.view.configurationWindow.panels;

import project.exceptions.ConversionException;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

public class PanelsHelper {

    public static Point3d convertToPoint3d(String x, String y, String z) throws ConversionException {
        try {
            Double doubleX = Double.parseDouble(x);
            Double doubleY = Double.parseDouble(y);
            Double doubleZ = Double.parseDouble(z);
            Point3d point3d = new Point3d(doubleX, doubleY, doubleZ);
            return point3d;
        } catch (Exception ex) {
            throw new ConversionException();
        }
    }

    public static Vector3d convertToVector3d(String x, String y, String z) throws ConversionException {
        try {
            Double doubleX = Double.parseDouble(x);
            Double doubleY = Double.parseDouble(y);
            Double doubleZ = Double.parseDouble(z);
            Vector3d vector3d = new Vector3d(doubleX, doubleY, doubleZ);
            return vector3d;
        } catch (Exception ex) {
            throw new ConversionException();
        }
    }

    public static Double convertToDouble(String a) throws ConversionException {
        try {
            Double doubleA = Double.parseDouble(a);
            return doubleA;
        } catch (Exception ex) {
            throw new ConversionException();
        }
    }

    public static Integer convertToInteger(String a) throws ConversionException {
        try {
            Integer integerA = Integer.parseInt(a);
            return integerA;
        } catch (Exception ex) {
            throw new ConversionException();
        }
    }
}
