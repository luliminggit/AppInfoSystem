package com.team.appinfo.until;

import org.springframework.web.bind.annotation.RequestParam;

public class PageMeter {
    private Integer page = 1;
    private Integer pageSize = 4;
    private String querySoftwareName;
    private Long queryStatus;
    private Long queryFlatformId;

    private Long queryCategoryLevel5;
    private Long queryCategoryLevel6;
    private Long queryCategoryLevel7;

    private Long devid;

    public Long getDevid() {
        return devid;
    }

    public void setDevid(Long devid) {
        this.devid = devid;
    }

    public String getQuerySoftwareName() {
        return querySoftwareName;
    }

    public void setQuerySoftwareName(String querySoftwareName) {
        this.querySoftwareName = querySoftwareName;
    }

    public Long getQueryStatus() {
        return queryStatus;
    }

    public void setQueryStatus(Long queryStatus) {
        this.queryStatus = queryStatus;
    }

    public Long getQueryFlatformId() {
        return queryFlatformId;
    }

    public void setQueryFlatformId(Long queryFlatformId) {
        this.queryFlatformId = queryFlatformId;
    }

    public Long getQueryCategoryLevel5() {
        return queryCategoryLevel5;
    }

    public void setQueryCategoryLevel5(Long queryCategoryLevel5) {
        this.queryCategoryLevel5 = queryCategoryLevel5;
    }

    public Long getQueryCategoryLevel6() {
        return queryCategoryLevel6;
    }

    public void setQueryCategoryLevel6(Long queryCategoryLevel6) {
        this.queryCategoryLevel6 = queryCategoryLevel6;
    }

    public Long getQueryCategoryLevel7() {
        return queryCategoryLevel7;
    }

    public void setQueryCategoryLevel7(Long queryCategoryLevel7) {
        this.queryCategoryLevel7 = queryCategoryLevel7;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
