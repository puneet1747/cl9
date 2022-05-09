import mpi.MPI;
import java.io.*;
import java.util.Scanner;

public class ScatterGather {

public static int isPrime(int x)
{
    if(x % 2 == 0)
        return 0;

    for(int i = 3; i < x; i=i+2)
    {
        if(x % i == 0)
            return 0;
    }
    return 1;
}

public static int n = 16;

    public static void main(String args[]){

        
    int count = 0, k = 0;
//Initialize MPI execution environment
    MPI.Init(args);
//Get the id of the process
    int rank = MPI.COMM_WORLD.Rank();
//total number of processes is stored in size
    int size = MPI.COMM_WORLD.Size();
    int root=0;
//array which will be filled with data by root process
    int sendbuf[]=null;

    sendbuf= new int[size];

    if(rank==root){

        sendbuf[0] = 0;
        sendbuf[1] = 0;
        sendbuf[2] = 0;
        sendbuf[3] = 0;

    //print current process number
        System.out.print("In process 0, Processor "+rank+" has data: ");
        for(int i = 0; i < size; i++){
            System.out.print(sendbuf[i]+" ");
        }
        System.out.println();
    }

    int recvbuf[] = new int[1];
    int primeno[] = new int[size];

	MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.INT, recvbuf, 0, 1, MPI.INT, root);

    for(int i = n * rank/size; i < n * (rank + 1) / size; i++)
            if(isPrime(i) == 1)
            {
                count++;
                primeno[k++] = i;
            }    

    recvbuf[0] = count;
	
	System.out.println("Processor "+rank+" has data: "+recvbuf[0]);
    for(int i=0;i<k;i++)
    {
        System.out.print(primeno[i]+ " ");
    }
    System.out.println();

	MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.INT, sendbuf, 0, 1, MPI.INT, root);
	//display the gathered result
    if(rank==root){
        count = 0;
       System.out.println("Process 0 has data: ");
       for(int i=0;i<4;i++)
	   {
			System.out.print(sendbuf[i]+ " ");
            count += sendbuf[i];
		}

        System.out.print("\nTotal number of prime numbers: " + count);
    }

	MPI.Finalize();
}
}

/*
 ~/Desktop/be_43220/cl9/MPI   master ±  export MPJ_HOME=/home/puneet/Desktop/be_43220/cl9/MPI/mpj-v0_44
 ~/Desktop/be_43220/cl9/MPI   master ±  javac -cp $MPJ_HOME/lib/mpj.jar ScatterGather.java             
 ~/Desktop/be_43220/cl9/MPI   master ±  $MPJ_HOME/bin/mpjrun.sh -np 4 ScatterGather

MPJ Express (0.44) is started in the multicore configuration
In process 0, Processor 0 has data: 0 0 0 0 
Processor 1 has data: 2
5 7 
Processor 0 has data: 2
1 3 
Processor 3 has data: 1
13 
Processor 2 has data: 1
11 
Process 0 has data: 
2 2 1 1 
Total number of prime numbers: 6
 ~/Desktop/be_43220/cl9/MPI   master ±  
*/
