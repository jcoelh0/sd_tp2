/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shared.Repository;

import entities.Customer.States.CustomerState;
import entities.Manager.States.ManagerState;
import entities.Mechanic.States.MechanicState;
import java.io.PrintWriter;

/**
 *
 * @author Andre
 */
public class Repository {
    
    private final String file_name = "log.txt";
    
    public PrintWriter writer;
    
    private ManagerState managerState;
    
    private CustomerState[] customerState;
    
    private MechanicState[] mechanicState;
    
}
