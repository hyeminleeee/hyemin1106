package xyz.itwill01.service;

import java.util.List;

import xyz.itwill01.dto.Notice;

public interface NoticeService {
	void addNotice(Notice notice);
	void removeNotice(int noticeNo);
	Notice getNotice(int noticeNo);
	List<Notice> getNoticeList();
	
}
