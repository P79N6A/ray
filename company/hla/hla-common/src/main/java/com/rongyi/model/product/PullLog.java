package com.rongyi.model.product;

import com.rongyi.model.BaseDO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * 操作日志记录
 *
 * @author: yechao
 * @date: 2018/08/08 15:27
 * @version: V1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class PullLog extends BaseDO {

    private static final long serialVersionUID = 1L;


    private String name; // 操作名称

    private boolean success = true;//操作结果

    private String targetAddress; // 操作的目标地址

    private String remark; // 操作备注、、、异常可以记载这里

    private Date createDate = new Date(); // 操作时间

    private String url = "0.0.0.0"; // 操作者的地址

    private int type; // 状态码

    private String operator; // 操作者

/**

    create table pull_log(
   `id` BIGINT(20) NOT NULL AUTO_INCREMENT '日志主键',
   `success` SMALLINT(4)  NOT NULL '是否成功',
   `type`  INT(10)  NOT NULL '是否成功',
            `name` VARCHAR(100) '操作名称',
            `target_address` VARCHAR(100) '操作的目标地址',
            `operator` VARCHAR(100) '操作名称',
            `remark` VARCHAR(225) '操作备注',
            `url` VARCHAR(225) '操作者的地址',
            `create_time` datetime DEFAULT NULL COMMIT '创建时间',
    PRIMARY KEY ( tutorial_id )
);

*/

    public PullLog(String name, boolean success) {
        this.name = name;
        this.success = success;
    }

    /**
     * @param operator      谁
     * @param name          操作名称
     * @param targetAddress 目标地址
     * @param remark        操作记录
     * @param success       结果
     */
    public PullLog(String operator, String name, String targetAddress, String remark, boolean success) {
        this.name = name;
        this.success = success;
        this.targetAddress = targetAddress;
        this.remark = remark;
        this.operator = operator;
    }
}