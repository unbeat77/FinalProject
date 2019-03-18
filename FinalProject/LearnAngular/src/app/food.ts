export class Food {

    constructor(public fName:string, public fCalories:number, public fVegan?:string){

    }
    public displayAll(){
        console.log("food\t" + this.fName
        + "Cal\t" + this.fCalories
        + "Vegan\t" + this.fVegan);
    }
}
