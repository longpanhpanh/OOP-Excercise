package Ex09;

import java.util.ArrayList;
import java.util.List;

public class ElectricManager {

    public double getElectricFee(Customer customer) {
        return (customer.getBill().getNewPoint() - customer.getBill().getOldPoint()) * 5;
    }

}
