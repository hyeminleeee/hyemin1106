package xyz.itwill01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill01.dto.Notice;
import xyz.itwill01.mapper.NoticeMapper;

@Repository
@RequiredArgsConstructor
public class NoticeDAOImpl implements NoticeDAO {
	private final SqlSession session;

	@Override
	public int insertNotice(Notice notice) {
		return session.getMapper(NoticeMapper.class).insertNotice(notice);
	}

	@Override
	public int deleteNotice(int noticeNo) {
		return session.getMapper(NoticeMapper.class).deleteNotice(noticeNo);
	}

	@Override
	public Notice selectNotice(int noticeNo) {
		return session.getMapper(NoticeMapper.class).selectNotice(noticeNo);
	}
	
	@Override
	public int selectNoticeCount() {
		return session.getMapper(NoticeMapper.class).selectNoticeCount();
	}

	@Override
	public List<Notice> selectNoticeList() {
		return session.getMapper(NoticeMapper.class).selectNoticeList();
	}

	

}
