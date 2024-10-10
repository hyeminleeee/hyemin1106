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
	//@Modifying : JPQL를 사용해 메소드에 INSERT, UPDATE, DELETE 명령을 등록하기 위한 어노테이션
	// => INSERT, UPDATE, DELETE 명령을 메소드에 등록시 @Modifying 어노테이션을 사용하지 않으면 예외 발생
	@Modifying
	//@Query : JPQL(Java Persistence Query Language)를 사용해 추상메소드에 SQL 명령을 등록하는 어노테이션
	// => 기본적으로 SELECT 명령만 등록하며 @Modifying 어노테이션을 사용하면 INSERT, UPDATE, DELETE 명령 등록 가능
	//JPQL : 객체 지향 쿼리 언어로 Entity 객체를 기반으로 SQL 명령 작성하여 메소드에 등록
	// => 복잡한 SQL 명령을 등록할 경우 QueryDSL(Query Domain-Specific Language) 사용
	//value 속성 : Entity 객체를 기반으로 작성된 JPQL 명령을 속성값으로 설정
	// => 메소드 매개변수로 전달받은 값을 [:변수명] 형식으로 JPQL에서 사용 가능
	@Query(value = "update BoardEntity b set b.hit = b.hit + 1 where b.num=:num")
	//@Param : @Query 어노테이션으로 등록된 JPQL 명령에 매개변수에 저장된 값을 제공하기 위한 어노테이션
	//value 속성 : JPQL 명령에서 사용하기 위한 변수명을 속성값으로 설정
	void updateHit(@Param(value = "num") Long num);
}