package xyz.itwill.boot.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

//@MappedSuperclass : 부모 역활의 Entity 클래스로 설정하기 위한 어노테이션
// => 데이타베이스의 테이블과 매핑되지 않도록 설정
@MappedSuperclass
//@EntityListeners : EntityListener 클래스를 등록하기 위한 어노테이션
// => AuditingEntityListener 클래스를 등록하여 생성 시간과 변경 시간을 자동으로 관리되도록 설정 
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseEntity {
	@CreationTimestamp
	@Column(name = "CREATE_DATE", updatable = false)
	private LocalDateTime createDate;
	
	@UpdateTimestamp
	@Column(name = "UPDATE_DATE", insertable = false)
	private LocalDateTime updateDate;
}