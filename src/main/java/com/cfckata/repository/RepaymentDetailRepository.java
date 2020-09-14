package com.cfckata.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cfckata.dao.RepaymentDetailDO;
import com.cfckata.dao.RepaymentDetailDOMapper;
import com.cfckata.domain.RepaymentDetail;
import com.cfckata.exception.RepaymentException;

@Repository
public class RepaymentDetailRepository {
	
	@Autowired
	private RepaymentDetailDOMapper repaymentDetailDOMapper;
	
	/**
	 * 插入还款明细信息
	 * @param detail
	 */
	public void insert(RepaymentDetail detail) {
		RepaymentDetailDO detailDO = new RepaymentDetailDO(detail);
		repaymentDetailDOMapper.insert(detailDO);
	}
	
	/**
	 * 根据还款流水Id获取还款明细信息
	 * @param repaymentId
	 * @return
	 */
	public RepaymentDetail findRepaymentDetailById(String repaymentId) {
		RepaymentDetailDO repaymentDetailDO = repaymentDetailDOMapper.findRepaymentDetailById(repaymentId);
		if(repaymentDetailDO == null) {
			throw new RepaymentException("根据还款流水ID无法查询到对应的还款明细信息");
		}
		return repaymentDetailDO.toRepaymentDetail();
	}
}
