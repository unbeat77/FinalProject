export class Menu {

    isSelected: boolean = false;
    qty: number = 0;
    tPrice: number = 0;
    vegOnly: boolean = false;
    constructor(
        public foodId: number,
        public venId: number,
        public foodName: String,
        public foodCategory: String,
        public foodPrice: number,
        public foodDescription: String) { }
}
