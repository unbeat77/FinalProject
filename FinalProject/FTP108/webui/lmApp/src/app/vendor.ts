export class Vendor {
  emit(myvendor: Vendor): any {
    throw new Error("Method not implemented.");
  }
    constructor(public vid : number, 
        public vname : string,
        public vusername : string,
        public vpass : string ,
        public vemail : string,
        public vphone : string ,
        public vaddress : string) {
            
        }
}
