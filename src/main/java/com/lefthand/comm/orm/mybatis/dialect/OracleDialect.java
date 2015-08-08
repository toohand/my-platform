package com.lefthand.comm.orm.mybatis.dialect;

public class OracleDialect extends Dialect
{
    public String getLimitString(String sql, int offset, int limit)
    {
        sql = sql.trim();
        boolean isForUpdate = false;
        if (sql.toLowerCase().endsWith(" for update")) {
            sql = sql.substring(0, sql.length() - 11);
            isForUpdate = true;
        }

        StringBuilder buffer = new StringBuilder(sql.length() + 100);
        buffer.append("select * from ( select row_.*, rownum rownum_ from ( ");
        buffer.append(sql);
        buffer.append(" ) row_ where rownum <= ");
        buffer.append(offset + limit);
        buffer.append(") where rownum_ > ");
        buffer.append(offset);

        if (isForUpdate) {
            buffer.append(" for update");
        }
        return buffer.toString();
    }
}