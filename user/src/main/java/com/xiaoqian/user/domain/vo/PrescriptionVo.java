package com.xiaoqian.user.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaoqian
 * @since 2024-05-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PrescriptionVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 分类
     */
    private String category;

    /**
     * 组成
     */
    private String makeUp;

    /**
     * 用法
     */
    private String usage;

    /**
     * 功用
     */
    private String benefits;

    /**
     * 主治
     */
    private String treat;

    /**
     * 病机
     */
    private String cause;

    /**
     * 运用
     */
    private String apply;

    /**
     * 附方
     */
    private String addendum;

    /**
     * 方歌
     */
    private String song;

    /**
     * 附注
     */
    private String note;

    /**
     * 出处
     */
    private String source;

    /**
     * 图片路径
     */
    private String url;

    /**
     * 药材组成
     */
    private String herbs;
}
