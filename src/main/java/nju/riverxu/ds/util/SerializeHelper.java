package nju.riverxu.ds.util;

import nju.riverxu.ds.model.data.InitialHero;

import java.io.*;

public class SerializeHelper {
    /**
     * Write any serializable objects with default ObjectOutputStream to the file.
     * @param objs
     * @param fileName
     * @return false if exception occurs
     */
    public static boolean writeAll(Object[] objs, String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objs);
            oos.close();
            fos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Use with writeAll() to get serializable objects
     * @param fileName
     * @return null if exception occurs
     */
    public static Object[] readAll(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ios = new ObjectInputStream(fis);
            Object[] read = (Object[])ios.readObject();
            ios.close();
            fis.close();

            return read;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
