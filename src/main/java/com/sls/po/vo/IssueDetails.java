package com.sls.po.vo;

import java.util.List;

import com.sls.po.model.Department;
import com.sls.po.model.IssueHeader;

public class IssueDetails {
	
	private IssueHeader issueHeader;
	private List<IssueLineItemVo> issuItemList;
	private Department department;
	public IssueHeader getIssueHeader() {
		return issueHeader;
	}
	public void setIssueHeader(IssueHeader issueHeader) {
		this.issueHeader = issueHeader;
	}
	public List<IssueLineItemVo> getIssuItemList() {
		return issuItemList;
	}
	public void setIssuItemList(List<IssueLineItemVo> issuItemList) {
		this.issuItemList = issuItemList;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	

}
