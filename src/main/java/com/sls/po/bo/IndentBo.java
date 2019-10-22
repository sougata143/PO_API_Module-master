package com.sls.po.bo;

import java.util.List;

import com.sls.po.model.BillPass;
import com.sls.po.model.Broker;
import com.sls.po.model.GoodReceiveHeader;
import com.sls.po.model.IndentHeader;
import com.sls.po.model.Item;
import com.sls.po.model.JuteGRNEntry;
import com.sls.po.model.JuteQualityEntryHeader;
import com.sls.po.model.LoginToken;
import com.sls.po.model.MaterialGoodReceiveHeader;
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

public interface IndentBo {
	public List<IndentHeader> getAllIndent();
	public List<IndentHeader> getAllIndentByStatus(String status);
	public IndentDetails getIndentDetails(String indentId);
	public IndentDetails addIndent(IndentDetails indentDetails);
	public IndentDetails updateIndent(IndentDetails indentDetails);
	public List<SupplierIndentNotification> addSupplierIndentNotification(List<SupplierIndentNotification> supplierIndentNotificationList);
	public List<SupplierIndentVo> addSupplierResponseIndentDetails (List<SupplierIndentVo>  supplierIndentVoList);
	public List<SupplierIndentVo> getSupplierResponseIndentDetailsBySupplierCode (String supplierCode) ;
	public TotalValueDTO getTotalValueFromStoreGoodReceiveBySrNoAndType(Long srNo, String srType);
	
	
	public List<POHeader> getAllPO();
	public List<POHeader> getAllPOByStatus(String status);
	public List<POHeader> getAllPOByMukamAndSupplierId(String mukam, String supplierId);
	public List<POHeader> getAllPOBySuppCodeAndChalanNo(String suppCode, Long chalanNo);
	public PODetails addPODetails(PODetails poDetails);
	public PODetails updatePODetails(PODetails poDetails);
	public PODetails getPODetails(String poId);
	
	public List<GoodReceiveHeader> getAllGoodReceiveHeader();
	public List<GoodReceiveHeader> getAllGoodReceiveHeaderByStatus(String status);
	
	public GoodReceiveDetails addGoodReceiveDetails(GoodReceiveDetails goodReceiveDetails);
	public GoodReceiveDetails updateGoodReceiveDetails(GoodReceiveDetails goodReceiveDetails);
	public GoodReceiveDetails getGoodReceiveDetails(long grnId);
	
	public List<IssueDetails> getAllIssue();
	public List<IssueDetails> getAllLoans();
	public List<IssueDetails> getAllIssueByDeparttmentId(long departmentId);
	public List<IssueDetails> getAllLoansByUnitId(String unitId);
	public IssueDetails addLoanIssue(IssueDetails issueDetails);
	public IssueItemVo updateIssue(IssueItemVo issueItemVo);
	
	
	
	
	
	public LoginToken addToken(LoginToken loginToken);
	public LoginToken getToken(String tokenId);
	
	
	List<Item> getAllItemsBySupplierCode(String supplierCode);
	public List<String> getAllSupplierResponseIndentBySupplierCodeItemCode (String supplierCode, String itemCode) ;
	public List<SupplierIndentVo> getSupplierResponseIndentDetailsByIds (String supplierCode, String itemCode,String indentId) ;
	List<Supplier> getAllIndentSupplier();
	List<Supplier> getAllIndentSupplierByIndentType(String type);
	List<Supplier> getRequestedSupplierListByIndent(String indentId);
	
	
	
	
	List<String> getAllSupplierResponseIndentIdsByPOType(String type);
	SupplierIndentVoMaster getSupplierResponseIndentDetailsByIndentId(String indentId);
	
	public List<String> getAllApprovedIndentIdsForJute(String type) ;
	public IndentDetails getIndentDetailsForJuteByIndentId(String indentId) ;
	public List<Supplier> getSupplierForJuteByType(String type);
	public List<SupplierIndentVo> getSelectedSupplierResponseIndentDetailsByIds(String supplierCode, String indentId);
	public List<SupplierIndentVo> getAllSupplierResponseIndentDetailsByIds(String supplierCode, String indentId);
	public List<Supplier> getAllSupplierForIndent(String indentId);
	
	
	public List<MaterialGoodReceiveHeader> getAllMaterialGoodReceiveHeaderByStatus(String status);
	public MaterialGoodReceiveHeader getAllMaterialGoodReceiveHeaderByChalan(long chalanNo);
	public List<MaterialGoodReceiveHeader> getAllMaterialGoodReceiveHeaderBySupplierId(String supplierId);
	public List<MaterialGoodReceiveHeader> getAllMaterialGoodReceiveHeaderByWarehouseNo(String warehouseNo);
	public MaterialGoodReceiveHeader getAllMaterialGoodReceiveHeaderById(long id);
	public MaterialGoodReceiveHeader getAllMaterialGoodReceiveHeaderByPoID(String poId);
	
	public List<MaterialGoodReceiveDetails> getAllMaterialGoodReceiveDetailsByStatus(String status);
	public List<MaterialGoodReceiveDetails> getAllMaterialGoodReceiveDetailsBySupplierId(String supplierId);
	public List<MaterialGoodReceiveDetails> getAllMaterialGoodReceiveDetailsByWarehouseNo(String warehouseNo);
	public MaterialGoodReceiveDetails getAllMaterialGoodReceiveDetailsByChalan(long chalanNo);
	public MaterialGoodReceiveDetails getAllMaterialGoodReceiveDetailsById(long id);
	public MaterialGoodReceiveDetails getAllMaterialGoodReceiveDetailsByPoID(String poId);
	public MaterialGoodReceiveDetails addMaterialGoodReceiveDetails(MaterialGoodReceiveDetails materialGoodReceiveDetails);
	public MaterialGoodReceiveDetails updateMaterialGoodReceiveDetails(MaterialGoodReceiveDetails materialGoodReceiveDetails);
	
	public List<StoreGoodReceiveDetails> getAllStoreGoodReceiveDetailsByStatus(String status);
	public List<StoreGoodReceiveDetails> getAllStoreGoodReceiveDetailsBySupplierId(String supplierId);
	public List<StoreGoodReceiveDetails> getAllStoreGoodReceiveDetailsByStoreNo(String warehouseNo);
	public StoreGoodReceiveDetails getAllStoreGoodReceiveDetailsByChalan(long chalanNo, String supplierId, String poId);
	public StoreGoodReceiveDetails getAllStoreGoodReceiveDetailsById(long id);
	public StoreGoodReceiveDetails getAllStoreGoodReceiveDetailsByPoID(String poId);
	public StoreGoodReceiveDetails addStoreGoodReceiveDetails(StoreGoodReceiveDetails storeGoodReceiveDetails);
	POChalanDetails getMaterialPODetailsByChalan(long chalanNo);
	POChalanDetails getStorePODetailsByChalan(long chalanNo);
	POChalanDetails getMaterialPODetailsByChalanAndSupplier(long chalanNo, String supplierCode);
	POChalanDetails getStorePODetailsByChalanAndSupplierAndPONo(long chalanNo, String supplierCode, String poNo);
	
	public List<DebitCreditNotesVo> getAllDebitCreditNotes();
	List<DebitCreditNotesVo> getAllDebitCreditNotesBySupplierCode(String supplierCode);
	List<DebitCreditNotesVo> getAllDebitCreditNotesByGrnNo(long grnNo);
	DebitCreditNotesVo getDebitCreditNotesById(long id);
	DebitCreditNotesVo addDebitCreditNotes(DebitCreditNotesVo debitCreditNotesVoObj);
	
	
	List<BillPass> getAllBillPassBySupplierCode(String supplierCode);
	List<BillPass> getAllBillPassByGrnNo(long grnNo);
	List<BillPass> getAllBillPassByPoId(String poId);
	List<BillPass> getAllBillPassByBillNo(String billNo);
	BillPassDTO addBillPass(BillPassDTO inobj);
	BillPassDTO getBillPassById(long id);
	List<BillPassDTO> getAllBillPass();
	List<MaterialGoodReceiveHeader> getAllMaterialGoodReceiveHeader();
	List<StoreGoodReceiveDetails> getAllStoreGoodReceiveDetails();
	List<MaterialGoodReceiveDetails> getAllMaterialGoodReceiveDetails();
	
	List<StoreGoodReceiveItemVo> getStoreGoodReceiveItemForIssue(String storeId, String itemId,float issueQuantity);
	List<MaterialGoodReceiveItemVo> getMaterialGoodReceiveItemForIssue(String warehouseNo, String itemId,float issueQuantity);
	IssueDetails getIssueDetailsById(long id);
	public List<Mukam> getAllMukamBySupplier(String supplierCode);
	public List<Mukam> getAllMukam();
	public Mukam getMukamById(long id);
	
	public Vehicle getVehicleById(long id);
	public List<Vehicle> getAllVehicle();
	List<IndentHeader> getAllIndentByMukam(String mukam);
	
	ReportCounter getCounterByTypeAndId(String type,String id);
	ReportCounter addUpdateCounter(ReportCounter reportCounterObj);
	List<JuteEntryHeaderDTO> getMaterialReceiveNoByChalanNo(long chalanNo, String suppCode, String poNo);
	List<StoreGRNEntryDTO> getStoreReceiveNoByChalanNo(long chalanNo, String suppCode, String poNo);
	
	List<JuteQualityEntryHeader> getMaterialQualityByPoNoAndPoLineItemId(String poNo,long poLineItemId);
	List<JuteQualityEntryHeader> addUpdateMaterialQuality(List<JuteQualityEntryHeader> list);
	Broker getBrokerDetailsById(long id);
	List<Supplier> getSupplierListByBrokerId(long id);
	List<Broker> getBrokerListBySupplierCode(String id);
	List<StoreGRNEntry> getStoreChalanListBySupplier(String supplierCode);
	List<JuteGRNEntry> getMaterialGoodReceiveChalanListBySupplier(String supplierCode);
	
	List<ServiceBatchType> getAllServiceBatchType();
	ServiceBatchType geServiceBatchTypeDetailsById(long id);
	
	public List<ChalanDTO> getStoreChalanListBySupplierDistinct(String supplierCode);
	
	public List<Supplier> getAllSupplierByIndentNo(String indentId);
	public List<SupplierIndentApprovalDTO> getSupplierIndentDetailsByIndentNoAndSupplierCode(String indentNo);
	
	public List<SupplierIndentApprovalDTO> 
		saveSupplierIndentDetailsByIndentNo(List<SupplierIndentApprovalDTO> suppreponse);

}
