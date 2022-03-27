package cn.gq.设计模式.abstractStatus.备忘录模式;

/**
 * @author cherry_xx
 * @create 2021/7/3 14:02
 * @update 2021/7/3
 * Description: 用来管理备忘录对象
 * @since 1.0.0
 */
public class CareTaker {
    public Memento memento;

    public CareTaker() {
    }

    public Memento getMemento() {
        try {
            return memento;
        }finally {
            memento = memento.getPreMemento();
        }
    }

    public void setMemento(Memento memento) {
        setPreMemento(memento);
        this.memento = memento;
    }
    public void setPreMemento(Memento memento){
        memento.setPreMemento(this.memento);
    }
}

