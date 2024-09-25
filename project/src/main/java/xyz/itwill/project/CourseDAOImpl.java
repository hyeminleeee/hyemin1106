package xyz.itwill.project;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CourseDAOImpl implements CourseDAO {
	private final SqlSession sqlSession;
	
	@Override
	public int insertCourse(Course course) {
		return sqlSession.getMapper(CourseMapper.class).insertCourse(course);
	}

	@Override
	public int insertPlace(Place place) {
		return sqlSession.getMapper(CourseMapper.class).insertPlace(place);
	}

	@Override
	public Course selectCourseByCourseNo(int courseNo) {
		return sqlSession.getMapper(CourseMapper.class).selectCourseByCourseNo(courseNo);
	}

}
