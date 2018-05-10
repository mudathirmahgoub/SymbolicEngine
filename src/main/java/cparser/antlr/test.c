int function_to_test(int x, int y) {
	/*Suppose inputs x and y are set to have symbolic values */

	int k = x - y;
	int t = x + y + 3;
	if(x % 2 == 0) /* check whether x is even; remainder is 0 when x is divisible by 2 */
	{
		x = y + 1;
		++y; /* Increment y value by 1 */
		if(t > 0){
			k = t - 2;
		}
	}
	if(x+6 > k) {
		y = 5;
	}
	if(t+x+y == 20){ /* Check whether t+x+y is equal to 20*/
		assert(0); /* Bug */
	}

	int z = (t + x + y) / x;
	return z;
}
