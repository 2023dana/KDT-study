package com.example.demo.pojo3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Board2Logic {
	Logger logger = Logger.getLogger(Board2Logic.class);
	Board2Dao bDao = new Board2Dao();
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList");
		List<Map<String, Object>> bList = new ArrayList<>();
		bList = bDao.boardList(pMap);
		return bList;
	}
	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsert");
		int result = 0;
		result = bDao.boardInsert(pMap);
		return result;
	}
	public int boardUpdate(Map<String, Object> pMap) {
		logger.info("boardUpdate");
		int result = 0;
		result = bDao.boardUpdate(pMap);
		return result;
	}
	public int boardDelete(Map<String, Object> pMap) {
		logger.info("boardDelete");
		int result = 0;
		result = bDao.boardDelete(pMap);
		return result;
	}
	public List<Map<String, Object>> boardDetail(Map<String, Object> pMap) {
		return null;
	}
}
