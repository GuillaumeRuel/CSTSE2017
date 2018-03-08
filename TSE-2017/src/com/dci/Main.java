package com.dci;

import com.dci.console.Base64Decoder;
import com.dci.console.CommandFactory;

import java.util.Base64;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("May I take your order?");
        String customerCommand = scanner.nextLine();

        CommandFactory.createCommand(customerCommand);
    }
}
