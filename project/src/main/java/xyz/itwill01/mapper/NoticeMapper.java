package xyz.itwill01.mapper;

import java.util.List;

import xyz.itwill01.dto.Notice;

public interface NoticeMapper {
	int insertNotice(Notice notice);
	int deleteNotice(int noticeNo);
	Notice selectNotice(int noticeNo);
	int selectNoticeCount();
	List<Notice> selectNoticeList();
}
