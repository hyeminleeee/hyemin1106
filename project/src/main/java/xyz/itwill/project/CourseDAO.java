package xyz.itwill.project;

public interface CourseDAO {
	int insertCourse(Course course);
	int insertPlace(Place place);
	Course selectCourseByCourseNo(int courseNo);
}
