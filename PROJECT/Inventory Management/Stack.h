
#ifndef INVENTORY_MANAGEMENT_STACK_H
#define INVENTORY_MANAGEMENT_STACK_H

#include <iostream>
using namespace std;
#include "Product.h"

class Node1 {

public:

    Product data;
    Node1 *next;

    Node1(Product data){
        this->data = data;
        next = NULL;
    }


};

class Stack {

public:
    Node1 * top;

    Stack(){
        top = NULL;
    }

    void push(Product val){
        Node1 *newNode = new Node1(val);


        if(top == NULL){
            top = newNode;
        } else {
            newNode->next = top;
            top = newNode;
        }

    }

    //remove from stack
    Product pop(){

        if (top == NULL)
        {
            cout<<"Underflow"<<endl;
        } else {
            Product topData = top->data;
            Node1 *temp = top;
            top = top->next;
            delete(temp);
            return topData;
        }

    }

    //Get stack top data
    Product StackTop(){
        if(!isEmpty()) {

            return top->data;
        } else
            cout << "Underflow ";

    }

    //empty or have data
    bool isEmpty(){
        if(top==NULL) return true;
        else return false;

    }

    //display all in stack
    void display(){

        Node1 *nextNode = top;
        while (nextNode!= NULL)
        {
            cout << nextNode->data.getId() <<" | ";
            nextNode = nextNode->next;
        }
        cout << endl;
    }

    //search product by order Month and Year.
    Product searchByMonthYr(int month, int year)
    {
        Node1 *nextNode = top;
        while (nextNode!= NULL)
        {
            if (nextNode->data.getSellingDate()->tm_mon == month && nextNode->data.getSellingDate()->tm_year+1900 == year)
                return nextNode->data;


            nextNode = nextNode->next;
        }
        cout << endl;
    }

    //print function for month
    void printMonth(int i){


            switch (i) {

                case 0:
                    cout << "==================================== January 2022  =====================================" << endl;
                    cout <<"\n---------------------------------------------------------------------------------------"<< endl;
                    cout <<"\t\tDate\t\t\tID\t\t\t\tName\t\t\t\t\tPrice\t\tQuantity";
                    cout <<"\n---------------------------------------------------------------------------------------"<< endl;
                    break;
                case 1:
                    cout << "========= February 2022  ===========" << endl;
                    cout <<"\n-----------------------------"<< endl;
                    cout <<"Sr.\tID\t\tName";
                    cout <<"\n-----------------------------"<< endl;
                    break;
                case 2:
                    cout << "========= March 2022  ===========" << endl;
                    cout <<"\n-----------------------------"<< endl;
                    cout <<"Sr.\tID\t\tName";
                    cout <<"\n-----------------------------"<< endl;
                    break;
                case 3:
                    cout << "========= April 2022  ===========\n" << endl;
                    cout <<"\n-----------------------------"<< endl;
                    cout <<"Sr.\tID\t\tName";
                    cout <<"\n-----------------------------"<< endl;
                    break;
                case 4:
                    cout << "========= May 2022  ===========\n" << endl;
                    cout <<"\n-----------------------------"<< endl;
                    cout <<"Sr.\tID\t\tName";
                    cout <<"\n-----------------------------"<< endl;
                    break;
                case 5:
                    cout << "========= June 2022  ===========\n" << endl;
                    cout <<"\n-----------------------------"<< endl;
                    cout <<"Sr.\tID\t\tName";
                    cout <<"\n-----------------------------"<< endl;
                    break;
                case 6:
                    cout << "========= July 2022  ===========\n" << endl;
                    cout <<"\n-----------------------------"<< endl;
                    cout <<"Sr.\tID\t\tName";
                    cout <<"\n-----------------------------"<< endl;
                    break;
                case 7:
                    cout << "========= August 2022  ===========\n" << endl;
                    cout <<"\n-----------------------------"<< endl;
                    cout <<"Sr.\tID\t\tName";
                    cout <<"\n-----------------------------"<< endl;
                    break;
                case 8:
                    cout << "========= September 2022  ===========\n" << endl;
                    cout <<"\n-----------------------------"<< endl;
                    cout <<"Sr.\tID\t\tName";
                    cout <<"\n-----------------------------"<< endl;
                    break;
                case 9:
                    cout << "========= October 2022  ===========\n" << endl;
                    cout <<"\n-----------------------------"<< endl;
                    cout <<"Sr.\tID\t\tName";
                    cout <<"\n-----------------------------"<< endl;
                    break;
                case 10:
                    cout << "========= November 2022  ===========\n" << endl;
                    cout <<"\n-----------------------------"<< endl;
                    cout <<"Sr.\tID\t\tName";
                    cout <<"\n-----------------------------"<< endl;
                    break;
                case 11:
                    cout << "========= December 2022  ===========\n" << endl;
                    cout <<"\n-----------------------------"<< endl;
                    cout <<"Sr.\tID\t\tName";
                    cout <<"\n-----------------------------"<< endl;
                    break;

        }
    }

    //print monthly Sell product
    void displayMonthlyData() {
        Node1 *nextNode = top;
        double total = 0.0;
        bool flag = true;

        while (nextNode != NULL) {
            int month = nextNode->data.getSellingDate()->tm_mon;
            int year = (nextNode->data.getSellingDate()->tm_year + 1900);

            if (month == 0 && year == 2022) {
                if (flag) {
                    flag = false;
                    printMonth(month);
                }
                cout
                    << "\t\t" << nextNode->data.getSellingDate()->tm_mday
                   <<"/" <<nextNode->data.getSellingDate()->tm_mon+1 <<
                   "/"<<nextNode->data.getSellingDate()->tm_year+1900
                    << "\t\t" << nextNode->data.getId()
                     << "\t\t\t" << nextNode->data.getName()
                     << "\t\t\t" << nextNode->data.getPrice()*nextNode->data.getQty()
                     << "\t\t\t" << nextNode->data.getQty() <<endl;

                total += nextNode->data.getPrice()*nextNode->data.getQty();

                nextNode = nextNode->next;
            }
        }
        cout <<"\n---------------------------------------------------------------------------------------"<< endl;
        cout << "\t\t\t\t\t\t\t\tTotal Sell on this month: $" << total << endl;
    }

    //print last 5 sell
    void displayLastFiveSell(){

        int count = 1;
        Node1 *nextNode = top;
        cout <<"\n-----------------------------"<< endl;
        cout <<"\tID\t\tName";
        cout <<"\n-----------------------------"<< endl;

        while (nextNode!= NULL)
        {
            if(count<=5) {
                cout << count << ". \t" << nextNode->data.getId()
                     << "\t\t" << nextNode->data.getName() <<endl;
                count++;
                nextNode = nextNode->next;
            } else
                break;
        }

    }

    //total selling item
    int size(){
        int count = 0;
        if(top!=NULL){

            Node1 *temp = top;
            while (temp!=NULL)
            {
                count++;
                temp = temp->next;
            }
        }
        return count;
    }
};

#endif //INVENTORY_MANAGEMENT_STACK_H
