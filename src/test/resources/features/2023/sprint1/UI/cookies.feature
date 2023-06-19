#1.Create WebDriver instance.
#2.Login into the Application.
#3.Read the cookie information using
# 4. driver.manage().getCookies();
#Store the cookie information using FileWriter Class to write streams of characters and BufferedWriter
# to write the text into a file to create into a file Cookies.data.


  #When Testing a web application using selenium web driver, you may need to create, update or delete a cookie.
  #
  #For example, when automating Online Shopping Application, you many need to automate test scenarios like place order,
  # View Cart, Payment Information, order confirmation, etc.
  #
  #If cookies are not stored, you will need to perform login action every time before you execute above listed test scenarios.
  # This will increase your coding effort and execution time.

  #Create an empty array to store the results.
  #
  #Iterate through each integer in the input array.
  #
  #Check if the current integer is a power of 2 by using the bitwise AND operation. A number that is a power of 2 has only one bit set to 1. Therefore, if we perform a bitwise AND operation between the number and its predecessor (number - 1), the result will be 0.
  #
  #If the result of the bitwise AND operation is 0, append 1 to the result array; otherwise, append 0.
  #
  #Return the result array.
  #Not sure if this is correct answer, but maybe try
  #AE — Today at 1:35 PM
  #public static int[] powersOfTwoArray(int n)
  #{
  #    int[] result = new int[n+1];  // use "n+1" otherwise it will throw exception
  #    int i = 0;
  #    int power = 1;   // initiate power = 1, not power = 0;
  #    while (i <= n)
  #    {
  #        result[i] = power;
  #        power *= 2;
  #        i++;        // increments "i" otherwise its an infinite loop
  #    }
  #    return result;
  #}

  #public static void main(String[] args) {
  #        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,16));
  #
  #
  #        System.out.println("powerOfTwoArrayList1(list) = " + powerOfTwoArrayList1(list));
  #        //powerOfTwoArrayList1(list) = [1, 2, 4, 8, 16]
  #
  #        System.out.println("isPowerOfTwo(8) = " + isPowerOfTwo(8)); //isPowerOfTwo(8) = true
  #        System.out.println("isPowerOfTwo(6) = " + isPowerOfTwo(6));//isPowerOfTwo(6) = false
  #    }
  #
  #    static boolean isPowerOfTwo(int n)
  #    {
  #        if (n == 0)
  #            return false;
  #
  #        while (n != 1) {
  #            if (n % 2 != 0)
  #                return false;
  #            n = n / 2;
  #        }
  #        return true;
  #    }
  #
  #    public static ArrayList<Integer> powerOfTwoArrayList1(ArrayList<Integer> list){
  #
  #            list.removeIf(p -> (isPowerOfTwo(p)) != true);
  #
  #        return list;
  #    }