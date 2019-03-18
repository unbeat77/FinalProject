export class Orders {
  checked: boolean;
  code: any;
    constructor(
        public oid : number,
        public cid: number,
        public foodId: number,
        public foodQty: number,
        public oreason: string,
        public ototPrice: number,
        public oestTime: string,
        public otime: string,
        public odate: Date,
        public vid: number,
        public ostatus: string) {
      }
}
