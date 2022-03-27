package cn.gq.设计模式.abstractStatus.备忘录模式;

/**
 * @author cherry_xx
 * @create 2021/7/3 14:00
 * @update 2021/7/3
 * Description: 备忘录对象 记录状态
 * @since 1.0.0
 */
public class Memento {
    private String state;
    private Memento preMemento;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento getPreMemento() {
        return preMemento;
    }

    public void setPreMemento(Memento preMemento) {
        this.preMemento = preMemento;
    }
}
