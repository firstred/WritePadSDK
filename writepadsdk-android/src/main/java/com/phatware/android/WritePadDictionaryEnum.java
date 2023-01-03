package com.phatware.android;

public enum WritePadDictionaryEnum {
    none(0);
    private int id;

    WritePadDictionaryEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}