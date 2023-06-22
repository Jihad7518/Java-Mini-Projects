

#ifndef INVENTORY_MANAGEMENT_ORDER_H
#define INVENTORY_MANAGEMENT_ORDER_H
#include "Product.h"
#include <string>
#include <vector>
#include <ctime>
using namespace std;

class Order{
    string orderID;
    vector<Product> item;
    double bill;
    time_t now;
    tm *purchaseDate;
    bool isDelivered;

public:

    Order(){
        this->bill = 0.0;
        now = time(0);
        purchaseDate = localtime(&now);
    }

    tm *getPurchaseDate() const {
        return purchaseDate;
    }

    const vector<Product> &getItem() const {
        return item;
    }

    void addOrderedProduct(Product product){
       item.push_back(product);
    }


    const string &getOrderId() const {
        return orderID;
    }

    void setOrderId(const string &orderId) {
        orderID = orderId;
    }

    void setBill(double bill) {
        Order::bill = bill;
    }

    bool isDelivered1() const {
        return isDelivered;
    }

    void setIsDelivered(bool isDelivered) {
        Order::isDelivered = isDelivered;
    }

    double getBill(){

        for(int i =0; i< item.capacity(); i++){
            bill += (item[i].getPrice()*item[i].getQty());
        }
        return bill;
    }

    void getInvoice(){
        cout << "\n==================== Invoice ======================\n";
        cout << "Purchase Date: "
        << purchaseDate->tm_mday
        <<"/" <<purchaseDate->tm_mon+1 <<
        "/"<<purchaseDate->tm_year+1900 << endl;
        cout << "----------------------------------------------------\n";
        cout << "Item Name\t\tPrice\tQuantity"<< endl;
        cout << "----------------------------------------------------\n";

        for(int i =0; i<item.capacity(); i++)
            cout <<item[i].getName() << "\t\t" << item[i].getPrice()  <<"\t\t" << item[i].getQty() << endl;

        cout << "----------------------------------------------------\n";
        cout << "\t\t\t\tTotal: $" << getBill() <<endl;

        cout << "================= Happy Shopping! =====================\n";
    }


};


#endif //INVENTORY_MANAGEMENT_ORDER_H
