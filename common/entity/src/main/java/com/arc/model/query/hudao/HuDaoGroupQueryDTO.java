package com.arc.model.query.hudao;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 互道非标准--分组
 * 查询条件
 */
@Data
@ToString
public class HuDaoGroupQueryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer parent_code = 0;//当前一个分组0

    public HuDaoGroupQueryDTO(Integer parent_code) {
        this.parent_code = parent_code;
    }
}
