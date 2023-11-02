package com.spring.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.LightVO;

public class LightDAOImpl implements LightDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	/*
	@Override
	public List<LightVO> selectSearchLightList(SearchListCommand command) throws Exception {
		int offset = command.getStartRowNum();
		int limit = command.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		List<LightVO> lightList = sqlSession.selectList("Light-Mapper.selectsearchLightList", command, rowBounds);
		return lightList;
	}
	*/
	@Override
	public LightVO selectLightByLnum(String lnum) throws SQLException {
		LightVO lightList=sqlSession.selectOne("Light-Mapper.selectLightByLnum", lnum);
		return lightList;
	}
	/*
	@Override
	public LightVO selectLightByLstate(String lstate) throws SQLException {
		LightVO lightList1=sqlSession.selectOne("Light-Mapper.selectLightByLstate", lstate);
		return lightList1;
	}
	@Override
	public int selectSearchLightListCount(SearchListCommand command) throws Exception {
		int count=0;
		count=sqlSession.selectOne("Light-Mapper.selectSearchLightListCount", command);
		return count;
	}
	*/
	@Override
	public List<LightVO> selectLightList() throws SQLException {
		List<LightVO> light = sqlSession.selectList("Light-Mapper.selectLightList");
		return light;
	}
	
	@Override
	public List<LightVO> selectsearchLightList() throws SQLException {
		List<LightVO> light = sqlSession.selectList("Light-Mapper.selectsearchLightList");
		return light;
	}

	@Override
	public List<LightVO> selectLightByHwCode(String hwCode) throws SQLException {
		List<LightVO> light= sqlSession.selectList("Light-Mapper.selectLightByHwCode",hwCode);
		return light;
	}
	
	@Override
	public void updateLight(List<LightVO> light) throws Exception {
		List<LightVO> lightList = selectLightList();
		for(int i=0;i<lightList.size();i++) {
			for(int j=0;j<light.size();j++) {
				if(lightList.get(i).getHwCode().equals(light.get(j).getHwCode())) {
					lightList.get(i).setlState(light.get(j).getlState());
				}
			}
			sqlSession.update("Light-Mapper.updateLight",lightList.get(i));
			//System.out.println(lightList.get(i).getlNum()+" "+lightList.get(i).getHwCode()+" "+lightList.get(i).getlState());
		}

	}


}
