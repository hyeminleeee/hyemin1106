package xyz.itwill.project;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
	private final CourseDAO courseDAO;
	
	@Override
	public void addCourse(Course course) {
		courseDAO.insertCourse(course);
	}

	@Override
	public void addPlace(Place place) {
		courseDAO.insertPlace(place);
	}

	@Override
	public Course getCourseByCourseNo(int courseNo) {
		return courseDAO.selectCourseByCourseNo(courseNo);
	}

}
