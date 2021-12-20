package com.nure.bearer.Adapter;

import java.util.List;

public class Machine {
    private String name;
    private String location;
    private List<Cell> listOfCells;

    public Machine(String name, String location, List<Cell> listOfCells) {
        this.name = name;
        this.location = location;
        this.listOfCells = listOfCells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Cell> getListOfCells() {
        return listOfCells;
    }

    public void setListOfCells(List<Cell> listOfCells) {
        this.listOfCells = listOfCells;
    }
}
