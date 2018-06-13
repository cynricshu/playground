// Copyright (C) 2018 Baidu Inc. All rights reserved.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.example.tutorial.AddressBookProtos.AddressBook;

/**
 * Grpc
 *
 * @author Shu Lingjie(shulingjie@baidu.com)
 */
public class Protobuf {
    public static void main(String[] args) {
        String filePath = "test.txt";
        writeMessageToFile(filePath);
        readMessageFromFile(filePath);
    }

    public static void writeMessageToFile(String filePath) {
        AddressBook.Builder addressBook = AddressBook.newBuilder();
        addressBook.addPeople(AddressUtil.generatePerson());
        addressBook.addPeople(AddressUtil.generatePerson());
        addressBook.addPeople(AddressUtil.generatePerson());

        try {
            addressBook.build().writeTo(new FileOutputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readMessageFromFile(String filePath) {
        try {
            AddressBook addressBook = AddressBook.parseFrom(new FileInputStream(filePath));
            AddressUtil.print(addressBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
