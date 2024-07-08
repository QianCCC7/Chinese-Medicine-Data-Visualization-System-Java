package com.xiaoqian.user.controller;


import com.xiaoqian.common.domain.ResponseResult;
import com.xiaoqian.user.domain.vo.MenuVo;
import com.xiaoqian.user.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaoqian
 * @since 2024-07-07
 */
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
@Api(tags = "菜单相关接口")
public class MenuController {
    private final IMenuService menuService;

    @ApiOperation("获取所有菜单")
    @GetMapping
    public ResponseResult<List<MenuVo>> getAllMenus() {
        return menuService.getAllMenus();
    }
}
