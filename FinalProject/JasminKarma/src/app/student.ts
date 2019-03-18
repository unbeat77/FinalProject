export class Student {

    constructor (public stdRegNo : string,
        public stdName : string ){}

        public compute(val : number):number{
            if (val <= 0){ return 0;}
            return val + 1;
        }

        public greet  (msg:string): string{
            return 'Welcome' +msg;
        }
}
