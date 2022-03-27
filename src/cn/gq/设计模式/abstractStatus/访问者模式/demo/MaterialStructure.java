package cn.gq.设计模式.abstractStatus.访问者模式.demo;

import cn.gq.设计模式.abstractStatus.访问者模式.Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cherry_xx
 * @create 2021/7/3 13:32
 * @update 2021/7/3
 * Description:
 * @since 1.0.0
 */
public class MaterialStructure {
    private List<Material> materials = new ArrayList<>();

    public void add(Material material) {
        materials.add(material);
    }
    public void remove (Material material) {
        materials.remove(material);
    }
    public MaterialStructure(Material... material) {
        materials.addAll(Arrays.asList(material));
    }
    public void accept(Company company){
        materials.forEach(material -> {
            material.accept(company);
        });
    }
}
