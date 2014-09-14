
#include <iostream>
#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>

int main(int argc, char **argv)
{
	pid_t pid;
	pid=fork();
		if(pid==-1){
				printf("Fallo en fork\n");
				return -1;
		}
		else if (!pid){
			printf("Proceso Hijo: PID %d \n",getpid());
			
		}
		else{
			printf("Proceso Padre: PID %d \n",getpid());
		}
	
	return 0;
}

