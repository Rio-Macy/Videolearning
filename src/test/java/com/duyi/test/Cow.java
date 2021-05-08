package com.duyi.test;


// implements Comparable<Cow>
public class Cow implements Comparable<Cow> {

    private Integer id;
    private String name;

    public Cow() {
    }

    public Cow(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    @Override
    public int compareTo(Cow o) {

        int value = this.id.compareTo(o.id);

        if (value != 0) {

            return value;
        }

        return this.id - o.id;
    }
}
