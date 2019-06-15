package SmallProject.service;

import SmallProject.model.Category;

import java.util.List;

/**
 * @Auther: Feiyu
 * @Date: 2019/3/15 13:16
 * @Description:
 */
public interface treeConstructure {
    /**
     * 查询树形结构类目数据
     * @param dept
     * @return
     */
    List<Category> tree(int dept);

}
