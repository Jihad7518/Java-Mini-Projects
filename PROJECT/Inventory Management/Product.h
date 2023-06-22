
#ifndef INVENTORY_MANAGEMENT_PRODUCT_H
#define INVENTORY_MANAGEMENT_PRODUCT_H


class Product {

    string id;
    string name;
    double price;
    time_t now;
    tm *sellingDate;
    int qty;

public:


    Product(){//empty
        now = time(0);
        sellingDate = localtime(&now);
         }

    Product(string id, string name, double price, int qty){
        this->id = id;
        this->name = name;
        this->price = price;
        this->qty = qty;
    }

    tm *getSellingDate() const {
        return sellingDate;
    }

    const string &getId() const {
        return id;
    }

    void setId(const string &id) {
        Product::id = id;
    }

    const string &getName() const {
        return name;
    }

    void setName(const string &name) {
        Product::name = name;
    }

    double getPrice() const {
        return price;
    }

    void setPrice(double price) {
        Product::price = price;
    }

    int getQty() const {
        return qty;
    }

    void setQty(int qty) {
        Product::qty = qty;
    }


};


#endif //INVENTORY_MANAGEMENT_PRODUCT_H
