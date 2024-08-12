package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.MyReply;
import xyz.itwill.dto.MyReplyUser;

public interface MyReplyMapper {
	int insertReply(MyReply reply);
	List<MyReply> selectReplyList();
	List<MyReplyUser> selectReplyUserList1();
	List<MyReplyUser> selectReplyUserList2();
	List<MyReply> selectCountReplyList();
	List<MyReply> selectCommentNoReplyList(int commentNo);
}
