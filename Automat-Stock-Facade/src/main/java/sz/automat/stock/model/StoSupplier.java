package sz.automat.stock.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import sz.automat.core.base.BaseModel;

/**
 * Created by Administrator on 2017/7/7.
 */
@SuppressWarnings("serial")
@TableName("sto_supplier")
public class StoSupplier extends BaseModel {

    /**
     * 供应商名称
     */
    @TableField(value="name")
    private String name;

    /**
     * 供应商联系人名称
     */
    @TableField(value="linkman")
    private String linkman;

    /**
     * 供应商联系人电话
     */
    @TableField(value="linkman_tel")
    private Integer linkmanTel;

    /**
     * 供应商联系人地址
     */
    @TableField(value="linkman_address")
    private String linkmanAddress;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public Integer getLinkmanTel() {
        return linkmanTel;
    }

    public void setLinkmanTel(Integer linkmanTel) {
        this.linkmanTel = linkmanTel;
    }

    public String getLinkmanAddress() {
        return linkmanAddress;
    }

    public void setLinkmanAddress(String linkmanAddress) {
        this.linkmanAddress = linkmanAddress;
    }
}
