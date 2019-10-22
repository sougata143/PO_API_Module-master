package com.sls.po.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.po.model.IssueLineItem;

public interface IssueLineItemRepository extends JpaRepository<IssueLineItem, Long> {

   List<IssueLineItem> findByIssueHeaderId(Long issueHeaderId);
   List<IssueLineItem> findByIssueHeaderId(long issueHeader);
   List<IssueLineItem> findByIssueHeaderIdAndItemId(long issueHeader, String itemCode);
   List<IssueLineItem> findByItemId(String itemCode);

}
