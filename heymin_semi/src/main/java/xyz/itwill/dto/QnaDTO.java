package xyz.itwill.dto;

/*
CREATE TABLE qna (
    qna_num         NUMBER         PRIMARY KEY,
    review_member  NUMBER         REFERENCES Member (member_num),
    qna_title     VARCHAR2(100)  NOT NULL,
    qna_content     VARCHAR2(4000) NOT NULL,
    qna_image       VARCHAR2(100),
    qna_date    DATE           DEFAULT SYSDATE,
    qna_update      DATE           DEFAULT SYSDATE,
    qna_count   NUMBER         DEFAULT 0,
    qna_reply      VARCHAR2(4000),
    qna_product_num NUMBER         REFERENCES Product (product_num),
    qna_status      NUMBER(1)      DEFAULT 1 CHECK (qna_status IN (0, 1))
);
  */

/*CREATE SEQUENCE qa_seq;*/

/*
이름              널?       유형             
--------------- -------- -------------- 
QNA_NUM         NOT NULL NUMBER         
REVIEW_MEMBER            NUMBER         
QNA_TITLE       NOT NULL VARCHAR2(100)  
QNA_CONTENT     NOT NULL VARCHAR2(4000) 
QNA_IMAGE                VARCHAR2(100)  
QNA_DATE                 DATE           
QNA_UPDATE               DATE           
QNA_COUNT                NUMBER         
QNA_REPLY               VARCHAR2(4000) 
QNA_PRODUCT_NUM          NUMBER         
QNA_STATUS               NUMBER(1)
*/

public class QnaDTO {
	private int qnaNum;
	private int reviewMember;
	private String qnaTitle;
	private String qnaContent;
	private String qnaImage;
	private String qnaDate;
	private String qnaUpdate;
	private int qnaCount;
	private String qnaReply;
	private String qnaProductNum;
	private int qnaStatus;
	
	public QnaDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getQnaNum() {
		return qnaNum;
	}

	public void setQnaNum(int qnaNum) {
		this.qnaNum = qnaNum;
	}

	public int getReviewMember() {
		return reviewMember;
	}

	public void setReviewMember(int reviewMember) {
		this.reviewMember = reviewMember;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public String getQnaImage() {
		return qnaImage;
	}

	public void setQnaImage(String qnaImage) {
		this.qnaImage = qnaImage;
	}

	public String getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaUpdate() {
		return qnaUpdate;
	}

	public void setQnaUpdate(String qnaUpdate) {
		this.qnaUpdate = qnaUpdate;
	}

	public int getQnaCount() {
		return qnaCount;
	}

	public void setQnaCount(int qnaCount) {
		this.qnaCount = qnaCount;
	}

	public String getQnaReply() {
		return qnaReply;
	}

	public void setQnaReply(String qnaReply) {
		this.qnaReply = qnaReply;
	}

	public String getQnaProductNum() {
		return qnaProductNum;
	}

	public void setQnaProductNum(String qnaProductNum) {
		this.qnaProductNum = qnaProductNum;
	}

	public int getQnaStatus() {
		return qnaStatus;
	}

	public void setQnaStatus(int qnaStatus) {
		this.qnaStatus = qnaStatus;
	}
	
	
	
}
