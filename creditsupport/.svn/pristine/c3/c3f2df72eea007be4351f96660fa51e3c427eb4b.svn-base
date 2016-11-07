package com.yodata.creditsupport.service;

import java.util.List;
import java.util.Map;

import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.orm.vo.GrossProfit;

public interface IScoreDetalService {
	/**
	 * 根据企业工商注册号查询企业的注册资金历史记录
	 * @param regId
	 * @return
	 * @throws DataAccessException
	 */
	public List<GrossProfit> getCapitalGrowthList(String regId) throws BusinessException;
	/**
	 * 近两年的年平均商旅毛利润总额信息
	 * @param id		企业编号
	 * @return
	 */
	public List<GrossProfit> getGrossProfit(String id) throws BusinessException;
	/**
	 * 获取最近6个月订单出票量及出票增长率
	 * @param id		企业编号
	 * @return
	 */
	public Map<String, List<GrossProfit>> getTicketGrowth(String id) throws BusinessException;
	/**
	 * 获取最近6个月退订单出票量、废票量及退废票率
	 * @param id		企业编号
	 * @return
	 */
	public Map<String, List<GrossProfit>> getRetirementTicket(String id) throws BusinessException;
}
