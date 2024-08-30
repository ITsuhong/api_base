package com.sysxx.common.dao;

import com.sysxx.common.enumeration.DataType;
import lombok.Data;

@Data
public class HeaderData {
    private String id;
    private String name;
    private String value;
//    private DataType type;
    private String desc;
}
