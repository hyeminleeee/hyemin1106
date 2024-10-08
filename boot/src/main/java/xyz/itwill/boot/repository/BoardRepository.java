package xyz.itwill.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import xyz.itwill.boot.entity.BoardEntity;

//JpaRepository 인터페이스를 상속받은 Repository 인터페이스 작성 - DAO 클래스(Repository 클래스)
//JpaRepository 인터페이스 : CRUD 기능을 제공하는 인터페이스
// => 첫번째 제네릭에는 Entity 클래스로 작성하고 두번째 제네릭에는 PK 제약조건이 설정된 필드의
//자료형으로 작성해 JpaRepository 인터페이스의 메소드가 필요한 정보를 제공하여 사용되도록 설정
// => Repository 인터페이스를 작성하면 JPA 내부에서 인터페이스를 상속받은 자식클래스로 객체 생성
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
	//@Modifying : JPQL(Java Persistence Query Language)를 사용한 메소드를 등록하기 위한 어노테이션
	// => JPQL : 객체 지향 쿼리 언어로 Entity 객체를 기반으로 SQL 명령 작성하여 메소드에 등록
	@Modifying
	//@Query : JPQL를 사용해 SQL 명령을 등록하는 어노테이션
	// => 메소드 매개변수로 전달받은 값을 [:변수명] 형식으로 SQL 명령에서 사용 가능
	//value 속성 : Entity 객체를 기반으로 작성된 SQL 명령을 속성값으로 설정
	//@Param : @Query 어노테이션으로 등록된 SQL 명령에 매개변수에 저장된 값을 제공하기 위한 어노테이션
	//value 속성 : SQL 명령에서 사용하기 위한 변수명을 속성값으로 설정
	@Query(value = "update BoardEntity b set b.hit = b.hit+1 where b.num=:num")
	void updateHit(@Param(value = "num") Long num);
}