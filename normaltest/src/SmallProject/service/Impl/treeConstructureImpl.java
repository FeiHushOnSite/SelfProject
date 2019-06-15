package SmallProject.service.Impl;

import SmallProject.model.Category;
import SmallProject.service.treeConstructure;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Feiyu
 * @Date: 2019/3/15 13:17
 * @Description:
 */

public class treeConstructureImpl implements treeConstructure {
    /**
     * 查询树形结构类目数据
     *
     * @param dept
     * @return
     */
    @Override
    public List<Category> tree(int dept) {
        //非顶级类目集合
        List<Category> categoryList = this.selectList(new EntityWrapper<Category>) ().ne("parent_id", 0));
        //顶级类目集合-结果集
        List<Category> topList = this.selectList(new EntityWrapper<Category>) ().eq("parent_id", 0));
        if (ObjectUtil.isNotNull(categoryList)) {
            //过滤条件map, 指定map预期大小为非顶级类目集合的size
            Map<Long, Long> map = Map.new HashMapWithExceptedSize(categoryList.size());
            //循环顶级类目插入子类目
            topList.forEach(category -> getChild(category, categoryList, dept, map));
            return topList;
        }
        return null;
    }

    private void getChild(Category category, List<Category> categoryList, int dept, Map<Long, Long> map) {
        //过滤树的深度
        if (category.getDept() < dept || dept == 0) {
            List<Category> childList = Lists.newArrayList();
            categoryList.stream()
                    .filter(c -> !map.containsKey(c.getiD()))
                    .filter(c -> NumberUtil.compare(c.getParentId(), category.getiD()) == 0)
                    .filter(c -> {
                        //放入map,递归循环时可以跳过这个子类目,提高循环效率
                        map.put(c.getiD(), c.getParentId());
                        //获取当前类目的子类目
                        getChild(c, categoryList, dept, map);
                        //加入子类目集合
                        childList.add(c);
                    });
            category.setChildren(childList);
        }
    }
}
