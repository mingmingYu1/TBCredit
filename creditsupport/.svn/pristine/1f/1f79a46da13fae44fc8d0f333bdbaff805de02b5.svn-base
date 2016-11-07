package com.yodata.creditsupport.dao.crawler;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.yodata.creditsupport.orm.entity.crawler.NewsListEntity;

/**
 * 抓取任务列表
 * @author liujin
 * 描述：前端提交抓取任务，该Dao调用create方法将一条任务数据插入对应的数据表
 *
 */
public class NewsListDao {
    private JdbcTemplate jdbcTemplate;
    
    /**
     * 新增一条记录到抓取列表
     * @param newsList
     * @return
     */
    public boolean create(NewsListEntity newsList) {
        String sql = "insert into newslist_000(rid,attachTag,channelName,cid,createTime,intv,keyword,lastcrawltime,modiTime,nextcrawltime,nextPageTime,pageIdx,pageType,status,url,weight)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, newsList.getRid(),newsList.getAttachTag(),newsList.getChannelName(),newsList.getCid(),newsList.getCreateTime(),newsList.getIntv(),newsList.getKeyword(),newsList.getLastcrawltime(),newsList.getModiTime(),newsList.getNextcrawltime(),newsList.getNextPageTime(),newsList.getPageIdx(),newsList.getPageType(),newsList.getStatus(),newsList.getUrl(),newsList.getWeight());
        return update > 0 ? true : false;
    }
    
    /**
     * 按id查询
     * @param id
     * @return
     */
    public NewsListEntity getById(Integer id) {
        String sql = "select * from newslist_000 where rid=?";
        return jdbcTemplate.queryForObject(sql,  new RowMapper<NewsListEntity>(){
            public NewsListEntity mapRow(ResultSet rs, int index) throws SQLException {
                NewsListEntity n = new NewsListEntity();
                n.setRid(rs.getInt("rid"));
                n.setAttachTag(rs.getString("attachTag"));
                n.setChannelName(rs.getString("channelName"));
                n.setCid(rs.getString("cid"));
                n.setCreateTime(rs.getDate("createTime"));
                n.setIntv(rs.getInt("intv"));
                n.setKeyword(rs.getString("keyword"));
                n.setLastcrawltime(rs.getDate("lastcrawltime"));
                n.setModiTime(rs.getDate("modiTime"));
                n.setNextcrawltime(rs.getDate("nextcrawltime"));
                n.setNextPageTime(rs.getInt("nextPageTime"));
                n.setPageIdx(rs.getInt("pageIdx"));
                n.setPageType(rs.getString("pageType"));
                n.setStatus(rs.getInt("status"));
                n.setUrl(rs.getString("url"));
                n.setWeight(rs.getInt("weight"));
                return n;
            }
        },id);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}