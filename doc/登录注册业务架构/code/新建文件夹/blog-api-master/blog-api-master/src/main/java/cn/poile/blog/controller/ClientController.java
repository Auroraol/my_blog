package cn.poile.blog.controller;


import cn.poile.blog.common.response.ApiResponse;
import cn.poile.blog.common.response.ResponseResult;
import cn.poile.blog.entity.Client;
import cn.poile.blog.service.IClientService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 客户端表 前端控制器
 * </p>
 *
 * @author yaohw
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/client")
@Api(tags = "客户端服务",value = "/client")
public class ClientController extends BaseController {

    @Autowired
    private IClientService clientService;

    @GetMapping("/page")
    @PreAuthorize("hasAuthority('admin')")
    @ApiOperation(value = "分页获取客户端列表",notes = "需要accessToken，需要管理员权限")
    public ApiResponse<IPage<Client>> page(@ApiParam("页码") @RequestParam(value = "current", required = false, defaultValue = "1") long current,
                                           @ApiParam("每页数量") @RequestParam(value = "size", required = false, defaultValue = "5") long size) {
        return createResponse(clientService.page(new Page<>(current,size)));

    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除客户端",notes = "需要accessToken，需要管理员权限")
    public ResponseResult<Object> delete(@ApiParam("id") @PathVariable(value = "id") int id) {
        clientService.removeById(id);
        clientService.clearCache();
//        return createResponse();
        return ResponseResult.success();
    }

    @PostMapping("/save")
    @ApiOperation(value = "新增或更新客户端,id为null时新增",notes = "需要accessToken，需要管理员权限")
    public ResponseResult<Object> save(@Validated @RequestBody Client client) {
        clientService.validateExist(client);
        clientService.saveOrUpdate(client);
        clientService.clearCache();
        return ResponseResult.success();
//        return createResponse();
    }

}
