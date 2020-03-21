/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session4_Generics;

/**
 *
 * @author June
 */
public class generics_methods_with_return {

    static <T extends Comparable<T>> T max(T value1, T value2) {
        if (value1.compareTo(value2) == 0) {
            return value1;
        } else {
            if (value1.compareTo(value2) > 0) {
                return value1;
            } else {
                return value2;
            }
        }
    }

    static <T> T add(T one, T two) {
        if (one.getClass() == Integer.class) {
            // With auto-boxing / unboxing
            return (T) (Integer) ((Integer) one + (Integer) two);
        } else {
            if (one.getClass() == Long.class) {
                // Without auto-boxing / unboxing
                return (T) Long.valueOf(((Long) one).longValue() + ((Long) two).longValue());
            } else {
                return (T) String.valueOf(String.valueOf(one) + String.valueOf(two));
            }
        }
    }

    public static <T extends Number> T add(T x, T y) {

        if (x == null || y == null) {
            return null;
        }

        if (x instanceof Double) {
            return (T) new Double(x.doubleValue() + y.doubleValue());
        } else if (x instanceof Integer) {
            return (T) new Integer(x.intValue() + y.intValue());
        } else {
            throw new IllegalArgumentException("Type " + x.getClass() + " is not supported by this method");
        }
    }

    public static void main(String[] args) {
        System.out.println(max(1, 2));
        System.out.println(max("a", "b"));
        System.out.println(add(1, 2));
        System.out.println(add("1", "2"));
    }
}
