package Chapter04;
public class TwoDimensional
{
    public static void main(String[] args) {
        //Demo for Creating two Dimensional Array for Storing Students ID and name.
        //⽤于创建⼆维数组以存储学⽣ ID 和姓名的⽰例。
        String [][] a=new String[2][2]; //First Approach For Creating Array
        //Second Approach For Creating Array
        //第⼆种创建数组的⽅法
        String [][] b={{"101","John"},{"102","Smith"}};
        //Store Friend's name in the array you created.
        //将朋友的姓名存储在你创建的数组中。
        a[0][0]="101";
        a[0][1]="John";
        a[1][0]="102";
        a[1][1]="Smith";
        //Accessing Array Elements..arrayname[row][column]
        //访问数组元素..arrayname[row][column]
        System.out.println("Student ID: "+a[0][0]+" Name: "+a[0][1]);
        //Accessing array elements using for loop and length of array.
        //使⽤ for 循环和数组⻓度访问数组元素。
        // First loop for accesing two dimesional array row.
        //第⼀个循环⽤于访问⼆维数组的⾏。
        for(int i=0;i<a.length;i++){
            // Second loop for accessing two dimensional array column.
            //第⼆个循环⽤于访问⼆维数组的列。
            for(int j=0;j<a[i].length;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        //Accessing array using for each loop
        //使⽤ foreach 循环访问数组
        // First for loop for storing the elements in each row.
        //第⼀个 for 循环⽤于存储每⾏的元素。
        for(String[] x:a){
            // Second loop to access the elements in each row.
            // 第⼆个循环⽤于访问每⼀⾏中的元素。
            for(String y:x){
                System.out.print(y+" ");
            }
            System.out.println();
        }
    }
}