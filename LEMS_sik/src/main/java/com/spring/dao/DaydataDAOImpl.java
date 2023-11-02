package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.command.SearchListCommand;
import com.spring.dto.DaydataVO;

public class DaydataDAOImpl implements DaydataDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<DaydataVO> selectSearchDaydataList(SearchListCommand command) throws Exception {
		int offset = command.getStartRowNum();
		int limit = command.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<DaydataVO> daydataList = sqlSession.selectList("Daydata-Mapper.selectSearchDaydataList", command, rowBounds);
		
		if(daydataList.size() > 0) {
			for(int i=0;i<daydataList.size();i++) {
				if(daydataList.get(i).getDayTrf().contains(".")) {
					daydataList.get(i).setDayTrf(daydataList.get(i).getDayTrf().substring(0, daydataList.get(i).getDayTrf().indexOf(".")));
				}
			}
		}
		
		return daydataList;
	}

	@Override
	public int selectSearchDaydataListCount(SearchListCommand command) throws Exception {
		int count = sqlSession.selectOne("Daydata-Mapper.selectSearchDaydataListCount", command);
		return count;
	}

	@Override
	public DaydataVO selectDaydataBydaynum(String daynum) throws SQLException {
		DaydataVO daydataList = sqlSession.selectOne("Daydata-Mapper.selectDaydataBydaynum", daynum);
		return daydataList;
	}

	@Override
	public List<DaydataVO> selectDaydataList() throws Exception {
		List<DaydataVO> daydataList = sqlSession.selectList("Daydata-Mapper.selectDaydataList");
		
		if(daydataList.size() > 0) {
			for(int i=0;i<daydataList.size();i++) {
				if(daydataList.get(i).getDayTrf().contains(".")) {
					daydataList.get(i).setDayTrf(daydataList.get(i).getDayTrf().substring(0, daydataList.get(i).getDayTrf().indexOf(".")));
				}
			}
		}
		
		return daydataList;
	}

}