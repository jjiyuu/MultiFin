package com.multi.multifin.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.board.model.vo.Board;
import com.multi.multifin.board.model.vo.Reply;

@Mapper
public interface BoardMapper {
	List<Board> selectBoardList(Map<String, String> map);
	int selectBoardCount(Map<String, String> map);
	Board selectBoardByNo(int bno);
	int insertBoard(Board board);
	int insertReply(Reply reply);
	int updateBoard(Board board);
	int updateReadCount(Board board);
	int deleteBoard(int no);
	int deleteReply(int no);
	int updateReply(Reply reply);
	Reply selectReplyByNo(int no);
	
	//회원수정부
	List<Board> selectMyBoardList(Map<String, String> map);
	int selectMyBoardCount(String id);
	int deleteAllMyBoard(int mNo);
	//메인
	List<Board> selectMainBoard();
	
	//내댓글수정부
	List<Board> selectMyReplyList(Map<String, String> map);
	int selectMyReplyTime(String id);
	int deleteAllMyReply(String id);
}
