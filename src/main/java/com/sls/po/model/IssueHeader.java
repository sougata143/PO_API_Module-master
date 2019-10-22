package com.sls.po.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity()
@Table(name = "SCM_ISSUE_HDR")

public class IssueHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ISSUE_HDR_SEQ")
	@SequenceGenerator(sequenceName = "SCM_ISSUE_HEADER_SEQ", allocationSize = 1, name = "ISSUE_HDR_SEQ")
	@Column(name = "ISSUE_NO")
	private long id;

	@Column(name = "ISSUE_TYPE")
	private String type;

	@Column(name = "ISSUE_STATUS")
	private String status;

	@Column(name = "USER_1")
	private String submitter;

	@Column(name = "FIN_YEAR")
	private String finnacialYear;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "ISSUE_DATE")
	private Date issueDate;

	@Column(name = "UNIT_ID")
	private String unitId;

	@Column(name = "DEPT_ID")
	private String deptId;

	@Column(name = "MOD_BY")
	private String lastModifiedUser;

	@Column(name = "MOD_ON")
	private Date lastModifiedDate;

	@Column(name = "GOOD_TYPE")
	private String goodType;

	@Column(name = "EXPCODE")
	private String expCode;

	@Column(name = "DEPTCOST")
	private String deptCost;

	@Column(name = "LOT_NO")
	private Long lotNo;

	public String getExpCode() {
		return expCode;
	}

	public void setExpCode(String expCode) {
		this.expCode = expCode;
	}

	public String getDeptCost() {
		return deptCost;
	}

	public void setDeptCost(String deptCost) {
		this.deptCost = deptCost;
	}

	public Long getLotNo() {
		return lotNo;
	}

	public void setLotNo(Long lotNo) {
		this.lotNo = lotNo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubmitter() {
		return submitter;
	}

	public void setSubmitter(String submitter) {
		this.submitter = submitter;
	}

	public String getFinnacialYear() {
		return finnacialYear;
	}

	public void setFinnacialYear(String finnacialYear) {
		this.finnacialYear = finnacialYear;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getLastModifiedUser() {
		return lastModifiedUser;
	}

	public void setLastModifiedUser(String lastModifiedUser) {
		this.lastModifiedUser = lastModifiedUser;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}

}
