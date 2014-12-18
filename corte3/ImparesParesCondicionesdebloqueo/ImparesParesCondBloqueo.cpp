#include <iostream>
#include <sys/types.h>
#include <stdio.h>
#include <fstream>
#include <unistd.h>
#include <conio.h>
using namespace std;

int main () {
    ofstream f;
    pid_t pid;
	int par,impar;
	par=0;
	impar=1;
		pid=fork();
		 if(pid==-1){
				printf("Fallo en fork\n");
				return -1;
		}
		else if (!pid){
			f.open("/home/marco/SistemasOperativos/Talleres/ImparesParesCondicionesdebloqueo/ImparesPares.txt", ios::app);
					if(!f)
					cout << "Error abriendo el fichero" << endl;
					 else{
							while (par<20){
								par=par+1;
									if(par %2 ==0){
										f << par << endl;
									}
							}
					  f.close();
					 }
		}
		else{
					f.open("/home/marco/SistemasOperativos/Talleres/ImparesParesCondicionesdebloqueo/ImparesPares.txt", ios::app);
					if(!f)
					cout << "Error abriendo el fichero" << endl;
					 else{
							while (impar<20){
								impar=impar+2;
									f << impar << endl;
							}
					  f.close();
					 }
		}
				
return 0;
}

