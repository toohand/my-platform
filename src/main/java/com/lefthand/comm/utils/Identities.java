package com.lefthand.comm.utils;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.UUID;

public class Identities
{
    private static SecureRandom random = new SecureRandom();

    public static String uuid()
    {
        return UUID.randomUUID().toString();
    }

    public static String uuid2()
    {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String uuid3()
    {
        long val = ByteBuffer.wrap(uuid2().toString().getBytes()).getLong();
        return Long.toString(val, 36);
    }

    public static long randomLong()
    {
        return Math.abs(random.nextLong());
    }

    public static String randomBase62(int length)
    {
        byte[] randomBytes = new byte[length];
        random.nextBytes(randomBytes);
        return Encodes.encodeBase62(randomBytes);
    }
}