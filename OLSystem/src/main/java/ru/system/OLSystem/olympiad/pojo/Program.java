package ru.system.OLSystem.olympiad.pojo;

public class Program {

    private String nameProgram;
    private String textProgram;

    public Program(String nameProgram, String textProgram) {
        this.nameProgram = nameProgram;
        this.textProgram = textProgram;
    }

    public String getNameProgram() {
        return nameProgram;
    }

    public void setNameProgram(String nameProgram) {
        this.nameProgram = nameProgram;
    }

    public String getTextProgram() {
        return textProgram;
    }

    public void setTextProgram(String textProgram) {
        this.textProgram = textProgram;
    }
}
