package xyz.itwill01.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notice {
	private int noticeNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeImage;
	private String noticeRegdate;
	private String noticeUpdate;
	private int noticeCount;
	private int noticeStatus;
}
