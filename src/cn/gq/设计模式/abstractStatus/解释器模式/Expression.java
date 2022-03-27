package cn.gq.设计模式.abstractStatus.解释器模式;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author cherry_xx
 * @create 2021/7/3 21:15
 * @update 2021/7/3
 * Description: 抽象一个一个解释器对象
 * @since 1.0.0
 */
public abstract class Expression {
    protected abstract boolean interpret(String  info);
}
class CityExpression extends  Expression{
    private HashSet<String> cites = new HashSet<>();
    public CityExpression (String... city) {
        cites.addAll(Arrays.asList(city));
    }
    public void add(String city) {
        cites.add(city);
    }
    public void remove (String city) {
        cites.remove(city);
    }
    @Override
    protected boolean interpret(String info) {
        return cites.contains(info);
    }
}

class PersonExpression extends Expression  {
    private HashSet<String> persons = new HashSet<>();
    @Override
    protected boolean interpret(String info) {
        return persons.contains(info);
    }

    public PersonExpression(String...person) {
        persons.addAll(Arrays.asList(person));
    }
    public void add(String person) {
        persons.add(person);
    }
    public void remove(String person) {
        persons.remove(person);
    }
}

class PersonAndCityExpression extends Expression{
    private String split;
    private PersonExpression personExpression;
    private CityExpression cityExpression;

    public PersonAndCityExpression(String split, String [] cities, String [] persons) {
        this.split = split;
        this.personExpression = new PersonExpression(persons);
        this.cityExpression = new CityExpression(cities);
    }

    public String getSplit() {
        return split;
    }

    public void setSplit(String split) {
        this.split = split;
    }

    public PersonExpression getPersonExpression() {
        return personExpression;
    }

    public void setPersonExpression(PersonExpression personExpression) {
        this.personExpression = personExpression;
    }

    public CityExpression getCityExpression() {
        return cityExpression;
    }

    public void setCityExpression(CityExpression cityExpression) {
        this.cityExpression = cityExpression;
    }

    @Override
    protected boolean interpret(String info) {
        String[] split = info.split(this.split);
        return cityExpression.interpret(split[0])&&personExpression.interpret(split[1]);
    }
}
