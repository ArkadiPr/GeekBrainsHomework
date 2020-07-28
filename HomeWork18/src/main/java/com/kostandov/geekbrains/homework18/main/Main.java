package com.kostandov.geekbrains.homework18.main;

import com.kostandov.geekbrains.homework18.data.PrepareDataApp;
import com.kostandov.geekbrains.homework18.entitys.Customer;
import com.kostandov.geekbrains.homework18.entitys.Item;
import com.kostandov.geekbrains.homework18.service.CustomersAndItemsService;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PrepareDataApp.forcePrepareData();

        CustomersAndItemsService customersAndItemsService=new CustomersAndItemsService();
        boolean readLine=true;
        String nextLine;
        String[] commandAndArgument;

        Scanner scanner=new Scanner(System.in);
        String argument=" ";

        while (readLine){
            nextLine=scanner.nextLine();
            commandAndArgument=nextLine.split(" ",2);

            String command=commandAndArgument[0];
            if(commandAndArgument.length==2){
                argument=commandAndArgument[1];
            }


            switch (command){
                case "showProductsByConsumer":
                    List<Item> items= customersAndItemsService.showProductsByConsumer(argument);
                    for(Item item:items){
                        System.out.println(item);
                    }
                    break;
                case  "showConsumersByProductTitle":
                    List<Customer> customers= customersAndItemsService.showConsumersByProductTitle(argument);
                    for(Customer customer1:customers){
                        System.out.println(customer1);
                    }
                    break;
                case "deleteConsumer":
                    customersAndItemsService.deleteConsumer(argument);
                    break;
                case "deleteProduct":
                    customersAndItemsService.deleteProduct(argument);
                    break;
                case "buy":
                    String[] idArguments=argument.split(" ",2);
                    try {
                        customersAndItemsService.buy(Long.parseLong(idArguments[0]),Long.parseLong(idArguments[1]));
                    }catch (Exception e){
                        System.out.println("Please input correct arguments.");
                    }

                    break;
                case "exit":
                    readLine=false;
                    break;
                default:
                    System.out.println("Input correct command please!");

            }

        }

    }
}
