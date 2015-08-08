package com.lefthand.comm.exception;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageBundle
{
    private static Logger logger = LoggerFactory.getLogger(MessageBundle.class);
    private Class<? extends Enum> clazz;
    private ResourceBundle bundle;

    public MessageBundle(Class<? extends Enum> clazz)
    {
        try
        {
            this.clazz = clazz;
            this.bundle = ResourceBundle.getBundle(this.clazz.getName(), Locale.SIMPLIFIED_CHINESE);
        } catch (MissingResourceException e) {
            logger.error(this.clazz.getName() + ".properties is missing", e);
        }
    }

    public String getMessage(String key) {
        String value = null;
        try {
            value = this.bundle.getString(key);
        } catch (MissingResourceException e) {
            logger.error(key + " is missing in " + this.clazz.getName() + ".properties");
        }
        return value;
    }
}