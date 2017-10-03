package com.capstone.deptmanager.quest.bean;

/**
 * DeptManager QuestBean
 * @author "dev.daehyoung"
 *
 */

// DTO
public class QuestBean {
	
	private String questNo;
	private String questTitle;
	private String questStart;
	private String questEnd;
	private String questContent;
	private String questType;
	
	public String getQuestNo() {
		return questNo;
	}
	public void setQuestNo(String questNo) {
		this.questNo = questNo;
	}
	public String getQuestTitle() {
		return questTitle;
	}
	public void setQuestTitle(String questTitle) {
		this.questTitle = questTitle;
	}
	public String getQuestStart() {
		return questStart;
	}
	public void setQuestStart(String questStart) {
		this.questStart = questStart;
	}
	public String getQuestEnd() {
		return questEnd;
	}
	public void setQuestEnd(String questEnd) {
		this.questEnd = questEnd;
	}
	public String getQuestContent() {
		return questContent;
	}
	public void setQuestContent(String questContent) {
		this.questContent = questContent;
	}
	public String getQuestType() {
		return questType;
	}
	public void setQuestType(String questType) {
		this.questType = questType;
	}
	
}
