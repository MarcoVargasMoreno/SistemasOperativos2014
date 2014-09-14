#include <sys/types.h>
#include <wait.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <iostream>

int main(int argc, char **argv)
{
char nombre[100];
	printf("imprima su nombre \n");
	scanf("%s",nombre);

pid_t idproceso1;
pid_t idproceso2;
int variable=1;
int estadohijo;
int max=30;
int n=15;
int i;

for (i=1;i<=max;i+n){

	idproceso1=fork();
	if(idproceso1==-1){
		perror("No se puede crear proceso \n");
		exit(-1);
	}
	if(idproceso1==0){
		printf("soy el hijo y mi pid es: %d \t",getpid());
		sleep(15);
		exit(33);
	}
	if(idproceso1>0){
			printf("soy el padre mi pid es: %d \t",getpid());
			wait(&estadohijo);
			if(WIFEXITED(estadohijo)!=0){
					printf("mi hijo a salido. Devuelve %d \n",WEXITSTATUS(estadohijo));
			}
			printf("soy el padre = %d \n",variable);
	}
}


idproceso2=fork();
	if(idproceso2==-1){
		perror("No se puede crear proceso \n");
		exit(-1);
	}
	if(idproceso2==0){
		printf("soy el hijo2 y el pid de mi proceso es: %d \t",getpid());
			printf("el nombre que usted digito fue: %s \t",nombre);
		sleep(2);
		exit(33);
	}
	if(idproceso2>0){
			//printf("soy el padre mi pid es: %d \t",getpid());
			wait(&estadohijo);
			if(WIFEXITED(estadohijo)!=0){
					printf("mi hijo a salido. Devuelve %d \n",WEXITSTATUS(estadohijo));
			}
			//printf("%d \n",variable);
	}

	

	return 0;
}

