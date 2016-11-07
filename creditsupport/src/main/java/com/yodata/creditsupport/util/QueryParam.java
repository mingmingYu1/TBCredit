package com.yodata.creditsupport.util;

public class QueryParam {
	
	private int offset;
	
	private int limit;
	
	private String condition;
	
	private int queryType;
	
	private String queryCode;
	private String queryName;
	private String IndicatorCate;
	
	private Integer queryId;
	
	private String status;
	
	/** 法人姓名 */
	private String lpname;
	
	//排序字段
	private String sortStr;
	
	//算法类型
	private String algorithmType;
	
	public QueryParam(){
		
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public int getQueryType() {
		return queryType;
	}

	public void setQueryType(int queryType) {
		this.queryType = queryType;
	}

	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getIndicatorCate() {
        return IndicatorCate;
    }

    public void setIndicatorCate(String indicatorCate) {
        IndicatorCate = indicatorCate;
    }

    public Integer getQueryId() {
		return queryId;
	}

	public void setQueryId(Integer queryId) {
		this.queryId = queryId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLpname() {
		return lpname;
	}

	public void setLpname(String lpname) {
		this.lpname = lpname;
	}

	public String getSortStr() {
		return sortStr;
	}

	public void setSortStr(String sortStr) {
		this.sortStr = sortStr;
	}

    public String getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(String algorithmType) {
        this.algorithmType = algorithmType;
    }

}
