package com.xiaoqian.user.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("药材信息")
public class MedicineHerbsVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("药材id")
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("拼音")
    private String pinyin;

    @ApiModelProperty("英文名")
    private String englishName;

    @ApiModelProperty("拉丁名")
    private String latinName;

    @ApiModelProperty("分类")
    private String category;

    @ApiModelProperty("产地")
    private String provinces;

    @ApiModelProperty("性状")
    private String nature;

    @ApiModelProperty("品质")
    private String quality;

    @ApiModelProperty("性味")
    private String flavor;

    @ApiModelProperty("功效")
    private String benefits;

    @ApiModelProperty("来源")
    private String source;

    @ApiModelProperty("图片路径")
    private String url;

    @ApiModelProperty("炙品")
    private String roastedFood;
}
