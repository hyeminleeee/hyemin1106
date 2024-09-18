package xyz.itwill01.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xyz.itwill01.dao.NoticeDAO;
import xyz.itwill01.dto.Notice;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
	private final NoticeDAO noticeDAO;
	
	@Override
	public void addNotice(Notice notice) {
		noticeDAO.insertNotice(notice);
	}

	@Override
	public void removeNotice(int noticeNo) {
		noticeDAO.deleteNotice(noticeNo);
	}

	@Override
	public Notice getNotice(int noticeNo) {
		return noticeDAO.selectNotice(noticeNo);
	}

	@Override
	public List<Notice> getNoticeList() {
		return noticeDAO.selectNoticeList();
	}

}
