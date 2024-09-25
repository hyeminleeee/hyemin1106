package xyz.itwill.project;

public interface CourseService {
	void addCourse(Course course);
	void addPlace(Place place);
	Course getCourseByCourseNo(int courseNo);
}
