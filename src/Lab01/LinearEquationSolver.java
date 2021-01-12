package Lab01;
/*
* Testcase
* quotient = 0
* known result (3x-y=7,2x+3y=1 => 2,-1)
* */
public class LinearEquationSolver {
    public static void main(String[] args) {
        //ax+by=e, cx+dy=f
        double a=3.4,b=50.2,c=2.1,d=0.55,e=44.5,f=5.9;

        double quotient = a*d-b*c;
        if(quotient == 0){
            System.out.println("No Real Solution");
        }
        else{
            double x = (e*d-b*f)/quotient;
            double y = (a*f-e*c)/quotient;

            System.out.printf("x=%f y=%f\n",x,y);
        }

    }
}
