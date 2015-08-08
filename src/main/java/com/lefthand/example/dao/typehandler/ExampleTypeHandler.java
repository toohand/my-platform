package com.lefthand.example.dao.typehandler;

import com.lefthand.example.domain.support.ExampleType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2014/9/30.
 */
public class ExampleTypeHandler extends BaseTypeHandler<ExampleType> implements TypeHandler<ExampleType> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ExampleType type, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, type.id());
    }

    @Override
    public ExampleType getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return ExampleType.fromTypeId(rs.getInt(columnName));
    }

    @Override
    public ExampleType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return ExampleType.fromTypeId(rs.getInt(columnIndex));
    }

    @Override
    public ExampleType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return ExampleType.fromTypeId(cs.getInt(columnIndex));
    }
}
