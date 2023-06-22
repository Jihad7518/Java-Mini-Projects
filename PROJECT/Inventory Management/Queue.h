
#ifndef INVENTORY_MANAGEMENT_QUEUE_H
#define INVENTORY_MANAGEMENT_QUEUE_H

#include <iostream>
#include "Order.h"
using namespace std;

class Node {
public:

    Order order;
    Node *next;

    Node(Order order){
        this->order = order;
        next = NULL;
    }

};


class Queue {

    public:
        Node * front;
        Node* rear;

        Queue(){
            front = NULL;
            rear = NULL;
        }

        bool isEmpty(){

            if(front == NULL && rear == NULL)
                return true;
            else
                return false;
        }

        void enquey(Order val){

            Node *newNode = new Node(val);

            if (front == NULL)
            {
                front = newNode;
                rear = newNode;

            } else {
                rear->next = newNode; //adding node to rear next or in the end.
                rear = newNode; //Updating rear.
            }
        }

        Order dequey(){

            if(isEmpty())
                cout<<"Underflow";
            else{
                Order dt = Order();
                //only one element/node in queue.
                if(front == rear)
                {
                    dt = front->order;
                    delete(front);
                    front = rear = NULL;
                    return dt;
                }
                else
                {   dt = front->order;
                    Node *temp = front;
                    front = front->next;
                    delete(temp);
                    return  dt;
                }
            }
        }

        int size(){
            int count = 0;
            if(!isEmpty()){

                Node* temp = front;

                while (temp !=NULL)
                {   count++;
                    temp = temp->next;
                }
                return count;
            }
            else
                return count;



        }

        void displayOrder() {

            if (isEmpty())
                cout<<"No Order!\n";
            else
            {
                Node *temp = front;
                while( temp !=NULL)
                {
                    cout<<temp->order.getOrderId()<<" ";
                    temp= temp->next;
                }
                cout << endl;
            }
        }

        Queue* CopyQueue() {

            Queue *q2 = new Queue();

            while(front!=NULL)
            {

                Order data = front->order;
                q2->enquey(data);
                front = front->next;
            }
            return q2;
        }

        Node* peek(){
            return front;
        }

        Order getFront(){
            if(!isEmpty())
                return (front->order);
        }


};


#endif //INVENTORY_MANAGEMENT_QUEUE_H
