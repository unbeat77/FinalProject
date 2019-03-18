export class Employee {
    
    public pf :number = 0;
    public ctc : number = 0;
    public title : string = "";
    public comment : string = ""; 
    constructor( public code : string,
        public name: string,
        public gender: string,
        public annualSalary: number,
        public dateOfBirth: string ){

    }
    //ng g class employee
    //ng g service employee
}
