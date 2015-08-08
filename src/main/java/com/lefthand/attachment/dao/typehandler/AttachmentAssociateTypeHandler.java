package com.lefthand.attachment.dao.typehandler;

import com.lefthand.attachment.domain.entity.AttachmentAssociateType;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 附件关联类型处理类
 * 实现数据库序列化, 反序列化
 */
public class AttachmentAssociateTypeHandler extends BaseTypeHandler<AttachmentAssociateType> implements TypeHandler<AttachmentAssociateType> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, AttachmentAssociateType associateType, JdbcType jdbcType) throws SQLException {
    ps.setInt(i, associateType.id());
  }

  @Override
  public AttachmentAssociateType getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return AttachmentAssociateType.fromTypeId(rs.getInt(columnName));
  }

  @Override
  public AttachmentAssociateType getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return AttachmentAssociateType.fromTypeId(rs.getInt(columnIndex));
  }

  @Override
  public AttachmentAssociateType getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return AttachmentAssociateType.fromTypeId(cs.getInt(columnIndex));
  }
}
