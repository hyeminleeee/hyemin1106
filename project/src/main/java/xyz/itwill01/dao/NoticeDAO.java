package xyz.itwill01.dao;

import java.util.List;

import xyz.itwill01.dto.Notice;

public interface NoticeDAO {
	int insertNotice(Notice notice);
	int deleteNotice(int noticeNo);
	Notice selectNotice(int noticeNo);
	int selectNoticeCount();
	List<Notice> selectNoticeList();
}
