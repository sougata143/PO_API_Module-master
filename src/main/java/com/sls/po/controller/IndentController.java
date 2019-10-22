package com.sls.po.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sls.po.bo.IndentBoImpl;
import com.sls.po.model.BillPass;
import com.sls.po.model.Broker;
import com.sls.po.model.GoodReceiveHeader;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.Item;
import com.sls.po.model.JuteGRNEntry;
import com.sls.po.model.JuteQualityEntryHeader;
import com.sls.po.model.LoginToken;
import com.sls.po.model.Mukam;
import com.sls.po.model.POHeader;
import com.sls.po.model.ReportCounter;
import com.sls.po.model.ServiceBatchType;
import com.sls.po.model.StoreGRNEntry;
import com.sls.po.model.Supplier;
import com.sls.po.model.SupplierIndentNotification;
import com.sls.po.model.Vehicle;
import com.sls.po.vo.BillPassDTO;
import com.sls.po.vo.ChalanDTO;
import com.sls.po.vo.DebitCreditNotesVo;
import com.sls.po.vo.GoodReceiveDetails;
import com.sls.po.vo.IndentDetails;
import com.sls.po.vo.IssueDetails;
import com.sls.po.vo.IssueItemVo;
import com.sls.po.vo.JuteEntryHeaderDTO;
import com.sls.po.vo.MaterialGoodReceiveDetails;
import com.sls.po.vo.MaterialGoodReceiveItemVo;
import com.sls.po.vo.POChalanDetails;
import com.sls.po.vo.PODetails;
import com.sls.po.vo.StoreGRNEntryDTO;
import com.sls.po.vo.StoreGoodReceiveDetails;
import com.sls.po.vo.StoreGoodReceiveItemVo;
import com.sls.po.vo.SupplierIndentApprovalDTO;
import com.sls.po.vo.SupplierIndentVo;
import com.sls.po.vo.SupplierIndentVoMaster;
import com.sls.po.vo.TotalValueDTO;

@CrossOrigin(origins = "*")
@RestController
public class IndentController {

	@Autowired
	@Qualifier("indentBoObj")
	IndentBoImpl boObj;

	@RequestMapping(value = "/api/v1/getAllIndent", method = RequestMethod.GET)
	public List<IndentHeader> getAllInden() {

		// IndentBo boObj= new IndentBoImpl();
		List<IndentHeader> list = new ArrayList<IndentHeader>();
		list = boObj.getAllIndent();
		return list.stream().sorted(Comparator.comparing(IndentHeader::getCreateDate).reversed())
				.collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{status}/getAllIndentByStatus", method = RequestMethod.GET)
	public List<IndentHeader> getAllIndentByStatus(@PathVariable String status) {
		// IndentBo boObj= new IndentBoImpl();
		List<IndentHeader> list = new ArrayList<IndentHeader>();
		list = boObj.getAllIndentByStatus(status);

		return list.stream().sorted(Comparator.comparing(IndentHeader::getCreateDate).reversed())
				.collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{mukam}/getAllIndentByMukam", method = RequestMethod.GET)
	public List<IndentHeader> getAllIndentByMukam(@PathVariable String mukam) {
		// IndentBo boObj= new IndentBoImpl();
		List<IndentHeader> list = new ArrayList<IndentHeader>();
		list = boObj.getAllIndentByMukam(mukam);

		return list.stream().sorted(Comparator.comparing(IndentHeader::getCreateDate).reversed())
				.collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{indentId}/getIndentDetails", method = RequestMethod.GET)
	public IndentDetails getIndentDetails(@PathVariable String indentId) {
		IndentDetails indentDetailsObj = null;
		// IndentBo boObj= new IndentBoImpl();
		indentDetailsObj = boObj.getIndentDetails(indentId);
		return indentDetailsObj;

	}

	@RequestMapping(value = "/api/v1/addIndent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public IndentDetails addIndent(@RequestBody IndentDetails indentDetailsIn) {
		IndentDetails indentDetails = boObj.addIndent(indentDetailsIn);
		return indentDetails;
	}

	@RequestMapping(value = "/api/v1/updateIndent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public IndentDetails updateIndent(@RequestBody IndentDetails indentDetailsIn) {
		IndentDetails indentDetails = boObj.updateIndent(indentDetailsIn);
		return indentDetails;
	}

	@RequestMapping(value = "/api/v1/addIndentSupplierRequest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SupplierIndentNotification> addIndentNotification(
			@RequestBody List<SupplierIndentNotification> supplierIndentNotificationList) {
		List<SupplierIndentNotification> list = boObj.addSupplierIndentNotification(supplierIndentNotificationList);
		return list;
	}

	@RequestMapping(value = "/api/v1/getAllSuppliersByIndentNo/{indentNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Supplier> getAllSupplierByIndentNo(@PathVariable String indentNo) {
		return boObj.getAllSupplierByIndentNo(indentNo);
	}

	@RequestMapping(value = "/api/v1/getAllSupplierIndentDetailsBySupplierAndIndent/{indentNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SupplierIndentApprovalDTO> getSupplierIndentDetailsByIndentNoAndSupplierCode(
			@PathVariable("indentNo") String indentNo) {
		return boObj.getSupplierIndentDetailsByIndentNoAndSupplierCode(indentNo);
	}
	
	@PostMapping(value = "/api/v1/addUpdateAllSupplierIndentDetailsBySupplierAndIndent")
	public List<SupplierIndentApprovalDTO> addUpdateAllSupplierIndentDetailsBySupplierAndIndent(
			@RequestBody List<SupplierIndentApprovalDTO> suppreponse) {
		return boObj.saveSupplierIndentDetailsByIndentNo(suppreponse);
	}

	@RequestMapping(value = "/api/v1/{indentId}/getRequestedSupplierListByIndent", method = RequestMethod.GET)
	public List<Supplier> getRequestedSupplierListByIndent(@PathVariable String indentId) {
		List<Supplier> list = boObj.getRequestedSupplierListByIndent(indentId);
		return list.stream().sorted(Comparator.comparing(Supplier::getName)).collect(Collectors.toList());
	}

	@RequestMapping(value = "/api/v1/addUpdateSupplierIndentResponse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<SupplierIndentVo> addUpdateSupplierIndentResponse(
			@RequestBody List<SupplierIndentVo> supplierIndentVoList) {
		List<SupplierIndentVo> listObj = boObj.addSupplierResponseIndentDetails(supplierIndentVoList);
		return listObj;
	}

	@RequestMapping(value = "/api/v1/{supplierCode}/getAllItemsBySupplier", method = RequestMethod.GET)
	public List<Item> getAllSupplierIndentBySupplier(@PathVariable String supplierCode) {
		List<Item> listObj = boObj.getAllItemsBySupplierCode(supplierCode);
		return listObj.stream().sorted(Comparator.comparing(Item::getName)).collect(Collectors.toList());
	}

	@RequestMapping(value = "/api/v1/{supplierCodeItemCode}/getAllIndentIdsBySupplierItem", method = RequestMethod.GET)
	public List<String> getAllIndentIdsBySupplierItem(@PathVariable String supplierCodeItemCode) {
		List<String> listObj = null;
		if (null != supplierCodeItemCode) {
			String[] ids = supplierCodeItemCode.split("\\^");
			if (ids.length > 1) {
				listObj = boObj.getAllSupplierResponseIndentBySupplierCodeItemCode(ids[0], ids[1]);
			}
		}
		return listObj;
	}

	@RequestMapping(value = "/api/v1/{supplierCode}/getAllSupplierIndentDetailsBySupplier", method = RequestMethod.GET)
	public List<SupplierIndentVo> getAllSupplierIndentDetailsBySupplier(@PathVariable String supplierCode) {
		List<SupplierIndentVo> listObj = boObj.getSupplierResponseIndentDetailsBySupplierCode(supplierCode);
		return listObj;
	}

	@RequestMapping(value = "/api/v1/{ids}/getAllSupplierIndentDetailsByIdsOLD", method = RequestMethod.GET)
	public List<SupplierIndentVo> getAllSupplierIndentDetailsByIndentId(@PathVariable String ids) {
		List<SupplierIndentVo> listObj = null;
		if (null != ids) {
			String[] params = ids.split("\\^");
			if (params.length > 2) {
				listObj = boObj.getSupplierResponseIndentDetailsByIds(params[0], params[1], params[2]);
			}
		}
		return listObj;
	}

	@RequestMapping(value = "/api/v1/getAllPO", method = RequestMethod.GET)
	public List<POHeader> getAllPO() {
		List<POHeader> list = new ArrayList<POHeader>();
		list = boObj.getAllPO();
		return list.stream().sorted(Comparator.comparing(POHeader::getCreateDate).reversed())
				.collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{status}/getAllPOByStatus", method = RequestMethod.GET)
	public List<POHeader> getAllPOByStatus(@PathVariable String status) {
		List<POHeader> list = new ArrayList<POHeader>();
		list = boObj.getAllPOByStatus(status);

		return list.stream().sorted(Comparator.comparing(POHeader::getCreateDate).reversed())
				.collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{poId}/getPODetails", method = RequestMethod.GET)
	public PODetails getPODetails(@PathVariable String poId) {
		PODetails poDetailsObj = null;
		poDetailsObj = boObj.getPODetails(poId);
		return poDetailsObj;
	}

	@RequestMapping(value = "/api/v1/addPO", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PODetails addPO(@RequestBody PODetails poDetailsIn) {
		PODetails pODetails = boObj.addPODetails(poDetailsIn);
		return pODetails;
	}

	@RequestMapping(value = "/api/v1/updatePO", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PODetails updatePO(@RequestBody PODetails poDetailsIn) {
		PODetails pODetails = boObj.updatePODetails(poDetailsIn);
		return pODetails;
	}

	@RequestMapping(value = "/api/v1/getAllGRN", method = RequestMethod.GET)
	public List<GoodReceiveHeader> getAllGRN() {
		List<GoodReceiveHeader> list = new ArrayList<GoodReceiveHeader>();
		list = boObj.getAllGoodReceiveHeader();
		return list;

	}

	@RequestMapping(value = "/api/v1/{status}/getAllGRNByStatus", method = RequestMethod.GET)
	public List<GoodReceiveHeader> getAllGRNByStatus(@PathVariable String status) {
		List<GoodReceiveHeader> list = new ArrayList<GoodReceiveHeader>();
		list = boObj.getAllGoodReceiveHeaderByStatus(status);

		return list;

	}

	@RequestMapping(value = "/api/v1/{grnId}/getGRNDetails", method = RequestMethod.GET)
	public GoodReceiveDetails getGRNDetails(@PathVariable long grnId) {
		GoodReceiveDetails goodReceiveDetails = null;
		goodReceiveDetails = boObj.getGoodReceiveDetails(grnId);
		return goodReceiveDetails;
	}

	@RequestMapping(value = "/api/v1/addGRN", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public GoodReceiveDetails addGRN(@RequestBody GoodReceiveDetails goodReceiveDetailsIn) {
		GoodReceiveDetails goodReceiveDetails = boObj.addGoodReceiveDetails(goodReceiveDetailsIn);
		return goodReceiveDetails;
	}

	@RequestMapping(value = "/api/v1/updateGRN", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public GoodReceiveDetails updateGRN(@RequestBody GoodReceiveDetails goodReceiveDetailsIn) {
		GoodReceiveDetails goodReceiveDetails = boObj.addGoodReceiveDetails(goodReceiveDetailsIn);
		return goodReceiveDetails;
	}

	@RequestMapping(value = "/api/v1/getAllLoanIssue", method = RequestMethod.GET)
	public List<IssueDetails> getAllIssue() {
		List<IssueDetails> list = new ArrayList<IssueDetails>();
		list = boObj.getAllIssue();
		return list;

	}

	@RequestMapping(value = "/api/v1/{id}/getLoanIssueDetailsById", method = RequestMethod.GET)
	public IssueDetails getLoanIssueDetailsById(@PathVariable long id) {
		IssueDetails obj = null;
		obj = boObj.getIssueDetailsById(id);
		return obj;
	}

	@RequestMapping(value = "/api/v1/{ids}/getStoreGoodReceiveItemForIssue", method = RequestMethod.GET)
	public List<StoreGoodReceiveItemVo> getStoreGoodReceiveItemForIssue(@PathVariable String ids) {
		List<StoreGoodReceiveItemVo> listObj = null;
		if (null != ids) {
			String[] params = ids.split("\\^");
			if (params.length > 2) {
				listObj = boObj.getStoreGoodReceiveItemForIssue(params[0], params[1], Float.valueOf(params[2]));
			}
		}
		return listObj;
	}

	@RequestMapping(value = "/api/v1/{ids}/getMaterialGoodReceiveItemForIssue", method = RequestMethod.GET)
	public List<MaterialGoodReceiveItemVo> getMaterialGoodReceiveItemForIssue(@PathVariable String ids) {
		List<MaterialGoodReceiveItemVo> listObj = null;
		if (null != ids) {
			String[] params = ids.split("\\^");
			if (params.length > 2) {
				listObj = boObj.getMaterialGoodReceiveItemForIssue(params[0], params[1], Float.valueOf(params[2]));
			}
		}
		return listObj;
	}

	@RequestMapping(value = "/api/v1/getAllLoans", method = RequestMethod.GET)
	public List<IssueDetails> getAllLoans() {
		List<IssueDetails> list = new ArrayList<IssueDetails>();
		list = boObj.getAllLoans();
		return list;

	}

	@RequestMapping(value = "/api/v1/{departmentId}/getAllIssueByDepartmentId", method = RequestMethod.GET)
	public List<IssueDetails> getAllIssueByDepartmentId(@PathVariable long departmentId) {
		List<IssueDetails> list = new ArrayList<IssueDetails>();
		list = boObj.getAllIssueByDeparttmentId(departmentId);

		return list;

	}

	@RequestMapping(value = "/api/v1/{unitId}/getAllLoansByUnitId", method = RequestMethod.GET)
	public List<IssueDetails> getAllLoansByUnitId(@PathVariable String unitId) {
		List<IssueDetails> list = new ArrayList<IssueDetails>();
		list = boObj.getAllLoansByUnitId(unitId);

		return list;

	}

	@RequestMapping(value = "/api/v1/addLoanIssue", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public IssueDetails addIssue(@RequestBody IssueDetails issueItemVoIn) {
		IssueDetails issueItemVo = boObj.addLoanIssue(issueItemVoIn);
		return issueItemVo;
	}

	@RequestMapping(value = "/api/v1/updateIssue", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public IssueItemVo updateIssue(@RequestBody IssueItemVo issueItemVoIn) {
		IssueItemVo issueItemVo = boObj.updateIssue(issueItemVoIn);
		return issueItemVo;
	}

	@RequestMapping(value = "/api/v1/addToken", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoginToken addToken(@RequestBody LoginToken loginToken) {
		LoginToken loginTokenObj = boObj.addToken(loginToken);
		return loginTokenObj;
	}

	@RequestMapping(value = "/api/v1/{tokenId}/getToken", method = RequestMethod.GET)
	public LoginToken getToken(@PathVariable String tokenId) {
		LoginToken loginTokenObj = null;
		loginTokenObj = boObj.getToken(tokenId);

		return loginTokenObj;

	}

	@RequestMapping(value = "/api/v1/getAllIndentSupplier", method = RequestMethod.GET)
	public List<Supplier> getAllSupplier() {

		List<Supplier> list = new ArrayList<Supplier>();
		list = boObj.getAllIndentSupplier();
		return list.stream().sorted(Comparator.comparing(Supplier::getName)).collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{indentType}/getAllIndentSupplierByIndentType", method = RequestMethod.GET)
	public List<Supplier> getAllIndentSupplierByIndentType(@PathVariable String indentType) {

		List<Supplier> list = new ArrayList<Supplier>();
		list = boObj.getAllIndentSupplierByIndentType(indentType);
		return list.stream().sorted(Comparator.comparing(Supplier::getName)).collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{status}/getAllApprovedIndentIdsForJute", method = RequestMethod.GET)
	public List<String> getAllApprovedIndentIdsForJute(@PathVariable String status) {
		List<String> listObj = null;
		if (null != status) {
			listObj = boObj.getAllApprovedIndentIdsForJute(status);

		}
		return listObj;
	}

	@RequestMapping(value = "/api/v1/{supplierType}/getSupplierForJuteByType", method = RequestMethod.GET)
	public List<Supplier> getSupplierForJuteByType(@PathVariable String supplierType) {

		List<Supplier> list = new ArrayList<Supplier>();
		list = boObj.getSupplierForJuteByType(supplierType);
		return list.stream().sorted(Comparator.comparing(Supplier::getName)).collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{indentId}/getIndentDetailsForJuteByIndentId", method = RequestMethod.GET)
	public IndentDetails getIndentDetailsForJuteByIndentId(@PathVariable String indentId) {
		IndentDetails indentDetailsObj = null;
		indentDetailsObj = boObj.getIndentDetailsForJuteByIndentId(indentId);
		return indentDetailsObj;

	}

	@RequestMapping(value = "/api/v1/{type}/getAllSupplierResponseIndentIdsByPOType", method = RequestMethod.GET)
	public List<String> getAllSupplierResponseIndentIdsByPOType(@PathVariable String type) {
		List<String> listObj = null;
		if (null != type) {
			listObj = boObj.getAllSupplierResponseIndentIdsByPOType(type);

		}
		return listObj;
	}

	@RequestMapping(value = "/api/v1/{indentId}/getSupplierResponseIndentDetailsByIndentId", method = RequestMethod.GET)
	public SupplierIndentVoMaster getSupplierResponseIndentDetailsByIndentId(@PathVariable String indentId) {
		SupplierIndentVoMaster indentDetailsObj = null;
		indentDetailsObj = boObj.getSupplierResponseIndentDetailsByIndentId(indentId);
		return indentDetailsObj;

	}

	@RequestMapping(value = "/api/v1/{ids}/getAllSupplierIndentDetailsByIds", method = RequestMethod.GET)
	public List<SupplierIndentVo> getAllSupplierIndentDetailsByIds(@PathVariable String ids) {
		List<SupplierIndentVo> listObj = null;
		if (null != ids) {
			String[] params = ids.split("\\^");
			if (params.length > 1) {
				listObj = boObj.getAllSupplierResponseIndentDetailsByIds(params[0], params[1]);
			}
		}
		return listObj;
	}

	@RequestMapping(value = "/api/v1/{ids}/getSelectedSupplierIndentDetailsByIds", method = RequestMethod.GET)
	public List<SupplierIndentVo> getSelectedSupplierIndentDetailsByIds(@PathVariable String ids) {
		List<SupplierIndentVo> listObj = null;
		if (null != ids) {
			String[] params = ids.split("\\^");
			if (params.length > 1) {
				listObj = boObj.getSelectedSupplierResponseIndentDetailsByIds(params[0], params[1]);
			}
		}
		return listObj;
	}

	@RequestMapping(value = "/api/v1/{indentId}/getAllSupplierForIndent", method = RequestMethod.GET)
	public List<Supplier> getAllSupplierForIndent(@PathVariable String indentId) {

		List<Supplier> list = null;
		list = boObj.getAllSupplierForIndent(indentId);
		return list.stream().sorted(Comparator.comparing(Supplier::getName)).collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/getAllMaterialGoodReceiveDetails", method = RequestMethod.GET)
	public List<MaterialGoodReceiveDetails> getAllMaterialGoodReceiveDetails() {

		List<MaterialGoodReceiveDetails> list = new ArrayList<MaterialGoodReceiveDetails>();
		list = boObj.getAllMaterialGoodReceiveDetails();
		return list;

	}

	@RequestMapping(value = "/api/v1/{status}/getAllMaterialGoodReceiveDetailsByStatus", method = RequestMethod.GET)
	public List<MaterialGoodReceiveDetails> getAllMaterialGoodReceiveDetailsByStatus(@PathVariable String status) {

		List<MaterialGoodReceiveDetails> list = new ArrayList<MaterialGoodReceiveDetails>();
		list = boObj.getAllMaterialGoodReceiveDetailsByStatus(status);
		return list;

	}

	@RequestMapping(value = "/api/v1/{supplierId}/getAllMaterialGoodReceiveDetailsBySupplierId", method = RequestMethod.GET)
	public List<MaterialGoodReceiveDetails> getAllMaterialGoodReceiveDetailsBySupplierId(
			@PathVariable String supplierId) {

		List<MaterialGoodReceiveDetails> list = new ArrayList<MaterialGoodReceiveDetails>();
		list = boObj.getAllMaterialGoodReceiveDetailsBySupplierId(supplierId);
		return list;

	}

	@RequestMapping(value = "/api/v1/{warehouseNo}/getAllMaterialGoodReceiveDetailsByWarehouseNo", method = RequestMethod.GET)
	public List<MaterialGoodReceiveDetails> getAllMaterialGoodReceiveDetailsByWarehouseNo(
			@PathVariable String warehouseNo) {

		List<MaterialGoodReceiveDetails> list = new ArrayList<MaterialGoodReceiveDetails>();
		list = boObj.getAllMaterialGoodReceiveDetailsByWarehouseNo(warehouseNo);
		return list;

	}

	@RequestMapping(value = "/api/v1/{chalanNo}/getAllMaterialGoodReceiveDetailsByChalan", method = RequestMethod.GET)
	public MaterialGoodReceiveDetails getAllMaterialGoodReceiveDetailsByChalan(@PathVariable long chalanNo) {

		MaterialGoodReceiveDetails obj = null;
		obj = boObj.getAllMaterialGoodReceiveDetailsByChalan(chalanNo);
		return obj;

	}

	@RequestMapping(value = "/api/v1/{id}/getAllMaterialGoodReceiveDetailsById", method = RequestMethod.GET)
	public MaterialGoodReceiveDetails getAllMaterialGoodReceiveDetailsById(@PathVariable long id) {

		MaterialGoodReceiveDetails obj = null;
		obj = boObj.getAllMaterialGoodReceiveDetailsById(id);
		return obj;

	}

	@RequestMapping(value = "/api/v1/{poId}/getAllMaterialGoodReceiveDetailsByPoID", method = RequestMethod.GET)
	public MaterialGoodReceiveDetails getAllMaterialGoodReceiveDetailsByPoID(@PathVariable String poId) {

		MaterialGoodReceiveDetails obj = null;
		obj = boObj.getAllMaterialGoodReceiveDetailsByPoID(poId);
		return obj;

	}

	@RequestMapping(value = "/api/v1/addMaterialGoodReceiveDetails", method = RequestMethod.POST)
	public MaterialGoodReceiveDetails addMaterialGoodReceiveDetails(
			@RequestBody MaterialGoodReceiveDetails materialGoodReceiveDetails) {

		MaterialGoodReceiveDetails obj = null;
		System.out.println("1.@@@@@@@@@@@@@@@@@ " + materialGoodReceiveDetails.getMaterialGoodReceiveHeader().getId());
		obj = boObj.addMaterialGoodReceiveDetails(materialGoodReceiveDetails);
		return obj;

	}

	@RequestMapping(value = "/api/v1/updateMaterialGoodReceiveDetails", method = RequestMethod.POST)
	public MaterialGoodReceiveDetails updateMaterialGoodReceiveDetails(
			@RequestBody MaterialGoodReceiveDetails materialGoodReceiveDetails) {

		MaterialGoodReceiveDetails obj = null;
		// obj=boObj.addMaterialGoodReceiveDetails(materialGoodReceiveDetails);
		obj = boObj.updateMaterialGoodReceiveDetails(materialGoodReceiveDetails);
		return obj;

	}

	@RequestMapping(value = "/api/v1/getAllStoreGoodReceiveDetails", method = RequestMethod.GET)
	public List<StoreGoodReceiveDetails> getAllStoreGoodReceiveDetails() {

		List<StoreGoodReceiveDetails> list = new ArrayList<StoreGoodReceiveDetails>();
		list = boObj.getAllStoreGoodReceiveDetails();
		return list;

	}

	@RequestMapping(value = "/api/v1/{status}/getAllStoreGoodReceiveDetailsByStatus", method = RequestMethod.GET)
	public List<StoreGoodReceiveDetails> getAllStoreGoodReceiveDetailsByStatus(@PathVariable String status) {

		List<StoreGoodReceiveDetails> list = new ArrayList<StoreGoodReceiveDetails>();
		list = boObj.getAllStoreGoodReceiveDetailsByStatus(status);
		return list;

	}

	@RequestMapping(value = "/api/v1/{supplierId}/getAllStoreGoodReceiveDetailsBySupplierId", method = RequestMethod.GET)
	public List<StoreGoodReceiveDetails> getAllStoreGoodReceiveDetailsBySupplierId(@PathVariable String supplierId) {

		List<StoreGoodReceiveDetails> list = new ArrayList<StoreGoodReceiveDetails>();
		list = boObj.getAllStoreGoodReceiveDetailsBySupplierId(supplierId);
		return list;

	}

	@RequestMapping(value = "/api/v1/{storeNo}/getAllStoreGoodReceiveDetailsByStoreNo", method = RequestMethod.GET)
	public List<StoreGoodReceiveDetails> getAllStoreGoodReceiveDetailsByStoreNo(@PathVariable String storeNo) {

		List<StoreGoodReceiveDetails> list = new ArrayList<StoreGoodReceiveDetails>();
		list = boObj.getAllStoreGoodReceiveDetailsByStoreNo(storeNo);
		return list;

	}

	@RequestMapping(value = "/api/v1/getAllStoreGoodReceiveDetailsByChalan/{chalanNo}/{supplierId}/{poId}", method = RequestMethod.GET)
	public StoreGoodReceiveDetails getAllStoreGoodReceiveDetailsByChalan(@PathVariable long chalanNo,
			@PathVariable String supplierId, @PathVariable String poId) {

		StoreGoodReceiveDetails obj = null;
		obj = boObj.getAllStoreGoodReceiveDetailsByChalan(chalanNo, supplierId, poId);
		return obj;

	}

	@RequestMapping(value = "/api/v1/{id}/getAllStoreGoodReceiveDetailsById", method = RequestMethod.GET)
	public StoreGoodReceiveDetails getAllStoreGoodReceiveDetailsById(@PathVariable long id) {

		StoreGoodReceiveDetails obj = null;
		obj = boObj.getAllStoreGoodReceiveDetailsById(id);
		return obj;

	}

	@RequestMapping(value = "/api/v1/{poId}/getAllStoreGoodReceiveDetailsByPoID", method = RequestMethod.GET)
	public StoreGoodReceiveDetails getAllStoreGoodReceiveDetailsByPoID(@PathVariable String poId) {

		StoreGoodReceiveDetails obj = null;
		obj = boObj.getAllStoreGoodReceiveDetailsByPoID(poId);
		return obj;

	}

	@RequestMapping(value = "/api/v1/addStoreGoodReceiveDetails", method = RequestMethod.POST)
	public StoreGoodReceiveDetails addStoreGoodReceiveDetails(
			@RequestBody StoreGoodReceiveDetails materialGoodReceiveDetails) {

		StoreGoodReceiveDetails obj = null;
		obj = boObj.addStoreGoodReceiveDetails(materialGoodReceiveDetails);
		return obj;

	}

	@RequestMapping(value = "/api/v1/updateStoreGoodReceiveDetails", method = RequestMethod.POST)
	public StoreGoodReceiveDetails updateStoreGoodReceiveDetails(
			@RequestBody StoreGoodReceiveDetails materialGoodReceiveDetails) {

		StoreGoodReceiveDetails obj = null;
		obj = boObj.addStoreGoodReceiveDetails(materialGoodReceiveDetails);
		return obj;

	}

	@RequestMapping(value = "/api/v1/{chalanNo}/getMaterialPODetailsByChalan", method = RequestMethod.GET)
	public POChalanDetails getMaterialPODetailsByChalan(@PathVariable long chalanNo) {

		POChalanDetails obj = null;
		obj = boObj.getMaterialPODetailsByChalan(chalanNo);
		return obj;

	}

	@RequestMapping(value = "/api/v1/{ids}/getMaterialPODetailsByChalanAndSupplier", method = RequestMethod.GET)
	public POChalanDetails getMaterialPODetailsByChalan(@PathVariable String ids) {

		POChalanDetails obj = null;
		if (null != ids) {
			String[] input = ids.split("\\^");
			if (input.length > 1) {
				obj = boObj.getMaterialPODetailsByChalanAndSupplier(Long.parseLong(input[0]), input[1]);
			}
		}
		return obj;

	}

	@RequestMapping(value = "/api/v1/{chalanNo}/getStorePODetailsByChalan", method = RequestMethod.GET)
	public POChalanDetails getStorePODetailsByChalan(@PathVariable long chalanNo) {

		POChalanDetails obj = null;
		obj = boObj.getStorePODetailsByChalan(chalanNo);
		return obj;

	}

	@RequestMapping(value = "/api/v1/{ids}/getStorePODetailsByChalanAndSupplier", method = RequestMethod.GET)
	public POChalanDetails getStorePODetailsByChalanAndSupplier(@PathVariable String ids) {

		POChalanDetails obj = null;
		if (null != ids) {
			String[] input = ids.split("\\^");
			if (input.length > 1) {
				obj = boObj.getStorePODetailsByChalanAndSupplierAndPONo(Long.parseLong(input[0]), input[1], input[2]);
			}
		}
		return obj;

	}

	@RequestMapping(value = "/api/v1/getAllDebitCreditNotes", method = RequestMethod.GET)
	public List<DebitCreditNotesVo> getAllDebitCreditNotes() {
		List<DebitCreditNotesVo> list = null;
		list = boObj.getAllDebitCreditNotes();
		return list;

	}

	@RequestMapping(value = "/api/v1/{supplierCode}/getAllDebitCreditNotesBySupplierCode", method = RequestMethod.GET)
	public List<DebitCreditNotesVo> getAllDebitCreditNotesBySupplierCode(@PathVariable String supplierCode) {
		List<DebitCreditNotesVo> list = null;
		list = boObj.getAllDebitCreditNotesBySupplierCode(supplierCode);
		return list;

	}

	@RequestMapping(value = "/api/v1/{grnNo}/getAllDebitCreditNotesByGrnNo", method = RequestMethod.GET)
	public List<DebitCreditNotesVo> getAllDebitCreditNotesByGrnNo(@PathVariable long grnNo) {
		List<DebitCreditNotesVo> list = null;
		list = boObj.getAllDebitCreditNotesByGrnNo(grnNo);
		return list;

	}

	@RequestMapping(value = "/api/v1/{id}/getDebitCreditNotesById", method = RequestMethod.GET)
	public DebitCreditNotesVo getDebitCreditNotesById(@PathVariable long id) {
		DebitCreditNotesVo obj = null;
		obj = boObj.getDebitCreditNotesById(id);
		return obj;
	}

	@RequestMapping(value = "/api/v1/addUpdateDebitCreditNotes", method = RequestMethod.POST)
	public DebitCreditNotesVo addUpdateDebitCreditNotes(@RequestBody DebitCreditNotesVo debitCreditNotesVo) {
		DebitCreditNotesVo obj = null;
		obj = boObj.addDebitCreditNotes(debitCreditNotesVo);
		return obj;

	}

	@RequestMapping(value = "/api/v1/getAllBillPass", method = RequestMethod.GET)
	public List<BillPassDTO> getAllBillPass() {
		List<BillPassDTO> list = null;
		list = boObj.getAllBillPass();
		return list;

	}

	@RequestMapping(value = "/api/v1/{supplierCode}/getAllBillPassBySupplierCode", method = RequestMethod.GET)
	public List<BillPass> getAllBillPassBySupplierCode(@PathVariable String supplierCode) {
		List<BillPass> list = null;
		list = boObj.getAllBillPassBySupplierCode(supplierCode);
		return list;

	}

	@RequestMapping(value = "/api/v1/{grnNo}/getAllBillPassByGrnNo", method = RequestMethod.GET)
	public List<BillPass> getAllBillPassByGrnNo(@PathVariable long grnNo) {
		List<BillPass> list = null;
		list = boObj.getAllBillPassByGrnNo(grnNo);
		return list;

	}

	@RequestMapping(value = "/api/v1/{billNo}/getAllBillPassByBillNo", method = RequestMethod.GET)
	public List<BillPass> getAllBillPassByBillNo(@PathVariable String billNo) {
		List<BillPass> list = null;
		list = boObj.getAllBillPassByBillNo(billNo);
		return list;

	}

	@RequestMapping(value = "/api/v1/{id}/getBillPassById", method = RequestMethod.GET)
	public BillPassDTO getBillPassById(@PathVariable long id) {
		BillPassDTO obj = null;
		obj = boObj.getBillPassById(id);
		return obj;

	}

	@RequestMapping(value = "/api/v1/{poId}/getAllBillPassByPoId", method = RequestMethod.GET)
	public List<BillPass> getAllBillPassByPoId(@PathVariable String poId) {
		List<BillPass> list = null;
		list = boObj.getAllBillPassByPoId(poId);
		return list;

	}

	@RequestMapping(value = "/api/v1/addUpdateBillPass", method = RequestMethod.POST)
	public BillPassDTO addBillPass(@RequestBody BillPassDTO billPass) {
		BillPassDTO obj = null;
		obj = boObj.addBillPass(billPass);
		return billPass;

	}

	@RequestMapping(value = "/api/v1/getAllVehicle", method = RequestMethod.GET)
	public List<Vehicle> getAllVehicle() {
		List<Vehicle> list = null;
		list = boObj.getAllVehicle();
		return list;

	}

	@RequestMapping(value = "/api/v1/{id}/getVehicleById", method = RequestMethod.GET)
	public Vehicle getVehicleById(@PathVariable long id) {
		Vehicle obj = null;
		obj = boObj.getVehicleById(id);
		return obj;

	}

	@RequestMapping(value = "/api/v1/getAllMukam", method = RequestMethod.GET)
	public List<Mukam> getAllMukam() {
		List<Mukam> list = null;
		list = boObj.getAllMukam();
		return list.stream().sorted(Comparator.comparing(Mukam::getMukamName)).collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{supplierCode}/getAllMukamBySupplier", method = RequestMethod.GET)
	public List<Mukam> getAllMukamBySupplier(@PathVariable String supplierCode) {
		List<Mukam> list = null;
		list = boObj.getAllMukamBySupplier(supplierCode);
		return list.stream().sorted(Comparator.comparing(Mukam::getMukamName)).collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{id}/getMukamById", method = RequestMethod.GET)
	public Mukam getAllMukamBySupplier(@PathVariable long id) {
		Mukam obj = null;
		obj = boObj.getMukamById(id);
		return obj;

	}

	@RequestMapping(value = "/api/v1/{ids}/getAllPOByMukamAndSupplierId", method = RequestMethod.GET)
	public List<POHeader> getAllPOByMukamAndSupplierId(@PathVariable String ids) {
		List<POHeader> listObj = null;
		if (null != ids) {
			String[] input = ids.split("\\^");
			if (input.length > 1) {
				listObj = boObj.getAllPOByMukamAndSupplierId(input[0], input[1]);
			}
		}
		return listObj.stream().sorted(Comparator.comparing(POHeader::getCreateDate).reversed())
				.collect(Collectors.toList());
	}

	@RequestMapping(value = "/api/v1/{ids}/getCounterByTypeAndId", method = RequestMethod.GET)
	public ReportCounter getCounterByTypeAndId(@PathVariable String ids) {
		ReportCounter obj = null;
		if (null != ids) {
			String[] input = ids.split("\\^");
			if (input.length > 1) {
				obj = boObj.getCounterByTypeAndId(input[0], input[1]);
			}
		}
		return obj;
	}

	@RequestMapping(value = "/api/v1/addUpdateCounter", method = RequestMethod.POST)
	public ReportCounter addUpdateCounter(@RequestBody ReportCounter reportCounterObj) {
		ReportCounter obj = null;
		obj = boObj.addUpdateCounter(reportCounterObj);
		return obj;

	}

	@RequestMapping(value = "/api/v1/getMaterialReceiveNoByChalanNo/{chalanNo}/{suppCode}/{poNo}", method = RequestMethod.GET)
	public List<JuteEntryHeaderDTO> getMaterialReceiveNoByChalanNo(@PathVariable long chalanNo,
			@PathVariable String suppCode, @PathVariable String poNo) {
		List<JuteEntryHeaderDTO> list = null;
		list = boObj.getMaterialReceiveNoByChalanNo(chalanNo, suppCode, poNo);
		return list;
	}

	@RequestMapping(value = "/api/v1/getStoreReceiveNoByChalanNo/{chalanNo}/{suppCode}/{poNo}", method = RequestMethod.GET)
	public List<StoreGRNEntryDTO> getStoreReceiveNoByChalanNo(@PathVariable long chalanNo,
			@PathVariable String suppCode, @PathVariable String poNo) {
		List<StoreGRNEntryDTO> list = null;
		list = boObj.getStoreReceiveNoByChalanNo(chalanNo, suppCode, poNo);
		return list;
	}

	@RequestMapping(value = "/api/v1/{ids}/getMaterialQualityByPoNoAndPoLineItemId", method = RequestMethod.GET)
	public List<JuteQualityEntryHeader> getMaterialQualityByPoNoAndPoLineItemId(@PathVariable String ids) {
		List<JuteQualityEntryHeader> list = null;
		if (null != ids) {
			String[] input = ids.split("\\^");
			if (input.length > 1) {
				list = boObj.getMaterialQualityByPoNoAndPoLineItemId(input[0], Long.parseLong(input[1]));
			}
		}
		return list;
	}

	@RequestMapping(value = "/api/v1/addUpdateMaterialQuality", method = RequestMethod.POST)
	public List<JuteQualityEntryHeader> addUpdateMaterialQuality(@RequestBody List<JuteQualityEntryHeader> list) {
		List<JuteQualityEntryHeader> resultList = null;
		resultList = boObj.addUpdateMaterialQuality(list);
		return resultList.stream().sorted(Comparator.comparing(JuteQualityEntryHeader::getCreateDate).reversed())
				.collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{id}/getSupplierListByBrokerId", method = RequestMethod.GET)
	public List<Supplier> getSupplierListByBrokerId(@PathVariable long id) {
		List<Supplier> list = new ArrayList<Supplier>();
		list = boObj.getSupplierListByBrokerId(id);
		return list.stream().sorted(Comparator.comparing(Supplier::getName)).collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{id}/getBrokerListBySupplierCode", method = RequestMethod.GET)
	public List<Broker> getBrokerListBySupplierCode(@PathVariable String id) {
		List<Broker> list = new ArrayList<Broker>();
		list = boObj.getBrokerListBySupplierCode(id);
		return list;

	}

	@RequestMapping(value = "/api/v1/{id}/getBrokerDetailsById", method = RequestMethod.GET)
	public Broker getBrokerDetailsById(@PathVariable long id) {
		Broker obj = null;
		obj = boObj.getBrokerDetailsById(id);
		return obj;

	}

	@RequestMapping(value = "/api/v1/{supplierCode}/getStoreChalanListBySupplier", method = RequestMethod.GET)
	public List<StoreGRNEntry> getStoreChalanListBySupplier(@PathVariable String supplierCode) {

		List<StoreGRNEntry> obj = null;
		if (null != supplierCode) {
			obj = boObj.getStoreChalanListBySupplier(supplierCode);
		}
		return obj;

	}

	@RequestMapping(value = "/api/v1/{supplierCode}/getMaterialGoodReceiveChalanListBySupplier", method = RequestMethod.GET)
	public List<JuteGRNEntry> getMaterialGoodReceiveChalanListBySupplier(@PathVariable String supplierCode) {

		List<JuteGRNEntry> obj = null;
		if (null != supplierCode) {
			obj = boObj.getMaterialGoodReceiveChalanListBySupplier(supplierCode);
		}
		return obj;

	}

	@RequestMapping(value = "/api/v1/getAllServiceBatchType", method = RequestMethod.GET)
	public List<ServiceBatchType> getAllServiceBatchType() {

		List<ServiceBatchType> obj = null;
		obj = boObj.getAllServiceBatchType();
		return obj;

	}

	@GetMapping("/api/v1/getAllPOBySuppCodeAndChalanNo/{suppCode}/{chalanNo}")
	public List<POHeader> getAllPOBySuppCodeAndChalanNo(@PathVariable("suppCode") String suppCode,
			@PathVariable("chalanNo") Long chalanNo) {
		return boObj.getAllPOBySuppCodeAndChalanNo(suppCode, chalanNo).stream()
				.sorted(Comparator.comparing(POHeader::getCreateDate).reversed()).collect(Collectors.toList());
	}

	@GetMapping("/api/v1/getChalanListBySupplierStore/{supplierCode}")
	public List<ChalanDTO> getStoreChalanListBySupplierDistinct(@PathVariable String supplierCode) {
		return boObj.getStoreChalanListBySupplierDistinct(supplierCode);
	}
	
	@GetMapping("/api/v1/getTotalValueFromStoreGoodReceiveBySrNoAndType/{srNo}/{srType}")
	public TotalValueDTO getTotalValueFromStoreGoodReceiveBySrNoAndType(@PathVariable Long srNo,
			@PathVariable String srType) {
		return boObj.getTotalValueFromStoreGoodReceiveBySrNoAndType(srNo,srType);
	}

}
