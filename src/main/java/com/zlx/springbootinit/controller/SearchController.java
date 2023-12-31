package com.zlx.springbootinit.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zlx.springbootinit.common.BaseResponse;
import com.zlx.springbootinit.common.ErrorCode;
import com.zlx.springbootinit.common.ResultUtils;
import com.zlx.springbootinit.exception.BusinessException;
import com.zlx.springbootinit.exception.ThrowUtils;
import com.zlx.springbootinit.manager.SearchFacede;
import com.zlx.springbootinit.model.dto.post.PostQueryRequest;
import com.zlx.springbootinit.model.dto.search.SearchRequest;
import com.zlx.springbootinit.model.dto.user.UserQueryRequest;
import com.zlx.springbootinit.model.entity.Picture;
import com.zlx.springbootinit.model.enums.SearchTypeEnum;
import com.zlx.springbootinit.model.vo.PostVO;
import com.zlx.springbootinit.model.vo.SearchVO;
import com.zlx.springbootinit.model.vo.UserVO;
import com.zlx.springbootinit.service.PictureService;
import com.zlx.springbootinit.service.PostService;
import com.zlx.springbootinit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.weaver.ast.Var;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 帖子接口
 *
 * @author zlx
 */
@RestController
@RequestMapping("/search")
@Slf4j
public class SearchController {

    @Resource
    private UserService userService;

    @Resource
    private PostService postService;

    @Resource
    private PictureService pictureService;

    @Resource
    private SearchFacede searchFacede;

    @PostMapping("/all")
    public BaseResponse<SearchVO> searchAll(@RequestBody SearchRequest searchRequest, HttpServletRequest request) {
        return ResultUtils.success(searchFacede.searchAll(searchRequest, request));
    }
}
