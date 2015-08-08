package com.lefthand.attachment.dao.typehandler;

import com.lefthand.attachment.domain.entity.AttachmentType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 附件类型处理类
 * 实现数据库序列化, 反序列化
 */
public class AttachmentTypeHandler extends BaseTypeHandler<AttachmentType> implements TypeHandler<AttachmentType> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, AttachmentType attachmentType, JdbcType jdbcType) throws SQLException {
    ps.setInt(i, attachmentType.id());
  }

  @Override
  public AttachmentType getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return AttachmentType.fromTypeId(rs.getInt(columnName));
  }

  @Override
  public AttachmentType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return AttachmentType.fromTypeId(rs.getInt(columnIndex));
  }

  @Override
  public AttachmentType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return AttachmentType.fromTypeId(cs.getInt(columnIndex));
  }
}
