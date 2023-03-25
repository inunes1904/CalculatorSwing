package com.ivonunes.model;

public interface MemoryObserver {

    default void valueChanged(String value){};
}
