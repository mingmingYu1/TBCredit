package com.yodata.creditsupport.orm.entity.crawler;

import java.io.Serializable;
import java.util.Date;

public class NewsListEntity implements Serializable{
	private static final long serialVersionUID = -8657105143541390778L;
	
	private Integer rid;                //主键
    private String cid;           		//站点名称（不可变固定值：tengbang）//测试时使用test
    private String channelName;         //频道名称（建议值：深圳信用）
    private String keyword;            	//关键字（企业名称或者社会信用代码）
    private String pageType;            //页面类型（不可变固定值：tengbanglist）
    private int weight;             	//优先级
    private String url;            		//拼接好的列表页的url
    private int pageIdx;            	//起始页码
    private int nextPageTime;           //最大请求次数
    private int status;            		//状态（0：停用，1：启用，建议测试时设置成0）
    private int intv;              		//下次抓取间隔
    private String attachTag;           //附加标签（{“深圳信用”：“工商注册号”}）
    private Date lastcrawltime;         //最后一次抓取时间
    private Date nextcrawltime;        	//下次抓取时间
    private Date createTime;         	//创建时间
    private Date modiTime;              //修改时间
	
    public Integer getRid() {
        return rid;
    }
	public void setRid(Integer rid) {
        this.rid = rid;
    }
    public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getPageType() {
		return pageType;
	}
	public void setPageType(String pageType) {
		this.pageType = pageType;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getPageIdx() {
		return pageIdx;
	}
	public void setPageIdx(int pageIdx) {
		this.pageIdx = pageIdx;
	}
	public int getNextPageTime() {
		return nextPageTime;
	}
	public void setNextPageTime(int nextPageTime) {
		this.nextPageTime = nextPageTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIntv() {
		return intv;
	}
	public void setIntv(int intv) {
		this.intv = intv;
	}
	public String getAttachTag() {
		return attachTag;
	}
	public void setAttachTag(String attachTag) {
		this.attachTag = attachTag;
	}
	public Date getLastcrawltime() {
		return lastcrawltime;
	}
	public void setLastcrawltime(Date lastcrawltime) {
		this.lastcrawltime = lastcrawltime;
	}
	public Date getNextcrawltime() {
		return nextcrawltime;
	}
	public void setNextcrawltime(Date nextcrawltime) {
		this.nextcrawltime = nextcrawltime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModiTime() {
		return modiTime;
	}
	public void setModiTime(Date modiTime) {
		this.modiTime = modiTime;
	}
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((rid == null) ? 0 : rid.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NewsListEntity other = (NewsListEntity) obj;
        if (rid == null) {
            if (other.rid != null)
                return false;
        } else if (!rid.equals(other.rid))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "AgentInfoEntity [rid=" + rid + ", cid=" + cid + ", channelName=" + channelName + ", keyword=" + keyword
                + ", pageType=" + pageType + ", weight=" + weight + ", url=" + url + ", pageIdx="
                + pageIdx + ", nextPageTime=" + nextPageTime + ", status=" + status + ", intv=" + intv + ", attachTag="
                + attachTag + ", lastcrawltime=" + lastcrawltime + ", nextcrawltime=" + nextcrawltime + ", createTime=" + createTime
                + ", modiTime=" + modiTime + "]";
    }
    
}