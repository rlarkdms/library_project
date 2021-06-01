package Data;

import java.time.LocalDateTime;

public class Notice {
	private Long notice_id;
	private String admin_id;
	private String notice_title;
	private LocalDateTime notice_date;
	private String notice_content;
	public Notice(String notice_title,String admin_id,LocalDateTime notice_date,String notice_content) {
		this.notice_title = notice_title;
		this.admin_id=admin_id;
		this.notice_date=notice_date;
		this.notice_content=notice_content;
		
	}
	public Long getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(Long notice_id) {
		this.notice_id = notice_id;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public LocalDateTime getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(LocalDateTime notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	
}
