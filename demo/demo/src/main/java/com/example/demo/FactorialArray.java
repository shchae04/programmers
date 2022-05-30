package com.example.demo;


public class FactorialArray
{
    // FactorialArray constructor
    public static void main(String[] args) {
        FactorialArray f = new FactorialArray(30);
        System.out.println("팩토리얼 보여줘!" + f.getProductAsString());
    }
    public FactorialArray(int number)
    {
        index = 0;
        product[index] = 1; // Initializes the first digit as 1

        // The remaining numbers in the array are initialized as -1
        for (int i = 1; i < product.length; i++) product[i] = -1;

        // Calculates the factorial by muliplying by 2, 3 ... number
        for (int n = 2; n <= number; n++) multiply(n);
    }

    // Returns the contents of the array formatted as a String, excluding all indices containing -1
    public String getProductAsString()
    {
        String productString = "";

        // Prints in reverse order because the greatest digit is the last in the array
        for (int i = index; i >= 0; i--) productString += product[i];

        return productString;
    }

    private int index; // Keeps track of the index of the end digit of the product
    private int[] product = new int[100000]; // The product array can be up to 100000 digits long (essentially arbitrarily large)

    // Multiplies each digit in the array by the supplied multiplier
    private void multiply(int multiplier)
    {
        for (int i = 0; i <= index; i++) product[i] *= multiplier;
        carry(); // Any digit that is 10 or over must be carried
    }

    // Performs a carry on the digits that have exceeded 9
    private void carry()
    {
        for (int i = 0; i <= index; i++)
        {
            if (product[i] > 9)
            {
                // Checks if the next value in the array does not contain a valid digit
                if (product[i + 1] == -1)
                {
                    // Increases the index and stores the new value as 0
                    product[++index] = 0;
                }

                // Performs the carry using modulus division
                product[i + 1] += (product[i] / 10);
                product[i] %= 10;
            }
        }
    }
}