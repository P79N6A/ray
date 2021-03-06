package com.arc.model.entity.product;

import lombok.NoArgsConstructor;
import lombok.*;

/**
 * 主分组（"code": 7,  "name": "SHOES&ACC"）
 * 注意：
 * 区别主分类（category_code、category_name）
 * 一个spu 一个主分类但是允许多个分组
 */
@Setter
@Getter
@NoArgsConstructor
public class GroupSpu {

    private String spuCode;

    private String groupCode; // spu对应分组的code

    private String groupName; // spu对应分组的名称

}
