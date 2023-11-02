package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.command.SearchListCommand;
import com.spring.dto.SunlightVO;

public class SunlightDAOImpl implements SunlightDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<SunlightVO> selectSearchSunlightList(SearchListCommand command) throws SQLException {
		int offset = command.getStartRowNum();
		int limit = command.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<SunlightVO> sunlightList = 
				sqlSession.selectList("Sunlight-Mapper.selectSearchSunlightList", command, rowBounds);
		
		for(int i=0;i<sunlightList.size();i++) {
			sunlightList.get(i).setStrFullLight(sunlightList.get(i).getFullLight());
		}
		
		return sunlightList;
	}

	@Override
	public int selectSearchSunlightListCount(SearchListCommand command) throws SQLException {
		int count = sqlSession.selectOne("Sunlight-Mapper.selectSearchSunlightListCount", command);
		return count;
	}

	@Override
	public SunlightVO selectSunlightBySunnum(String sunnum) throws SQLException {
		SunlightVO lightList = sqlSession.selectOne("Sunlight-Mapper.selectSunlightBySunnum", sunnum);
		return lightList;
	}
	
	@Override
	public SunlightVO selectSunlightByHwCode(String hwCode) throws SQLException {
		
		List<SunlightVO> sunlightList = 
				sqlSession.selectList("Sunlight-Mapper.selectSunlightByHwCode", hwCode);
		
		return sunlightList.get(0);
	}

}
