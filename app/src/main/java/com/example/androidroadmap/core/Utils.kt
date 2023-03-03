package com.example.androidroadmap.core

object Utils {

    fun isNotLastItemInList(index: Int, list: List<*>): Boolean {
        return (index + 1) < list.size
    }
}