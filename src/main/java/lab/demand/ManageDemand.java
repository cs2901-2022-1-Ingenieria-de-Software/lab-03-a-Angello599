package lab.demand;

import java.util.List;

public class ManageDemand {

    private Tax tax;

    public ManageDemand(Tax tax) {
        this.tax = tax;
    }

    public double calculateTotal(List<Order> orders){
        // Calculate Taxes and Total
        double taxes = 0.0;
        double quantities = 0.0;
        for (Order order : orders) {
            taxes += this.tax.calculateTax(order.getCountry());
            quantities += order.getQuantity();
        }

        return quantities * taxes;
    }

    public double calculateTotalForWithAdditionalByCountry(List<Order> orders, double defaultAdditionalColombia, double defaultAdditionalPeru, double defaultAdditionalBrazil){
        // Calculate additionals by country
        double taxes = 0.0;
        for (Order order : orders) {
            double r = this.tax.calculateTax(order.getCountry());
            if (r == 0.18) {
                taxes += defaultAdditionalPeru;
            } else if (r == 0.12) {
                taxes += defaultAdditionalBrazil;
            } else {
                taxes += defaultAdditionalColombia;
            }

            /*String currCountry = order.getCountry();
            if (currCountry.equals("PE")) {
                taxes += defaultAdditionalPeru;
            } else if (currCountry.equals("BR")) {
                taxes += defaultAdditionalBrazil;
            } else {
                taxes += defaultAdditionalColombia;
            }*/
        }

        // Calculate Total
        double quantities = 0.0;
        for (Order order : orders) {
            double temp = order.getQuantity();
            quantities += temp;
        }

        return quantities * taxes;
    }

}
