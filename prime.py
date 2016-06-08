import time

start = time.time()
for n in range(2,1000):
	isPrime = True
	for i in range(2,n):
		if n % i == 0:
			isPrime = False


	if isPrime:
		print(n,'is Prime number!!')
end = time.time()
print(end-start)
