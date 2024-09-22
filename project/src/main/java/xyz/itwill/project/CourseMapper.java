package xyz.itwill.project;

public interface CourseMapper {
	int insertCourse(Course course);
	int insertPlace(Place place);
	Course selectCourseByCourseNo(int courseNo);
}
