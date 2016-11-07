package com.yodata.creditsupport.service.imp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yodata.creditsupport.dao.ScoreDetalDao;
import com.yodata.creditsupport.exception.BusinessException;
import com.yodata.creditsupport.exception.DataAccessException;
import com.yodata.creditsupport.orm.vo.GrossProfit;
import com.yodata.creditsupport.service.IScoreDetalService;

@Service
public class ScoreDetailServiceImpl implements IScoreDetalService {
	private final Log log = LogFactory.getLog(ScoreDetailServiceImpl.class);
	@Resource
	private ScoreDetalDao scoreDetalDao;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<GrossProfit> getCapitalGrowthList(String regId) throws BusinessException {
		try {
			int year = Calendar.getInstance().get(Calendar.YEAR);
			List<GrossProfit> list = scoreDetalDao.getCapitalGrowthList(regId, (year - 3) + "0101", (year + 1) + "0101");
			return list;
		} catch (DataAccessException e) {
			log.error(e);
			throw new BusinessException("数据查询异常");
		}
	}

	// 出票增长率
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, List<GrossProfit>> getTicketGrowth(String id) throws BusinessException {
		try {
			String[] date = getMinMaxDate();
			// 月订单出票数
			List<GrossProfit> mList = scoreDetalDao.getRetirementTicketMonth(id, "B001", date[0], date[1]);
			// 日订单出票数
			List<GrossProfit> dList = scoreDetalDao.getRetirementTicketDay(id, "B001", date[0], date[1]);
			GrossProfit before = null, current = null;
			Double amount = null;
			for (GrossProfit item : mList) { // 设置增长率
				item.setDateStr(item.getYear() + "年" + item.getMonth() + "月");
				amount = item.getAmount();
				if (before == null) {
					before = item;
					before.setGrowth(0.0d);
				} else {
					current = item;
					if (amount == 0.0d) {
						current.setGrowth(before.getAmount() == 0.0d ? 0.0d : -1);
					} else {
						current.setGrowth((amount - before.getAmount()) / amount);
					}
					before = current;
				}
			}
			Map<String, List<GrossProfit>> map = new HashMap<>();
			map.put("mOrderNum", mList);
			map.put("dOrderNum", dList);
			return map;
		} catch (DataAccessException e) {
			log.error(e);
			throw new BusinessException("数据查询异常");
		}
	}

	// 退废票
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Map<String, List<GrossProfit>> getRetirementTicket(String id) throws BusinessException {
		try {
			// 月退废票数
			List<GrossProfit> mList1 = new ArrayList<>();
			// 月订单出票数
			List<GrossProfit> mList2 = new ArrayList<>();
			String[] date = getMinMaxDate();
			// 日退废票数
			List<GrossProfit> dList1 = scoreDetalDao.getRetirementTicketDay(id, "B002", date[0], date[1]);
			// 日订单出票数
			List<GrossProfit> dList2 = scoreDetalDao.getRetirementTicketDay(id, "B001", date[0], date[1]);
			// 接纳每天
			GrossProfit backDay, orderDay;
			// 接纳每月
			GrossProfit backMonth = new GrossProfit();
			GrossProfit orderMonth = new GrossProfit();
			mList1.add(backMonth);
			mList2.add(orderMonth);
			// 每月累加值
			Double backAmount = Double.valueOf(0);
			Double orderAmount = Double.valueOf(0);
			int len = dList1.size();
			for (int i = 0; i < len; i++) {
				backDay = dList1.get(i);
				orderDay = dList2.get(i);
				// 如果进入了下个月或者最后一天
				if ((i > 0 && backDay.getDay() == 1) || i == len - 1) {
					if (i == len - 1) {
						backAmount += backDay.getAmount(); // 累加每日的量
						orderAmount += orderDay.getAmount();
					}
					GrossProfit before = dList1.get(i - 1); // 获取上一条数据
					backMonth.setAmount(backAmount);
					orderMonth.setAmount(orderAmount);
					// 每月退废票率放在 orderMonth
					if (orderAmount.longValue() == 0) {	//出票量为0
						if(backAmount.longValue() == 0) {
							orderMonth.setGrowth(0.0d);
						} else {	//退票量不为0
							orderMonth.setGrowth(1.0d);
						}
					} else {
						orderMonth.setGrowth(backAmount / (orderAmount + backAmount));
					}
					backMonth.setDateStr(before.getYear() + "年" + before.getMonth() + "月");
					orderMonth.setDateStr(before.getYear() + "年" + before.getMonth() + "月");
	
					backMonth = new GrossProfit();
					orderMonth = new GrossProfit();
					mList1.add(backMonth);
					mList2.add(orderMonth);
					// 清空累加量
					backAmount = Double.valueOf(0);
					orderAmount = Double.valueOf(0);
				}
				// 累加每日的量
				backAmount += backDay.getAmount();
				orderAmount += orderDay.getAmount();
			}
			Map<String, List<GrossProfit>> map = new HashMap<>();
			map.put("mBackNum", mList1);
			map.put("mOrderNum", mList2);
			map.put("dBackNum", dList1);
			map.put("dOrderNum", dList2);
			return map;
		} catch (DataAccessException e) {
			log.error(e);
			throw new BusinessException("数据查询异常");
		}
	}

	// 毛利额-增长率
	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<GrossProfit> getGrossProfit(String id) throws BusinessException {
		try {
			String[] date = new String[2];
			Calendar c = Calendar.getInstance();
			int currentYear = c.get(Calendar.YEAR);
			c.add(Calendar.YEAR, -5);
			date[0] = c.get(Calendar.YEAR) + "0101";
			date[1] = ++currentYear + "0101";
			List<GrossProfit> list = scoreDetalDao.getGrossProfit(id, "B003", date[0], date[1]);
			// 下面是设置增长率，因为我还没有找到在数据库里计算出来的方法 :(
			GrossProfit before = null, current = null;
			Double amount = null;
			for (GrossProfit item : list) {
				amount = item.getAmount();
				item.setAmount(amount);
				if (before == null) {
					before = item;
					before.setGrowth(0.0d);
				} else {
					current = item;
					amount = current.getAmount();
					if (amount == 0.0d) {
						current.setGrowth(before.getAmount() == 0.0d ? 0.0d : -1);
					} else {
						current.setGrowth((amount - before.getAmount()) / amount);
					}
					before = current;
				}
			}
			return list;
		} catch (DataAccessException e) {
			log.error(e);
			throw new BusinessException("数据查询异常");
		}
	}

	// 获取日期区间
	private String[] getMinMaxDate() {
		String[] date = new String[2];
		Calendar c = Calendar.getInstance();
		// 获取6个月前的日期
		c.add(Calendar.MONTH, -5);
		StringBuffer sbf = new StringBuffer(String.valueOf(c.get(Calendar.YEAR)));
		int month = c.get(Calendar.MONTH);
		if (month < 10) {
			sbf.append("0" + month);
		} else {
			sbf.append(month);
		}
		sbf.append("01");
		date[0] = sbf.toString();

		c.set(Calendar.DATE, 1); // 设置日期为1号，防止月份加1出错
		c.add(Calendar.MONTH, 6); // 月份加6
		sbf = new StringBuffer(String.valueOf(c.get(Calendar.YEAR)));
		month = c.get(Calendar.MONTH);
		if (month < 10) {
			sbf.append("0" + month);
		} else {
			sbf.append(month);
		}
		sbf.append("01");
		date[1] = sbf.toString();

		return date;
	}
}
