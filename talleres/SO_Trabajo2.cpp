#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>


int main (){
pid_t pid;
pid=fork();
	if(pid==-1){
	   printf( "Error al crear proceso hijo \n");
	exit(0);
	}
	if(pid){
	printf("Soy el Padre, y el PID de mi hijo es: %d\n",pid);
	}
	else{
	printf("Hola Mundo");
	}
	return 0;
}
