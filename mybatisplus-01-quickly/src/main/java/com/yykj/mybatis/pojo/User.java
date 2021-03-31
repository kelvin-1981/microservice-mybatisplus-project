package com.yykj.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 对应主键：
     * 1.IdType.ID_WORKER: 全局唯一ID
     * 2.IdType.AUTO: 主键自增 *数据库ID字段需要自增
     * 3.IdType.NONE: 未设置主键
     * 4.IdType.INPUT: 手动输入
     * 5.UUID: 全局唯一 UUID
     * 6.IdType.ID_WORKER_STR: ID_WORKER字符串表示法
     */
    @TableId(type = IdType.INPUT)
    private long id;
    private String name;
    private Integer age;
    private String email;
    @Version
    private Integer version;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @TableLogic
    private Integer deleted;
}
