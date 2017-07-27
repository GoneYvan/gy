package com.gy.base;

/**
 * Created by Administrator on 2017/7/27 0027.
 */
public class BasePagination {

    private Integer page; // 页数
    private Integer pageNum; // 分页数量
    private Integer start = 0; // 起始首位查询索引
    private Integer stop = 20; // 起始末端查询索引

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getStop() {
        return stop;
    }

    public void setStop(Integer stop) {
        this.stop = stop;
    }
}
