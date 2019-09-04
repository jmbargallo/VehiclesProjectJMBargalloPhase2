package vehicles;

import vehicles.Car;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        /*#######################################################
            Input Data
        #######################################################*/
        Map<String, String> carInputs = new HashMap<>();


        System.out.println("Introduce los datos del vehiculo: ");
        System.out.print("Matricula: ");
        String matricula;
        matricula = in.nextLine();
        int valido=1;

        if (matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")
                || matricula.toUpperCase().matches("^[0-9]{4}[A-Z]{2}$")) {

            System.out.println("Matrícula válida");
            valido=1;

        } else {

            System.out.println("Matrícula inválida");
            valido=0;


        }


        carInputs.put("Plate", matricula);
        System.out.println("Marca: ");
        carInputs.put("Brand", in.nextLine());

        System.out.println("Color: ");
        carInputs.put("Color", in.nextLine());

        //Create a car

        Vehicle car = new Car(carInputs.get("Plate"), carInputs.get("Brand"), carInputs.get("Color"));

        if (valido==0) {
            System.out.println("No puedo crear un coche valido" +
                    " sin una matricula correcta");
        }
        /*#######################################################
            Add wheels
        #######################################################*/
        List<Wheel> carFrontWheels = new ArrayList<>();
        List<Wheel> carBackWheels = new ArrayList<>();
        Map<String, String> mapWheelsBrands = new HashMap<>();
        Map<String, Double> mapWheelsDiameters = new HashMap<>();

        //Front Wheels
        System.out.print("Marca ruedas delanteras: ");
        mapWheelsBrands.put("FrontWheelBrand", in.nextLine());
        System.out.print("Diámetro ruedas delanteras: ");
        double diametro1=Double.parseDouble(in.nextLine());
        if (diametro1<0.4 || diametro1>4){
            System.out.println("Diametro no valido");
        }
        mapWheelsDiameters.put("FrontWheelDiameter", diametro1);

        carFrontWheels.add(new Wheel(mapWheelsBrands.get("FrontWheelBrand"), mapWheelsDiameters.get("FrontWheelDiameter")));
        carFrontWheels.add(new Wheel(mapWheelsBrands.get("FrontWheelBrand"), mapWheelsDiameters.get("FrontWheelDiameter")));

        //Back Wheels
        System.out.print("Marca ruedas traseras: ");
        mapWheelsBrands.put("BackWheelBrand", in.nextLine());
        System.out.print("Diámetro ruedas traseras: ");
        double diametro2=Double.parseDouble(in.nextLine());
        if (diametro2<0.4 || diametro2>4){
            System.out.println("Diametro no valido");

        }
        mapWheelsDiameters.put("BackWheelDiameter", diametro2);

        carBackWheels.add(new Wheel(mapWheelsBrands.get("BackWheelBrand"), mapWheelsDiameters.get("BackWheelDiameter")));
        carBackWheels.add(new Wheel(mapWheelsBrands.get("BackWheelBrand"), mapWheelsDiameters.get("BackWheelDiameter")));

        try {
            ((Car) car).addWheels(carFrontWheels, carBackWheels);
        } catch (Exception e) {
            System.out.println("Error en los datos de las ruedas");
        }


        /*#######################################################
            Results
        #######################################################*/
        System.out.println();
        System.out.println("Los datos del coche son:");
        System.out.println();
        System.out.println("Marca:  " + car.brand);
        System.out.println("Matricula: " + car.plate);
        if (car.plate.toUpperCase().matches("^[0-9]{4}[A-Z]{3}$")
                || car.plate.toUpperCase().matches("^[0-9]{4}[A-Z]{2}$")) {

            System.out.println("Matrícula válida");


        } else {

            System.out.println("Esta matricula te la has inventado listillo");
        }
        System.out.println("Color: " + car.color);
        System.out.println();
        System.out.println("Ruedas");
        System.out.println();
        List<Wheel> carWheelsResult = car.wheels;
        int contador=0;

        for (Wheel c : carWheelsResult)
        {
            contador++;
            System.out.println("Rueda "+ contador+" Marca "+c.getBrand()+" diametro "+c.getDiameter() );
            if (c.getDiameter()>4||c.getDiameter()<0.4){
                System.out.println("el diametro  es chungo");
            }
        }
        if (valido==0){
            System.out.println();
            System.out.println("Este coche es mas falso que un euro de carton");
        }
    }
}
