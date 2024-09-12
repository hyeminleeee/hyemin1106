package xyz.itwill09.dto;

import lombok.Data;

//c

@Data
public class Payment {
	private String impUid;//거래고유번호
	private String merchantUid;//가맹점 주문번호
	private long amount;//결제금액
	private String payDate;//결제일
	private String userid;//결제 사용자의 아이디
	private String status;//결제 상태
}
