package xyz.itwill.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xyz.itwill.boot.entity.BoardEntity;

//JpaRepository 인터페이스 : CRUD 기능을 제공하는 인터페이스
// => 첫번째 제네릭에는 Entity 클래스로 작성하고 두번째 제네릭에는 PK 제약조건이 설정된 필드의
//자료형을 작성해 JpaRepository 인터페이스의 메소드가 필요한 정보를 제공받아 사용되도록 설정
// => Repository 인터페이스를 작성하면 JPA 내부에서 인터페이스를 상복받은 자식클래스로 객체 생성
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
