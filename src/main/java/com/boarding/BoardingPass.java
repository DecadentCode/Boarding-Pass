package com.boarding;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class BoardingPass {

    private Flight flight;
    private User user;

    public BoardingPass() {}

    public BoardingPass(Flight flight, User user) {
        this.flight = flight;
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void serialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        try {
            String boardingPass = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
            FileWriter file = new FileWriter("target/boarding_pass.json");
            BufferedWriter out = new BufferedWriter(file);
            out.write(boardingPass);
            out.close();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IOException occurred during serialization!\n");
        }

    }
}
