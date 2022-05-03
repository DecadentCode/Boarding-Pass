import com.boarding.Flight;
import com.boarding.Gender;
import com.boarding.User;
import org.junit.jupiter.api.Assertions;

import java.time.LocalTime;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    //User Class tests
    @org.junit.jupiter.api.Test
    void constructor() {
        User user = new User("Joe Jackson", "jj@gmail.com", "(111) 222-3333", Gender.Male);
        assertEquals("Joe Jackson", user.getName(), "User Name test");
        assertEquals("jj@gmail.com", user.getEmail(), "User Email test");
        assertEquals("(111) 222-3333", user.getPhoneNumber(), "User pone number test");
        assertEquals(Gender.Male, user.getGender(), "User Gender test");
    }
    void getUser() {
        User user = new User("Joe Jackson", "jj@gmail.com", "(111) 222-3333", Gender.Male);
        user.setName("Test User");
        assertEquals("Test User", user.getName(), "User Name test");
    }

    @org.junit.jupiter.api.Test
    void getEmail() {
        User user = new User("Joe Jackson", "jj@gmail.com", "(111) 222-3333", Gender.Male);
        user.setEmail("Foo@Bar.com");
        assertEquals("Foo@Bar.com", user.getEmail(), "User Email test");
    }
    @org.junit.jupiter.api.Test
    void getPhoneNumber() {
        User user = new User("Joe Jackson", "jj@gmail.com", "(111) 222-3333", Gender.Male);
        user.setPhoneNumber("(123) 456-7890");
        assertEquals("(123) 456-7890", user.getPhoneNumber(), "User pone number test");
    }
    @org.junit.jupiter.api.Test
    void getGender() {
        User user = new User("Joe Jackson", "jj@gmail.com", "(111) 222-3333", Gender.Male);
        user.setGender(Gender.Female);
        assertEquals(Gender.Female, user.getGender(), "User Gender test");
    }
    // Flight Class Tests
    @org.junit.jupiter.api.Test
//    TODO: FIX THIS
    void getDate() {
        Flight flight = new Flight();
//        flight.setDate("1/2/2022");
        assertEquals("1/2/2022", flight.getDate(), "Flight date test");
    }
    @org.junit.jupiter.api.Test
    void getOrigin() {
        Flight flight = new Flight();
        flight.setOrigin("Dulles International Airport");
        assertEquals("Dulles International Airport", flight.getOrigin(), "Flight origin test");
    }
    @org.junit.jupiter.api.Test
    void getDestination() {
        Flight flight = new Flight();
        flight.setDestination("O'Hare International Airport");
        assertEquals("O'Hare International Airport", flight.getDestination(), "Flight destination test");
    }
    @org.junit.jupiter.api.Test
    void getETA() {
        Flight flight = new Flight();
        flight.setETA(LocalTime.of(12, 45)); //TODO: Convert this to use LocalTime
        assertEquals(LocalTime.of(12, 45), flight.getETA(), "Flight ETA test");
    }
    @org.junit.jupiter.api.Test
    void getDT() {
        Flight flight = new Flight();
        flight.setDT(LocalTime.of(12,45)); //TODO: Convert this to use LocalTime
        assertEquals(LocalTime.of(12,45), flight.getDT(), "Flight DT test");
    }

}