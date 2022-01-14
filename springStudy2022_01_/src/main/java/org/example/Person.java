package org.example;

public class Person {
    //证明反射调用无参的构造方法
//    private Person(){
//        System.out.println("调用了无参的构造方法");
//    }
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
