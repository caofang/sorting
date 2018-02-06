#include <iostream>
using namespace std;

int factorial(unsigned int n)
{
    cout << "Computing factorial of " << n << "\n";

    int result;
    if (n == 0) {
        result = 1;
    } else {
        result = n * factorial(n-1);
    }

    cout << "factorial(" << n << ") = " << result << "\n";
    return result;
}

int main()
{
    factorial(5);
}