package xyz.itwill.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
import xyz.itwill09.dto.PointUser;
import xyz.itwill09.service.PointUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@Slf4j
public class PointUserServiceTest {
	@Autowired
	private PointUserService pointUserService;
	
	@Test
	//테스트 메소드에 @Transactional 어노테이션을 사용하면 예외 발생에 상관없이 무조건 롤백 처리
	@Transactional
	public void testAddPointBoard() {
		//PointUser user=PointUser.builder().id("abc123").name("홍길동").build();
		PointUser user=PointUser.builder().id("xyz789").name("임꺽정").build();
		
		PointUser addUser=pointUserService.addPointUser(user);
		
		log.info(addUser.toString());
	}
}











