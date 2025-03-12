package Ui;

import Domain.SoftwareInstrument;
import Domain.HardwareInstrument;
import Service.Service;

import java.util.Scanner;

public class Ui {
    private final Service softwareHardwareInstrumentService;
    private final Scanner scanner;

    public Ui(Service softwareHardwareInstrumentService) {
        this.softwareHardwareInstrumentService = softwareHardwareInstrumentService;
        this.scanner = new Scanner(System.in);
    }

    private SoftwareInstrument readingSoftwareInstrument() {
        System.out.print("The code:");
        String code = scanner.nextLine();
        System.out.print("Maintenance (true/false):");
        boolean maintenance = scanner.nextBoolean();
        scanner.nextLine();
        System.out.print("Version:");
        int version = scanner.nextInt();
        scanner.nextLine();

        return new SoftwareInstrument(code, maintenance, version);
    }

    private HardwareInstrument readingHardwareInstrument() {
        System.out.print("The code:");
        String code = scanner.nextLine();
        System.out.print("Maintenance (true/false):");
        boolean maintenance = scanner.nextBoolean();
        scanner.nextLine();
        System.out.print("MeasurementType (altitudine, directie or stare_motor):");
        String measurementType = scanner.nextLine();
        while(!measurementType.equals("altitudine") && !measurementType.equals("directie") && !measurementType.equals("stare_motor")) {
            System.out.println("Invalid measurementType. Type altitudine, directie or stare_motor:");
            measurementType = scanner.nextLine();
        }

        return new HardwareInstrument(code, maintenance, measurementType);
    }

    public void printMenu(){
        System.out.println("=====SoftwareInstrument functions=====");
        System.out.println("1. Add SoftwareInstrument");
        System.out.println("2. Print All SoftwareInstrument");
        System.out.println("=====HardwareInstrument functions=====");
        System.out.println("3. Add HardwareInstrument");
        System.out.println("4. Print All HardwareInstrument");
        System.out.println("0. Exit");
        System.out.print("Type your option:");
    }

    public void start(){
        while(true){
            printMenu();
            int option;

            try {
                option = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch(option){
                case 1 -> addSoftwareInstrument();
                case 2 -> printSoftwareInstruments();
                case 3 -> addHardwareInstrument();
                case 4 -> printAllHardwareInstruments();
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("!! Invalid option !!\n");
            }
        }
    }

    //Software Functions
    void addSoftwareInstrument(){
        SoftwareInstrument manuscript = readingSoftwareInstrument();
        softwareHardwareInstrumentService.addSoftwareInstrument(manuscript);
    }
    void printSoftwareInstruments(){
        System.out.println("How to read the information: Software Instrument, Code, Maintenance, Version, Price");
        for(SoftwareInstrument s : softwareHardwareInstrumentService.getSoftwareInstruments()){
            System.out.println(s.toString()+","+s.getPrice());
        }
    }

    //Hardware functions
    void addHardwareInstrument(){
        HardwareInstrument hardwareInstrument = readingHardwareInstrument();
        softwareHardwareInstrumentService.addHardwareInstrument(hardwareInstrument);
    }
    void printAllHardwareInstruments(){
        System.out.println("How to read the information: Hardware Instrument, Code, Maintenance, measurementType, Price");
        for(HardwareInstrument p : softwareHardwareInstrumentService.getAllHardwareInstruments()){
            System.out.println(p.toString()+","+p.getPrice());
        }
    }
}
