package xyz.itwill.spring;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill01.dto.Notice;
import xyz.itwill01.service.NoticeService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Slf4j
public class NoticeServiceTest {
	@Autowired
	public NoticeService noticeService;
	
	@Test
	@Transactional
	public void testAddNotice() {
		Notice notice=Notice.builder().noticeNo(1).noticeTitle("테스트").noticeContent("테스트-1")
				.noticeImage(null).noticeRegdate(null).noticeUpdate(null).noticeCount(0).noticeStatus(1).build();
		noticeService.addNotice(notice);
	}
	
	@Test
	@Transactional
	public void testGetNoticeList() {
		List<Notice> noticeList=noticeService.getNoticeList();
		
		for(Notice notice : noticeList) {
			log.info(notice.toString());
		}
	}
}
