cmake_minimum_required(VERSION 3.21)
project(Inventory_Management)

set(CMAKE_CXX_STANDARD 14)

add_executable(Inventory_Management main.cpp Product.h List.h Order.h Queue.h Stack.h)
