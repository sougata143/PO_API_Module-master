package com.sls.po.vo;

import java.util.List;

import com.sls.po.model.IndentHeader;

public class IndentDetails {
	
	private IndentHeader indentHeader;
	private List<IndentVo> indentList;
	public IndentHeader getIndentHeader() {
		return indentHeader;
	}
	
	public void setIndentHeader(IndentHeader indentHeader) {
		this.indentHeader = indentHeader;
	}
	public List<IndentVo> getIndentList() {
		return indentList;
	}
	public void setIndentList(List<IndentVo> indentList) {
		this.indentList = indentList;
	}
	
	

}
