package com.sysxx.common.core.controller;


import com.github.pagehelper.PageInfo;
import com.sysxx.common.constant.HttpStatus;
import com.sysxx.common.core.page.TableDataInfo;
import com.sysxx.common.utils.PageUtils;

import java.util.List;

public class BaseController {

    protected void startPage() {
        PageUtils.startPage();
    }

    protected TableDataInfo getDataTable(List<?> list) {
        TableDataInfo tableDataInfo = new TableDataInfo();
        PageInfo<?> pageInfo = new PageInfo<>(list);
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        long total = pageInfo.getTotal();
        int navigatePages = pageInfo.getNavigateLastPage();
        tableDataInfo.setCode(HttpStatus.SUCCESS);
        tableDataInfo.setMsg("查询成功");
        tableDataInfo.setData(list);
        tableDataInfo.setPageSize(pageSize);
        tableDataInfo.setPageNum(pageNum);
        tableDataInfo.setTotal(total);
        tableDataInfo.setPageTotal(navigatePages);
        return tableDataInfo;
    }
}
