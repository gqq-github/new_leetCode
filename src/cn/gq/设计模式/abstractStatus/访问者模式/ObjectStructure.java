package cn.gq.设计模式.abstractStatus.访问者模式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cherry_xx
 * @create 2021/7/3 13:03
 * @update 2021/7/3
 * Description:
 * @since 1.0.0
 */
public class ObjectStructure {
    private List<Element> elements = new ArrayList<>();

    public void add(Element element) {
        elements.add(element);
    }
    public void remove(Element element) {
        elements.remove(element);
    }

    public ObjectStructure(Element... element) {
        elements.addAll(Arrays.asList(element));
    }
    public  void accept(Visitor visitor) {
        elements.forEach(element -> element.accept(visitor));
    }
}
