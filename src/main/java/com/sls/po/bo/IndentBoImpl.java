package com.sls.po.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sls.po.dao.BillPassRepository;
import com.sls.po.dao.BrokerRepository;
import com.sls.po.dao.BrokerSupplierRepository;
import com.sls.po.dao.DebitCreditNoteDao;
import com.sls.po.dao.DebitCreditNoteRepository;
import com.sls.po.dao.DepartmentRepository;
import com.sls.po.dao.GateStoreEntryDtlRepository;
import com.sls.po.dao.GoodReceiveHeaderRepository;
import com.sls.po.dao.GoodReceiveItemRepository;
import com.sls.po.dao.IndentHeaderRepository;
import com.sls.po.dao.IndentHeaderTypeGRepository;
import com.sls.po.dao.IndentHeaderTypeHRepository;
import com.sls.po.dao.IndentHeaderTypeJRepository;
import com.sls.po.dao.IndentHeaderTypeMRepository;
import com.sls.po.dao.IndentHeaderTypeORepository;
import com.sls.po.dao.IndentHeaderTypePRepository;
import com.sls.po.dao.IndentHeaderTypeWRepository;
import com.sls.po.dao.IndentRepository;
import com.sls.po.dao.IssueHeaderRepository;
import com.sls.po.dao.IssueItemtRepository;
import com.sls.po.dao.IssueLineItemRepository;
import com.sls.po.dao.ItemGroupRepository;
import com.sls.po.dao.ItemRepository;
import com.sls.po.dao.JuteGRNEntryRepository;
import com.sls.po.dao.JuteGateEntryDtlRepository;
import com.sls.po.dao.JutePriceMasterRepository;
import com.sls.po.dao.LoginTokenRepository;
import com.sls.po.dao.MaterialEntryRepository;
import com.sls.po.dao.MaterialGoodReceiveHeaderRepository;
import com.sls.po.dao.MaterialGoodReceiveItemRepository;
import com.sls.po.dao.MaterialQualityCenterRepository;
import com.sls.po.dao.MukamJuteRepository;
import com.sls.po.dao.MukamRepository;
import com.sls.po.dao.MukamSupplierRepository;
import com.sls.po.dao.POHeaderRepository;
import com.sls.po.dao.POHeaderTypeGRepository;
import com.sls.po.dao.POHeaderTypeHRepository;
import com.sls.po.dao.POHeaderTypeJRepository;
import com.sls.po.dao.POHeaderTypeMRepository;
import com.sls.po.dao.POHeaderTypeORepository;
import com.sls.po.dao.POHeaderTypePRepository;
import com.sls.po.dao.POLineItemRepository;
import com.sls.po.dao.PhysicalStockRepository;
import com.sls.po.dao.QualityRepository;
import com.sls.po.dao.QuantityUnitRepository;
import com.sls.po.dao.ReportCounterRepository;
import com.sls.po.dao.ServiceBatchRepository;
import com.sls.po.dao.StoreGRNEntryRepository;
import com.sls.po.dao.StoreGoodReceiveHeaderRepository;
import com.sls.po.dao.StoreGoodReceiveItemRepository;
import com.sls.po.dao.SupplierIndentComponent;
import com.sls.po.dao.SupplierIndentNotificationRepository;
import com.sls.po.dao.SupplierIndentRepository;
import com.sls.po.dao.SupplierRepository;
import com.sls.po.dao.UserRepository;
import com.sls.po.dao.VehicleRepository;
import com.sls.po.model.BillPass;
import com.sls.po.model.Broker;
import com.sls.po.model.BrokerSupplierMap;
import com.sls.po.model.DebitCreditNotes;
import com.sls.po.model.Department;
import com.sls.po.model.GateStoreEntryRegDtl;
import com.sls.po.model.GoodReceiveHeader;
import com.sls.po.model.GoodReceiveLineItem;
import com.sls.po.model.Indent;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.IndentHeaderTypeG;
import com.sls.po.model.IndentHeaderTypeH;
import com.sls.po.model.IndentHeaderTypeJ;
import com.sls.po.model.IndentHeaderTypeM;
import com.sls.po.model.IndentHeaderTypeO;
import com.sls.po.model.IndentHeaderTypeP;
import com.sls.po.model.IndentHeaderTypeW;
import com.sls.po.model.IssueHeader;
import com.sls.po.model.IssueItem;
import com.sls.po.model.IssueLineItem;
import com.sls.po.model.Item;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.ItemTax;
import com.sls.po.model.JuteEntryHeader;
import com.sls.po.model.JuteGRNEntry;
import com.sls.po.model.JuteGateEntryDtl;
import com.sls.po.model.JutePriceMaster;
import com.sls.po.model.JuteQualityEntryHeader;
import com.sls.po.model.LoginToken;
import com.sls.po.model.MaterialGoodReceiveHeader;
import com.sls.po.model.MaterialGoodReceiveLineItem;
import com.sls.po.model.Mukam;
import com.sls.po.model.MukamSupplier;
import com.sls.po.model.POHeader;
import com.sls.po.model.POLineItem;
import com.sls.po.model.POTypeGHeader;
import com.sls.po.model.POTypeHHeader;
import com.sls.po.model.POTypeJHeader;
import com.sls.po.model.POTypeMHeader;
import com.sls.po.model.POTypeOHeader;
import com.sls.po.model.POTypePHeader;
import com.sls.po.model.PhysicalStock;
import com.sls.po.model.Quality;
import com.sls.po.model.QuantityUnit;
import com.sls.po.model.ReportCounter;
import com.sls.po.model.ServiceBatchType;
import com.sls.po.model.StoreGRNEntry;
import com.sls.po.model.StoreGoodReceiveHeader;
import com.sls.po.model.StoreGoodReceiveLineItem;
import com.sls.po.model.Supplier;
import com.sls.po.model.SupplierIndent;
import com.sls.po.model.SupplierIndentNotification;
import com.sls.po.model.User;
import com.sls.po.model.Vehicle;
import com.sls.po.vo.BillPassDTO;
import com.sls.po.vo.ChalanDTO;
import com.sls.po.vo.DebitCreditNotesVo;
import com.sls.po.vo.GoodReceiveDetails;
import com.sls.po.vo.GoodReceiveItemVo;
import com.sls.po.vo.IndentDetails;
import com.sls.po.vo.IndentVo;
import com.sls.po.vo.IssueDetails;
import com.sls.po.vo.IssueItemVo;
import com.sls.po.vo.IssueLineItemVo;
import com.sls.po.vo.ItemDTO;
import com.sls.po.vo.JuteEntryHeaderDTO;
import com.sls.po.vo.MaterialGoodReceiveDetails;
import com.sls.po.vo.MaterialGoodReceiveItemVo;
import com.sls.po.vo.POChalanDetails;
import com.sls.po.vo.PODetails;
import com.sls.po.vo.PoItemVo;
import com.sls.po.vo.StoreGRNEntryDTO;
import com.sls.po.vo.StoreGoodReceiveDetails;
import com.sls.po.vo.StoreGoodReceiveItemVo;
import com.sls.po.vo.SupplierIndentApprovalDTO;
import com.sls.po.vo.SupplierIndentVo;
import com.sls.po.vo.SupplierIndentVoMaster;
import com.sls.po.vo.SupplierRankVo;
import com.sls.po.vo.SupplierResponseIndentLineDTO;
import com.sls.po.vo.TotalValueDTO;

@Component
@Qualifier("indentBoObj")
@Transactional
public class IndentBoImpl implements IndentBo {

	@Autowired
	DataSource dataSource;
	
	@Autowired
	DebitCreditNoteDao drcrDao;

	@Autowired
	ItemGroupRepository itemGroupRepository;

	@Autowired
	ItemRepository itemRepository11;

	@Autowired
	QuantityUnitRepository quantityUnitRepository;

	@Autowired
	QualityRepository qualityRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	IndentHeaderRepository indentHeaderRepository;

	@Autowired
	IndentHeaderTypeGRepository indentHeaderTypeGRepository;

	@Autowired
	IndentHeaderTypePRepository indentHeaderTypePRepository;

	@Autowired
	IndentHeaderTypeORepository indentHeaderTypeORepository;

	@Autowired
	IndentHeaderTypeHRepository indentHeaderTypeHRepository;

	@Autowired
	IndentHeaderTypeMRepository indentHeaderTypeMRepository;

	@Autowired
	IndentHeaderTypeJRepository indentHeaderTypeJRepository;

	@Autowired
	IndentHeaderTypeWRepository indentHeaderTypeWRepository;

	@Autowired
	IndentRepository indentRepository;

	@Autowired
	JuteGRNEntryRepository juteentryhdrReposiotry;

	@Autowired
	StoreGRNEntryRepository storeentryhdrReposirtory;

	@Autowired
	GateStoreEntryDtlRepository storeentrydtlRepository;

	@Autowired
	JuteGateEntryDtlRepository juteentrydtlRepository;

	@Autowired
	SupplierIndentNotificationRepository supplierIndentNotificationRepository;

	@Autowired
	SupplierIndentRepository supplierIndentRepository;

	@Autowired
	SupplierRepository supplierRepository;

	@Autowired
	POHeaderRepository pOHeaderRepository;

	@Autowired
	POHeaderTypePRepository pOHeaderTypePRepository;

	@Autowired
	POHeaderTypeJRepository pOHeaderTypeJRepository;

	@Autowired
	POHeaderTypeGRepository pOHeaderTypeGRepository;

	@Autowired
	POHeaderTypeORepository pOHeaderTypeORepository;

	@Autowired
	POHeaderTypeHRepository pOHeaderTypeHRepository;

	@Autowired
	POHeaderTypeMRepository pOHeaderTypeMRepository;

	@Autowired
	POLineItemRepository pOLineItemRepository;

	@Autowired
	GoodReceiveHeaderRepository goodReceiveHeaderRepository;

	@Autowired
	GoodReceiveItemRepository goodReceiveItemRepository;

	@Autowired
	IssueItemtRepository issueItemtRepository;

	@Autowired
	PhysicalStockRepository physicalStockRepository;

	@Autowired
	LoginTokenRepository loginTokenRepository;

	@Autowired
	JutePriceMasterRepository jutePriceMasterRepository;

	@Autowired
	MaterialGoodReceiveHeaderRepository materialGoodReceiveHeaderRepository;

	@Autowired
	MaterialGoodReceiveItemRepository materialGoodReceiveItemRepository;

	@Autowired
	StoreGoodReceiveHeaderRepository storeGoodReceiveHeaderRepository;

	@Autowired
	StoreGoodReceiveItemRepository storeGoodReceiveItemRepository;

	@Autowired
	JuteGRNEntryRepository juteGRNEntryRepository;

	@Autowired
	StoreGRNEntryRepository storeGRNEntryRepository;

	@Autowired
	DebitCreditNoteRepository debitCreditNoteRepository;

	@Autowired
	BillPassRepository billPassRepository;

	@Autowired
	IssueHeaderRepository issueHeaderRepository;

	@Autowired
	IssueLineItemRepository issueLineItemRepository;

	@Autowired
	MukamRepository mukamRepository;

	@Autowired
	MukamJuteRepository mukamJuteRepository;

	@Autowired
	MukamSupplierRepository mukamSupplierRepository;

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	ReportCounterRepository reportCounterRepository;

	@Autowired
	MaterialEntryRepository materialEntryRepository;

	@Autowired
	MaterialQualityCenterRepository materialQualityCenterRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	BrokerRepository brokerRepository;

	@Autowired
	BrokerSupplierRepository brokerSupplierRepository;

	@Autowired
	ServiceBatchRepository serviceBatchRepository;

	@Autowired
	SupplierIndentComponent supplierindentDao;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	@Qualifier("itemBoObj")
	ItemBoImpl itemBoObj;

	@Override
	public List<IndentHeader> getAllIndent() {
		List<IndentHeader> list = new ArrayList<IndentHeader>();
		for (IndentHeader indentHeaderObj : indentHeaderRepository.findAll()) {
			list.add(indentHeaderObj);
		}
		return list.stream().sorted(Comparator.comparing(IndentHeader::getCreateDate).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public List<IndentHeader> getAllIndentByStatus(String status) {
		List<IndentHeader> list = new ArrayList<IndentHeader>();
		for (IndentHeader indentHeaderObj : indentHeaderRepository.findByStatus(status)) {
			list.add(indentHeaderObj);
		}
		return list.stream().sorted(Comparator.comparing(IndentHeader::getCreateDate).reversed())
				.collect(Collectors.toList());

	}

	@Override
	public List<IndentHeader> getAllIndentByMukam(String mukam) {
		List<IndentHeader> list = new ArrayList<IndentHeader>();
		for (IndentHeader indentHeaderObj : indentHeaderRepository.findByMukam(mukam)) {
			list.add(indentHeaderObj);
		}
		return list.stream().sorted(Comparator.comparing(IndentHeader::getCreateDate).reversed())
				.collect(Collectors.toList());

	}

	@Override
	public IndentDetails getIndentDetails(String indentId) {
		IndentDetails indentDetailsObj = new IndentDetails();
		IndentHeader indentHeaderObj = null;
		List<IndentVo> indentVoList = new ArrayList<IndentVo>();
		List<Indent> indentList = null;
		indentHeaderObj = indentHeaderRepository.findOne(indentId);
		indentList = indentRepository.findByIndentHeaderId(indentId);

		if (null != indentList) {

			for (Indent indentObj : indentList) {
				IndentVo indentVoObj = new IndentVo();
				indentVoObj.setStatus(indentObj.getStatus());
				indentVoObj.setIndentQuantity(indentObj.getIndentQuantity());
				indentVoObj.setIndentCancelledQuantity(indentObj.getIndentCancelledQuantity());
				indentVoObj.setStock(String.valueOf(indentObj.getStock()));
				indentVoObj.setSubmitter(indentHeaderObj.getSubmitter());
				indentVoObj.setIndentId(indentObj.getIndentHeaderId());
				indentVoObj.setIndentItemId(indentObj.getId());

				Department deptObj = departmentRepository.findOne(indentObj.getDeptId());
				indentVoObj.setDepartment(deptObj);

				ItemGroup itemGroupObj = itemGroupRepository.findOne(indentObj.getItemGroupId());
				indentVoObj.setItemGroup(itemGroupObj);

				Item itemObj = itemBoObj.getItemById(indentObj.getItemId());
				indentVoObj.setItem(itemObj);

				QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(indentObj.getUnitId());
				indentVoObj.setQuantityUnit(quantityUnitObj);

				Quality qualityObj = qualityRepository.findOne(indentObj.getQualityCode());
				if (null != qualityObj)
					indentVoObj.setQuality(qualityObj);

				if (null != indentObj.getMarka())
					indentVoObj.setMarka(indentObj.getMarka());

				if (null != indentObj.getApproverFirst())
					indentVoObj.setApproverFirst(indentObj.getApproverFirst());
				if (null != indentObj.getApproverSecond())
					indentVoObj.setApproverSecond(indentObj.getApproverSecond());
				if (null != indentObj.getApproveFirstDate())
					indentVoObj.setApproveFirstDate(indentObj.getApproveFirstDate());
				if (null != indentObj.getApproveSecondDate())
					indentVoObj.setApproveSecondDate(indentObj.getApproveSecondDate());

				if (null != indentObj.getAdditionalRequirement())
					indentVoObj.setAdditionalRequirement(indentObj.getAdditionalRequirement());

				indentVoList.add(indentVoObj);

			}

		}

		indentDetailsObj.setIndentHeader(indentHeaderObj);
		indentDetailsObj.setIndentList(indentVoList);

		return indentDetailsObj;
	}

	@Override
	public IndentDetails addIndent(IndentDetails indentDetails) {
		Indent indentObj = null;
		IndentHeader indentHeaderObj = null;
		List<IndentVo> indentVoList = new ArrayList<IndentVo>();
		IndentDetails indentDetailsObj = new IndentDetails();
		if (null != indentDetails.getIndentHeader()) {
			indentHeaderObj = indentDetails.getIndentHeader();
			indentHeaderObj.setCreateDate(new Date());
			if (indentHeaderObj.getType() != null && indentHeaderObj.getType().equalsIgnoreCase("G")) {
				IndentHeaderTypeG indentHeaderTypeGObj = getIndentHeaderTypeG(indentHeaderObj);
				indentHeaderTypeGObj = indentHeaderTypeGRepository.save(indentHeaderTypeGObj);
				indentHeaderObj = getIndentHeaderFromIndentHeaderTypeG(indentHeaderTypeGObj);
			} else if (indentHeaderObj.getType() != null && indentHeaderObj.getType().equalsIgnoreCase("P")) {
				IndentHeaderTypeP indentHeaderTypePObj = getIndentHeaderTypeP(indentHeaderObj);
				indentHeaderTypePObj = indentHeaderTypePRepository.save(indentHeaderTypePObj);
				indentHeaderObj = getIndentHeaderFromIndentHeaderTypeP(indentHeaderTypePObj);
			} else if (indentHeaderObj.getType() != null && indentHeaderObj.getType().equalsIgnoreCase("J")) {
				IndentHeaderTypeJ indentHeaderTypeJObj = getIndentHeaderTypeJ(indentHeaderObj);
				indentHeaderTypeJObj = indentHeaderTypeJRepository.save(indentHeaderTypeJObj);
				indentHeaderObj = getIndentHeaderFromIndentHeaderTypeJ(indentHeaderTypeJObj);
			} else if (indentHeaderObj.getType() != null && indentHeaderObj.getType().equalsIgnoreCase("M")) {
				IndentHeaderTypeM indentHeaderTypeMObj = getIndentHeaderTypeM(indentHeaderObj);
				indentHeaderTypeMObj = indentHeaderTypeMRepository.save(indentHeaderTypeMObj);
				indentHeaderObj = getIndentHeaderFromIndentHeaderTypeM(indentHeaderTypeMObj);
			} else if (indentHeaderObj.getType() != null && indentHeaderObj.getType().equalsIgnoreCase("O")) {
				IndentHeaderTypeO indentHeaderTypeOObj = getIndentHeaderTypeO(indentHeaderObj);
				indentHeaderTypeOObj = indentHeaderTypeORepository.save(indentHeaderTypeOObj);
				indentHeaderObj = getIndentHeaderFromIndentHeaderTypeO(indentHeaderTypeOObj);
			} else if (indentHeaderObj.getType() != null && indentHeaderObj.getType().equalsIgnoreCase("H")) {
				IndentHeaderTypeH indentHeaderTypeHObj = getIndentHeaderTypeH(indentHeaderObj);
				indentHeaderTypeHObj = indentHeaderTypeHRepository.save(indentHeaderTypeHObj);
				indentHeaderObj = getIndentHeaderFromIndentHeaderTypeH(indentHeaderTypeHObj);
			} else if (indentHeaderObj.getType() != null && indentHeaderObj.getType().equalsIgnoreCase("W")) {
				IndentHeaderTypeW indentHeaderTypeWObj = getIndentHeaderTypeW(indentHeaderObj);
				indentHeaderTypeWObj = indentHeaderTypeWRepository.save(indentHeaderTypeWObj);
				indentHeaderObj = getIndentHeaderFromIndentHeaderTypeW(indentHeaderTypeWObj);
			}

			// indentHeaderObj = indentHeaderRepository.save(indentHeaderObj);
			for (IndentVo indentVoObj : indentDetails.getIndentList()) {
				indentObj = new Indent();
				if (null != indentVoObj.getDepartment())
					indentObj.setDeptId(indentVoObj.getDepartment().getId());
				if (null != indentVoObj.getItemGroup())
					indentObj.setItemGroupId(indentVoObj.getItemGroup().getId());
				if (null != indentVoObj.getItem())
					indentObj.setItemId(indentVoObj.getItem().getId());
				if (null != indentVoObj.getQuantityUnit())
					indentObj.setUnitId(indentVoObj.getQuantityUnit().getId());

				if (null != indentVoObj.getQuality())
					indentObj.setQualityCode(indentVoObj.getQuality().getId());
				if (null != indentVoObj.getMarka())
					indentObj.setMarka(indentVoObj.getMarka());

				indentObj.setIndentCancelledQuantity(indentVoObj.getIndentCancelledQuantity());
				indentObj.setIndentHeaderId(indentHeaderObj.getId());
				indentObj.setIndentQuantity(indentVoObj.getIndentQuantity());
				indentObj.setStatus(indentVoObj.getStatus());
				indentObj.setStock(Float.parseFloat(indentVoObj.getStock()));
				indentObj.setType(indentHeaderObj.getType());
				indentObj.setAdditionalRequirement(indentVoObj.getAdditionalRequirement());
				indentObj = indentRepository.save(indentObj);
				indentVoObj.setSubmitter(indentHeaderObj.getSubmitter());
				indentVoObj.setIndentId(indentHeaderObj.getId());
				indentVoObj.setIndentItemId(indentObj.getId());
				indentVoList.add(indentVoObj);

			}
			indentDetailsObj.setIndentHeader(indentHeaderObj);
			indentDetailsObj.setIndentList(indentVoList);

		}
		return indentDetailsObj;
	}

	@Override
	public IndentDetails updateIndent(IndentDetails indentDetails) {
		Indent indentObj = null;
		IndentHeader indentHeaderObj = null;
		List<IndentVo> indentVoList = new ArrayList<IndentVo>();
		IndentDetails indentDetailsObj = new IndentDetails();
		if (null != indentDetails.getIndentHeader()) {
			indentHeaderObj = indentDetails.getIndentHeader();
			indentHeaderObj = indentHeaderRepository.save(indentHeaderObj);
			for (IndentVo indentVoObj : indentDetails.getIndentList()) {
				indentObj = new Indent();
				indentObj.setId(indentVoObj.getIndentItemId());
				if (null != indentVoObj.getDepartment())
					indentObj.setDeptId(indentVoObj.getDepartment().getId());
				if (null != indentVoObj.getItemGroup())
					indentObj.setItemGroupId(indentVoObj.getItemGroup().getId());
				if (null != indentVoObj.getItem())
					indentObj.setItemId(indentVoObj.getItem().getId());
				if (null != indentVoObj.getQuantityUnit())
					indentObj.setUnitId(indentVoObj.getQuantityUnit().getId());

				if (null != indentVoObj.getQuality())
					indentObj.setQualityCode(indentVoObj.getQuality().getId());
				if (null != indentVoObj.getMarka())
					indentObj.setMarka(indentVoObj.getMarka());

				indentObj.setIndentCancelledQuantity(indentVoObj.getIndentCancelledQuantity());
				indentObj.setIndentHeaderId(indentHeaderObj.getId());
				indentObj.setIndentQuantity(indentVoObj.getIndentQuantity());
				indentObj.setStatus(indentVoObj.getStatus());
				indentObj.setStock(Float.parseFloat(indentVoObj.getStock()));
				indentObj.setType(indentHeaderObj.getType());
				indentObj.setAdditionalRequirement(indentVoObj.getAdditionalRequirement());

				if (null != indentHeaderObj.getApproverFirst())
					indentObj.setApproverFirst(indentHeaderObj.getApproverFirst());
				if (null != indentHeaderObj.getApproverSecond())
					indentObj.setApproverSecond(indentHeaderObj.getApproverSecond());

				if (null != indentHeaderObj.getApproveFirstDate())
					indentObj.setApproveFirstDate(indentHeaderObj.getApproveFirstDate());
				if (null != indentHeaderObj.getApproveSecondDate())
					indentObj.setApproveSecondDate(indentHeaderObj.getApproveSecondDate());

				indentObj = indentRepository.save(indentObj);
				indentVoObj.setSubmitter(indentHeaderObj.getSubmitter());
				indentVoObj.setIndentId(indentHeaderObj.getId());
				indentVoObj.setIndentItemId(indentObj.getId());
				indentVoObj.setIndentQuantity(indentObj.getIndentQuantity());
				indentVoObj.setIndentCancelledQuantity(indentObj.getIndentCancelledQuantity());
				indentVoObj.setStatus(indentObj.getStatus());
				indentVoList.add(indentVoObj);

			}
			indentDetailsObj.setIndentHeader(indentHeaderObj);
			indentDetailsObj.setIndentList(indentVoList);

		}
		return indentDetailsObj;
	}

	@Override
	public List<SupplierIndentNotification> addSupplierIndentNotification(
			List<SupplierIndentNotification> supplierIndentNotificationList) {
		List<SupplierIndentNotification> resultList = new ArrayList<SupplierIndentNotification>();
		if (null != supplierIndentNotificationList) {
			for (SupplierIndentNotification obj : supplierIndentNotificationList) {
				obj = supplierIndentNotificationRepository.save(obj);
				resultList.add(obj);
			}
		}
		return resultList.stream().sorted(Comparator.comparing(SupplierIndentNotification::getIndentNo).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public List<Supplier> getRequestedSupplierListByIndent(String indentId) {
		List<Supplier> resultList = new ArrayList<Supplier>();
		Supplier supplierObj = null;
		for (SupplierIndentNotification obj : supplierIndentNotificationRepository.findByIndentNo(indentId)) {
			supplierObj = supplierRepository.findOne(obj.getSupplierCode());
			if (null != supplierObj)
				resultList.add(supplierObj);

		}
		return resultList.stream().sorted(Comparator.comparing(Supplier::getName)).collect(Collectors.toList());
	}

	@Override
	public List<SupplierIndentVo> addSupplierResponseIndentDetails(List<SupplierIndentVo> supplierIndentVoList) {
		SupplierIndent indentObj = null;
		IndentHeader headerObj = null;
		List<SupplierIndentVo> resultList = new ArrayList<SupplierIndentVo>();
		if (null != supplierIndentVoList) {
			for (SupplierIndentVo indentVoObj : supplierIndentVoList) {
				headerObj = indentHeaderRepository.findOne(indentVoObj.getIndentId());
				indentObj = new SupplierIndent();
				if (indentVoObj.getTransId() != 0)
					indentObj.setTransId(indentVoObj.getTransId());
				if (null != indentVoObj.getSupplier())
					indentObj.setSupplierCode(indentVoObj.getSupplier().getId());
				if (null != indentVoObj.getItemGroup())
					indentObj.setItemGroupId(indentVoObj.getItemGroup().getId());
				if (null != indentVoObj.getItem())
					indentObj.setItemId(indentVoObj.getItem().getId());
				if (null != indentVoObj.getQuantityUnit())
					indentObj.setUnitId(indentVoObj.getQuantityUnit().getId());
				if (null != indentVoObj.getQuality())
					indentObj.setQualityCode(indentVoObj.getQuality().getId());
				if (null != indentVoObj.getMarka())
					indentObj.setMarka(indentVoObj.getMarka());
				if (null != headerObj)
					indentObj.setType(headerObj.getType());

				indentObj.setIndentHeaderId(indentVoObj.getIndentId());
				indentObj.setId(indentVoObj.getIndentItemId());
				indentObj.setIndentQuantity(indentVoObj.getIndentQuantity());
				indentObj.setStatus(indentVoObj.getStatus());
				// indentObj.setType(indentVoObj.getType());
				indentObj.setRate(indentVoObj.getRate());
				indentObj.setSubmitter(indentVoObj.getSubmitter());
				indentObj.setCreateDate(indentVoObj.getCreateDate());
				indentObj.setFinnacialYear(indentVoObj.getFinnacialYear());

				if (null != indentVoObj.getApproverFirst())
					indentObj.setApproverFirst(indentVoObj.getApproverFirst());
				if (null != indentVoObj.getApproverSecond())
					indentObj.setApproverSecond(indentVoObj.getApproverSecond());
				if (null != indentVoObj.getApproveFirstDate())
					indentObj.setApproveFirstDate(indentVoObj.getApproveFirstDate());
				if (null != indentVoObj.getApproveSecondDate())
					indentObj.setApproveSecondDate(indentVoObj.getApproveSecondDate());

				indentObj = supplierIndentRepository.save(indentObj);
				indentVoObj.setTransId(indentObj.getTransId());
				resultList.add(indentVoObj);

			}

		}
		return supplierIndentVoList;
	}

	@Override
	public List<SupplierIndentVo> getSupplierResponseIndentDetailsBySupplierCode(String supplierCode) {
		SupplierIndentVo indentVoObj = null;
		List<SupplierIndentVo> supplierIndentVoList = new ArrayList<SupplierIndentVo>();
		List<SupplierIndent> supplierIndentList = null;
		supplierIndentList = supplierIndentRepository.findBySupplierCode(supplierCode);
		if (null != supplierIndentList) {
			for (SupplierIndent indentObj : supplierIndentList) {
				indentVoObj = new SupplierIndentVo();
				Supplier supplierObj = supplierRepository.findOne(indentObj.getSupplierCode());
				indentVoObj.setSupplier(supplierObj);
				ItemGroup itemGroupObj = itemGroupRepository.findOne(indentObj.getItemGroupId());
				indentVoObj.setItemGroup(itemGroupObj);
				Item itemObj = itemBoObj.getItemById(indentObj.getItemId());
				indentVoObj.setItem(itemObj);
				QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(indentObj.getUnitId());
				indentVoObj.setQuantityUnit(quantityUnitObj);

				Quality qualityObj = qualityRepository.findOne(indentObj.getQualityCode());
				if (null != qualityObj)
					indentVoObj.setQuality(qualityObj);

				if (null != indentObj.getMarka())
					indentVoObj.setMarka(indentObj.getMarka());

				indentVoObj.setIndentId(indentObj.getIndentHeaderId());
				indentVoObj.setIndentItemId(indentObj.getId());

				indentVoObj.setIndentQuantity(indentObj.getIndentQuantity());
				indentVoObj.setStatus(indentObj.getStatus());
				indentVoObj.setType(indentObj.getType());
				indentVoObj.setRate(indentObj.getRate());
				indentVoObj.setSubmitter(indentObj.getSubmitter());
				indentVoObj.setCreateDate(indentObj.getCreateDate());
				indentVoObj.setFinnacialYear(indentObj.getFinnacialYear());

				if (null != indentObj.getApproverFirst())
					indentVoObj.setApproverFirst(indentObj.getApproverFirst());
				if (null != indentObj.getApproverSecond())
					indentVoObj.setApproverSecond(indentObj.getApproverSecond());
				if (null != indentObj.getApproveFirstDate())
					indentVoObj.setApproveFirstDate(indentObj.getApproveFirstDate());
				if (null != indentObj.getApproveSecondDate())
					indentVoObj.setApproveSecondDate(indentObj.getApproveSecondDate());

				supplierIndentVoList.add(indentVoObj);

			}

		}
		return supplierIndentVoList;
	}

	@Override
	public List<String> getAllSupplierResponseIndentBySupplierCodeItemCode(String supplierCode, String itemCode) {

		List<String> supplierIndentVoList = new ArrayList<String>();
		List<SupplierIndent> supplierIndentList = null;
		List<POLineItem> poLineItemList = null;
		POLineItem poLineItemObj = null;
		supplierIndentList = supplierIndentRepository.findBySupplierCode(supplierCode);
		Map<String, String> indentIdMap = new HashMap<String, String>();

		Map<String, String> poIndentMap = new HashMap<String, String>();
		Map<String, POLineItem> poItemMap = new HashMap<String, POLineItem>();
		long qualityCode = 0;
		String poIndentItemKey = null;
		long suppResponseQualityCode = 0;
		String suppResponseIndentItemKey = null;

		if (null != supplierIndentList) {
			for (SupplierIndent supplierIndentObj : supplierIndentList) {
				if (!supplierIndentObj.getStatus().equalsIgnoreCase("5")) {
					if (supplierIndentObj.getItemId().equalsIgnoreCase(itemCode)) {
						if (null == poIndentMap.get(supplierIndentObj.getIndentHeaderId())) {
							poLineItemList = pOLineItemRepository.findByIndentId(supplierIndentObj.getIndentHeaderId());
							if (null != poLineItemList && poLineItemList.size() > 0) {
								for (POLineItem itemObj : poLineItemList) {
									if (itemObj.getQualityCode() != 0) {
										qualityCode = itemObj.getQualityCode();
									}
									poIndentItemKey = itemObj.getIndentId() + "-" + itemObj.getItemId() + "-"
											+ qualityCode;
									poItemMap.put(poIndentItemKey, itemObj);
								}
								poIndentMap.put(supplierIndentObj.getIndentHeaderId(),
										supplierIndentObj.getIndentHeaderId());
							}
						}

						if (supplierIndentObj.getQualityCode() != 0) {
							suppResponseQualityCode = supplierIndentObj.getQualityCode();
						}
						suppResponseIndentItemKey = supplierIndentObj.getIndentHeaderId() + "-"
								+ supplierIndentObj.getItemId() + "-" + suppResponseQualityCode;
						POLineItem obj = poItemMap.get(suppResponseIndentItemKey);
						if (null == obj) {
							if (null == indentIdMap.get(supplierIndentObj.getIndentHeaderId())) {
								indentIdMap.put(supplierIndentObj.getIndentHeaderId(),
										supplierIndentObj.getIndentHeaderId());
								supplierIndentVoList.add(supplierIndentObj.getIndentHeaderId());
							}
						} else {
							if (obj.getStatus() != null) {
								if (obj.getStatus().equalsIgnoreCase("4") || obj.getStatus().equalsIgnoreCase("6")) {
									if (null == indentIdMap.get(supplierIndentObj.getIndentHeaderId())) {
										indentIdMap.put(supplierIndentObj.getIndentHeaderId(),
												supplierIndentObj.getIndentHeaderId());
										supplierIndentVoList.add(supplierIndentObj.getIndentHeaderId());
									}
								}

							}

						}
					}

				}
			}

		}

		return supplierIndentVoList;
	}

	@Override
	public List<String> getAllSupplierResponseIndentIdsByPOType(String type) {

		List<String> supplierIndentVoList = new ArrayList<String>();
		List<SupplierIndent> supplierIndentList = null;
		List<SupplierIndent> openTypeSupplierIndentList = null;
		List<POLineItem> poLineItemList = null;
		POLineItem poLineItemObj = null;
		if (type != null && type.length() > 0) {
			supplierIndentList = supplierIndentRepository.findByType(type);
			if (type.equalsIgnoreCase("G")) {
				openTypeSupplierIndentList = supplierIndentRepository.findByType("O");
				if (openTypeSupplierIndentList != null && openTypeSupplierIndentList.size() > 0) {
					supplierIndentList.addAll(openTypeSupplierIndentList);
				}
			}
		}

		Map<String, String> indentIdMap = new HashMap<String, String>();

		Map<String, String> poIndentMap = new HashMap<String, String>();
		Map<String, POLineItem> poItemMap = new HashMap<String, POLineItem>();
		long qualityCode = 0;
		String poIndentItemKey = null;
		long suppResponseQualityCode = 0;
		String suppResponseIndentItemKey = null;

		if (null != supplierIndentList) {
			for (SupplierIndent supplierIndentObj : supplierIndentList) {
				IndentHeader indenthdr = indentHeaderRepository.findOne(supplierIndentObj.getIndentHeaderId());
				if (indenthdr.getStatus().equalsIgnoreCase("15")) {
					if (!supplierIndentObj.getStatus().equalsIgnoreCase("5")) {

						if (null == poIndentMap.get(supplierIndentObj.getIndentHeaderId())) {
							poLineItemList = pOLineItemRepository.findByIndentId(supplierIndentObj.getIndentHeaderId());
							if (null != poLineItemList && poLineItemList.size() > 0) {
								for (POLineItem itemObj : poLineItemList) {
									if (itemObj.getQualityCode() != 0) {
										qualityCode = itemObj.getQualityCode();
									}
									poIndentItemKey = itemObj.getIndentId() + "-" + itemObj.getItemId() + "-"
											+ qualityCode;
									poItemMap.put(poIndentItemKey, itemObj);
								}
								poIndentMap.put(supplierIndentObj.getIndentHeaderId(),
										supplierIndentObj.getIndentHeaderId());
							}
						}

						if (supplierIndentObj.getQualityCode() != 0) {
							suppResponseQualityCode = supplierIndentObj.getQualityCode();
						}
						suppResponseIndentItemKey = supplierIndentObj.getIndentHeaderId() + "-"
								+ supplierIndentObj.getItemId() + "-" + suppResponseQualityCode;
						POLineItem obj = poItemMap.get(suppResponseIndentItemKey);
						if (null == obj) {
							if (null == indentIdMap.get(supplierIndentObj.getIndentHeaderId())) {
								indentIdMap.put(supplierIndentObj.getIndentHeaderId(),
										supplierIndentObj.getIndentHeaderId());
								supplierIndentVoList.add(supplierIndentObj.getIndentHeaderId());
							}
						} else {
							if (obj.getStatus() != null) {
								if (obj.getStatus().equalsIgnoreCase("4") || obj.getStatus().equalsIgnoreCase("6")
										|| obj.getIndentId().startsWith("O")) {
									if (null == indentIdMap.get(supplierIndentObj.getIndentHeaderId())) {
										indentIdMap.put(supplierIndentObj.getIndentHeaderId(),
												supplierIndentObj.getIndentHeaderId());
										supplierIndentVoList.add(supplierIndentObj.getIndentHeaderId());
									}
								}

							}

						}

					}
				}

			}

		}

		return supplierIndentVoList;
	}

	@Override
	public List<Supplier> getAllIndentSupplier() {

		List<Supplier> supplierList = new ArrayList<Supplier>();
		Map<String, String> supplierIdMap = new HashMap<String, String>();
		Supplier supplierObj = null;
		for (SupplierIndent supplierIndentObj : supplierIndentRepository.findAll()) {
			if (!supplierIndentObj.getStatus().equalsIgnoreCase("5")) {
				if (null == supplierIdMap.get(supplierIndentObj.getSupplierCode())) {
					supplierObj = supplierRepository.findOne(supplierIndentObj.getSupplierCode());
					if (null != supplierObj) {
						supplierIdMap.put(supplierIndentObj.getSupplierCode(), supplierIndentObj.getSupplierCode());
						supplierList.add(supplierObj);
					}
				}
			}
		}
		return supplierList;
	}

	@Override
	public List<Supplier> getAllIndentSupplierByIndentType(String type) {

		List<Supplier> supplierList = new ArrayList<Supplier>();
		Map<String, String> supplierIdMap = new HashMap<String, String>();
		List<POLineItem> poLineItemList = null;
		POLineItem poLineItemObj = null;
		Supplier supplierObj = null;
		Map<String, String> poIndentMap = new HashMap<String, String>();
		Map<String, POLineItem> poItemMap = new HashMap<String, POLineItem>();
		long qualityCode = 0;
		String poIndentItemKey = null;
		long suppResponseQualityCode = 0;
		String suppResponseIndentItemKey = null;

		for (SupplierIndent supplierIndentObj : supplierIndentRepository.findByType(type)) {
			if (!supplierIndentObj.getStatus().equalsIgnoreCase("5")) {

				if (null == poIndentMap.get(supplierIndentObj.getIndentHeaderId())) {
					poLineItemList = pOLineItemRepository.findByIndentId(supplierIndentObj.getIndentHeaderId());
					if (null != poLineItemList && poLineItemList.size() > 0) {
						for (POLineItem itemObj : poLineItemList) {
							if (itemObj.getQualityCode() != 0) {
								qualityCode = itemObj.getQualityCode();
							}
							poIndentItemKey = itemObj.getIndentId() + "-" + itemObj.getItemId() + "-" + qualityCode;
							poItemMap.put(poIndentItemKey, itemObj);
						}
						poIndentMap.put(supplierIndentObj.getIndentHeaderId(), supplierIndentObj.getIndentHeaderId());
					}
				}

				if (supplierIndentObj.getQualityCode() != 0) {
					suppResponseQualityCode = supplierIndentObj.getQualityCode();
				}
				suppResponseIndentItemKey = supplierIndentObj.getIndentHeaderId() + "-" + supplierIndentObj.getItemId()
						+ "-" + suppResponseQualityCode;

				POLineItem obj = poItemMap.get(suppResponseIndentItemKey);
				if (null == obj) {
					if (null == supplierIdMap.get(supplierIndentObj.getSupplierCode())) {
						supplierObj = supplierRepository.findOne(supplierIndentObj.getSupplierCode());
						if (null != supplierObj) {
							supplierIdMap.put(supplierIndentObj.getSupplierCode(), supplierIndentObj.getSupplierCode());
							supplierList.add(supplierObj);
						}
					}
				} else {
					if (obj.getStatus() != null) {
						if (obj.getStatus().equalsIgnoreCase("4") || obj.getStatus().equalsIgnoreCase("6")) {
							if (null == supplierIdMap.get(supplierIndentObj.getSupplierCode())) {
								supplierObj = supplierRepository.findOne(supplierIndentObj.getSupplierCode());
								if (null != supplierObj) {
									supplierIdMap.put(supplierIndentObj.getSupplierCode(),
											supplierIndentObj.getSupplierCode());
									supplierList.add(supplierObj);
								}
							}

						}

					}

				}
			}
		}
		return supplierList;
	}

	@Override
	public List<Item> getAllItemsBySupplierCode(String supplierCode) {

		List<Item> supplierItemVoList = new ArrayList<Item>();
		List<SupplierIndent> supplierIndentList = null;
		List<POLineItem> poLineItemList = null;
		POLineItem poLineItemObj = null;
		supplierIndentList = supplierIndentRepository.findBySupplierCode(supplierCode);
		Map<String, Item> itemMap = new HashMap<String, Item>();
		Map<String, String> poIndentMap = new HashMap<String, String>();
		Map<String, POLineItem> poItemMap = new HashMap<String, POLineItem>();
		long qualityCode = 0;
		String poIndentItemKey = null;
		long suppResponseQualityCode = 0;
		String suppResponseIndentItemKey = null;
		if (null != supplierIndentList) {
			for (SupplierIndent supplierIndentObj : supplierIndentList) {
				if (!supplierIndentObj.getStatus().equalsIgnoreCase("5")) {

					if (null == poIndentMap.get(supplierIndentObj.getIndentHeaderId())) {
						poLineItemList = pOLineItemRepository.findByIndentId(supplierIndentObj.getIndentHeaderId());
						if (null != poLineItemList && poLineItemList.size() > 0) {
							for (POLineItem itemObj : poLineItemList) {
								if (itemObj.getQualityCode() != 0) {
									qualityCode = itemObj.getQualityCode();
								}
								poIndentItemKey = itemObj.getIndentId() + "-" + itemObj.getItemId() + "-" + qualityCode;
								poItemMap.put(poIndentItemKey, itemObj);
							}
							poIndentMap.put(supplierIndentObj.getIndentHeaderId(),
									supplierIndentObj.getIndentHeaderId());
						}
					}
					if (supplierIndentObj.getQualityCode() != 0) {
						suppResponseQualityCode = supplierIndentObj.getQualityCode();
					}
					suppResponseIndentItemKey = supplierIndentObj.getIndentHeaderId() + "-"
							+ supplierIndentObj.getItemId() + "-" + suppResponseQualityCode;

					POLineItem obj = poItemMap.get(suppResponseIndentItemKey);
					if (null == obj) {
						Item itemObj1 = itemBoObj.getItemById(supplierIndentObj.getItemId());
						if (itemObj1 != null) {
							if (null == itemMap.get(itemObj1.getId())) {
								itemMap.put(itemObj1.getId(), itemObj1);
								supplierItemVoList.add(itemObj1);
							}
						}
					} else {
						if (obj.getStatus() != null) {
							if (obj.getStatus().equalsIgnoreCase("4") || obj.getStatus().equalsIgnoreCase("6")) {
								Item itemObj1 = itemBoObj.getItemById(supplierIndentObj.getItemId());
								if (itemObj1 != null) {
									if (null == itemMap.get(itemObj1.getId())) {
										itemMap.put(itemObj1.getId(), itemObj1);
										supplierItemVoList.add(itemObj1);
									}
								}

							}

						}

					}

				}

			}

		}

		return supplierItemVoList.stream().sorted(Comparator.comparing(Item::getId).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public SupplierIndentVoMaster getSupplierResponseIndentDetailsByIndentId(String indentId) {
		SupplierIndentVoMaster supplierIndentVoMasterObj = new SupplierIndentVoMaster();
		SupplierIndentVo indentVoObj = null;
		List<SupplierIndentVo> supplierIndentVoList = new ArrayList<SupplierIndentVo>();
		List<SupplierIndent> supplierIndentList = null;
		Map<String, String> poIndentMap = new HashMap<String, String>();
		Map<String, POLineItem> poItemMap = new HashMap<String, POLineItem>();
		long qualityCode = 0;
		String poIndentItemKey = null;
		long suppResponseQualityCode = 0;
		String suppResponseIndentItemKey = null;
		List<POLineItem> poLineItemList = null;

		Map<String, Float> supplierIndentRateMap = new HashMap<String, Float>();
		Map<String, Long> supplierALLItemCountMap = new HashMap<String, Long>();
		Map<String, List<SupplierIndentVo>> supplierIndentRateDetailsMap1 = new HashMap<String, List<SupplierIndentVo>>();
		List<SupplierIndentVo> supplierIndentRateDetailsList = null;
		Map<String, String> indentAllItemCountMap = new HashMap<String, String>();
		Map<Long, List<String>> countwiseSuppliesrMap = new HashMap<Long, List<String>>();

		Map<String, Float> supplierItemRateMap = new HashMap<String, Float>();
		Map<String, Long> supplierSelectedItemCountMap = new HashMap<String, Long>();
		Map<String, List<SupplierIndentVo>> supplierItemRateDetailsMap = new HashMap<String, List<SupplierIndentVo>>();
		Map<String, String> indentSelectedItemCountMap = new HashMap<String, String>();
		Map<Long, List<String>> countwiseSelectedItemSuppliesrMap = new HashMap<Long, List<String>>();

		supplierIndentList = supplierIndentRepository.findByIndentHeaderId(indentId);
		if (null != supplierIndentList) {
			for (SupplierIndent indentObj : supplierIndentList) {

				indentAllItemCountMap.put(indentObj.getItemId(), indentObj.getItemId());

				if (supplierALLItemCountMap.get(indentObj.getSupplierCode()) == null) {
					long count = 1;
					supplierALLItemCountMap.put(indentObj.getSupplierCode(), count);
					if (countwiseSuppliesrMap.get(count) == null) {
						List<String> list = new ArrayList<String>();
						list.add(indentObj.getSupplierCode());
						countwiseSuppliesrMap.put(count, list);
					} else {
						List<String> list = countwiseSuppliesrMap.get(count);
						list.add(indentObj.getSupplierCode());
						countwiseSuppliesrMap.put(count, list);
					}

				} else {
					long count = supplierALLItemCountMap.get(indentObj.getSupplierCode());
					count++;
					supplierALLItemCountMap.put(indentObj.getSupplierCode(), count);
					if (countwiseSuppliesrMap.get(count) == null) {
						List<String> list = new ArrayList<String>();
						list.add(indentObj.getSupplierCode());
						countwiseSuppliesrMap.put(count, list);
					} else {
						List<String> list = countwiseSuppliesrMap.get(count);
						list.add(indentObj.getSupplierCode());
						countwiseSuppliesrMap.put(count, list);
					}
				}

				if (supplierIndentRateDetailsMap1.get(indentObj.getSupplierCode()) == null) {
					supplierIndentRateDetailsList = new ArrayList<SupplierIndentVo>();
					supplierIndentRateDetailsList.add(getSupplierIndentVo(indentObj));
					supplierIndentRateDetailsMap1.put(indentObj.getSupplierCode(), supplierIndentRateDetailsList);
				} else {
					supplierIndentRateDetailsList = supplierIndentRateDetailsMap1.get(indentObj.getSupplierCode());
					supplierIndentRateDetailsList.add(getSupplierIndentVo(indentObj));
					supplierIndentRateDetailsMap1.put(indentObj.getSupplierCode(), supplierIndentRateDetailsList);
				}

				if (supplierIndentRateMap.get(indentObj.getSupplierCode()) == null) {
					float totalPrice = indentObj.getIndentQuantity() * indentObj.getRate();
					supplierIndentRateMap.put(indentObj.getSupplierCode(), totalPrice);
				} else {
					float totalPrice = supplierIndentRateMap.get(indentObj.getSupplierCode());
					totalPrice = totalPrice + (indentObj.getIndentQuantity() * indentObj.getRate());
					supplierIndentRateMap.put(indentObj.getSupplierCode(), totalPrice);
				}

				if (null == poIndentMap.get(indentObj.getIndentHeaderId())) {
					poLineItemList = pOLineItemRepository.findByIndentId(indentObj.getIndentHeaderId());
					if (null != poLineItemList && poLineItemList.size() > 0) {
						for (POLineItem itemObj : poLineItemList) {
							if (itemObj.getQualityCode() != 0) {
								qualityCode = itemObj.getQualityCode();
							}
							poIndentItemKey = itemObj.getIndentId() + "-" + itemObj.getItemId() + "-" + qualityCode;
							poItemMap.put(poIndentItemKey, itemObj);
						}
						poIndentMap.put(indentObj.getIndentHeaderId(), indentObj.getIndentHeaderId());
					}
				}
				if (indentObj.getQualityCode() != 0) {
					suppResponseQualityCode = indentObj.getQualityCode();
				}
				suppResponseIndentItemKey = indentObj.getIndentHeaderId() + "-" + indentObj.getItemId() + "-"
						+ suppResponseQualityCode;
				POLineItem obj = poItemMap.get(suppResponseIndentItemKey);
				boolean addFlag = false;
				if (null == obj) {
					addFlag = true;
				} else {
					if (obj.getStatus() != null) {
						if (obj.getStatus().equalsIgnoreCase("4") || obj.getStatus().equalsIgnoreCase("6")
								|| obj.getIndentId().startsWith("O")) {
							addFlag = true;
						}
					}
				}
				if (addFlag) {
					if (indentSelectedItemCountMap.get(indentObj.getItemId()) == null) {
						indentVoObj = getSupplierIndentVo(indentObj);
						supplierIndentVoList.add(indentVoObj);
						indentSelectedItemCountMap.put(indentObj.getItemId(), indentObj.getItemId());
					}

					if (supplierSelectedItemCountMap.get(indentObj.getSupplierCode()) == null) {
						long count = 1;
						supplierSelectedItemCountMap.put(indentObj.getSupplierCode(), count);
						if (countwiseSelectedItemSuppliesrMap.get(count) == null) {
							List<String> list = new ArrayList<String>();
							list.add(indentObj.getSupplierCode());
							countwiseSelectedItemSuppliesrMap.put(count, list);
						} else {
							List<String> list = countwiseSelectedItemSuppliesrMap.get(count);
							list.add(indentObj.getSupplierCode());
							countwiseSelectedItemSuppliesrMap.put(count, list);
						}

					} else {
						long count = supplierSelectedItemCountMap.get(indentObj.getSupplierCode());
						count++;
						supplierSelectedItemCountMap.put(indentObj.getSupplierCode(), count);
						if (countwiseSelectedItemSuppliesrMap.get(count) == null) {
							List<String> list = new ArrayList<String>();
							list.add(indentObj.getSupplierCode());
							countwiseSelectedItemSuppliesrMap.put(count, list);
						} else {
							List<String> list = countwiseSelectedItemSuppliesrMap.get(count);
							list.add(indentObj.getSupplierCode());
							countwiseSelectedItemSuppliesrMap.put(count, list);
						}
					}

					if (supplierItemRateDetailsMap.get(indentObj.getSupplierCode()) == null) {
						List<SupplierIndentVo> list = new ArrayList<SupplierIndentVo>();
						list.add(getSupplierIndentVo(indentObj));
						supplierItemRateDetailsMap.put(indentObj.getSupplierCode(), list);
					} else {
						List<SupplierIndentVo> list = supplierItemRateDetailsMap.get(indentObj.getSupplierCode());
						list.add(getSupplierIndentVo(indentObj));
						supplierItemRateDetailsMap.put(indentObj.getSupplierCode(), list);
					}

					if (supplierItemRateMap.get(indentObj.getSupplierCode()) == null) {
						float totalPrice = indentObj.getIndentQuantity() * indentObj.getRate();
						supplierItemRateMap.put(indentObj.getSupplierCode(), totalPrice);
					} else {
						float totalPrice = supplierItemRateMap.get(indentObj.getSupplierCode());
						totalPrice = totalPrice + (indentObj.getIndentQuantity() * indentObj.getRate());
						supplierItemRateMap.put(indentObj.getSupplierCode(), totalPrice);
					}

				}

			}

		}
		List<SupplierRankVo> SortedSupplierListForAllIndentItems = getSortedSupplierListForAllIndentItems(
				supplierIndentRateMap, supplierALLItemCountMap, supplierIndentRateDetailsMap1, indentAllItemCountMap,
				countwiseSuppliesrMap);
		List<SupplierRankVo> SortedSupplierListForSelectedIndentItems = getSortedSupplierListForSelectedIndentItems(
				supplierItemRateMap, supplierSelectedItemCountMap, supplierItemRateDetailsMap,
				indentSelectedItemCountMap, countwiseSelectedItemSuppliesrMap);
		supplierIndentVoMasterObj.setSupplierIndentVoList(supplierIndentVoList);
		supplierIndentVoMasterObj.setSortedIndentSuppliers(SortedSupplierListForAllIndentItems);
		supplierIndentVoMasterObj.setSortedIndentItemSuppliers(SortedSupplierListForSelectedIndentItems);

		return supplierIndentVoMasterObj;
	}

	@Override
	public List<SupplierIndentVo> getSupplierResponseIndentDetailsByIds(String supplierCode, String itemCode,
			String indentId) {
		SupplierIndentVo indentVoObj = null;
		List<SupplierIndentVo> supplierIndentVoList = new ArrayList<SupplierIndentVo>();
		List<SupplierIndent> supplierIndentList = null;
		Map<String, String> poIndentMap = new HashMap<String, String>();
		Map<String, POLineItem> poItemMap = new HashMap<String, POLineItem>();
		long qualityCode = 0;
		String poIndentItemKey = null;
		long suppResponseQualityCode = 0;
		String suppResponseIndentItemKey = null;
		List<POLineItem> poLineItemList = null;
		supplierIndentList = supplierIndentRepository.findByIndentHeaderId(indentId);
		if (null != supplierIndentList) {
			for (SupplierIndent indentObj : supplierIndentList) {
				if (indentObj.getSupplierCode().equals(supplierCode)) {
					if (indentObj.getItemId().equals(itemCode)) {

						if (null == poIndentMap.get(indentObj.getIndentHeaderId())) {
							poLineItemList = pOLineItemRepository.findByIndentId(indentObj.getIndentHeaderId());
							if (null != poLineItemList && poLineItemList.size() > 0) {
								for (POLineItem itemObj : poLineItemList) {
									if (itemObj.getQualityCode() != 0) {
										qualityCode = itemObj.getQualityCode();
									}
									poIndentItemKey = itemObj.getIndentId() + "-" + itemObj.getItemId() + "-"
											+ qualityCode;
									poItemMap.put(poIndentItemKey, itemObj);
								}
								poIndentMap.put(indentObj.getIndentHeaderId(), indentObj.getIndentHeaderId());
							}
						}
						if (indentObj.getQualityCode() != 0) {
							suppResponseQualityCode = indentObj.getQualityCode();
						}
						suppResponseIndentItemKey = indentObj.getIndentHeaderId() + "-" + indentObj.getItemId() + "-"
								+ suppResponseQualityCode;
						POLineItem obj = poItemMap.get(suppResponseIndentItemKey);
						if (null == obj) {
							indentVoObj = new SupplierIndentVo();
							Supplier supplierObj = supplierRepository.findOne(indentObj.getSupplierCode());
							indentVoObj.setSupplier(supplierObj);
							ItemGroup itemGroupObj = itemGroupRepository.findOne(indentObj.getItemGroupId());
							indentVoObj.setItemGroup(itemGroupObj);
							Item itemObj = itemBoObj.getItemById(indentObj.getItemId());
							indentVoObj.setItem(itemObj);
							QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(indentObj.getUnitId());
							indentVoObj.setQuantityUnit(quantityUnitObj);

							Quality qualityObj = qualityRepository.findOne(indentObj.getQualityCode());
							if (null != qualityObj)
								indentVoObj.setQuality(qualityObj);

							if (null != indentObj.getMarka())
								indentVoObj.setMarka(indentObj.getMarka());

							indentVoObj.setIndentId(indentObj.getIndentHeaderId());
							indentVoObj.setIndentItemId(indentObj.getId());

							indentVoObj.setIndentQuantity(indentObj.getIndentQuantity());
							indentVoObj.setStatus(indentObj.getStatus());
							indentVoObj.setType(indentObj.getType());
							indentVoObj.setRate(indentObj.getRate());
							indentVoObj.setSubmitter(indentObj.getSubmitter());
							indentVoObj.setCreateDate(indentObj.getCreateDate());
							indentVoObj.setFinnacialYear(indentObj.getFinnacialYear());

							if (null != indentObj.getApproverFirst())
								indentVoObj.setApproverFirst(indentObj.getApproverFirst());
							if (null != indentObj.getApproverSecond())
								indentVoObj.setApproverSecond(indentObj.getApproverSecond());
							if (null != indentObj.getApproveFirstDate())
								indentVoObj.setApproveFirstDate(indentObj.getApproveFirstDate());
							if (null != indentObj.getApproveSecondDate())
								indentVoObj.setApproveSecondDate(indentObj.getApproveSecondDate());

							supplierIndentVoList.add(indentVoObj);

						} else {
							if (obj.getStatus() != null) {
								if (obj.getStatus().equalsIgnoreCase("4") || obj.getStatus().equalsIgnoreCase("6")) {
									indentVoObj = new SupplierIndentVo();
									Supplier supplierObj = supplierRepository.findOne(indentObj.getSupplierCode());
									indentVoObj.setSupplier(supplierObj);
									ItemGroup itemGroupObj = itemGroupRepository.findOne(indentObj.getItemGroupId());
									indentVoObj.setItemGroup(itemGroupObj);
									Item itemObj = itemBoObj.getItemById(indentObj.getItemId());
									indentVoObj.setItem(itemObj);
									QuantityUnit quantityUnitObj = quantityUnitRepository
											.findOne(indentObj.getUnitId());
									indentVoObj.setQuantityUnit(quantityUnitObj);

									Quality qualityObj = qualityRepository.findOne(indentObj.getQualityCode());
									if (null != qualityObj)
										indentVoObj.setQuality(qualityObj);

									if (null != indentObj.getMarka())
										indentVoObj.setMarka(indentObj.getMarka());

									indentVoObj.setIndentId(indentObj.getIndentHeaderId());
									indentVoObj.setIndentItemId(indentObj.getId());

									indentVoObj.setIndentQuantity(indentObj.getIndentQuantity());
									indentVoObj.setStatus(indentObj.getStatus());
									indentVoObj.setType(indentObj.getType());
									indentVoObj.setRate(indentObj.getRate());
									indentVoObj.setSubmitter(indentObj.getSubmitter());
									indentVoObj.setCreateDate(indentObj.getCreateDate());
									indentVoObj.setFinnacialYear(indentObj.getFinnacialYear());

									if (null != indentObj.getApproverFirst())
										indentVoObj.setApproverFirst(indentObj.getApproverFirst());
									if (null != indentObj.getApproverSecond())
										indentVoObj.setApproverSecond(indentObj.getApproverSecond());
									if (null != indentObj.getApproveFirstDate())
										indentVoObj.setApproveFirstDate(indentObj.getApproveFirstDate());
									if (null != indentObj.getApproveSecondDate())
										indentVoObj.setApproveSecondDate(indentObj.getApproveSecondDate());

									supplierIndentVoList.add(indentVoObj);
								}
							}

						}
					}
				}

			}

		}
		return supplierIndentVoList;
	}

	@Override
	public List<SupplierIndentVo> getSelectedSupplierResponseIndentDetailsByIds(String supplierCode, String indentId) {
		SupplierIndentVo indentVoObj = null;
		List<SupplierIndentVo> supplierIndentVoList = new ArrayList<SupplierIndentVo>();
		List<SupplierIndent> supplierIndentList = null;
		Map<String, String> poIndentMap = new HashMap<String, String>();
		Map<String, POLineItem> poItemMap = new HashMap<String, POLineItem>();
		long qualityCode = 0;
		String poIndentItemKey = null;
		long suppResponseQualityCode = 0;
		String suppResponseIndentItemKey = null;
		List<POLineItem> poLineItemList = null;
		supplierIndentList = supplierIndentRepository.findByIndentHeaderId(indentId);
		if (null != supplierIndentList) {
			for (SupplierIndent indentObj : supplierIndentList) {
				if (indentObj.getSupplierCode().equals(supplierCode)) {

					if (null == poIndentMap.get(indentObj.getIndentHeaderId())) {
						poLineItemList = pOLineItemRepository.findByIndentId(indentObj.getIndentHeaderId());
						if (null != poLineItemList && poLineItemList.size() > 0) {
							for (POLineItem itemObj : poLineItemList) {
								if (itemObj.getQualityCode() != 0) {
									qualityCode = itemObj.getQualityCode();
								}
								poIndentItemKey = itemObj.getIndentId() + "-" + itemObj.getItemId() + "-" + qualityCode;
								poItemMap.put(poIndentItemKey, itemObj);
							}
							poIndentMap.put(indentObj.getIndentHeaderId(), indentObj.getIndentHeaderId());
						}
					}
					if (indentObj.getQualityCode() != 0) {
						suppResponseQualityCode = indentObj.getQualityCode();
					}
					suppResponseIndentItemKey = indentObj.getIndentHeaderId() + "-" + indentObj.getItemId() + "-"
							+ suppResponseQualityCode;
					POLineItem obj = poItemMap.get(suppResponseIndentItemKey);
					if (null == obj) {
						indentVoObj = getSupplierIndentVo(indentObj);
						supplierIndentVoList.add(indentVoObj);

					} else {
						if (obj.getStatus() != null) {
							if (obj.getStatus().equalsIgnoreCase("4") || obj.getStatus().equalsIgnoreCase("6")) {
								indentVoObj = getSupplierIndentVo(indentObj);
								supplierIndentVoList.add(indentVoObj);
							}
						}
					}
				}
			}
		}
		return supplierIndentVoList;
	}

	@Override
	public List<SupplierIndentVo> getAllSupplierResponseIndentDetailsByIds(String supplierCode, String indentId) {
		SupplierIndentVo indentVoObj = null;
		List<SupplierIndentVo> supplierIndentVoList = new ArrayList<SupplierIndentVo>();
		List<SupplierIndent> supplierIndentList = null;
		supplierIndentList = supplierIndentRepository.findByIndentHeaderId(indentId);
		if (null != supplierIndentList) {
			for (SupplierIndent indentObj : supplierIndentList) {
				if (indentObj.getSupplierCode().equals(supplierCode)) {
					indentVoObj = getSupplierIndentVo(indentObj);
					supplierIndentVoList.add(indentVoObj);
				}
			}
		}
		return supplierIndentVoList;
	}

	@Override
	public PODetails addPODetails(PODetails poDetails) {
		POLineItem itemObj = null;
		POHeader headerObj = null;
		List<PoItemVo> poItemVoList = new ArrayList<PoItemVo>();
		PODetails poDetailsObj = new PODetails();
		if (null != poDetails.getPoHeader()) {
			headerObj = poDetails.getPoHeader();
			if (headerObj != null && headerObj.getType().equalsIgnoreCase("G")) {
				POTypeGHeader obj = pOHeaderTypeGRepository.save(getPOTypeGHeader(headerObj));
				headerObj = getPOHeaderFromPOTypeGHeader(obj);
			} else if (headerObj != null && headerObj.getType().equalsIgnoreCase("P")) {
				POTypePHeader obj = pOHeaderTypePRepository.save(getPOTypePHeader(headerObj));
				headerObj = getPOHeaderFromPOTypePHeader(obj);
			} else if (headerObj != null && headerObj.getType().equalsIgnoreCase("J")) {
				POTypeJHeader obj = pOHeaderTypeJRepository.save(getPOTypeJHeader(headerObj));
				headerObj = getPOHeaderFromPOTypeJHeader(obj);
			} else if (headerObj != null && headerObj.getType().equalsIgnoreCase("H")) {
				POTypeHHeader obj = pOHeaderTypeHRepository.save(getPOTypeHHeader(headerObj));
				headerObj = getPOHeaderFromPOTypeHHeader(obj);
			} else if (headerObj != null && headerObj.getType().equalsIgnoreCase("M")) {
				POTypeMHeader obj = pOHeaderTypeMRepository.save(getPOTypeMHeader(headerObj));
				headerObj = getPOHeaderFromPOTypeMHeader(obj);
			} else if (headerObj != null && headerObj.getType().equalsIgnoreCase("O")) {
				POTypeOHeader obj = pOHeaderTypeORepository.save(getPOTypeOHeader(headerObj));
				headerObj = getPOHeaderFromPOTypeOHeader(obj);
			}
			// headerObj = pOHeaderRepository.save(headerObj);

			for (PoItemVo poItemVoObj : poDetails.getPoItemList()) {
				itemObj = new POLineItem();
				if (null != poItemVoObj.getItemGroup())
					itemObj.setItemGroupId(poItemVoObj.getItemGroup().getId());
				if (null != poItemVoObj.getItem())
					itemObj.setItemId(poItemVoObj.getItem().getId());
				if (null != poItemVoObj.getQuantityUnit())
					itemObj.setUnitId(poItemVoObj.getQuantityUnit().getId());
				if (null != poItemVoObj.getQuality())
					itemObj.setQualityCode(poItemVoObj.getQuality().getId());
				if (null != poItemVoObj.getMarka())
					itemObj.setMarka(poItemVoObj.getMarka());

				if (null != poItemVoObj.getStatus())
					itemObj.setStatus(poItemVoObj.getStatus());

				if (null != poItemVoObj.getUnitConversionType()) {
					if (poItemVoObj.getUnitConversionType().equalsIgnoreCase("LOOSE")) {
						itemObj.setLoose(poItemVoObj.getConversionQuantity());
					} else if (poItemVoObj.getUnitConversionType().equalsIgnoreCase("BALE")) {
						itemObj.setBale(poItemVoObj.getConversionQuantity());
					}

				}

				String indentId = poItemVoObj.getIndentId();
				if (indentId != null && indentId.startsWith("O")) {
					IndentHeader indent = indentHeaderRepository.findOne(indentId);
					indent.setStatus("15");
					indentHeaderRepository.save(indent);
				}

				itemObj.setPoId(headerObj.getId());
				itemObj.setIndentId(poItemVoObj.getIndentId());
				itemObj.setType(poItemVoObj.getType());

				itemObj.setQuantity(poItemVoObj.getPoQuantity());
				itemObj.setActualQuantity(poItemVoObj.getPoActualQuantity());
				itemObj.setRate(poItemVoObj.getRate());
				itemObj.setTax(poItemVoObj.getTax());
				itemObj.setValueWithTax(poItemVoObj.getValueWithTax());
				itemObj.setValueWithoutTax(poItemVoObj.getValueWithoutTax());
				itemObj.setAllowableMoisturePercentage(poItemVoObj.getAllowableMoisturePercentage());

				if (null != poItemVoObj.getApproverFirst())
					itemObj.setApproverFirst(poItemVoObj.getApproverFirst());
				if (null != poItemVoObj.getApproverSecond())
					itemObj.setApproverSecond(poItemVoObj.getApproverSecond());
				if (null != poItemVoObj.getApproveFirstDate())
					itemObj.setApproveFirstDate(poItemVoObj.getApproveFirstDate());
				if (null != poItemVoObj.getApproveSecondDate())
					itemObj.setApproveSecondDate(poItemVoObj.getApproveSecondDate());

				itemObj.setDiscount(poItemVoObj.getDiscount());

				itemObj = pOLineItemRepository.save(itemObj);

				poItemVoObj.setPoItemId(itemObj.getId());
				poItemVoObj.setPoId(headerObj.getId());
				poItemVoList.add(poItemVoObj);
			}
			poDetailsObj.setPoHeader(headerObj);
			poDetailsObj.setPoItemList(poItemVoList);
		}
		return poDetailsObj;
	}

	@Override
	public PODetails updatePODetails(PODetails poDetails) {
		POLineItem itemObj = null;
		POHeader headerObj = null;
		List<PoItemVo> poItemVoList = new ArrayList<PoItemVo>();
		PODetails poDetailsObj = new PODetails();
		if (null != poDetails.getPoHeader()) {
			headerObj = poDetails.getPoHeader();
			headerObj = pOHeaderRepository.save(headerObj);

			for (PoItemVo poItemVoObj : poDetails.getPoItemList()) {
				itemObj = new POLineItem();
				itemObj.setId(poItemVoObj.getPoItemId());
				if (null != poItemVoObj.getItemGroup())
					itemObj.setItemGroupId(poItemVoObj.getItemGroup().getId());
				if (null != poItemVoObj.getItem())
					itemObj.setItemId(poItemVoObj.getItem().getId());
				if (null != poItemVoObj.getQuantityUnit())
					itemObj.setUnitId(poItemVoObj.getQuantityUnit().getId());
				if (null != poItemVoObj.getQuality())
					itemObj.setQualityCode(poItemVoObj.getQuality().getId());
				if (null != poItemVoObj.getMarka())
					itemObj.setMarka(poItemVoObj.getMarka());

				if (null != poItemVoObj.getUnitConversionType()) {
					if (poItemVoObj.getUnitConversionType().equalsIgnoreCase("LOOSE")) {
						itemObj.setLoose(poItemVoObj.getConversionQuantity());
					} else if (poItemVoObj.getUnitConversionType().equalsIgnoreCase("BALE")) {
						itemObj.setBale(poItemVoObj.getConversionQuantity());
					}

				}

				itemObj.setStatus(poItemVoObj.getStatus());
				itemObj.setDiscount(poItemVoObj.getDiscount());
				itemObj.setPoId(headerObj.getId());
				itemObj.setIndentId(poItemVoObj.getIndentId());
				itemObj.setType(poItemVoObj.getType());

				itemObj.setQuantity(poItemVoObj.getPoQuantity());
				itemObj.setActualQuantity(poItemVoObj.getPoActualQuantity());
				itemObj.setRate(poItemVoObj.getRate());
				itemObj.setTax(poItemVoObj.getTax());
				itemObj.setValueWithTax(poItemVoObj.getValueWithTax());
				itemObj.setValueWithoutTax(poItemVoObj.getValueWithoutTax());
				itemObj.setAllowableMoisturePercentage(poItemVoObj.getAllowableMoisturePercentage());

				if (null != poItemVoObj.getApproverFirst())
					itemObj.setApproverFirst(poItemVoObj.getApproverFirst());
				if (null != poItemVoObj.getApproverSecond())
					itemObj.setApproverSecond(poItemVoObj.getApproverSecond());
				if (null != poItemVoObj.getApproveFirstDate())
					itemObj.setApproveFirstDate(poItemVoObj.getApproveFirstDate());
				if (null != poItemVoObj.getApproveSecondDate())
					itemObj.setApproveSecondDate(poItemVoObj.getApproveSecondDate());

				itemObj = pOLineItemRepository.save(itemObj);
				poItemVoObj.setPoItemId(itemObj.getId());
				poItemVoObj.setPoId(headerObj.getId());
				poItemVoList.add(poItemVoObj);
			}
			poDetailsObj.setPoHeader(headerObj);
			poDetailsObj.setPoItemList(poItemVoList);
		}
		return poDetailsObj;
	}

	@Override
	public PODetails getPODetails(String poId) {
		PODetails poDetailsObj = new PODetails();
		POHeader headerObj = null;
		List<PoItemVo> poItemVoList = new ArrayList<PoItemVo>();
		List<POLineItem> poLineItemList = null;
		headerObj = pOHeaderRepository.findOne(poId);
		poLineItemList = pOLineItemRepository.findByPoId(poId);

		if (null != poLineItemList) {

			for (POLineItem itemObj : poLineItemList) {
				PoItemVo voObj = new PoItemVo();
				voObj.setPoItemId(itemObj.getId());
				voObj.setPoId(headerObj.getId());
				voObj.setStatus(itemObj.getStatus());
				voObj.setIndentId(itemObj.getIndentId());
				voObj.setType(itemObj.getType());
				voObj.setPoQuantity(itemObj.getQuantity());
				voObj.setPoActualQuantity(itemObj.getActualQuantity());
				voObj.setRate(itemObj.getRate());
				voObj.setTax(itemObj.getTax());
				voObj.setValueWithTax(itemObj.getValueWithTax());
				voObj.setValueWithoutTax(itemObj.getValueWithoutTax());
				voObj.setDiscount(itemObj.getDiscount());
				voObj.setAllowableMoisturePercentage(itemObj.getAllowableMoisturePercentage());
				if (itemObj.getBale() > 0) {
					voObj.setUnitConversionType("BALE");
					voObj.setConversionQuantity(itemObj.getBale());
				}
				if (itemObj.getLoose() > 0) {
					voObj.setUnitConversionType("LOOSE");
					voObj.setConversionQuantity(itemObj.getLoose());
				}

				ItemGroup itemGroupObj = itemGroupRepository.findOne(itemObj.getItemGroupId());
				voObj.setItemGroup(itemGroupObj);

				Indent indentObj = indentRepository.findOne(itemObj.getId());
				if (indentObj != null)
					voObj.setAdditionalRequirement(indentObj.getAdditionalRequirement());

				Item item = itemBoObj.getItemById(itemObj.getItemId());
				voObj.setItem(item);

				QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(itemObj.getUnitId());
				voObj.setQuantityUnit(quantityUnitObj);

				Quality qualityObj = qualityRepository.findOne(itemObj.getQualityCode());
				if (null != qualityObj)
					voObj.setQuality(qualityObj);

				if (null != itemObj.getMarka())
					voObj.setMarka(itemObj.getMarka());

				if (null != itemObj.getApproverFirst())
					voObj.setApproverFirst(itemObj.getApproverFirst());
				if (null != itemObj.getApproverSecond())
					voObj.setApproverSecond(itemObj.getApproverSecond());
				if (null != itemObj.getApproveFirstDate())
					voObj.setApproveFirstDate(itemObj.getApproveFirstDate());
				if (null != itemObj.getApproveSecondDate())
					voObj.setApproveSecondDate(itemObj.getApproveSecondDate());

				poItemVoList.add(voObj);

			}

		}

		poDetailsObj.setPoHeader(headerObj);
		poDetailsObj.setPoItemList(poItemVoList);

		return poDetailsObj;
	}

	@Override
	public List<POHeader> getAllPO() {
		List<POHeader> list = new ArrayList<POHeader>();

		for (POHeader headerObj : pOHeaderRepository.findAll()) {
			list.add(headerObj);
		}

		return list.stream().sorted(Comparator.comparing(POHeader::getModOn)
				// .thenComparing(POHeader::getId)
				.reversed()).collect(Collectors.toList());

	}

	@Override
	public List<POHeader> getAllPOByStatus(String status) {
		List<POHeader> list = new ArrayList<POHeader>();
		for (POHeader headerObj : pOHeaderRepository.findByStatus(status)) {
			list.add(headerObj);
		}
		return list.stream().sorted(Comparator.comparing(POHeader::getModOn)
				// .thenComparing(POHeader::getId)
				.reversed()).collect(Collectors.toList());

	}

	@Override
	public List<GoodReceiveHeader> getAllGoodReceiveHeader() {
		List<GoodReceiveHeader> list = new ArrayList<GoodReceiveHeader>();
		for (GoodReceiveHeader headerObj : goodReceiveHeaderRepository.findAll()) {
			list.add(headerObj);
		}
		return list.stream().sorted(Comparator.comparing(GoodReceiveHeader::getPoId)).collect(Collectors.toList());
	}

	@Override
	public List<GoodReceiveHeader> getAllGoodReceiveHeaderByStatus(String status) {
		List<GoodReceiveHeader> list = new ArrayList<GoodReceiveHeader>();
		for (GoodReceiveHeader headerObj : goodReceiveHeaderRepository.findByStatus(status)) {
			list.add(headerObj);
		}
		return list.stream().sorted(Comparator.comparing(GoodReceiveHeader::getPoId)).collect(Collectors.toList());
	}

	@Override
	public GoodReceiveDetails addGoodReceiveDetails(GoodReceiveDetails goodReceiveDetails) {
		GoodReceiveLineItem itemObj = null;
		GoodReceiveHeader headerObj = null;
		List<GoodReceiveItemVo> grnItemVoList = new ArrayList<GoodReceiveItemVo>();
		GoodReceiveDetails detailsObj = new GoodReceiveDetails();
		if (null != goodReceiveDetails.getGoodReceiveHeader()) {
			headerObj = goodReceiveDetails.getGoodReceiveHeader();
			headerObj = goodReceiveHeaderRepository.save(headerObj);

			for (GoodReceiveItemVo itemVoObj : goodReceiveDetails.getGrnItemList()) {
				itemObj = new GoodReceiveLineItem();

				if (null != itemVoObj.getItemGroup())
					itemObj.setGroupCode(itemVoObj.getItemGroup().getId());
				if (null != itemVoObj.getItem())
					itemObj.setItemId(itemVoObj.getItem().getId());
				if (null != itemVoObj.getQuantityUnit())
					itemObj.setUnitId(itemVoObj.getQuantityUnit().getId());
				if (null != itemVoObj.getQuality())
					itemObj.setQualityCode(itemVoObj.getQuality().getId());
				if (null != itemVoObj.getMarka())
					itemObj.setMarka(itemVoObj.getMarka());

				itemObj.setIndentId(itemVoObj.getIndentId());
				itemObj.setIndentType(itemVoObj.getIndentType());
				itemObj.setStatus(itemVoObj.getStatus());

				itemObj.setOrderQuantity(itemVoObj.getOrderQuantity());
				itemObj.setActualQuantity(itemVoObj.getActualQuantity());
				itemObj.setApprovedQuantity(itemVoObj.getApprovedQuantity());
				itemObj.setRejectedQuantity(itemVoObj.getRejectedQuantity());

				if (null != itemVoObj.getApproverFirst())
					itemObj.setApproverFirst(itemVoObj.getApproverFirst());
				if (null != itemVoObj.getApproverSecond())
					itemObj.setApproverSecond(itemVoObj.getApproverSecond());
				if (null != itemVoObj.getApproveFirstDate())
					itemObj.setApproveFirstDate(itemVoObj.getApproveFirstDate());
				if (null != itemVoObj.getApproveSecondDate())
					itemObj.setApproveSecondDate(itemVoObj.getApproveSecondDate());

				itemVoObj.setGrnId(headerObj.getId());
				itemObj = goodReceiveItemRepository.save(itemObj);
				itemVoObj.setId(itemObj.getId());

				grnItemVoList.add(itemVoObj);
			}
			detailsObj.setGoodReceiveHeader(headerObj);
			detailsObj.setGrnItemList(grnItemVoList);
		}
		return detailsObj;

	}

	@Override
	public GoodReceiveDetails updateGoodReceiveDetails(GoodReceiveDetails goodReceiveDetails) {
		GoodReceiveLineItem itemObj = null;
		GoodReceiveHeader headerObj = null;
		List<GoodReceiveItemVo> grnItemVoList = new ArrayList<GoodReceiveItemVo>();
		GoodReceiveDetails detailsObj = new GoodReceiveDetails();
		if (null != detailsObj.getGoodReceiveHeader()) {
			headerObj = detailsObj.getGoodReceiveHeader();
			headerObj = goodReceiveHeaderRepository.save(headerObj);

			for (GoodReceiveItemVo itemVoObj : detailsObj.getGrnItemList()) {
				itemObj = new GoodReceiveLineItem();
				itemObj.setId(itemVoObj.getId());

				if (null != itemVoObj.getItemGroup())
					itemObj.setGroupCode(itemVoObj.getItemGroup().getId());
				if (null != itemVoObj.getItem())
					itemObj.setItemId(itemVoObj.getItem().getId());
				if (null != itemVoObj.getQuantityUnit())
					itemObj.setUnitId(itemVoObj.getQuantityUnit().getId());
				if (null != itemVoObj.getQuality())
					itemObj.setQualityCode(itemVoObj.getQuality().getId());
				if (null != itemVoObj.getMarka())
					itemObj.setMarka(itemVoObj.getMarka());

				itemObj.setIndentId(itemVoObj.getIndentId());
				itemObj.setIndentType(itemVoObj.getIndentType());
				itemObj.setStatus(itemVoObj.getStatus());

				itemObj.setOrderQuantity(itemVoObj.getOrderQuantity());
				itemObj.setActualQuantity(itemVoObj.getActualQuantity());
				itemObj.setApprovedQuantity(itemVoObj.getApprovedQuantity());
				itemObj.setRejectedQuantity(itemVoObj.getRejectedQuantity());

				if (null != itemVoObj.getApproverFirst())
					itemObj.setApproverFirst(itemVoObj.getApproverFirst());
				if (null != itemVoObj.getApproverSecond())
					itemObj.setApproverSecond(itemVoObj.getApproverSecond());
				if (null != itemVoObj.getApproveFirstDate())
					itemObj.setApproveFirstDate(itemVoObj.getApproveFirstDate());
				if (null != itemVoObj.getApproveSecondDate())
					itemObj.setApproveSecondDate(itemVoObj.getApproveSecondDate());

				itemObj = goodReceiveItemRepository.save(itemObj);
				itemVoObj.setId(itemObj.getId());
				itemVoObj.setGrnId(headerObj.getId());
				grnItemVoList.add(itemVoObj);
			}
			detailsObj.setGoodReceiveHeader(headerObj);
			detailsObj.setGrnItemList(grnItemVoList);

			if (itemObj.getStatus().equalsIgnoreCase("APPROVED")
					|| headerObj.getStatus().equalsIgnoreCase("APPROVED")) {
				List<PhysicalStock> physicalStockList = physicalStockRepository.findByItemId(itemObj.getItemId());
				if (null != physicalStockList) {
					for (PhysicalStock psObj : physicalStockList) {
						if (psObj.getStoreId() == headerObj.getStoreId()) {
							psObj.setTotalStock(psObj.getTotalStock() + itemObj.getApprovedQuantity());
							psObj.setStockInHand(psObj.getStockInHand() + itemObj.getApprovedQuantity());
							psObj.setNewStock(itemObj.getApprovedQuantity());
							psObj.setNewStockIndentId(itemObj.getIndentId());
							psObj.setLastModifiedUser(itemObj.getLastModifiedUser());
							psObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));
							physicalStockRepository.save(psObj);
						}
					}

				} else {
					PhysicalStock stockObj = new PhysicalStock();
					stockObj.setStoreId(headerObj.getStoreId());
					stockObj.setItemGroupId(itemObj.getGroupCode());
					stockObj.setItemId(itemObj.getItemId());
					stockObj.setTotalStock(itemObj.getApprovedQuantity());
					stockObj.setStockInHand(itemObj.getApprovedQuantity());
					stockObj.setNewStock(itemObj.getApprovedQuantity());
					stockObj.setNewStockIndentId(itemObj.getIndentId());
					stockObj.setLastModifiedUser(itemObj.getLastModifiedUser());
					stockObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));
					physicalStockRepository.save(stockObj);
				}
			}
		}
		return detailsObj;
	}

	@Override
	public GoodReceiveDetails getGoodReceiveDetails(long grnId) {
		GoodReceiveDetails detailsObj = new GoodReceiveDetails();
		GoodReceiveHeader headerObj = null;
		List<GoodReceiveItemVo> itemVoList = new ArrayList<GoodReceiveItemVo>();
		List<GoodReceiveLineItem> lineItemList = null;
		headerObj = goodReceiveHeaderRepository.findOne(grnId);
		lineItemList = goodReceiveItemRepository.findByGrnId(grnId);

		if (null != lineItemList) {

			for (GoodReceiveLineItem itemObj : lineItemList) {
				GoodReceiveItemVo itemVoObj = new GoodReceiveItemVo();
				itemVoObj.setId(itemObj.getId());
				itemVoObj.setGrnId(headerObj.getId());

				itemVoObj.setIndentId(itemObj.getIndentId());
				itemVoObj.setIndentType(itemObj.getIndentType());
				itemVoObj.setStatus(itemObj.getStatus());

				itemVoObj.setOrderQuantity(itemObj.getOrderQuantity());
				itemVoObj.setActualQuantity(itemObj.getActualQuantity());
				itemVoObj.setApprovedQuantity(itemObj.getApprovedQuantity());
				itemVoObj.setRejectedQuantity(itemObj.getRejectedQuantity());

				if (null != itemObj.getApproverFirst())
					itemVoObj.setApproverFirst(itemObj.getApproverFirst());
				if (null != itemObj.getApproverSecond())
					itemVoObj.setApproverSecond(itemObj.getApproverSecond());
				if (null != itemObj.getApproveFirstDate())
					itemVoObj.setApproveFirstDate(itemObj.getApproveFirstDate());
				if (null != itemObj.getApproveSecondDate())
					itemVoObj.setApproveSecondDate(itemObj.getApproveSecondDate());

				ItemGroup itemGroupObj = itemGroupRepository.findOne(itemObj.getGroupCode());
				itemVoObj.setItemGroup(itemGroupObj);

				Item item = itemBoObj.getItemById(itemObj.getItemId());
				itemVoObj.setItem(item);

				QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(itemObj.getUnitId());
				itemVoObj.setQuantityUnit(quantityUnitObj);

				Quality qualityObj = qualityRepository.findOne(itemObj.getQualityCode());
				if (null != qualityObj)
					itemVoObj.setQuality(qualityObj);

				if (null != itemObj.getMarka())
					itemVoObj.setMarka(itemObj.getMarka());

				itemVoList.add(itemVoObj);

			}

		}

		detailsObj.setGoodReceiveHeader(headerObj);
		detailsObj.setGrnItemList(itemVoList);

		return detailsObj;
	}

	// @Override
	// public List<IssueItemVo> getAllIssue() {
	// List<IssueItemVo> list = new ArrayList<IssueItemVo>();
	// for (IssueItem issueItem : issueItemtRepository.findAll()) {
	// IssueItemVo voObj = new IssueItemVo();
	// voObj.setId(issueItem.getId());
	// voObj.setIndentId(issueItem.getIndentId());
	// voObj.setIssueDate(issueItem.getIssueDate());
	// voObj.setIssuer(issueItem.getIssuer());
	// voObj.setReceiver(issueItem.getReceiver());
	// voObj.setIndentQuantity(issueItem.getIndentQuantity());
	// voObj.setIssuedQuantity(issueItem.getIssuedQuantity());
	// voObj.setLastModifiedDate(issueItem.getLastModifiedDate());
	// voObj.setLastModifiedUser(issueItem.getLastModifiedUser());
	//
	// ItemGroup itemGroupObj =
	// itemGroupRepository.findOne(issueItem.getItemGroupId());
	// voObj.setItemGroup(itemGroupObj);
	//
	// Department deptobj = departmentRepository.findOne(issueItem.getDeptId());
	// voObj.setDepartment(deptobj);
	//
	// Item item = itemBoObj.getItemById(issueItem.getItemId());
	// voObj.setItem(item);
	//
	// QuantityUnit quantityUnitObj =
	// quantityUnitRepository.findOne(issueItem.getUnitId());
	// voObj.setQuantityUnit(quantityUnitObj);
	//
	// Quality qualityObj = qualityRepository.findOne(issueItem.getQualityCode());
	// if (null != qualityObj)
	// voObj.setQuality(qualityObj);
	//
	// if (null != issueItem.getMarka())
	// voObj.setMarka(issueItem.getMarka());
	//
	// list.add(voObj);
	// }
	// return list;
	// }
	//

	@Override
	public List<IssueDetails> getAllIssue() {
		List<IssueDetails> list = new ArrayList<IssueDetails>();
		List<IssueLineItemVo> itemList = null;

		for (IssueHeader issueHeaderObj : issueHeaderRepository.findAll()) {
			IssueDetails voObj = new IssueDetails();
			voObj.setIssueHeader(issueHeaderObj);
			Department deptobj = departmentRepository.findOne(Long.parseLong(issueHeaderObj.getDeptId()));
			voObj.setDepartment(deptobj);
			itemList = new ArrayList<IssueLineItemVo>();
			for (IssueLineItem issueLineItem : issueLineItemRepository.findByIssueHeaderId(issueHeaderObj.getId())) {
				itemList.add(getIssueLineItemVo(issueLineItem));
			}
			voObj.setIssuItemList(itemList);

			list.add(voObj);
		}
		return list;
	}

	@Override
	public IssueDetails getIssueDetailsById(long id) {
		IssueDetails voObj = new IssueDetails();
		List<IssueLineItemVo> itemList = null;
		IssueHeader issueHeaderObj = issueHeaderRepository.findOne(id);
		voObj.setIssueHeader(issueHeaderObj);
		Department deptobj = departmentRepository.findOne(Long.parseLong(issueHeaderObj.getDeptId()));
		voObj.setDepartment(deptobj);
		itemList = new ArrayList<IssueLineItemVo>();
		for (IssueLineItem issueLineItem : issueLineItemRepository.findByIssueHeaderId(issueHeaderObj.getId())) {
			itemList.add(getIssueLineItemVo(issueLineItem));
		}
		voObj.setIssuItemList(itemList);

		return voObj;
	}

	@Override
	public List<IssueDetails> getAllLoans() {
		List<IssueDetails> list = new ArrayList<IssueDetails>();
		List<IssueLineItemVo> itemList = null;

		for (IssueHeader issueHeaderObj : issueHeaderRepository.findAll()) {
			if (issueHeaderObj.getType().equalsIgnoreCase("L")) {
				IssueDetails voObj = new IssueDetails();
				voObj.setIssueHeader(issueHeaderObj);
				Department deptobj = departmentRepository.findOne(Long.parseLong(issueHeaderObj.getDeptId()));
				voObj.setDepartment(deptobj);
				itemList = new ArrayList<IssueLineItemVo>();
				for (IssueLineItem issueLineItem : issueLineItemRepository
						.findByIssueHeaderId(issueHeaderObj.getId())) {
					itemList.add(getIssueLineItemVo(issueLineItem));
				}
				voObj.setIssuItemList(itemList);

				list.add(voObj);

			}

		}
		return list;
	}

	@Override
	public List<IssueDetails> getAllIssueByDeparttmentId(long departmentId) {
		List<IssueDetails> list = new ArrayList<IssueDetails>();
		List<IssueLineItemVo> itemList = null;
		for (IssueHeader issueHeaderObj : issueHeaderRepository.findByDeptId(String.valueOf(departmentId))) {
			IssueDetails voObj = new IssueDetails();
			voObj.setIssueHeader(issueHeaderObj);
			Department deptobj = departmentRepository.findOne(Long.parseLong(issueHeaderObj.getDeptId()));
			voObj.setDepartment(deptobj);
			itemList = new ArrayList<IssueLineItemVo>();
			for (IssueLineItem issueLineItem : issueLineItemRepository.findByIssueHeaderId(issueHeaderObj.getId())) {
				itemList.add(getIssueLineItemVo(issueLineItem));
			}
			voObj.setIssuItemList(itemList);

			list.add(voObj);
		}
		return list;
	}

	@Override
	public List<IssueDetails> getAllLoansByUnitId(String unitId) {
		List<IssueDetails> list = new ArrayList<IssueDetails>();
		List<IssueLineItemVo> itemList = null;

		for (IssueHeader issueHeaderObj : issueHeaderRepository.findByUnitId(unitId)) {
			IssueDetails voObj = new IssueDetails();
			voObj.setIssueHeader(issueHeaderObj);
			Department deptobj = departmentRepository.findOne(Long.parseLong(issueHeaderObj.getDeptId()));
			voObj.setDepartment(deptobj);
			itemList = new ArrayList<IssueLineItemVo>();
			for (IssueLineItem issueLineItem : issueLineItemRepository.findByIssueHeaderId(issueHeaderObj.getId())) {
				itemList.add(getIssueLineItemVo(issueLineItem));
			}
			voObj.setIssuItemList(itemList);

			list.add(voObj);
		}
		return list;
	}

	// @Override
	// public List<IssueItemVo> getAllIssueByDeparttmentId(long departmentId) {
	// List<IssueItemVo> list = new ArrayList<IssueItemVo>();
	// for (IssueItem issueItem : issueItemtRepository.findByDeptId(departmentId)) {
	// IssueItemVo voObj = new IssueItemVo();
	// voObj.setId(issueItem.getId());
	// voObj.setIndentId(issueItem.getIndentId());
	// voObj.setIssueDate(issueItem.getIssueDate());
	// voObj.setIssuer(issueItem.getIssuer());
	// voObj.setReceiver(issueItem.getReceiver());
	// voObj.setIndentQuantity(issueItem.getIndentQuantity());
	// voObj.setIssuedQuantity(issueItem.getIssuedQuantity());
	// voObj.setLastModifiedDate(issueItem.getLastModifiedDate());
	// voObj.setLastModifiedUser(issueItem.getLastModifiedUser());
	//
	// ItemGroup itemGroupObj =
	// itemGroupRepository.findOne(issueItem.getItemGroupId());
	// voObj.setItemGroup(itemGroupObj);
	// Department deptobj = departmentRepository.findOne(issueItem.getDeptId());
	// voObj.setDepartment(deptobj);
	//
	// Item item = itemBoObj.getItemById(issueItem.getItemId());
	// voObj.setItem(item);
	//
	// QuantityUnit quantityUnitObj =
	// quantityUnitRepository.findOne(issueItem.getUnitId());
	// voObj.setQuantityUnit(quantityUnitObj);
	//
	// Quality qualityObj = qualityRepository.findOne(issueItem.getQualityCode());
	// if (null != qualityObj)
	// voObj.setQuality(qualityObj);
	//
	// if (null != issueItem.getMarka())
	// voObj.setMarka(issueItem.getMarka());
	//
	// list.add(voObj);
	// }
	// return list;
	// }

	@Override
	public IssueDetails addLoanIssue(IssueDetails issueDetails) {
		IssueDetails issueDetailsObj = new IssueDetails();
		List<IssueLineItemVo> itemList = new ArrayList<IssueLineItemVo>();
		List<IssueLineItemVo> issueItemList = new ArrayList<IssueLineItemVo>();
		
		IssueHeader issueHeader = issueDetails.getIssueHeader();
		User user = userRepository.findOne(Long.valueOf(issueHeader.getSubmitter()));
		issueHeader.setSubmitter(user.getUserName());
		// issueHeader.setCreateDate(java.sql.Date.valueOf(LocalDate.now()))
		issueHeader = issueHeaderRepository.save(issueHeader);
		issueHeader.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));
		itemList = issueDetails.getIssuItemList();
		if (null != itemList && itemList.size() > 0) {
			for (IssueLineItemVo issueLineItemVo : itemList) {
				IssueLineItem issueItem = getIssueLineItem(issueLineItemVo);
				issueItem.setIssueHeaderId(issueHeader.getId());
				issueItem = issueLineItemRepository.save(issueItem);
				// issueLineItemVo.setIssueId(issueItem.getIssueHeaderId());
				// issueLineItemVo.setIssueItemId(issueItem.getId());
				issueItemList.add(getIssueLineItemVo(issueItem));

				if (issueItem.getAdditionalRequirement() != null) {
					String[] issueDtlsArr = issueItem.getAdditionalRequirement().split(",");
					for (String issueId : issueDtlsArr) {
						String[] idQnt = issueId.split("\\^");
						if (idQnt.length > 1) {
							PhysicalStock stockObj = physicalStockRepository.findOne(Long.parseLong(idQnt[0]));
							if (null != stockObj) {
								float issueQunatity = Float.parseFloat(idQnt[1]);
								float currentTotalStock = 0;
								float currentTotalBaleStock = 0;
								float avgQuantityPerBale = 0;

								if (stockObj.getConversionUnit() != null
										&& stockObj.getConversionUnit().equalsIgnoreCase("BALE")) {
									MaterialGoodReceiveLineItem mrlineitem = 
											materialGoodReceiveItemRepository.findOne(stockObj.getGoodItemSerialNo());
									avgQuantityPerBale = mrlineitem.getActualWeight() / mrlineitem.getActualBale();
//									avgQuantityPerBale = stockObj.getTotalStock() / stockObj.getTotalBaleStock();
									currentTotalBaleStock = stockObj.getTotalBaleStock() - issueQunatity;
									currentTotalStock = stockObj.getTotalStock() - (issueQunatity * avgQuantityPerBale);
									stockObj.setTotalStock(currentTotalStock);
									stockObj.setStockInHand(currentTotalStock);
									stockObj.setTotalBaleStock(currentTotalBaleStock);
									stockObj.setStockInHandBale(currentTotalBaleStock);

								} else {
									currentTotalStock = stockObj.getTotalStock() - issueQunatity;
									stockObj.setTotalStock(currentTotalStock);
									stockObj.setStockInHand(currentTotalStock);

								}

								physicalStockRepository.save(stockObj);
							}

						}

					}

				}
			}
		}
		issueDetailsObj.setIssueHeader(issueHeader);
		Department deptobj = departmentRepository.findOne(Long.parseLong(issueHeader.getDeptId()));
		issueDetailsObj.setDepartment(deptobj);
		issueDetailsObj.setIssuItemList(issueItemList);

		return issueDetailsObj;
	}

	@Override
	public IssueItemVo updateIssue(IssueItemVo issueItemVo) {
		IssueItem issueItem = new IssueItem();
		issueItem.setId(issueItemVo.getId());
		issueItem.setIndentId(issueItemVo.getIndentId());
		issueItem.setIssueDate(issueItemVo.getIssueDate());
		issueItem.setIssuer(issueItemVo.getIssuer());

		issueItem.setReceiver(issueItemVo.getReceiver());
		issueItem.setIndentQuantity(issueItemVo.getIndentQuantity());
		issueItem.setIssuedQuantity(issueItem.getIssuedQuantity());
		issueItem.setLastModifiedDate(issueItemVo.getLastModifiedDate());
		issueItem.setLastModifiedUser(issueItemVo.getLastModifiedUser());

		if (null != issueItemVo.getDepartment())
			issueItem.setDeptId(issueItemVo.getDepartment().getId());
		if (null != issueItemVo.getItemGroup())
			issueItem.setItemGroupId(issueItemVo.getItemGroup().getId());
		if (null != issueItemVo.getItem())
			issueItem.setItemId(issueItemVo.getItem().getId());
		if (null != issueItemVo.getQuantityUnit())
			issueItem.setUnitId(issueItemVo.getQuantityUnit().getId());
		if (null != issueItemVo.getQuality())
			issueItem.setQualityCode(issueItemVo.getQuality().getId());
		if (null != issueItemVo.getMarka())
			issueItem.setMarka(issueItemVo.getMarka());
		issueItem = issueItemtRepository.save(issueItem);

		return issueItemVo;
	}

	@Override
	public LoginToken addToken(LoginToken loginToken) {
		boolean flag = true;
		String generatedToken = null;
		while (flag) {
			generatedToken = generateRandomToken();
			if (null == loginTokenRepository.findOne(generatedToken)) {
				flag = false;
			} else {
				generatedToken = generateRandomToken();
			}
		}
		loginToken.setTokenId(generateRandomToken());
		loginToken.setCounter(0);
		loginToken = loginTokenRepository.save(loginToken);
		return loginToken;
	}

	@Override
	public LoginToken getToken(String tokenId) {
		LoginToken loginToken = null;
		loginToken = loginTokenRepository.findOne(tokenId);
		if (loginToken != null) {
			if (loginToken.getCounter() > 10) {
				boolean flag = true;
				String generatedToken = null;
				while (flag) {
					generatedToken = generateRandomToken();
					if (null == loginTokenRepository.findOne(generatedToken)) {
						flag = false;
					} else {
						generatedToken = generateRandomToken();
					}
				}
				loginToken.setTokenId(generateRandomToken());
				loginToken.setCounter(0);
				loginToken = loginTokenRepository.save(loginToken);
				loginTokenRepository.delete(tokenId);

			} else {
				loginToken.setCounter(loginToken.getCounter() + 1);
				loginToken.setLastModifiedDate(new Date());
				loginToken = loginTokenRepository.save(loginToken);

			}
		}

		return loginToken;
	}

	private String generateRandomToken() {
		String aToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		Random rand = new Random();
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < 17; i++) {
			int randIndex = rand.nextInt(aToZ.length());
			res.append(aToZ.charAt(randIndex));
		}
		return res.toString();
	}

	@Override
	public List<String> getAllApprovedIndentIdsForJute(String status) {
		List<String> supplierIndentVoList = new ArrayList<String>();
		List<Indent> supplierIndentList = null;
		List<IndentHeader> indentHeaderList = null;
		List<POLineItem> poLineItemList = null;
		indentHeaderList = indentHeaderRepository.findByStatus(status);
		Map<String, String> indentIdMap = new HashMap<String, String>();

		Map<String, String> poIndentMap = new HashMap<String, String>();
		Map<String, POLineItem> poItemMap = new HashMap<String, POLineItem>();
		long qualityCode = 0;
		String poIndentItemKey = null;
		long suppResponseQualityCode = 0;
		String suppResponseIndentItemKey = null;
		if (indentHeaderList != null && indentHeaderList.size() > 0) {
			for (IndentHeader indentHeaderObj : indentHeaderList) {
				if (indentHeaderObj.getType() != null && indentHeaderObj.getType().equalsIgnoreCase("J")) {
					supplierIndentList = indentRepository.findByIndentHeaderId(indentHeaderObj.getId());
					if (null != supplierIndentList) {
						for (Indent supplierIndentObj : supplierIndentList) {
							if (!supplierIndentObj.getStatus().equalsIgnoreCase("5")) {

								if (null == poIndentMap.get(supplierIndentObj.getIndentHeaderId())) {
									poLineItemList = pOLineItemRepository
											.findByIndentId(supplierIndentObj.getIndentHeaderId());
									if (null != poLineItemList && poLineItemList.size() > 0) {
										for (POLineItem itemObj : poLineItemList) {
											if (itemObj.getQualityCode() != 0) {
												qualityCode = itemObj.getQualityCode();
											}
											poIndentItemKey = itemObj.getIndentId() + "-" + itemObj.getItemId() + "-"
													+ qualityCode;
											poItemMap.put(poIndentItemKey, itemObj);
										}
										poIndentMap.put(supplierIndentObj.getIndentHeaderId(),
												supplierIndentObj.getIndentHeaderId());
									}
								}

								if (supplierIndentObj.getQualityCode() != 0) {
									suppResponseQualityCode = supplierIndentObj.getQualityCode();
								}
								suppResponseIndentItemKey = supplierIndentObj.getIndentHeaderId() + "-"
										+ supplierIndentObj.getItemId() + "-" + suppResponseQualityCode;
								POLineItem obj = poItemMap.get(suppResponseIndentItemKey);
								if (null == obj) {
									if (null == indentIdMap.get(supplierIndentObj.getIndentHeaderId())) {
										indentIdMap.put(supplierIndentObj.getIndentHeaderId(),
												supplierIndentObj.getIndentHeaderId());
										supplierIndentVoList.add(supplierIndentObj.getIndentHeaderId());
									}
								} else {
									if (obj.getStatus() != null) {
										if (obj.getStatus().equalsIgnoreCase("4")
												|| obj.getStatus().equalsIgnoreCase("6")) {
											if (null == indentIdMap.get(supplierIndentObj.getIndentHeaderId())) {
												indentIdMap.put(supplierIndentObj.getIndentHeaderId(),
														supplierIndentObj.getIndentHeaderId());
												supplierIndentVoList.add(supplierIndentObj.getIndentHeaderId());
											}
										}

									}

								}

							}
						}

					}
				}

			}
		}
		return supplierIndentVoList;

	}

	@Override
	public IndentDetails getIndentDetailsForJuteByIndentId(String indentId) {
		IndentDetails indentDetailsObj = new IndentDetails();
		Map<String, POLineItem> poItemMap = new HashMap<String, POLineItem>();
		Map<String, String> jutePriceMasterMap = new HashMap<String, String>();
		Map<String, JutePriceMaster> jutePriceMasterItemMap = new HashMap<String, JutePriceMaster>();
		List<POLineItem> poLineItemList = null;
		POLineItem pOLineItemObj = null;
		IndentHeader indentHeaderObj = indentHeaderRepository.findOne(String.valueOf(indentId));
		indentDetailsObj.setIndentHeader(indentHeaderObj);
		List<Indent> indentList = indentRepository.findByIndentHeaderId(String.valueOf(indentId));
		List<IndentVo> indentVoList = new ArrayList<IndentVo>();
		poLineItemList = pOLineItemRepository.findByIndentId(String.valueOf(indentId));
		if (null != poLineItemList && poLineItemList.size() > 0) {
			for (POLineItem itemObj : poLineItemList) {
				poItemMap.put(itemObj.getItemId(), itemObj);
			}
		}
		if (indentList != null && indentList.size() > 0) {

			for (Indent indentObj : indentList) {
				JutePriceMaster jutePriceMasterObj = null;
				if (jutePriceMasterMap.get(indentObj.getItemId()) == null) {
					List<JutePriceMaster> jutePriceMasterList = jutePriceMasterRepository
							.findByItemCode(indentObj.getItemId());
					for (JutePriceMaster jpmObj : jutePriceMasterList) {
						jutePriceMasterItemMap.put(jpmObj.getItemCode() + "_" + jpmObj.getJuteQuality(), jpmObj);
					}
					jutePriceMasterMap.put(indentObj.getItemId(), indentObj.getItemId());
				}
				pOLineItemObj = poItemMap.get(indentObj.getId());
				if (pOLineItemObj == null) {

					IndentVo indentVoObj = new IndentVo();
					indentVoObj.setStatus(indentObj.getStatus());
					indentVoObj.setIndentQuantity(indentObj.getIndentQuantity());
					indentVoObj.setIndentCancelledQuantity(indentObj.getIndentCancelledQuantity());
					indentVoObj.setStock(String.valueOf(indentObj.getStock()));
					indentVoObj.setSubmitter(indentHeaderObj.getSubmitter());
					indentVoObj.setIndentId(indentObj.getIndentHeaderId());
					indentVoObj.setIndentItemId(indentObj.getId());
					indentVoObj.setAdditionalRequirement(indentObj.getAdditionalRequirement());
					Department deptObj = departmentRepository.findOne(indentObj.getDeptId());
					indentVoObj.setDepartment(deptObj);

					ItemGroup itemGroupObj = itemGroupRepository.findOne(indentObj.getItemGroupId());
					indentVoObj.setItemGroup(itemGroupObj);

					Item itemObj = itemBoObj.getItemById(indentObj.getItemId());
					indentVoObj.setItem(itemObj);

					QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(indentObj.getUnitId());
					indentVoObj.setQuantityUnit(quantityUnitObj);

					Quality qualityObj = qualityRepository.findOne(indentObj.getQualityCode());
					if (null != qualityObj)
						indentVoObj.setQuality(qualityObj);

					if (null != indentObj.getMarka())
						indentVoObj.setMarka(indentObj.getMarka());

					if (null != indentObj.getApproverFirst())
						indentVoObj.setApproverFirst(indentObj.getApproverFirst());
					if (null != indentObj.getApproverSecond())
						indentVoObj.setApproverSecond(indentObj.getApproverSecond());
					if (null != indentObj.getApproveFirstDate())
						indentVoObj.setApproveFirstDate(indentObj.getApproveFirstDate());
					if (null != indentObj.getApproveSecondDate())
						indentVoObj.setApproveSecondDate(indentObj.getApproveSecondDate());
					jutePriceMasterObj = jutePriceMasterItemMap
							.get(indentObj.getItemId() + "_" + indentObj.getQualityCode());
					if (null != jutePriceMasterObj) {
						indentVoObj.setLastPurchasedRate(jutePriceMasterObj.getRate());
						indentVoObj.setLastPurchasedCurrency(jutePriceMasterObj.getCurrency());
					}
					indentVoList.add(indentVoObj);
				}

			}
			indentDetailsObj.setIndentList(indentVoList);
		}

		return indentDetailsObj;
	}

	@Override
	public List<Supplier> getSupplierForJuteByType(String type) {
		List<Supplier> resultList = new ArrayList<Supplier>();
		for (Supplier supplier : supplierRepository.findByType(type)) {
			resultList.add(supplier);
		}
		return resultList;

	}

	@Override
	public List<Supplier> getAllSupplierForIndent(String indentId) {
		List<Supplier> resultList = new ArrayList<Supplier>();
		HashMap<String, String> supplierMap = new HashMap<String, String>();
		List<SupplierIndent> supplierList = supplierIndentRepository.findByIndentHeaderId(indentId);
		for (SupplierIndent supplierIndent : supplierList) {
			supplierMap.put(supplierIndent.getSupplierCode(), supplierIndent.getSupplierCode());
		}

		for (Supplier supplier : supplierRepository.findAll()) {
			if (supplierMap.get(supplier.getId()) == null)
				resultList.add(supplier);
		}
		return resultList;

	}

	private List<SupplierRankVo> getSortedSupplierListForAllIndentItems(Map<String, Float> supplierIndentRateMap,
			Map<String, Long> supplierALLItemCountMap, Map<String, List<SupplierIndentVo>> supplierIndentRateDetailsMap,
			Map<String, String> indentAllItemCountMap, Map<Long, List<String>> countwiseSuppliesrMap) {

		long totalIndentItemCOunt = indentAllItemCountMap.keySet().size();
		long counter = totalIndentItemCOunt;
		List<String> supplierCodeList = null;
		List<SupplierRankVo> resultList = new ArrayList<SupplierRankVo>();
		Map<Float, List<String>> rateSupplierCodeMap = new HashMap<Float, List<String>>();
		List<Float> rateList = new ArrayList<Float>();
		boolean flag = true;

		while (flag) {
			supplierCodeList = countwiseSuppliesrMap.get(counter);
			if (supplierCodeList != null && supplierCodeList.size() > 0) {
				// if(counter==supplierCodeList.size()){
				flag = false;
				for (String supplierCode : supplierCodeList) {
					float supplierRate = supplierIndentRateMap.get(supplierCode);
					if (!rateList.contains(supplierRate))
						rateList.add(supplierRate);
					List<String> suppliers = rateSupplierCodeMap.get(supplierRate);
					if (suppliers != null && suppliers.size() > 0) {
						suppliers.add(supplierCode);
						rateSupplierCodeMap.put(supplierRate, suppliers);
					} else {
						suppliers = new ArrayList<String>();
						suppliers.add(supplierCode);
						rateSupplierCodeMap.put(supplierRate, suppliers);
					}

				}

				// }
			}
			counter--;
		}
		Collections.sort(rateList);
		int finalLength = 3;
		if (rateList.size() < finalLength)
			finalLength = rateList.size();
		for (int i = 0; i < finalLength; i++) {
			if (rateList.get(i) != null) {
				List<String> suppCodeList = rateSupplierCodeMap.get(rateList.get(i));
				if (suppCodeList != null && suppCodeList.size() > 0) {
					for (String suppCode : suppCodeList) {
						SupplierRankVo supplierRankVoObj = new SupplierRankVo();
						supplierRankVoObj.setSupplier(supplierRepository.findOne(suppCode));
						supplierRankVoObj.setTotalFinalPrice(supplierIndentRateMap.get(suppCode));
						supplierRankVoObj.setSupplierIndentList(supplierIndentRateDetailsMap.get(suppCode));
						if (!resultList.contains(supplierRankVoObj)) {
							resultList.add(i, supplierRankVoObj);

						}

					}

				}
			}
		}

		return resultList;
	}

	private List<SupplierRankVo> getSortedSupplierListForSelectedIndentItems(Map<String, Float> supplierItemRateMap,
			Map<String, Long> supplierSelectedItemCountMap,
			Map<String, List<SupplierIndentVo>> supplierItemRateDetailsMap,
			Map<String, String> indentSelectedItemCountMap, Map<Long, List<String>> countwiseSelectedItemSuppliesrMap) {

		long totalIndentItemCOunt = indentSelectedItemCountMap.keySet().size();
		long counter = totalIndentItemCOunt;
		List<String> supplierCodeList = null;
		List<SupplierRankVo> resultList = new ArrayList<SupplierRankVo>();
		Map<Float, List<String>> rateSupplierCodeMap = new HashMap<Float, List<String>>();
		List<Float> rateList = new ArrayList<Float>();
		boolean flag = true;
		while (flag) {
			supplierCodeList = countwiseSelectedItemSuppliesrMap.get(counter);
			if (supplierCodeList != null && supplierCodeList.size() > 0) {
				// if(counter==supplierCodeList.size()){
				flag = false;
				for (String supplierCode : supplierCodeList) {
					float supplierRate = supplierItemRateMap.get(supplierCode);
					if (!rateList.contains(supplierRate))
						rateList.add(supplierRate);
					List<String> suppliers = rateSupplierCodeMap.get(supplierRate);
					if (suppliers != null && suppliers.size() > 0) {
						suppliers.add(supplierCode);
						rateSupplierCodeMap.put(supplierRate, suppliers);
					} else {
						suppliers = new ArrayList<String>();
						suppliers.add(supplierCode);
						rateSupplierCodeMap.put(supplierRate, suppliers);
					}

				}

				// }
			}
			counter--;
		}
		Collections.sort(rateList);
		int finalLength = 3;
		if (rateList.size() < finalLength)
			finalLength = rateList.size();
		for (int i = 0; i < finalLength; i++) {
			if (rateList.get(i) != null) {
				List<String> suppCodeList = rateSupplierCodeMap.get(rateList.get(i));
				if (suppCodeList != null && suppCodeList.size() > 0) {
					for (String suppCode : suppCodeList) {
						SupplierRankVo supplierRankVoObj = new SupplierRankVo();
						supplierRankVoObj.setSupplier(supplierRepository.findOne(suppCode));
						supplierRankVoObj.setTotalFinalPrice(supplierItemRateMap.get(suppCode));
						supplierRankVoObj.setSupplierIndentList(supplierItemRateDetailsMap.get(suppCode));
						if (!resultList.contains(supplierRankVoObj)) {
							resultList.add(i, supplierRankVoObj);

						}

					}

				}
			}
		}

		return resultList;
	}

	private SupplierIndentVo getSupplierIndentVo(SupplierIndent indentObj) {

		SupplierIndentVo suppIndentVoObj = new SupplierIndentVo();
		Supplier supplierObj = supplierRepository.findOne(indentObj.getSupplierCode());
		suppIndentVoObj.setSupplier(supplierObj);
		ItemGroup itemGroupObj = itemGroupRepository.findOne(indentObj.getItemGroupId());
		suppIndentVoObj.setItemGroup(itemGroupObj);
		Item itemObj = itemBoObj.getItemById(indentObj.getItemId());
		suppIndentVoObj.setItem(itemObj);
		QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(indentObj.getUnitId());
		suppIndentVoObj.setQuantityUnit(quantityUnitObj);

		Quality qualityObj = qualityRepository.findOne(indentObj.getQualityCode());
		if (null != qualityObj)
			suppIndentVoObj.setQuality(qualityObj);

		if (null != indentObj.getMarka())
			suppIndentVoObj.setMarka(indentObj.getMarka());

		suppIndentVoObj.setIndentId(indentObj.getIndentHeaderId());
		suppIndentVoObj.setIndentItemId(indentObj.getId());

		suppIndentVoObj.setIndentQuantity(indentObj.getIndentQuantity());
		suppIndentVoObj.setStatus(indentObj.getStatus());
		suppIndentVoObj.setType(indentObj.getType());
		suppIndentVoObj.setRate(indentObj.getRate());
		suppIndentVoObj.setSubmitter(indentObj.getSubmitter());
		suppIndentVoObj.setCreateDate(indentObj.getCreateDate());
		suppIndentVoObj.setFinnacialYear(indentObj.getFinnacialYear());

		if (null != indentObj.getApproverFirst())
			suppIndentVoObj.setApproverFirst(indentObj.getApproverFirst());
		if (null != indentObj.getApproverSecond())
			suppIndentVoObj.setApproverSecond(indentObj.getApproverSecond());
		if (null != indentObj.getApproveFirstDate())
			suppIndentVoObj.setApproveFirstDate(indentObj.getApproveFirstDate());
		if (null != indentObj.getApproveSecondDate())
			suppIndentVoObj.setApproveSecondDate(indentObj.getApproveSecondDate());

		return suppIndentVoObj;
	}

	private StoreGoodReceiveItemVo getStoreGoodReceiveItemVo(StoreGoodReceiveLineItem item) {
		StoreGoodReceiveItemVo itemVo = new StoreGoodReceiveItemVo();
		itemVo.setActualQuantity(item.getActualQuantity());
		itemVo.setAdditionalRequirements(item.getAdditionalRequirements());
		itemVo.setAdvisedQuantity(item.getAdvisedQuantity());
		if (item.getApproveFirstDate() != null) {
			itemVo.setApproveFirstDate(item.getApproveFirstDate());
		}

		if (item.getApproverFirst() != null) {
			itemVo.setApproverFirst(item.getApproverFirst());
		}
		if (item.getApproverSecond() != null) {
			itemVo.setApproverSecond(item.getApproverSecond());
		}
		if (item.getApproveSecondDate() != null) {
			itemVo.setApproveSecondDate(item.getApproveSecondDate());
		}

		itemVo.setBatchno(item.getBatchno());
		itemVo.setClaims(item.getClaims());
		itemVo.setDebitNotesFlag(item.getDebitNotesFlag());
		itemVo.setDeviation(item.getDeviation());
		if (item.getExpiryDate() != null) {
			itemVo.setExpiryDate(item.getExpiryDate());
		}
		itemVo.setFloor(item.getFloor());
		itemVo.setId(item.getId());
		Item itemObj = itemBoObj.getItemById(item.getItemId());
		if (itemObj != null) {
			itemVo.setItem(itemObj);
		}

		itemVo.setOrderedPrice(item.getOrderedPrice());
		itemVo.setPosition(item.getPosition());
		itemVo.setRack(item.getRack());
		itemVo.setReceiveDate(item.getReceiveDate());
		itemVo.setReceivedPrice(item.getReceivedPrice());
		itemVo.setRemarks(item.getRemarks());
		itemVo.setRoom(item.getRoom());
		itemVo.setStatus(item.getStatus());
		itemVo.setStoreGrnHdrId(item.getStoreGrnHdrId());
		itemVo.setStoreId(item.getStoreId());
		if (item.getUomCode() != null && item.getUomCode().length() > 0) {
			QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(item.getUomCode());
			itemVo.setUomCode(quantityUnitObj);
		}

		return itemVo;
	}

	private StoreGoodReceiveLineItem getStoreGoodReceiveLineItem(StoreGoodReceiveItemVo item) {
		StoreGoodReceiveLineItem itemVo = new StoreGoodReceiveLineItem();
		itemVo.setActualQuantity(item.getActualQuantity());
		itemVo.setAdditionalRequirements(item.getAdditionalRequirements());
		itemVo.setAdvisedQuantity(item.getAdvisedQuantity());
		if (item.getApproveFirstDate() != null) {
			itemVo.setApproveFirstDate(item.getApproveFirstDate());
		}

		if (item.getApproverFirst() != null) {
			itemVo.setApproverFirst(item.getApproverFirst());
		}
		if (item.getApproverSecond() != null) {
			itemVo.setApproverSecond(item.getApproverSecond());
		}
		if (item.getApproveSecondDate() != null) {
			itemVo.setApproveSecondDate(item.getApproveSecondDate());
		}

		itemVo.setBatchno(item.getBatchno());
		itemVo.setClaims(item.getClaims());
		itemVo.setDebitNotesFlag(item.getDebitNotesFlag());
		itemVo.setDeviation(item.getDeviation());
		if (item.getExpiryDate() != null) {
			itemVo.setExpiryDate(item.getExpiryDate());
		}
		itemVo.setFloor(item.getFloor());
		itemVo.setId(item.getId());
		itemVo.setItemId(item.getItem().getId());

		itemVo.setOrderedPrice(item.getOrderedPrice());
		itemVo.setPosition(item.getPosition());
		itemVo.setRack(item.getRack());
		
		itemVo.setReceiveDate(item.getReceiveDate());
		itemVo.setReceivedPrice(item.getReceivedPrice());
		itemVo.setRemarks(item.getRemarks());
		itemVo.setRoom(item.getRoom());
		itemVo.setStatus(item.getStatus());
		itemVo.setStoreGrnHdrId(item.getStoreGrnHdrId());
		itemVo.setStoreId(item.getStoreId());

		if (item.getUomCode() != null) {
			itemVo.setUomCode(item.getUomCode().getId());
		}

		return itemVo;
	}

	private MaterialGoodReceiveItemVo getMaterialGoodReceiveItemVo(MaterialGoodReceiveLineItem item, String poId) {

		MaterialGoodReceiveItemVo itemVo = new MaterialGoodReceiveItemVo();

		if (item.getActualQuality() != 0) {
			Quality actualQuality = qualityRepository.findOne(item.getActualQuality());
			itemVo.setActualQuality(actualQuality);
		}

		if (item.getAdvisedQuality() != 0) {
			Quality advisedQuality = qualityRepository.findOne(item.getAdvisedQuality());
			itemVo.setAdvisedQuality(advisedQuality);
		}

		List<POLineItem> poItemList = pOLineItemRepository.findByPoIdAndItemIdAndQualityCode(poId, item.getItemId(),
				item.getAdvisedQuality());

		if (null != poItemList && poItemList.size() > 0) {
			itemVo.setAllowableMoisturePercentage(poItemList.get(0).getAllowableMoisturePercentage());
		}

		if (item.getClaimsQuality() != null) {
			itemVo.setClaimsQuality(item.getClaimsQuality());
		}

		itemVo.setActualWeight(item.getActualWeight());

		itemVo.setAdvisedWeight(item.getAdvisedWeight());

		if (item.getApproveFirstDate() != null) {
			itemVo.setApproveFirstDate(item.getApproveFirstDate());
		}

		if (item.getApproverFirst() != null) {
			itemVo.setApproverFirst(item.getApproverFirst());
		}
		if (item.getApproverSecond() != null) {
			itemVo.setApproverSecond(item.getApproverSecond());
		}
		if (item.getApproveSecondDate() != null) {
			itemVo.setApproveSecondDate(item.getApproveSecondDate());
		}
		Item itemObj = itemBoObj.getItemById(item.getItemId());
		if (itemObj != null) {
			itemVo.setItem(itemObj);
		}
		if (item.getQuantityUnit() != null && item.getQuantityUnit().length() > 0) {
			QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(item.getQuantityUnit());
			itemVo.setQuantityUnit(quantityUnitObj);
		}
		if (item.getAdvisedItemId() != null) {
			Item advisedItemObj = itemBoObj.getItemById(item.getAdvisedItemId());
			if (advisedItemObj != null) {
				itemVo.setAdvisedItem(advisedItemObj);
			}

		}

		itemVo.setClaimsCondition(item.getClaimsCondition());
		itemVo.setDebitNotesFlag(item.getDebitNotesFlag());
		itemVo.setDeviation(item.getDeviation());
		itemVo.setId(item.getId());
		itemVo.setMarka(item.getMarka());
		itemVo.setMaterialGrnHdrId(item.getMaterialGrnHdrId());
		itemVo.setQuantity(item.getQuantity());
		itemVo.setRate(item.getRate());
		itemVo.setRemarks(item.getRemarks());
		itemVo.setStatus(item.getStatus());
		itemVo.setTotalPrice(item.getTotalPrice());
		itemVo.setWarehouseNo(item.getWarehouseNo());
		if (item.getBale() > 0) {
			itemVo.setUnitConversionType("BALE");
			itemVo.setConversionQuantity(item.getBale());
			itemVo.setConversionActualQuantity(item.getActualBale());
		}
		if (item.getLoose() > 0) {
			itemVo.setUnitConversionType("LOOSE");
			itemVo.setConversionQuantity(item.getLoose());
			itemVo.setConversionActualQuantity(item.getActualLoose());
		}

		return itemVo;
	}

	private MaterialGoodReceiveLineItem getMaterialGoodReceiveLineItem(MaterialGoodReceiveItemVo item) {

		MaterialGoodReceiveLineItem itemVo = new MaterialGoodReceiveLineItem();

		if (item.getActualQuality() != null) {
			itemVo.setActualQuality(item.getActualQuality().getId());
		}

		if (item.getAdvisedQuality() != null) {
			itemVo.setAdvisedQuality(item.getAdvisedQuality().getId());
		}

		if (item.getClaimsQuality() != null) {
			itemVo.setClaimsQuality(item.getClaimsQuality());
		}

		itemVo.setActualWeight(item.getActualWeight());

		itemVo.setAdvisedWeight(item.getAdvisedWeight());

		if (item.getApproveFirstDate() != null) {
			itemVo.setApproveFirstDate(item.getApproveFirstDate());
		}

		if (item.getApproverFirst() != null) {
			itemVo.setApproverFirst(item.getApproverFirst());
		}
		if (item.getApproverSecond() != null) {
			itemVo.setApproverSecond(item.getApproverSecond());
		}
		if (item.getApproveSecondDate() != null) {
			itemVo.setApproveSecondDate(item.getApproveSecondDate());
		}
		itemVo.setItemId(item.getItem().getId());

		if (item.getAdvisedItem() != null) {
			itemVo.setAdvisedItemId(item.getAdvisedItem().getId());
		}
		if (item.getQuantityUnit() != null) {
			itemVo.setQuantityUnit(item.getQuantityUnit().getId());
		}

		if (null != item.getUnitConversionType()) {
			if (item.getUnitConversionType().equalsIgnoreCase("LOOSE")) {
				itemVo.setLoose(item.getConversionQuantity());
				itemVo.setActualLoose(item.getConversionActualQuantity());
			} else if (item.getUnitConversionType().equalsIgnoreCase("BALE")) {
				itemVo.setBale(item.getConversionQuantity());
				itemVo.setActualBale(item.getConversionActualQuantity());
			}

		}

		itemVo.setClaimsCondition(item.getClaimsCondition());
		itemVo.setDebitNotesFlag(item.getDebitNotesFlag());
		itemVo.setDeviation(item.getDeviation());
		itemVo.setId(item.getId());
		itemVo.setMarka(item.getMarka());
		itemVo.setMaterialGrnHdrId(item.getMaterialGrnHdrId());
		itemVo.setQuantity(item.getQuantity());
		itemVo.setRate(item.getRate());
		itemVo.setRemarks(item.getRemarks());
		itemVo.setStatus(item.getStatus());
		itemVo.setTotalPrice(item.getTotalPrice());
		itemVo.setWarehouseNo(item.getWarehouseNo());

		return itemVo;
	}

	@Override
	public List<MaterialGoodReceiveHeader> getAllMaterialGoodReceiveHeader() {
		List<MaterialGoodReceiveHeader> list = new ArrayList<MaterialGoodReceiveHeader>();
		for (MaterialGoodReceiveHeader materialGoodReceiveHeaderObj : materialGoodReceiveHeaderRepository.findAll()) {
			list.add(materialGoodReceiveHeaderObj);
		}
		return list.stream().sorted(Comparator.comparing(MaterialGoodReceiveHeader::getModOn).reversed())
				.collect(Collectors.toList());

	}

	@Override
	public List<MaterialGoodReceiveHeader> getAllMaterialGoodReceiveHeaderByStatus(String status) {
		List<MaterialGoodReceiveHeader> list = new ArrayList<MaterialGoodReceiveHeader>();
		for (MaterialGoodReceiveHeader materialGoodReceiveHeaderObj : materialGoodReceiveHeaderRepository
				.findByStatus(status)) {
			list.add(materialGoodReceiveHeaderObj);
		}
		return list.stream().sorted(Comparator.comparing(MaterialGoodReceiveHeader::getModOn).reversed())
				.collect(Collectors.toList());

	}

	@Override
	public List<MaterialGoodReceiveHeader> getAllMaterialGoodReceiveHeaderBySupplierId(String supplierId) {
		List<MaterialGoodReceiveHeader> list = new ArrayList<MaterialGoodReceiveHeader>();
		for (MaterialGoodReceiveHeader materialGoodReceiveHeaderObj : materialGoodReceiveHeaderRepository
				.findBySupplierId(supplierId)) {
			list.add(materialGoodReceiveHeaderObj);
		}
		return list.stream().sorted(Comparator.comparing(MaterialGoodReceiveHeader::getModOn).reversed())
				.collect(Collectors.toList());

	}

	@Override
	public List<MaterialGoodReceiveHeader> getAllMaterialGoodReceiveHeaderByWarehouseNo(String warehouseNo) {
		List<MaterialGoodReceiveHeader> list = new ArrayList<MaterialGoodReceiveHeader>();
		for (MaterialGoodReceiveHeader materialGoodReceiveHeaderObj : materialGoodReceiveHeaderRepository
				.findByWarehouseNo(warehouseNo)) {
			list.add(materialGoodReceiveHeaderObj);
		}
		return list.stream().sorted(Comparator.comparing(MaterialGoodReceiveHeader::getModOn).reversed())
				.collect(Collectors.toList());

	}

	@Override
	public MaterialGoodReceiveHeader getAllMaterialGoodReceiveHeaderById(long id) {
		MaterialGoodReceiveHeader materialGoodReceiveHeaderObj = null;
		materialGoodReceiveHeaderObj = materialGoodReceiveHeaderRepository.findOne(id);
		return materialGoodReceiveHeaderObj;

	}

	@Override
	public MaterialGoodReceiveHeader getAllMaterialGoodReceiveHeaderByChalan(long chalanNo) {
		MaterialGoodReceiveHeader resultMaterialGoodReceiveHeaderObj = null;
		List<MaterialGoodReceiveHeader> list = new ArrayList<MaterialGoodReceiveHeader>();
		for (MaterialGoodReceiveHeader materialGoodReceiveHeaderObj : materialGoodReceiveHeaderRepository
				.findBychalanNo(chalanNo)) {
			if (materialGoodReceiveHeaderObj.getAgentId() == null) {
				list.add(materialGoodReceiveHeaderObj);
			}

		}
		if (list.size() > 0) {
			resultMaterialGoodReceiveHeaderObj = list.get(0);
		}

		return resultMaterialGoodReceiveHeaderObj;

	}

	@Override
	public MaterialGoodReceiveHeader getAllMaterialGoodReceiveHeaderByPoID(String poId) {
		MaterialGoodReceiveHeader resultMaterialGoodReceiveHeaderObj = null;
		List<MaterialGoodReceiveHeader> list = new ArrayList<MaterialGoodReceiveHeader>();
		for (MaterialGoodReceiveHeader materialGoodReceiveHeaderObj : materialGoodReceiveHeaderRepository
				.findByPoId(poId)) {
			list.add(materialGoodReceiveHeaderObj);
		}
		if (list.size() > 0) {
			resultMaterialGoodReceiveHeaderObj = list.get(0);
		}

		return resultMaterialGoodReceiveHeaderObj;

	}

	@Override
	public List<MaterialGoodReceiveDetails> getAllMaterialGoodReceiveDetails() {
		List<MaterialGoodReceiveDetails> materialGoodReceiveDetailsList = new ArrayList<MaterialGoodReceiveDetails>();
		List<MaterialGoodReceiveHeader> materialGoodReceiveHeaders = materialGoodReceiveHeaderRepository.findAll()
				.stream().sorted(Comparator.comparing(MaterialGoodReceiveHeader::getModOn).reversed())
				.collect(Collectors.toList());

		for (MaterialGoodReceiveHeader materialGoodReceiveHeaderObj : materialGoodReceiveHeaders) {
			List<MaterialGoodReceiveItemVo> materialGoodReceiveItemVoList = new ArrayList<MaterialGoodReceiveItemVo>();
			List<MaterialGoodReceiveLineItem> materialGoodReceiveLineItemList = materialGoodReceiveItemRepository
					.findByMaterialGrnHdrId(materialGoodReceiveHeaderObj.getId());
			for (MaterialGoodReceiveLineItem materialGoodReceiveLineItem : materialGoodReceiveLineItemList) {
				materialGoodReceiveItemVoList.add(getMaterialGoodReceiveItemVo(materialGoodReceiveLineItem,
						materialGoodReceiveHeaderObj.getPoId()));
			}
			MaterialGoodReceiveDetails obj = new MaterialGoodReceiveDetails();
			obj.setMaterialGoodReceiveHeader(materialGoodReceiveHeaderObj);
			obj.setMaterialGrnItemList(materialGoodReceiveItemVoList);
			materialGoodReceiveDetailsList.add(obj);

		}

		return materialGoodReceiveDetailsList;
	}

	@Override
	public List<MaterialGoodReceiveDetails> getAllMaterialGoodReceiveDetailsByStatus(String status) {
		List<MaterialGoodReceiveDetails> materialGoodReceiveDetailsList = new ArrayList<MaterialGoodReceiveDetails>();

		List<MaterialGoodReceiveHeader> materialGoodReceiveHeaders = materialGoodReceiveHeaderRepository
				.findByStatus(status).stream()
				.sorted(Comparator.comparing(MaterialGoodReceiveHeader::getModOn).reversed())
				.collect(Collectors.toList());

		for (MaterialGoodReceiveHeader materialGoodReceiveHeaderObj : materialGoodReceiveHeaders) {
			List<MaterialGoodReceiveItemVo> materialGoodReceiveItemVoList = new ArrayList<MaterialGoodReceiveItemVo>();
			List<MaterialGoodReceiveLineItem> materialGoodReceiveLineItemList = materialGoodReceiveItemRepository
					.findByMaterialGrnHdrId(materialGoodReceiveHeaderObj.getId());
			for (MaterialGoodReceiveLineItem materialGoodReceiveLineItem : materialGoodReceiveLineItemList) {
				materialGoodReceiveItemVoList.add(getMaterialGoodReceiveItemVo(materialGoodReceiveLineItem,
						materialGoodReceiveHeaderObj.getPoId()));
			}
			MaterialGoodReceiveDetails obj = new MaterialGoodReceiveDetails();
			obj.setMaterialGoodReceiveHeader(materialGoodReceiveHeaderObj);
			obj.setMaterialGrnItemList(materialGoodReceiveItemVoList);
			materialGoodReceiveDetailsList.add(obj);

		}

		return materialGoodReceiveDetailsList;
	}

	@Override
	public List<MaterialGoodReceiveDetails> getAllMaterialGoodReceiveDetailsBySupplierId(String supplierId) {
		List<MaterialGoodReceiveDetails> materialGoodReceiveDetailsList = new ArrayList<MaterialGoodReceiveDetails>();

		List<MaterialGoodReceiveHeader> materialGoodReceiveHeaders = materialGoodReceiveHeaderRepository
				.findBySupplierId(supplierId).stream()
				.sorted(Comparator.comparing(MaterialGoodReceiveHeader::getModOn).reversed())
				.collect(Collectors.toList());

		for (MaterialGoodReceiveHeader materialGoodReceiveHeaderObj : materialGoodReceiveHeaders) {
			List<MaterialGoodReceiveItemVo> materialGoodReceiveItemVoList = new ArrayList<MaterialGoodReceiveItemVo>();
			List<MaterialGoodReceiveLineItem> materialGoodReceiveLineItemList = materialGoodReceiveItemRepository
					.findByMaterialGrnHdrId(materialGoodReceiveHeaderObj.getId());
			for (MaterialGoodReceiveLineItem materialGoodReceiveLineItem : materialGoodReceiveLineItemList) {
				materialGoodReceiveItemVoList.add(getMaterialGoodReceiveItemVo(materialGoodReceiveLineItem,
						materialGoodReceiveHeaderObj.getPoId()));
			}
			MaterialGoodReceiveDetails obj = new MaterialGoodReceiveDetails();
			obj.setMaterialGoodReceiveHeader(materialGoodReceiveHeaderObj);
			obj.setMaterialGrnItemList(materialGoodReceiveItemVoList);
			materialGoodReceiveDetailsList.add(obj);

		}

		return materialGoodReceiveDetailsList;
	}

	@Override
	public List<MaterialGoodReceiveDetails> getAllMaterialGoodReceiveDetailsByWarehouseNo(String warehouseNo) {
		List<MaterialGoodReceiveDetails> materialGoodReceiveDetailsList = new ArrayList<MaterialGoodReceiveDetails>();

		List<MaterialGoodReceiveHeader> materialGoodReceiveHeaders = materialGoodReceiveHeaderRepository
				.findByWarehouseNo(warehouseNo).stream()
				.sorted(Comparator.comparing(MaterialGoodReceiveHeader::getModOn).reversed())
				.collect(Collectors.toList());

		for (MaterialGoodReceiveHeader materialGoodReceiveHeaderObj : materialGoodReceiveHeaders) {
			List<MaterialGoodReceiveItemVo> materialGoodReceiveItemVoList = new ArrayList<MaterialGoodReceiveItemVo>();
			List<MaterialGoodReceiveLineItem> materialGoodReceiveLineItemList = materialGoodReceiveItemRepository
					.findByMaterialGrnHdrId(materialGoodReceiveHeaderObj.getId());
			for (MaterialGoodReceiveLineItem materialGoodReceiveLineItem : materialGoodReceiveLineItemList) {
				materialGoodReceiveItemVoList.add(getMaterialGoodReceiveItemVo(materialGoodReceiveLineItem,
						materialGoodReceiveHeaderObj.getPoId()));
			}
			MaterialGoodReceiveDetails obj = new MaterialGoodReceiveDetails();
			obj.setMaterialGoodReceiveHeader(materialGoodReceiveHeaderObj);
			obj.setMaterialGrnItemList(materialGoodReceiveItemVoList);
			materialGoodReceiveDetailsList.add(obj);

		}

		return materialGoodReceiveDetailsList;
	}

	@Override
	public List<JuteGRNEntry> getMaterialGoodReceiveChalanListBySupplier(String supplierCode) {
		List<JuteGRNEntry> mrChalanList = null;
		List<JuteGRNEntry> list = new ArrayList<JuteGRNEntry>();
		List<POHeader> pOHeaderList = null;
		String approvedStatus = "3";

		pOHeaderList = pOHeaderRepository.findBySupplierIdAndStatus(supplierCode, approvedStatus);

		for (POHeader headerObj : pOHeaderList) {
			mrChalanList = juteGRNEntryRepository.findByPoId(String.valueOf(headerObj.getId()));
			if (null != mrChalanList && mrChalanList.size() > 0) {
				list.addAll(mrChalanList);
			}
		}
		return list.stream().sorted(Comparator.comparing(JuteGRNEntry::getPoId)).collect(Collectors.toList());
	}

	@Override
	public MaterialGoodReceiveDetails getAllMaterialGoodReceiveDetailsByChalan(long chalanNo) {
		MaterialGoodReceiveHeader resultMaterialGoodReceiveHeaderObj = null;

		List<MaterialGoodReceiveHeader> list = new ArrayList<MaterialGoodReceiveHeader>();

		for (MaterialGoodReceiveHeader materialGoodReceiveHeaderObj : materialGoodReceiveHeaderRepository
				.findBychalanNo(chalanNo)) {
			if (materialGoodReceiveHeaderObj.getAgentId() == null) {
				list.add(materialGoodReceiveHeaderObj);
			}

		}
		if (list.size() > 0) {
			resultMaterialGoodReceiveHeaderObj = list.get(0);
		}

		List<MaterialGoodReceiveItemVo> materialGoodReceiveItemVoList = new ArrayList<MaterialGoodReceiveItemVo>();
		List<MaterialGoodReceiveLineItem> materialGoodReceiveLineItemList = materialGoodReceiveItemRepository
				.findByMaterialGrnHdrId(resultMaterialGoodReceiveHeaderObj.getId());
		for (MaterialGoodReceiveLineItem materialGoodReceiveLineItem : materialGoodReceiveLineItemList) {
			materialGoodReceiveItemVoList.add(getMaterialGoodReceiveItemVo(materialGoodReceiveLineItem,
					resultMaterialGoodReceiveHeaderObj.getPoId()));
		}
		MaterialGoodReceiveDetails obj = new MaterialGoodReceiveDetails();
		obj.setMaterialGoodReceiveHeader(resultMaterialGoodReceiveHeaderObj);
		obj.setMaterialGrnItemList(materialGoodReceiveItemVoList);

		return obj;
	}

	@Override
	public MaterialGoodReceiveDetails getAllMaterialGoodReceiveDetailsById(long id) {
		MaterialGoodReceiveHeader resultMaterialGoodReceiveHeaderObj = materialGoodReceiveHeaderRepository.findOne(id);
		List<MaterialGoodReceiveItemVo> materialGoodReceiveItemVoList = new ArrayList<MaterialGoodReceiveItemVo>();
		List<MaterialGoodReceiveLineItem> materialGoodReceiveLineItemList = materialGoodReceiveItemRepository
				.findByMaterialGrnHdrId(resultMaterialGoodReceiveHeaderObj.getId());
		long mrno = 0;
		if (resultMaterialGoodReceiveHeaderObj.getSourceId() != null) {
			mrno = Long.parseLong(resultMaterialGoodReceiveHeaderObj.getSourceId());
		} else {
			mrno = resultMaterialGoodReceiveHeaderObj.getId();
		}

		JuteGRNEntry entryhdr = juteGRNEntryRepository.findByMrNo(mrno);
		List<JuteGateEntryDtl> entrydtl = juteentrydtlRepository.findByHdrId(entryhdr.getId());

		for (MaterialGoodReceiveLineItem materialGoodReceiveLineItem : materialGoodReceiveLineItemList) {

			MaterialGoodReceiveItemVo materialgoodreceiveitemvo = getMaterialGoodReceiveItemVo(
					materialGoodReceiveLineItem, resultMaterialGoodReceiveHeaderObj.getPoId());
			Quality quality = new Quality();
			Quality quality1 = new Quality();
			ItemDTO item = new ItemDTO();
			if (resultMaterialGoodReceiveHeaderObj.getStatus().equalsIgnoreCase("16")) {
				for (int i = 0; i < entrydtl.size(); i++) {
					quality = qualityRepository.findOne(materialGoodReceiveLineItem.getActualQuality());
					quality1 = qualityRepository.findByName(entrydtl.get(i).getActualQuality()).get(0);
					item = prepareItemDTO(itemRepository.findByName(entrydtl.get(i).getActualJuteTyp()));
					if (entrydtl.get(i).getActualQuality().equals(quality.getName())) {
						/*
						 * if (entrydtl.get(i).getReceivedIn().equalsIgnoreCase("BALE")) {
						 * materialgoodreceiveitemvo.setActualWeight(
						 * Float.parseFloat(String.valueOf(entrydtl.get(i).getActualQuantity()))); }
						 * else if (entrydtl.get(i).getReceivedIn().equalsIgnoreCase("LOOSE")) {
						 * materialgoodreceiveitemvo.setActualWeight(entrydtl.get(i).getActualQuantity()
						 * ); }
						 */
						materialgoodreceiveitemvo.setConversionActualQuantity(entrydtl.get(i).getActualQuantity());
						materialgoodreceiveitemvo.setActualQuality(quality1);
						materialgoodreceiveitemvo.setItem(prepareItemEntity(item));

					}
				}
			}

			// d
			materialGoodReceiveItemVoList.add(materialgoodreceiveitemvo);

		}
		MaterialGoodReceiveDetails obj = new MaterialGoodReceiveDetails();
		obj.setMaterialGoodReceiveHeader(resultMaterialGoodReceiveHeaderObj);
		obj.setMaterialGrnItemList(materialGoodReceiveItemVoList);

		return obj;
	}

	@Override
	public MaterialGoodReceiveDetails getAllMaterialGoodReceiveDetailsByPoID(String poId) {
		MaterialGoodReceiveHeader resultMaterialGoodReceiveHeaderObj = null;
		List<MaterialGoodReceiveHeader> list = new ArrayList<MaterialGoodReceiveHeader>();

		for (MaterialGoodReceiveHeader materialGoodReceiveHeaderObj : materialGoodReceiveHeaderRepository
				.findByPoId(poId)) {
			list.add(materialGoodReceiveHeaderObj);
		}
		if (list.size() > 0) {
			resultMaterialGoodReceiveHeaderObj = list.get(0);
		}

		List<MaterialGoodReceiveItemVo> materialGoodReceiveItemVoList = new ArrayList<MaterialGoodReceiveItemVo>();
		List<MaterialGoodReceiveLineItem> materialGoodReceiveLineItemList = materialGoodReceiveItemRepository
				.findByMaterialGrnHdrId(resultMaterialGoodReceiveHeaderObj.getId());
		for (MaterialGoodReceiveLineItem materialGoodReceiveLineItem : materialGoodReceiveLineItemList) {
			materialGoodReceiveItemVoList.add(getMaterialGoodReceiveItemVo(materialGoodReceiveLineItem,
					resultMaterialGoodReceiveHeaderObj.getPoId()));
		}
		MaterialGoodReceiveDetails obj = new MaterialGoodReceiveDetails();
		obj.setMaterialGoodReceiveHeader(resultMaterialGoodReceiveHeaderObj);
		obj.setMaterialGrnItemList(materialGoodReceiveItemVoList);

		return obj;
	}

	@Override
	public List<StoreGoodReceiveDetails> getAllStoreGoodReceiveDetails() {
		List<StoreGoodReceiveDetails> storeGoodReceiveDetailsList = new ArrayList<StoreGoodReceiveDetails>();
		List<StoreGoodReceiveHeader> storeGoodReceiveHeader = storeGoodReceiveHeaderRepository.findAll().stream()
				.sorted(Comparator.comparing(StoreGoodReceiveHeader::getModOn).reversed()).collect(Collectors.toList());
		for (StoreGoodReceiveHeader storeGoodReceiveHeaderObj : storeGoodReceiveHeader) {
			List<StoreGoodReceiveItemVo> storeGoodReceiveItemVoList = new ArrayList<StoreGoodReceiveItemVo>();
			List<StoreGoodReceiveLineItem> storeGoodReceiveLineItemList = storeGoodReceiveItemRepository
					.findByStoreGrnHdrId(storeGoodReceiveHeaderObj.getId());
			for (StoreGoodReceiveLineItem storeGoodReceiveLineItem : storeGoodReceiveLineItemList) {
				storeGoodReceiveItemVoList.add(getStoreGoodReceiveItemVo(storeGoodReceiveLineItem));
			}
			StoreGoodReceiveDetails obj = new StoreGoodReceiveDetails();
			obj.setStoreGoodReceiveHeader(storeGoodReceiveHeaderObj);
			obj.setStoreGrnItemList(storeGoodReceiveItemVoList);
			storeGoodReceiveDetailsList.add(obj);

		}
		return storeGoodReceiveDetailsList;

	}

	@Override
	public List<StoreGoodReceiveDetails> getAllStoreGoodReceiveDetailsByStatus(String status) {
		List<StoreGoodReceiveDetails> storeGoodReceiveDetailsList = new ArrayList<StoreGoodReceiveDetails>();
		List<StoreGoodReceiveHeader> storeGoodReceiveHeader = storeGoodReceiveHeaderRepository.findByStatus(status)
				.stream().sorted(Comparator.comparing(StoreGoodReceiveHeader::getModOn).reversed())
				.collect(Collectors.toList());
		for (StoreGoodReceiveHeader storeGoodReceiveHeaderObj : storeGoodReceiveHeader) {
			List<StoreGoodReceiveItemVo> storeGoodReceiveItemVoList = new ArrayList<StoreGoodReceiveItemVo>();
			List<StoreGoodReceiveLineItem> storeGoodReceiveLineItemList = storeGoodReceiveItemRepository
					.findByStoreGrnHdrId(storeGoodReceiveHeaderObj.getId());
			for (StoreGoodReceiveLineItem storeGoodReceiveLineItem : storeGoodReceiveLineItemList) {
				storeGoodReceiveItemVoList.add(getStoreGoodReceiveItemVo(storeGoodReceiveLineItem));
			}
			StoreGoodReceiveDetails obj = new StoreGoodReceiveDetails();
			obj.setStoreGoodReceiveHeader(storeGoodReceiveHeaderObj);
			obj.setStoreGrnItemList(storeGoodReceiveItemVoList);
			storeGoodReceiveDetailsList.add(obj);

		}
		return storeGoodReceiveDetailsList;

	}

	@Override
	public List<StoreGoodReceiveDetails> getAllStoreGoodReceiveDetailsBySupplierId(String supplierId) {
		List<StoreGoodReceiveDetails> storeGoodReceiveDetailsList = new ArrayList<StoreGoodReceiveDetails>();
		List<StoreGoodReceiveHeader> storeGoodReceiveHeader = storeGoodReceiveHeaderRepository
				.findBySupplierId(supplierId).stream()
				.sorted(Comparator.comparing(StoreGoodReceiveHeader::getModOn).reversed()).collect(Collectors.toList());
		for (StoreGoodReceiveHeader storeGoodReceiveHeaderObj : storeGoodReceiveHeader) {
			List<StoreGoodReceiveItemVo> storeGoodReceiveItemVoList = new ArrayList<StoreGoodReceiveItemVo>();
			List<StoreGoodReceiveLineItem> storeGoodReceiveLineItemList = storeGoodReceiveItemRepository
					.findByStoreGrnHdrId(storeGoodReceiveHeaderObj.getId());
			for (StoreGoodReceiveLineItem storeGoodReceiveLineItem : storeGoodReceiveLineItemList) {
				storeGoodReceiveItemVoList.add(getStoreGoodReceiveItemVo(storeGoodReceiveLineItem));
			}
			StoreGoodReceiveDetails obj = new StoreGoodReceiveDetails();
			obj.setStoreGoodReceiveHeader(storeGoodReceiveHeaderObj);
			obj.setStoreGrnItemList(storeGoodReceiveItemVoList);
			storeGoodReceiveDetailsList.add(obj);

		}
		return storeGoodReceiveDetailsList;
	}

	@Override
	public List<StoreGoodReceiveDetails> getAllStoreGoodReceiveDetailsByStoreNo(String storeNo) {
		List<StoreGoodReceiveDetails> storeGoodReceiveDetailsList = new ArrayList<StoreGoodReceiveDetails>();
		List<StoreGoodReceiveHeader> storeGoodReceiveHeader = storeGoodReceiveHeaderRepository.findByStoreNo(storeNo)
				.stream().sorted(Comparator.comparing(StoreGoodReceiveHeader::getModOn).reversed())
				.collect(Collectors.toList());
		for (StoreGoodReceiveHeader storeGoodReceiveHeaderObj : storeGoodReceiveHeader) {
			List<StoreGoodReceiveItemVo> storeGoodReceiveItemVoList = new ArrayList<StoreGoodReceiveItemVo>();
			List<StoreGoodReceiveLineItem> storeGoodReceiveLineItemList = storeGoodReceiveItemRepository
					.findByStoreGrnHdrId(storeGoodReceiveHeaderObj.getId());
			for (StoreGoodReceiveLineItem storeGoodReceiveLineItem : storeGoodReceiveLineItemList) {
				storeGoodReceiveItemVoList.add(getStoreGoodReceiveItemVo(storeGoodReceiveLineItem));
			}
			StoreGoodReceiveDetails obj = new StoreGoodReceiveDetails();
			obj.setStoreGoodReceiveHeader(storeGoodReceiveHeaderObj);
			obj.setStoreGrnItemList(storeGoodReceiveItemVoList);
			storeGoodReceiveDetailsList.add(obj);

		}
		return storeGoodReceiveDetailsList;
	}

	@Override
	public StoreGoodReceiveDetails getAllStoreGoodReceiveDetailsByChalan(long chalanNo, String supplierId,
			String poId) {
		StoreGoodReceiveHeader resultStoreGoodReceiveHeaderObj = null;
		List<StoreGoodReceiveHeader> list = new ArrayList<StoreGoodReceiveHeader>();

		for (StoreGoodReceiveHeader storeGoodReceiveHeaderObj : storeGoodReceiveHeaderRepository
				.findByChalanNoAndSupplierIdAndPoId(chalanNo, supplierId, poId)) {
			list.add(storeGoodReceiveHeaderObj);
		}
		if (list.size() > 0) {
			resultStoreGoodReceiveHeaderObj = list.get(0);
		}

		List<StoreGoodReceiveItemVo> storeGoodReceiveItemVoList = new ArrayList<StoreGoodReceiveItemVo>();
		if (resultStoreGoodReceiveHeaderObj != null) {
			List<StoreGoodReceiveLineItem> storeGoodReceiveLineItemList = storeGoodReceiveItemRepository
					.findByStoreGrnHdrId(resultStoreGoodReceiveHeaderObj.getId());
			for (StoreGoodReceiveLineItem storeGoodReceiveLineItem : storeGoodReceiveLineItemList) {
				storeGoodReceiveItemVoList.add(getStoreGoodReceiveItemVo(storeGoodReceiveLineItem));
			}
		}

		StoreGoodReceiveDetails obj = new StoreGoodReceiveDetails();
		obj.setStoreGoodReceiveHeader(resultStoreGoodReceiveHeaderObj);
		obj.setStoreGrnItemList(storeGoodReceiveItemVoList);

		return obj;
	}

	@Override
	public StoreGoodReceiveDetails getAllStoreGoodReceiveDetailsById(long id) {
		StoreGoodReceiveHeader resultStoreGoodReceiveHeaderObj = storeGoodReceiveHeaderRepository.findOne(id);
		List<StoreGoodReceiveItemVo> storeGoodReceiveItemVoList = new ArrayList<StoreGoodReceiveItemVo>();
		List<StoreGoodReceiveLineItem> storeGoodReceiveLineItemList = storeGoodReceiveItemRepository
				.findByStoreGrnHdrId(resultStoreGoodReceiveHeaderObj.getId());
		for (StoreGoodReceiveLineItem storeGoodReceiveLineItem : storeGoodReceiveLineItemList) {
			storeGoodReceiveItemVoList.add(getStoreGoodReceiveItemVo(storeGoodReceiveLineItem));
		}
		StoreGoodReceiveDetails obj = new StoreGoodReceiveDetails();
		obj.setStoreGoodReceiveHeader(resultStoreGoodReceiveHeaderObj);
		obj.setStoreGrnItemList(storeGoodReceiveItemVoList);

		return obj;
	}

	@Override
	public StoreGoodReceiveDetails getAllStoreGoodReceiveDetailsByPoID(String poId) {
		StoreGoodReceiveHeader resultStoreGoodReceiveHeaderObj = null;
		List<StoreGoodReceiveHeader> list = new ArrayList<StoreGoodReceiveHeader>();

		for (StoreGoodReceiveHeader storeGoodReceiveHeaderObj : storeGoodReceiveHeaderRepository.findByPoId(poId)) {
			list.add(storeGoodReceiveHeaderObj);
		}
		if (list.size() > 0) {
			resultStoreGoodReceiveHeaderObj = list.get(0);
		}

		List<StoreGoodReceiveItemVo> storeGoodReceiveItemVoList = new ArrayList<StoreGoodReceiveItemVo>();
		List<StoreGoodReceiveLineItem> storeGoodReceiveLineItemList = storeGoodReceiveItemRepository
				.findByStoreGrnHdrId(resultStoreGoodReceiveHeaderObj.getId());
		for (StoreGoodReceiveLineItem storeGoodReceiveLineItem : storeGoodReceiveLineItemList) {
			storeGoodReceiveItemVoList.add(getStoreGoodReceiveItemVo(storeGoodReceiveLineItem));
		}
		StoreGoodReceiveDetails obj = new StoreGoodReceiveDetails();
		obj.setStoreGoodReceiveHeader(resultStoreGoodReceiveHeaderObj);
		obj.setStoreGrnItemList(storeGoodReceiveItemVoList);

		return obj;
	}

	@Override
	public MaterialGoodReceiveDetails addMaterialGoodReceiveDetails(
			MaterialGoodReceiveDetails materialGoodReceiveDetails) {

		MaterialGoodReceiveDetails obj = new MaterialGoodReceiveDetails();
		MaterialGoodReceiveHeader headerObj = null;
		MaterialGoodReceiveLineItem materialGoodReceiveLineItemObj = null;
		List<MaterialGoodReceiveItemVo> materialGoodReceiveItemVoList = new ArrayList<MaterialGoodReceiveItemVo>();
		List<MaterialGoodReceiveItemVo> resultMaterialGoodReceiveItemVoList = new ArrayList<MaterialGoodReceiveItemVo>();
		// System.out.println("2. @@@@@@@@@@@@@@@@@
		// "+materialGoodReceiveDetails.getMaterialGoodReceiveHeader().getId());
		if (null != materialGoodReceiveDetails) {
			MaterialGoodReceiveHeader materialGoodReceiveHeader = materialGoodReceiveDetails
					.getMaterialGoodReceiveHeader();
			materialGoodReceiveHeader.setModOn(new Date());
			materialGoodReceiveHeader.setModBy(materialGoodReceiveHeader.getSubmitter());
			// materialGoodReceiveHeader.setCreateDate(new Date());
			headerObj = materialGoodReceiveHeaderRepository.save(materialGoodReceiveHeader);
			materialGoodReceiveItemVoList = materialGoodReceiveDetails.getMaterialGrnItemList();

			long mrno = 0;
			if (materialGoodReceiveDetails.getMaterialGoodReceiveHeader().getSourceId() != null) {
				mrno = Long.parseLong(materialGoodReceiveDetails.getMaterialGoodReceiveHeader().getSourceId());
			} else {
				mrno = materialGoodReceiveDetails.getMaterialGoodReceiveHeader().getId();
			}

			JuteGRNEntry entryhdr = juteGRNEntryRepository.findByMrNo(mrno);
			List<JuteGateEntryDtl> entrydtl = juteentrydtlRepository.findByHdrId(entryhdr.getId());

			for (MaterialGoodReceiveItemVo itemVo : materialGoodReceiveItemVoList) {
				itemVo.setMaterialGrnHdrId(headerObj.getId());

				if (materialGoodReceiveDetails.getMaterialGoodReceiveHeader().getSourceId() == null) {
					for (int i = 0; i < entrydtl.size(); i++) {
						Quality quality = qualityRepository.findOne(itemVo.getActualQuality().getId());
						if (entrydtl.get(i).getActualQuality().equals(quality.getName())) {
							if (entrydtl.get(i).getReceivedIn().equalsIgnoreCase("BALE")) {
								itemVo.setActualWeight(
										Float.parseFloat(String.valueOf((entrydtl.get(i).getActualQuantity()) * 1.5)));
							} else if (entrydtl.get(i).getReceivedIn().equalsIgnoreCase("LOOSE")) {
								itemVo.setActualWeight(entrydtl.get(i).getActualQuantity());
							}

						}
					}
				}

				materialGoodReceiveLineItemObj = materialGoodReceiveItemRepository
						.save(getMaterialGoodReceiveLineItem(itemVo));
				resultMaterialGoodReceiveItemVoList
						.add(getMaterialGoodReceiveItemVo(materialGoodReceiveLineItemObj, headerObj.getPoId()));
				PhysicalStock physicalStockObj = null;
				if (headerObj.getAgentId() == null) {
					if (materialGoodReceiveLineItemObj.getStatus().equalsIgnoreCase("1")) {
						physicalStockObj = new PhysicalStock();
						physicalStockObj.setWareHouseNo(materialGoodReceiveLineItemObj.getWarehouseNo());
						physicalStockObj.setNewStock(materialGoodReceiveLineItemObj.getActualWeight());
						Item itemObj = itemRepository.findOne(materialGoodReceiveLineItemObj.getItemId());
						physicalStockObj.setItemGroupId(itemObj.getGroupId());
						physicalStockObj.setItemId(materialGoodReceiveLineItemObj.getItemId());
						physicalStockObj
								.setQualityCode(String.valueOf(materialGoodReceiveLineItemObj.getActualQuality()));
						physicalStockObj.setStoreId(-1);
						physicalStockObj.setTotalStock(0);
						physicalStockObj.setExistingStock(-1);
						physicalStockObj.setExistingStockIndentId(-1);
						physicalStockObj.setNewStockIndentId(-1);
						physicalStockObj.setStockInHand(-1);

						physicalStockObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));

						physicalStockObj.setTotalBaleStock(0);
						physicalStockObj.setExistingBaleStock(-1);
						physicalStockObj.setStockInHandBale(-1);

						physicalStockObj.setGoodType("MR");
						physicalStockObj.setGoodItemSerialNo(materialGoodReceiveLineItemObj.getId());
						physicalStockObj.setReceiveNo(materialGoodReceiveLineItemObj.getMaterialGrnHdrId());

						if (materialGoodReceiveLineItemObj.getBale() > 0) {
							physicalStockObj.setConversionUnit("BALE");
							physicalStockObj.setNewBaleStock(materialGoodReceiveLineItemObj.getActualBale());
						}
						if (materialGoodReceiveLineItemObj.getLoose() > 0) {
							physicalStockObj.setConversionUnit("LOOSE");
						}

						physicalStockObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));

						physicalStockRepository.save(physicalStockObj);
					} else if (materialGoodReceiveLineItemObj.getStatus().equalsIgnoreCase("3")) {
						List<PhysicalStock> physicalStockObjList = physicalStockRepository
								.findByItemIdAndQualityCodeAndReceiveNo(materialGoodReceiveLineItemObj.getItemId(),
										String.valueOf(materialGoodReceiveLineItemObj.getActualQuality()),
										materialGoodReceiveLineItemObj.getMaterialGrnHdrId());
						if (physicalStockObjList != null && physicalStockObjList.size() > 0) {
							physicalStockObj = physicalStockObjList.get(0);
							physicalStockObj.setTotalStock(physicalStockObj.getNewStock());
							physicalStockObj.setStockInHand(physicalStockObj.getTotalStock());

							if (materialGoodReceiveLineItemObj.getBale() > 0) {
								physicalStockObj.setConversionUnit("BALE");
								physicalStockObj.setTotalBaleStock(physicalStockObj.getNewBaleStock());
								physicalStockObj.setStockInHandBale(physicalStockObj.getNewBaleStock());

							}
							if (materialGoodReceiveLineItemObj.getLoose() > 0) {
								physicalStockObj.setConversionUnit("LOOSE");
							}
							physicalStockObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));
							physicalStockRepository.save(physicalStockObj);
						}
					} else if (materialGoodReceiveLineItemObj.getStatus().equalsIgnoreCase("4")) {
						List<PhysicalStock> physicalStockObjList = physicalStockRepository
								.findByItemIdAndQualityCodeAndReceiveNo(materialGoodReceiveLineItemObj.getItemId(),
										String.valueOf(materialGoodReceiveLineItemObj.getActualQuality()),
										materialGoodReceiveLineItemObj.getMaterialGrnHdrId());
						if (physicalStockObjList != null && physicalStockObjList.size() > 0) {
							physicalStockObj = physicalStockObjList.get(0);
							physicalStockObj.setNewStock(0);
							physicalStockObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));
							physicalStockRepository.save(physicalStockObj);
						}
					} else {

					}

				}

			}

		}

		obj.setMaterialGoodReceiveHeader(headerObj);
		obj.setMaterialGrnItemList(resultMaterialGoodReceiveItemVoList);
		return obj;
	}

	@Override
	public StoreGoodReceiveDetails addStoreGoodReceiveDetails(StoreGoodReceiveDetails storeGoodReceiveDetails) {
		StoreGoodReceiveDetails obj = new StoreGoodReceiveDetails();
		StoreGoodReceiveHeader headerObj = null;
		StoreGoodReceiveLineItem storeGoodReceiveLineItemObj = null;
		List<StoreGoodReceiveItemVo> storeGoodReceiveItemVoList = new ArrayList<StoreGoodReceiveItemVo>();
		List<StoreGoodReceiveItemVo> resultStoreGoodReceiveItemVoList = new ArrayList<StoreGoodReceiveItemVo>();

		if (null != storeGoodReceiveDetails) {
			StoreGoodReceiveHeader storeGoodReceiveHeader = storeGoodReceiveDetails.getStoreGoodReceiveHeader();
			storeGoodReceiveHeader.setModOn(new Date());
			storeGoodReceiveHeader.setModBy(storeGoodReceiveHeader.getSubmitter());
			// storeGoodReceiveHeader.setCreateDate(new Date());
			headerObj = storeGoodReceiveHeaderRepository.save(storeGoodReceiveHeader);
			storeGoodReceiveItemVoList = storeGoodReceiveDetails.getStoreGrnItemList();
			for (StoreGoodReceiveItemVo itemVo : storeGoodReceiveItemVoList) {
				itemVo.setStoreGrnHdrId(headerObj.getId());
				storeGoodReceiveLineItemObj = storeGoodReceiveItemRepository.save(getStoreGoodReceiveLineItem(itemVo));
				resultStoreGoodReceiveItemVoList.add(getStoreGoodReceiveItemVo(storeGoodReceiveLineItemObj));

				PhysicalStock physicalStockObj = null;
				if (storeGoodReceiveLineItemObj.getStatus().equalsIgnoreCase("1")) {
					physicalStockObj = new PhysicalStock();
					physicalStockObj.setNewStock(storeGoodReceiveLineItemObj.getActualQuantity());
					Item itemObj = itemRepository.findOne(storeGoodReceiveLineItemObj.getItemId());
					physicalStockObj.setItemGroupId(itemObj.getGroupId());
					physicalStockObj.setItemId(storeGoodReceiveLineItemObj.getItemId());
					physicalStockObj.setQualityCode("");
					physicalStockObj.setStoreId(Long.parseLong(storeGoodReceiveLineItemObj.getStoreId()));
					physicalStockObj.setTotalStock(0);
					physicalStockObj.setExistingStock(-1);
					physicalStockObj.setExistingStockIndentId(-1);
					physicalStockObj.setNewStockIndentId(-1);
					physicalStockObj.setStockInHand(-1);
					if (storeGoodReceiveLineItemObj.getExpiryDate() != null) {
						physicalStockObj.setNewStockExpirydDate(
								java.sql.Date.valueOf(String.valueOf(storeGoodReceiveLineItemObj.getExpiryDate())));
					}
					physicalStockObj.setGoodType("SR");
					physicalStockObj.setGoodItemSerialNo(storeGoodReceiveLineItemObj.getId());
					physicalStockObj.setReceiveNo(storeGoodReceiveLineItemObj.getStoreGrnHdrId());
					physicalStockObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));
					physicalStockRepository.save(physicalStockObj);
				} else if (storeGoodReceiveLineItemObj.getStatus().equalsIgnoreCase("3")) {
					List<PhysicalStock> physicalStockObjList = physicalStockRepository.findByItemIdAndReceiveNo(
							storeGoodReceiveLineItemObj.getItemId(), storeGoodReceiveLineItemObj.getStoreGrnHdrId());
					if (physicalStockObjList != null && physicalStockObjList.size() > 0) {
						physicalStockObj = physicalStockObjList.get(0);
						physicalStockObj.setNewStock(storeGoodReceiveLineItemObj.getActualQuantity());
						physicalStockObj.setTotalStock(physicalStockObj.getNewStock());
						physicalStockObj.setStockInHand(physicalStockObj.getTotalStock());
						physicalStockObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));
						physicalStockRepository.save(physicalStockObj);
					}
				} else if (storeGoodReceiveLineItemObj.getStatus().equalsIgnoreCase("4")) {
					List<PhysicalStock> physicalStockObjList = physicalStockRepository.findByItemIdAndReceiveNo(
							storeGoodReceiveLineItemObj.getItemId(), storeGoodReceiveLineItemObj.getStoreGrnHdrId());
					if (physicalStockObjList != null && physicalStockObjList.size() > 0) {
						physicalStockObj = physicalStockObjList.get(0);
						physicalStockObj.setNewStock(0);
						physicalStockObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));
						physicalStockRepository.save(physicalStockObj);
					}
				} else {

				}

			}

		}

		obj.setStoreGoodReceiveHeader(headerObj);
		obj.setStoreGrnItemList(resultStoreGoodReceiveItemVoList);
		return obj;
	}

	@Override
	public POChalanDetails getMaterialPODetailsByChalan(long chalanNo) {
		POChalanDetails poDetailsObj = new POChalanDetails();
		POHeader headerObj = null;
		List<PoItemVo> poItemVoList = new ArrayList<PoItemVo>();
		List<POLineItem> poLineItemList = null;
		JuteGRNEntry juteGRNEntry = null;
		List<JuteGRNEntry> list = new ArrayList<JuteGRNEntry>();

		for (JuteGRNEntry juteGRNEntryObj : juteGRNEntryRepository.findByChalanNo(chalanNo)) {
			list.add(juteGRNEntryObj);
		}
		if (list.size() > 0) {
			juteGRNEntry = list.get(0);
		}
		if (juteGRNEntry != null && (juteGRNEntry.getPoId() != null && juteGRNEntry.getPoId().length() > 0)) {
			headerObj = pOHeaderRepository.findOne(juteGRNEntry.getPoId());
			poLineItemList = pOLineItemRepository.findByPoId(juteGRNEntry.getPoId());

			if (null != poLineItemList) {

				for (POLineItem itemObj : poLineItemList) {
					PoItemVo voObj = new PoItemVo();
					voObj.setPoItemId(itemObj.getId());
					voObj.setPoId(headerObj.getId());
					voObj.setStatus(itemObj.getStatus());
					voObj.setIndentId(itemObj.getIndentId());
					voObj.setType(itemObj.getType());
					voObj.setPoQuantity(itemObj.getQuantity());
					voObj.setPoActualQuantity(itemObj.getActualQuantity());
					voObj.setRate(itemObj.getRate());
					voObj.setTax(itemObj.getTax());
					voObj.setValueWithTax(itemObj.getValueWithTax());
					voObj.setValueWithoutTax(itemObj.getValueWithoutTax());
					voObj.setDiscount(itemObj.getDiscount());
					voObj.setAllowableMoisturePercentage(itemObj.getAllowableMoisturePercentage());
					if (itemObj.getBale() > 0) {
						voObj.setUnitConversionType("BALE");
						voObj.setConversionQuantity(itemObj.getBale());
					}
					if (itemObj.getLoose() > 0) {
						voObj.setUnitConversionType("LOOSE");
						voObj.setConversionQuantity(itemObj.getLoose());
					}

					ItemGroup itemGroupObj = itemGroupRepository.findOne(itemObj.getItemGroupId());
					voObj.setItemGroup(itemGroupObj);

					Indent indentObj = indentRepository.findOne(itemObj.getId());
					if (indentObj != null)
						voObj.setAdditionalRequirement(indentObj.getAdditionalRequirement());

					Item item = itemBoObj.getItemById(itemObj.getItemId());
					voObj.setItem(item);

					QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(itemObj.getUnitId());
					voObj.setQuantityUnit(quantityUnitObj);

					Quality qualityObj = qualityRepository.findOne(itemObj.getQualityCode());
					if (null != qualityObj)
						voObj.setQuality(qualityObj);

					if (null != itemObj.getMarka())
						voObj.setMarka(itemObj.getMarka());

					if (null != itemObj.getApproverFirst())
						voObj.setApproverFirst(itemObj.getApproverFirst());
					if (null != itemObj.getApproverSecond())
						voObj.setApproverSecond(itemObj.getApproverSecond());
					if (null != itemObj.getApproveFirstDate())
						voObj.setApproveFirstDate(itemObj.getApproveFirstDate());
					if (null != itemObj.getApproveSecondDate())
						voObj.setApproveSecondDate(itemObj.getApproveSecondDate());

					poItemVoList.add(voObj);

				}

			}

			poDetailsObj.setPoHeader(headerObj);
			poDetailsObj.setPoItemList(poItemVoList);
			poDetailsObj.setChalanNo(chalanNo);
			poDetailsObj.setChalanDate(juteGRNEntry.getChalanDate());

		}

		return poDetailsObj;
	}

	@Override
	public POChalanDetails getMaterialPODetailsByChalanAndSupplier(long chalanNo, String supplierCode) {
		POChalanDetails poDetailsObj = new POChalanDetails();
		POHeader headerObj = null;
		List<PoItemVo> poItemVoList = new ArrayList<PoItemVo>();
		List<POLineItem> poLineItemList = null;
		JuteGRNEntry juteGRNEntry = null;
		List<JuteGRNEntry> list = new ArrayList<JuteGRNEntry>();

		for (JuteGRNEntry juteGRNEntryObj : juteGRNEntryRepository.findByChalanNo(chalanNo)) {
			if (juteGRNEntryObj != null
					&& (juteGRNEntryObj.getPoId() != null && juteGRNEntryObj.getPoId().length() > 0)) {
				headerObj = pOHeaderRepository.findOne(juteGRNEntryObj.getPoId());
				if (headerObj != null && (headerObj.getSupplierId() != null
						&& headerObj.getSupplierId().equalsIgnoreCase(supplierCode))) {
					juteGRNEntry = juteGRNEntryObj;
					break;
				}
			}
		}

		if (juteGRNEntry != null && (juteGRNEntry.getPoId() != null && juteGRNEntry.getPoId().length() > 0)) {
			headerObj = pOHeaderRepository.findOne(juteGRNEntry.getPoId());
			poLineItemList = pOLineItemRepository.findByPoId(juteGRNEntry.getPoId());

			if (null != poLineItemList) {

				for (POLineItem itemObj : poLineItemList) {
					PoItemVo voObj = new PoItemVo();
					voObj.setPoItemId(itemObj.getId());
					voObj.setPoId(headerObj.getId());
					voObj.setStatus(itemObj.getStatus());
					voObj.setIndentId(itemObj.getIndentId());
					voObj.setType(itemObj.getType());
					voObj.setPoQuantity(itemObj.getQuantity());
					voObj.setPoActualQuantity(itemObj.getActualQuantity());
					voObj.setRate(itemObj.getRate());
					voObj.setTax(itemObj.getTax());
					voObj.setValueWithTax(itemObj.getValueWithTax());
					voObj.setValueWithoutTax(itemObj.getValueWithoutTax());
					voObj.setDiscount(itemObj.getDiscount());
					voObj.setAllowableMoisturePercentage(itemObj.getAllowableMoisturePercentage());
					if (itemObj.getBale() > 0) {
						voObj.setUnitConversionType("BALE");
						voObj.setConversionQuantity(itemObj.getBale());
					}
					if (itemObj.getLoose() > 0) {
						voObj.setUnitConversionType("LOOSE");
						voObj.setConversionQuantity(itemObj.getLoose());
					}

					ItemGroup itemGroupObj = itemGroupRepository.findOne(itemObj.getItemGroupId());
					voObj.setItemGroup(itemGroupObj);

					Indent indentObj = indentRepository.findOne(itemObj.getId());
					if (indentObj != null)
						voObj.setAdditionalRequirement(indentObj.getAdditionalRequirement());

					Item item = itemBoObj.getItemById(itemObj.getItemId());
					voObj.setItem(item);

					QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(itemObj.getUnitId());
					voObj.setQuantityUnit(quantityUnitObj);

					Quality qualityObj = qualityRepository.findOne(itemObj.getQualityCode());
					if (null != qualityObj)
						voObj.setQuality(qualityObj);

					if (null != itemObj.getMarka())
						voObj.setMarka(itemObj.getMarka());

					if (null != itemObj.getApproverFirst())
						voObj.setApproverFirst(itemObj.getApproverFirst());
					if (null != itemObj.getApproverSecond())
						voObj.setApproverSecond(itemObj.getApproverSecond());
					if (null != itemObj.getApproveFirstDate())
						voObj.setApproveFirstDate(itemObj.getApproveFirstDate());
					if (null != itemObj.getApproveSecondDate())
						voObj.setApproveSecondDate(itemObj.getApproveSecondDate());

					poItemVoList.add(voObj);

				}

			}

			poDetailsObj.setPoHeader(headerObj);
			poDetailsObj.setPoItemList(poItemVoList);
			poDetailsObj.setChalanNo(chalanNo);
			poDetailsObj.setChalanDate(juteGRNEntry.getChalanDate());

		}

		return poDetailsObj;
	}

	@Override
	public POChalanDetails getStorePODetailsByChalan(long chalanNo) {
		POChalanDetails poDetailsObj = new POChalanDetails();
		POHeader headerObj = null;
		List<PoItemVo> poItemVoList = new ArrayList<PoItemVo>();
		List<POLineItem> poLineItemList = null;
		StoreGRNEntry storeGRNEntry = null;
		List<StoreGRNEntry> list = new ArrayList<StoreGRNEntry>();

		for (StoreGRNEntry storeGRNEntryObj : storeGRNEntryRepository.findByChalanNo(chalanNo)) {
			list.add(storeGRNEntryObj);
		}
		if (list.size() > 0) {
			storeGRNEntry = list.get(0);
		}
		if (storeGRNEntry != null && (storeGRNEntry.getPoId() != null && storeGRNEntry.getPoId().length() > 0)) {
			headerObj = pOHeaderRepository.findOne(storeGRNEntry.getPoId());
			poLineItemList = pOLineItemRepository.findByPoId(storeGRNEntry.getPoId());

			if (null != poLineItemList) {

				for (POLineItem itemObj : poLineItemList) {
					PoItemVo voObj = new PoItemVo();
					voObj.setPoItemId(itemObj.getId());
					voObj.setPoId(headerObj.getId());
					voObj.setStatus(itemObj.getStatus());
					voObj.setIndentId(itemObj.getIndentId());
					voObj.setType(itemObj.getType());
					voObj.setPoQuantity(itemObj.getQuantity());
					voObj.setPoActualQuantity(itemObj.getActualQuantity());
					voObj.setRate(itemObj.getRate());
					voObj.setTax(itemObj.getTax());
					voObj.setValueWithTax(itemObj.getValueWithTax());
					voObj.setValueWithoutTax(itemObj.getValueWithoutTax());
					voObj.setDiscount(itemObj.getDiscount());
					voObj.setAllowableMoisturePercentage(itemObj.getAllowableMoisturePercentage());
					if (itemObj.getBale() > 0) {
						voObj.setUnitConversionType("BALE");
						voObj.setConversionQuantity(itemObj.getBale());
					}
					if (itemObj.getLoose() > 0) {
						voObj.setUnitConversionType("LOOSE");
						voObj.setConversionQuantity(itemObj.getLoose());
					}

					ItemGroup itemGroupObj = itemGroupRepository.findOne(itemObj.getItemGroupId());
					voObj.setItemGroup(itemGroupObj);

					Indent indentObj = indentRepository.findOne(itemObj.getId());
					if (indentObj != null)
						voObj.setAdditionalRequirement(indentObj.getAdditionalRequirement());

					Item item = itemBoObj.getItemById(itemObj.getItemId());
					voObj.setItem(item);

					QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(itemObj.getUnitId());
					voObj.setQuantityUnit(quantityUnitObj);

					Quality qualityObj = qualityRepository.findOne(itemObj.getQualityCode());
					if (null != qualityObj)
						voObj.setQuality(qualityObj);

					if (null != itemObj.getMarka())
						voObj.setMarka(itemObj.getMarka());

					if (null != itemObj.getApproverFirst())
						voObj.setApproverFirst(itemObj.getApproverFirst());
					if (null != itemObj.getApproverSecond())
						voObj.setApproverSecond(itemObj.getApproverSecond());
					if (null != itemObj.getApproveFirstDate())
						voObj.setApproveFirstDate(itemObj.getApproveFirstDate());
					if (null != itemObj.getApproveSecondDate())
						voObj.setApproveSecondDate(itemObj.getApproveSecondDate());

					poItemVoList.add(voObj);

				}

			}

			poDetailsObj.setPoHeader(headerObj);
			poDetailsObj.setPoItemList(poItemVoList);
			poDetailsObj.setChalanNo(chalanNo);
			poDetailsObj.setChalanDate(storeGRNEntry.getChalanDate());

		}

		return poDetailsObj;
	}

	@Override
	public List<StoreGRNEntry> getStoreChalanListBySupplier(String supplierCode) {
		List<StoreGRNEntry> storeChalanList = null;
		List<StoreGRNEntry> list = new ArrayList<StoreGRNEntry>();
		List<POHeader> pOHeaderList = null;
		String approvedStatus = "3";

		pOHeaderList = pOHeaderRepository.findBySupplierIdAndStatus(supplierCode, approvedStatus);

		for (POHeader headerObj : pOHeaderList) {

			storeChalanList = storeGRNEntryRepository.findByPoId(String.valueOf(headerObj.getId()));
			if (null != storeChalanList && storeChalanList.size() > 0) {
				list.addAll(storeChalanList);
			}
		}
		return list;
	}

	@Override
	public POChalanDetails getStorePODetailsByChalanAndSupplierAndPONo(long chalanNo, String supplierCode,
			String poNo) {
		POChalanDetails poDetailsObj = new POChalanDetails();
		POHeader headerObj = null;
		List<PoItemVo> poItemVoList = new ArrayList<PoItemVo>();
		List<POLineItem> poLineItemList = null;
		StoreGRNEntry storeGRNEntry = null;
		List<StoreGRNEntry> list = new ArrayList<StoreGRNEntry>();
		List<GateStoreEntryRegDtl> storeentrydtl = new ArrayList<>();

		// for (StoreGRNEntry storeGRNEntryObj :
		// storeGRNEntryRepository.findByChalanNo(chalanNo)) {
		for (StoreGRNEntry storeGRNEntryObj : storeGRNEntryRepository.findByChalanNoAndSuppCodeAndPoId(chalanNo,
				supplierCode, poNo)) {

			storeentrydtl = storeentrydtlRepository.findByHdrId(storeGRNEntryObj.getId());

			if (storeGRNEntryObj != null
					&& (storeGRNEntryObj.getPoId() != null && storeGRNEntryObj.getPoId().length() > 0)) {
				headerObj = pOHeaderRepository.findOne(storeGRNEntryObj.getPoId());
				if (headerObj != null && (headerObj.getSupplierId() != null
						&& headerObj.getSupplierId().equalsIgnoreCase(supplierCode))) {
					storeGRNEntry = storeGRNEntryObj;
					break;
				}
			}
		}

		if (storeGRNEntry != null && (storeGRNEntry.getPoId() != null && storeGRNEntry.getPoId().length() > 0)) {
			headerObj = pOHeaderRepository.findOne(storeGRNEntry.getPoId());
			poLineItemList = pOLineItemRepository.findByPoId(storeGRNEntry.getPoId());

			if (null != poLineItemList) {

				for (int i = 0; i < poLineItemList.size(); i++) {
					PoItemVo voObj = new PoItemVo();

					voObj.setPoItemId(poLineItemList.get(i).getId());
					voObj.setPoId(headerObj.getId());
					voObj.setStatus(poLineItemList.get(i).getStatus());
					voObj.setIndentId(poLineItemList.get(i).getIndentId());
					voObj.setType(poLineItemList.get(i).getType());
					voObj.setPoQuantity(poLineItemList.get(i).getQuantity());
					// voObj.setPoActualQuantity(poLineItemList.get(i).getActualQuantity());
					voObj.setRate(poLineItemList.get(i).getRate());
					voObj.setTax(poLineItemList.get(i).getTax());
					voObj.setValueWithTax(poLineItemList.get(i).getValueWithTax());
					voObj.setValueWithoutTax(poLineItemList.get(i).getValueWithoutTax());
					voObj.setDiscount(poLineItemList.get(i).getDiscount());
					voObj.setAllowableMoisturePercentage(poLineItemList.get(i).getAllowableMoisturePercentage());

					for (int j = 0; j < storeentrydtl.size(); j++) {
						System.out.println("inside store dtl for");
						System.out.println(storeentrydtl.get(i).getReqQuantity());
						System.out.println(poLineItemList.get(i).getQuantity());
						voObj.setPoActualQuantity(storeentrydtl.get(i).getReqQuantity());
						voObj.setConversionQuantity(storeentrydtl.get(i).getReqQuantity());
						if (poLineItemList.get(i).getBale() > 0) {
							voObj.setUnitConversionType("BALE");
							System.out.println(storeentrydtl.get(j).getReqQuantity());
							System.out.println(poLineItemList.get(i).getQuantity());
							voObj.setPoActualQuantity(storeentrydtl.get(j).getReqQuantity());
							voObj.setConversionQuantity(storeentrydtl.get(j).getReqQuantity());
						}
						if (poLineItemList.get(i).getLoose() > 0) {
							voObj.setUnitConversionType("LOOSE");
							voObj.setPoActualQuantity(storeentrydtl.get(j).getReqQuantity());
							voObj.setConversionQuantity(storeentrydtl.get(j).getReqQuantity());
						}
					}
					/*
					 * if (poLineItemList.get(i).getBale() > 0) {
					 * voObj.setUnitConversionType("BALE");
					 * voObj.setConversionQuantity(poLineItemList.get(i).getBale()); } if
					 * (poLineItemList.get(i).getLoose() > 0) {
					 * voObj.setUnitConversionType("LOOSE");
					 * voObj.setConversionQuantity(poLineItemList.get(i).getLoose()); }
					 */

					ItemGroup itemGroupObj = itemGroupRepository.findOne(poLineItemList.get(i).getItemGroupId());
					voObj.setItemGroup(itemGroupObj);

					Indent indentObj = indentRepository.findOne(poLineItemList.get(i).getId());
					if (indentObj != null)
						voObj.setAdditionalRequirement(indentObj.getAdditionalRequirement());

					Item item = itemBoObj.getItemById(poLineItemList.get(i).getItemId());
					voObj.setItem(item);

					QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(poLineItemList.get(i).getUnitId());
					voObj.setQuantityUnit(quantityUnitObj);

					Quality qualityObj = qualityRepository.findOne(poLineItemList.get(i).getQualityCode());
					if (null != qualityObj)
						voObj.setQuality(qualityObj);

					if (null != poLineItemList.get(i).getMarka())
						voObj.setMarka(poLineItemList.get(i).getMarka());

					if (null != poLineItemList.get(i).getApproverFirst())
						voObj.setApproverFirst(poLineItemList.get(i).getApproverFirst());
					if (null != poLineItemList.get(i).getApproverSecond())
						voObj.setApproverSecond(poLineItemList.get(i).getApproverSecond());
					if (null != poLineItemList.get(i).getApproveFirstDate())
						voObj.setApproveFirstDate(poLineItemList.get(i).getApproveFirstDate());
					if (null != poLineItemList.get(i).getApproveSecondDate())
						voObj.setApproveSecondDate(poLineItemList.get(i).getApproveSecondDate());

					poItemVoList.add(voObj);

				}

			}

			poDetailsObj.setPoHeader(headerObj);
			poDetailsObj.setPoItemList(poItemVoList);
			poDetailsObj.setChalanNo(chalanNo);
			poDetailsObj.setChalanDate(storeGRNEntry.getChalanDate());

		}

		return poDetailsObj;
	}

	private DebitCreditNotesVo getDebitCreditNotesVo(DebitCreditNotes inObj) {

		DebitCreditNotesVo obj = new DebitCreditNotesVo();
		obj.setAdjustmentDate(inObj.getAdjustmentDate());
		obj.setAdjustmentQunatity(inObj.getAdjustmentQunatity());
		obj.setAdjustmentType(inObj.getAdjustmentType());
		obj.setAdjustmentValue(inObj.getAdjustmentValue());
		obj.setFinancialYear(inObj.getFinancialYear());
		obj.setGrnDate(inObj.getGrnDate());
		obj.setGrnNo(inObj.getGrnNo());
		obj.setGrnYear(inObj.getGrnYear());

		if (inObj.getId() > 0) {
			obj.setId(inObj.getId());
		}

		Item item = itemBoObj.getItemById(inObj.getItemCode());
		obj.setItem(item);

		QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(inObj.getUomCode());
		obj.setQuantityUnit(quantityUnitObj);
		
//		Supplier supplier = supplierRepository.findOne(inObj.getSupplierCode());
		obj.setReason(inObj.getReason());
		obj.setSupplierCode(inObj.getSupplierCode());
//		obj.setSupplierCode(supplier.getName());
		
		return obj;

	}
	
	private DebitCreditNotesVo getDebitCreditNotesVoById(DebitCreditNotes inObj) {

		DebitCreditNotesVo obj = new DebitCreditNotesVo();
		obj.setAdjustmentDate(inObj.getAdjustmentDate());
		obj.setAdjustmentQunatity(inObj.getAdjustmentQunatity());
		obj.setAdjustmentType(inObj.getAdjustmentType());
		obj.setAdjustmentValue(inObj.getAdjustmentValue());
		obj.setFinancialYear(inObj.getFinancialYear());
		obj.setGrnDate(inObj.getGrnDate());
		obj.setGrnNo(inObj.getGrnNo());
		obj.setGrnYear(inObj.getGrnYear());

		if (inObj.getId() > 0) {
			obj.setId(inObj.getId());
		}

		Item item = itemBoObj.getItemById(inObj.getItemCode());
		obj.setItem(item);

		QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(inObj.getUomCode());
		obj.setQuantityUnit(quantityUnitObj);
		
		Supplier supplier = supplierRepository.findOne(inObj.getSupplierCode());
		obj.setReason(inObj.getReason());
//		obj.setSupplierCode(inObj.getSupplierCode());
		obj.setSupplierCode(supplier.getName());
		
		return obj;

	}

	private DebitCreditNotes getDebitCreditNotes(DebitCreditNotesVo inObj) {

		DebitCreditNotes obj = new DebitCreditNotes();
		obj.setAdjustmentDate(inObj.getAdjustmentDate());
		obj.setAdjustmentQunatity(inObj.getAdjustmentQunatity());
		obj.setAdjustmentType(inObj.getAdjustmentType());
		obj.setAdjustmentValue(inObj.getAdjustmentValue());
		obj.setFinancialYear(inObj.getFinancialYear());
		obj.setGrnDate(inObj.getGrnDate());
		obj.setGrnNo(inObj.getGrnNo());
		obj.setGrnYear(inObj.getGrnYear());

		if (inObj.getId() > 0) {
			obj.setId(inObj.getId());
		}

		if (inObj.getItem() != null) {
			obj.setItemCode(inObj.getItem().getId());
		}

		if (inObj.getQuantityUnit() != null) {
			obj.setUomCode(inObj.getQuantityUnit().getId());
		}

		obj.setReason(inObj.getReason());
		obj.setSupplierCode(inObj.getSupplierCode());

		return obj;

	}

	@Override
	public List<DebitCreditNotesVo> getAllDebitCreditNotesBySupplierCode(String supplierCode) {
		List<DebitCreditNotesVo> list = new ArrayList<DebitCreditNotesVo>();
		for (DebitCreditNotes debitCreditNotesObj : debitCreditNoteRepository.findBySupplierCode(supplierCode)) {
			list.add(getDebitCreditNotesVo(debitCreditNotesObj));
		}

		return list;
	}

	@Override
	public List<DebitCreditNotesVo> getAllDebitCreditNotes() {
		List<DebitCreditNotesVo> list = new ArrayList<DebitCreditNotesVo>();
		for (DebitCreditNotes debitCreditNotesObj : debitCreditNoteRepository.findAll()) {
			list.add(getDebitCreditNotesVo(debitCreditNotesObj));
		}

		return list;
	}

	@Override
	public List<DebitCreditNotesVo> getAllDebitCreditNotesByGrnNo(long grnNo) {
		List<DebitCreditNotesVo> list = new ArrayList<DebitCreditNotesVo>();
		for (DebitCreditNotes debitCreditNotesObj : debitCreditNoteRepository.findByGrnNo(grnNo)) {
			list.add(getDebitCreditNotesVo(debitCreditNotesObj));
		}
		return list;
	}

	@Override
	public DebitCreditNotesVo getDebitCreditNotesById(long id) {
		DebitCreditNotes obj = null;
		obj = debitCreditNoteRepository.findOne(id);
		
		return getDebitCreditNotesVoById(obj);
	}

	@Override
	@Transactional
	public DebitCreditNotesVo addDebitCreditNotes(DebitCreditNotesVo debitCreditNotesVoObj) {
		DebitCreditNotes obj = getDebitCreditNotes(debitCreditNotesVoObj);
		DebitCreditNotes obj1 = new DebitCreditNotes();
		String inReason = obj.getReason();
		Float inQuantity = obj.getAdjustmentQunatity();
		String inItemCode = obj.getItemCode();
		Long inSrNum = obj.getGrnNo();
		String inSuppCode = obj.getSupplierCode();
		
		obj1 = debitCreditNoteRepository.save(obj);
//		obj = drcrDao.saveDebitCreditNotes(obj);
		
		drcrDao.storedProc(inReason,inQuantity,inItemCode,inSrNum,inSuppCode);
		return getDebitCreditNotesVo(obj1);
		
	}

	@Override
	public List<BillPass> getAllBillPassBySupplierCode(String supplierCode) {
		List<BillPass> list = null;
		list = billPassRepository.findBySupplierCode(supplierCode);
		return list;
	}

	@Override
	public List<BillPassDTO> getAllBillPass() {
		List<BillPassDTO> list = new ArrayList<BillPassDTO>();
		for (BillPass billPassObj : billPassRepository.findAll()) {
			BillPassDTO obj = new BillPassDTO();
			BillPass inobj = billPassObj;
			obj.setAdjustmentType(inobj.getAdjustmentType());
			obj.setBillAmount(inobj.getBillAmount());
			obj.setBillDate(inobj.getBillDate());
			obj.setBillNo(Long.parseLong(inobj.getBillNo()));
			obj.setDocNo(inobj.getDocNo());
			obj.setDocType(inobj.getDocType());
			obj.setGrnNo(inobj.getGrnNo());
			obj.setId(inobj.getId());
			obj.setPoId(inobj.getPoId());
			Supplier supplier = supplierRepository.findOne(inobj.getSupplierCode());
//			obj.setSupplierCode(inobj.getSupplierCode());
			obj.setSupplierCode(supplier.getName());
			obj.setFinancialYear(inobj.getFinancialYear());
			list.add(obj);
		}

		return list;
	}

	@Override
	public List<BillPass> getAllBillPassByGrnNo(long grnNo) {
		List<BillPass> list = null;
		list = billPassRepository.findByGrnNo(grnNo);
		return list;
	}

	@Override
	public List<BillPass> getAllBillPassByBillNo(String billNo) {
		List<BillPass> list = null;
		list = billPassRepository.findByBillNo(billNo);
		return list;
	}

	@Override
	public List<BillPass> getAllBillPassByPoId(String poId) {
		List<BillPass> list = null;
		list = billPassRepository.findByPoId(poId);
		return list;
	}

	@Override
	public BillPassDTO getBillPassById(long id) {
		BillPass inobj = null;
		BillPassDTO obj = new BillPassDTO();
		inobj = billPassRepository.findOne(id);
		obj.setAdjustmentType(inobj.getAdjustmentType());
		obj.setBillAmount(inobj.getBillAmount());
		obj.setBillDate(inobj.getBillDate());
		obj.setBillNo(Long.parseLong(inobj.getBillNo()));
		obj.setDocNo(inobj.getDocNo());
		obj.setDocType(inobj.getDocType());
		obj.setGrnNo(inobj.getGrnNo());
		obj.setId(inobj.getId());
		obj.setPoId(inobj.getPoId());
//		Supplier supplier = supplierRepository.findOne(inobj.getSupplierCode());
		obj.setSupplierCode(inobj.getSupplierCode());
//		obj.setSupplierCode(supplier.getName());
		obj.setFinancialYear(inobj.getFinancialYear());
		return obj;
	}

	@Override
	public BillPassDTO addBillPass(BillPassDTO inobj) {
		BillPass obj = new BillPass();
		obj.setAdjustmentType(inobj.getAdjustmentType());
		obj.setBillAmount(inobj.getBillAmount());
		obj.setBillDate(inobj.getBillDate());
		obj.setBillNo(inobj.getUiBillNo());
		obj.setDocNo(inobj.getDocNo());
		obj.setDocType(inobj.getDocType());
		obj.setGrnNo(inobj.getGrnNo());
		obj.setId(inobj.getId());
		obj.setPoId(inobj.getPoId());
		obj.setSupplierCode(inobj.getSupplierCode());
		obj.setFinancialYear(inobj.getFinancialYear());
		obj = billPassRepository.save(obj);
		return inobj;
	}

	private IssueLineItemVo getIssueLineItemVo(IssueLineItem inObj) {

		IssueLineItemVo obj = new IssueLineItemVo();
		obj.setIssueId(inObj.getIssueHeaderId());
		if (inObj.getId() > 0) {
			obj.setIssueItemId(inObj.getId());
		}

		ItemGroup itemGroupObj = itemGroupRepository.findOne(inObj.getItemGroupId());
		obj.setItemGroup(itemGroupObj);

		Item item = itemBoObj.getItemById(inObj.getItemId());
		obj.setItem(item);

		QuantityUnit quantityUnitObj = quantityUnitRepository.findOne(inObj.getUnitId());
		obj.setQuantityUnit(quantityUnitObj);

		Quality qualityObj = qualityRepository.findOne(inObj.getQualityCode());
		if (null != qualityObj)
			obj.setQuality(qualityObj);

		if (null != inObj.getMarka())
			obj.setMarka(inObj.getMarka());

		obj.setIssueQuantity(inObj.getIssueQuantity());
		obj.setStock(inObj.getStock());

		if (null != inObj.getRemark())
			obj.setRemark(inObj.getRemark());

		if (null != inObj.getAdditionalRequirement())
			obj.setAdditionalRequirement(inObj.getAdditionalRequirement());

		if (inObj.getServiceBatchType() != -1) {
			ServiceBatchType serviceBatchTypeObj = serviceBatchRepository.findOne(inObj.getServiceBatchType());
			if (null != serviceBatchTypeObj)
				obj.setServiceBatchType(serviceBatchTypeObj);

		}

		return obj;

	}

	private IssueLineItem getIssueLineItem(IssueLineItemVo inObj) {

		IssueLineItem obj = new IssueLineItem();
		obj.setIssueHeaderId(inObj.getIssueId());
		if (inObj.getIssueItemId() > 0) {
			obj.setId(inObj.getIssueItemId());
		}
		obj.setItemGroupId(inObj.getItemGroup().getId());
		obj.setItemId(inObj.getItem().getId());
		obj.setUnitId(inObj.getQuantityUnit().getId());
		if (null != inObj.getQuality())
			obj.setQualityCode(inObj.getQuality().getId());

		if (null != inObj.getMarka())
			obj.setMarka(inObj.getMarka());

		obj.setIssueQuantity(inObj.getIssueQuantity());
		obj.setStock(inObj.getStock());

		if (null != inObj.getRemark())
			obj.setRemark(inObj.getRemark());

		if (null != inObj.getAdditionalRequirement())
			obj.setAdditionalRequirement(inObj.getAdditionalRequirement());

		if (null != inObj.getServiceBatchType()) {
			obj.setServiceBatchType(inObj.getServiceBatchType().getId());
		} else {
			obj.setServiceBatchType(-1);
		}

		return obj;

	}

	@Override
	public List<StoreGoodReceiveItemVo> getStoreGoodReceiveItemForIssue(String storeId, String itemId,
			float issueQuantity)

	{
		float remainingIssueQunatity = issueQuantity;
		List<StoreGoodReceiveItemVo> result = new ArrayList<StoreGoodReceiveItemVo>();
		StoreGoodReceiveItemVo storeGoodReceiveItemVoObj = null;
		List<StoreGoodReceiveLineItem> list = storeGoodReceiveItemRepository.findByStoreIdAndItemId(storeId, itemId);
		for (StoreGoodReceiveLineItem storeGoodReceiveLineItem : list) {
			storeGoodReceiveItemVoObj = getStoreGoodReceiveItemVo(storeGoodReceiveLineItem);
			if (storeGoodReceiveItemVoObj.getActualQuantity() > remainingIssueQunatity) {
				storeGoodReceiveItemVoObj.setIssueQuantity(remainingIssueQunatity);
				remainingIssueQunatity = 0;
			} else if (storeGoodReceiveItemVoObj.getActualQuantity() < remainingIssueQunatity) {
				storeGoodReceiveItemVoObj.setIssueQuantity(storeGoodReceiveItemVoObj.getActualQuantity());
				remainingIssueQunatity = remainingIssueQunatity - storeGoodReceiveItemVoObj.getActualQuantity();
			} else {
				storeGoodReceiveItemVoObj.setIssueQuantity(remainingIssueQunatity);
			}
			result.add(storeGoodReceiveItemVoObj);
		}

		return result;
	}

	@Override
	public List<MaterialGoodReceiveItemVo> getMaterialGoodReceiveItemForIssue(String warehouseNo, String itemId,
			float issueQuantity) {
		float remainingIssueQunatity = issueQuantity;
		List<MaterialGoodReceiveItemVo> result = new ArrayList<MaterialGoodReceiveItemVo>();
		MaterialGoodReceiveItemVo materialGoodReceiveItemVo = null;
		List<MaterialGoodReceiveLineItem> list = materialGoodReceiveItemRepository
				.findByWarehouseNoAndItemId(warehouseNo, itemId);
		for (MaterialGoodReceiveLineItem materialGoodReceiveLineItem : list) {

			MaterialGoodReceiveHeader materialGoodReceiveHeaderObj = materialGoodReceiveHeaderRepository
					.findOne(materialGoodReceiveLineItem.getMaterialGrnHdrId());
			materialGoodReceiveItemVo = getMaterialGoodReceiveItemVo(materialGoodReceiveLineItem,
					materialGoodReceiveHeaderObj.getPoId());
			if (materialGoodReceiveItemVo.getActualWeight() > remainingIssueQunatity) {
				materialGoodReceiveItemVo.setIssueQuantity(remainingIssueQunatity);
				remainingIssueQunatity = 0;
			} else if (materialGoodReceiveItemVo.getActualWeight() < remainingIssueQunatity) {
				materialGoodReceiveItemVo.setIssueQuantity(materialGoodReceiveItemVo.getActualWeight());
				remainingIssueQunatity = remainingIssueQunatity - materialGoodReceiveItemVo.getActualWeight();
			} else {
				materialGoodReceiveItemVo.setIssueQuantity(remainingIssueQunatity);
			}
			result.add(materialGoodReceiveItemVo);
		}

		return result;
	}

	@Override
	public List<Mukam> getAllMukam() {
		List<Mukam> list = new ArrayList<Mukam>();
		for (Mukam mukamObj : mukamRepository.findAll()) {
			if (null != mukamObj)
				list.add(mukamObj);
		}
		return list;
	}

	@Override
	public List<Mukam> getAllMukamBySupplier(String supplierCode) {
		List<Mukam> list = new ArrayList<Mukam>();
		Mukam obj = null;
		List<MukamSupplier> mukamSupplierList = mukamSupplierRepository.findBySupplierName(supplierCode);
		if (null != mukamSupplierList) {
			for (MukamSupplier mukamSupplierObj : mukamSupplierList) {
				obj = mukamRepository.findOne(mukamSupplierObj.getMukamId());
				if (null != obj)
					list.add(obj);
			}
		}
		return list;
	}

	@Override
	public Vehicle getVehicleById(long id) {
		Vehicle obj = null;
		obj = vehicleRepository.findOne(id);
		return obj;
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		List<Vehicle> list = new ArrayList<Vehicle>();
		for (Vehicle obj : vehicleRepository.findAll()) {
			list.add(obj);
		}
		return list;
	}

	@Override
	public Mukam getMukamById(long id) {
		Mukam obj = null;
		obj = mukamRepository.findOne(id);
		return obj;
	}

	@Override
	public List<POHeader> getAllPOByMukamAndSupplierId(String mukam, String supplierId) {
		List<POHeader> list = null;
		list = pOHeaderRepository.findByMukamAndSupplierId(mukam, supplierId);

		// return list.stream().sorted(Comparator.comparing(POHeader::getId))
		// .collect(Collectors.toList());
		/*
		 * return list .stream() .sorted(Comparator .comparing(POHeader::getType)
		 * .reversed() .thenComparing(POHeader::getId)) .collect(Collectors.toList());
		 */
		return list.stream().sorted(Comparator.comparing(POHeader::getModOn).reversed())
				// .thenComparing(POHeader::getId))
				.collect(Collectors.toList());

	}

	@Override
	public ReportCounter getCounterByTypeAndId(String type, String id) {
		ReportCounter obj = null;
		List<ReportCounter> list = reportCounterRepository.findByTypeAndId(type, id);
		if (list != null)
			obj = list.get(0);
		return obj;
	}

	@Override
	public ReportCounter addUpdateCounter(ReportCounter reportCounterObj) {
		ReportCounter obj = null;
		obj = reportCounterRepository.save(reportCounterObj);
		return obj;
	}

	@Override
	public List<JuteEntryHeaderDTO> getMaterialReceiveNoByChalanNo(long chalanNo, String suppCode, String poNo) {
		List<JuteEntryHeader> list = null;
		List<JuteEntryHeaderDTO> listDTOs = new ArrayList<>();
		list = materialEntryRepository.findByChalanNoAndSuppCodeAndPoNo(chalanNo, suppCode, poNo);
		for (int i = 0; i < list.size(); i++) {
			JuteEntryHeaderDTO listDTO = new JuteEntryHeaderDTO();
			Mukam mukam = mukamRepository.findOne(Long.parseLong(list.get(i).getMukam()));
			listDTO.setChalanDate(list.get(i).getChalanDate());
			listDTO.setChalanNo(list.get(i).getChalanNo());
			listDTO.setId(list.get(i).getId());
			listDTO.setMrNo(list.get(i).getMrNo());
			listDTO.setMukam(list.get(i).getMukam());
			listDTO.setMukamName(mukam.getMukamName());
			listDTO.setPoNo(list.get(i).getPoNo());
			listDTO.setSuppCode(list.get(i).getSuppCode());
			listDTO.setVehicleNo(list.get(i).getVehicleNo());
			listDTOs.add(listDTO);
		}
		return listDTOs;
	}

	@Override
	public List<JuteQualityEntryHeader> getMaterialQualityByPoNoAndPoLineItemId(String poNo, long poLineItemId) {
		List<JuteQualityEntryHeader> list = null;
		list = materialQualityCenterRepository.findByPoNoAndPoLineItemId(poNo, poLineItemId);
		return list;
	}

	@Override
	public List<JuteQualityEntryHeader> addUpdateMaterialQuality(List<JuteQualityEntryHeader> list) {
		List<JuteQualityEntryHeader> resultList = new ArrayList<JuteQualityEntryHeader>();
		for (JuteQualityEntryHeader juteQualityEntryHeaderObj : list) {
			resultList.add(materialQualityCenterRepository.save(juteQualityEntryHeaderObj));
		}
		return resultList;
	}

	@Override
	public Broker getBrokerDetailsById(long id) {
		Broker obj = null;
		obj = brokerRepository.findOne(id);
		return obj;
	}

	@Override
	public List<Supplier> getSupplierListByBrokerId(long id) {
		List<Supplier> list = new ArrayList<Supplier>();
		Supplier supplierObj = null;
		Map<String, Supplier> mapObj = new HashMap<String, Supplier>();
		if (id > 0) {
			List<BrokerSupplierMap> mapList = brokerSupplierRepository.findByBrokerId(id);
			if (null != mapList && mapList.size() > 0) {
				for (BrokerSupplierMap brokerSupplierMapObj : mapList) {
					supplierObj = supplierRepository.findOne(brokerSupplierMapObj.getSupplierCode());
					if (supplierObj != null) {
						if (mapObj.get(supplierObj.getId()) == null) {
							list.add(supplierObj);
							mapObj.put(supplierObj.getId(), supplierObj);
						}
					}

				}
			}
		}
		return list;
	}

	@Override
	public List<Broker> getBrokerListBySupplierCode(String id) {
		List<Broker> list = new ArrayList<Broker>();
		Broker brokerObj = null;
		Map<Long, Broker> mapObj = new HashMap<Long, Broker>();
		if (id != null) {
			List<BrokerSupplierMap> mapList = brokerSupplierRepository.findBySupplierCode(id);
			if (null != mapList && mapList.size() > 0) {
				for (BrokerSupplierMap brokerSupplierMapObj : mapList) {
					brokerObj = brokerRepository.findOne(brokerSupplierMapObj.getBrokerId());
					if (brokerObj != null) {
						if (mapObj.get(brokerObj.getId()) == null) {
							list.add(brokerObj);
							mapObj.put(brokerObj.getId(), brokerObj);
						}
					}

				}
			}
		}
		return list;
	}

	private IndentHeaderTypeG getIndentHeaderTypeG(IndentHeader headerObj) {
		IndentHeaderTypeG obj = new IndentHeaderTypeG();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setModOn(java.sql.Date.valueOf(LocalDate.now()));
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		return obj;
	}

	private IndentHeaderTypeW getIndentHeaderTypeW(IndentHeader headerObj) {
		IndentHeaderTypeW obj = new IndentHeaderTypeW();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setModOn(java.sql.Date.valueOf(LocalDate.now()));
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		return obj;
	}

	private IndentHeader getIndentHeaderFromIndentHeaderTypeG(IndentHeaderTypeG headerObj) {
		IndentHeader obj = new IndentHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setId(headerObj.getId());
		return obj;
	}

	private IndentHeaderTypeP getIndentHeaderTypeP(IndentHeader headerObj) {
		IndentHeaderTypeP obj = new IndentHeaderTypeP();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setModOn(java.sql.Date.valueOf(LocalDate.now()));
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		return obj;
	}

	private IndentHeader getIndentHeaderFromIndentHeaderTypeP(IndentHeaderTypeP headerObj) {
		IndentHeader obj = new IndentHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setId(headerObj.getId());
		return obj;
	}

	private IndentHeaderTypeO getIndentHeaderTypeO(IndentHeader headerObj) {
		IndentHeaderTypeO obj = new IndentHeaderTypeO();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setModOn(java.sql.Date.valueOf(LocalDate.now()));
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		return obj;
	}

	private IndentHeader getIndentHeaderFromIndentHeaderTypeO(IndentHeaderTypeO headerObj) {
		IndentHeader obj = new IndentHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setId(headerObj.getId());
		return obj;
	}

	private IndentHeaderTypeM getIndentHeaderTypeM(IndentHeader headerObj) {
		IndentHeaderTypeM obj = new IndentHeaderTypeM();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setModOn(java.sql.Date.valueOf(LocalDate.now()));
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		return obj;
	}

	private IndentHeader getIndentHeaderFromIndentHeaderTypeM(IndentHeaderTypeM headerObj) {
		IndentHeader obj = new IndentHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setId(headerObj.getId());
		return obj;
	}

	private IndentHeaderTypeH getIndentHeaderTypeH(IndentHeader headerObj) {
		IndentHeaderTypeH obj = new IndentHeaderTypeH();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setModOn(java.sql.Date.valueOf(LocalDate.now()));
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		return obj;
	}

	private IndentHeader getIndentHeaderFromIndentHeaderTypeH(IndentHeaderTypeH headerObj) {
		IndentHeader obj = new IndentHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setId(headerObj.getId());
		return obj;
	}

	private IndentHeader getIndentHeaderFromIndentHeaderTypeW(IndentHeaderTypeW headerObj) {
		IndentHeader obj = new IndentHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setId(headerObj.getId());
		return obj;
	}

	private IndentHeaderTypeJ getIndentHeaderTypeJ(IndentHeader headerObj) {
		IndentHeaderTypeJ obj = new IndentHeaderTypeJ();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setModOn(java.sql.Date.valueOf(LocalDate.now()));
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		return obj;
	}

	private IndentHeader getIndentHeaderFromIndentHeaderTypeJ(IndentHeaderTypeJ headerObj) {
		IndentHeader obj = new IndentHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setIndentDate(headerObj.getIndentDate());
		obj.setMukam(headerObj.getMukam());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setType(headerObj.getType());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setId(headerObj.getId());
		return obj;
	}

	private POTypePHeader getPOTypePHeader(POHeader headerObj) {
		POTypePHeader obj = new POTypePHeader();
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setCompanyCode(headerObj.getCompanyCode());
		obj.setCreateDate(headerObj.getCreateDate());
		// obj.setCreateDate(new Date());
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		obj.setModOn(new Date());
		obj.setDeliveryAddress(headerObj.getDeliveryAddress());
		obj.setDeliveryTimeline(headerObj.getDeliveryTimeline());
		obj.setDiscount(headerObj.getDiscount());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setFooterNote(headerObj.getFooterNote());
		obj.setFrieghtCharge(headerObj.getFrieghtCharge());
		obj.setId(headerObj.getId());
		obj.setJuteUnit(headerObj.getJuteUnit());
		obj.setMukam(headerObj.getMukam());
		obj.setPoDate(headerObj.getPoDate());
		obj.setStatus(headerObj.getStatus());
		
		obj.setSupplierId(headerObj.getSupplierId());
		obj.setTax(headerObj.getTax());
		obj.setType(headerObj.getType());
		obj.setValueWithoutTax(headerObj.getValueWithoutTax());
		obj.setValueWithTax(headerObj.getValueWithTax());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setBrokerId(headerObj.getBrokerId());
		obj.setBrokerName(headerObj.getBrokerName());

		return obj;
	}

	private POHeader getPOHeaderFromPOTypePHeader(POTypePHeader headerObj) {
		POHeader obj = new POHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setCompanyCode(headerObj.getCompanyCode());
		obj.setCreateDate(headerObj.getCreateDate());
		// obj.setCreateDate(new Date());
		obj.setDeliveryAddress(headerObj.getDeliveryAddress());
		obj.setDeliveryTimeline(headerObj.getDeliveryTimeline());
		obj.setDiscount(headerObj.getDiscount());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setFooterNote(headerObj.getFooterNote());
		obj.setFrieghtCharge(headerObj.getFrieghtCharge());
		obj.setId(headerObj.getId());
		obj.setJuteUnit(headerObj.getJuteUnit());
		obj.setMukam(headerObj.getMukam());
		obj.setPoDate(headerObj.getPoDate());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSupplierId(headerObj.getSupplierId());
		obj.setTax(headerObj.getTax());
		obj.setType(headerObj.getType());
		obj.setValueWithoutTax(headerObj.getValueWithoutTax());
		obj.setValueWithTax(headerObj.getValueWithTax());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setBrokerId(headerObj.getBrokerId());
		obj.setBrokerName(headerObj.getBrokerName());

		return obj;
	}

	private POTypeGHeader getPOTypeGHeader(POHeader headerObj) {
		POTypeGHeader obj = new POTypeGHeader();
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setCompanyCode(headerObj.getCompanyCode());
		obj.setCreateDate(headerObj.getCreateDate());
		// obj.setCreateDate(new Date());
		obj.setModOn(new Date());
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		obj.setDeliveryAddress(headerObj.getDeliveryAddress());
		obj.setDeliveryTimeline(headerObj.getDeliveryTimeline());
		obj.setDiscount(headerObj.getDiscount());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setFooterNote(headerObj.getFooterNote());
		obj.setFrieghtCharge(headerObj.getFrieghtCharge());
		obj.setId(headerObj.getId());
		obj.setJuteUnit(headerObj.getJuteUnit());
		obj.setMukam(headerObj.getMukam());
		obj.setPoDate(headerObj.getPoDate());
		obj.setStatus(headerObj.getStatus());

		obj.setSupplierId(headerObj.getSupplierId());
		obj.setTax(headerObj.getTax());
		obj.setType(headerObj.getType());
		obj.setValueWithoutTax(headerObj.getValueWithoutTax());
		obj.setValueWithTax(headerObj.getValueWithTax());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setBrokerId(headerObj.getBrokerId());
		obj.setBrokerName(headerObj.getBrokerName());

		return obj;
	}

	private POHeader getPOHeaderFromPOTypeGHeader(POTypeGHeader headerObj) {
		POHeader obj = new POHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setCompanyCode(headerObj.getCompanyCode());
		obj.setCreateDate(headerObj.getCreateDate());
		// obj.setCreateDate(new Date());
		obj.setDeliveryAddress(headerObj.getDeliveryAddress());
		obj.setDeliveryTimeline(headerObj.getDeliveryTimeline());
		obj.setDiscount(headerObj.getDiscount());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setFooterNote(headerObj.getFooterNote());
		obj.setFrieghtCharge(headerObj.getFrieghtCharge());
		obj.setId(headerObj.getId());
		obj.setJuteUnit(headerObj.getJuteUnit());
		obj.setMukam(headerObj.getMukam());
		obj.setPoDate(headerObj.getPoDate());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSupplierId(headerObj.getSupplierId());
		obj.setTax(headerObj.getTax());
		obj.setType(headerObj.getType());
		obj.setValueWithoutTax(headerObj.getValueWithoutTax());
		obj.setValueWithTax(headerObj.getValueWithTax());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setBrokerId(headerObj.getBrokerId());
		obj.setBrokerName(headerObj.getBrokerName());

		return obj;
	}

	private POTypeJHeader getPOTypeJHeader(POHeader headerObj) {
		POTypeJHeader obj = new POTypeJHeader();
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setCompanyCode(headerObj.getCompanyCode());
		obj.setCreateDate(headerObj.getCreateDate());
		// obj.setCreateDate(new Date());
		obj.setModOn(new Date());
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		obj.setDeliveryAddress(headerObj.getDeliveryAddress());
		obj.setDeliveryTimeline(headerObj.getDeliveryTimeline());
		obj.setDiscount(headerObj.getDiscount());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setFooterNote(headerObj.getFooterNote());
		obj.setFrieghtCharge(headerObj.getFrieghtCharge());
		obj.setId(headerObj.getId());
		obj.setJuteUnit(headerObj.getJuteUnit());
		obj.setMukam(headerObj.getMukam());
		obj.setPoDate(headerObj.getPoDate());
		obj.setStatus(headerObj.getStatus());
		
		obj.setSupplierId(headerObj.getSupplierId());
		obj.setTax(headerObj.getTax());
		obj.setType(headerObj.getType());
		obj.setValueWithoutTax(headerObj.getValueWithoutTax());
		obj.setValueWithTax(headerObj.getValueWithTax());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setBrokerId(headerObj.getBrokerId());
		obj.setBrokerName(headerObj.getBrokerName());

		return obj;
	}

	private POHeader getPOHeaderFromPOTypeJHeader(POTypeJHeader headerObj) {
		POHeader obj = new POHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setCompanyCode(headerObj.getCompanyCode());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setDeliveryAddress(headerObj.getDeliveryAddress());
		obj.setDeliveryTimeline(headerObj.getDeliveryTimeline());
		obj.setDiscount(headerObj.getDiscount());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setFooterNote(headerObj.getFooterNote());
		obj.setFrieghtCharge(headerObj.getFrieghtCharge());
		obj.setId(headerObj.getId());
		obj.setJuteUnit(headerObj.getJuteUnit());
		obj.setMukam(headerObj.getMukam());
		obj.setPoDate(headerObj.getPoDate());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSupplierId(headerObj.getSupplierId());
		obj.setTax(headerObj.getTax());
		obj.setType(headerObj.getType());
		obj.setValueWithoutTax(headerObj.getValueWithoutTax());
		obj.setValueWithTax(headerObj.getValueWithTax());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setBrokerId(headerObj.getBrokerId());
		obj.setBrokerName(headerObj.getBrokerName());

		return obj;
	}

	private POTypeOHeader getPOTypeOHeader(POHeader headerObj) {
		POTypeOHeader obj = new POTypeOHeader();
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setCompanyCode(headerObj.getCompanyCode());
		obj.setCreateDate(headerObj.getCreateDate());
		// obj.setCreateDate(new Date());
		obj.setModOn(new Date());
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		obj.setDeliveryAddress(headerObj.getDeliveryAddress());
		obj.setDeliveryTimeline(headerObj.getDeliveryTimeline());
		obj.setDiscount(headerObj.getDiscount());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setFooterNote(headerObj.getFooterNote());
		obj.setFrieghtCharge(headerObj.getFrieghtCharge());
		obj.setId(headerObj.getId());
		obj.setJuteUnit(headerObj.getJuteUnit());
		obj.setMukam(headerObj.getMukam());
		obj.setPoDate(headerObj.getPoDate());
		obj.setStatus(headerObj.getStatus());
		
		obj.setSupplierId(headerObj.getSupplierId());
		obj.setTax(headerObj.getTax());
		obj.setType(headerObj.getType());
		obj.setValueWithoutTax(headerObj.getValueWithoutTax());
		obj.setValueWithTax(headerObj.getValueWithTax());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setBrokerId(headerObj.getBrokerId());
		obj.setBrokerName(headerObj.getBrokerName());

		return obj;
	}

	private POHeader getPOHeaderFromPOTypeOHeader(POTypeOHeader headerObj) {
		POHeader obj = new POHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setCompanyCode(headerObj.getCompanyCode());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setDeliveryAddress(headerObj.getDeliveryAddress());
		obj.setDeliveryTimeline(headerObj.getDeliveryTimeline());
		obj.setDiscount(headerObj.getDiscount());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setFooterNote(headerObj.getFooterNote());
		obj.setFrieghtCharge(headerObj.getFrieghtCharge());
		obj.setId(headerObj.getId());
		obj.setJuteUnit(headerObj.getJuteUnit());
		obj.setMukam(headerObj.getMukam());
		obj.setPoDate(headerObj.getPoDate());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSupplierId(headerObj.getSupplierId());
		obj.setTax(headerObj.getTax());
		obj.setType(headerObj.getType());
		obj.setValueWithoutTax(headerObj.getValueWithoutTax());
		obj.setValueWithTax(headerObj.getValueWithTax());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setBrokerId(headerObj.getBrokerId());
		obj.setBrokerName(headerObj.getBrokerName());

		return obj;
	}

	private POTypeMHeader getPOTypeMHeader(POHeader headerObj) {
		POTypeMHeader obj = new POTypeMHeader();
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setCompanyCode(headerObj.getCompanyCode());
		obj.setCreateDate(headerObj.getCreateDate());
		// obj.setCreateDate(new Date());
		obj.setModOn(new Date());
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		obj.setDeliveryAddress(headerObj.getDeliveryAddress());
		obj.setDeliveryTimeline(headerObj.getDeliveryTimeline());
		obj.setDiscount(headerObj.getDiscount());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setFooterNote(headerObj.getFooterNote());
		obj.setFrieghtCharge(headerObj.getFrieghtCharge());
		obj.setId(headerObj.getId());
		obj.setJuteUnit(headerObj.getJuteUnit());
		obj.setMukam(headerObj.getMukam());
		obj.setPoDate(headerObj.getPoDate());
		obj.setStatus(headerObj.getStatus());
		
		obj.setSupplierId(headerObj.getSupplierId());
		obj.setTax(headerObj.getTax());
		obj.setType(headerObj.getType());
		obj.setValueWithoutTax(headerObj.getValueWithoutTax());
		obj.setValueWithTax(headerObj.getValueWithTax());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setBrokerId(headerObj.getBrokerId());
		obj.setBrokerName(headerObj.getBrokerName());

		return obj;
	}

	private POHeader getPOHeaderFromPOTypeMHeader(POTypeMHeader headerObj) {
		POHeader obj = new POHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setCompanyCode(headerObj.getCompanyCode());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setDeliveryAddress(headerObj.getDeliveryAddress());
		obj.setDeliveryTimeline(headerObj.getDeliveryTimeline());
		obj.setDiscount(headerObj.getDiscount());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setFooterNote(headerObj.getFooterNote());
		obj.setFrieghtCharge(headerObj.getFrieghtCharge());
		obj.setId(headerObj.getId());
		obj.setJuteUnit(headerObj.getJuteUnit());
		obj.setMukam(headerObj.getMukam());
		obj.setPoDate(headerObj.getPoDate());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSupplierId(headerObj.getSupplierId());
		obj.setTax(headerObj.getTax());
		obj.setType(headerObj.getType());
		obj.setValueWithoutTax(headerObj.getValueWithoutTax());
		obj.setValueWithTax(headerObj.getValueWithTax());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setBrokerId(headerObj.getBrokerId());
		obj.setBrokerName(headerObj.getBrokerName());

		return obj;
	}

	private POTypeHHeader getPOTypeHHeader(POHeader headerObj) {
		POTypeHHeader obj = new POTypeHHeader();
		User user = userRepository.findOne(Long.valueOf(headerObj.getSubmitter()));
//		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSubmitter(user.getUserName());
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setCompanyCode(headerObj.getCompanyCode());
		obj.setCreateDate(headerObj.getCreateDate());
		// obj.setCreateDate(new Date());
		obj.setModOn(new Date());
//		obj.setModBy(headerObj.getSubmitter());
		obj.setModBy(user.getUserName());
		obj.setDeliveryAddress(headerObj.getDeliveryAddress());
		obj.setDeliveryTimeline(headerObj.getDeliveryTimeline());
		obj.setDiscount(headerObj.getDiscount());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setFooterNote(headerObj.getFooterNote());
		obj.setFrieghtCharge(headerObj.getFrieghtCharge());
		obj.setId(headerObj.getId());
		obj.setJuteUnit(headerObj.getJuteUnit());
		obj.setMukam(headerObj.getMukam());
		obj.setPoDate(headerObj.getPoDate());
		obj.setStatus(headerObj.getStatus());
		
		obj.setSupplierId(headerObj.getSupplierId());
		obj.setTax(headerObj.getTax());
		obj.setType(headerObj.getType());
		obj.setValueWithoutTax(headerObj.getValueWithoutTax());
		obj.setValueWithTax(headerObj.getValueWithTax());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setBrokerId(headerObj.getBrokerId());
		obj.setBrokerName(headerObj.getBrokerName());

		return obj;
	}

	private POHeader getPOHeaderFromPOTypeHHeader(POTypeHHeader headerObj) {
		POHeader obj = new POHeader();
		obj.setApproveFirstDate(headerObj.getApproveFirstDate());
		obj.setApproverFirst(headerObj.getApproverFirst());
		obj.setApproverSecond(headerObj.getApproverSecond());
		obj.setApproveSecondDate(headerObj.getApproveSecondDate());
		obj.setCompanyCode(headerObj.getCompanyCode());
		obj.setCreateDate(headerObj.getCreateDate());
		obj.setDeliveryAddress(headerObj.getDeliveryAddress());
		obj.setDeliveryTimeline(headerObj.getDeliveryTimeline());
		obj.setDiscount(headerObj.getDiscount());
		obj.setFinnacialYear(headerObj.getFinnacialYear());
		obj.setFooterNote(headerObj.getFooterNote());
		obj.setFrieghtCharge(headerObj.getFrieghtCharge());
		obj.setId(headerObj.getId());
		obj.setJuteUnit(headerObj.getJuteUnit());
		obj.setMukam(headerObj.getMukam());
		obj.setPoDate(headerObj.getPoDate());
		obj.setStatus(headerObj.getStatus());
		obj.setSubmitter(headerObj.getSubmitter());
		obj.setSupplierId(headerObj.getSupplierId());
		obj.setTax(headerObj.getTax());
		obj.setType(headerObj.getType());
		obj.setValueWithoutTax(headerObj.getValueWithoutTax());
		obj.setValueWithTax(headerObj.getValueWithTax());
		obj.setVehicleQuantity(headerObj.getVehicleQuantity());
		obj.setVehicleTypeId(headerObj.getVehicleTypeId());
		obj.setBrokerId(headerObj.getBrokerId());
		obj.setBrokerName(headerObj.getBrokerName());

		return obj;
	}

	@Override
	public List<ServiceBatchType> getAllServiceBatchType() {
		List<ServiceBatchType> list = new ArrayList<ServiceBatchType>();
		for (ServiceBatchType obj : serviceBatchRepository.findAll()) {
			list.add(obj);
		}
		return list;
	}

	@Override
	public ServiceBatchType geServiceBatchTypeDetailsById(long id) {
		ServiceBatchType obj = null;
		obj = serviceBatchRepository.findOne(id);
		return obj;
	}

	@Override
	public List<POHeader> getAllPOBySuppCodeAndChalanNo(String suppCode, Long chalanNo) {
		List<POHeader> pohdrDTOs = new ArrayList<>();
		if (suppCode.startsWith("J")) {
			List<JuteGRNEntry> juteentryhdrs = juteGRNEntryRepository.findBySuppCodeAndChalanNo(suppCode, chalanNo);
			for (int i = 0; i < juteentryhdrs.size(); i++) {
				POHeader pohdrDTO = new POHeader();
				POHeader POHeaderEntities = pOHeaderRepository.findOne(juteentryhdrs.get(i).getPoId());
				pohdrDTOs.add(POHeaderEntities);
			}
		} else {
			List<StoreGRNEntry> storeentryhds = storeentryhdrReposirtory.findByChalanNoAndSuppCode(chalanNo, suppCode);
			for (int j = 0; j < storeentryhds.size(); j++) {
				POHeader pohdrDTO = new POHeader();
				POHeader POHeaderEntities = pOHeaderRepository.findOne(storeentryhds.get(j).getPoId());
				pohdrDTOs.add(POHeaderEntities);
			}
		}
		return pohdrDTOs.stream().sorted(Comparator.comparing(POHeader::getModOn).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public List<StoreGRNEntryDTO> getStoreReceiveNoByChalanNo(long chalanNo, String suppCode, String poNo) {
		List<StoreGRNEntryDTO> dtosEmp = new ArrayList<>();
		List<StoreGRNEntry> entitis = storeentryhdrReposirtory.findByChalanNoAndSuppCodeAndPoId(chalanNo, suppCode,
				poNo);
		for (int i = 0; i < entitis.size(); i++) {
			StoreGRNEntryDTO dto = new StoreGRNEntryDTO();

			dto.setChalanDate(entitis.get(i).getChalanDate());
			dto.setChalanNo(entitis.get(i).getChalanNo());
			dto.setId(entitis.get(i).getId());
			dto.setPoNo(entitis.get(i).getPoId());
			dto.setSuppCode(entitis.get(i).getSuppCode());
			dto.setVehicleNo(entitis.get(i).getVehicleNo());

			dtosEmp.add(dto);
		}
		return dtosEmp;
	}

	@Override
	public List<ChalanDTO> getStoreChalanListBySupplierDistinct(String supplierCode) {
		List<ChalanDTO> chalanDTOEmp = new ArrayList<>();
		if (supplierCode.startsWith("J")) {
			List<JuteGRNEntry> storeChalanList = juteentryhdrReposiotry.findBySuppCode(supplierCode);
			List<Long> chalans = storeChalanList.stream().map(JuteGRNEntry::getChalanNo).collect(Collectors.toList())
					.stream().distinct().collect(Collectors.toList());
			for (int i = 0; i < chalans.size(); i++) {
				ChalanDTO chalanDTO = new ChalanDTO();
				chalanDTO.setChalanNo(chalans.get(i));
				chalanDTOEmp.add(chalanDTO);
			}
		} else {
			List<StoreGRNEntry> storeChalanList = storeGRNEntryRepository.findBySuppCode(supplierCode);
			List<Long> chalans = storeChalanList.stream().map(StoreGRNEntry::getChalanNo).collect(Collectors.toList())
					.stream().distinct().collect(Collectors.toList());
			for (int i = 0; i < chalans.size(); i++) {
				ChalanDTO chalanDTO = new ChalanDTO();
				chalanDTO.setChalanNo(chalans.get(i));
				chalanDTOEmp.add(chalanDTO);
			}
		}

		return chalanDTOEmp.stream().distinct().collect(Collectors.toList());
	}

	@Override
	public MaterialGoodReceiveDetails updateMaterialGoodReceiveDetails(
			MaterialGoodReceiveDetails materialGoodReceiveDetails) {
		MaterialGoodReceiveDetails obj = new MaterialGoodReceiveDetails();
		MaterialGoodReceiveHeader headerObj = null;
		MaterialGoodReceiveLineItem materialGoodReceiveLineItemObj = null;
		List<MaterialGoodReceiveItemVo> materialGoodReceiveItemVoList = new ArrayList<MaterialGoodReceiveItemVo>();
		List<MaterialGoodReceiveItemVo> resultMaterialGoodReceiveItemVoList = new ArrayList<MaterialGoodReceiveItemVo>();
		// System.out.println("2. @@@@@@@@@@@@@@@@@
		// "+materialGoodReceiveDetails.getMaterialGoodReceiveHeader().getId());
		if (null != materialGoodReceiveDetails) {
			MaterialGoodReceiveHeader materialGoodReceiveHeader = materialGoodReceiveDetails
					.getMaterialGoodReceiveHeader();
			materialGoodReceiveHeader.setModOn(new Date());
			// materialGoodReceiveHeader.setCreateDate(new Date());
			headerObj = materialGoodReceiveHeaderRepository.save(materialGoodReceiveHeader);
			materialGoodReceiveItemVoList = materialGoodReceiveDetails.getMaterialGrnItemList();

			for (MaterialGoodReceiveItemVo itemVo : materialGoodReceiveItemVoList) {
				itemVo.setMaterialGrnHdrId(headerObj.getId());

				materialGoodReceiveLineItemObj = materialGoodReceiveItemRepository
						.save(getMaterialGoodReceiveLineItem(itemVo));
				resultMaterialGoodReceiveItemVoList
						.add(getMaterialGoodReceiveItemVo(materialGoodReceiveLineItemObj, headerObj.getPoId()));
				PhysicalStock physicalStockObj = null;
				if (headerObj.getAgentId() == null) {
					if (materialGoodReceiveLineItemObj.getStatus().equalsIgnoreCase("1")) {
						physicalStockObj = new PhysicalStock();
						physicalStockObj.setWareHouseNo(materialGoodReceiveLineItemObj.getWarehouseNo());
						physicalStockObj.setNewStock(materialGoodReceiveLineItemObj.getActualWeight());
						Item itemObj = itemRepository.findOne(materialGoodReceiveLineItemObj.getItemId());
						physicalStockObj.setItemGroupId(itemObj.getGroupId());
						physicalStockObj.setItemId(materialGoodReceiveLineItemObj.getItemId());
						physicalStockObj
								.setQualityCode(String.valueOf(materialGoodReceiveLineItemObj.getActualQuality()));
						physicalStockObj.setStoreId(-1);
						physicalStockObj.setTotalStock(0);
						physicalStockObj.setExistingStock(-1);
						physicalStockObj.setExistingStockIndentId(-1);
						physicalStockObj.setNewStockIndentId(-1);
						physicalStockObj.setStockInHand(-1);
						// physicalStockObj.setLastModifiedDate(new Date());
						physicalStockObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));

						physicalStockObj.setTotalBaleStock(0);
						physicalStockObj.setExistingBaleStock(-1);
						physicalStockObj.setStockInHandBale(-1);

						physicalStockObj.setGoodType("MR");
						physicalStockObj.setGoodItemSerialNo(materialGoodReceiveLineItemObj.getId());
						physicalStockObj.setReceiveNo(materialGoodReceiveLineItemObj.getMaterialGrnHdrId());

						if (materialGoodReceiveLineItemObj.getBale() > 0) {
							physicalStockObj.setConversionUnit("BALE");
							physicalStockObj.setNewBaleStock(materialGoodReceiveLineItemObj.getActualBale());
						}
						if (materialGoodReceiveLineItemObj.getLoose() > 0) {
							physicalStockObj.setConversionUnit("LOOSE");
						}
						physicalStockObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));
						physicalStockRepository.save(physicalStockObj);
					} else if (materialGoodReceiveLineItemObj.getStatus().equalsIgnoreCase("3")) {
						List<PhysicalStock> physicalStockObjList = physicalStockRepository
								.findByItemIdAndQualityCodeAndReceiveNo(materialGoodReceiveLineItemObj.getItemId(),
										String.valueOf(materialGoodReceiveLineItemObj.getActualQuality()),
										materialGoodReceiveLineItemObj.getMaterialGrnHdrId());
						if (physicalStockObjList != null && physicalStockObjList.size() > 0) {
							physicalStockObj = physicalStockObjList.get(0);
							physicalStockObj.setTotalStock(physicalStockObj.getNewStock());
							physicalStockObj.setStockInHand(physicalStockObj.getTotalStock());

							if (materialGoodReceiveLineItemObj.getBale() > 0) {
								physicalStockObj.setConversionUnit("BALE");
								physicalStockObj.setTotalBaleStock(physicalStockObj.getNewBaleStock());
								physicalStockObj.setStockInHandBale(physicalStockObj.getNewBaleStock());

							}
							if (materialGoodReceiveLineItemObj.getLoose() > 0) {
								physicalStockObj.setConversionUnit("LOOSE");
							}
							physicalStockObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));
							physicalStockRepository.save(physicalStockObj);
						}
					} else if (materialGoodReceiveLineItemObj.getStatus().equalsIgnoreCase("4")) {
						List<PhysicalStock> physicalStockObjList = physicalStockRepository
								.findByItemIdAndQualityCodeAndReceiveNo(materialGoodReceiveLineItemObj.getItemId(),
										String.valueOf(materialGoodReceiveLineItemObj.getActualQuality()),
										materialGoodReceiveLineItemObj.getMaterialGrnHdrId());
						if (physicalStockObjList != null && physicalStockObjList.size() > 0) {
							physicalStockObj = physicalStockObjList.get(0);
							physicalStockObj.setNewStock(0);
							physicalStockObj.setLastModifiedDate(java.sql.Date.valueOf(LocalDate.now()));
							physicalStockRepository.save(physicalStockObj);
						}
					} else {

					}

				}

			}

		}

		obj.setMaterialGoodReceiveHeader(headerObj);
		obj.setMaterialGrnItemList(resultMaterialGoodReceiveItemVoList);
		return obj;
	}

	@Override
	public List<Supplier> getAllSupplierByIndentNo(String indentId) {
		List<Supplier> resultList = new ArrayList<Supplier>();
		Supplier supplierObj = null;
		/*
		 * for (SupplierIndent obj :
		 * supplierIndentRepository.findByIndentHeaderId(indentId)) { supplierObj =
		 * supplierRepository.findOne(obj.getSupplierCode()); if (null != supplierObj) {
		 * resultList.add(supplierObj); }
		 * 
		 * }
		 */
		List<SupplierIndent> obj = supplierIndentRepository.findByIndentHeaderId(indentId);
		List<String> suppcode = obj.stream().map(SupplierIndent::getSupplierCode).distinct()
				.collect(Collectors.toList());
		for (int i = 0; i < suppcode.size(); i++) {
			supplierObj = supplierRepository.findOne(suppcode.get(i));
			if (null != supplierObj) {
				resultList.add(supplierObj);
			}
		}

		return resultList.stream().sorted(Comparator.comparing(Supplier::getName)).distinct()
				.collect(Collectors.toList());
	}

	@Override
	public List<SupplierIndentApprovalDTO> getSupplierIndentDetailsByIndentNoAndSupplierCode(String indentNo) {
		List<SupplierIndentApprovalDTO> supplierindentDTOs = new ArrayList<>();
		List<SupplierIndent> supplierresponse = supplierIndentRepository.findByIndentHeaderId(indentNo);
		List<String> supplierresponsedist = supplierresponse.stream().map(SupplierIndent::getSupplierCode)
				.collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());
		for (int i = 0; i < supplierresponsedist.size(); i++) {
			SupplierIndentApprovalDTO supplierindentDTO = new SupplierIndentApprovalDTO();
			List<SupplierResponseIndentLineDTO> lineitems = new ArrayList<>();

			List<SupplierIndent> supplierresponseline = supplierIndentRepository
					.findBySupplierCodeAndIndentHeaderId(supplierresponsedist.get(i), indentNo);
			Supplier supplier = supplierRepository.findOne(supplierresponsedist.get(i));

			for (int j = 0; j < supplierresponseline.size(); j++) {
				supplierindentDTO.setTranId(supplierresponseline.get(j).getTransId());
				lineitems.add(prepareResponseIndentLineDTO(supplierresponseline.get(j)));
			}
			// supplierindentDTO.setTranId(supplierresponse.get(j).getTransId());
			supplierindentDTO.setSupplier(supplier);
			supplierindentDTO.setIndentlineitems(lineitems);
			supplierindentDTOs.add(supplierindentDTO);
		}
		return supplierindentDTOs.stream().distinct().collect(Collectors.toList());
	}

	private SupplierResponseIndentLineDTO prepareResponseIndentLineDTO(SupplierIndent supplierIndent) {
		SupplierResponseIndentLineDTO dto = new SupplierResponseIndentLineDTO();
		SupplierIndent supplierresponse = supplierIndentRepository
				.findBySupplierCodeAndId(supplierIndent.getSupplierCode(), supplierIndent.getId());
		Item item = itemRepository.findOne(supplierIndent.getItemId());
		ItemGroup group = itemGroupRepository.findOne(item.getGroupId());
		Quality quality = qualityRepository.findOne(supplierIndent.getQualityCode());
		Indent indentline = indentRepository.findOne(supplierIndent.getId());
		Department dept = departmentRepository.findOne(indentline.getDeptId());

		dto.setTranId(supplierresponse.getTransId());
		dto.setApproveFirstDate(supplierIndent.getApproveFirstDate());
		dto.setApproverFirst(supplierIndent.getApproverFirst());
		dto.setApproverSecond(supplierIndent.getApproverSecond());
		dto.setApproveSecondDate(supplierIndent.getApproveSecondDate());
		dto.setIndentItemId(supplierIndent.getId());
		dto.setIndentId(supplierIndent.getIndentHeaderId());
		dto.setIndentQuantity(supplierIndent.getIndentQuantity());
		dto.setItemGroup(group);

		dto.setDeptId(dept.getName());

		dto.setItem(prepareItemDTO(item));

		dto.setMarka(supplierIndent.getMarka());
		dto.setQuality(quality);
		dto.setRate(supplierresponse.getRate());
		dto.setStatus(supplierIndent.getStatus());
		dto.setType(supplierIndent.getType());
		dto.setUnitId(supplierIndent.getUnitId());

		dto.setDiscount(0);
		return dto;
	}

	private ItemDTO prepareItemDTO(Item item) {
		ItemDTO dto = new ItemDTO();
		ItemTax itemtax = itemBoObj.itemTaxRepository.findByHsnCode(item.getHsnCode()).get(0);
		QuantityUnit quantity = itemBoObj.quantityUnitRepository.findOne(item.getUomCode());
		dto.setCentralStockValue(item.getCentralStockValue());
		dto.setGroupId(item.getGroupId());
		dto.setHsnCode(item.getHsnCode());
		dto.setId(item.getId());
		dto.setLegacyItemCode(item.getLegacyItemCode());
		dto.setMake(item.getMake());
		dto.setMaxOrderValue(item.getMaxOrderValue());
		dto.setMaxValue(item.getMaxValue());
		dto.setName(item.getName());
		dto.setStock(item.getStock());
		dto.setUomCode(item.getUomCode());

		dto.setQuantityUnit(quantity);
		dto.setItemTax(itemtax);
		dto.setItemStock(item.getItemStock());
		return dto;
	}

	private Item prepareItemEntity(ItemDTO item) {
		Item dto = new Item();
		Item item1 = itemRepository.findByName(item.getName());
		ItemTax itemtax = itemBoObj.itemTaxRepository.findByItemInTax(item1);
		QuantityUnit quantity = itemBoObj.quantityUnitRepository.findOne(item.getUomCode());
		dto.setCentralStockValue(item.getCentralStockValue());
		dto.setGroupId(item.getGroupId());
		dto.setHsnCode(item.getHsnCode());
		dto.setId(item.getId());
		dto.setLegacyItemCode(item.getLegacyItemCode());
		dto.setMake(item.getMake());
		dto.setMaxOrderValue(item.getMaxOrderValue());
		dto.setMaxValue(item.getMaxValue());
		dto.setName(item.getName());
		dto.setStock(item.getStock());
		dto.setUomCode(item.getUomCode());

		dto.setQuantityUnit(quantity);
		dto.setItemTax(item.getItemTax());
		dto.setItemStock(item.getItemStock());
		return dto;
	}

	@Override
	public List<SupplierIndentApprovalDTO> saveSupplierIndentDetailsByIndentNo(
			List<SupplierIndentApprovalDTO> suppreponse) {
		List<SupplierResponseIndentLineDTO> indentlineitem = new ArrayList<>();
		List<SupplierResponseIndentLineDTO> indentlineitems = new ArrayList<>();
		for (int i = 0; i < suppreponse.size(); i++) {
			// SupplierIndent suppindent =
			// supplierIndentRepository.findOne(suppreponse.get(i).getTranId());
			indentlineitem = suppreponse.get(i).getIndentlineitems();
			indentlineitems.addAll(indentlineitem);
		}

		List<SupplierIndent> suppindents = new ArrayList<>();
		for (int j = 0; j < indentlineitems.size(); j++) {
			SupplierIndent suppindent = supplierIndentRepository.findOne(indentlineitems.get(j).getTranId());

			suppindent.setApproveFirstDate(indentlineitems.get(j).getApproveFirstDate());
			suppindent.setApproverFirst(indentlineitems.get(j).getApproverFirst());
			suppindent.setApproverSecond(indentlineitems.get(j).getApproverSecond());
			suppindent.setApproveSecondDate(indentlineitems.get(j).getApproveSecondDate());
			// suppindent.setCreateDate(indentlineitems.get(i).get);
			// suppindent.setCurrencyCode(indentlineitems.get(i).getc);
			// suppindent.setFinnacialYear(indentlineitems.get(i).fin);
			suppindent.setId(indentlineitems.get(j).getIndentItemId());
			suppindent.setIndentHeaderId(indentlineitems.get(j).getIndentId());
			suppindent.setIndentQuantity(indentlineitems.get(j).getIndentQuantity());

			if (indentlineitems.get(j).getItemGroup() != null)
				suppindent.setItemGroupId(indentlineitems.get(j).getItemGroup().getId());

			if (indentlineitems.get(j).getItem() != null)
				suppindent.setItemId(indentlineitems.get(j).getItem().getId());

			suppindent.setMarka(indentlineitems.get(j).getMarka());

			if (indentlineitems.get(j).getQuality() != null)
				suppindent.setQualityCode(indentlineitems.get(j).getQuality().getId());

			suppindent.setRate(indentlineitems.get(j).getRate());
			suppindent.setStatus(indentlineitems.get(j).getStatus());
			// suppindent.setSubmitter(indentlineitems.get(i).gets);
			// suppindent.setSupplierCode(suppreponse.get(j).getSupplier().getId());
			suppindent.setTransId(indentlineitems.get(j).getTranId());
			suppindent.setType(indentlineitems.get(j).getType());
			suppindent.setUnitId(indentlineitems.get(j).getUnitId());

			System.out.println("after " + suppindent.getRate());
			System.out.println("inside save");
			// suppindents.add(suppindent);
			// suppindents.add(supplierIndentRepository.save(suppindent));
			supplierindentDao.save(suppindent);

		}
		// supplierIndentRepository.save(suppindents);
		return suppreponse;
	}

	@Override
	public TotalValueDTO getTotalValueFromStoreGoodReceiveBySrNoAndType(Long srNo, String srType) {
		TotalValueDTO totalvalue = new TotalValueDTO();
		
		Float totval = 0.0f;
		if(srType.equalsIgnoreCase("SR")) {
			List<StoreGoodReceiveLineItem> srlines = storeGoodReceiveItemRepository.findByStoreGrnHdrId(srNo);
			
			for(int i = 0 ; i < srlines.size() ; i++) {
				if(!srlines.get(i).getStatus().equalsIgnoreCase("4")) {
					Float actualWeight = srlines.get(i).getActualQuantity();
					Float val = actualWeight*srlines.get(i).getReceivedPrice();
					totval = totval + val;
				}
			}
		}else {
			List<MaterialGoodReceiveLineItem> mrlines = 
					materialGoodReceiveItemRepository.findByMaterialGrnHdrId(srNo);
			for(int i = 0 ; i < mrlines.size() ; i++) {
				if(!mrlines.get(i).getStatus().equalsIgnoreCase("4")) {
					Float actualWeight = mrlines.get(i).getActualWeight();
					Float val = actualWeight*mrlines.get(i).getRate();
					totval = totval + val;
				}
			}
		}
		
		totalvalue.setTotalValue(totval);
		return totalvalue;
	}

}
