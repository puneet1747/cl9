import java.util.Scanner;
public class Ring {
	public static void main(String[] args) {
		int temp,i,j;
		Rr proc[] = new Rr[10];
		for(i=0;i<proc.length;i++) {
			proc[i] = new Rr();
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of process : ");
		int num = sc.nextInt();
		for(i=0;i < num;i++) {
			proc[i].index = i;
			System.out.println("Enter the id of process : ");
			proc[i].id = sc.nextInt();
			proc[i].state = "active";
			proc[i].f = 0;
		}
		for( i=0;i<num-1;i++) {
			for( j=0;j<num-1;j++) {
				if(proc[j].id > proc[j+1].id) {
					temp = proc[j].id;
					proc[j].id = proc[j+1].id;
					proc[j+1].id = temp;
				}
			}
		}
		for(i=0;i<num;i++) {
			System.out.println(" ["+i+"]"+" "+proc[i].id);
		}
		int init;
		int ch;
		int temp1;
		int temp2;
		int ch1;
		int arr[] = new int[10];
		proc[num-1].state = "inactive";
		System.out.println("\nProcess "+ proc[num-1].id+" selected as coordinator");
		while(true) {
			System.out.println("\n1. election\n2. Quit");
			ch = sc.nextInt();
			for( i=0;i<num;i++) {
				proc[i].f = 0;
			}
			switch(ch) {
			case 1:
				System.out.println("\nEnter the process number who initiated election : ");
				init = sc.nextInt();
				temp2 = init;
				temp1 = init+1;
				i=0;
				while(temp2 != temp1) {
					if("active".equals(proc[temp1].state) && proc[temp1].f == 0) {
						System.out.println("\nProcess "+ proc[init].id+ " send message to "+ proc[temp1].id);
						proc[temp1].f = 1;
						init = temp1;
						arr[i] = proc[temp1].id;
						i++;
					}
					if(temp1 == num) {
						temp1 = 0;
					}
					else {
						temp1++;
					}
				}
				System.out.println("\nProcess "+ proc[init].id + " send message to "+ proc[temp1].id);
				arr[i] = proc[temp1].id;
				i++;
				int max = -1;
				for(j=0;j<i;j++) {
					if(max < arr[j]) {
						max = arr[j];
					}
				}
				System.out.println("\n Process "+max+" selected as coordinator");
				for(i=0;i<num;i++) {
					if(proc[i].id == max) {
						proc[i].state = "inactive";
					}
				}
				break;
			case 2:
				System.out.println("Program terminated...");
				return;
			default:
				System.out.println("\n Invalid response\n");
				break;
			}
		}
	}
}
class Rr {
	public int index;
	public int id;
	public int f;
	String state;
}


/*
import java.util.Scanner;

class Process {
    public int id;
    public boolean active;

    public Process(int id) {
        this.id = id;
        active = true;
    }

}

public class Ring {
    int noOfProcesses;
    Process[] processes;
    Scanner sc;

    public Ring() {
        sc = new Scanner(System.in);
    }

    public void initialiseRing() {
        System.out.println("Enter no of processes");
        noOfProcesses = sc.nextInt();
        processes = new Process[noOfProcesses];
        for (int i = 0; i < processes.length; i++) {
            processes[i] = new Process(i);
        }
    }

    public int getMax() {
        int maxId = -99;
        int maxIdIndex = 0;
        for (int i = 0; i < processes.length; i++) {
            if (processes[i].active && processes[i].id > maxId) {
                maxId = processes[i].id;
                maxIdIndex = i;

            }
        }
        return maxIdIndex;
    }

    public void performElection() {

        System.out.println("Process no " + processes[getMax()].id + " fails");
        processes[getMax()].active = false;
        System.out.println("Election Initiated by");
        int initiatorProcesss = sc.nextInt();

        int prev = initiatorProcesss;
        int next = prev + 1;

        while (true) {
            if (processes[next].active) {
                System.out.println("Process " + processes[prev].id + " pass Election(" + processes[prev].id + ") to"
                        + processes[next].id);
                prev = next;
            }

            next = (next + 1) % noOfProcesses;
            if (next == initiatorProcesss) {
                break;
            }
        }

        System.out.println("Process " + processes[getMax()].id + " becomes coordinator");
        int coordinator = processes[getMax()].id;

        prev = coordinator;
        next = (prev + 1) % noOfProcesses;

        while (true) {

            if (processes[next].active) {
                System.out.println("Process " + processes[prev].id + " pass Coordinator(" + coordinator
                        + ") message to process " + processes[next].id);
                prev = next;
            }
            next = (next + 1) % noOfProcesses;
            if (next == coordinator) {
                System.out.println("End Of Election ");
                break;
            }
        }

    }

    public static void main(String arg[]) {
        Ring r = new Ring();
        r.initialiseRing();
        r.performElection();
    }

}
*/
