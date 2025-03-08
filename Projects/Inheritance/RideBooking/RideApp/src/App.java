class Vehicle {
    String model;
    int maxSpeed;
    int wheels;

    public void showDetails() {
        System.out.println("Model: " + this.model);
        System.out.println("Max Speed: " + this.maxSpeed + " km/hr");
        System.out.println("Wheels: " + this.wheels);
    }

    Vehicle(String model, int maxSpeed, int wheels) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.wheels = wheels;
    }
}

class Car extends Vehicle {
    String fuelType;

    Car(String model, int maxSpeed, int wheels, String fuelType) {
        super(model, maxSpeed, wheels);
        this.fuelType = fuelType;
    }

    public void showDetails() {
        System.out.println("🚗 Car Details:");
        super.showDetails();
        System.out.println("Fuel Type: " + this.fuelType);
    }
}

class Bike extends Vehicle {
    int gears;

    Bike(String model, int maxSpeed, int wheels, int gears) {
        super(model, maxSpeed, wheels);
        this.gears = gears;
    }

    public void showDetails() {
        System.out.println("🏍️ Bike Details:");
        super.showDetails();
        System.out.println("No of Gears: " + this.gears);
    }
}

class User {
    String name;
    String phoneNumber;

    User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void showUserDetails() {
        System.out.println("👤 User Details:");
        System.out.println("Name: " + this.name);
        System.out.println("Contact Number: " + this.phoneNumber);
    }

    public void bookRide(Vehicle vehicle) {
        System.out.println(this.name + " has booked a ride with a " + vehicle.model);
    }
}

class Rider extends User {
    String numberPlate;

    Rider(String name, String phoneNumber, String numberPlate) {
        super(name, phoneNumber);
        this.numberPlate = numberPlate;
    }

    @Override
    public void bookRide(Vehicle vehicle) {
        System.out.println("🚖 Driver " + this.name + " with registered number plate " + this.numberPlate + " is assigned to " + vehicle.model);
    }
}

class Ride {
    User customer;
    Vehicle vehicle;
    Rider rider;

    Ride(User customer, Vehicle vehicle, Rider rider) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rider = rider;
    }

    public void startRide() {
        System.out.println("✅ Ride Started!");
        System.out.println(customer.name + " is traveling in " + vehicle.model + " with driver " + rider.name);
    }

    public void endRide() {
        System.out.println("🛑 Ride Ended! " + customer.name + " has completed the trip.");
    }
}

public class App {
    public static void main(String[] args) {
        // Creating vehicles
        Car car1 = new Car("Tesla Model 3", 200, 4, "Electric");
        Bike bike1 = new Bike("Yamaha R15", 150, 2, 6);

        // Creating users
        User customer1 = new User("Ramesh", "9876543210");
        Rider rider1 = new Rider("Rajesh", "9123456789", "KA-01-AB-1234");

        // Displaying details
        car1.showDetails();
        bike1.showDetails();
        customer1.showUserDetails();
        rider1.showUserDetails();

        // Booking rides
        customer1.bookRide(car1);
        rider1.bookRide(car1);

        // Start and End ride
        Ride ride1 = new Ride(customer1, car1, rider1);
        ride1.startRide();
        ride1.endRide();
    }
}
