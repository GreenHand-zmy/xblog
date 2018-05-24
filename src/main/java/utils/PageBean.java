package utils;

import java.util.List;

public class PageBean<T> {
    // 元素总和
    private Integer totalRecords;

    // 每页多少个元素
    private Integer pageSize;

    // 当前页码
    private Integer pageIndex;

    // 总页数
    private Integer totalPages;

    // 此页数据内容
    private List<T> data;

    public PageBean(Integer totalRecords, Integer pageIndex) {
        this.totalRecords = totalRecords;
        this.pageIndex = pageIndex;
    }

    public PageBean(Integer totalRecords, Integer pageIndex, Integer pageSize) {
        this.totalRecords = totalRecords;
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
    }

    /**
     * 分页偏移量
     * 在mysql中 limit offset,limit
     *
     * @return 返回偏移量
     */
    public Integer getOffset() {
        return pageSize * (pageIndex - 1);
    }

    /**
     * 返回页大小
     *
     * @return
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 返回页码
     *
     * @return
     */
    public Integer getPageIndex() {
        return pageIndex;
    }

    /**
     * 返回总页数
     *
     * @return
     */
    public Integer getTotalPages() {
        return totalPages = totalRecords % pageSize == 0 ?
                (totalRecords / pageSize) : (totalRecords / pageSize + 1);
    }

    /**
     * 是否有上一页
     *
     * @return
     */
    public boolean havePrePage() {
        return pageIndex > 1;
    }

    /**
     * 是否有下一页
     *
     * @return
     */
    public boolean haveNextPage() {
        return pageIndex < getTotalPages();
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
