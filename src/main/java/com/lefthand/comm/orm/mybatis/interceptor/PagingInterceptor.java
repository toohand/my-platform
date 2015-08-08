package com.lefthand.comm.orm.mybatis.interceptor;

import com.lefthand.comm.orm.mybatis.dialect.MySql5Dialect;
import com.lefthand.comm.orm.mybatis.dialect.OracleDialect;
import java.util.Properties;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

@Intercepts({@org.apache.ibatis.plugin.Signature(type=StatementHandler.class, method="prepare", args={java.sql.Connection.class})})
public class PagingInterceptor
        implements Interceptor
{
    private static final Log log = LogFactory.getLog(PagingInterceptor.class);

    public Object intercept(Invocation invocation) throws Throwable
    {
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
        BoundSql boundSql = statementHandler.getBoundSql();
        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler,null,null);
        RowBounds rowBounds = (RowBounds)metaStatementHandler.getValue("delegate.rowBounds");
        if ((rowBounds == null) || (rowBounds == RowBounds.DEFAULT)) {
            return invocation.proceed();
        }
        Configuration configuration = (Configuration)metaStatementHandler.getValue("delegate.configuration");
        com.lefthand.comm.orm.mybatis.dialect.Dialect.Type databaseType = null;
        try {
            databaseType = com.lefthand.comm.orm.mybatis.dialect.Dialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (databaseType == null) {
            throw new RuntimeException("the value of the dialect property in configuration.xml is not defined : " + configuration.getVariables().getProperty("dialect"));
        }
        com.lefthand.comm.orm.mybatis.dialect.Dialect dialect = null;
        switch (databaseType.ordinal()) {
        case 1:
            dialect = new MySql5Dialect();
            break;
        case 2:
            dialect = new OracleDialect();
    }

        String originalSql = (String)metaStatementHandler.getValue("delegate.boundSql.sql");
        metaStatementHandler.setValue("delegate.boundSql.sql", dialect.getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit()));
        metaStatementHandler.setValue("delegate.rowBounds.offset", Integer.valueOf(0));
        metaStatementHandler.setValue("delegate.rowBounds.limit", Integer.valueOf(2147483647));
        if (log.isDebugEnabled()) {
            log.debug("生成分页SQL : " + boundSql.getSql());
        }
        return invocation.proceed();
    }

    public Object plugin(Object target)
    {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties)
    {
    }
}