package com.crio.codingame.commands;

import java.util.List;

import com.crio.codingame.dtos.UserRegistrationDto;
import com.crio.codingame.exceptions.ContestNotFoundException;
import com.crio.codingame.exceptions.InvalidOperationException;
import com.crio.codingame.exceptions.UserNotFoundException;
import com.crio.codingame.services.IUserService;

public class AttendContestCommand implements ICommand{

    private final IUserService userService;
    
    public AttendContestCommand(IUserService userService) {
        this.userService = userService;
    }

    // TODO: CRIO_TASK_MODULE_CONTROLLER
    // Execute attendContest method of IUserService and print the result.
    // Also Handle Exceptions and print the error messsages if any.
    // Look for the unit tests to see the expected output.
    // Sample Input Token List:- ["ATTEND_CONTEST","3","Joey"]
    // Hint - Use Parameterized Exceptions in the Service class to match with the Unit Tests Output.

    @Override
    public void execute(List<String> tokens) {
        try{
            String contestId=tokens.get(1);
            String userName=tokens.get(2);
            UserRegistrationDto user=userService.attendContest(contestId, userName);
            System.out.println(user);
        }catch(UserNotFoundException e){
            System.out.println("Cannot Attend Contest. User for given name:"+ tokens.get(2)+" not found!");
            
        }catch(ContestNotFoundException e){
            System.out.println("Cannot Attend Contest. Contest for given id:"+tokens.get(1)+" not found!");
        }
        catch(InvalidOperationException e){
            System.out.println(e.getMessage());
            
        }
    }
    
}
