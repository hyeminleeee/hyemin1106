package xyz.itwill.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
CREATE TABLE PLACE (
    place_no       NUMBER,                  -- 코스 번호 (FK)
    place_order    NUMBER,                  -- 장소 순서
    place_x        NUMBER,                  -- 장소 경도
    place_y        NUMBER,                  -- 장소 위도
    place_name     VARCHAR2(255),           -- 장소 이름
    place_content  VARCHAR2(1000),          -- 장소 소개
    place_image    VARCHAR2(500),           -- 장소 이미지
    CONSTRAINT fk_course_no FOREIGN KEY (place_no) REFERENCES COURSE(course_no)
);
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {
	private int placeNo;
	private int placeOrder;
	private int placeX;
	private int placeY;
	private String placeName;
	private String placeContent;
	private String placeImage;	
}
