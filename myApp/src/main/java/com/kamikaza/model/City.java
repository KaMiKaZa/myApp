package com.kamikaza.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "cities")
public class City implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "population")
    private int population;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getPopulation() { return population; }

    public void setPopulation(int population) { this.population = population; }

    @Override
    public String toString()
    {
        return String.format("City[id=%d, name=%s, population=%d]", this.id, this.name, this.population);
    }
}
