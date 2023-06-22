
#ifndef INVENTORY_MANAGEMENT_LIST_H
#define INVENTORY_MANAGEMENT_LIST_H

#include <iostream>
using namespace std;
#include <ctime>
#include "Product.h"
#include <algorithm>

class PDNode{

public:

    Product product;
    PDNode* pdNext;

      PDNode(Product product){
        this->product = product;
        pdNext = NULL;
    }

};

class CTGNode{

public:
    string ctgName;
    string id;
    CTGNode* prev;
    PDNode* next;

    CTGNode(string ctgName){

        this->ctgName = ctgName;
        this->id = randID();
        this->prev = NULL;
        this->next = NULL;
    }

    const string &getId() const {
        return id;
    }

    void setId(const string &id) {
        CTGNode::id = id;
    }

    string randID() {

        string id = "";
        srand(time(NULL));
        int random = rand()%9999;
        id ="CTG"+to_string(random);
        return id;
    }

};

class List {
    CTGNode * head;
public:

    List(){
        this->head = NULL;
    }

    //Create a category to insert product
    void createCategory(string name){

        CTGNode* newCTGNode = new CTGNode(name);

        if(head == NULL){
            head = newCTGNode;
        } else {

            CTGNode* temp = head, *end = head;

            while (temp!= NULL)
            {
                end = temp;
                temp = temp->prev;
            }
            end->prev = newCTGNode;
        }
    }

    //insert product after creating category if is not created before.
    void insertProduct() {

        if(head == NULL){
            cout << "No category found. Please create a category first.";
        } else {

            displayCategory();
            string  catID;
            //Searching Category
            cout <<"Enter Category ID: ";
             cin>> catID;
            CTGNode *temp = head;

            while (temp!=NULL)
            {
                if (temp->id == stringToUpper(catID))
                {
                    Product product = createProduct();
                    PDNode* newPDNode = new PDNode(product);
                    PDNode* head1 = temp->next;
                    if(head1 == NULL){
                        temp->next = newPDNode;
                    } else {

                        PDNode* temp1 = head1, *end;

                        while (temp1 != NULL)
                        {
                            end = temp1;
                            temp1 = temp1->pdNext;
                        }
                        end->pdNext = newPDNode;
                    }
                }
                temp = temp->prev;
            }
        }
    }

    //creating product method for code simplicity
    Product createProduct(){

        string name;
        string id;
        double price;
        int qty;

        Product product =  Product();

        cout << "Enter Product ID: ";
        cin >> id;
        product.setId(id);
        cout << "Enter Product Name: ";
        cin >> name;
        product.setName(name);
        cout << "Enter Price: ";
        cin >> price;
        product.setPrice(price);
        cout << "Enter Quantity: ";
        cin >> qty;
        product.setQty(qty);

        return product;
    }

    //display available category in the list.
    void displayCategory(){

        CTGNode *nextNode = head;

        cout << "Category: \n";
        while (nextNode!= NULL)
        {
            cout <<"" << nextNode->id <<" | Name: "<<nextNode->ctgName <<endl;
            nextNode = nextNode->prev;
        }
        cout << endl;
    }

    //display all product by category.
    void displayAllProduct() {

       CTGNode *nextNode = head;
       PDNode *pdHead = head->next;
        cout << "\n==================================== ALL ITEMS =======================================" << endl;
        cout << "\n--------------------------------------------------------------------------------------" << endl;
        cout << "Category\t\t\t\tID\t\t\t\tName\t\t\t\t\tPrice\t\t\tQty";
        cout << "\n--------------------------------------------------------------------------------------" << endl;
       while (nextNode != NULL)
       {
           //product print

                while (pdHead != NULL) {
                    cout << "\n" << nextNode->id <<" | "<< nextNode->ctgName;
                    cout <<"\t\t"<< pdHead->product.getId()
                     << "\t\t\t\t"<<pdHead->product.getName()
                    << "\t\t\t\t"<<pdHead->product.getPrice()
                     << "\t\t\t\t"<<pdHead->product.getQty() <<endl;


                    pdHead = pdHead->pdNext;
            }
                //next category
           nextNode = nextNode->prev;
                if(nextNode!=NULL)
                    pdHead = nextNode->next; //next product
          cout << "\n--------------------------------------------------------------------------------------" << endl;
       }
       cout << endl;

    }

    //search product by id
    Product searchByProductID(string id){

        CTGNode *nextNode = head;
        PDNode *pdHead = head->next;

        while (nextNode != NULL)
        {

            while (pdHead != NULL) {

                if(pdHead->product.getId()==id)
                    return pdHead->product;


               pdHead = pdHead->pdNext;
            }
            nextNode = nextNode->prev;
            if(nextNode!=NULL)
                pdHead = nextNode->next;
        }

    }

    void  decreaseQty(string id, int qty) {

        int existQTy;
        CTGNode *nextNode = head;
        PDNode *pdHead = head->next;

        while (nextNode != NULL)
        {

            while (pdHead != NULL) {

                if(pdHead->product.getId()==id) {
                    existQTy = pdHead->product.getQty()-qty;
                    pdHead->product.setQty(existQTy);
                }
                pdHead = pdHead->pdNext;
            }
            nextNode = nextNode->prev;
            if(nextNode!=NULL)
                pdHead = nextNode->next;
        }
    }

    //make string upper
    string stringToUpper(string s){
        transform(s.begin(),s.end(), s.begin(),::toupper);
        return s;
    }


};


#endif //INVENTORY_MANAGEMENT_LIST_H
