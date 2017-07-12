package sz.automat.stock.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sz.automat.core.base.AbstractController;
import sz.automat.stock.model.StoSupplier;
import sz.automat.stock.provider.IStockProvider;

import java.util.Map;

/**
 *
 * 供应商管理控制类
 * Created by Administrator on 2017/7/7.
 */
@RestController
@Api(value = "供应商管理", description = "供应商管理")
@RequestMapping(value = "supplier")
public class StoSupplierController extends AbstractController<IStockProvider> {

    @Override
    public String getService() {
        return "stoSupplierService";
    }

    @ApiOperation(value = "查询供应商")
    @RequiresPermissions("sto.supplier.read")
    @RequestMapping(value = "/read/list", method = RequestMethod.PUT)
    public Object list(ModelMap modelMap, @RequestBody Map<String, Object> param) {
        return super.queryList(modelMap, param);
    }

    @ApiOperation(value = "查询供应商")
    @RequiresPermissions("sto.supplier.read")
    @PutMapping(value = "/read/page")
    public Object query(ModelMap modelMap, @RequestBody Map<String, Object> param) {
        return super.query(modelMap, param);
    }

    @ApiOperation(value = "供应商详情")
    @RequiresPermissions("sto.supplier.read")
    @RequestMapping(value = "/read/detail", method = RequestMethod.PUT)
    public Object get(ModelMap modelMap, @RequestBody StoSupplier param) {
        return super.get(modelMap, param);
    }

    @ApiOperation(value = "修改供应商")
    @RequiresPermissions("sto.supplier.update")
    @RequestMapping(method = RequestMethod.POST)
    public Object update(ModelMap modelMap, @RequestBody StoSupplier param) {

        return super.update(modelMap, param);
    }

    @ApiOperation(value = "删除供应商")
    @RequiresPermissions("sto.supplier.delete")
    @RequestMapping(method = RequestMethod.DELETE)
    public Object delete(ModelMap modelMap, @RequestBody StoSupplier param) {
        return super.delete(modelMap, param);
    }
}
