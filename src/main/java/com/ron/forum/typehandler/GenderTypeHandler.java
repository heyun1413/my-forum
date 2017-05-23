package com.ron.forum.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.ron.forum.enums.Gender;

public class GenderTypeHandler extends BaseTypeHandler<Gender>{

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Gender parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.getValue());
	}
	
	@Override
	public Gender getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int value = rs.getInt(columnName);
		if (rs.wasNull()) {
			throw new NullPointerException();
		}
		return Gender.genderOf(value);
	}

	@Override
	public Gender getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int value = rs.getInt(columnIndex);
		if (rs.wasNull()) {
			throw new NullPointerException();
		}
		return Gender.genderOf(value);
	}

	@Override
	public Gender getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		throw new UnsupportedOperationException("没有实现的方法");
	}

}
