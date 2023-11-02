package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.command.SearchListCommand;
import com.spring.dto.HighwayVO;

public class HighwayDAOImpl implements HighwayDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<HighwayVO> selectSearchHighwayList(SearchListCommand command) throws Exception {
		int offset = command.getStartRowNum();
		int limit = command.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<HighwayVO> highwayList = sqlSession.selectList("Highway-Mapper.selectsearchHighwayList", command, rowBounds);
		return highwayList;
	}

	@Override
	public HighwayVO selectHighwayByHwcode(String hwcode) throws SQLException {
		HighwayVO highwayList=sqlSession.selectOne("Highway-Mapper.selectHighwayByHwcode", hwcode);
		return highwayList;
	}

}
