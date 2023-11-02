package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.spring.command.SearchListCommand;
import com.spring.dto.TrafficVO;

public class TrafficDAOImpl implements TrafficDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<TrafficVO> selectsearchTrafficList(SearchListCommand command) throws Exception {
		int offset = command.getStartRowNum();
		int limit = command.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<TrafficVO> trafficList = sqlSession.selectList("Traffic-Mapper.selectsearchTrafficList", command, rowBounds);

		if(trafficList.size() > 0 ) {
			for(int i=0;i<trafficList.size();i++) {
				//교통량 형식 맞추기
				if(trafficList.get(i).getTraff().contains(".")) {
					trafficList.get(i).setTraff(trafficList.get(i).getTraff().substring(0, trafficList.get(i).getTraff().indexOf(".")));
				}
			}
		}

		return trafficList;
	}
	
	@Override
	public int selectSearchTrafficListCount(SearchListCommand command) throws Exception {
		int count = sqlSession.selectOne("Traffic-Mapper.selectSearchTrafficListCount", command);
		return count;
	}
	
	@Override
	public TrafficVO selectTrafficByTraffnum(String traffnum) throws SQLException {
		TrafficVO tarfficList=sqlSession.selectOne("Traffic-Mapper.selectTrafficByTraffnum", traffnum);
		return tarfficList;
	}
	
	@Override
	public TrafficVO selectTrafficByHwCode(String hwCode) throws SQLException {
		
		List<TrafficVO> trafficList = 
				sqlSession.selectList("Traffic-Mapper.selectTrafficByHwCode", hwCode);
		
		return trafficList.get(0);
	}


}
