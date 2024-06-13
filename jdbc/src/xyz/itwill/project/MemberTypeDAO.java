package xyz.itwill.project;

public interface MemberTypeDAO {
	MemberTypeDAO selectDuringDateByType(String type);
	MemberTypeDAO selectPriceeByType(String type);
}
