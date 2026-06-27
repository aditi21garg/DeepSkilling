public class FinancialForecaster {
    public static double predictFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return predictFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialInvestment = 1000.0; 
        double annualGrowthRate = 0.05;    
        int targetYears = 5;               
        
        double forecastedValue = predictFutureValue(initialInvestment, annualGrowthRate, targetYears);
        
        System.out.println("Forecasted Value after " + targetYears + " years: " + forecastedValue);
    }
}
