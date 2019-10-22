package com.sls.po.bo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sls.po.dao.IssueHeaderRepository;
import com.sls.po.dao.IssueLineItemRepository;
import com.sls.po.dao.ItemGroupDepartmentRepository;
import com.sls.po.dao.ItemGroupRepository;
import com.sls.po.dao.ItemMaterialStockRepository;
import com.sls.po.dao.ItemRepository;
import com.sls.po.dao.ItemStockRepository;
import com.sls.po.dao.ItemTaxRepository;
import com.sls.po.dao.MukamJuteRepository;
import com.sls.po.dao.QuantityUnitRepository;
import com.sls.po.model.IssueHeader;
import com.sls.po.model.IssueLineItem;
import com.sls.po.model.Item;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.ItemGroupDepartmentMap;
import com.sls.po.model.ItemMaterialStock;
import com.sls.po.model.ItemStock;
import com.sls.po.model.ItemTax;
import com.sls.po.model.Items;
import com.sls.po.model.MukamJute;
import com.sls.po.model.QuantityUnit;
import com.sls.po.vo.ItemDTO;

@Component
@Qualifier("itemBoObj")
public class ItemBoImpl implements ItemBo {

	@Autowired
	DataSource dataSource;

	@Autowired
	ItemGroupRepository itemGroupRepository;
	@Autowired
	ItemRepository itemRepository;

	@Autowired
	ItemTaxRepository itemTaxRepository;

	@Autowired
	ItemStockRepository itemStockRepository;

	@Autowired
	ItemMaterialStockRepository itemMaterialStockRepository;

	@Autowired
	QuantityUnitRepository quantityUnitRepository;

	@Autowired
	MukamJuteRepository mukamJuteRepository;

	@Autowired
	ItemGroupDepartmentRepository itemGroupDepartmentRepository;
	
	@Autowired
	IssueLineItemRepository issueItemtRepository;
	
	@Autowired
	IssueHeaderRepository issuehdrRepository;

	@Override
	public Items getAllItemBygroupId(String groupId) {
		Items itemsobj = new Items();
		ItemGroup itemGroupObj = itemGroupRepository.findOne(groupId);
		List<ItemDTO> itemList = new ArrayList<ItemDTO>();
		List<Item> resultList = itemRepository.findByGroupId(String.valueOf(groupId));
		ItemTax itemTaxObj = null;
		ItemStock itemStockObj = null;
		long stockCount = 0;
		
		long starttime = Calendar.getInstance().getTimeInMillis();
		Date startdate = Date.valueOf(LocalDate.now());
		Date enddate = Date.valueOf(LocalDate.now().minusMonths(12));
		
		List<IssueHeader> issuehdrs = 
				issuehdrRepository.findByModOnRange(startdate,enddate);
		List<IssueLineItem> issuelines = new ArrayList<>();
		int linesize = issuehdrs.size();
		for(int i = 0 ; i < linesize ; i++) {
			issuelines = 
					issueItemtRepository.findByIssueHeaderId(issuehdrs.get(i).getId());
		}
		if (null != resultList) {
			for (Item itemobj : resultList) {
				if (itemobj.getId() != null) {
					List<ItemStock> liststock = itemStockRepository.findByItemId(itemobj.getId());
					if (null != liststock && liststock.size() > 0) {
						for (ItemStock obj : liststock) {
							if (obj.getStock() != null) {
								stockCount = stockCount + Long.parseLong(obj.getStock());
							}

						}
						itemStockObj = liststock.get(0);
						// itemobj.setItemStock(itemStockObj);
						itemobj.setStock(String.valueOf(stockCount));
					}

				}
				/*if (itemobj.getHsnCode() != null) {
					List<ItemTax> listTax = itemTaxRepository.findByHsnCode(itemobj.getHsnCode());
					if (null != listTax && listTax.size() > 0) {
						itemTaxObj = listTax.get(0);
						itemobj.setItemTax(itemTaxObj);
					}

				}

				if (itemobj.getUomCode() != null && itemobj.getUomCode().length() > 0) {
					QuantityUnit quantityUnit = quantityUnitRepository.findOne(itemobj.getUomCode());
					itemobj.setQuantityUnit(quantityUnit);
				}*/

				itemList.add(prepareItemDTO(itemobj, issuelines));

			}
		}
		long endtime = Calendar.getInstance().getTimeInMillis();
		System.out.println(endtime-starttime);
		
		itemsobj.setItem_Group(itemGroupObj);
		List<ItemDTO> items = itemList
				.stream()
				.sorted(Comparator.comparing(ItemDTO::getName))
				.collect(Collectors.toList());
		itemsobj.setItems(items);
		return itemsobj;
	}

	private ItemDTO prepareItemDTO(Item item, List<IssueLineItem> issuehdrs) {
		ItemDTO dto = new ItemDTO();
		ItemTax itemtax = itemTaxRepository.findByHsnCode(item.getHsnCode()).get(0);
		QuantityUnit quantity = quantityUnitRepository.findOne(item.getUomCode());
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

		float avgConsumption = 0.0f;
		float totalconsumpsion = 0.0f;
		
		List<IssueLineItem> issuelines = 
				issueItemtRepository.findByItemId( item.getId());
		
		int size = issuelines.size();
		for(int j = 0 ; j < size ; j++) {
			totalconsumpsion = totalconsumpsion + issuelines.get(j).getIssueQuantity();
		}
		avgConsumption = totalconsumpsion/12;
		
		dto.setAvgConsumption(avgConsumption);
		
		dto.setQuantityUnit(quantity);
		dto.setItemTax(itemtax);
		dto.setItemStock(item.getItemStock());
		return dto;
	}

	private Item prepareItemEntity(ItemDTO item) {
		Item dto = new Item();
		Item item1 = itemRepository.findByName(item.getName());
		ItemTax itemtax = itemTaxRepository.findByItemInTax(item1);
		QuantityUnit quantity = quantityUnitRepository.findOne(item.getUomCode());
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
	public Item getItemById(String itemId) {
		Item itemobj = null;
		ItemTax itemTaxObj = null;
		ItemStock itemStockObj = null;

		itemobj = itemRepository.findOne(itemId);
		if (itemobj.getId() != null) {
			List<ItemStock> liststock = itemStockRepository.findByItemId(itemobj.getId());
			if (null != liststock && liststock.size() > 0) {
				itemStockObj = liststock.get(0);
				// itemobj.setItemStock(itemStockObj);
				itemobj.setStock(itemStockObj.getStock());
			}

		}
		if (itemobj.getHsnCode() != null) {
			List<ItemTax> listTax = itemTaxRepository.findByHsnCode(itemobj.getHsnCode());
			if (null != listTax && listTax.size() > 0) {
				itemTaxObj = listTax.get(0);
				itemobj.setItemTax(itemTaxObj);
			}

		}
		if (itemobj.getUomCode() != null && itemobj.getUomCode().length() > 0) {
			QuantityUnit quantityUnit = quantityUnitRepository.findOne(itemobj.getUomCode());
			itemobj.setQuantityUnit(quantityUnit);
		}

		return itemobj;
	}

	public ItemMaterialStock getStockByItemIdAndQualityCode(String itemId, String qualityCode) {

		List<ItemMaterialStock> list = null;
		ItemMaterialStock itemStockObj = null;
		list = itemMaterialStockRepository.findByItemIdAndQualityCode(itemId, qualityCode);
		if (null != list && list.size() > 0) {

			itemStockObj = list.get(0);
		}

		return itemStockObj;

	}

	@Override
	public Items getAllItemByMukam(long mukamId) {
		Items itemsobj = new Items();
		Item obj = null;
		List<ItemDTO> itemList = new ArrayList<ItemDTO>();
		List<Item> resultList = new ArrayList<Item>();
		;// itemRepository.findByGroupId(String.valueOf(groupId));
		ItemTax itemTaxObj = null;
		ItemStock itemStockObj = null;

		for (MukamJute mukamJuteObj : mukamJuteRepository.findByMukamId(mukamId)) {
			obj = itemRepository.findOne(mukamJuteObj.getItemJuteCode());
			resultList.add(obj);
		}
		ItemGroup itemGroupObj = itemGroupRepository.findOne(obj.getGroupId());

		long starttime = Calendar.getInstance().getTimeInMillis();
		Date startdate = Date.valueOf(LocalDate.now());
		Date enddate = Date.valueOf(LocalDate.now().minusMonths(12));
		
		List<IssueHeader> issuehdrs = 
				issuehdrRepository.findByModOnRange(startdate,enddate);
		List<IssueLineItem> issuelines = new ArrayList<>();
		for(int i = 0 ; i < issuehdrs.size() ; i++) {
			issuelines = 
					issueItemtRepository.findByIssueHeaderId(issuehdrs.get(i).getId());
		}
		
		if (null != resultList) {
			
			for (Item itemobj : resultList) {
				if (itemobj.getId() != null) {
					List<ItemStock> liststock = itemStockRepository.findByItemId(itemobj.getId());
					if (null != liststock && liststock.size() > 0) {
						itemStockObj = liststock.get(0);
						// itemobj.setItemStock(itemStockObj);
						itemobj.setStock(itemStockObj.getStock());
					}

				}
				if (itemobj.getHsnCode() != null) {
					List<ItemTax> listTax = itemTaxRepository.findByHsnCode(itemobj.getHsnCode());
					if (null != listTax && listTax.size() > 0) {
						itemTaxObj = listTax.get(0);
						itemobj.setItemTax(itemTaxObj);
					}

				}

				if (itemobj.getUomCode() != null && itemobj.getUomCode().length() > 0) {
					QuantityUnit quantityUnit = quantityUnitRepository.findOne(itemobj.getUomCode());
					itemobj.setQuantityUnit(quantityUnit);
				}

				itemList.add(prepareItemDTO(itemobj,issuelines));
				itemList.stream().sorted(Comparator.comparing(ItemDTO::getName)).collect(Collectors.toList());
			}
		}

		itemsobj.setItem_Group(itemGroupObj);
		itemsobj.setItems(itemList.stream().sorted(Comparator.comparing(ItemDTO::getName)).collect(Collectors.toList()));
		return itemsobj;
	}

	public List<ItemGroup> getAllItemGroupsByDepartmentId(long deparmentId) {
		List<ItemGroup> resiltList = new ArrayList<ItemGroup>();
		List<ItemGroupDepartmentMap> groupDeptList = null;
		ItemGroup obj = null;
		if (deparmentId > 0) {
			groupDeptList = itemGroupDepartmentRepository.findByDeparmentId(deparmentId);
			if (null != groupDeptList && groupDeptList.size() > 0) {

				for (ItemGroupDepartmentMap grpDeptObj : groupDeptList) {
					obj = itemGroupRepository.findOne(grpDeptObj.getItemGroupCode());
					if (null != obj)
						resiltList.add(obj);

				}

			}
		}

		return resiltList.stream().sorted(Comparator.comparing(ItemGroup::getName)).collect(Collectors.toList());
	}

}
