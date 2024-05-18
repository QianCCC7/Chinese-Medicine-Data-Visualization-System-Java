package com.xiaoqian.user.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class MedicineHerbsVo implements Serializable {

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
     * 英文名
     */
    private String englishName;

    /**
     * 拉丁名
     */
    private String latinName;

    /**
     * 分类
     */
    private String category;

    /**
     * 产地
     */
    private String provinces;

    /**
     * 性状
     */
    private String nature;

    /**
     * 品质
     */
    private String quality;

    /**
     * 性味
     */
    private String flavor;

    /**
     * 功效
     */
    private String benefits;

    /**
     * 来源
     */
    private String source;

    /**
     * 图片路径
     */
    private String url;

    /**
     * 炙品
     */
    private String roastedFood;
}
