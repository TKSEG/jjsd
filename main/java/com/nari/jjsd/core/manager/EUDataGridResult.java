package com.nari.jjsd.core.manager;

/**
 * Created by yangbo on 2019/3/13.
 */

import java.util.List;

public class EUDataGridResult {
    public EUDataGridResult(){}
    public EUDataGridResult(ResultInfo resultInfo){
        this.resultInfo = resultInfo;
    }

    //操作结果信息
    private ResultInfo resultInfo;
    //总条数
    private long total;
    //结果集
    private List<?> rows;
    //总计告诉footer
    private List<?> footer;

    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    public List<?> getFooter() {
        return footer;
    }

    public void setFooter(List<?> footer) {
        this.footer = footer;
    }

    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List<?> getRows() {
        return rows;
    }
    public void setRows(List<?> rows) {
        this.rows = rows;
    }

}

