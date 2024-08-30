package com.sysxx.common.utils;

import com.github.pagehelper.PageHelper;
import com.sysxx.common.core.page.PageDomain;
import com.sysxx.common.core.page.TableSupport;

public class PageUtils extends PageHelper {
    public static void startPage() {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        Boolean reasonable = pageDomain.getReasonable();
        String orderBy = pageDomain.getOrderBy();
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

    public static void clearPage() {
        PageHelper.clearPage();
    }

}
