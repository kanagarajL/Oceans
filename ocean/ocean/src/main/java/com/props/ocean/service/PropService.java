package com.props.ocean.service;

import com.props.ocean.model.Prop;
import com.props.ocean.repository.PropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropService {

    @Autowired
    private PropRepository repo;

    public Prop init(Prop p){
       return  repo.save(p);
    }

    public Prop getCurrentPosition(String command) {
        command = command.toUpperCase();

        List<Prop> propList = repo.findAll();
        String direction = propList.get(0).getDirection();
        Integer x =  propList.get(0).getX();
        Integer y =  propList.get(0).getY();

        switch (command){

            case "MOVE_FORWARD" ->{
                if(direction.equals("NORTH"))   y++;
                else if (direction.equals("SOUTH")) y--;
                else if (direction.equals("EAST")) x++;
                else if (direction.equals("WEST")) x--;
            }
            case "MOVE_BACKWORD" -> {
                if(direction.equals("NORTH"))   y--;
                else if (direction.equals("SOUTH")) y++;
                else if (direction.equals("EAST")) x--;
                else if (direction.equals("WEST")) x++;
            }
            case "TURN_LEFT" -> {
               direction = trunLeft(direction);
            }
            case "TRUN_RIGHT" -> {
                direction = trunRight(direction);
            }
            case "STAY" -> {

            }

            default -> {
                System.out.println("Invalid direction");
            }
        }

        Prop result = new Prop();
        result.setY(y);
        result.setX(x);
        result.setDirection(direction);

        return result;


    }

    private String trunRight(String direction) {

        switch (direction){
            case "NORTH": return "EAST";
            case "EAST": return "SOUTH";
            case "SOUTH": return "WEST";
            case "WEST": return "NORTH";
            default:
                return direction;
        }
    }

    private String trunLeft(String direction) {
        switch (direction){
            case "NORTH": return "WEST";
            case "WEST": return "SOUTH";
            case "SOUTH": return "EAST";
            case "EAST": return "NORTH";
            default:
                return direction;

        }
    }

    public String getStatus() {

       Prop ps =  repo.findAll().get(0);
       return "current position : (" + ps.getX() + "," + ps.getY() +") direction is "+ ps.getDirection();
    }
}
