package oop;
class PrintPrint {
    static void printSeries(int ... args) {
        int start = 0;
        int end = args[0];
        int step = 1;
        if(args.length >= 2) {
            start = args[0];
            end = args[1];
        }
        if (args.length == 3) {
            step = args[2];
        }
        for (int i = start; i <= end; i += step) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}


	public class test_01 {
	    public static void main(String[] args) {

	        // NOT OVERLOADING
	        PrintPrint.printSeries(5);
	        PrintPrint.printSeries(5, 10);
	        PrintPrint.printSeries(5, 15, 3);

	    }
	}


