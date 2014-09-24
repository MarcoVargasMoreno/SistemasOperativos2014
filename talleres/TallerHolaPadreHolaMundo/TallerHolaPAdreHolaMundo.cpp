#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main (){
pid_t pid;
pid=fork();

	
		if(pid==-1){
		   printf( "error \n");
		exit(0);
		}
		if(pid==0){
		printf("Hola padre \n");
		
		}
		else{
			printf("\n Hola Mundo");
		

	}		
return 0;
}
