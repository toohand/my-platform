package com.lefthand.comm.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CloneUtils
{
    private static Logger logger = LoggerFactory.getLogger(CloneUtils.class);

    public static <T extends Serializable> T clone(T o) {
        Serializable result = null;

        ByteArrayOutputStream byteOut = null;

        ByteArrayInputStream byteIn = null;

        ObjectOutputStream objectOut = null;

        ObjectInputStream objectIn = null;
        try
        {
            byteOut = new ByteArrayOutputStream();
            objectOut = new ObjectOutputStream(byteOut);
            objectOut.writeObject(o);
            objectOut.close();

            byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            objectIn = new ObjectInputStream(byteIn);

            result = (Serializable)objectIn.readObject();
            objectIn.close();
        } catch (IOException e) {
            logger.error("Clone Object failed, IO Exception", e);
        } catch (ClassNotFoundException e) {
            logger.error("Clone Object failed, Class not found", e);
        } finally {
            try {
                byteOut = null;
                byteIn = null;
                if (objectOut != null) objectOut.close();
                if (objectIn != null) objectIn.close();
            }
            catch (IOException e) { logger.error("Clone Object Stream close failed", e); }

        }
        return (T)result;
    }
}