package com.sysxx.common.core.page;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class TableDataInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer pageSize;

    private Integer PageNum;

    private Integer PageTotal;

    /**
     * 总记录数
     */
    private long total;

    /**
     * 列表数据
     */
    private Object data;

    /**
     * 消息状态码
     */
    private int code;

    /**
     * 消息内容
     */
    private String msg;

    /**
     * 表格数据对象
     */
    public TableDataInfo() {
    }

    /**
     * 分页
     *
     * @param data 列表数据
     */
    public void setData(Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("list", data);
        this.data = result;
    }
}
