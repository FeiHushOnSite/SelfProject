package SmallProject.model;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: Feiyu
 * @Date: 2019/3/15 11:04
 * @Description:
 */

public class Category implements Serializable {
    private static final Long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    private Long iD;
    /**
     * 父键ID 无默认为0
     */
    private Long parentId;
    /**
     * 子类目录
     */
    private List<Category> children;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 深度: 1-2-3级
     */
    private Integer dept;

    public Category() {
    }

    public Category(Long iD, Long parentId, String name, Integer dept) {
        this.iD = iD;
        this.parentId = parentId;
        this.name = name;
        this.dept = dept;
    }

    public Long getiD() {
        return iD;
    }

    public void setiD(Long iD) {
        this.iD = iD;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }
}
