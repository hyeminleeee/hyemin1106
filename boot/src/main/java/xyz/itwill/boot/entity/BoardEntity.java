package xyz.itwill.boot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//Entity 클래스 : Java 객체와 테이블을 매핑 처리하기 위한 클래스
// => Entity 클래스의 필드는 테이블의 컬럼과 동일한 기능 제공

//@Entity : Java 객체를 테이블로 변환하기 위한 기능을 제공하는 어노테이션
// => 테이블의 이름은 클래스 이름으로 자동 설정
@Entity
//@Table : 테이블 관련 정보를 제공하기 위한 어노테이션
//name 속성 : 테이블의 이름을 속성값으로 설정 
@Table(name = "BOARD")
//@SequenceGenerator : 데이타베이스에 시퀸스를 생성하여 제공하는 어노테이션
//name 속성 : @SequenceGenerator 어노테이션의 식별자를 속성값으로 설정 
//sequenceName 속성 : 시퀸스의 이름을 속성값으로 설정 
//initialValue 속성 : 시퀸스로 제공될 초기값을 속성값으로 설정
//allocationSize 속성 : 시퀸스로 미리 생성될 자동 증가값의 갯수를 속성값으로 설정
@SequenceGenerator(name = "board_seq_generator", sequenceName = "BOARD_SEQ"
	, initialValue = 1, allocationSize = 1)
@Setter
@Getter
public class BoardEntity extends BaseEntity {
	//@Id : 테이블 컬럼에 Primary Key 제약조건을 부여하기 위한 어노테이션
	@Id
	//@GeneratedValue : 자동 증가값을 제공받아 컬럼에 저장하기 위한 어노테이션
	//strategy 속성 : 자동 증가값을 제공하기 위한 방법을 속성값으로 설정
	// => GenerationType 자료형(Enum)의 상수를 속성값으로 사용
	//GenerationType 자료형에서 제공하는 상수
	// => GenerationType.IDENTITY : 테이블의 AUTO_INCREAMENT 기능을 사용해 자동 증가값을 제공받아 사용 - mysql, mariaDB 등
	// => GenerationType.SEQUENCE : 테이타베이스의 시퀸스를 사용해 자동 증가값을 제공받아 사용 - Oracle, PostgreSQL 등
	// => GenerationType.TABLE : 자동 증가값이 저장된 테이블을 사용해 자동 증가값을 제공받아 사용
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_generator")
	private Long num;
	
	//@Column : 필드를 컬럼으로 변환하기 위한 어노테이션
	// => 필드의 이름이 자동으로 컬럼명으로 설정
	@Column
	private String writer;
	@Column
	private String title;
	@Column
	private String content;
	@Column
	private int hit;
	
	/*
	//@CreationTimestamp : 테이블에 행이 삽입될 때 자동으로 생성된 시간이 저장하는 기능을 제공하는 어노테이션
	@CreationTimestamp
	//name 속성 : 컬럼명을 속성값으로 설정
	//updatable 속성 : false 또는 true 중 하나를 속성값으로 설정
	// => 속성값이 [false]로 설정된 경우 테이블의 행 변경시 컬럼 미사용
	@Column(name = "CREATE_DATE", updatable = false)
	private LocalDateTime createDate;
	
	//@UpdateTimestamp : 테이블의 행이 변경될 때 자동으로 생성된 시간이 변경하는 기능을 제공하는 어노테이션
	@UpdateTimestamp
	//updatable 속성 : false 또는 true 중 하나를 속성값으로 설정
	// => 속성값이 [false]로 설정된 경우 테이블의 행 삽입시 컬럼 미사용
	@Column(name = "UPDATE_DATE", insertable = false)
	private LocalDateTime updateDate;
	*/
}