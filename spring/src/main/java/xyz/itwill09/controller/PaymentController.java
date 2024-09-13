package xyz.itwill09.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import xyz.itwill09.dto.Payment;
import xyz.itwill09.service.PaymentService;

@Controller
@RequestMapping("/pay")
@RequiredArgsConstructor
public class PaymentController {
	private final PaymentService paymentService;
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String pay() {
		return "pay";
	}
	
	@RequestMapping(value = "/payment", method = RequestMethod.POST)
	@ResponseBody
	public String pay(@RequestBody Payment payment, HttpSession session) {
		//결제 관련 OpenAPI를 이용하기 전에 결제 금액 검증을 위해 세션에 속성명으로 주문번호를
		//저장하고 속성값으로 결제금액을 저장한 후 문자열로 응답하는 요청 처리 메소드
		session.setAttribute(payment.getMerchantUid(), payment.getAmount());
		return "ok";
	}
	
	//결제 후 결제 금액을 검증하여 문자열로 응답하는 요청 처리 메소드
	@RequestMapping(value = "/complete", method = RequestMethod.POST)
	public String complete(@RequestBody Payment payment, HttpSession session) {
		//접근토큰을 발급받아 저장
		String accessToken=paymentService.getAccessToken();
		
		//매개변수에 접근토큰과 결제고유값을 전달하여 OpenAPI를 사용해 결제정보를 반환받아 저장
		Payment returnPayment=paymentService.getPayment(accessToken, payment.getImpUid());
		
		//세션에 저장된 결제금액을 반환받아 저장
		Long beforeAmount=(Long)session.getAttribute(payment.getMerchantUid());
		session.removeAttribute(payment.getMerchantUid());
		
		//조회된 결제 정보의 결제금액을 반환받아 저장
		Long amount=returnPayment.getAmount();
		
		if(beforeAmount == amount) {//검증 성공
			paymentService.addPayment(returnPayment);//테이블에 행 삽입
			return "success";
		} else {
			paymentService.cancelPayment(accessToken, returnPayment);
			return "forgery";
		}
	}
}




















