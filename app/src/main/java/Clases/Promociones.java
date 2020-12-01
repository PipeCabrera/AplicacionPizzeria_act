package Clases;

public class Promociones {
    private int Pizzaspromo;
    private int Masterpizza;
    private int Pizzamax;

    public Promociones()
    {
        Pizzaspromo = 5990;
        Masterpizza = 12990;
        Pizzamax = 18500;

    }

    public int getPizzaspromo() {
        return Pizzaspromo;
    }

    public void setPizzaspromo(int pizzaspromo) {
        Pizzaspromo = pizzaspromo;
    }

    public int getMasterpizza() {
        return Masterpizza;
    }

    public void setMasterpizza(int masterpizza) {
        Masterpizza = masterpizza;
    }

    public int getPizzamax() {
        return Pizzamax;
    }

    public void setPizzamax(int pizzamax) {
        Pizzamax = pizzamax;
    }

}
