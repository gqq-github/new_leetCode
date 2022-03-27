package cn.gq.设计模式.abstractStatus.中介者模式;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cherry_xx
 * @create 2021/6/28 21:41
 * @update 2021/6/28
 * Description: 定义一个抽象的中介者，
 * 使用中介者来实现一对多的关系
 * 就是将对应的中介者和对应的关联对象
 * @since 1.0.0
 */
public abstract class Mediator {
    // 注册对应的关联对象
    protected abstract void register(Colleague colleague);

    // 处理多对象需要怎么处理
    protected abstract void relay(Colleague colleague);
}

class ConcreteMediator extends  Mediator{
    private List<Colleague> colleagueList;
    public ConcreteMediator() {
        colleagueList = new ArrayList<>();
    }

    @Override
    protected void register(Colleague colleague) {
        colleagueList.add(colleague);
        colleague.setMediator(this);
    }

    @Override
    protected void relay(Colleague colleague) {
        colleagueList.stream().filter(colleague1 -> colleague1 != colleague).collect(Collectors.toList()).forEach(Colleague::receive);
    }
}