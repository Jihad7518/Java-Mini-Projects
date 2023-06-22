#include <iostream>
using namespace std;
#include "List.h"
#include "Product.h"
#include "Order.h"
#include "Queue.h"
#include "Stack.h"
#include <string>


//All List declared globally
List* list  = new List();
Queue* queue = new Queue();
Stack* stack = new Stack();

//function Prototype
string randID();
void adminMenu();
void mainMenu();

//fun for creating order
Order createAnOrder(Order order){
    string id;
    int qty;
    cout << "Enter Product ID: ";
    cin >> id;
    Product pd = list->searchByProductID(id);
    cout << "Enter Quantity: ";
    cin >> qty;
    cout << "You ordered for: " << pd.getName() << endl;
    pd.setQty(qty);
    order.addOrderedProduct(pd);
   list->decreaseQty(id,qty);

    //storing ordered product in stack.
    stack->push(pd);
    return order;
}

//fun for Placing order
void placeAnOrder(){
    char op,opt ='y';
    list->displayAllProduct();
    cout << "Do want place an order? y/n --> ";
    cin >> op;
    if (tolower(op) =='y'){
        Order order = Order();
        order.setOrderId(randID());
        order = createAnOrder(order);
        while (tolower(opt) =='y'){
            cout << "Do you want to order again ? y/n-->";
            cin >> opt;
            if (tolower(opt)=='y')
                order = createAnOrder(order);
        }
        //show invoice
        order.getInvoice();
        //insert order customer's order information in Queue.
        queue->enquey(order);

    }
}

//Main function
int main() {

    list->createCategory("Electronics");
    mainMenu();

    return 0;
}


//Main Menu
void mainMenu(){
    int option;
    bool stop = false;

    do {

        cout
                << endl <<"1.Admin" << endl
                << "2.Customer" << endl
                << "3.Exit" << endl;

        cout << "Select you option: ";
        cin >> option;

        switch (option) {
            case 1:
                adminMenu();
                break;
            case 2:
                placeAnOrder();
                break;
            case 3:
                stop = true;
                break;

        }

    } while (!stop);


}

//Admin menu
 void adminMenu() {

    string catName;
    int option;
    bool stop = false;

    do {
        cout
                << "\n1.Create Category" << endl
                << "2.Insert Item" << endl
                << "3.Display All Item" << endl
                << "4.Order List" << endl
                << "5.Last sold Items" << endl
                << "6.Monthly Sell Data" << endl
                << "7.Go to Main" << endl;


        cout << "Select you option: ";
        cin >> option;

        switch (option) {
            case 1:
                list->displayCategory();
                cout << "Enter Category Name: ";
                cin>>catName;
                list->createCategory(catName);
                break;
            case 2:
                list->insertProduct();
                break;
            case 3:
                list->displayAllProduct();
                break;
            case 4:
                queue->displayOrder();
                break;
            case 5:
                stack->displayLastFiveSell();
                break;
            case 6:
                stack->displayMonthlyData();
                break;
           case 7:
               stop = true;
                mainMenu();
                break;
        }

    } while (!stop);

}

//Random ID Generator
string randID() {

    string id = "";
    // srand(time(NULL));
    int random = rand()%9999;
    id ="OR"+to_string(random);
    return id;
}


