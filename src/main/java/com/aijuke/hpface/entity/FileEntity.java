package com.aijuke.hpface.entity;

import lombok.Data;

import java.util.Date;

@Data
public class FileEntity {
    private Long id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 后缀
     */
    private String gs;

    /**
     * 大小
     */
    private String size;

    /**
     * 路径
     */
    private String path;

    /**
     * 创建时间
     */
    private Date createTime;
}
