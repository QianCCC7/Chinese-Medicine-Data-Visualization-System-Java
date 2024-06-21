package com.xiaoqian.user.domain.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@ApiModel("方剂信息")
public class PrescriptionVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("方剂id")
    private Integer id;

    @ApiModelProperty("方剂id")
    private String name;

    @ApiModelProperty("拼音")
    private String pinyin;

    @ApiModelProperty("分类")
    private String category;

    @ApiModelProperty("组成")
    private String makeUp;

    @ApiModelProperty("用法")
    private String usage;

    @ApiModelProperty("功用")
    private String benefits;

    @ApiModelProperty("主治")
    private String treat;

    @ApiModelProperty("病机")
    private String cause;

    @ApiModelProperty("运用")
    private String apply;

    @ApiModelProperty("附方")
    private String addendum;

    @ApiModelProperty("方歌")
    private String song;

    @ApiModelProperty("附注")
    private String note;

    @ApiModelProperty("出处")
    private String source;

    @ApiModelProperty("图片路径")
    private String url;

    @ApiModelProperty("药材组成")
    private String herbs;
}
