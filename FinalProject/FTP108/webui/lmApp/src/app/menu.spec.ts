import { Menu } from './menu';

describe('Menu', () => {
  it('should create an instance', () => {
    expect(new Menu(1001,501,"CHICKENWINGS","NONVEG",80,"CRISPY DEEP FRIED CHICKEN")).toBeTruthy();
  });
});
