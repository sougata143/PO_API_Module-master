package com.sls.po.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sls.po.bo.ItemBoImpl;
import com.sls.po.dao.DepartmentRepository;
import com.sls.po.dao.IndentTypeRepository;
import com.sls.po.dao.ItemGroupRepository;
import com.sls.po.dao.ItemMaterialStockRepository;
import com.sls.po.dao.ItemRepository;
import com.sls.po.dao.ItemStockRepository;
import com.sls.po.dao.PhysicalStockRepository;
import com.sls.po.dao.QualityRepository;
import com.sls.po.dao.QuantityUnitRepository;
import com.sls.po.dao.SupplierRepository;
import com.sls.po.model.Department;
import com.sls.po.model.IndentType;
import com.sls.po.model.ItemGroup;
import com.sls.po.model.ItemMaterialStock;
import com.sls.po.model.ItemStock;
import com.sls.po.model.Items;
import com.sls.po.model.PhysicalStock;
import com.sls.po.model.Quality;
import com.sls.po.model.QuantityUnit;
import com.sls.po.model.Supplier;

@CrossOrigin(origins = "*")
@RestController
public class ItemController {

	@Autowired
	DataSource dataSource;

	@Autowired
	ItemGroupRepository itemGroupRepository;

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	QuantityUnitRepository quantityUnitRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	IndentTypeRepository indentTypeRepository;

	@Autowired
	QualityRepository qualityRepository;

	@Autowired
	SupplierRepository supplierRepository;

	@Autowired
	ItemStockRepository itemStockRepository;

	@Autowired
	ItemMaterialStockRepository itemMaterialStockRepository;

	@Autowired
	PhysicalStockRepository physicalStockRepository;

	@Autowired
	@Qualifier("itemBoObj")
	ItemBoImpl boObj;

	@RequestMapping(value = "/api/v1/getItemGroup", method = RequestMethod.GET)
	public List<ItemGroup> getAllItemGroup() {

		List<ItemGroup> list = new ArrayList<ItemGroup>();

		for (ItemGroup itemGroupIObj : itemGroupRepository.findAll()) {
			list.add(itemGroupIObj);
		}

		return list.stream().sorted(Comparator.comparing(ItemGroup::getName)).collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/getQuantityUnit", method = RequestMethod.GET)
	public List<QuantityUnit> getAllQuantityUnit() {

		List<QuantityUnit> list = new ArrayList<QuantityUnit>();

		for (QuantityUnit quantityUnitObj : quantityUnitRepository.findAll()) {
			list.add(quantityUnitObj);
		}

		return list;

	}

	@RequestMapping(value = "/api/v1/getQuality", method = RequestMethod.GET)
	public List<Quality> getAllQuality() {

		List<Quality> list = new ArrayList<Quality>();

		for (Quality obj : qualityRepository.findAll()) {
			list.add(obj);
		}

		return list.stream().sorted(Comparator.comparing(Quality::getName)).collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{itemCode}/getQualityByItem", method = RequestMethod.GET)
	public List<Quality> getQualityByItem(@PathVariable String itemCode) {

		List<Quality> list = new ArrayList<Quality>();

		for (Quality obj : qualityRepository.findByItemCode(itemCode)) {
			list.add(obj);
		}

		return list.stream().sorted(Comparator.comparing(Quality::getName)).collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{groupId}/getItemsByGroupId", method = RequestMethod.GET)
	public Items getAllItemBygroupId(@PathVariable String groupId) {

		Items itemsobj = boObj.getAllItemBygroupId(groupId);
		return itemsobj;

	}

	@RequestMapping(value = "/api/v1/getAllDepartment", method = RequestMethod.GET)
	public List<Department> getAllDepartment() {
		List<Department> list = new ArrayList<Department>();
		for (Department obj : departmentRepository.findAll()) {
			list.add(obj);
		}

		return list.stream().sorted(Comparator.comparing(Department::getName)).collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/getAllIndentType", method = RequestMethod.GET)
	public List<IndentType> getAllIndentType() {
		List<IndentType> list = new ArrayList<IndentType>();
		for (IndentType obj : indentTypeRepository.findAll()) {
			list.add(obj);
		}

		return list;

	}

	@RequestMapping(value = "/api/v1/getAllSupplier", method = RequestMethod.GET)
	public List<Supplier> getAllSupplier() {

		List<Supplier> list = new ArrayList<Supplier>();

		for (Supplier obj : supplierRepository.findAll()) {
			list.add(obj);
		}

		return list.stream().sorted(Comparator.comparing(Supplier::getName)).collect(Collectors.toList());

	}

	@RequestMapping(value = "/api/v1/{ids}/getStockByItemIdAndQualityCode", method = RequestMethod.GET)
	public List<ItemMaterialStock> getStockByItemIdAndQualityCode(@PathVariable String ids) {

		List<ItemMaterialStock> list = null;
		ItemMaterialStock itemStockObj = null;

		if (null != ids) {
			String[] params = ids.split("\\^");
			if (params.length > 1) {
				list = itemMaterialStockRepository.findByItemIdAndQualityCode(params[0], params[1]);
				// if(null!=list && list.size()>0){
				// itemStockObj=list.get(0);
				// }
			}
		}
		return list;

	}

	@RequestMapping(value = "/api/v1/{ids}/getStockByItemIdAndQualityCodeAndWareHouseNo", method = RequestMethod.GET)
	public List<PhysicalStock> getStockByItemIdAndQualityCodeAndWareHouseNo(@PathVariable String ids) {

		List<PhysicalStock> list = null;
		PhysicalStock itemStockObj = null;

		if (null != ids) {
			String[] params = ids.split("\\^");
			if (params.length > 1) {
				list = physicalStockRepository.findByItemIdAndQualityCodeAndWareHouseNo(params[0], params[1],
						params[2]);
				// if(null!=list && list.size()>0){
				// itemStockObj=list.get(0);
				// }
			}
		}
		return list;

	}

	@RequestMapping(value = "/api/v1/{id}/getStockByItemId", method = RequestMethod.GET)
	public List<ItemStock> getStockByItemId(@PathVariable String id) {

		List<ItemStock> list = null;
		if (null != id) {
			list = itemStockRepository.findByItemId(id);
		}
		return list;

	}

	@RequestMapping(value = "/api/v1/{ids}/getStockByItemIdAndStoreId", method = RequestMethod.GET)
	public List<PhysicalStock> getStockByItemIdAndStoreId(@PathVariable String ids) {

		List<PhysicalStock> list = null;
		if (null != ids) {
			String[] params = ids.split("\\^");
			if (params.length > 1) {
				list = physicalStockRepository.findByItemIdAndStoreId(params[0], Long.parseLong(params[1]));

			}

		}
		return list;

	}

	@RequestMapping(value = "/api/v1/{mukamId}/getAllItemByMukam", method = RequestMethod.GET)
	public Items getAllItemByMukam(@PathVariable long mukamId) {
		Items itemsobj = boObj.getAllItemByMukam(mukamId);
		return itemsobj;

	}

	@RequestMapping(value = "/api/v1/{departmentId}/getAllItemGroupsByDepartmentId", method = RequestMethod.GET)
	public List<ItemGroup> getAllItemGroupsByDepartmentId(@PathVariable long departmentId) {

		return boObj.getAllItemGroupsByDepartmentId(departmentId).stream()
				.sorted(Comparator.comparing(ItemGroup::getName)).collect(Collectors.toList());

	}

}
