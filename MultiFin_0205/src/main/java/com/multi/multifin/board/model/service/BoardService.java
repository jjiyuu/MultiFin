package com.multi.multifin.board.model.service;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.multi.multifin.board.model.mapper.BoardMapper;
import com.multi.multifin.board.model.vo.Board;
import com.multi.multifin.board.model.vo.Reply;
import com.multi.multifin.common.util.PageInfo;

@Service
public class BoardService {
	@Autowired
	private BoardMapper mapper;
	
	@Transactional(rollbackFor = Exception.class)
	public int saveBoard(Board board) {
		int result = 0;
		if(board.getBNo() == 0) {
			result = mapper.insertBoard(board);
		}else {
			result = mapper.updateBoard(board);
		}
		return result;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int saveReply(Reply reply) {
		return mapper.insertReply(reply);
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	public int updateReply(Reply reply) {
		return mapper.updateReply(reply);
	}
	
	
	public String saveFile(MultipartFile upFile, String savePath) {
		File folder = new File(savePath);
		
		if(folder.exists() == false) {
			folder.mkdir();
		}
		System.out.println("savePath : " + savePath);
		
		String originalFileName = upFile.getOriginalFilename();
		String reNameFileName = 
					LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSSS"));
		reNameFileName += originalFileName.substring(originalFileName.lastIndexOf("."));
		String reNamePath = savePath + "/" + reNameFileName;
		
		try {
			upFile.transferTo(new File(reNamePath));
		} catch (Exception e) {
			return null;
		}
		return reNameFileName;
	}
	
	
	
	
	
	
	public int getBoardCount(Map<String, String> param) {
		param.put("type", "공지사항");
		return mapper.selectBoardCount(param);
	}
	
	public List<Board> getBoardList(PageInfo pageInfo, Map<String, String> param){
		param.put("type", "공지사항");
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectBoardList(param);
	}
	
	
	
	public int getBoardCount2(Map<String, String> param) {
		param.put("type", "자유게시판");
		return mapper.selectBoardCount(param);
	}
	
	public List<Board> getBoardList2(PageInfo pageInfo, Map<String, String> param){
		param.put("type", "자유게시판");
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectBoardList(param);
	}

	
	
	
	@Transactional(rollbackFor = Exception.class)
	public Board findByNo(int boardNo) {
		Board board = mapper.selectBoardByNo(boardNo); 
		board.setReadCount(board.getReadCount() + 1);  
		mapper.updateReadCount(board);
		return board; 
	}
	
	
	public void deleteFile(String filePath) {
		File file = new File(filePath);
		if(file.exists()) {
			file.delete();
		}
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	public int deleteBoard(int no, String rootPath) {
		Board board = mapper.selectBoardByNo(no);
		deleteFile(rootPath + "\\" + board.getRenamedFileName());
		return mapper.deleteBoard(no);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int deleteReply(int no) {
		return mapper.deleteReply(no);
	}
	
		
	
	/*회원수정부*/
	public int getMyBoardCount(String id) {
		return mapper.selectMyBoardCount(id);
	}
	
	public List<Board> getMyBoardList(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectMyBoardList(param);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int deleteAllMyBoard(int mNo) {
		return mapper.deleteAllMyBoard(mNo);
	}
	

	
	/*내댓글수정부*/
	public int selectMyReplyTime(String id) {
		return mapper.selectMyReplyTime(id);
	}
	
	public List<Board> selectMyReplyList(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectMyReplyList(param);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int deleteAllMyReply(String id) {
		return mapper.deleteAllMyReply(id);
	}
	
	/*메인에 들어갈 것*/
	public List<Board> selectMainBoard(){
		return mapper.selectMainBoard();
	}



}




