package fitness;

public interface MemberTypeDAO {
	MemberTypeDAO selectDuringDateByType(String type);
	MemberTypeDAO selectPriceeByType(String type);
}
