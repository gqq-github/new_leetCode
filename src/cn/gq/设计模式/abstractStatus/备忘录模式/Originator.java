package cn.gq.设计模式.abstractStatus.备忘录模式;

/**
 * @author cherry_xx
 * @create 2021/7/3 14:04
 * @update 2021/7/3
 * Description:
 * @since 1.0.0
 */
public class Originator {
    private String state;
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public Memento createMemento() {
        return new Memento(state);
    }
    public void restoreMemento(Memento m) {
        this.setState(m.getState());
    }
}
