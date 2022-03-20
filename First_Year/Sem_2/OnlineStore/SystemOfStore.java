package ru.kpfu.classwork.OnlineStore;


import java.util.Arrays;
import java.util.Scanner;

public class SystemOfStore {
    private Product[] store=new Product[10];
    private int numberProducts=0;
    private int index=0;



    public boolean addProduct(Product product){
        store[numberProducts]=product;
        numberProducts++;
        return true;
    }
    private boolean isEmpty(){
        return numberProducts == 0;
    }

    public SystemOfStore() {
    }
    public boolean Search(Product product){
        for (Product s:store) {
            if (s.getId()==product.getId()){
                System.out.println(s.toString());
                return true;
            }
        }
        System.out.println("The product is not in the store");
        return false;
    }
    public boolean remove(Product product){
        int index=0;
        for (Product s:store) {
            if (s.getId()==product.getId()){
                store[index]=null;
                return true;
            }
            index++;
        }
        return false;
    }
    private boolean isAvailableForBuy(Product product){
        return product.getQuantity() != 0;
    }
    public boolean buy(Product product,int money){
        if (isAvailableForBuy(product)){
                product.setOrders();
                if (buying(money)) {
                    product.setPlaces(Product.places.In_Shipping);
                    product.setNegativeQuantity();
                    return true;
                }
        }
        return false;
    }
    private boolean buying(int money){
        Scanner S=new Scanner(System.in);
        System.out.println("how you want to buy :"+
                            "\n VISA\\MASTERCARD enter 1 "+
                              "\n Electronic currencies enter 2 "+
                               "\n cache from one of our branches enter 3 "+
                                "\n for cancel 4 ");
        int way=S.nextInt();
        while (way!=1&&way!=2&&way!=3&&way!=4){
            System.out.println("This is not true\n try aging");
            way=S.nextInt();
        }
        switch (way){
            case 1:
                buyThroughVisa();break;
            case 2:
                buyThroughEle();break;
            case 3:
                buyThroughCache();break;
            case 4:
                return false;
        }
        return true;
    }
    private void buyThroughVisa(){
        System.out.println("hello world");
    }
    private void buyThroughEle(){
        System.out.println("hello world");
    }
    private void buyThroughCache(){
        System.out.println("hello world");
    }
    public boolean addToBlackList(Product product){




        return true;
    }
    public boolean removeInBlackList(Product product){




        return true;
    }

    @Override
    public String toString() {
        return "SystemOfStore{" +
                "numberProducts=" + numberProducts +
                " , store=" + Arrays.toString(store) +
                '}';
    }
}
